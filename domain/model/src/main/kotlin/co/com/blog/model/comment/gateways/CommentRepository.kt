package co.com.blog.model.comment.gateways

import co.com.blog.model.comment.Comment

interface CommentRepository {
     fun saveComment(comment: Comment)
     fun deleteComment(id: Long)
     fun getAllComments(): List<Comment>
     fun getCommentByID(id: Long) : Comment?
     fun updateComment(comment: Comment)
}
