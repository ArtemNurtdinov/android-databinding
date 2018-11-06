package com.nefrit.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "operations")
data class OperationLocal(
    @PrimaryKey val id: Int,
    val value: Double,
    val date: Long,
    val categoryName: String,
    val categoryIconRes: Int
)