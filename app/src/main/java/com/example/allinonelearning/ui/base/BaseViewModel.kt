package com.example.allinonelearning.ui.base

import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.room.NoteDatabase
import com.example.allinonelearning.room.RoomDB
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(netWorkService: NetWorkService,roomDatabase: NoteDatabase,
                    private val compositeDisposable: CompositeDisposable):ViewModel() {

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}