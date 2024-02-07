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
        val commentData = mapper.map(comment, CommentData::class.java)
        repository.save(commentData)
    }

    override fun deleteComment(id: Long) {
        repository.deleteById(id)
    }

    override fun getAllComments(): List<Comment> {
        val allCommentData = repository.findAll()
        return allCommentData.map { commentData ->
            mapper.map(commentData, Comment::class.java)
        }
    }

    override fun getCommentByID(id: Long): Comment? {
        val commentData = repository.findById(id)
        return if (commentData.isPresent) {
            mapper.map(commentData.get(), Comment::class.java)
        } else {
            null
        }
    }

    override fun updateComment(comment: Comment) {
        val commentData = mapper.map(comment, CommentData::class.java)
        repository.save(commentData)
    }
}