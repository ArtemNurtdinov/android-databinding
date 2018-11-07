package com.nefrit.databinding.ui.operations

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.content.Context
import com.nefrit.databinding.ui.operation.OperationActivity
import com.nefrit.domain.interactors.OperationsInteractor
import com.nefrit.model.Operation
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class OperationsViewModel @Inject constructor(
    private val interactor: OperationsInteractor
) : ViewModel(), LifecycleObserver, OperationClickListener {

    val operations = MutableLiveData<List<Operation>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getOperations() {
        interactor.getOperations()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                operations.value = it
            }, {})

    }

    override fun onClick(context: Context, operation: Operation) {
        OperationActivity.start(context, operation)
    }
}