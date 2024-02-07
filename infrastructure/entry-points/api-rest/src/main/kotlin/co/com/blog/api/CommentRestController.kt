package co.com.blog.api

import co.com.blog.model.comment.Comment
import co.com.blog.usecase.comment.createcomment.CreateCommentUseCase
import co.com.blog.usecase.comment.deletecomment.DeleteCommentUseCase
import co.com.blog.usecase.comment.getallcomment.GetAllCommentUseCase
import co.com.blog.usecase.comment.getcommentbyid.GetCommentByIDUseCase
import co.com.blog.usecase.comment.updatecomment.UpdateCommentUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/comment"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CommentRestController(
        private val createCommentUseCase: CreateCommentUseCase,
        private val deleteCommentUseCase: DeleteCommentUseCase,
        private val getAllCommentUseCase: GetAllCommentUseCase,
        private val getCommentByIdUseCase: GetCommentByIDUseCase,
        private val updateCommentUseCase: UpdateCommentUseCase
) {
    @PostMapping
    fun createComment(@RequestBody comment: Comment) {
        createCommentUseCase.createComment(comment)
    }

    @DeleteMapping("/{id}")
    fun deleteComment(@PathVariable id: Long) {
        deleteCommentUseCase.deleteComment(id)
    }

    @GetMapping
    fun getAllComments(): List<Comment> {
        return getAllCommentUseCase.getAllComments()
    }

    @GetMapping("/{id}")
    fun getCommentById(@PathVariable id: Long): Comment {
        return getCommentByIdUseCase.getCommentByID(id)
    }

    @PutMapping("/{id}")
    fun updateComment(@PathVariable id: Long, @RequestBody comment: Comment) {
        updateCommentUseCase.updateComment(comment.copy(id = id))
    }
}