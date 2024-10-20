package com.example.baseprojectflamingo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.baseprojectflamingo.databinding.ActivityMainBinding
import com.example.baseprojectflamingo.viewmodel.MainDtoViewModel
import com.example.baseprojectflamingo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainDtoViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.notes.observe(this) { data ->
            Log.d("duylt", "List: $data")
        }
    }
}