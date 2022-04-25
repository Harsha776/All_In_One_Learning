package com.example.allinonelearning.network

import io.reactivex.Single
import retrofit2.http.GET



interface NetWorkService {

    @GET("/api/unknown")
    fun doGetListResources(): Single<Object>
}