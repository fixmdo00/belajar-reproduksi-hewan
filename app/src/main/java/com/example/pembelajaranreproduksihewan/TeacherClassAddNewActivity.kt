package com.example.pembelajaranreproduksihewan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherClassAddNewBinding

class TeacherClassAddNewActivity : AppCompatActivity() {
    lateinit var binding : ActivityTeacherClassAddNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherClassAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}