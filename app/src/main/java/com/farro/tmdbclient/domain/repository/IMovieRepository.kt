package com.farro.tmdbclient.domain.repository

import com.farro.tmdbclient.data.model.movie.Movie

interface IMovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}