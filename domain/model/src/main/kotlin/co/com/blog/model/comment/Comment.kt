package co.com.blog.model.comment

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
data class Comment(
  //val anyField : Any?
) {
  //fun anyMethod():Any? { return null }
}
