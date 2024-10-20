package com.example.baseprojectflamingo.repository

import com.example.baseprojectflamingo.dao.NoteDao
import com.example.baseprojectflamingo.entities.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    val notesData = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) = noteDao.insert(note)

    suspend fun updateNote(note: Note) = noteDao.update(note)

    suspend fun deleteNote(note: Note) = noteDao.delete(note)

}