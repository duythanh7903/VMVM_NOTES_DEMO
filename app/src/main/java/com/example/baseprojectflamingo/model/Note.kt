package com.example.baseprojectflamingo.model

data class Note(
    var id: String = "",
    var title: String = "",
    var description: String = "",
    var createdAt: Long = 0L,
) {
}