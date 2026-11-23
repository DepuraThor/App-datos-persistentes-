package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad que representa la tabla genre en Room
@Entity(tableName = "genre")
data class GenreEntity(
    @PrimaryKey @ColumnInfo(name = "genre_id") val genreId: Int,
    val name: String,
    val category: String
)
