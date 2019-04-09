package com.spulse.hirame.model

import java.sql.Date

/**
 *
 */
data class Player(
        var number: Int,
        var name: String,
        var position: String,
        var birthplace: String,
        var birthday: Date,
        var height: Int,
        var weight: Int
                  ) {
}