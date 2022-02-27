package com.rkpandey.flixster

import org.json.JSONArray

data class Movie (val moviedId: Int, val title: String, private val poster: String, val overview: String){
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$poster"

    companion object {
        fun fromJsonArray(movieJSONArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJSONArray.length()) {
                val movieJson = movieJSONArray.getJSONObject(i)
                movies.add(
                    Movie(movieJson.getInt("id"),
                           movieJson.getString("title"),
                           movieJson.getString("poster_path"),
                           movieJson.getString("overview")))
            }
            return movies
        }
    }

}