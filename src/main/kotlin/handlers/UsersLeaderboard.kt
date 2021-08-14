package handlers

import models.UserLeaderboardData
import java.io.File
import java.time.LocalDate
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.set

object UsersLeaderboard {
    private const val FILE_NAME = "userLeaderboard.txt"
    private val leaderboard = hashMapOf<String, UserLeaderboardData>()
    private val leaderboardFile = File(FILE_NAME)

    init {
        if (!leaderboardFile.createNewFile()) {
            load()
        }
    }

    fun incrementScore(userId: String, userName: String): Boolean {
        if (leaderboard.containsKey(userId)) {
            return if (isEligibleForPraisingToday(leaderboard[userId]!!.lastPraiseDate)) {
                leaderboard[userId]?.score?.incrementAndGet()
                leaderboard[userId]?.lastPraiseDate = LocalDate.now()

                if (leaderboard[userId]?.userName.isNullOrEmpty()) {
                    leaderboard[userId]?.userName = userName
                }

                save()

                true
            } else {
                false
            }
        } else {
            leaderboard[userId] = UserLeaderboardData(
                id = userId,
                score = AtomicInteger(1),
                lastPraiseDate = LocalDate.now(),
                userName = userName
            )
            save()

            return true
        }
    }

    fun generateTopTenMessage(): String {
        val sb = StringBuilder()
        val sortedPrintableLeaderboard = getSortedLeaderboardMap().map {
            val displayName = if(it.value.userName.isNullOrEmpty()) {
                "<@${it.key}>"
            } else {
                it.value.userName
            }

            "$displayName with ${it.value.score} praises!"
        }

        // We're generating messages only for top 10, if there are less than 10 people who have praised, it will generate
        // a message for all the players in the leaderboard
        if (sortedPrintableLeaderboard.size >= 10) {
            for (i in 0..9) {
                sb.append("**#${i + 1}** ${sortedPrintableLeaderboard[i]}${System.lineSeparator()}")
            }
        } else {
            for ((i, msg) in sortedPrintableLeaderboard.withIndex()) {
                sb.append("**#${i + 1}** $msg${System.lineSeparator()}")
            }
        }

        return sb.toString()
    }

    private fun getSortedLeaderboardMap(): Map<String, UserLeaderboardData> =
        leaderboard.toList().sortedByDescending { (_, user) -> user.score.get() }.toMap()


    private fun save() {
        val sb = StringBuilder()
        leaderboard.forEach {
            sb.append("${it.key}|${it.value.score}|${it.value.lastPraiseDate.toEpochDay()}|${it.value.userName}${System.lineSeparator()}")
        }
        leaderboardFile.writeText(sb.toString())
    }

    private fun load() {
        leaderboardFile.forEachLine {
            val userData = it.split("|")

            if (userData.size < 3) {
                println("corrupted user data: $userData")
                throw Exception("detected corrupted userdata, terminating...")
            } else {
                leaderboard[userData[0]] = UserLeaderboardData(
                    id = userData[0],
                    score = AtomicInteger(userData[1].toInt()),
                    lastPraiseDate = LocalDate.ofEpochDay(userData[2].toLong())
                )
                if (userData.size == 4) {
                    leaderboard[userData[0]]?.userName = userData[3]
                }
            }
        }
    }

    private fun isEligibleForPraisingToday(lastPraiseTime: LocalDate): Boolean {
        return lastPraiseTime.plusDays(1).isBefore(LocalDate.now()) ||
                lastPraiseTime.plusDays(1).isEqual(LocalDate.now())
    }
}