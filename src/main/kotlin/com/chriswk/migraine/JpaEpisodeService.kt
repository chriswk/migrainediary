package com.chriswk.migraine

import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
internal class JpaEpisodeService(val episodeRepository: EpisodeRepository) : EpisodeService {
    override fun retrieveEpisode(id: UUID): EpisodeDto? {
        return episodeRepository.findById(id).map { it.toDto() }.orElse(null)
    }

    override fun retrieveEpisodes(): List<EpisodeDto> {
        return episodeRepository.findAll().map { it.toDto() }
    }

    override fun addEpisode(create: EpisodeCreateDto): EpisodeDto {
        return episodeRepository.save(Episode.fromCreateDto(create)).toDto()
    }

    override fun updateEpisode(id: UUID, update: EpisodeUpdateDto): EpisodeDto {
        val current = episodeRepository.getOne(id)
        val update = Episode.fromUpdateDto(update, current)
        return episodeRepository.save(update).toDto()
    }
}