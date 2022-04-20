package com.example.allinonelearning.room

import android.content.Context
import com.example.allinonelearning.di.qualifier.ApplicationContext
import com.example.allinonelearning.di.qualifier.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomDB @Inject constructor(@ApplicationContext context: Context,
                                 @DatabaseInfo dbName:String) {

    val context=context
    val dbName=dbName


    fun getBaseUrl():String{
        return dbName
    }
}