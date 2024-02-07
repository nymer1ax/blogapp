package co.com.blog.jpa.post

import co.com.blog.jpa.helper.AdapterOperations
import co.com.blog.model.post.Post
import co.com.blog.model.post.gateways.PostRepository
import org.reactivecommons.utils.ObjectMapper
import org.springframework.stereotype.Repository
import java.util.function.Function

@Repository
open class PostDataAdapter (
        private val repository: PostDataRepository,
        private val mapper: ObjectMapper
) : AdapterOperations<Post, PostData, Long, PostDataRepository>(
        repository,
        mapper,
        Function { d -> mapper.map(d, Post::class.java) }
), PostRepository {

    override fun savePost(post: Post) {
        val postData = mapper.map(post, PostData::class.java)
        repository.save(postData)
    }

    override fun findPostById(id: Long): Post? {
        val postData = repository.findById(id)
        return if (postData.isPresent) {
            mapper.map(postData.get(), Post::class.java)
        } else {
            null
        }
    }

    override fun deletePost(post: Post) {
        repository.deleteById(post.id)
    }

    override fun getAllPost(): List<Post> {
        val allPostData = repository.findAll()
        return allPostData.map { postData ->
            mapper.map(postData, Post::class.java)
        }
    }

    override fun updatePost(post: Post): Post? {
        val postData = mapper.map(post, PostData::class.java)
        val savedPostData = repository.save(postData)
        return mapper.map(savedPostData, Post::class.java)
    }
}