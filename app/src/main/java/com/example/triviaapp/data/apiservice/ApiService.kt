package com.example.triviaapp.data.apiservice

import com.example.triviaapp.domain.models.CategoryResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api_category.php")
    suspend fun getCategories():CategoryResponse
}