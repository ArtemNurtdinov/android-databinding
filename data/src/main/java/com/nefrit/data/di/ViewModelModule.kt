package com.nefrit.data.di

import android.arch.lifecycle.ViewModelProvider
import com.nefrit.data.di.DataBindingViewModelFactory
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