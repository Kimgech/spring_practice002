package com.example.spring_practice002.service

import com.example.spring_practice002.model.dto.OperatingSystemDto
import com.example.spring_practice002.model.entity.OperatingSystem
import com.example.spring_practice002.model.request.OperatingSystemRequest
import com.example.spring_practice002.repository.OperatingSystemRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OperatingSystemServiceImpl(
    private val osRepository: OperatingSystemRepository
) : OperatingSystemService {

    override fun save(os: OperatingSystemRequest): Mono<OperatingSystemDto> {
        return osRepository.save(os.toEntity()).map { it.toDto() }
    }

    override fun findAll(): Flux<OperatingSystemDto> {
        return osRepository.findAll().map { it.toDto() }
    }

    override fun findById(operatingSystemId: Long): Mono<OperatingSystem> {
        return osRepository.findById(operatingSystemId)
    }
}