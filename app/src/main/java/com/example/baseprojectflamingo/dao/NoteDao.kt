package com.example.baseprojectflamingo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.baseprojectflamingo.entities.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM NOTE ORDER BY id DESC")
    fun getAllNotes(): LiveData<MutableList<Note>>

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}