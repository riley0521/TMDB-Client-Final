package com.farro.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.farro.tmdbclient.R
import com.farro.tmdbclient.databinding.ActivityHomeBinding
import com.farro.tmdbclient.presentation.artist.ArtistActivity
import com.farro.tmdbclient.presentation.movie.MovieActivity
import com.farro.tmdbclient.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.apply {
            btnArtists.setOnClickListener {
                startActivity(Intent(applicationContext, ArtistActivity::class.java))
            }

            btnMovies.setOnClickListener {
                startActivity(Intent(applicationContext, MovieActivity::class.java))
            }

            btnTvShows.setOnClickListener {
                startActivity(Intent(applicationContext, TvShowActivity::class.java))
            }
        }
    }
}