package com.example.pembelajaranreproduksihewan.`object`

import android.content.Context
import android.content.SharedPreferences

object TeacherLoginSP {
    lateinit var LoginSP : SharedPreferences

    fun init (context: Context){
        val sp = context.getSharedPreferences("loginSP", Context.MODE_PRIVATE)
        LoginSP = sp
    }

    fun getSP () : SharedPreferences {
        return LoginSP
    }

    fun getLoginStatus () : Boolean {
        return LoginSP.getBoolean("status", false)
    }

    fun deleteLogin (){
        LoginSP.edit().putBoolean("status", false).apply()
        LoginSP.edit().putString("id", null).apply()
        LoginSP.edit().putString("name", null).apply()
        LoginSP.edit().putString("name", null).apply()
    }

    fun setLoginInfo (id : String, name : String, password : String){
        LoginSP.edit().putBoolean("status", true).apply()
        LoginSP.edit().putString("id",id).apply()
        LoginSP.edit().putString("name",name).apply()
        LoginSP.edit().putString("password",password).apply()
    }

}