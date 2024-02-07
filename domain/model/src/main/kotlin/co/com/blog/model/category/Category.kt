package co.com.blog.model.category

import lombok.Builder
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
data class Category(
        val id: Long,
        val nombre: String,
        val fechaCreacion: java.time.Instant,
        val fechaActualizacion: java.time.Instant
)

