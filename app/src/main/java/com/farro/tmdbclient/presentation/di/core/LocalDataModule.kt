package com.farro.tmdbclient.presentation.di.core

import com.farro.tmdbclient.data.database.ArtistDao
import com.farro.tmdbclient.data.database.MovieDao
import com.farro.tmdbclient.data.database.TvShowDao
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.farro.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.farro.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.farro.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.farro.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieDataSource(movieDao: MovieDao):MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

    @Singleton
    @Provides
    fun provideTvShowDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource =
        TvShowLocalDataSourceImpl(tvShowDao)

    @Singleton
    @Provides
    fun provideArtistDataSource(artistDao : ArtistDao):ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)
}