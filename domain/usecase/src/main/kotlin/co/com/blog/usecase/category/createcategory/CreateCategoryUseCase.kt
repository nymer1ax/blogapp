package co.com.blog.usecase.category.createcategory

import co.com.blog.model.category.Category
import co.com.blog.model.category.gateways.CategoryRepository

class CreateCategoryUseCase(private val categoryRepository: CategoryRepository){

    fun createCategory(category: Category){
        return categoryRepository.createCategory(category)
    }

}
