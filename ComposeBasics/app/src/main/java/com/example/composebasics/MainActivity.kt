package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeBasicInQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeBasicInQuadrant() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
//        Row(modifier = Modifier.weight(1f)) {
            DisplayQuadrantContent(
                modifier = Modifier
                    .background(color = Color.Green)
                    .weight(1f)
                    .fillMaxSize()
                    .padding(all = 16.dp),
                heading = stringResource(R.string.text_composable_heading),
                detail = stringResource(R.string.text_composable_detail)
            )
            DisplayQuadrantContent(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .weight(1f)
                    .fillMaxSize()
                    .padding(all = 16.dp),
                heading = stringResource(R.string.image_composable_heading),
                detail = stringResource(R.string.image_composable_detail)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            DisplayQuadrantContent(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .weight(1f)
                    .fillMaxSize()
                    .padding(all = 16.dp),
                heading = stringResource(R.string.row_composable_heading),
                detail = stringResource(R.string.row_composable_detail)
            )
            DisplayQuadrantContent(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .weight(1f)
                    .fillMaxSize()
                    .padding(all = 16.dp),
                heading = stringResource(R.string.column_composable_heading),
                detail = stringResource(R.string.column_composable_detail)
            )
        }
    }
}

@Composable
private fun DisplayQuadrantContent(modifier: Modifier, heading: String, detail: String) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(text = heading, fontWeight = FontWeight.Bold, textAlign = TextAlign.Justify)
        Text(text = detail, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeBasicInQuadrantPreview() {
    ComposeBasicsTheme {
        ComposeBasicInQuadrant()
    }
}