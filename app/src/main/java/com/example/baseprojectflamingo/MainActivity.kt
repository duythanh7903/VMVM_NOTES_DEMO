package com.example.baseprojectflamingo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.baseprojectflamingo.databinding.ActivityMainBinding
import com.example.baseprojectflamingo.model.Note
import com.example.data.remote.RetrofitInstance
import com.example.data.repository.NoteRepository
import com.example.domain.use_case.DeleteNoteUseCase
import com.example.domain.use_case.GetNoteByIdUseCase
import com.example.domain.use_case.GetNoteUseCase
import com.example.domain.use_case.SaveNoteUseCase
import com.example.domain.use_case.UpdateNoteUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        insertNote()
//        getNoteById("1")
        /*updateNoteById(Note(
            id = "1",
            title = "Title Update",
            description = "Description Update",
            createdAt = System.currentTimeMillis()
        ))*/
//        deleteNoteById("78")
        getData()
        observeData()
    }

    private fun initViewModel() {
        val noteRepository = NoteRepository(RetrofitInstance.webService)
        val getNoteUseCase = GetNoteUseCase(noteRepository)
        val getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
        val saveNoteUseCase = SaveNoteUseCase(noteRepository)
        val updateNoteUseCase = UpdateNoteUseCase(noteRepository)
        val deleteNoteUseCase = DeleteNoteUseCase(noteRepository)
        val viewModelFactory = MainVmFactory(
            getNoteUseCase,
            getNoteByIdUseCase,
            saveNoteUseCase,
            updateNoteUseCase,
            deleteNoteUseCase
        )
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun getData() = viewModel.fetchNotes()

    private fun observeData() = viewModel.apply {
        isLoading.observe(this@MainActivity) { loading ->
            if (loading) binding.progress.visibility = View.VISIBLE
            else binding.progress.visibility = View.GONE
        }

        notesData.observe(this@MainActivity) { notes ->
            Log.d("duylt", "Note Size: ${notes.size}")
        }

        note.observe(this@MainActivity) { data ->
            Log.d("duylt", "Note Data: $data")
        }
    }

    private fun insertNote() {
        val note = Note(
            id = "0",
            title = "Hello",
            description = "Hello VietNam",
            createdAt = System.currentTimeMillis()
        )
        viewModel.saveNote(note)
    }

    private fun getNoteById(id: String) = viewModel.fetchNotesById(id)

    private fun deleteNoteById(id: String) = viewModel.deleteNote(id)

    private fun updateNoteById(note: Note) = viewModel.updateNote(note)
}