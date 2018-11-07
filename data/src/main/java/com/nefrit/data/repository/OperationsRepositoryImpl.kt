package com.nefrit.data.repository

import com.nefrit.data.db.AppDatabase
import com.nefrit.data.mappers.mapOperationLocalToOperation
import com.nefrit.domain.interfaces.OperationsRepository
import com.nefrit.model.Operation
import io.reactivex.Observable
import javax.inject.Inject

class OperationsRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : OperationsRepository {

    override fun getOperationById(id: Int): Observable<Operation> {
        return db.operationsDao().getOperationById(id)
            .toObservable()
            .map { mapOperationLocalToOperation(it) }
    }

    override fun getOperations(): Observable<List<Operation>> {
        return db.operationsDao().getAllOperations()
            .toObservable()
            .map { it.map { mapOperationLocalToOperation(it) } }
    }
}