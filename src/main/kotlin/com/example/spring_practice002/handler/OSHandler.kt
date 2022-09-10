package com.example.spring_practice002.handler

import com.example.spring_practice002.model.dto.OperatingSystemDto
import com.example.spring_practice002.model.request.OperatingSystemRequest
import com.example.spring_practice002.service.OperatingSystemService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class OSHandler(val operatingSystemService: OperatingSystemService) {

    fun createOperatingSystem(req: ServerRequest): Mono<ServerResponse> {
        val osRequestMono = req.bodyToMono(OperatingSystemRequest::class.java)

        val osResultMono: Mono<OperatingSystemDto> =
            osRequestMono.flatMap {
                operatingSystemService.save(it)
            }
        return ServerResponse.ok().body(osResultMono, OperatingSystemDto::class.java)
    }

    fun findAllOS(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().body(
            operatingSystemService.findAll(),
            OperatingSystemDto::class.java
        )
}
