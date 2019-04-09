package com.spulse.hirame

import com.spulse.hirame.model.Player
import org.springframework.stereotype.Service

@Service
class PlayerService(
        val playerRepository: PlayerRepository
) {
    fun find(num: Int): Player? =
            playerRepository.findOneByNum(num)?.let {
                it
            }
    fun create(player: Player) = playerRepository.create(player)
    fun update(player: Player) = playerRepository.update(player.copy())
    fun delete(number: Int) = playerRepository.delete(number)
}