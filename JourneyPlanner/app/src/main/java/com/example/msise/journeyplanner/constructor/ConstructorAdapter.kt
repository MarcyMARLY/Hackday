package com.example.msise.journeyplanner.constructor

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*
import kotlinx.android.synthetic.main.constructor_card_accommodation.view.*
import kotlinx.android.synthetic.main.constructor_card_accommodation_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_car_rent.view.*
import kotlinx.android.synthetic.main.constructor_card_car_rent_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_entertainment.view.*
import kotlinx.android.synthetic.main.constructor_card_entertainment_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_flight_tickets.view.*
import kotlinx.android.synthetic.main.constructor_card_flight_tickets_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_food.view.*
import kotlinx.android.synthetic.main.constructor_card_food_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_insurance.view.*
import kotlinx.android.synthetic.main.constructor_card_insurance_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_top_text.view.*

class ConstructorAdapter(var context: Context, var dataset: ArrayList<Any>, var tickets: ArrayList<FlightTickets>, var hotels: ArrayList<Accommodation>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    object HolderTypes {
        const val TOPTEXT = 1
        const val FLIGHTTICKETS = 2
        const val ACCOMMODATION = 3
        const val FOOD = 4
        const val ENTERTAINMENT = 5
        const val CARRENT = 6
        const val INSURANCE = 7
        const val FLIGHTTICKETSSELECTED = 8
        const val ACCOMMODATIONSELECTED = 9
        const val FOODSELECTED = 10
        const val ENTERTAINMENTSELECTED = 11
        const val CARRENTSELECTED = 12
        const val INSURANCESELECTED = 13
    }

    override fun getItemViewType(position: Int): Int = when(dataset[position]) {
        is Pair<*, *>    -> HolderTypes.TOPTEXT
        FLIGHTTICKETS    -> HolderTypes.FLIGHTTICKETS
        ACCOMMODATION    -> HolderTypes.ACCOMMODATION
        FOOD             -> HolderTypes.FOOD
        ENTERTAINMENT    -> HolderTypes.ENTERTAINMENT
        CARRENT          -> HolderTypes.CARRENT
        INSURANCE        -> HolderTypes.INSURANCE
        is FlightTickets -> HolderTypes.FLIGHTTICKETSSELECTED
        is Accommodation -> HolderTypes.ACCOMMODATIONSELECTED
        is Food          -> HolderTypes.FOODSELECTED
        is Entertainment -> HolderTypes.ENTERTAINMENTSELECTED
        is CarRent       -> HolderTypes.CARRENTSELECTED
        is Insurance     -> HolderTypes.INSURANCESELECTED
        else             -> HolderTypes.TOPTEXT
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder = when(p1) {
        HolderTypes.TOPTEXT               -> TopTextViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_top_text, p0, false))
        HolderTypes.FLIGHTTICKETS         -> FlightTicketsViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_flight_tickets, p0, false))
        HolderTypes.ACCOMMODATION         -> AccommodationViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_accommodation, p0, false))
        HolderTypes.FOOD                  -> FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_food, p0, false))
        HolderTypes.ENTERTAINMENT         -> EntertainmentViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_entertainment, p0, false))
        HolderTypes.CARRENT               -> CarRentViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_car_rent, p0, false))
        HolderTypes.INSURANCE             -> InsuranceViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_insurance, p0, false))
        HolderTypes.FLIGHTTICKETSSELECTED -> FlightTicketsSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_flight_tickets_selected, p0, false))
        HolderTypes.ACCOMMODATIONSELECTED -> AccommodationSelectediewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_accommodation_selected, p0, false))
        HolderTypes.FOODSELECTED          -> FoodSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_food_selected, p0, false))
        HolderTypes.ENTERTAINMENTSELECTED -> EntertainmentSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_entertainment_selected, p0, false))
        HolderTypes.CARRENTSELECTED       -> CarRentSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_car_rent_selected, p0, false))
        HolderTypes.INSURANCESELECTED     -> InsuranceSelectedViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_insurance_selected, p0, false))
        else                              -> TopTextViewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_top_text, p0, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        when (p0) {
            is TopTextViewHolder -> {

            }
            is FlightTicketsSelectedViewHolder -> {
                val ticket = dataset[p1]
                if (ticket is FlightTickets) {
                    p0.itemView.flightTicketsSelectedFirstTime.text = ticket.firstTime
                    p0.itemView.flightTicketsSelectedFirstDescription.text = ticket.firstDesc
                    p0.itemView.flightTicketsSelectedFirstDuration.text = ticket.firstDuration
                    p0.itemView.flightTicketsSelectedSecondTime.text = ticket.secondTime
                    p0.itemView.flightTicketsSelectedSecondDescription.text = ticket.secondDesc
                    p0.itemView.flightTicketsSelectedSecondDuration.text = ticket.secondDuration
                    p0.itemView.flightTicketsSelectedPrice.text = ticket.price
                }
            }
            is AccommodationSelectediewHolder -> {
                val acc = dataset[p1]
                if (acc is Accommodation) {
                    p0.itemView.accommodationSelectedTitle.text = acc.name
                    p0.itemView.accommodationSelectedDescription.text = acc.desription
                    p0.itemView.accommodationSelectedPrice.text = acc.price
                    when(acc.stars) {
                        1 -> {
                            p0.itemView.accommodationSelectedStar1.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar2.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar3.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar4.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar5.visibility = View.INVISIBLE
                        }
                        2 -> {
                            p0.itemView.accommodationSelectedStar1.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar2.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar3.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar4.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar5.visibility = View.INVISIBLE
                        }
                        3 -> {
                            p0.itemView.accommodationSelectedStar1.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar2.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar3.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar4.visibility = View.INVISIBLE
                            p0.itemView.accommodationSelectedStar5.visibility = View.INVISIBLE
                        }
                        4 -> {
                            p0.itemView.accommodationSelectedStar1.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar2.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar3.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar4.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar5.visibility = View.INVISIBLE
                        }
                        5 -> {
                            p0.itemView.accommodationSelectedStar1.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar2.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar3.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar4.visibility = View.VISIBLE
                            p0.itemView.accommodationSelectedStar5.visibility = View.VISIBLE
                        }
                    }
                }
            }
            is FoodSelectedViewHolder -> {
                val food = dataset[p1]
                if (food is Food) {
                    p0.itemView.foodSelectedTitle.text = food.name
                    p0.itemView.foodSelectedDescription.text = food.desription
                    p0.itemView.foodSelectedPrice.text = food.price
                }
            }
            is EntertainmentSelectedViewHolder -> {
                val ent = dataset[p1]
                if (ent is Entertainment) {
                    p0.itemView.entertainmentSelectedTitle.text = ent.name
                    p0.itemView.entertainmentSelectedDescription.text = ent.description
                    p0.itemView.entertainmentSelectedPrice.text = ent.price
                }
            }
            is CarRentSelectedViewHolder -> {
                val car = dataset[p1]
                if (car is CarRent) {
                    p0.itemView.carRentSelectedTitle.text = car.name
                    p0.itemView.carRentSelectedDescription.text = car.desription
                    p0.itemView.carRentSelectedPrice.text = car.price
                }
            }
        }
    }

    inner class TopTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.topTextCard.setOnClickListener {

            }
        }
    }
    inner class FlightTicketsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.flightTicketsCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "tickets")
                        .putParcelableArrayListExtra("tickets", tickets), 1)
            }
        }
    }
    inner class AccommodationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.accommodationCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "hotels")
                        .putParcelableArrayListExtra("hotels", hotels), 2)
            }
        }
    }
    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.foodCard?.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "food"), 3)
            }
        }
    }
    inner class EntertainmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.entertainmentCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "entertainment"), 4)
            }
        }
    }
    inner class CarRentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.carRentCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "car"), 5)
            }
        }
    }
    inner class InsuranceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.insuranceCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "insurance"), 6)
            }
        }
    }
    inner class FlightTicketsSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.flightTicketsSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "tickets")
                        .putParcelableArrayListExtra("tickets", tickets), 1)
            }
        }
    }
    inner class AccommodationSelectediewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.accommodationSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "hotels")
                        .putParcelableArrayListExtra("hotels", hotels), 2)
            }
        }
    }
    inner class FoodSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.foodSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "food"), 3)
            }
        }
    }
    inner class EntertainmentSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.entertainmentSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "entertainment"), 4)
            }
        }
    }
    inner class CarRentSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.carRentSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "car"), 5)
            }
        }
    }
    inner class InsuranceSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.insuranceSelectedCard.setOnClickListener {
                (context as Activity).startActivityForResult(Intent((context as Activity), ItemListActivity::class.java)
                        .putExtra("type", "insuranceCancel"), 7)
            }
        }
    }

}

const val FLIGHTTICKETS = "FLIGHTTICKETS"
const val ACCOMMODATION = "ACCOMMODATION"
const val FOOD = "FOOD"
const val ENTERTAINMENT = "ENTERTAINMENT"
const val CARRENT = "CARRENT"
const val INSURANCE = "INSURANCE"