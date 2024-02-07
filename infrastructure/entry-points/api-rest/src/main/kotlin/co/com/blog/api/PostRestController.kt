package co.com.blog.api

import co.com.blog.api.request.PostRequest
import co.com.blog.model.post.Post
import co.com.blog.usecase.post.createpost.CreatePostUseCase
import co.com.blog.usecase.post.deletepost.DeletePostUseCase
import co.com.blog.usecase.post.getallpost.GetAllPostUseCase
import co.com.blog.usecase.post.getbyidpost.GetByIdPostUseCase
import co.com.blog.usecase.post.updatepost.UpdatePostUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/post"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PostRestController(private val createPost: CreatePostUseCase,
                         private val deletePost: DeletePostUseCase,
                         private val getAllPostUseCase: GetAllPostUseCase,
                         private val getPost: GetByIdPostUseCase,
                         private val updatePost: UpdatePostUseCase
) {
    @PostMapping
    fun createPost(@RequestBody postRequest: PostRequest) {
        val post = postRequest.toDomain();
        createPost.createPost(post)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long) {
        deletePost.deletePost(id)
    }

    @GetMapping
    fun getAllPosts(): List<Post> {
        return getAllPostUseCase.getAllPost()
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): Post {
        return getPost.getById(id)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody postRequest: PostRequest) {
        var post = postRequest.toDomain()
        updatePost.updatePost(post)
    }
}
