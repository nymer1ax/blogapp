package co.com.blog.api.advisor

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpHeaders
@ControllerAdvice
class CustomGlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(IllegalArgumentException::class)])
    protected fun handleConflict(ex: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.CONFLICT, request)
    }

    @ExceptionHandler(value = [(RuntimeException::class)])
    protected fun handleRuntimeException(ex: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request)
    }

}