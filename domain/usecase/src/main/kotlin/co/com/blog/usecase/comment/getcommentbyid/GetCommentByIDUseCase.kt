package co.com.blog.usecase.comment.getcommentbyid

import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class GetCommentByIDUseCase(private val commentRepository: CommentRepository){

    fun getCommentByID(id: Long): Comment? {
        return commentRepository.getCommentByID(id)
    }

}
