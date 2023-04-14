package com.example.courseapp.model

import com.example.courseapp.R

class DataSource() {
    fun loadTopicSummary() : List<TopicSummary> {
        return listOf(
            TopicSummary(
                R.drawable.architecture,
                R.string.architecture_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.crafts,
                R.string.craft_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.business,
                R.string.business_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.culinary,
                R.string.culinary_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.design,
                R.string.design_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.fashion,
                R.string.fashion_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.film,
                R.string.film_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.gaming,
                R.string.gaming_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.drawing,
                R.string.drawing_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.lifestyle,
                R.string.liftstyle_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.music,
                R.string.music_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.painting,
                R.string.painting_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.photography,
                R.string.photography_topic_name,
                numOfCourses = 58
            ),
            TopicSummary(
                R.drawable.tech,
                R.string.tech_topic_name,
                numOfCourses = 58
            )
        )
    }
}