package co.com.blog.jpa.comments

import co.com.blog.jpa.helper.AdapterOperations
import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import org.reactivecommons.utils.ObjectMapper
import org.springframework.stereotype.Repository
import java.util.function.Function

@Repository
open class CommentDataAdapter (
        private val repository: CommentDataRepository,
        private val mapper: ObjectMapper
) : AdapterOperations<Comment, CommentData, Long, CommentDataRepository>(
        repository,
        mapper,
        Function { d -> mapper.map(d, Comment::class.java) }
), CommentRepository {

    override fun saveComment(comment: Comment) {
        val commentData = mapToCommentData(comment)
        repository.save(commentData)
    }

    override fun deleteComment(id: Long) {
        repository.deleteById(id)
    }

    override fun getAllComments(): List<Comment> {
        val allCommentData = repository.findAll()
        return allCommentData.map { commentData ->
            mapToComment(commentData)
        }
    }

    override fun getCommentByID(id: Long): Comment? {
        val commentData = repository.findById(id)
        return if (commentData.isPresent) {
            mapToComment(commentData.get())
        } else {
            null
        }
    }

    override fun updateComment(comment: Comment) {
        val commentData = mapToCommentData(comment)
        repository.save(commentData)
    }

    private fun mapToCommentData(comment: Comment): CommentData {
        return CommentData(
                id = comment.id,
                postsId = comment.postsId,
                contenido = comment.contenido,
                fechaCreacion = comment.fechaCreacion,
                fechaActualizacion = comment.fechaActualizacion
        )
    }

    private fun mapToComment(commentData: CommentData): Comment {
        return Comment(
                id = commentData.id,
                postsId = commentData.postsId,
                contenido = commentData.contenido,
                fechaCreacion = commentData.fechaCreacion,
                fechaActualizacion = commentData.fechaActualizacion
        )
    }
}