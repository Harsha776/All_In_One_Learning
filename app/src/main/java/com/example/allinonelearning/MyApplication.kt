package com.example.allinonelearning

import android.app.Application
import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.RoomDB

class MyApplication: Application() {
    lateinit var networking: Networking
    lateinit var roomDB: RoomDB

    override fun onCreate() {
        super.onCreate()
        networking= Networking(this,"Base Url data")
        roomDB= RoomDB(this,"Example.db",1)

    }
}