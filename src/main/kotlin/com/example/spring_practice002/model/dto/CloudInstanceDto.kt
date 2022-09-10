package com.example.spring_practice002.model.dto

import com.example.spring_practice002.handler.AppUser

data class CloudInstanceDto (val id: Long,
                             val instanceName: String,
                             val publicIpAddress: String,
                             var operatingSystem: OperatingSystemDto? = null,
                             var appUser: AppUser? = null
)

