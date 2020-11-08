package com.gabriel.lunala.project.backend.entities

import com.gabriel.lunala.project.backend.database.tables.GuildTable
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Guild(id: EntityID<Long>): LongEntity(id) {

    companion object: LongEntityClass<Guild>(GuildTable)

    var partner by GuildTable.partner

    fun toResponseDto() = GuildResponseDTO(id.value, partner)

}

@Serializable
data class GuildCreateDTO(val id: Long, val partner: Boolean)

@Serializable
data class GuildUpdateDTO(val partner: Boolean?)

@Serializable
data class GuildResponseDTO(val id: Long, val partner: Boolean)