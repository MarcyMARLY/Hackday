package com.example.msise.journeyplanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.msise.journeyplanner.model.Hotel
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val endPoint = ApiClient().getClient().create(ApiInterface::class.java)
    }
}
