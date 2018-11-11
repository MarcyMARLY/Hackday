package com.example.msise.journeyplanner.settings

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.journeyplanner.R

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {

    }

    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }
}