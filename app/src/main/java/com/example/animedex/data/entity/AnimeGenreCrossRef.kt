package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

// Tabla de relacion N:M entre anime y genre
@Entity(
    tableName = "anime_genre",
    primaryKeys = ["anime_id", "genre_id"],
    foreignKeys = [
        ForeignKey(
            entity = AnimeEntity::class,
            parentColumns = ["anime_id"],
            childColumns = ["anime_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = GenreEntity::class,
            parentColumns = ["genre_id"],
            childColumns = ["genre_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("genre_id")]
)
data class AnimeGenreCrossRef(
    @ColumnInfo(name = "anime_id") val animeId: Int,
    @ColumnInfo(name = "genre_id") val genreId: Int
)
