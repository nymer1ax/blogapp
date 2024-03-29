package co.com.blog.usecase.comment.updatecomment

import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class UpdateCommentUseCase(private val commentRepository: CommentRepository){

    fun updateComment(comment: Comment){

        commentRepository.getCommentByID(comment.id)
                ?: throw RuntimeException("Comment not found")

        return commentRepository.updateComment(comment)
    }

}
