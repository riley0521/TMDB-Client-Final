package com.farro.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.farro.tmdbclient.data.model.tvshow.TvShow
import com.bumptech.glide.Glide
import com.farro.tmdbclient.R
import com.farro.tmdbclient.databinding.ListItemBinding
import com.farro.tmdbclient.presentation.OnItemClickListener


class TvShowAdapter(
    private val listener: OnItemClickListener
):RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var tvShows = ArrayList<TvShow>()

    fun setList(tvShowList:List<TvShow>){
         tvShows.clear()
         tvShows.addAll(tvShowList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int = tvShows.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
       holder.bind(tvShows[position])
    }

    inner class TvShowViewHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root){

        init {
            binding.apply {
                cardView.setOnClickListener {
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION) {
                        val tvShow = tvShows[position]
                        listener.OnItemClick(tvShow)
                    }
                }
            }
        }

        fun bind(tvShow:TvShow){
            binding.tvTitle.text = tvShow.name
            binding.tvDescription.text = tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }

    }
}



