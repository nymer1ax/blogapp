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
        val postData = mapToPostData(post)
        repository.save(postData)
    }

    override fun findPostById(id: Long): Post? {
        val postData = repository.findById(id)
        return if (postData.isPresent) {
            mapToPost(postData.get())
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
            mapToPost(postData)
        }
    }

    override fun updatePost(post: Post): Post? {
        val postData = mapToPostData(post)
        val savedPostData = repository.save(postData)
        return mapToPost(savedPostData)
    }

    private fun mapToPostData(post: Post): PostData {
        return PostData(
                id = post.id,
                categoriasId = post.categoriasId,
                titulo = post.titulo,
                contenido = post.contenido,
                fechaCreacion = post.fechaCreacion,
                fechaActualizacion = post.fechaActualizacion
        )
    }

    private fun mapToPost(postData: PostData): Post {
        return Post(
                id = postData.id,
                categoriasId = postData.categoriasId,
                titulo = postData.titulo,
                contenido = postData.contenido,
                fechaCreacion = postData.fechaCreacion,
                fechaActualizacion = postData.fechaActualizacion
        )
    }
}