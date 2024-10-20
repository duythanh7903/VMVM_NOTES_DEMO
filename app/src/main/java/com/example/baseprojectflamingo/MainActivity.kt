package com.example.baseprojectflamingo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.baseprojectflamingo.databinding.ActivityMainBinding
import com.example.baseprojectflamingo.entities.Note
import com.example.baseprojectflamingo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertNote()
        observe()
    }

    private fun insertNote() {
        val note = Note(title = "This is test title", content = "This is test content")
        viewModel.insertNote(note)
    }

    private fun observe() = viewModel.apply {
        notesData.observe(this@MainActivity) { data ->
            Log.d("duylt", "List: $data")
        }
    }
}