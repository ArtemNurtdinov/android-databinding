package com.nefrit.domain.interactors

import com.nefrit.domain.interfaces.OperationsRepository
import com.nefrit.model.Operation
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OperationsInteractor @Inject constructor(
    private val operationsRepository: OperationsRepository
) {

    fun getOperations(): Observable<List<Operation>> {
        return operationsRepository.getOperations()
            .subscribeOn(Schedulers.io())
    }
}