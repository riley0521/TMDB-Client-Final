package com.farro.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.farro.tmdbclient.data.model.artist.Artist
import com.bumptech.glide.Glide
import com.farro.tmdbclient.R
import com.farro.tmdbclient.databinding.ListItemBinding
import com.farro.tmdbclient.presentation.OnItemClickListener


class ArtistAdapter(
    private val listener: OnItemClickListener,
    private var artists: ArrayList<Artist>
) : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    fun updateList(artistList: List<Artist>) {
        artists.clear()
        artists = ArrayList(artistList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistViewHolder(binding)
    }

    override fun getItemCount(): Int = artists.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    inner class ArtistViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                cardView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val artist = artists[position]
                        listener.OnItemClick(artist)
                    }
                }
            }
        }

        fun bind(artist: Artist) {
            binding.tvTitle.text = artist.name
            binding.tvDescription.text = artist.popularity.toString()
            val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .error(R.drawable.ic_error)
                .into(binding.imageView)
        }

    }
}


