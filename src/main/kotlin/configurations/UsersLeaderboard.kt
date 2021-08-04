package configurations

import java.io.File
import java.util.concurrent.atomic.AtomicInteger

object UsersLeaderboard {
    private const val FILE_NAME = "userLeaderboard.txt"
    private val leaderboard = hashMapOf<String, AtomicInteger>()
    private val leaderboardFile = File(FILE_NAME)

    init {
        if(!leaderboardFile.createNewFile()) {
            load()
        }
    }

    fun incrementScore(userId: String) {
        if(leaderboard.containsKey(userId)) {
            leaderboard[userId]?.incrementAndGet()
        } else {
            leaderboard[userId] = AtomicInteger(1)
        }
        save()
    }

    fun generateTopTenMessage() : String {
        val sb = StringBuilder()
        val sortedPrintableLeaderboard = getSortedLeaderboardMap().map {
            "<@${it.key}> with ${it.value} praises!"
        }

        // We generating messages only for top 10, if there are less than 10 people who have praised, it will generate
        // a message for all the players in the leaderboard
        if(sortedPrintableLeaderboard.size >= 10) {
            for (i in 0..9) {
                sb.append("**#${i + 1}** ${sortedPrintableLeaderboard[i]}${System.lineSeparator()}")
            }
        } else {
            for((i, msg) in sortedPrintableLeaderboard.withIndex()) {
                sb.append("**#${i + 1}** $msg${System.lineSeparator()}")
            }
        }

        return sb.toString()
    }

    private fun getSortedLeaderboardMap() : Map<String, AtomicInteger> =
        leaderboard.toList().sortedByDescending { (_, score) -> score.get() }.toMap()


    private fun save() {
        val sb = StringBuilder()
        leaderboard.forEach {
            sb.append("${it.key}|${it.value}${System.lineSeparator()}")
        }
        leaderboardFile.writeText(sb.toString())
    }

    private fun load() {
        leaderboardFile.forEachLine {
            val userData = it.split("|")
            leaderboard[userData.first()] = AtomicInteger(userData.last().toInt())
        }
    }
}