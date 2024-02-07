package co.com.blog.usecase.post.createpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class CreatePostUseCase(private  val postRepository: PostRepository){
    fun createPost(post: Post){
         postRepository.savePost(post);
    }

}
