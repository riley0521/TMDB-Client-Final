package com.farro.tmdbclient.data.repository.tvshow.datasource

import com.farro.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
   suspend fun getTvShows(): Response<TvShowList>
}