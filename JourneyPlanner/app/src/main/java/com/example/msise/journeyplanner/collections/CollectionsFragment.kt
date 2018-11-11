package com.example.msise.journeyplanner.collections

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.constructor.ConstructorActivity

class CollectionsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_collections, container, false)

        val my1 = view.findViewById<CardView>(R.id.my1)

        my1.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }

        return view
    }

    companion object {
        fun newInstance(): CollectionsFragment = CollectionsFragment()
    }
}