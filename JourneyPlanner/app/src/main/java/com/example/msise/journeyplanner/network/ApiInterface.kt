package com.example.msise.journeyplanner.network

import com.example.msise.journeyplanner.model.Hotel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("hotels/")
    fun getHotels(): Call<List<Hotel>>
}