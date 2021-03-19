package com.farro.tmdbclient.presentation

import android.app.Application
import com.farro.tmdbclient.BuildConfig
import com.farro.tmdbclient.presentation.di.Injector
import com.farro.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.farro.tmdbclient.presentation.di.core.*
import com.farro.tmdbclient.presentation.di.movie.MovieSubComponent
import com.farro.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule())
            .remoteDataModule(RemoteDataModule(BuildConfig.TMDB_API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent =
        appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent =
        appComponent.tvShowSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent =
        appComponent.artistSubComponent().create()
}