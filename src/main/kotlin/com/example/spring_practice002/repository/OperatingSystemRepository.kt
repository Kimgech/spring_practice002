package com.example.spring_practice002.repository

import com.example.spring_practice002.model.entity.OperatingSystem
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface OperatingSystemRepository : ReactiveCrudRepository<OperatingSystem,Long> {

}
