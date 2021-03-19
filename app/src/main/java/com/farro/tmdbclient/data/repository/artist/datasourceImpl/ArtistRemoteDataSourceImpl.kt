package com.farro.tmdbclient.data.repository.artist.datasourceImpl

import com.farro.tmdbclient.data.api.TMDBService
import com.farro.tmdbclient.data.model.artist.ArtistList
import com.farro.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

