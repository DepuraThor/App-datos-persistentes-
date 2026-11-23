package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// Entidad que representa la tabla person en Room
@Entity(
    tableName = "person",
    indices = [Index("person_type")]
)
data class PersonEntity(
    @PrimaryKey @ColumnInfo(name = "person_id") val personId: Int,
    val name: String?,
    @ColumnInfo(name = "person_type") val personType: String,
    @ColumnInfo(name = "image_url") val imageUrl: String?
)
