package co.com.blog.usecase.comment.createcomment

import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class CreateCommentUseCase(private val commentRepository: CommentRepository){

    fun createComment(comment: Comment){
        commentRepository.saveComment(comment)
    }
}
