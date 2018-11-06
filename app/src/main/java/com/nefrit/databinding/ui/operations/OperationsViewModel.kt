package com.nefrit.databinding.ui.operations

import android.arch.lifecycle.ViewModel
import com.nefrit.domain.interactors.OperationsInteractor
import javax.inject.Inject

class OperationsViewModel @Inject constructor(
    private val interactor: OperationsInteractor
) : ViewModel() {

}