package com.farro.tmdbclient.data.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.farro.tmdbclient.data.model.movie.Movie
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase
    private lateinit var movies: List<Movie>

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()

        movies = listOf(
            Movie(1, "title1", "overview1", "date1", "posterPath1"),
            Movie(2, "title2", "overview2", "date2", "posterPath2"),
            Movie(3, "title3", "overview3", "date3", "posterPath3"),
            Movie(4, "title4", "overview4", "date4", "posterPath4"),
            Movie(5, "title5", "overview5", "date5", "posterPath5")
        )
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        dao.saveMovies(movies)

        val moviesFromDb = dao.getMovies()
        assertThat(moviesFromDb).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesFromDb = dao.getMovies()

        assertThat(moviesFromDb).isEmpty()
    }
}