package co.com.blog.usecase.category.getallcategory

import co.com.blog.model.category.Category
import co.com.blog.model.category.gateways.CategoryRepository

class GetAllCategoryUseCase(private val categoryRepository: CategoryRepository){

    fun getAllCategories(): List<Category> {
        return categoryRepository.getAllCategories()
    }

}
