package com.farro.tmdbclient.presentation.di

import com.farro.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.farro.tmdbclient.presentation.di.movie.MovieSubComponent
import com.farro.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
   fun createMovieSubComponent():MovieSubComponent
   fun createTvShowSubComponent():TvShowSubComponent
   fun createArtistSubComponent():ArtistSubComponent
}