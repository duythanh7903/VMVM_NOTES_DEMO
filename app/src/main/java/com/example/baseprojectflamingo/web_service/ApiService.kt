package com.example.baseprojectflamingo.web_service

import com.example.baseprojectflamingo.dto.NoteDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("Note")
    fun getAllNote(): Call<MutableList<NoteDto>>

}