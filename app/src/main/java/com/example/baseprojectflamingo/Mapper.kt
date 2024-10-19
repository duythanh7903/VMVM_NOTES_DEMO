package com.example.baseprojectflamingo

import com.example.baseprojectflamingo.model.Note
import com.example.data.remote.dto.dto_res.NoteDto

fun NoteDto.toNote() = Note(
    id = this.id,
    title = this.title,
    description = this.description,
    createdAt = this.createdAt
)

fun MutableList<NoteDto>.toMutableListNote() =
    this.map { it.toNote() }.toMutableList()

fun Note.toNoteDto() = NoteDto(
    id = this.id,
    title = this.title,
    description = this.description,
    createdAt = this.createdAt
)