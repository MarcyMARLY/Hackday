package com.example.msise.journeyplanner.search

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.msise.journeyplanner.R
import android.widget.ListAdapter
import android.support.v7.widget.SearchView
import android.util.Log
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import kotlinx.coroutines.experimental.launch
import retrofit2.Call

private const val LOCATION = "Location"

class LocationSearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var toolbar: Toolbar? = null
    lateinit var recyclerView: ListView
    private val TAG = LocationSearchActivity::class.java!!.simpleName
    var arrays: MutableList<String> = mutableListOf()
    lateinit var adapter: ArrayAdapter<String>
    lateinit var endPoint: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_search)
        endPoint = ApiClient().getClient().create(ApiInterface::class.java)
        setupCities()
    }

    private fun setupCities() {
        val call: Call<List<String>> = endPoint.getCities()
        val s = launch {
            val res = call.execute()?.body()
            if (res != null) {
                arrays.addAll(res)
                runOnUiThread {
                    setupViews()
                }
            }
            Log.e("LLLL", res.toString())
        }
    }

    private fun setupViews() {
        toolbar = findViewById(R.id.activity_search_toolbar)
        recyclerView = findViewById(R.id.activity_search_rv)
        recyclerView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent()
            intent.putExtra(LOCATION, recyclerView.getItemAtPosition(position).toString())
            setResult(RESULT_OK, intent)
            finish()
        }
        adapter = ArrayAdapter(this, R.layout.simple_list_item_1, arrays)
        recyclerView.adapter = adapter as ListAdapter?
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = "Location"
        toolbar?.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)
        val searchMenuItem = menu.findItem(R.id.menu_toolbar_search)
        val searchView = searchMenuItem.actionView as SearchView?
        searchView?.queryHint = "Search"
        searchView?.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {

        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        adapter.filter.filter(text)

        return true
    }
}
