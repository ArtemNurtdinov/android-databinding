package com.nefrit.databinding.di

import com.nefrit.data.di.RepoModule
import com.nefrit.data.di.ViewModelModule
import com.nefrit.databinding.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        RepoModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}