package com.farro.tmdbclient.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farro.tmdbclient.data.model.artist.Artist
import com.farro.tmdbclient.data.model.movie.Movie
import com.farro.tmdbclient.data.model.tvshow.TvShow


@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun tvShowDao(): TvShowDao
abstract fun artistDao(): ArtistDao

}