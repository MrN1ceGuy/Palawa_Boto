package configurations

import java.io.*
import java.util.*
import kotlin.system.exitProcess

object DiscordConfigurations {
    private const val CONFIGURATION_DIRECTORY = "./config"
    private const val PROPERTIES_FILE_NAME = "DiscordConfiguration.properties"

    var properties = Properties()

    init {
        val filePath = "$CONFIGURATION_DIRECTORY/$PROPERTIES_FILE_NAME"
        try {
            properties.load(FileInputStream(filePath))
        } catch (e: IOException) {
            println("Properties file at $filePath, creating default properties file instead.")
            properties = createDefault()
            File(CONFIGURATION_DIRECTORY).mkdir()
            properties.store(OutputStreamWriter(FileOutputStream(filePath), Charsets.UTF_8), null)
            println(
                "Default configuration created successfully, the program will now exit," +
                        " please set the default configuration values in the property file at $filePath"
            )

            // To trigger the Sources object for the sources files to be created (image urls and quotes)
            Sources

            exitProcess(1)
        }
    }

    private fun createDefault(): Properties {
        val defProp = Properties()

        defProp.setProperty(PropertyKeys.DISCORD_BOT_TOKEN, "{insert_api_key_here}")

        return defProp
    }

    object PropertyKeys {
        const val DISCORD_BOT_TOKEN = "discord_bot_api_key"
    }
}