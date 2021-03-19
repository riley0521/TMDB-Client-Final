package com.farro.tmdbclient.domain.repository

import com.farro.tmdbclient.data.model.artist.Artist

interface IArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}