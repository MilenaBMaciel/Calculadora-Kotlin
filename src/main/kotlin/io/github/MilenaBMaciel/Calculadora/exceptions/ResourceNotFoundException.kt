package io.github.MilenaBMaciel.Calculadora.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(exc: String?) : RuntimeException(exc) {

}