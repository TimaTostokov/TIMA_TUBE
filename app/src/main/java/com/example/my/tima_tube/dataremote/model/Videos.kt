package com.example.my.tima_tube.dataremote.model

data class Videos(
    val items: List<Items>,
)

data class Items(
    val contentDetails: ContentDetails,
) {
    data class ContentDetails(
        val duration: String,
    )
}