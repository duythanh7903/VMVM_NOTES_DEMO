package com.example.data.remote.api

import com.example.data.remote.dto.dto_res.NoteDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WebApiService {

    @GET("Note")
    fun getAllNote(): Call<MutableList<NoteDto>>

    @GET("Note/{id}")
    fun getNoteById(
        @Path("id") id: String
    ): Call<NoteDto>


    @POST("Note")
    fun addNote(
        @Body note: NoteDto
    ): Call<Int>

    @PUT("Note/{id}")
    fun updateNote(
        @Path("id") id: String,
        @Body note: NoteDto
    ): Call<Int>

    @DELETE("Note/{id}")
    fun deleteNote(
        @Path("id") id: String
    ): Call<Int>

}