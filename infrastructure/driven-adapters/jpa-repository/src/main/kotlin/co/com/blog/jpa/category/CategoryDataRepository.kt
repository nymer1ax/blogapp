package co.com.blog.jpa.category

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor

interface CategoryDataRepository: CrudRepository<CategoryData, Long>, QueryByExampleExecutor<CategoryData>
