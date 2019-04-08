package com.spulse.hirame

import com.spulse.hirame.model.Player
import org.apache.ibatis.annotations.Select
import org.mapstruct.Mapper
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface PlayerRepository: PlayerMapper {

    @Select(
            """
                SELECT
                    number, name, position, birthplace, birthday, height, weight
                FROM
                    player
            """
    )
    override fun findAll(): List<Player?>

    @Select(
            """
                SELECT
                    number, name, position, birthplace, birthday, height, weight
                FROM
                    player
                WHERE
                    number = #{um}
            """
    )
    override fun findOneByNum(num: Int): Player?

}