package com.nefrit.databinding.ui.operation

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nefrit.databinding.util.setValueIfNew
import com.nefrit.domain.interactors.OperationsInteractor
import com.nefrit.model.Operation
import com.nefrit.model.OperationId
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@Suppress("NestedLambdaShadowedImplicitParameter")
@SuppressLint("CheckResult")
class OperationViewModel @Inject constructor(
    private val interactor: OperationsInteractor
): ViewModel(), LifecycleObserver {

    private val loadOperationResult = MediatorLiveData<Operation>()
    private val operationId = MutableLiveData<OperationId>()

    val operation = MediatorLiveData<Operation>()

    init {
        operation.addSource(operationId) {
            it?.let { getOperation(it) }
        }

        // If there's a new result with data, update the operation
        operation.addSource(loadOperationResult) {
            it?.let { operation.value = it }
        }
    }

    private fun getOperation(operationId: OperationId) {
        interactor.getOperationById(operationId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadOperationResult.value = it
            }, {
                // TODO: handle error here
            })
    }

    fun setOperationId(newOperationId: OperationId) {
        operationId.setValueIfNew(newOperationId)
    }
}



