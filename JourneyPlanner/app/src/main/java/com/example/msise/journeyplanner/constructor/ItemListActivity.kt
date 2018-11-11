package com.example.msise.journeyplanner.constructor

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*
import kotlinx.android.synthetic.main.activity_item_list.*

class ItemListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val dataset = ArrayList<Any>()

        val type = intent.getStringExtra("type")

        when(type) {
            "tickets" -> {
                val tickets = intent.getParcelableArrayListExtra<FlightTickets>("tickets")
                dataset.addAll(tickets)
            }
            "hotels" -> {
                val hotels = intent.getParcelableArrayListExtra<Accommodation>("hotels")
                dataset.addAll(hotels)
            }
            "food" -> {
                dataset.add(Food("", "", "Price: $100"))
                dataset.add(Food("", "", "Price: $100"))
                dataset.add(Food("", "", "Price: $100"))
                dataset.add(Food("", "", "Price: $100"))
            }
            "entertainment" -> {
                dataset.add(Entertainment("", "", "Price: $100"))
                dataset.add(Entertainment("", "", "Price: $100"))
                dataset.add(Entertainment("", "", "Price: $100"))
                dataset.add(Entertainment("", "", "Price: $100"))
            }
            "car" -> {
                dataset.add(CarRent("", "", "Price: $100"))
                dataset.add(CarRent("", "", "Price: $100"))
                dataset.add(CarRent("", "", "Price: $100"))
                dataset.add(CarRent("", "", "Price: $100"))
            }
            "insurance" -> {
                val insurance = Insurance("Basic Insurance", "Health and Safety Kit", "Price: $20.00")
                setResult(Activity.RESULT_OK, Intent()
                        .putExtra("insurance", insurance))
                finish()
            }
            "insuranceCancel" -> {
                setResult(Activity.RESULT_OK, Intent()
                        .putExtra("insurance", INSURANCE))
                finish()
            }
        }

        dataset.add(SPACE)

        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = ItemListAdapter(this, dataset)
    }
}
