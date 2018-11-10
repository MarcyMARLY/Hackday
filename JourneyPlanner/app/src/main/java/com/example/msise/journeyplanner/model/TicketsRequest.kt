package com.example.msise.journeyplanner.model

import com.google.gson.annotations.SerializedName

class TicketsRequest(@SerializedName("origin") var origin: String,
                     @SerializedName("destination") var destination: String,
                     @SerializedName("from") var from: String,
                     @SerializedName("to") var to: String,
                     @SerializedName("adults") var adults: Int,
                     @SerializedName("child") var child: Int,
                     @SerializedName("baby") var baby: Int
                     )
