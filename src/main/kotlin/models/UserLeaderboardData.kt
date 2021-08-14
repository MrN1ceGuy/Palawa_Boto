package models

import java.time.LocalDate
import java.util.concurrent.atomic.AtomicInteger

data class UserLeaderboardData(
    val id: String,
    val score: AtomicInteger,
    var lastPraiseDate: LocalDate,
    var userName: String? = null
)
