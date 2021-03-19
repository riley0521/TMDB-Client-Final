package com.farro.tmdbclient.domain.usecase

import com.farro.tmdbclient.data.model.movie.Movie
import com.farro.tmdbclient.domain.repository.IMovieRepository

class GetMoviesUseCase(private val movieRepository: IMovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}