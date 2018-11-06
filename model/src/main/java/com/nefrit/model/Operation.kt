package com.nefrit.model

data class Operation(
    val id: Int,
    val value: Double,
    val date: Long,
    val categoryName: String,
    val categoryIconRes: Int
)