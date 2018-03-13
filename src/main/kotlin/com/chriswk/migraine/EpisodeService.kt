package com.chriswk.migraine

import java.util.*

interface EpisodeService {
    fun retrieveEpisode(id: UUID): EpisodeDto?
    fun retrieveEpisodes(): List<EpisodeDto>
    fun addEpisode(create: EpisodeCreateDto): EpisodeDto
    fun updateEpisode(id: UUID, episode: EpisodeUpdateDto): EpisodeDto
}