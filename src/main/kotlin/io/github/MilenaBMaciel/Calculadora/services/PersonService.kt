package io.github.MilenaBMaciel.Calculadora.services

import io.github.MilenaBMaciel.Calculadora.exceptions.ResourceNotFoundException
import io.github.MilenaBMaciel.Calculadora.model.Person
import io.github.MilenaBMaciel.Calculadora.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding All People!")

        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding Person with ID $id")

        return repository.findById(id).orElseThrow{ ResourceNotFoundException("No Person found with ID $id") }
    }

    fun create(person: Person) : Person{
        logger.info("Creating one person with name ${person.firstName}")

        return repository.save(person)
    }

    fun update(person: Person) : Person{
        logger.info("Updating one person with ID ${person.id}")

        val entity = repository.findById(person.id).orElseThrow{ ResourceNotFoundException("No Person found with ID $person.id") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id : Long){
        logger.info("Deleting one person with ID $id")

        val entity = repository.findById(id).orElseThrow{ ResourceNotFoundException("No Person found with ID $id") }

        repository.delete(entity)
    }


}