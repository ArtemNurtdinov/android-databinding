package com.nefrit.data.mappers

import com.nefrit.data.db.model.OperationLocal
import com.nefrit.model.Operation

fun mapOperationLocalToOperation(operation: OperationLocal): Operation {
    return with (operation) {
        Operation(id, value, comment, date, categoryName, categoryIconId)
    }
}