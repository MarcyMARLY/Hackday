package com.example.msise.journeyplanner.constructor

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*
import kotlinx.android.synthetic.main.activity_constructor.*
import kotlin.math.roundToInt

class ConstructorActivity : AppCompatActivity() {

    lateinit var dataset: ArrayList<Any>
    var ticketsCost = 0
    var accommodationCost = 0
    var foodCost = 0
    var entCost = 0
    var carCost = 0
    var insuranceCost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constructor)

        val tickets = intent.getParcelableArrayListExtra<TicketsResponse>("tickets")
        val hotels = intent.getParcelableArrayListExtra<Hotel>("hotels")

        dataset = ArrayList()

        val save: TextView = findViewById(R.id.save)
        save.setOnClickListener{
            finish()
        }

        val ticketsDataset = ArrayList<FlightTickets>()
        if (tickets != null) {
            for (t in 0..(tickets.size-1)) {
                val ticket = tickets[t]
                val flightTicket = FlightTickets(ticket.dateFrom,
                        ticket.flyFrom + " - " + ticket.flyTo + ", " + ticket.airlineFrom,
                        ticket.flyDuration,
                        ticket.dateTo,
                        ticket.flyTo + " - " + ticket.flyFrom + ", " + ticket.airlineFrom,
                        ticket.returnDuration,
                        "Price: $" + ticket.price.toString())
                ticketsDataset.add(flightTicket)
            }
        }

        val hotelsDataset = ArrayList<Accommodation>()
        if (hotels != null) {
            for (h in 0..(hotels.size-1)) {
                val hotel = hotels[h]
                val accommodation = Accommodation(hotel.hotelName, hotel.stars.toDouble().roundToInt(), hotel.address + ", " + hotel.cityName, "Price: $" + hotel.price.toString())
                hotelsDataset.add(accommodation)
            }
        }

        dataset.add(Pair("Generate by Budget", 1))
        dataset.add(FLIGHTTICKETS)
        dataset.add(ACCOMMODATION)
        dataset.add(FOOD)
        dataset.add(ENTERTAINMENT)
        dataset.add(CARRENT)
        dataset.add(INSURANCE)

        constructorRecyclerView.layoutManager = LinearLayoutManager(this)
        constructorRecyclerView.adapter = ConstructorAdapter(this, dataset, ticketsDataset, hotelsDataset)
    }

    fun calculateCost() : Int {
        return ticketsCost + accommodationCost + foodCost + entCost + carCost + insuranceCost
    }

    fun generateByBudget() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<FlightTickets>("ticket")
                    dataset[1] = result!!
                    ticketsCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            2 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<Accommodation>("hotel")
                    dataset[2] = result!!
                    accommodationCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            3 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<Food>("food")
                    dataset[3] = result!!
                    foodCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            4 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<Entertainment>("entertainment")
                    dataset[4] = result!!
                    entCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            5 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<CarRent>("car")
                    dataset[5] = result!!
                    carCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            6 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getParcelableExtra<Insurance>("insurance")
                    dataset[6] = result!!
                    insuranceCost = result.price.substring(8).toDouble().roundToInt()
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
            7 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result = data?.getStringExtra("insurance")
                    dataset[6] = result!!
                    insuranceCost = 0
                    val curCost = "Cost: $" + calculateCost().toString()
                    cost.text = curCost
                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}
