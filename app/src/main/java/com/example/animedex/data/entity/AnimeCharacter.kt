package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

// Tabla de relacion entre anime y character
@Entity(
    tableName = "anime_character",
    primaryKeys = ["anime_id", "character_id"],
    foreignKeys = [
        ForeignKey(
            entity = AnimeEntity::class,
            parentColumns = ["anime_id"],
            childColumns = ["anime_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["character_id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("character_id")]
)
data class AnimeCharacter(
    @ColumnInfo(name = "anime_id") val animeId: Int,
    @ColumnInfo(name = "character_id") val characterId: Int,
    val role: String
)
