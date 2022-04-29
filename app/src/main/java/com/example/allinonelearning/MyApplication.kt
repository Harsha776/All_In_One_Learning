package com.example.allinonelearning

import android.app.Application
import com.example.allinonelearning.di.components.ApplicationComponent
import com.example.allinonelearning.di.components.DaggerApplicationComponent
import com.example.allinonelearning.di.module.ApplicationModule
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.NoteDatabase
import com.example.allinonelearning.room.NotesDao
import com.example.allinonelearning.room.RoomDB
import javax.inject.Inject

class MyApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
    @Inject lateinit var networking: NetWorkService
    @Inject lateinit var roomDB: RoomDB

    override fun onCreate() {
        super.onCreate()
        applicationComponent= DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

    }

    fun getInstance():NoteDatabase{
        return NoteDatabase.getDatabase(this)
    }
}