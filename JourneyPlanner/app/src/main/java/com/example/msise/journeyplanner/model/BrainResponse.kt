package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable

data class BrainResponse (var collection: Int) :Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        if (parcel == null) {

            return
        }
        parcel.writeString(collection.toString())
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<BrainResponse> {
        override fun createFromParcel(parcel: Parcel): BrainResponse {
            return BrainResponse(parcel)
        }

        override fun newArray(size: Int): Array<BrainResponse?> {
            return arrayOfNulls(size)
        }
    }
}