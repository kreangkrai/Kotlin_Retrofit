package com.example.testretrofit.Interface


import com.example.testretrofit.Models.DeviceModel
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("gets")
    fun getAllDevice(): Observable<List<DeviceModel>>
}