package com.farro.tmdbclient.data.repository.movie.datasource

import com.farro.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
   suspend fun getMovies(): Response<MovieList>
}