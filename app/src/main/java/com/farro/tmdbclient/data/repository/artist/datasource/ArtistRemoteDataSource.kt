package com.farro.tmdbclient.data.repository.artist.datasource

import com.farro.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
   suspend fun getArtists(): Response<ArtistList>
}