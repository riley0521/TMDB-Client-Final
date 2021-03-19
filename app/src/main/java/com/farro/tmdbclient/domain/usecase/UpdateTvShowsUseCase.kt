package com.farro.tmdbclient.domain.usecase

import com.farro.tmdbclient.data.model.tvshow.TvShow
import com.farro.tmdbclient.domain.repository.ITvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}