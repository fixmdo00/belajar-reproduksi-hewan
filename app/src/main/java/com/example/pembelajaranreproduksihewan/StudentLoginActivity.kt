package com.example.pembelajaranreproduksihewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pembelajaranreproduksihewan.databinding.ActivityStudentLoginBinding

class StudentLoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityStudentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, StudentMainActivity::class.java)
            startActivity(intent)
        }
    }
}