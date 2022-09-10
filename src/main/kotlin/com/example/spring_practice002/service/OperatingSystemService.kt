package com.example.spring_practice002.service

import com.example.spring_practice002.model.dto.OperatingSystemDto
import com.example.spring_practice002.model.entity.OperatingSystem
import com.example.spring_practice002.model.request.OperatingSystemRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OperatingSystemService {
    fun save(os: OperatingSystemRequest): Mono<OperatingSystemDto>

    fun findAll(): Flux<OperatingSystemDto>
    fun findById(operatingSystemId: Long): Mono<OperatingSystem>
}
