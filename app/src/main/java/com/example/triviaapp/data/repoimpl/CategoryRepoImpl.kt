package com.example.triviaapp.data.repoimpl

import android.content.Context
import com.example.triviaapp.data.apiservice.ApiService
import com.example.triviaapp.domain.models.CategoriesItem
import com.example.triviaapp.domain.repo.CategoryRepo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class CategoryRepoImpl (
//    private val apiService: ApiService
//        ) : CategoryRepo {
//
//    override suspend fun getCategories(): List<CategoriesItem?>? {
//        return apiService.getCategories().triviaCategories
//    }
//}

class CategoryRepoImpl(
    private val apiService: ApiService,
    private val context: Context // Inject Context for SharedPreferences
) : CategoryRepo {

    override suspend fun getCategories(): List<CategoriesItem?>? {
        return apiService.getCategories().triviaCategories
    }

    override fun cacheCategories(categories: List<CategoriesItem?>?) {
        val jsonCategories = Gson().toJson(categories)
        val sharedPreferences = context.getSharedPreferences("CategoryCache", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("categories", jsonCategories)
        editor.apply()
    }

    override fun getCachedCategories(): List<CategoriesItem?>? {
        val sharedPreferences = context.getSharedPreferences("CategoryCache", Context.MODE_PRIVATE)
        val jsonCategories = sharedPreferences.getString("categories", null)
        return Gson().fromJson(jsonCategories, object : TypeToken<List<CategoriesItem?>?>() {}.type)
    }
}