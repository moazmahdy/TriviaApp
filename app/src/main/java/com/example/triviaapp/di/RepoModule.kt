package com.example.triviaapp.di

import android.content.Context
import com.example.triviaapp.data.apiservice.ApiService
import com.example.triviaapp.data.repoimpl.CategoryRepoImpl
import com.example.triviaapp.domain.repo.CategoryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideCategoryRepo(apiService: ApiService, context: Context): CategoryRepo {
        return CategoryRepoImpl(apiService, context)
    }
}

//@Provides
//fun provideCategoryRepo(apiService: ApiService, context: Context): CategoryRepo {
//    return CategoryRepoImpl(apiService, context)
//}
