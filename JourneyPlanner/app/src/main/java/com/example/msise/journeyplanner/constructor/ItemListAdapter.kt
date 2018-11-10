package com.example.msise.journeyplanner.constructor

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.model.*

class ItemListAdapter(var context: Context, var dataset: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    object HolderTypes {
        const val TICKET = 1
        const val HOTEL = 2
        const val FOOD = 3
        const val ENTERTAINMENT = 4
        const val CAR = 5
        const val SPACE = 6
    }

    override fun getItemViewType(position: Int): Int = when (dataset[position]) {
        is FlightTickets -> HolderTypes.TICKET
        is Accommodation -> HolderTypes.HOTEL
        is Food          -> HolderTypes.FOOD
        is Entertainment -> HolderTypes.ENTERTAINMENT
        is CarRent       -> HolderTypes.CAR
        else             -> HolderTypes.SPACE
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder = when(p1) {
        HolderTypes.TICKET        -> TicketViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_ticket, p0, false))
        HolderTypes.HOTEL         -> HotelViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_hotel, p0, false))
        HolderTypes.FOOD          -> FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_food, p0, false))
        HolderTypes.ENTERTAINMENT -> EntertainmentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_entertainment, p0, false))
        HolderTypes.CAR           -> CarViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_car, p0, false))
        else                      -> SpaceViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_space, p0, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    inner class TicketViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class HotelViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class EntertainmentViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class CarViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class SpaceViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

const val SPACE = "SPACE"