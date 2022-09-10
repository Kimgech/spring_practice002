package com.example.spring_practice002.model.request

import com.example.spring_practice002.model.entity.CloudInstance
import kotlin.random.Random

data class CloudInstanceRequest(
    val instanceName: String,
    val operatingSystemId: Long,
    val appUserId: String
){
    fun toEntity() = CloudInstance(
        instanceName = instanceName,
        operatingSystemId = operatingSystemId,
        appUserId = appUserId,
        publicIpAddress = "${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}"
    )
}
