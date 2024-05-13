package com.example.pembelajaranreproduksihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherStudentsAddNewBinding

class TeacherStudentsAddNewActivity : AppCompatActivity() {
    lateinit var binding : ActivityTeacherStudentsAddNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherStudentsAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}