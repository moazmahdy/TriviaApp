package com.example.triviaapp.ui.category

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.domain.models.CategoriesItem
import com.example.triviaapp.domain.repo.CategoryRepo
import com.example.triviaapp.domain.usecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class CategoryViewModel @Inject constructor(
//    private val categoryUseCase: CategoryUseCase
//) : ViewModel() {
//
//    private val categoryListFlow: MutableStateFlow<List<CategoriesItem>> =
//        MutableStateFlow(emptyList())
//
//    val categoryList: StateFlow<List<CategoriesItem>> =
//        categoryListFlow.asStateFlow()
//
//    fun getCategoryList() {
//        viewModelScope.launch {
//            var list = categoryUseCase.invoke()
//            categoryListFlow.value = list as List<CategoriesItem>
//        }
//    }
//}


@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val categoryRepo: CategoryRepo,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val categoryListFlow: MutableStateFlow<List<CategoriesItem>> =
        MutableStateFlow(emptyList())

    val categoryList: StateFlow<List<CategoriesItem>> =
        categoryListFlow.asStateFlow()

    fun getCategoryList() {
        viewModelScope.launch {
            var list = categoryRepo.getCachedCategories()
            if (list == null) {
                list = categoryUseCase.invoke()
                categoryRepo.cacheCategories(list)
            }
            categoryListFlow.value = list as List<CategoriesItem>
        }
    }
}
