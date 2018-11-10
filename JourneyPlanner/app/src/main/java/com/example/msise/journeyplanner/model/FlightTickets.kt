package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class FlightTickets(var firstTime: String,
                         var firstDesc: String,
                         var firstDuration: String,
                         var secondTime: String,
                         var secondDesc: String,
                         var secondDuration: String,
                         var price: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstTime)
        parcel.writeString(firstDesc)
        parcel.writeString(firstDuration)
        parcel.writeString(secondTime)
        parcel.writeString(secondDesc)
        parcel.writeString(secondDuration)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FlightTickets> {
        override fun createFromParcel(parcel: Parcel): FlightTickets {
            return FlightTickets(parcel)
        }

        override fun newArray(size: Int): Array<FlightTickets?> {
            return arrayOfNulls(size)
        }
    }
}