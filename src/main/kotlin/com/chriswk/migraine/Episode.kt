package com.chriswk.migraine

import java.util.UUID
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id

@Entity
@Table(name = "episodes")
internal data class Episode(@Id val id: UUID? = UUID.randomUUID(),
                            val happened: LocalDate = LocalDate.now(),
                            val duration: Long,
                            val severity: Int
) {
    fun toDto(): EpisodeDto =
            EpisodeDto(id = this.id!!, happened = this.happened, duration = this.duration, severity = this.severity)

    companion object {
        fun fromDto(dto: EpisodeDto): Episode =
                Episode(id = dto.id,
                        happened = dto.happened,
                        duration = dto.duration,
                        severity = dto.severity)

        fun fromCreateDto(dto: EpisodeCreateDto): Episode = Episode(id = UUID.randomUUID(),
                happened = dto.happened,
                duration = dto.duration,
                severity = dto.severity)

        fun fromUpdateDto(dto: EpisodeUpdateDto, original: Episode): Episode =
                Episode(id = original.id!!,
                        happened = dto.happened ?: original.happened,
                        duration = dto.duration ?: original.duration,
                        severity = dto.severity ?: original.severity
                )

    }
}

data class EpisodeCreateDto(val happened: LocalDate, val duration: Long, val severity: Int)
data class EpisodeDto(val id: UUID, val happened: LocalDate, val duration: Long, val severity: Int)
data class EpisodeUpdateDto(val happened: LocalDate?, val duration: Long?, val severity: Int?)

