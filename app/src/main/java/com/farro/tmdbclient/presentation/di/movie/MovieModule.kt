package com.farro.tmdbclient.presentation.di.movie

import com.farro.tmdbclient.domain.usecase.GetMoviesUseCase
import com.farro.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.farro.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory =
        MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
}