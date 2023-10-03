package org.acme

import GreetingEntityJava
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingRepository : PanacheRepository<GreetingEntityJava>