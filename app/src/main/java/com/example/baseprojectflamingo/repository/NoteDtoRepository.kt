package com.example.baseprojectflamingo.repository

import com.example.baseprojectflamingo.web_service.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteDtoRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun fetchNotes() = apiService.getAllNote()

}