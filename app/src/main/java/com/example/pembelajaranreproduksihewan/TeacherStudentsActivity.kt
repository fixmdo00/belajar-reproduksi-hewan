package com.example.pembelajaranreproduksihewan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pembelajaranreproduksihewan.data.Class
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherStudentsBinding

class TeacherStudentsActivity : AppCompatActivity() {
    lateinit var binding : ActivityTeacherStudentsBinding
    lateinit var class_info : Class
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherStudentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        if (intent.hasExtra("class_id")) {
            class_info = Class(
                intent.getStringExtra("class_id").toString(),
                intent.getStringExtra("teacher_id").toString(),
                intent.getStringExtra("name").toString()
            )
        } else {
            class_info.id = "NULL"
        }

        binding.tvClassName.text = "Daftar siswa " + class_info.name

        binding.btnAddNew.setOnClickListener {
            val intent = Intent(this, TeacherStudentsAddNewActivity::class.java)
            startActivity(intent)
        }

        Log.d("class_id",class_info.name)
    }
}