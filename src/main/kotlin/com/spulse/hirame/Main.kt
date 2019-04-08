package com.spulse.hirame


import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.spulse.hirame")
class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}