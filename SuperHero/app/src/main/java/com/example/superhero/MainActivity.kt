package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(4)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(2f)) {
                Text(stringResource(id = hero.nameId), style = MaterialTheme.typography.h2, modifier = Modifier.padding(start = 8.dp))
                Text(
                    stringResource(id = hero.descriptionId),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = hero.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun SuperHeroListing(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier
        .padding(bottom = 16.dp)
        .background(color = MaterialTheme.colors.background)
    ) {
        items(HeroesRepository.heroes) {
            HeroCard(it)
        }
    }
}

@Composable
fun TopAppBar() {
    Box(
        modifier = Modifier.fillMaxWidth().size(56.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1)
        
    }
}

@Composable
fun SuperHeroApp() {
    Scaffold(modifier = Modifier.fillMaxWidth(), topBar = { TopAppBar() }) {
        SuperHeroListing(modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroTheme(darkTheme = true) {
        SuperHeroApp()
    }
}