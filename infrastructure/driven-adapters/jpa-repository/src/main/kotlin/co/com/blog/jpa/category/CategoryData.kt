package co.com.blog.jpa.category

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "categories")
data class CategoryData(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,

        @Column(name = "nombre")
        val nombre: String,

        @Column(name = "fecha_creacion")
        val fechaCreacion: Date,

        @Column(name = "fecha_actualizacion")
        val fechaActualizacion: Date
) {
    constructor() : this(
            id = 0L,
            nombre = "",
            fechaCreacion = Date(),
            fechaActualizacion = Date()
    )
}