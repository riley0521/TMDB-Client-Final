package com.farro.tmdbclient.data.repository.movie

import com.farro.tmdbclient.data.model.movie.Movie
import com.farro.tmdbclient.domain.repository.IMovieRepository

class FakeMovieRepository: IMovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "title1", "overview1", "date1", "posterPath1"))
        movies.add(Movie(2, "title2", "overview2", "date2", "posterPath2"))
        movies.add(Movie(3, "title3", "overview3", "date3", "posterPath3"))
        movies.add(Movie(4, "title4", "overview4", "date4", "posterPath4"))
        movies.add(Movie(5, "title5", "overview5", "date5", "posterPath5"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.add(Movie(6, "title6", "overview6", "date6", "posterPath6"))
        movies.add(Movie(7, "title7", "overview7", "date7", "posterPath7"))
        return movies
    }

}