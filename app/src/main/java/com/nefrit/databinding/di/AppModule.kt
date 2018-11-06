package com.nefrit.databinding.di

import android.content.Context
import com.nefrit.data.db.AppDatabase
import com.nefrit.databinding.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context) = context.getSharedPreferences("outlet-prefs", Context.MODE_PRIVATE)!!

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.get(context)
}