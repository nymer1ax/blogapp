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
        val categoryData = CategoryData(
                id = category.id,
                nombre = category.nombre,
                fechaCreacion = category.fechaCreacion,
                fechaActualizacion = category.fechaActualizacion
        )
        repository.save(categoryData)
    }

    override fun deleteCategory(id: Long) {
        repository.deleteById(id)
    }

    override fun getAllCategories(): List<Category> {
        val allCategoryData = repository.findAll()
        return allCategoryData.map { categoryData ->
            Category(
                    id = categoryData.id,
                    nombre = categoryData.nombre,
                    fechaCreacion = categoryData.fechaCreacion,
                    fechaActualizacion = categoryData.fechaActualizacion
            )
        }
    }

    override fun getCategoryById(id: Long): Category? {
        val categoryData = repository.findById(id)
        return if (categoryData.isPresent) {
            val data = categoryData.get()
            Category(
                    id = data.id,
                    nombre = data.nombre,
                    fechaCreacion = data.fechaCreacion,
                    fechaActualizacion = data.fechaActualizacion
            )
        } else {
            null
        }
    }

    override fun updateCategory(category: Category) {
        val categoryData = CategoryData(
                id = category.id,
                nombre = category.nombre,
                fechaCreacion = category.fechaCreacion,
                fechaActualizacion = category.fechaActualizacion
        )
        repository.save(categoryData)
    }
}