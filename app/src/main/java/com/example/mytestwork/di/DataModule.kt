package com.example.mytestwork.di

import com.example.mytestwork.domain.repository.Repository
import com.example.mytestwork.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideRepository(): Repository{
        return RepositoryImpl()
    }
}