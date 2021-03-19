package com.farro.tmdbclient.presentation.di.artist

import com.farro.tmdbclient.domain.usecase.GetArtistsUseCase
import com.farro.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.farro.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory =
        ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
}