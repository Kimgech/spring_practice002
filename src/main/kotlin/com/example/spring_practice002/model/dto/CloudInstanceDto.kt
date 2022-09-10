package com.example.spring_practice002.model.dto

data class CloudInstanceDto (val id: Long,
                             val instanceName: String,
                             val publicIpAddress: String,
                             var operatingSystem: OperatingSystemDto? = null)

