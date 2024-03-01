package com.example.triviaapp.di

import com.example.triviaapp.domain.repo.CategoryRepo
import com.example.triviaapp.domain.usecase.CategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCategoryUseCase(categoryRepo: CategoryRepo): CategoryUseCase {
        return CategoryUseCase(categoryRepo)
    }
}