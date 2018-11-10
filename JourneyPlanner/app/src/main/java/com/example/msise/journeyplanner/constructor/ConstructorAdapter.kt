package com.example.msise.journeyplanner.constructor

import android.content.Context
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
import kotlinx.android.synthetic.main.constructor_card_flight_tickets_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_food.view.*
import kotlinx.android.synthetic.main.constructor_card_food_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_insurance.view.*
import kotlinx.android.synthetic.main.constructor_card_insurance_selected.view.*
import kotlinx.android.synthetic.main.constructor_card_top_text.view.*

class ConstructorAdapter(var context: Context, var dataset: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        HolderTypes.ACCOMMODATIONSELECTED -> AccommodationVSelectediewHolder(LayoutInflater.from(context).inflate(R.layout.constructor_card_accommodation_selected, p0, false))
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

    }

    inner class TopTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.topTextCard.setOnClickListener {

            }
        }
    }
    inner class FlightTicketsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.flightTicketsSelectedCard.setOnClickListener {

            }
        }
    }
    inner class AccommodationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.accommodationCard.setOnClickListener {

            }
        }
    }
    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.foodCard.setOnClickListener {

            }
        }
    }
    inner class EntertainmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.entertainmentCard.setOnClickListener {

            }
        }
    }
    inner class CarRentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.carRentCard.setOnClickListener {  }

        }
    }
    inner class InsuranceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.insuranceCard.setOnClickListener {

            }
        }
    }
    inner class FlightTicketsSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.flightTicketsSelectedCard.setOnClickListener {

            }
        }
    }
    inner class AccommodationVSelectediewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.accommodationSelectedCard.setOnClickListener {

            }
        }
    }
    inner class FoodSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.foodSelectedCard.setOnClickListener {

            }
        }
    }
    inner class EntertainmentSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.entertainmentSelectedCard.setOnClickListener {

            }
        }
    }
    inner class CarRentSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.carRentSelectedCard.setOnClickListener {

            }
        }
    }
    inner class InsuranceSelectedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.insuranceSelectedCard.setOnClickListener {

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