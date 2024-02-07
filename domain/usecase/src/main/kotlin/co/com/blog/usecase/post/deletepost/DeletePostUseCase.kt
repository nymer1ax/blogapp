package co.com.blog.usecase.post.deletepost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import co.com.blog.usecase.post.getbyidpost.GetByIdPostUseCase
import lombok.RequiredArgsConstructor

class DeletePostUseCase(private val postRepository: PostRepository, private val getByIdPostUseCase: GetByIdPostUseCase){
    fun deletePost(post: Post){
        val existingPost: Post = getByIdPostUseCase.getById(post.id)
        postRepository.deletePost(existingPost);
    }
}
