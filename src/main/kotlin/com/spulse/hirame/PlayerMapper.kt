package com.spulse.hirame

import com.spulse.hirame.model.Player

interface PlayerMapper {
    fun findAll(): List<Player?>
    fun findOneByNum(num: Int): Player?
    fun create(player: Player)
    fun update(player: Player)
    fun delete(num: Int)
}