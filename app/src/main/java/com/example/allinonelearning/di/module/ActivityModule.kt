package com.example.allinonelearning.di.module

import android.app.Activity

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.allinonelearning.MainViewModel
import com.example.allinonelearning.di.qualifier.ActivityContext
import com.example.allinonelearning.di.scope.ActivityScope
import com.example.allinonelearning.factory.ViewModelFactory
import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.RoomDB
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(activity: Activity) {

    val activity=activity

    @ActivityContext
    fun getActivityContext():Context{
        return activity
    }

        @ActivityScope
        @Provides
        fun getMainViewModule(networking: Networking,roomDB: RoomDB)
        :MainViewModel {
            return ViewModelProvider(activity as FragmentActivity, ViewModelFactory(MainViewModel::class) {
                MainViewModel(networking, roomDB)
            }).get(MainViewModel::class.java)
        }

}