package com.farro.tmdbclient.presentation.di.core

import com.farro.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.farro.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.farro.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.farro.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.farro.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowDataSource(): TvShowCacheDataSource = TvShowCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()
}