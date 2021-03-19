package com.farro.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.farro.tmdbclient.R
import com.farro.tmdbclient.data.model.artist.Artist
import com.farro.tmdbclient.databinding.ActivityArtistBinding
import com.farro.tmdbclient.presentation.OnItemClickListener
import com.farro.tmdbclient.presentation.di.Injector
import kotlinx.android.synthetic.main.activity_artist.*
import javax.inject.Inject

class ArtistActivity : AppCompatActivity(), OnItemClickListener {
    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)

        val response = viewModel.getArtists()
        response.observe(this, Observer {
            if(it != null) {
                adapter = ArtistAdapter(this, ArrayList(it))
                binding.apply {
                    recyclerViewArtists.setHasFixedSize(false)
                    recyclerViewArtists.adapter = adapter
                    progressBar.isVisible = false
                }
            } else {
                binding.progressBar.isVisible = false
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows() {
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateArtists()
        response.observe(this, Observer {
            if (it != null) {
                adapter.updateList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    override fun OnItemClick(item: Any) {
        val artist: Artist = item as Artist
        Toast.makeText(applicationContext, "You clicked ${artist.name}", Toast.LENGTH_SHORT).show()
    }
}