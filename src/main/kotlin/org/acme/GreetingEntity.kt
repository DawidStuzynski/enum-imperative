package org.acme

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.Type


@Entity
@Table(name = "example_table")
class GreetingEntity(

    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType::class)
    val number: Number
) {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "resource_sq", sequenceName = "resource_sq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_sq")
    private var id: Long? = null
}