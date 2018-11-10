package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class CarRent(var name: String,
                   var desription: String,
                   var price: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desription)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CarRent> {
        override fun createFromParcel(parcel: Parcel): CarRent {
            return CarRent(parcel)
        }

        override fun newArray(size: Int): Array<CarRent?> {
            return arrayOfNulls(size)
        }
    }
}