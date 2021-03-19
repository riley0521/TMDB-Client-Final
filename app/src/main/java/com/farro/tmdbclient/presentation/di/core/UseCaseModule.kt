package com.farro.tmdbclient.presentation.di.core

import com.farro.tmdbclient.domain.repository.IArtistRepository
import com.farro.tmdbclient.domain.repository.IMovieRepository
import com.farro.tmdbclient.domain.repository.ITvShowRepository
import com.farro.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: IMovieRepository): GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: IMovieRepository): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: ITvShowRepository): GetTvShowsUseCase =
        GetTvShowsUseCase(tvShowRepository)

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: ITvShowRepository): UpdateTvShowsUseCase =
        UpdateTvShowsUseCase(tvShowRepository)

    @Provides
    fun provideGetArtistUseCase(artistRepository: IArtistRepository): GetArtistsUseCase =
        GetArtistsUseCase(artistRepository)

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: IArtistRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepository)
}