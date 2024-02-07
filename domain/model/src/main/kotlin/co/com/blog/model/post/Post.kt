package co.com.blog.model.post

import lombok.Builder
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.Date
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
data class Post(
        val id: Long,
        val categoriasId: Long,
        val titulo: String,
        val contenido: String,
        val fechaCreacion: Date,
        val fechaActualizacion: Date
)


