package com.nefrit.data.repository

import com.nefrit.domain.interfaces.OperationsRepository
import com.nefrit.model.Operation
import io.reactivex.Observable
import javax.inject.Inject

class OperationsRepositoryImpl @Inject constructor(

) : OperationsRepository {

    override fun getOperations(): Observable<Operation> {
        return Observable.empty()
    }
}