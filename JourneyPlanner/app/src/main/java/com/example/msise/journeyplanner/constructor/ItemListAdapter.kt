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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_car.view.*
import kotlinx.android.synthetic.main.item_list_entertainment.view.*
import kotlinx.android.synthetic.main.item_list_food.view.*
import kotlinx.android.synthetic.main.item_list_hotel.view.*
import kotlinx.android.synthetic.main.item_list_ticket.view.*

class ItemListAdapter(var context: Context, var dataset: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val hotelList = arrayListOf<String>(
            "https://pix10.agoda.net/hotelImages/489/489266/489266_17032920250052009110.jpg?s=1024x768",
            "https://www.amtrak.com/content/dam/projects/dotcom/english/public/images/text-with-image-square/hotel-building-pool.jpg/_jcr_content/renditions/cq5dam.web.600.600.jpeg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg0AMriutllpphYg5h9s-NXc3MRnckXDqJS6-MPFw5QRBH_lCw",
            "https://media-api.xogrp.com/images/9a506749-95e9-47cf-857e-5374f2205b93~rs_768.h"
    )

    val foodList = arrayListOf<String>(
            "https://d1vp8nomjxwyf1.cloudfront.net/wp-content/uploads/sites/64/2016/04/07101403/Manotel-Geneve-Restaurants.jpg",
            "http://www.hotelseacliff.com/wp-content/uploads/2017/04/alcove1.jpg",
            "http://www.realdetroitweekly.com/wp-content/uploads/2017/06/Restaurants.jpg",
            "https://www.gannett-cdn.com/-mm-/ac688eec997d2fce10372bf71657297ff863814d/c=171-0-1195-768/local/-/media/2018/07/31/USATODAY/usatsports/247WallSt.com-247WS-482802-restaurant.jpg?width=680&height=510&fit=crop"
    )

    val carList = arrayListOf<String>(
            "https://www.hellopeter.com//static/img/industries/icons/car-rental-icon.jpg",
            "http://www.carzonrent.com/images/346x392x7111822296.png.pagespeed.ic.Jiyk43v6PX.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlI9TqIQctmjuM9UoM-Jxw39Yv7F0_X5HMicKw6M5jYIIS1vOZ",
            "https://cabledahmerbodyshop.com/wp-content/uploads/2018/08/CD-Collision-BOX-RentalCars.jpg"
    )

    val entList = arrayListOf<String>(
            "https://media.blogto.com/articles/20171112-live-theatre-toronto.jpg?w=2048&cmd=resize_then_crop&height=1365&quality=70",
            "https://washington-org.s3.amazonaws.com/s3fs-public/children-viewing-henry-the-elephant-at-natural-history-museum_credit-department-of-state-iip-photo-archive.jpg",
            "https://lovelace-media.imgix.net/getty/481127342.jpg",
            "https://www.wienmuseum.at/fileadmin/user_upload/Slideshows_Locations_Wien_Museum/Wien_Museum_Karlsplatz/Wien_Museum_Karlsplatz_Dauerausstellung_Stock2_Foto_06.jpg"
    )

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
                    val imageUri = hotelList[p1%4]
                    Picasso.get().load(imageUri).resize(115, 120).centerCrop().into(p0.itemView.hotelImage)
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
                    val imageUri = foodList[p1%4]
                    Picasso.get().load(imageUri).resize(115, 120).centerCrop().into(p0.itemView.foodImage)
                    p0.itemView.nameFood.text = food.name
                    p0.itemView.descriptionFood.text = food.desription
                    p0.itemView.priceFood.text = food.price
                }
            }
            is EntertainmentViewHolder -> {
                val ent = dataset[p1]
                if (ent is Entertainment) {
                    val imageUri = entList[p1%4]
                    Picasso.get().load(imageUri).resize(115, 120).centerCrop().into(p0.itemView.entertainmentImage)
                    p0.itemView.nameEnt.text = ent.name
                    p0.itemView.descriptionEnt.text = ent.description
                    p0.itemView.priceEnt.text = ent.price
                }
            }
            is CarViewHolder -> {
                val car = dataset[p1]
                if (car is CarRent) {
                    val imageUri = carList[p1%4]
                    Picasso.get().load(imageUri).resize(115, 120).centerCrop().into(p0.itemView.carImage)
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