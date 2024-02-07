package co.com.blog.jpa.post

import jakarta.persistence.*

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
        val fechaCreacion: java.time.Instant,

        @Column(name = "fecha_actualizacion")
        val fechaActualizacion: java.time.Instant
)