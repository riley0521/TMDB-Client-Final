package com.farro.tmdbclient.presentation.di.tvshow

import com.farro.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.farro.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.farro.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory =
        TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
}