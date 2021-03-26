package com.farro.tmdbclient.presentation.movie

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
import com.farro.tmdbclient.data.model.movie.Movie
import com.farro.tmdbclient.databinding.ActivityMovieBinding
import com.farro.tmdbclient.presentation.OnItemClickListener
import com.farro.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity(), OnItemClickListener {

    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        viewModel=ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)

        val response = viewModel.getMovies()
        response.observe(this, Observer {
            if(it != null) {
                adapter = MovieAdapter(this)
                adapter.setList(it)
                binding.apply {
                    recyclerViewMovies.setHasFixedSize(false)
                    recyclerViewMovies.adapter = adapter
                    progressBar.isVisible = false
                }
            } else {
                binding.progressBar.isVisible = false
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
      binding.progressBar.visibility = View.VISIBLE
      val response = viewModel.updateMovies()
      response.observe(this, Observer {
        if(it!=null){
          adapter.setList(it)
          adapter.notifyDataSetChanged()
          binding.progressBar.visibility = View.GONE
        }else{
          binding.progressBar.visibility = View.GONE
        }
      })
    }

    override fun OnItemClick(item: Any) {
        val movie: Movie = item as Movie
        Toast.makeText(applicationContext, "You clicked ${movie.title}", Toast.LENGTH_SHORT).show()
    }

}