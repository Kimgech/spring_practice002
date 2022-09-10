package com.example.spring_practice002.model.entity

import com.example.spring_practice002.model.dto.OperatingSystemDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("operating_systems")
data class OperatingSystem(

    @Id
    val id: Long? = null,

    @Column("name")
    val name: String,

    @Column("version")
    val version: String,

    @Column("owner")
    val owner: String,
) {
    fun toDto() = OperatingSystemDto(
        id = id!!,
        name = name,
        version = version,
        owner=owner
    )
}