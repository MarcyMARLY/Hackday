package com.example.msise.journeyplanner.network

import com.example.msise.journeyplanner.model.Hotel
import com.example.msise.journeyplanner.model.ServerResponse
import com.example.msise.journeyplanner.model.TicketsRequest
import com.example.msise.journeyplanner.model.TicketsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("tickets")
    fun sendTicket(@Body ticketsRequest: TicketsRequest): Call<ServerResponse>

    @POST("brain/")
    fun sendBrainDescription(@Body description: String): Call<TicketsRequest>

    @GET("hotels/")
    fun getHotels(): Call<List<Hotel>>

    @GET("cities")
    fun getCities(): Call<List<String>>

    @GET("hotels/{price}")
    fun getHotelsByPrice(@Path("price") price: Double ) : Call<List<Hotel>>

    @GET("hotels/{price}/{countryName}")
    fun getHotelsByPriceAndCountry(@Path("price") price: Double, @Path("countryName") countryName: String ) : Call<List<Hotel>>

    @GET("hotels/{price}/{countryName}/{cityName}")
    fun getHotelsByPriceCountryCity(@Path("price") price: Double, @Path("countryName") countryName: String, @Path("city") cityName: String ) : Call<List<Hotel>>
}