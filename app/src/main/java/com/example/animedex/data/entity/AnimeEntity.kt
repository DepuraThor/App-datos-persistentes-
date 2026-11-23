package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// Entidad principal que representa la tabla anime en Room
@Entity(
    tableName = "anime",
    indices = [Index("rank"), Index("type")]
)
data class AnimeEntity(
    @PrimaryKey @ColumnInfo(name = "anime_id") val animeId: Int,
    val title: String,
    val score: Double,
    val rank: Int,
    val popularity: Int,
    val members: Int,
    val synopsis: String?,
    @ColumnInfo(name = "start_date") val startDate: String?,
    @ColumnInfo(name = "end_date") val endDate: String?,
    val type: String,
    val episodes: Int?,
    @ColumnInfo(name = "image_url") val imageUrl: String
)
