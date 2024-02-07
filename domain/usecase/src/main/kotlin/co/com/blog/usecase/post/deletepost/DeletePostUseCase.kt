package co.com.blog.usecase.post.deletepost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class DeletePostUseCase(private val postRepository: PostRepository){
    fun deletePost(post: Post){

        val post: Post? = postRepository.findPostById(post.id)

        if (post != null) {
            postRepository.deletePost(post);
        }

    }
}
