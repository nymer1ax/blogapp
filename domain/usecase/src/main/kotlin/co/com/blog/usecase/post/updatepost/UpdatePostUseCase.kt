package co.com.blog.usecase.post.updatepost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository

class UpdatePostUseCase(){

    private lateinit var postRepository: PostRepository
    fun updatePost(post: Post): Post {

        if (post.id == null) {
            throw RuntimeException("Id is required")
        }

        return postRepository.updatePost(post) ?: throw Exception("Post not found")
    }
}
