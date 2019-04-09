package com.spulse.hirame

import com.spulse.hirame.model.Player
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
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

    @Insert(
            """
        INSERT INTO player
            (number, name, position, birthplace, birthday, height, weight)
        VALUES
            (#{number}, #{name}, #{position}, #{birthplace}, #{birthday}, #{height}, #{weight});
    """
    )
    override fun create(player: Player)

    @Update(
            """
        UPDATE player SET
            name = #{name},
            position = #{position},
            birthplace = #{birthplace},
            birthday = #{birthday},
            height = #{height},
            weight = #{weight}
        WHERE
            number = #{number}
    """
    )
    override fun update(player: Player)

    @Delete(
            """
                DELETE FROM
                    player
                WHERE
                    number = #{number}
    """
    )
    override fun delete(number: Int)

}