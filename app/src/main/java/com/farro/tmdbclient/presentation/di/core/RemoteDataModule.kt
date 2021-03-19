package com.farro.tmdbclient.presentation.di.core

import com.farro.tmdbclient.data.api.TMDBService
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.farro.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.farro.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.farro.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.farro.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieDataSource(service: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(service, apiKey)

    @Singleton
    @Provides
    fun provideTvShowDataSource(service: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(service, apiKey)

    @Singleton
    @Provides
    fun provideArtistDataSource(service: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(service, apiKey)
}