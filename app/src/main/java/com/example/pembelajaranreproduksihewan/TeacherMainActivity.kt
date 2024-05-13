package com.example.pembelajaranreproduksihewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pembelajaranreproduksihewan.R
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherMainBinding
import com.example.pembelajaranreproduksihewan.`object`.TeacherLoginSP

class TeacherMainActivity : AppCompatActivity() {

    lateinit var binding : ActivityTeacherMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftarKelas.setOnClickListener {
            val intent = Intent(this, TeacherClassesActivity::class.java)
            startActivity(intent)
        }

        binding.btnMengajar.setOnClickListener {
            val intent = Intent(this, TeacherTeachActivity::class.java)
            startActivity(intent)
        }

        binding.btnNilai.setOnClickListener {
            val intent = Intent(this, TeacherGradesActivity::class.java)
            startActivity(intent)
        }

        binding.btnSettingPertanyaan.setOnClickListener {
            val intent = Intent(this, TeacherQuizSettingActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            TeacherLoginSP.deleteLogin()
            val intent = Intent(this, SplashScreenActivity::class.java)
            startActivity(intent)
        }

    }
}