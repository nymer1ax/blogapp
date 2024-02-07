package co.com.blog.usecase.post.getbyidpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import java.lang.RuntimeException

class GetByIdPostUseCase(private val postRepository: PostRepository){
    fun getById(id: Long) : Post{
        return postRepository.findPostById(id) ?: throw RuntimeException("Post not found")
    }
}
