package com.example.youtuberecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        // data source or ui table delicate(iOs) terms
        // helps rend out the items inside your list, the list being recyclerView.
        //recyclerView_main.adapter = MainAdapter()
        // moved to the onreponse section

        fetchJson()

    }

    fun fetchJson() {

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        // creating a new request builder to request the info from the url above.
        val request = Request.Builder().url(url).build()

        //construct a new client
        val client = OkHttpClient()

        // this is on the main ui thread, android doesn't allow you to use .execute
        // from the main thread. which is why .enqueue() is user here first.
        client.newCall(request).enqueue(object: Callback {

            // takes back the Response from the http request
            override fun onResponse(call: Call, response: Response) {

                // holds the body of the response from the http request
                // solved error by adding java8 compile options in gradle.

                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                // in order to get a type for a class in kotlin you need to pass in ::class.java
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                // this allow the code to run on the same thread as the Ui elements / Layout Manager
                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
               throw IOException ("Failed to execute request $request")
            }
        })
    }
}