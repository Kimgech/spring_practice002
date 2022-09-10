package com.example.spring_practice002.repository
import com.example.spring_practice002.model.entity.CloudInstance
//import com.example.webfluxdemo.model.entity.CloudInstance
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CloudInstanceRepository : ReactiveCrudRepository<CloudInstance, Long> {

    fun findByPublicIpAddress(publicIpAddress: Mono<String>): Mono<CloudInstance>

    fun findByInstanceName(instanceName: Mono<String>): Mono<CloudInstance>

    fun findAllByInstanceNameContainingIgnoreCase(instanceName: Mono<String>): Flux<CloudInstance>
}