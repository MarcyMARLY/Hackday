package com.example.msise.journeyplanner.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Hotel(
        @SerializedName("hotelName") var hotelName: String,
        @SerializedName("stars") var stars: String,
        @SerializedName("price") var price: Double,
        @SerializedName("cityName") var cityName: String,
        @SerializedName("countryCode") var countryCode: String,
        @SerializedName("countryName") var countryName: String,
        @SerializedName("address") var address: String,
        @SerializedName("location") var location: String,
        @SerializedName("url") var url: String?,
        @SerializedName("latitude") var latitude: String,
        @SerializedName("longitude") var longitude: String,
        @SerializedName("image") var image: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        if (parcel == null) {

            return
        }
        parcel.writeString(hotelName)
        parcel.writeString(stars)
        parcel.writeDouble(price)
        parcel.writeString(cityName)
        parcel.writeString(countryCode)
        parcel.writeString(countryName)
        parcel.writeString(address)
        parcel.writeString(location)
        parcel.writeString(url)
        parcel.writeString(latitude)
        parcel.writeString(longitude)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {

        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hotel> {
        override fun createFromParcel(parcel: Parcel): Hotel {
            return Hotel(parcel)
        }

        override fun newArray(size: Int): Array<Hotel?> {
            return arrayOfNulls(size)
        }
    }
}