package com.nefrit.databinding.ui.operations

import android.arch.lifecycle.ViewModel
import com.nefrit.data.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OperationsModule {

    @Binds
    @IntoMap
    @ViewModelKey(OperationsViewModel::class)
    internal abstract fun bindPointsViewModel(viewModel: OperationsViewModel): ViewModel
}