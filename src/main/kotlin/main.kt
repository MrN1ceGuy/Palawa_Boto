import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import configurations.DiscordConfigurations
import handlers.PalawaBotoHandler

    suspend fun main() {
    val botToken = DiscordConfigurations.properties.getProperty(
        DiscordConfigurations.PropertyKeys.DISCORD_BOT_TOKEN
    )

    val handler = PalawaBotoHandler()

    bot(botToken) {
        commands("") {
            command("praise joko") {
                reply(handler.generateRandomImageRespose())
                reply(handler.generateRandomTextRespose())
            }
            command("!help") {
                reply(handler.generateHelpMessage())
            }
        }
    }
}