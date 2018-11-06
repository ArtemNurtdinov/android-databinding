package com.nefrit.databinding.ui.operations

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import com.nefrit.domain.interactors.OperationsInteractor
import com.nefrit.model.Operation
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@SuppressLint("CheckResult")
class OperationsViewModel @Inject constructor(
    private val interactor: OperationsInteractor
) : ViewModel(), LifecycleObserver {

    val operations = MutableLiveData<List<Operation>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getOperations() {
        interactor.getOperations()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                operations.value = it
            }, {})

    }
}