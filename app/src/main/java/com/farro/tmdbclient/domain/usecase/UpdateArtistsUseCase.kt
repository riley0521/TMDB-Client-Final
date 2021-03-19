package com.farro.tmdbclient.domain.usecase

import com.farro.tmdbclient.data.model.artist.Artist
import com.farro.tmdbclient.domain.repository.IArtistRepository

class UpdateArtistsUseCase(private val artistRepository: IArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}