package com.example.allinonelearning.di.components

import android.content.Context
import com.example.allinonelearning.MyApplication
import com.example.allinonelearning.di.module.ApplicationModule
import com.example.allinonelearning.di.qualifier.ApplicationContext
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.RoomDB
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    fun getNetworkService(): NetWorkService

    fun getDatabaseService(): RoomDB
}