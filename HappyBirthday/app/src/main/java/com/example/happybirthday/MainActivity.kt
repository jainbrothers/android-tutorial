package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthWishesWithImage("ajit", "jain")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithName(name: String, from: String) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(R.string.BirthdayGreeting) + " " + name + "!",
                    fontSize = 36.sp
                )
                Text(modifier = Modifier.padding(top = 16.dp, end = 16.dp).align(Alignment.End),
                text = stringResource(R.string.fromstring) + " " + from,
                fontSize = 24.sp
                )
            }
        )
}

@Composable
fun BirthWishesWithImage(name: String, from: String) {
    Box {
        Image(painter = painterResource(id = R.drawable.androidparty), contentDescription = null, contentScale = ContentScale.Crop)
        BirthdayGreetingWithName(name, from)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthWishesWithImagePreview() {
    HappyBirthdayTheme {
        BirthWishesWithImage(stringResource(R.string.defaultname), stringResource(R.string.defaultfrom))
    }
}