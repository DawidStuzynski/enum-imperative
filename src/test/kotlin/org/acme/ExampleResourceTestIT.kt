package org.acme

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.testcontainers.junit.jupiter.Testcontainers

@QuarkusTest
@Testcontainers
@QuarkusTestResource(PostgresResource::class)
class ExampleResourceTestIT {

    @Test
    fun `test for enums hibernate`() {
        val expected = String(readResource("/fixtures/Expected.json"))

        When {
            get("hello")
        } Then {
            statusCode(200)
        } Extract {
            val result = body().asString()
            JSONAssert.assertEquals(expected, result, JSONCompareMode.STRICT)
        }
    }

    fun readResource(path: String): ByteArray {
        return javaClass.getResourceAsStream(path)!!.readAllBytes()
    }
}
