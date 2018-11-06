package com.nefrit.databinding.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [DataBindingViewModelFactory].
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DataBindingViewModelFactory): ViewModelProvider.Factory
}