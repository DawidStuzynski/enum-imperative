package org.acme


import GreetingEntityJava
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class GreetingController(
    private val repository: GreetingRepository
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun hello(): GreetingEntityJava {
//        val greeting = GreetingEntityJava(arrayOf("test"))
        val greeting = GreetingEntityJava()
        repository.persist(greeting)
        return greeting
    }
}
