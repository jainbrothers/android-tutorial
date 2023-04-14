package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superhero.R

data class Hero(@StringRes val nameId: Int, @StringRes val descriptionId: Int, @DrawableRes val imageId: Int)

object HeroesRepository {
        val heroes = listOf(
            Hero(
                nameId = R.string.hero1,
                descriptionId = R.string.description1,
                imageId = R.drawable.android_superhero1
            ),
            Hero(
                nameId = R.string.hero2,
                descriptionId = R.string.description2,
                imageId = R.drawable.android_superhero2
            ),
            Hero(
                nameId = R.string.hero3,
                descriptionId = R.string.description3,
                imageId = R.drawable.android_superhero3
            ),
            Hero(
                nameId = R.string.hero4,
                descriptionId = R.string.description4,
                imageId = R.drawable.android_superhero4
            ),
            Hero(
                nameId = R.string.hero5,
                descriptionId = R.string.description5,
                imageId = R.drawable.android_superhero5
            ),
            Hero(
                nameId = R.string.hero6,
                descriptionId = R.string.description6,
                imageId = R.drawable.android_superhero6
            )
        )
}