package com.example.pembelajaranreproduksihewan.`object`

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.example.pembelajaranreproduksihewan.data.Class
import org.json.JSONArray
import org.json.JSONException

object Classes {
    var list = ArrayList<Class>()
    var classes = JSONArray()
    val _liveClasses = MutableLiveData<JSONArray>()
    val liveTeachers : LiveData<JSONArray> = _liveClasses

    fun getFromDB(progressBar: ProgressBar, callback : (Boolean) -> Unit){
        progressBar.visibility = View.VISIBLE
        val url = RQ.domain + "classes.php"
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                progressBar.visibility = View.GONE
                try {
                    classes = response
                    _liveClasses.postValue(response)
                    list.clear()
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
            for (i in 0 until classes.length()) {
                val jsonObject = classes.getJSONObject(i)
                names.add(jsonObject.getString("name"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return names
    }

    fun populateList (){
        try {
            for (i in 0 until classes.length()) {
                val jsonObject = classes.getJSONObject(i)
                val id = (jsonObject.getString("id"))
                val teacher_id = (jsonObject.getString("teacher_id"))
                val name = (jsonObject.getString("name"))
                list.add(Class(id,teacher_id,name))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addNew(teacher_id : String, name : String){
        val params = HashMap<String, String>()
        params["teacher_id"] = teacher_id
        params["name"] = name
        val url = RQ.domain + "classes.php"
        val urlTest = "https://httpdump.app/dumps/9147a50c-0ab4-497f-b260-82c755cb88dc"
        val request = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("debug add class", response)
                if (response == "berhasil") {
                } else {
                }
            },
            { error ->
                Log.d("pzn add order err",error.toString())
            }) {
            override fun getParams(): Map<String, String> {
                return params // Mengubah JSONObject menjadi Map<String, String>
            }
        }
        RQ.getRQ().add(request)
    }
}