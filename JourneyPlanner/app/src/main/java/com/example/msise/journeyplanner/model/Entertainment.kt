package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class Entertainment(var name: String,
                         var description: String,
                         var price: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Entertainment> {
        override fun createFromParcel(parcel: Parcel): Entertainment {
            return Entertainment(parcel)
        }

        override fun newArray(size: Int): Array<Entertainment?> {
            return arrayOfNulls(size)
        }
    }
}