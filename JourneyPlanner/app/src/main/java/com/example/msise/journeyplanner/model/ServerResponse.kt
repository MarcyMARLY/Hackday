package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class ServerResponse (var tickets: List<TicketsResponse>, var hotels: List<Hotel>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.createTypedArrayList(TicketsResponse),
            parcel.createTypedArrayList(Hotel)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(tickets)
        parcel.writeTypedList(hotels)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServerResponse> {
        override fun createFromParcel(parcel: Parcel): ServerResponse {
            return ServerResponse(parcel)
        }

        override fun newArray(size: Int): Array<ServerResponse?> {
            return arrayOfNulls(size)
        }
    }
}