package com.example.msise.journeyplanner.search

import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.msise.journeyplanner.R
import java.util.*

private const val LOCATION = "Location"
private const val TYPE = "Type"

class SearchFragment : Fragment() {
    lateinit var flightFrom: TextView
    lateinit var flightTo: TextView
    lateinit var dateFrom: TextView
    lateinit var dateTo: TextView
    lateinit var adults: TextView
    lateinit var children: TextView
    lateinit var infants: TextView
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        setupViews(view)
        return view
    }

    fun setupViews(view: View) {
        flightFrom = view.findViewById(R.id.card_flight_from)
        flightTo = view.findViewById(R.id.card_flight_to)
        dateFrom = view.findViewById(R.id.card_date_from)
        dateTo = view.findViewById(R.id.card_date_to)
        adults = view.findViewById(R.id.card_passengers_adults)
        children = view.findViewById(R.id.card_passengers_children)
        infants = view.findViewById(R.id.card_passengers_infants)

        flightFrom.setOnClickListener(clickListener)
        flightTo.setOnClickListener(clickListener)
        dateFrom.setOnClickListener(clickListener)
        dateTo.setOnClickListener(clickListener)
        adults.setOnClickListener(clickListener)
        children.setOnClickListener(clickListener)
        infants.setOnClickListener(clickListener)
    }

    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.card_flight_from -> {
                val intent = Intent(context, LocationSearchActivity::class.java)
                intent.putExtra(TYPE, 1)
                startActivityForResult(intent, 1)
            }
            R.id.card_flight_to -> {
                val intent = Intent(context, LocationSearchActivity::class.java)
                intent.putExtra(TYPE, 2)
                startActivityForResult(intent, 2)
            }
            R.id.card_date_from -> {
                val calendar: Calendar = Calendar.getInstance()
                year = calendar.get(Calendar.YEAR)
                month = calendar.get(Calendar.MONTH)
                day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePicker = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateFrom.setText("" + dayOfMonth + " " + (monthOfYear + 1) + " " + year)
                }, year, month, day)
                datePicker.show()
            }
            R.id.card_date_to -> {
                val calendar: Calendar = Calendar.getInstance()
                year = calendar.get(Calendar.YEAR)
                month = calendar.get(Calendar.MONTH)
                day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePicker = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateTo.setText("" + dayOfMonth + " " + (monthOfYear + 1) + " " + year)
                }, year, month, day)
                datePicker.show()
            }
            R.id.card_passengers_adults -> {

            }
            R.id.card_passengers_children -> {

            }
            R.id.card_passengers_infants -> {

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return

        val location = data.getStringExtra(LOCATION)
        if (requestCode == 1) {
            flightFrom.text = location
        } else {
            flightTo.text = location
        }
    }

    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }
}