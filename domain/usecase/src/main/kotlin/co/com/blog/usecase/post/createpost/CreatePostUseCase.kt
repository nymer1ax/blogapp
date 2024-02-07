package co.com.blog.usecase.post.createpost

import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import co.com.blog.usecase.category.getcategorybyid.GetCategoryByIdUseCase

class CreatePostUseCase(private val postRepository: PostRepository, private val getCategory: GetCategoryByIdUseCase){
    fun createPost(post: Post){
        getCategory.getCategoryById(post.categoriasId)
        postRepository.savePost(post)
    }
}
