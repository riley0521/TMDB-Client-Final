package com.farro.tmdbclient.domain.repository

import com.farro.tmdbclient.data.model.tvshow.TvShow

interface ITvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}