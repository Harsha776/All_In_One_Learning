package com.example.allinonelearning.di.module

import android.app.Activity

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.allinonelearning.MainViewModel
import com.example.allinonelearning.di.qualifier.ActivityContext
import com.example.allinonelearning.di.scope.ActivityScope
import com.example.allinonelearning.factory.ViewModelFactory
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.room.NoteDatabase
import com.example.allinonelearning.room.RoomDB
import com.example.allinonelearning.ui.base.BaseActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(activity: BaseActivity<*>) {

    val activity=activity

    @ActivityContext
    fun getActivityContext():Context{
        return activity
    }

        @ActivityScope
        @Provides
        fun getMainViewModule(networking: NetWorkService,roomDB: NoteDatabase,compositeDisposable: CompositeDisposable)
        : MainViewModel {
            return ViewModelProvider(activity, ViewModelFactory(MainViewModel::class) {
                MainViewModel(networking, roomDB,compositeDisposable)
            }).get(MainViewModel::class.java)
        }

}