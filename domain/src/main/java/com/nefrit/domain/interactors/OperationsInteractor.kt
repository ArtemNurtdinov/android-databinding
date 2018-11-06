package com.nefrit.domain.interactors

import com.nefrit.domain.interfaces.OperationsRepository
import javax.inject.Inject

class OperationsInteractor @Inject constructor(
    private val operationsRepository: OperationsRepository
) {

}