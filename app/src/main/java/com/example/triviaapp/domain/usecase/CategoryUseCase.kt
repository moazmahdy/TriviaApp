package com.example.triviaapp.domain.usecase

import com.example.triviaapp.domain.repo.CategoryRepo

class CategoryUseCase(private val categoryRepo: CategoryRepo) {

    suspend operator fun invoke() = categoryRepo.getCategories()
}