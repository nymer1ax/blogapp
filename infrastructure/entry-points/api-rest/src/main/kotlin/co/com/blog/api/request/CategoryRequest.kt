package co.com.blog.api.request

import co.com.blog.model.category.Category
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class CategoryRequest @JsonCreator constructor(
        @JsonProperty("id") val id: Long,
        @JsonProperty("nombre") val nombre: String,
        @JsonProperty("fechaCreacion") val fechaCreacion: Date,
        @JsonProperty("fechaActualizacion") val fechaActualizacion: Date
) {
    fun toDomain(): Category {
        return Category(
                id = this.id,
                nombre = this.nombre,
                fechaCreacion = this.fechaCreacion,
                fechaActualizacion = this.fechaActualizacion
        )
    }
}