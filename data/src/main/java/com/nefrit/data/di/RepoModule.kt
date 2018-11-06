package com.nefrit.data.di

import com.nefrit.data.repository.OperationsRepositoryImpl
import com.nefrit.domain.interfaces.OperationsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Singleton
    @Binds
    fun bindOperationsRepository(operationsRepository: OperationsRepositoryImpl): OperationsRepository
}