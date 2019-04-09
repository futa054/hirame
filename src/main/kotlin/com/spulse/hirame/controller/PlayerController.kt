package com.spulse.hirame.controller


import com.spulse.hirame.model.Player
import com.spulse.hirame.PlayerService
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate

@RestController
@RequestMapping("/player")
class PlayerController(
        val playerService: PlayerService
) {

    @GetMapping("/find/{num}")
    fun find(@PathVariable num: Int): Player = playerService.find(num)?.let {
        it
    } ?:Player(12, "サポーター", "IAI", "静岡県", java.sql.Date.valueOf(LocalDate.of(1991, 2, 4)), 0, 0)

    @PostMapping("/new")
    fun create(@ModelAttribute player: PlayerRequest) = playerService.create(
            Player(
                    number = player.number,
                    name = player.name,
                    position = player.position,
                    birthplace = player.birthplace,
                    birthday = java.sql.Date.valueOf(player.birthday),
                    height = player.height,
                    weight = player.weight
            )
    )

    @PostMapping("/update/{num}")
    fun update(@PathVariable num: Int, @ModelAttribute player: PlayerRequest) {
        playerService.find(num)?.let {
            playerService.update(it.copy(number =  player.number, name = player.name,
                    position = player.position, birthplace = player.birthplace,
                    birthday = java.sql.Date.valueOf(player.birthday),
                    height = player.height, weight = player.weight))
        }
    }

    @GetMapping("/delete/{num}")
    fun delete(@PathVariable num: Int) = playerService.delete(num)

    data class PlayerRequest(
            val number: Int,
            val name: String,
            val position: String,
            val birthplace: String,
            val birthday: String,
            val height: Int,
            val weight: Int
    )
}