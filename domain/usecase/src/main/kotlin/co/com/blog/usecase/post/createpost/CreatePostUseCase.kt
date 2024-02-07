package co.com.blog.usecase.post.createpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository

class CreatePostUseCase(){

    private lateinit var postRepository: PostRepository

    fun createPost(post: Post){
         postRepository.savePost(post);
    }

}
