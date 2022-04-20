package com.example.allinonelearning

import com.example.allinonelearning.network.Networking
import com.example.allinonelearning.room.RoomDB
import javax.inject.Inject

class MainViewModel @Inject constructor(val networking: Networking,val roomDB: RoomDB) {

    fun getData():String{
     return networking.getBaseUrl()
    }
}