package co.com.blog.jpa.category

import co.com.blog.jpa.helper.AdapterOperations
import co.com.blog.model.category.Category
import co.com.blog.model.category.gateways.CategoryRepository
import org.reactivecommons.utils.ObjectMapper
import org.springframework.stereotype.Repository
import java.util.function.Function

@Repository
open class CategoryDataAdapter (
        private val repository: CategoryDataRepository,
        private val mapper: ObjectMapper
) : AdapterOperations<Category, CategoryData, Long, CategoryDataRepository>(
        repository,
        mapper,
        Function { d -> mapper.map(d, Category::class.java) }
), CategoryRepository {

    override fun createCategory(category: Category) {
        val categoryData = mapper.map(category, CategoryData::class.java)
        repository.save(categoryData)
    }

    override fun deleteCategory(id: Long) {
        repository.deleteById(id)
    }

    override fun getAllCategories(): List<Category> {
        val allCategoryData = repository.findAll()
        return allCategoryData.map { categoryData ->
            mapper.map(categoryData, Category::class.java)
        }
    }

    override fun getCategoryById(id: Long): Category? {
        val categoryData = repository.findById(id)
        return if (categoryData.isPresent) {
            mapper.map(categoryData.get(), Category::class.java)
        } else {
            null
        }
    }

    override fun updateCategory(category: Category) {
        val categoryData = mapper.map(category, CategoryData::class.java)
        repository.save(categoryData)
    }
}