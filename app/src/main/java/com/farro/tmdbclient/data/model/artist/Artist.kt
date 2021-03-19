package com.farro.tmdbclient.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
data class Artist(
    @PrimaryKey
    val id: Int,
    val name: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
)