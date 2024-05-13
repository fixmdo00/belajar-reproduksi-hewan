package com.example.pembelajaranreproduksihewan.`object`

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

object RQ {
    private lateinit var RQ: RequestQueue
    var domain : String = "https://wifi-map.my.id/kevin_api/"

    fun initRQ (context: Context) {
        val requestQueue = Volley.newRequestQueue(context)
        RQ = requestQueue
    }

    fun getRQ(): RequestQueue {
        return RQ
    }
}