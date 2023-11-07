package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTestIT {

    @Test
    fun `test for enums hibernate`() {

        When {
            get("hello")
        } Then {
            statusCode(200)
        } Extract {
            val result = body().asString()
            println(result)
        }
    }
}
