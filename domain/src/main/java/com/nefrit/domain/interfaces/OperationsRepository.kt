package com.nefrit.domain.interfaces

import com.nefrit.model.Operation
import io.reactivex.Observable

interface OperationsRepository {

    fun getOperations(): Observable<List<Operation>>
}