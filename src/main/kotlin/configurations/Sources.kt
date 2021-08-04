package configurations

import java.io.File
import kotlin.system.exitProcess

object Sources {
    private const val IMAGE_SOURCES_FILE_NAME = "imagesSources.txt"
    private const val QUOTE_SOURCES_FILE_NAME = "quotesSources.txt"

    val imageUrls = arrayListOf<String>()
    val quotesUrls = arrayListOf<String>()

    //
    init {
        var isSourceFilesExists = true
        if(!File(IMAGE_SOURCES_FILE_NAME).exists()) {
            File(IMAGE_SOURCES_FILE_NAME).writeText("remove this text and write the images urls here separated by line")
            isSourceFilesExists = false
        } else {
            imageUrls.addAll(File(IMAGE_SOURCES_FILE_NAME).readText().split(System.lineSeparator()))
        }

        if(!File(QUOTE_SOURCES_FILE_NAME).exists()) {
            File(QUOTE_SOURCES_FILE_NAME).writeText("remove this text and write the quotes here separated by line")
            isSourceFilesExists = false
        } else {
            quotesUrls.addAll(File(QUOTE_SOURCES_FILE_NAME).readText().split(System.lineSeparator()))
        }

        if(!isSourceFilesExists) {
            println("Source files have been generated, please fill them up with image urls/quotes, the program will now exit")
            exitProcess(1)
        }
    }
}