package com.example.msise.journeyplanner.search

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.constructor.ConstructorActivity
import com.example.msise.journeyplanner.model.ServerResponse
import com.example.msise.journeyplanner.model.TicketsRequest
import com.example.msise.journeyplanner.model.TicketsResponse
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

private const val LOCATION = "Location"
private const val TYPE = "Type"

class SearchFragment : Fragment() {
    lateinit var flightFrom: TextView
    lateinit var flightTo: TextView
    lateinit var dateFrom: TextView
    lateinit var dateTo: TextView
    lateinit var adults: EditText
    lateinit var children: EditText
    lateinit var infants: EditText
    lateinit var continueButton: Button
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
        continueButton = view.findViewById(R.id.fragment_search_button_continue)

        flightFrom.setOnClickListener(clickListener)
        flightTo.setOnClickListener(clickListener)
        dateFrom.setOnClickListener(clickListener)
        dateTo.setOnClickListener(clickListener)
        adults.setOnClickListener(clickListener)
        children.setOnClickListener(clickListener)
        infants.setOnClickListener(clickListener)
        continueButton.setOnClickListener(clickListener)
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
                    dateFrom.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
                }, year, month, day)
                datePicker.show()
            }
            R.id.card_date_to -> {
                val calendar: Calendar = Calendar.getInstance()
                year = calendar.get(Calendar.YEAR)
                month = calendar.get(Calendar.MONTH)
                day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePicker = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateTo.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
                }, year, month, day)
                datePicker.show()
            }
            R.id.card_passengers_adults -> {

            }
            R.id.card_passengers_children -> {

            }
            R.id.card_passengers_infants -> {

            }
            R.id.fragment_search_button_continue -> {

                var adultNumber = 0
                if (adults.text.toString() != "" && adults.text.toString() != null) {
                    adultNumber = adults.text.toString().toInt()
                }

                var childNumber = 0
                if (children.text.toString() != "" && children.text.toString() != null) {
                    childNumber = children.text.toString().toInt()
                }

                var babyNumber = 0
                if (infants.text.toString() != "" && infants.text.toString() != null) {
                    babyNumber = infants.text.toString().toInt()
                }

                val ticket: TicketsRequest = TicketsRequest(
                        origin = flightFrom.text?.toString() ?: "d",
                        destination = flightTo.text?.toString() ?: "d",
                        from = dateFrom.text?.toString() ?: "11/11/2018",
                        to = dateTo.text?.toString() ?: "19/11/2018",
                        adults = adultNumber,
                        child = childNumber,
                        baby = babyNumber)

                val endPoint = ApiClient().getClient().create(ApiInterface::class.java)
                val call = endPoint.sendTicket(ticketsRequest = ticket)
                call.enqueue(object : Callback<ServerResponse>{

                    override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
                        val result = response.body()
                        val tickets = result?.tickets as ArrayList
                        val hotels = result?.hotels as ArrayList

                        startActivity(Intent(activity, ConstructorActivity::class.java)
                                .putParcelableArrayListExtra("tickets", tickets)
                                .putParcelableArrayListExtra("hotels", hotels))
                    }

                    override fun onFailure(call: Call<ServerResponse>, t: Throwable) {

                    }
                })

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