package com.example.allinonelearning.network

import android.content.Context

class Networking(context: Context, baseUrl:String) {
    var context:Context=context
    private var baseUrl=baseUrl

    fun getBaseUrl():String{
        return baseUrl
    }
}