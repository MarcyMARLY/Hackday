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
    lateinit var ticketGenerated: FlightTickets
    lateinit var hotelGenerated: Accommodation
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
        val open = intent.getIntExtra("open", 0)

        val ticketsDataset = ArrayList<FlightTickets>()
        val hotelsDataset = ArrayList<Accommodation>()

        dataset = ArrayList()

        if (open == 1) {
            openJourney()
        } else {


            val save: TextView = findViewById(R.id.save)
            save.setOnClickListener {
                finish()
            }

            if (tickets != null) {
                for (t in 0..(tickets.size - 1)) {
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
                ticketGenerated = ticketsDataset[0]
            }

            if (hotels != null) {
                for (h in 0..(hotels.size - 1)) {
                    val hotel = hotels[h]
                    val accommodation = Accommodation(hotel.hotelName, hotel.stars.toDouble().roundToInt(), hotel.address + ", " + hotel.cityName, "Price: $" + hotel.price.toString())
                    hotelsDataset.add(accommodation)
                }
                hotelGenerated = hotelsDataset[0]
            }

            dataset.add(Pair("Generate by Budget", 1))
            dataset.add(FLIGHTTICKETS)
            dataset.add(ACCOMMODATION)
            dataset.add(FOOD)
            dataset.add(ENTERTAINMENT)
            dataset.add(CARRENT)
            dataset.add(INSURANCE)
        }

        constructorRecyclerView.layoutManager = LinearLayoutManager(this)
        constructorRecyclerView.adapter = ConstructorAdapter(this, dataset, ticketsDataset, hotelsDataset)
    }

    fun calculateCost() : Int {
        return ticketsCost + accommodationCost + foodCost + entCost + carCost + insuranceCost
    }

    fun openJourney() {
        dataset.add(Pair("Generate by Budget", 1))
        dataset.add(FlightTickets("13:15 - 21:40", "TSE - LAA, UN", "8h 25m", "09:00 - 18:00", "LAA - TSE, UN", "9h 00m", "Price: $600"))
        dataset.add(Accommodation("Meridian Resort", 4, "Sent Luis Avenue 59", "Price: $600.00"))
        dataset.add(Food("Italian Senioro", "Whereiswaldo Street 46", "Price: $30.00"))
        dataset.add(Entertainment("Sweet Fest", "Dominica Square, lots of sweet food", "Price: $15.20"))
        dataset.add(CarRent("Honda A9", "Middle class hetchback", "Price: $40.00"))
        dataset.add(Insurance("Basic Health Pack", "Collects the most popular medical insurance", "Price: $25.00"))

        constructorRecyclerView.adapter?.notifyDataSetChanged()
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
            8 -> {
                if (resultCode == Activity.RESULT_OK) {
                    dataset[1] = ticketGenerated
                    dataset[2] = hotelGenerated
                    dataset[3] = Food("Italian Senioro", "Whereiswaldo Street 46", "Price: $30.00")
                    dataset[4] = Entertainment("Sweet Fest", "Dominica Square, lots of sweet food", "Price: $15.20")
                    dataset[5] = CarRent("Honda A9", "Middle class hetchback", "Price: $40.00")
                    dataset[6] = Insurance("Basic Health Pack", "Collects the most popular medical insurance", "Price: $25.00")

                    ticketsCost = ticketGenerated.price.substring(8).toDouble().roundToInt()
                    accommodationCost = hotelGenerated.price.substring(8).toDouble().roundToInt()


                    constructorRecyclerView.adapter?.notifyDataSetChanged()
                    val curCost = "Cost: $" + (calculateCost()+30+15+40+25).toString()
                    cost.text = curCost
                }
            }
        }
    }
}
