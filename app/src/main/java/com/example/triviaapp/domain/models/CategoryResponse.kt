package com.example.triviaapp.domain.models

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("trivia_categories")
	val triviaCategories: List<CategoriesItem?>? = null
)

data class CategoriesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)