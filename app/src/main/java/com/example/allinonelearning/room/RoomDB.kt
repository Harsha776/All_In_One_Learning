package com.example.allinonelearning.room

import android.content.Context

class RoomDB(context: Context,dbName:String,version:Int) {

    val context=context
    val dbName=dbName
    val version=version

    fun getBaseUrl():String{
        return dbName
    }
}