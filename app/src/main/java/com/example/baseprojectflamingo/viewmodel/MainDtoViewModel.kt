package com.example.baseprojectflamingo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.baseprojectflamingo.repository.NoteDtoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainDtoViewModel @Inject constructor(
    private val noteDtoRepository: NoteDtoRepository
): ViewModel() {

    val notes = liveData(Dispatchers.IO) {
        val response = noteDtoRepository.fetchNotes().execute()
        if (response.isSuccessful) {
            Log.d("duylt", "Fetching note Successful")
            emit(response.body() ?: mutableListOf())
        } else {
            Log.d("duylt", "Fetching note Failed")
            emit(mutableListOf())
        }
    }

}