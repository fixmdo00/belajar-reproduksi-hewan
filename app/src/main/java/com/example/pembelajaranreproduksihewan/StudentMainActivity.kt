package com.example.pembelajaranreproduksihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pembelajaranreproduksihewan.databinding.ActivityStudentMainBinding

class StudentMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityStudentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}