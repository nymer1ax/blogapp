package co.com.blog.usecase.category.getcategorybyid

import co.com.blog.model.category.Category
import co.com.blog.model.category.gateways.CategoryRepository

class GetCategoryByIdUseCase(private val categoryRepository: CategoryRepository){

    fun getCategoryById(id: Long) : Category {
        return categoryRepository.getCategoryById(id) ?: throw RuntimeException("Category not found")
    }

}