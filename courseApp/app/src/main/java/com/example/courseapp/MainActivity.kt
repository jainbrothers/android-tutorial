package com.example.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courseapp.model.DataSource
import com.example.courseapp.model.TopicSummary
import com.example.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplayTopicSummaryGrid()
                }
            }
        }
    }
}

@Composable
fun AutoResizedText(text: String, style: TextStyle, modifier: Modifier) {
    var isDraw by remember {
        mutableStateOf(false)
    }
    var styleWithResizedFontsize by remember {
        mutableStateOf(style.copy(fontSize = style.fontSize ?: TextStyle.Default.fontSize))
    }

    Text(
        text = text,
        style = styleWithResizedFontsize,
        modifier = modifier.drawWithContent {
            if (isDraw) {
                drawContent()
            }
        },
        softWrap = false,
        onTextLayout = {result ->
            if (result.didOverflowWidth) {
                println("Before resize ${styleWithResizedFontsize.fontSize} for text ${text}")
                styleWithResizedFontsize = styleWithResizedFontsize
                    .copy(fontSize = styleWithResizedFontsize.fontSize * 0.9)
                println("After resize ${styleWithResizedFontsize.fontSize} for text ${text}")
            } else {
                isDraw = true
            }
        }
    )
}

@Composable
fun DisplayTopicCard(topicSummary: TopicSummary) {
    Card(elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topicSummary.resourceImageId),
                contentDescription = stringResource(id = topicSummary.resourceNameId),
                modifier = Modifier
                    .size(68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)
            Column  {
                Text(
                    stringResource(id = topicSummary.resourceNameId),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.body2
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )
                    Text(
                        topicSummary.numOfCourses.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayTopicSummaryGrid() {
    val topicSummaryList = DataSource().loadTopicSummary()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(topicSummaryList.size) { index  ->
            DisplayTopicCard(topicSummary = topicSummaryList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseAppDefaultPreview() {
    CourseAppTheme {
        DisplayTopicSummaryGrid()
    }
}