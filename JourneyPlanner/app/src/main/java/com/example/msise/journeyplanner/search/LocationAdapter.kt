package com.example.msise.journeyplanner.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.msise.journeyplanner.R

class LocationAdapter(private val data: List<String>) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    class LocationViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LocationAdapter.LocationViewHolder {
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.simple_list_item_1, parent, false) as TextView

        return LocationViewHolder(textView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder:LocationViewHolder, position: Int) {
        holder.textView.text = data[position]
    }
}