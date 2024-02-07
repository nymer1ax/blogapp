package co.com.blog.jpa.post

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "post")
data class PostData(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,

        @Column(name = "categorias_id")
        val categoriasId: Long,

        @Column(name = "titulo")
        val titulo: String,

        @Column(name = "contenido")
        val contenido: String,

        @Column(name = "fecha_creacion")
        val fechaCreacion: Date,

        @Column(name = "fecha_actualizacion")
        val fechaActualizacion: Date
){
        // Constructor secundario sin argumentos para JPA
        constructor() : this(
                id = 0L,
                categoriasId = 0L,
                titulo = "",
                contenido = "",
                fechaCreacion = Date(),
                fechaActualizacion = Date()
        )
}