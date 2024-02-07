package co.com.blog.model.category
import java.util.Date

data class Category(
        val id: Long,
        val nombre: String,
        val fechaCreacion: Date,
        val fechaActualizacion: Date
) {
    constructor() : this(
            id = 0L,
            nombre = "",
            fechaCreacion = Date(),
            fechaActualizacion = Date()
    )
}

