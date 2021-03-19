package com.farro.tmdbclient.presentation.di.core

import com.farro.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.farro.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.farro.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.farro.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.farro.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.farro.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.farro.tmdbclient.domain.repository.IArtistRepository
import com.farro.tmdbclient.domain.repository.IMovieRepository
import com.farro.tmdbclient.domain.repository.ITvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): IMovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): ITvShowRepository =
        TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): IArtistRepository =
        ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)

}