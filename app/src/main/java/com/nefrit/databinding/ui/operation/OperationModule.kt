package com.nefrit.databinding.ui.operation

import android.arch.lifecycle.ViewModel
import com.nefrit.data.di.ViewModelKey
import com.nefrit.databinding.ui.operations.OperationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OperationModule {

    @Binds
    @IntoMap
    @ViewModelKey(OperationViewModel::class)
    internal abstract fun bindOperationViewModel(viewModel: OperationViewModel): ViewModel
}