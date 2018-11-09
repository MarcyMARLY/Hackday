package com.example.msise.journeyplanner.search

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R

class SearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_search, container, false)

    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }
}