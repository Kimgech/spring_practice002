package com.example.spring_practice002.model.entity

import com.example.spring_practice002.model.dto.CloudInstanceDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("cloud_instances")
data class CloudInstance(

    @Id
    val id: Long? = null,

    @Column("public_ip_address")
    val publicIpAddress: String,

    @Column("instance_name")
    val instanceName: String,

    @Column("os_id")
    val operatingSystemId: Long,

    @Column("app_user")
    val appUserId: String,

) {
    fun toDto() = CloudInstanceDto(
        id = id!!,
        instanceName = instanceName,
        publicIpAddress = publicIpAddress,
        operatingSystem = null,
        appUser = null
    )
}
