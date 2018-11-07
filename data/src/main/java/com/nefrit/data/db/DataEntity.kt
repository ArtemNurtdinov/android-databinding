package com.nefrit.data.db

import com.nefrit.data.db.model.OperationLocal

object DataEntity {

    fun populateData(): List<OperationLocal> {
        return mutableListOf<OperationLocal>().apply {
            add(OperationLocal(1, -322.9,  "Test operation with flower icon", 723469612000, "Транспорт", 3))
            add(OperationLocal(2, -142.12, "This is operation with Android icon", 975240409000, "Продукты", 1))
            add(OperationLocal(3, -99.99, "Look at this cute apple icon!", 1354128056000, "Кафе", 2))
            add(OperationLocal(4, 123.45, "Another test operation with flower icon", 1547234004100, "Перевод", 3))
        }
    }
}