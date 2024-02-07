package co.com.blog.api.request

import co.com.blog.model.post.Post


import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class PostRequest @JsonCreator constructor(
        @JsonProperty("id") val id: Long,
        @JsonProperty("categoriasId") val categoriasId: Long,
        @JsonProperty("titulo") val titulo: String,
        @JsonProperty("contenido") val contenido: String,
        @JsonProperty("fechaCreacion") val fechaCreacion: Date,
        @JsonProperty("fechaActualizacion") val fechaActualizacion: Date
) {
    fun toDomain(): Post {
        return Post(
                id = this.id,
                categoriasId = this.categoriasId,
                titulo = this.titulo,
                contenido = this.contenido,
                fechaCreacion = this.fechaCreacion,
                fechaActualizacion = this.fechaActualizacion
        )
    }
}