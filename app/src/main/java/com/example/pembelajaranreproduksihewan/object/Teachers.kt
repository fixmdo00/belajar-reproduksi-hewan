package com.example.pembelajaranreproduksihewan.`object`

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.pembelajaranreproduksihewan.data.Teacher
import org.json.JSONArray
import org.json.JSONException

object Teachers {
    var list = ArrayList<Teacher>()
    var teachers = JSONArray()
    val _liveTeachers = MutableLiveData<JSONArray>()
    val liveTeachers : LiveData<JSONArray> = _liveTeachers

    fun getFromDB(progressBar: ProgressBar, callback : (Boolean) -> Unit){
        progressBar.visibility = View.VISIBLE
        val url = RQ.domain + "teachers.php"
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                progressBar.visibility = View.GONE
                try {
                    teachers = response
                    _liveTeachers.postValue(response)
                    populateList()
                    callback(true)
                } catch (e: JSONException) {
                    e.printStackTrace()
                    callback(false)
                }
            },
            { error ->
                Log.d("err",error.toString())
                callback(false)
            }
        )
        RQ.getRQ().add(jsonArrayRequest)
    }

    fun getNames () : ArrayList<String> {
        val names = ArrayList<String>()
        try {
            for (i in 0 until teachers.length()) {
                val jsonObject = teachers.getJSONObject(i)
                names.add(jsonObject.getString("name"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return names
    }

    fun populateList (){
        try {
            for (i in 0 until teachers.length()) {
                val jsonObject = teachers.getJSONObject(i)
                val id = (jsonObject.getString("id"))
                val name = (jsonObject.getString("name"))
                val password = (jsonObject.getString("password"))
                list.add(Teacher(id,name,password))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}