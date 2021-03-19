package com.farro.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.farro.tmdbclient.data.database.ArtistDao
import com.farro.tmdbclient.data.database.MovieDao
import com.farro.tmdbclient.data.database.TMDBDatabase
import com.farro.tmdbclient.data.database.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideTMDBDataBase(context: Context): TMDBDatabase =
        Room.databaseBuilder(context, TMDBDatabase::class.java, "myDatabase")
            .build()

    @Singleton
    @Provides
    fun provideMovieDao(db: TMDBDatabase): MovieDao = db.movieDao()

    @Singleton
    @Provides
    fun provideTvDao(db: TMDBDatabase): TvShowDao = db.tvShowDao()

    @Singleton
    @Provides
    fun provideArtistDao(db: TMDBDatabase): ArtistDao = db.artistDao()
}