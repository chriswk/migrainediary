package com.chriswk.migraine

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
internal interface EpisodeRepository : JpaRepository<Episode, UUID>