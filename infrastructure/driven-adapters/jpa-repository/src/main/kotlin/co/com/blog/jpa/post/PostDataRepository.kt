package co.com.blog.jpa.post

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor

interface PostDataRepository : CrudRepository<PostData, Long>, QueryByExampleExecutor<PostData>
