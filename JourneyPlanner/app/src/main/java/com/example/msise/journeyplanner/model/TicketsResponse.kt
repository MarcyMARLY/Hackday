package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class TicketsResponse( var price: Int,
                            var flyDuration: String,
                            var returnDuration: String,
                            var countryTo: String,
                            var countryFrom: String,
                            var cityFrom: String,
                            var cityTo: String,
                            var airlineTo: String,
                            var airlineFrom: String,
                            var flyFrom: String,
                            var flyTo: String,
                            var dateFrom: String,
                            var dateTo: String,
                            var image: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(price)
        parcel.writeString(flyDuration)
        parcel.writeString(returnDuration)
        parcel.writeString(countryTo)
        parcel.writeString(countryFrom)
        parcel.writeString(cityFrom)
        parcel.writeString(cityTo)
        parcel.writeString(airlineTo)
        parcel.writeString(airlineFrom)
        parcel.writeString(flyFrom)
        parcel.writeString(flyTo)
        parcel.writeString(dateFrom)
        parcel.writeString(dateTo)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TicketsResponse> {
        override fun createFromParcel(parcel: Parcel): TicketsResponse {
            return TicketsResponse(parcel)
        }

        override fun newArray(size: Int): Array<TicketsResponse?> {
            return arrayOfNulls(size)
        }
    }

}

