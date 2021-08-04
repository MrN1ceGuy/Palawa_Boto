import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import configurations.DiscordConfigurations
import configurations.UsersLeaderboard
import handlers.PalawaBotoHandler

suspend fun main() {
    val botToken = DiscordConfigurations.properties.getProperty(
        DiscordConfigurations.PropertyKeys.DISCORD_BOT_TOKEN
    )

    val handler = PalawaBotoHandler()

    bot(botToken) {
        commands("!joko ") {
            messageCreated { msg ->
                if(msg.content.startsWith("praise joko!", ignoreCase = true)) {
                    UsersLeaderboard.incrementScore(msg.author.id)
                    msg.reply(handler.generateRandomImageResponse())
                    msg.reply(handler.generateRandomTextResponse())
                }
            }
            command("loyalists") {
                val sb = StringBuilder()
                val topTen = UsersLeaderboard.generateTopTenMessage()
                sb.append("__**Here I present you with my loyalists servants:**__" + System.lineSeparator())
                sb.append(topTen)
                sb.append("Those who are not mentioned here are little weaklings that will suffer for eternity!!!" + System.lineSeparator())
                sb.append(System.lineSeparator())
                reply(sb.toString())
            }
            command("help") {
                reply(handler.generateHelpMessage())
            }
        }
    }
}