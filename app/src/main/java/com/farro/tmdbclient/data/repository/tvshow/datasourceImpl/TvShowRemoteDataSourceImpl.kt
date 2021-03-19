package com.farro.tmdbclient.data.repository.tvshow.datasourceImpl

import com.farro.tmdbclient.data.api.TMDBService
import com.farro.tmdbclient.data.model.tvshow.TvShowList
import com.farro.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}

