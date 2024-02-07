package co.com.blog.usecase.comment.deletecomment

import co.com.blog.model.comment.gateways.CommentRepository
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class DeleteCommentUseCase(private val commentRepository: CommentRepository){

    fun deleteComment(id: Long){
        commentRepository.deleteComment(id)
    }

}
