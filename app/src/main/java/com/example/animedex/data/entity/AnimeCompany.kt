package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

// Tabla de relacion entre anime y company (estudios/productoras)
@Entity(
    tableName = "anime_company",
    primaryKeys = ["anime_id", "company_id"],
    foreignKeys = [
        ForeignKey(
            entity = AnimeEntity::class,
            parentColumns = ["anime_id"],
            childColumns = ["anime_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CompanyEntity::class,
            parentColumns = ["company_id"],
            childColumns = ["company_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("company_id")]
)
data class AnimeCompany(
    @ColumnInfo(name = "anime_id") val animeId: Int,
    @ColumnInfo(name = "company_id") val companyId: Int,
    val role: String
)
