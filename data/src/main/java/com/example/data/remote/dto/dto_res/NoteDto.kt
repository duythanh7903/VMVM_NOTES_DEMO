package com.example.data.remote.dto.dto_res

import com.google.gson.annotations.SerializedName

data class NoteDto(
    @SerializedName("id")
    var id: String = "1",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("created_at")
    var createdAt: Long = 0
) {
}