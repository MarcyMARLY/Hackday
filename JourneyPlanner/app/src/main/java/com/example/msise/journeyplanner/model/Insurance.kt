package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class Insurance(var name: String,
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

    companion object CREATOR : Parcelable.Creator<Insurance> {
        override fun createFromParcel(parcel: Parcel): Insurance {
            return Insurance(parcel)
        }

        override fun newArray(size: Int): Array<Insurance?> {
            return arrayOfNulls(size)
        }
    }
}