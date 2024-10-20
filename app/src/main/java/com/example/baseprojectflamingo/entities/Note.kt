package com.example.baseprojectflamingo.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var title: String = "",
    var content: String = "",
    var createdAt: Long = System.currentTimeMillis()
)
