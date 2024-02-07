package co.com.blog.model.post.gateways

import co.com.blog.model.post.Post

interface PostRepository {
    fun savePost(post: Post);
    fun findPostById(id: Long): Post?
    fun deletePost(post: Post)
    fun getAllPost() : List<Post>
    fun updatePost(post: Post): Post?
}
