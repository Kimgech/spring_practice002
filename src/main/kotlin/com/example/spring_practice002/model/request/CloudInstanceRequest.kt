package com.example.spring_practice002.model.request

import com.example.spring_practice002.model.entity.CloudInstance
import kotlin.random.Random

data class CloudInstanceRequest(
    val instanceName: String,
    val operatingSystemId: Long
){
    fun toEntity() = CloudInstance(
        instanceName = instanceName,
        operatingSystemId = operatingSystemId,
        publicIpAddress = "${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}"
    )
}
