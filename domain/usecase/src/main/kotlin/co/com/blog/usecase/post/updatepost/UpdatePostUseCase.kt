package co.com.blog.usecase.post.updatepost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class UpdatePostUseCase(private  val postRepository: PostRepository){
    fun updatePost(post: Post): Post {
        return postRepository.updatePost(post) ?: throw Exception("Post not found")
    }
}
