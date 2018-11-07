package com.nefrit.domain.interfaces

import com.nefrit.model.Operation
import io.reactivex.Observable

interface OperationsRepository {

    fun getOperationById(id: Int): Observable<Operation>

    fun getOperations(): Observable<List<Operation>>
}