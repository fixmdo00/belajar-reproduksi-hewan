package com.example.pembelajaranreproduksihewan

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pembelajaranreproduksihewan.data.Teacher
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherLoginBinding
import com.example.pembelajaranreproduksihewan.databinding.CustomSpinnerItemBinding
import com.example.pembelajaranreproduksihewan.`object`.TeacherLoginSP
import com.example.pembelajaranreproduksihewan.`object`.Teachers

class TeacherLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTeacherLoginBinding
    private lateinit var bindingSpinner : CustomSpinnerItemBinding

    val teacherList = ArrayList<String>()
    var selectedTeacherName = String()
    lateinit var selectedTeacher : Teacher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinnerTeacher : Spinner = binding.spinnerTeacher
        val teacherAdapter = ArrayAdapter(this, R.layout.simple_spinner_item , teacherList)
        spinnerTeacher.adapter = teacherAdapter

        Teachers.getFromDB(binding.loadingProgressBar){
            teacherList.addAll(Teachers.getNames())
            teacherAdapter.notifyDataSetChanged()
        }

        spinnerTeacher.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position)
                selectedTeacherName = selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.btnLogin.setOnClickListener {
            if(selectedTeacherName.isNotBlank()){
                login(binding.inputPasswordGuru.text.toString())
            }
        }
    }

    fun login(password : String){
        for (i in 0 until Teachers.teachers.length()) {
            val jsonObject = Teachers.teachers.getJSONObject(i)
            if(jsonObject.getString("name") == selectedTeacherName){
                if(jsonObject.getString("password") == password){
                    TeacherLoginSP.setLoginInfo(
                        jsonObject.getString("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("password")
                    )
                    val intent = Intent(this, TeacherMainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}