package co.com.blog.model.category.gateways

import co.com.blog.model.category.Category

interface CategoryRepository {
     fun createCategory(category: Category)
     fun deleteCategory(id: Long)
     fun getAllCategories(): List<Category>
     fun getCategoryById(id: Long): Category?
     fun updateCategory(category: Category)
}
