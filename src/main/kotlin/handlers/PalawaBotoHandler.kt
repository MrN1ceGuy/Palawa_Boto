package handlers

import configurations.Sources
import kotlin.random.Random

class PalawaBotoHandler {
    private val jokoTextQuotes = Sources.quotesUrls
    private val jokoImagesUrls = Sources.imageUrls

//    init {
//        initializeJokoImagesUrls()
//        initializeJokoQuotes()
//    }
    fun generateRandomTextResponse() : String {
        return jokoTextQuotes[Random.nextInt(0, jokoTextQuotes.lastIndex)]
    }
    fun generateRandomImageResponse() : String {
        return jokoImagesUrls[Random.nextInt(0, jokoImagesUrls.lastIndex)]
    }

    fun generateHelpMessage() : String {
        val sb = StringBuilder()
        sb.append(">>> ")
        sb.append("I am Palawa Joko! the Inevitable! The Last Primeval King! The Undying! The Scourge of Vabbi! The Feared! The Beloved! The Transcendent! The Eternal Monarch of All!" + System.lineSeparator())
        sb.append("You should praise me as your beloved king, useless mortal!")
        return sb.toString()
    }
}