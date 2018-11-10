package com.example.msise.journeyplanner.constructor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*
import kotlinx.android.synthetic.main.activity_constructor.*

class ConstructorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constructor)



        val dataset = ArrayList<Any>()

        dataset.add(Pair("Generate by Budget", 1))
        dataset.add(FLIGHTTICKETS)
        dataset.add(ACCOMMODATION)
        dataset.add(FOOD)
        dataset.add(ENTERTAINMENT)
        dataset.add(CARRENT)
        dataset.add(INSURANCE)
        dataset.add(FlightTickets("", "", "", "", "", "", ""))
        dataset.add(Accommodation("", 0, "", ""))
        dataset.add(Food("", "", ""))
        dataset.add(Entertainment("", "", ""))
        dataset.add(CarRent("", "", ""))
        dataset.add(Insurance("", "", ""))

        constructorRecyclerView.layoutManager = LinearLayoutManager(this)
        constructorRecyclerView.adapter = ConstructorAdapter(this, dataset)
    }
}
