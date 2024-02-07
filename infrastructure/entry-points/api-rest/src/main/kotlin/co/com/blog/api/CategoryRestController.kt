package co.com.blog.api

import co.com.blog.api.request.CategoryRequest
import co.com.blog.model.category.Category
import co.com.blog.usecase.category.createcategory.CreateCategoryUseCase
import co.com.blog.usecase.category.deletecategory.DeleteCategoryUseCase
import co.com.blog.usecase.category.getallcategory.GetAllCategoryUseCase
import co.com.blog.usecase.category.getcategorybyid.GetCategoryByIdUseCase
import co.com.blog.usecase.category.updatecategory.UpdateCategoryUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/category"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CategoryRestController(
        private val createCategoryUseCase: CreateCategoryUseCase,
        private val deleteCategoryUseCase: DeleteCategoryUseCase,
        private val getAllCategoryUseCase: GetAllCategoryUseCase,
        private val getCategoryByIdUseCase: GetCategoryByIdUseCase,
        private val updateCategoryUseCase: UpdateCategoryUseCase
) {
    @PostMapping
    fun createCategory(@RequestBody categoryRequest: CategoryRequest) {
        val category = categoryRequest.toDomain()
        createCategoryUseCase.createCategory(category)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long) {
        deleteCategoryUseCase.deleteCategory(id)
    }

    @GetMapping
    fun getAllCategories(): List<Category> {
        return getAllCategoryUseCase.getAllCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): Category {
        return getCategoryByIdUseCase.getCategoryById(id)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: CategoryRequest) {
        val category = category.toDomain()
        updateCategoryUseCase.updateCategory(category)
    }
}