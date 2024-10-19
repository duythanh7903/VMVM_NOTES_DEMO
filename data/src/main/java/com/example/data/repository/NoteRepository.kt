package com.example.data.repository

import com.example.data.remote.api.WebApiService
import com.example.data.remote.dto.dto_res.NoteDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NoteRepository(
    private val webApiService: WebApiService,
) {

    suspend fun getAllNotes() = withContext(Dispatchers.IO) {
        val result = getAllNotesResumeResult()
        return@withContext result
    }

    private suspend fun getAllNotesResumeResult(): MutableList<NoteDto> =
        suspendCoroutine { continuation ->
            val response = webApiService.getAllNote()
            response.enqueue(object : Callback<MutableList<NoteDto>> {
                override fun onResponse(
                    call: Call<MutableList<NoteDto>>,
                    response: Response<MutableList<NoteDto>>
                ) {
                    val body = response.body()
                    body?.let { continuation.resume(it) } ?: continuation.resume(mutableListOf())
                }

                override fun onFailure(call: Call<MutableList<NoteDto>>, t: Throwable) {
                    continuation.resume(mutableListOf())
                }
            })
        }

    suspend fun getNoteById(id: String) = withContext(Dispatchers.IO) {
        val result = getNoteByIdResumeResult(id)
        return@withContext result
    }

    private suspend fun getNoteByIdResumeResult(id: String): NoteDto? =
        suspendCoroutine { continuation ->
            val response = webApiService.getNoteById(id)
            response.enqueue(object : Callback<NoteDto> {
                override fun onResponse(call: Call<NoteDto>, response: Response<NoteDto>) {
                    val noteDto = response.body()
                    continuation.resume(noteDto)
                }

                override fun onFailure(call: Call<NoteDto>, t: Throwable) {
                    continuation.resume(null)
                }
            })
        }

    suspend fun saveNote(note: NoteDto) = withContext(Dispatchers.IO) {
        webApiService.addNote(note).enqueue(object: Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {

            }

            override fun onFailure(call: Call<Int>, t: Throwable) {

            }
        })
    }

    suspend fun updateNote(note: NoteDto) = withContext(Dispatchers.IO) {
        webApiService.updateNote(note.id, note).enqueue(object: Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {

            }

            override fun onFailure(call: Call<Int>, t: Throwable) {

            }
        })
    }

    suspend fun deleteNote(id: String) = withContext(Dispatchers.IO) {
        webApiService.deleteNote(id).enqueue(object: Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {

            }

            override fun onFailure(call: Call<Int>, t: Throwable) {

            }
        })
    }

}