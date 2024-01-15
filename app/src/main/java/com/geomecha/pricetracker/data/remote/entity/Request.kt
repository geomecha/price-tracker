package com.geomecha.pricetracker.data.remote.entity

data class Request(
    val count: Int,
    val cx: String,
    val inputEncoding: String,
    val outputEncoding: String,
    val safe: String,
    val searchTerms: String,
    val searchType: String,
    val startIndex: Int,
    val title: String,
    val totalResults: String
)