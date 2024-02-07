package co.com.blog.jpa.comments

import jakarta.persistence.*

@Entity
@Table(name = "comment")
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
    val fechaCreacion: java.time.Instant,

    @Column(name = "fecha_actualizacion")
    val fechaActualizacion: java.time.Instant
){
}