package co.com.blog.usecase.post.getallpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository

class GetAllPostUseCase(){

    private lateinit var postRepository: PostRepository

    fun getAllPost(): List<Post> {
         return postRepository.getAllPost();
    }

}
