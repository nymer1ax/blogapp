package co.com.blog.config
import org.reactivecommons.utils.ObjectMapperImp
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ObjectMapperConfig {

    @Bean
    open fun objectMapper() = ObjectMapperImp();

}
