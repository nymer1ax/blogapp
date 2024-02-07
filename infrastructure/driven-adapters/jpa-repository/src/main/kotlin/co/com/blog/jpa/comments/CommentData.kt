package co.com.blog.jpa.comments

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "comments")
data class CommentData(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long,

        @Column(name = "posts_id")
        val postsId: Long,

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
            postsId = 0L,
            contenido = "",
            fechaCreacion = Date(),
            fechaActualizacion = Date()
    )
}