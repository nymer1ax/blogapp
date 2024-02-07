package co.com.blog.usecase.category.deletecategory

import co.com.blog.model.category.gateways.CategoryRepository

class DeleteCategoryUseCase(private val categoryRepository: CategoryRepository){

    fun deleteCategory(id: Long){
        return categoryRepository.deleteCategory(id)
    }

}
