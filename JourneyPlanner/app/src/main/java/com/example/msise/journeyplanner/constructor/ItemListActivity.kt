package com.example.msise.journeyplanner.constructor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*
import kotlinx.android.synthetic.main.activity_item_list.*

class ItemListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val dataset = ArrayList<Any>()

        dataset.add(FlightTickets("", "", "", "", "", "", ""))
        dataset.add(FlightTickets("", "", "", "", "", "", ""))
        dataset.add(FlightTickets("", "", "", "", "", "", ""))

        dataset.add(Accommodation("", 0, "", ""))
        dataset.add(Accommodation("", 0, "", ""))
        dataset.add(Accommodation("", 0, "", ""))

        dataset.add(Food("", "", ""))
        dataset.add(Food("", "", ""))
        dataset.add(Food("", "", ""))

        dataset.add(Entertainment("", "", ""))
        dataset.add(Entertainment("", "", ""))
        dataset.add(Entertainment("", "", ""))

        dataset.add(CarRent("", "", ""))
        dataset.add(CarRent("", "", ""))
        dataset.add(CarRent("", "", ""))

        dataset.add(SPACE)

        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = ItemListAdapter(this, dataset)
    }
}
