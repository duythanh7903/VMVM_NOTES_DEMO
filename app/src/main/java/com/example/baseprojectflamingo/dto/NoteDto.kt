package com.example.baseprojectflamingo.dto

import com.google.gson.annotations.SerializedName

data class NoteDto(
    @SerializedName("id")
    var id: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("created_at")
    var createdAt: Long = System.currentTimeMillis()
) {
}