package com.farro.tmdbclient.presentation.tvshow

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
import com.farro.tmdbclient.data.model.tvshow.TvShow
import com.farro.tmdbclient.databinding.ActivityTvShowBinding
import com.farro.tmdbclient.presentation.OnItemClickListener
import com.farro.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity(), OnItemClickListener {

    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)

        val response = viewModel.getTvShows()
        response.observe(this, Observer {
            if(it != null) {
                adapter = TvShowAdapter(this)
                adapter.setList(it)
                binding.apply {
                    recyclerViewTvShows.setHasFixedSize(false)
                    recyclerViewTvShows.adapter = adapter
                    progressBar.isVisible = false
                }
            }
            else {
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
        val response = viewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    override fun OnItemClick(item: Any) {
        val tvShow: TvShow = item as TvShow
        Toast.makeText(applicationContext, "You clicked ${tvShow.name}", Toast.LENGTH_SHORT).show()
    }
}