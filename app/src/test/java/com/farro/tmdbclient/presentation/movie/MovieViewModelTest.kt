package com.farro.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.farro.tmdbclient.data.repository.movie.FakeMovieRepository
import com.farro.tmdbclient.domain.repository.IMovieRepository
import com.farro.tmdbclient.domain.usecase.GetMoviesUseCase
import com.farro.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.farro.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var repository: IMovieRepository

    private lateinit var getMoviesUseCase : GetMoviesUseCase
    private lateinit var updateMoviesUseCase : UpdateMoviesUseCase

    @Before
    fun setUp() {
        repository = FakeMovieRepository()
        getMoviesUseCase = GetMoviesUseCase(repository)
        updateMoviesUseCase = UpdateMoviesUseCase(repository)
        movieViewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMoviesTest_returnCurrentList() = runBlocking {
        val result = movieViewModel.getMovies().getOrAwaitValue()
        assertThat(result?.size).isEqualTo(5)
    }

    @Test
    fun updateMoviesTest_appendNewMovies() = runBlocking {
        val result = movieViewModel.updateMovies().getOrAwaitValue()
        assertThat(result?.size).isEqualTo(7)
    }
}