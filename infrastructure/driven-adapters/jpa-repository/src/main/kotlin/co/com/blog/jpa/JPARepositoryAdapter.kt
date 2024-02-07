package co.com.blog.jpa

import co.com.blog.jpa.helper.AdapterOperations
import org.reactivecommons.utils.ObjectMapper
import org.springframework.stereotype.Repository
import java.util.function.Function


@Repository
open class JPARepositoryAdapter(repository: JPARepository, mapper: ObjectMapper) :
    AdapterOperations<Any, Any, String, JPARepository>(repository, mapper,
        Function { d ->
            mapper.map(
                d,
                Any::class.java /* change for domain model */
            )
        }) // implements ModelRepository from domain
