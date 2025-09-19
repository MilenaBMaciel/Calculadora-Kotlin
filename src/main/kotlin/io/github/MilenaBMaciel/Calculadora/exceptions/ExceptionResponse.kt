package io.github.MilenaBMaciel.Calculadora.exceptions

import java.time.LocalDateTime
import java.util.Date

class ExceptionResponse (
    val timestamp: Date,
    val message: String?,
    val details: String
)