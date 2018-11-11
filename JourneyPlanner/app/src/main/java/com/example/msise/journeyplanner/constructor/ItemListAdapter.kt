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
import kotlinx.android.synthetic.main.item_list_car.view.*
import kotlinx.android.synthetic.main.item_list_entertainment.view.*
import kotlinx.android.synthetic.main.item_list_food.view.*
import kotlinx.android.synthetic.main.item_list_hotel.view.*
import kotlinx.android.synthetic.main.item_list_ticket.view.*

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
        when(p0) {
            is TicketViewHolder -> {
                val ticket = dataset[p1]
                if (ticket is FlightTickets) {
                    p0.itemView.firstTime.text = ticket.firstTime
                    p0.itemView.firstDescription.text = ticket.firstDesc
                    p0.itemView.firstDuration.text = ticket.firstDuration
                    p0.itemView.secondTime.text = ticket.secondTime
                    p0.itemView.secondDescription.text = ticket.secondDesc
                    p0.itemView.secondDuration.text = ticket.secondDuration
                    p0.itemView.priceTicket.text = ticket.price
                }
            }
            is HotelViewHolder -> {
                val hotel = dataset[p1]
                if (hotel is Accommodation) {
                    p0.itemView.nameHotel.text = hotel.name
                    p0.itemView.descriptionHotel.text = hotel.desription
                    p0.itemView.priceHotel.text = hotel.price
                    when(hotel.stars) {
                        1 -> {
                            p0.itemView.star1.visibility = View.VISIBLE
                            p0.itemView.star2.visibility = View.INVISIBLE
                            p0.itemView.star3.visibility = View.INVISIBLE
                            p0.itemView.star4.visibility = View.INVISIBLE
                            p0.itemView.star5.visibility = View.INVISIBLE
                        }
                        2 -> {
                            p0.itemView.star1.visibility = View.VISIBLE
                            p0.itemView.star2.visibility = View.VISIBLE
                            p0.itemView.star3.visibility = View.INVISIBLE
                            p0.itemView.star4.visibility = View.INVISIBLE
                            p0.itemView.star5.visibility = View.INVISIBLE
                        }
                        3 -> {
                            p0.itemView.star1.visibility = View.VISIBLE
                            p0.itemView.star2.visibility = View.VISIBLE
                            p0.itemView.star3.visibility = View.VISIBLE
                            p0.itemView.star4.visibility = View.INVISIBLE
                            p0.itemView.star5.visibility = View.INVISIBLE
                        }
                        4 -> {
                            p0.itemView.star1.visibility = View.VISIBLE
                            p0.itemView.star2.visibility = View.VISIBLE
                            p0.itemView.star3.visibility = View.VISIBLE
                            p0.itemView.star4.visibility = View.VISIBLE
                            p0.itemView.star5.visibility = View.INVISIBLE
                        }
                        5 -> {
                            p0.itemView.star1.visibility = View.VISIBLE
                            p0.itemView.star2.visibility = View.VISIBLE
                            p0.itemView.star3.visibility = View.VISIBLE
                            p0.itemView.star4.visibility = View.VISIBLE
                            p0.itemView.star5.visibility = View.VISIBLE
                        }
                    }
                }
            }
            is FoodViewHolder -> {
                val food = dataset[p1]
                if (food is Food) {
                    p0.itemView.nameFood.text = food.name
                    p0.itemView.descriptionFood.text = food.desription
                    p0.itemView.priceFood.text = food.price
                }
            }
            is EntertainmentViewHolder -> {
                val ent = dataset[p1]
                if (ent is Entertainment) {
                    p0.itemView.nameEnt.text = ent.name
                    p0.itemView.descriptionEnt.text = ent.description
                    p0.itemView.priceEnt.text = ent.price
                }
            }
            is CarViewHolder -> {
                val car = dataset[p1]
                if (car is CarRent) {
                    p0.itemView.nameCar.text = car.name
                    p0.itemView.descriptionCar.text = car.desription
                    p0.itemView.priceCar.text = car.price
                }
            }
        }
    }

    inner class TicketViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.ticketCard.setOnClickListener {
                val ticket = dataset[adapterPosition]
                if (ticket is FlightTickets) {
                    (context as Activity).setResult(Activity.RESULT_OK, Intent()
                            .putExtra("ticket", ticket))
                    (context as Activity).finish()
                }
            }
        }
    }
    inner class HotelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.hotelCard.setOnClickListener {
                val hotel = dataset[adapterPosition]
                if (hotel is Accommodation) {
                    (context as Activity).setResult(Activity.RESULT_OK, Intent()
                            .putExtra("hotel", hotel))
                    (context as Activity).finish()
                }
            }
        }
    }
    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.foodCard.setOnClickListener {
                val food = dataset[adapterPosition]
                if (food is Food) {
                    (context as Activity).setResult(Activity.RESULT_OK, Intent()
                            .putExtra("food", food))
                    (context as Activity).finish()
                }
            }
        }
    }
    inner class EntertainmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.entertainmentCard.setOnClickListener {
                val ent = dataset[adapterPosition]
                if (ent is Entertainment) {
                    (context as Activity).setResult(Activity.RESULT_OK, Intent()
                            .putExtra("entertainment", ent))
                    (context as Activity).finish()
                }
            }
        }
    }
    inner class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.carCard.setOnClickListener {
                val car = dataset[adapterPosition]
                if (car is CarRent) {
                    (context as Activity).setResult(Activity.RESULT_OK, Intent()
                            .putExtra("car", car))
                    (context as Activity).finish()
                }
            }
        }
    }
    inner class SpaceViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

const val SPACE = "SPACE"