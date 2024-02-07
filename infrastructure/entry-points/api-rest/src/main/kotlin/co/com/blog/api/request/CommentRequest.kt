package co.com.blog.api.request

import com.fasterxml.jackson.annotation.JsonProperty
import co.com.blog.model.comment.Comment
import java.util.*

data class CommentRequest(
        @JsonProperty("id")
        val id: Long,

        @JsonProperty("postsId")
        val postsId: Long,

        @JsonProperty("contenido")
        val contenido: String,

        @JsonProperty("fechaCreacion")
        val fechaCreacion: Date,

        @JsonProperty("fechaActualizacion")
        val fechaActualizacion: Date
) {
    fun toDomain(): Comment {
        return Comment(
                id = this.id,
                postsId = this.postsId,
                contenido = this.contenido,
                fechaCreacion = this.fechaCreacion,
                fechaActualizacion = this.fechaActualizacion
        )
    }
}