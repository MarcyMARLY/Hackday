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
                dataset.add(Food("The Wolseley", "As far as classic, good-for-everything establishments go, it’s hard to beat the Wolseley. The breakfasts here are an essential", "Price: $125"))
                dataset.add(Food("E. Pellicci", "No words fill theatregoers with more dread than ‘audience participation’. We need an orchestra pit", "Price: $178"))
                dataset.add(Food("Beigel Bake", "Long before Brick Lane became a hotbed of cereal cafes and artisanal donuts, it was a big centre for the Bengali community and even before that, Jewish community.", "Price: $201"))
                dataset.add(Food("Dishoom Shoreditch", "The first thing you notice about Dishoom is just how busy it is. No matter which location you’re visiting, you’ll almost always a find a queue of people waiting for a table ", "Price: $156"))
            }
            "entertainment" -> {
                dataset.add(Entertainment("Les Miserables", "The West End's longest running musical, Les Misérables has been enjoyed by over 70 million people in 42 countries and in 22 languages around the globe", "Price: $100"))
                dataset.add(Entertainment("Mandela My Life", "Tickets are also available for purchase at the Box Office within Museum on Lower Ground Floor. ", "Price: $235"))
                dataset.add(Entertainment("Disney Park", "Disney, Universal Studios, Busch Gardens, Sea World and all other attractions available. If you are looking for a fantastic deal on cheap Disney  vacation of a lifetime", "Price: $178"))
                dataset.add(Entertainment("Fantastic Fan Screening Event", "'Fantastic Beasts: The Crimes Of Grindelwald' sees the powerful dark wizard having escaped custody, and in the process of gathering his followers.", "Price: $98"))
            }
            "car" -> {
                dataset.add(CarRent("EuropeCar", "Choose your vehicle from our new models ranging from affordable to luxury", "Price: $110"))
                dataset.add(CarRent("CarBoss", "Become a privilege member to unlock rewards", "Price: $89"))
                dataset.add(CarRent("EconomyCarRentals", "One of our top priorities is to adjust each package we offer to our customer’s exact needs. We offer a variety of options that can enhance your experience, always according to your necessities, and help you get the best out of your holidays or your business trip.", "Price: $56"))
                dataset.add(CarRent("Prime Car Rent", "Dropping a car off with Prime Car Rent is quick and easy. We work hard to find you the best prices - book with us and get the best price on a Prime Car Rent rental, guaranteed.", "Price: $100"))
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
            "generate" -> {
                setResult(Activity.RESULT_OK, Intent())
                finish()
            }
        }

        dataset.add(SPACE)

        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = ItemListAdapter(this, dataset)
    }
}
