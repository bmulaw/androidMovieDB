package com.codepath.bestsellerlistapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codepath.bestsellerlistapp.R.id
import com.codepath.bestsellerlistapp.R.layout
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler

private const val TAG = "MainActivity"
private const val URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=add0f760a52cfaca1a0b22c2703d315f"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
//        val supportFragmentManager = supportFragmentManager
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(id.content, BestSellerBooksFragment(), null).commit()

        val client = AsyncHttpClient()
        client.get(URL, object: JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                // called when response HTTP status is "200 OK"
                Log.i(TAG, "onSuccess: JSON data $json")

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String errorResponse, Throwable t) {
                // called when response
                Log.e(TAG, "onFailure $statusCode")
            }
        })

    }
}