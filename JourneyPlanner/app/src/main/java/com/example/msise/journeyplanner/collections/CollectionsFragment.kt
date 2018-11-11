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
        val my2 = view.findViewById<CardView>(R.id.my2)
        val rec1 = view.findViewById<CardView>(R.id.rec1)
        val rec2 = view.findViewById<CardView>(R.id.rec2)
        val rec3 = view.findViewById<CardView>(R.id.rec3)
        val rec4 = view.findViewById<CardView>(R.id.rec4)
        val rec5 = view.findViewById<CardView>(R.id.rec5)

        my1.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        my2.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        rec1.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        rec2.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        rec3.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        rec4.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }
        rec5.setOnClickListener {
            startActivity(Intent(activity, ConstructorActivity::class.java).putExtra("open", 1))
        }

        return view
    }

    companion object {
        fun newInstance(): CollectionsFragment = CollectionsFragment()
    }
}