package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad que representa la tabla character en Room
@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "character_id") val characterId: Int,
    val name: String?,
    @ColumnInfo(name = "image_url") val imageUrl: String?
)
