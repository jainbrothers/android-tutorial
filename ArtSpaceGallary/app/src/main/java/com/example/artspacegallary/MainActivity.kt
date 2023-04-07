package com.example.artspacegallary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspacegallary.ui.theme.ArtSpaceGallaryTheme
import com.example.artspacegallary.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceGallaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceGallaryPage()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceGallaryPage() {
    val imageIdentifiers  = arrayOf(
        Triple(R.drawable.i1, "Sample description", "Sample Author"),
        Triple(R.drawable.i2, "Sample description", "Sample Author"),
        Triple(R.drawable.i3, "Sample description", "Sample Author"),
        Triple(R.drawable.i4, "Sample description", "Sample Author"),
        Triple(R.drawable.i5, "Sample description", "Sample Author"),
        Triple(R.drawable.i6, "Sample description", "Sample Author"),
        Triple(R.drawable.i7, "Sample description", "Sample Author"),
        Triple(R.drawable.i8, "Sample description", "Sample Author"),
        Triple(R.drawable.i9, "Sample description", "Sample Author"),
        Triple(R.drawable.i10, "Sample description", "Sample Author"),
        Triple(R.drawable.i11, "Sample description", "Sample Author"),
        Triple(R.drawable.i12, "Sample description", "Sample Author"),
        Triple(R.drawable.i13, "Sample description", "Sample Author"),
        Triple(R.drawable.i14, "Sample description", "Sample Author")
    )
    var currentImageIndex by remember { mutableStateOf(0) }
    Column(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageIdentifiers[currentImageIndex].first),
            contentDescription = imageIdentifiers[currentImageIndex].second,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(weight = 0.70f, fill = true)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(imageIdentifiers[currentImageIndex].second, fontSize = 20.sp, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
        Row (modifier = Modifier.align(alignment = Alignment.CenterHorizontally)){
            Text(
                imageIdentifiers[currentImageIndex].third,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.left_paranthesis))
            Text(
                stringResource(R.string.sample_publication_year),
            )
            Text(stringResource(R.string.right_paranthesis))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { currentImageIndex = if (currentImageIndex != 0)  (currentImageIndex - 1) % imageIdentifiers.size else imageIdentifiers.size - 1}) {
                Text("Previous")
            }
            Button(onClick = {currentImageIndex = (currentImageIndex + 1) % imageIdentifiers.size},
                shape = Shapes.large) {
                Text("Next")
            }
        }
        Spacer(modifier = Modifier.padding(all = 5.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceGallaryTheme {
        ArtSpaceGallaryPage()
    }
}