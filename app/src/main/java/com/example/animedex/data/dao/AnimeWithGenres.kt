package com.example.animedex.data.dao

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.animedex.data.entity.AnimeEntity
import com.example.animedex.data.entity.AnimeGenreCrossRef
import com.example.animedex.data.entity.GenreEntity

// Relacion N:M entre Anime y Genre mediante AnimeGenreCrossRef
data class AnimeWithGenres(
    @Embedded val anime: AnimeEntity,
    @Relation(
        parentColumn = "anime_id",
        entityColumn = "genre_id",
        associateBy = Junction(
            value = AnimeGenreCrossRef::class,
            parentColumn = "anime_id",
            entityColumn = "genre_id"
        )
    )
    val genres: List<GenreEntity>
)
