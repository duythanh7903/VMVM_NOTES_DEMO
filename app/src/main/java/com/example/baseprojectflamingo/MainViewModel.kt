package com.example.baseprojectflamingo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseprojectflamingo.model.Note
import com.example.domain.use_case.DeleteNoteUseCase
import com.example.domain.use_case.GetNoteByIdUseCase
import com.example.domain.use_case.GetNoteUseCase
import com.example.domain.use_case.SaveNoteUseCase
import com.example.domain.use_case.UpdateNoteUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getNotesUseCase: GetNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val saveNoteUseCase: SaveNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _notesData = MutableLiveData<MutableList<Note>>()
    val notesData: LiveData<MutableList<Note>> = _notesData

    private val _note = MutableLiveData<Note?>()
    val note: LiveData<Note?> = _note

    fun fetchNotes() = viewModelScope.launch {
        _isLoading.postValue(true)
        val listNotesData = getNotesUseCase.execute()
        _notesData.postValue(listNotesData.toMutableListNote())
        _isLoading.postValue(false)
    }

    fun fetchNotesById(id: String) = viewModelScope.launch {
        val noteDataCanNull = getNoteByIdUseCase.execute(id)
        _note.postValue(noteDataCanNull?.toNote())
    }

    fun saveNote(note: Note) = viewModelScope.launch {
        saveNoteUseCase.execute(note.toNoteDto())
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        updateNoteUseCase.execute(note.toNoteDto())
    }

    fun deleteNote(id: String) = viewModelScope.launch {
        deleteNoteUseCase.execute(id)
    }

}