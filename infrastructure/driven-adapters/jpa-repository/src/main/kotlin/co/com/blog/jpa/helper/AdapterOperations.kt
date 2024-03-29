package co.com.blog.jpa.helper

import org.reactivecommons.utils.ObjectMapper
import org.springframework.data.domain.Example
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import java.lang.reflect.ParameterizedType
import java.util.function.Function
import java.util.stream.Collectors

abstract class AdapterOperations<E, D, I, R>(
    private var repository: R,
    private var mapper: ObjectMapper,
    private val toEntityFn: Function<D, E>
) where R : CrudRepository<D, I>, R : QueryByExampleExecutor<D> {

    private val dataClass: Class<D>

    private fun toData(entity: E): D {
        return mapper.map(entity, dataClass)
    }

    private fun toEntity(data: D?): E? {
        return if (data != null) toEntityFn.apply(data) else null
    }

    fun save(entity: E): E? {
        val data = toData(entity)
        return toEntity(saveData(data))
    }

    protected fun saveAllEntities(entities: List<E>): List<E> {
        val list = entities.stream().map { entity: E ->
            toData(
                entity
            )
        }.collect(Collectors.toList())
        return toList(saveData(list))
    }

    private fun toList(iterable: Iterable<D>): List<E> {
        return iterable.mapNotNull { data: D ->
            toEntity(
                data
            )
        }
    }

    private fun saveData(data: D): D {
        return repository.save(data)
    }

    private fun saveData(data: List<D>?): Iterable<D> {
        return repository.saveAll(data)
    }

    fun findById(id: I): E? {
        return toEntity(repository.findById(id).orElse(null))
    }

    fun findByExample(entity: E): List<E> {
        return toList(repository.findAll(Example.of(toData(entity))))
    }

    fun findAll(): List<E> {
        return toList(repository.findAll())
    }

    init {
        val genericSuperclass = this.javaClass.genericSuperclass as ParameterizedType
        dataClass = genericSuperclass.actualTypeArguments[1] as Class<D>
    }
}
