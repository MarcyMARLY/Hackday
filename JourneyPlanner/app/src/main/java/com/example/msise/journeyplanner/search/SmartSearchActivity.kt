package com.example.msise.journeyplanner.search

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.msise.journeyplanner.R
import com.example.msise.journeyplanner.constructor.ConstructorActivity
import com.example.msise.journeyplanner.model.BrainResponse
import com.example.msise.journeyplanner.model.Description
import com.example.msise.journeyplanner.model.ServerResponse
import com.example.msise.journeyplanner.model.TicketsRequest
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SPEECH_REQUEST_CODE = 0

class SmartSearchActivity : AppCompatActivity() {
    lateinit var description: EditText
    lateinit var buttonGenerate: Button
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_search)
        setupViews()
    }

    private fun setupViews() {
        description = findViewById(R.id.fragment_smart_search_form)
        buttonGenerate = findViewById(R.id.fragment_smart_search_button_continue)
        fab = findViewById(R.id.fragment_smart_search_fab)

        buttonGenerate.setOnClickListener {
            if (description.text != null) {
                val endPoint = ApiClient().getClient().create(ApiInterface::class.java)
                val call = endPoint.sendBrainDescription(Description(description.text.toString()))

                call.enqueue(object : Callback<BrainResponse> {
                    override fun onResponse(call: Call<BrainResponse>?, response: Response<BrainResponse>?) {
                        val result = response?.body()
//                        val tickets = result?.tickets as ArrayList?
//                        val hotels = result?.hotels as ArrayList?

                        startActivity(Intent(applicationContext, ConstructorActivity::class.java))
//                                .putParcelableArrayListExtra("tickets", tickets)
//                                .putParcelableArrayListExtra("hotels", hotels))
                    }

                    override fun onFailure(call: Call<BrainResponse>?, t: Throwable?) {
                    }
                })
            }
        }
        fab.setOnClickListener {
            displaySpeechRecognizer()
        }
    }

    private fun displaySpeechRecognizer() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        }
        startActivityForResult(intent, SPEECH_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                        results[0]
                    }
            Log.v("spokenText", spokenText)
            if (spokenText != null) {
                description.setText(spokenText)
            }
        }
    }
}
