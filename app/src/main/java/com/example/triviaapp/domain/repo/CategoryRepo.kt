package com.example.triviaapp.domain.repo

import com.example.triviaapp.domain.models.CategoriesItem

//interface CategoryRepo {
//
//    suspend fun getCategories(): List<CategoriesItem?>?
//}

interface CategoryRepo {
    suspend fun getCategories(): List<CategoriesItem?>?
    fun cacheCategories(categories: List<CategoriesItem?>?)
    fun getCachedCategories(): List<CategoriesItem?>?
}
