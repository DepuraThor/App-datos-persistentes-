package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

// Tabla de relacion entre character y person (actores de voz)
@Entity(
    tableName = "character_voice_actor",
    primaryKeys = ["character_id", "person_id", "language"],
    foreignKeys = [
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["character_id"],
            childColumns = ["character_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PersonEntity::class,
            parentColumns = ["person_id"],
            childColumns = ["person_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("person_id")]
)
data class CharacterVoiceActor(
    @ColumnInfo(name = "character_id") val characterId: Int,
    @ColumnInfo(name = "person_id") val personId: Int,
    val language: String
)
