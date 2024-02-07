package co.com.blog.usecase.post.getbyidpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import java.lang.RuntimeException

class GetByIdPostUseCase(private val postRepository: PostRepository){
    fun getById(post: Post) : Post{
        return postRepository.findPostById(post.id) ?: throw Exception("Post not found")
    }
}
