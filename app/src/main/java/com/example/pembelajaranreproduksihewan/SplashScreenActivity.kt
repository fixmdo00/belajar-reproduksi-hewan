package com.example.pembelajaranreproduksihewan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pembelajaranreproduksihewan.`object`.RQ
import com.example.pembelajaranreproduksihewan.`object`.StudentLoginSP
import com.example.pembelajaranreproduksihewan.`object`.TeacherLoginSP

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        TeacherLoginSP.init(applicationContext)
        StudentLoginSP.init(applicationContext)
        RQ.initRQ(applicationContext)
        Handler().postDelayed({
            // Setelah delay, pindah ke main activity
            val intentLogin = Intent(this@SplashScreenActivity, MainActivity::class.java)
            val intentTeacher = Intent(this, TeacherMainActivity::class.java)
            val intentStudent = Intent(this, StudentMainActivity::class.java)

            if (TeacherLoginSP.getLoginStatus()){
                startActivity(intentTeacher)
            } else if (StudentLoginSP.getLoginStatus()){
                startActivity(intentStudent)
            } else {
                startActivity(intentLogin)
            }
            finish()
        }, SPLASH_DELAY)
    }
}