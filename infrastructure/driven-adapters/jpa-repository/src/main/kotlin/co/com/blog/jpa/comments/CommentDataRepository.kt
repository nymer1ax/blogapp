package co.com.blog.jpa.comments

import co.com.blog.jpa.category.CategoryData
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor

interface CommentDataRepository : CrudRepository<CommentData, Long>, QueryByExampleExecutor<CommentData>
