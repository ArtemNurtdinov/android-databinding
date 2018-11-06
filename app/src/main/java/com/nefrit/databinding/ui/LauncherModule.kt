package com.nefrit.databinding.ui

import android.arch.lifecycle.ViewModel
import com.nefrit.data.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LauncherModule {

    @Binds
    @IntoMap
    @ViewModelKey(LauncherViewModel::class)
    internal abstract fun bindLauncherViewModel(viewModel: LauncherViewModel): ViewModel
}