package com.example.domain.use_case

import com.example.data.remote.dto.dto_res.NoteDto
import com.example.data.repository.NoteRepository

open class NoteUseCase {
    open suspend fun getNote(): MutableList<NoteDto> = mutableListOf()
    open suspend fun getNoteById(id: String): NoteDto? = null
    open suspend fun saveNote(note: NoteDto) {}
    open suspend fun updateNote(note: NoteDto) {}
    open suspend fun deleteNote(id: String) {}
}

class GetNoteUseCase(private val noteRepository: NoteRepository) : NoteUseCase() {

    suspend fun execute() =
        getNote()

    override suspend fun getNote(): MutableList<NoteDto> = noteRepository.getAllNotes()
}

class GetNoteByIdUseCase(private val noteRepository: NoteRepository) : NoteUseCase() {

    suspend fun execute(id: String) =
        getNoteById(id)

    override suspend fun getNoteById(id: String): NoteDto? = noteRepository.getNoteById(id)
}

class SaveNoteUseCase(private val noteRepository: NoteRepository) : NoteUseCase() {

    suspend fun execute(note: NoteDto) =
        saveNote(note)

    override suspend fun saveNote(note: NoteDto) {
        noteRepository.saveNote(note)
    }
}

class UpdateNoteUseCase(private val noteRepository: NoteRepository) : NoteUseCase() {

    suspend fun execute(note: NoteDto) =
        updateNote(note)

    override suspend fun updateNote(note: NoteDto) {
        noteRepository.updateNote(note)
    }
}

class DeleteNoteUseCase(private val noteRepository: NoteRepository) : NoteUseCase() {

    suspend fun execute(id: String) =
        deleteNote(id)

    override suspend fun deleteNote(id: String) {
        noteRepository.deleteNote(id)
    }
}