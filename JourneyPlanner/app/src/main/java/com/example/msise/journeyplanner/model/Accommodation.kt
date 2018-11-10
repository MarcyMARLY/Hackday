package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class Accommodation(var name: String,
                         var stars: Int,
                         var desription: String,
                         var price: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(stars)
        parcel.writeString(desription)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Accommodation> {
        override fun createFromParcel(parcel: Parcel): Accommodation {
            return Accommodation(parcel)
        }

        override fun newArray(size: Int): Array<Accommodation?> {
            return arrayOfNulls(size)
        }
    }
}