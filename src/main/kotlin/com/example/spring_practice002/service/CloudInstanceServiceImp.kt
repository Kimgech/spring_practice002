package com.example.spring_practice002.service

import com.example.spring_practice002.config.UserClient
import com.example.spring_practice002.handler.AppUser
import com.example.spring_practice002.model.dto.CloudInstanceDto
import com.example.spring_practice002.model.entity.OperatingSystem
import com.example.spring_practice002.model.request.CloudInstanceRequest
import com.example.spring_practice002.repository.CloudInstanceRepository
import com.example.spring_practice002.repository.OperatingSystemRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CloudInstanceServiceImpl(
    val cloudInstanceRepository: CloudInstanceRepository,
    val operatingSystemRepository: OperatingSystemRepository,
    @Qualifier("UserClient") val userClient: WebClient
) : CloudInstanceService {

    override fun create(cloudInstanceRequest: CloudInstanceRequest): Mono<CloudInstanceDto> {
        return cloudInstanceRepository
            .save(cloudInstanceRequest.toEntity())
            .map { res -> res.toDto() }
    }

    override fun findAll(): Flux<CloudInstanceDto> {
        val cloudInstanceFlux = cloudInstanceRepository
            .findAll()

        val osFlux = cloudInstanceFlux
            .flatMap{
                operatingSystemRepository.findById(it.operatingSystemId)
            }

        val appUserIdFlux: Flux<String> = cloudInstanceFlux.map { it.appUserId }

        fun fetchUserById(id:String):Mono<AppUser> = userClient.get()
            .uri("/api/v1/users/{id}", id)
            .retrieve()
            .bodyToMono(AppUser::class.java)

        val cloudOsFlux = cloudInstanceFlux.zipWith(osFlux)
            .map{
                val cloud = it.t1
                val myos = it.t2

                val cloudResponse = cloud.toDto()
                cloudResponse.operatingSystem=myos.toDto()
                cloudResponse
            }
        return cloudOsFlux.zipWith(appUserIdFlux)
            .flatMap {
                val  mycloud = it.t1
                val user = it.t2
                val users = fetchUserById(user)

                Mono.just(mycloud).zipWith(users)
                    .map { resultTup ->
                    val cloud = resultTup.t1
                    val result = resultTup.t2
                    cloud.appUser = result
                    cloud}

            }
//        val osMono = cloudInstanceMono
//            .flatMap {
//                operatingSystemRepository.findById(it.operatingSystemId)
//            }
//        return cloudInstanceMono.zipWith(osMono)
//            .map {
//                val cloud = it.t1
//                val myos = it.t2
//
//                val cloudResponse = cloud.toDto()
//                cloudResponse.operatingSystem = myos.toDto()
//
//                cloudResponse
//            }
    }




}