package com.example.allinonelearning

import androidx.lifecycle.ViewModel
import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.RoomDB
import javax.inject.Inject

class MainViewModel(val networking: Networking,val roomDB: RoomDB):ViewModel() {

    fun getData():String{
     return networking.getBaseUrl()
    }
}