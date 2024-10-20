package com.example.baseprojectflamingo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseprojectflamingo.entities.Note
import com.example.baseprojectflamingo.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val notesData = noteRepository.notesData

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.insertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.deleteNote(note)
    }

}