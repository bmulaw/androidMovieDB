package com.rkpandey.flixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R

class MovieAdapter(private val context: Context, private val movies: List<Movie>):
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moviePoster = itemView.findViewById<ImageView>(R.id.moviePoster)
        private val movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
        private val movieOverview = itemView.findViewById<TextView>(R.id.movieOverview)

        fun bind(movie: Movie) {
            movieTitle = movie.title
            movieOverview = movie.overview
        }
    }
}