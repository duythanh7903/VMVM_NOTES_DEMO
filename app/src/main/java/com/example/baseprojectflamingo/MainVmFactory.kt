package com.example.baseprojectflamingo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.use_case.DeleteNoteUseCase
import com.example.domain.use_case.GetNoteByIdUseCase
import com.example.domain.use_case.GetNoteUseCase
import com.example.domain.use_case.SaveNoteUseCase
import com.example.domain.use_case.UpdateNoteUseCase

@Suppress("UNCHECKED_CAST")
class MainVmFactory(
    private val getNotesUseCase: GetNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val saveNoteUseCase: SaveNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                getNotesUseCase, getNoteByIdUseCase, saveNoteUseCase,
                updateNoteUseCase, deleteNoteUseCase
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}