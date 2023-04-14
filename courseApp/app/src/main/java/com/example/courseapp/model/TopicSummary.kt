package com.example.courseapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TopicSummary(@DrawableRes val resourceImageId: Int, @StringRes val resourceNameId: Int, val numOfCourses: Int)
//TODO: add icon to enable diff icons for diff course summary