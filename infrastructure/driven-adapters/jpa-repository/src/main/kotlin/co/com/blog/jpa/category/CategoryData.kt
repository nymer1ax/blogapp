package co.com.blog.jpa.category

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class CategoryData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "nombre")
    val nombre: String,

    @Column(name = "fecha_creacion")
    val fechaCreacion: java.time.Instant,

    @Column(name = "fecha_actualizacion")
    val fechaActualizacion: java.time.Instant
) {
}