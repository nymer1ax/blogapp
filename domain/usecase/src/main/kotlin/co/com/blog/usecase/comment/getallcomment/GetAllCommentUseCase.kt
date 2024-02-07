package co.com.blog.usecase.comment.getallcomment

import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor

class GetAllCommentUseCase(private val commentRepository: CommentRepository){

    fun getAllComments() : List<Comment> {
        return commentRepository.getAllComments()
    }

}
