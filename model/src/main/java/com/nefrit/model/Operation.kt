package com.nefrit.model

typealias OperationId = Int

data class Operation(
    val id: OperationId,
    val value: Double,
    val comment: String,
    val date: Long,
    val categoryName: String,
    val categoryIconRes: Int
)