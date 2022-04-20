package com.example.allinonelearning.network

import android.content.Context
import com.example.allinonelearning.di.qualifier.ApplicationContext
import com.example.allinonelearning.di.qualifier.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Networking @Inject constructor(@ApplicationContext context: Context,
                                     @NetworkInfo baseUrl:String) {
    var context:Context=context
    private var baseUrl=baseUrl

    fun getBaseUrl():String{
        return baseUrl
    }
}