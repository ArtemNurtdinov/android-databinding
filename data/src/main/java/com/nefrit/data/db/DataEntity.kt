package com.nefrit.data.db

import com.nefrit.data.db.model.OperationLocal

object DataEntity {

    fun populateData(): List<OperationLocal> {
        return mutableListOf<OperationLocal>().apply {
            add(OperationLocal(1, -322.9,  "test operation", 723459600000, "Транспорт", 0))
            add(OperationLocal(2, -142.12, "adwadawdwa dawdwadawd awdawd", 975920400000, "Продукты", 0))
            add(OperationLocal(3, -99.99, "lol lol operation comment kek", 1354608000000, "Кафе", 0))
            add(OperationLocal(4, 123.45, "another test operation comment", 1543914000000, "Перевод", 0))
        }
    }
}