package org.acme

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
    fun hello(): GreetingEntity {
        val greeting = GreetingEntity(Number.THREE)
        repository.persist(greeting)
        return greeting
    }
}
