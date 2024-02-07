package co.com.blog.usecase.comment.createcomment

import co.com.blog.model.comment.Comment
import co.com.blog.model.comment.gateways.CommentRepository
import co.com.blog.model.post.Post
import co.com.blog.usecase.post.getbyidpost.GetByIdPostUseCase
import lombok.RequiredArgsConstructor

class CreateCommentUseCase(private val commentRepository: CommentRepository, private val getPost : GetByIdPostUseCase){

    fun createComment(comment: Comment){
        getPost.getById(comment.postsId)
        commentRepository.saveComment(comment)
    }
}
