package com.example.allinonelearning

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.room.NoteDatabase
import com.example.allinonelearning.room.RoomDB
import com.example.allinonelearning.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(val networking: NetWorkService,val roomDB: NoteDatabase,
                    private val compositeDisposable: CompositeDisposable):BaseViewModel(networking,
    roomDB,compositeDisposable) {

    fun getData(){
     networking.doGetListResources()
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({
             Log.d("TAG", "getData: "+it)
             Log.d("TAG", "getData: "+roomDB.noteDao().getNotes())

         },{

         })
    }

    fun printDB(){
        Log.d("TAG", "getData: "+roomDB.noteDao().getNotes())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}