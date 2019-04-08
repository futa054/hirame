package com.spulse.hirame.controller


import com.spulse.hirame.model.Player
import com.spulse.hirame.PlayerService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/player")
class PlayerController(
        val playerService: PlayerService
) {

    @GetMapping("/find/{num}")
    fun find(@PathVariable num: Int): Player = playerService.find(num)?.let {
        it
    } ?:Player(12, "サポーター", "IS", "静岡県", java.sql.Date.valueOf(LocalDate.of(1991, 2, 4)), 100, 100)

}