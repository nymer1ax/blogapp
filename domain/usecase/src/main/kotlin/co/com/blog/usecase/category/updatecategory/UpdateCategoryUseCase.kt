package co.com.blog.usecase.category.updatecategory


import co.com.blog.model.category.Category
import co.com.blog.model.category.gateways.CategoryRepository

class UpdateCategoryUseCase(private val categoryRepository: CategoryRepository){

    fun updateCategory(category: Category){
         return categoryRepository.updateCategory(category)
    }

}