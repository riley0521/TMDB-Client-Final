package com.farro.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.farro.tmdbclient.data.model.movie.Movie
import com.bumptech.glide.Glide
import com.farro.tmdbclient.R
import com.farro.tmdbclient.databinding.ListItemBinding
import com.farro.tmdbclient.presentation.OnItemClickListener


class MovieAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies = ArrayList<Movie>()

    fun setList(movieList: List<Movie>) {
        movies.clear()
        movies.addAll(movieList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                cardView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val movie = movies[position]
                        listener.OnItemClick(movie)
                    }
                }
            }
        }

        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title
            binding.tvDescription.text = movie.overview
            val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

        }

    }
}


