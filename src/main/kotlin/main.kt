import com.jessecorbett.diskord.bot.bot
import com.jessecorbett.diskord.bot.classicCommands
import com.jessecorbett.diskord.bot.events
import configurations.DiscordConfigurations
import handlers.PalawaBotoHandler
import handlers.UsersLeaderboard

suspend fun main() {
    val botToken = DiscordConfigurations.properties.getProperty(
        DiscordConfigurations.PropertyKeys.DISCORD_BOT_TOKEN
    )

    bot(botToken) {
        events {
            onMessageCreate { msg ->
                if (msg.content.startsWith("praise joko!", ignoreCase = true)) {
                    if (UsersLeaderboard.incrementScore(msg.author.id, msg.author.username)) {
                        msg.respond(PalawaBotoHandler.generateRandomImageResponse())
                        msg.respond(PalawaBotoHandler.generateRandomTextResponse())
                    } else {
                        msg.respond(PalawaBotoHandler.generateRandomImageResponse())
                        msg.respond("**You useless servant, you already praised me today!**")
                    }
                }
            }
        }
        classicCommands("!joko ") {
            command("loyalists") { message ->
                val sb = StringBuilder()
                val topTen = UsersLeaderboard.generateTopTenMessage()
                sb.append("__**Here I present you with my loyalist servants:**__" + System.lineSeparator())
                sb.append(topTen)
                sb.append("Those who are not mentioned here are little weaklings that will suffer for eternity!!!" + System.lineSeparator())
                sb.append(System.lineSeparator())
                message.respond(sb.toString())
            }
            command("help") { message ->
                message.respond(PalawaBotoHandler.generateHelpMessage())
            }
        }
    }
}