package com.example.spring_practice002.service

import com.example.spring_practice002.model.dto.CloudInstanceDto
import com.example.spring_practice002.model.request.CloudInstanceRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CloudInstanceService {
    fun create(cloudInstanceRequest: CloudInstanceRequest): Mono<CloudInstanceDto>

    fun findAll(): Flux<CloudInstanceDto>
}
