package com.example.animedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidad que representa la tabla company en Room
@Entity(tableName = "company")
data class CompanyEntity(
    @PrimaryKey @ColumnInfo(name = "company_id") val companyId: Int,
    val name: String?,
    @ColumnInfo(name = "company_type") val companyType: String,
    @ColumnInfo(name = "image_url") val imageUrl: String?
)
