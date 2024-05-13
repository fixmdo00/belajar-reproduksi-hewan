package com.example.pembelajaranreproduksihewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pembelajaranreproduksihewan.adapter.ClassAdapter
import com.example.pembelajaranreproduksihewan.data.Class
import com.example.pembelajaranreproduksihewan.databinding.ActivityTeacherClassesBinding
import com.example.pembelajaranreproduksihewan.`object`.Classes

class TeacherClassesActivity : AppCompatActivity() {
    lateinit var binding : ActivityTeacherClassesBinding
    lateinit var classAdapter : ClassAdapter
    lateinit var classRecyclerView : RecyclerView
    var classArrayList = ArrayList<Class>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherClassesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        classRecyclerView = binding.classesRV
        classRecyclerView.layoutManager = LinearLayoutManager(this)
        classRecyclerView.setHasFixedSize(true)
        classAdapter = ClassAdapter(classArrayList)
        classRecyclerView.adapter = classAdapter

        Classes.getFromDB(binding.loadingProgressBar){
            Log.d("debugx",Classes.classes.toString())
            classAdapter.list = Classes.list
            classAdapter.notifyDataSetChanged()
        }

        classAdapter.onItemClick = {
            val class_id = it[0]
            val intent = Intent(this, TeacherStudentsActivity::class.java)
            intent.putExtra("class_id",it[0])
            intent.putExtra("teacher_id",it[1])
            intent.putExtra("name",it[2])
            startActivity(intent)
        }

        binding.btnAddNew.setOnClickListener {
            val intent = Intent(this, TeacherClassAddNewActivity::class.java)
            startActivity(intent)
        }



    }

//    override fun onRestart() {
//        super.onRestart()
//        Classes.getFromDB(binding.loadingProgressBar){
//            Log.d("debug",Classes.classes.toString())
//            classAdapter.list.clear()
//            classAdapter.list = Classes.list
//            classAdapter.notifyDataSetChanged()
//        }
//    }
}