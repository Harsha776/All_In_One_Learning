package com.example.allinonelearning.di.module

import android.content.Context
import com.example.allinonelearning.MyApplication
import com.example.allinonelearning.di.qualifier.ApplicationContext
import com.example.allinonelearning.di.qualifier.DatabaseInfo
import com.example.allinonelearning.di.qualifier.NetworkInfo
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.network.Networking
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(myApplication: MyApplication) {
    val myApplication=myApplication

    @ApplicationContext
    @Provides
    fun provideContext(): Context{
        return myApplication
    }

    /*@Singleton
    @Provides
    fun getNetWork():Networking{
        return Networking(context,"Base Url data")
    }

    @Singleton
    @Provides
    fun getRoomDB():RoomDB{
        return RoomDB(context,"Example.db",1)
    }*/

    @NetworkInfo
    @Provides
    fun getString():String{
        return "Base Url data"
    }

    @DatabaseInfo
    @Provides
    fun getRoomString():String{
        return "Example.db"
    }

    @Provides
    fun provideNetworkService():NetWorkService{
        return Networking.createInstance()
    }
}