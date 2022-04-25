package com.example.allinonelearning

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.allinonelearning.network.NetWorkService
import com.example.allinonelearning.room.RoomDB
import io.reactivex.android.schedulers.AndroidSchedulers


import io.reactivex.schedulers.Schedulers

class MainViewModel(val networking: NetWorkService,val roomDB: RoomDB):ViewModel() {

    fun getData(){
     networking.doGetListResources()
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe({
             Log.d("TAG", "getData: "+it)

         },{

         })
    }
}