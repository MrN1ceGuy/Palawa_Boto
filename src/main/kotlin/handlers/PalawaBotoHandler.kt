package handlers

import kotlin.random.Random

class PalawaBotoHandler {
    private val jokoTextQuotes = ArrayList<String>()
    private val jokoImagesUrls = ArrayList<String>()

    init {
        initializeJokoImagesUrls()
        initializeJokoQuotes()
    }
    fun generateRandomTextRespose() : String {
        return jokoTextQuotes[Random.nextInt(0, jokoTextQuotes.lastIndex)]
    }
    fun generateRandomImageRespose() : String {
        return jokoImagesUrls[Random.nextInt(0, jokoImagesUrls.lastIndex)]
    }

    fun generateHelpMessage() : String {
        val sb = StringBuilder()
        sb.append(">>> ")
        sb.append("I am Palawa Joko! the Inevitable! The Last Primeval King! The Undying! The Scourge of Vabbi! The Feared! The Beloved! The Transcendent! The Eternal Monarch of All!" + System.lineSeparator())
        sb.append("You should praise me as your beloved king, useless mortal!")
        return sb.toString()
    }

    private fun initializeJokoImagesUrls() {
        jokoImagesUrls.add("https://wiki.guildwars.com/images/5/51/Palawa_Joko_concept_art.jpg")
        jokoImagesUrls.add("https://static.wikia.nocookie.net/villains/images/6/65/Joko.jpg/revision/latest?cb=20200914231831")
        jokoImagesUrls.add("https://pbs.twimg.com/profile_images/1011597809009790976/i4XOlJ2x.jpg")
        jokoImagesUrls.add("https://wiki.guildwars2.com/images/f/f2/Palawa_Joko_%28actor%29.jpg")
        jokoImagesUrls.add("https://cdna.artstation.com/p/assets/images/images/024/625/970/large/marcus-jackson-jokoono-006.jpg?1583020619")
        jokoImagesUrls.add("https://i.redd.it/wc7oae8xepmz.jpg")
        jokoImagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjP4dDxBNo1yHXLhnh51nZGEHC80SPw_sQ0Q&usqp=CAU")
        jokoImagesUrls.add("https://static.wikia.nocookie.net/behemoth/images/0/0c/Palawa_Joko.jpg/revision/latest?cb=20191201124658&path-prefix=de")
        jokoImagesUrls.add("https://cdna.artstation.com/p/assets/images/images/024/625/972/large/marcus-jackson-jokoono-007.jpg?1583020495")
        jokoImagesUrls.add("https://i.redd.it/8nim593ebdu11.jpg")
    }

    private fun initializeJokoQuotes() {
        jokoTextQuotes.add("No, No, No! Mummified flesh on the left! Dried bones on the right! No, your other right! You worthless bits of animated anatomy!")
        jokoTextQuotes.add("Oh, just curious, can you even SPELL \"epidemic\"?")
        jokoTextQuotes.add("How disappointing. And honestly, unexpected, I thought you would present better")
        jokoTextQuotes.add("The commander of the Pact. Hero of blah-blah-blah. Rendered useless by a glorified parlor trick")
        jokoTextQuotes.add("Oh-ho, Commander. You DO know how to flatter a lich")
        jokoTextQuotes.add("A question: do you love pain as I do? Live this long, and sensations lose their savor")
        jokoTextQuotes.add("This is really how you fight? Your form is terrible. Do you ever actually beat anyone?")
        jokoTextQuotes.add("It's funny, I remember you being taller. And better looking")
        jokoTextQuotes.add("Oh, you're going to LOVE being Awakened")
        jokoTextQuotes.add("Oh, Commander, you look so disappointed. So impotent. I feel for you, I really do.")
        jokoTextQuotes.add("I confess, I was happy to take credit for your \"victories.\"")
        jokoTextQuotes.add("My reach is vast, my vengeance legendary. I alone can liberate you from your dull, falvorless friends and loved ones.")
        jokoTextQuotes.add("Ah, my ever loyal minion. Those Ossas never give me a moment of peace.")
        jokoTextQuotes.add("Well, hello there well-to-do hero type.")
        jokoTextQuotes.add("You miserable hunks of desiccated flesh! I leave you alone for a few hundred years and you let everything go to hell! Now that I'm back, things are going to be different.")
        jokoTextQuotes.add("Let all the desert region see that defying me is certain death.")
        jokoTextQuotes.add("Skillful. Ruthless. Perhaps lacking a bit in spectacle... Still, your king approves.")
        jokoTextQuotes.add("Now, before these Sunspears can live forever serving their king, they have to die. Get to killing.")
        jokoTextQuotes.add("Repay the kindness of your benevolent king by opening the throats of the Sunspears")
        jokoTextQuotes.add("There can be no mercy for the enemies of King Joko the Beloved.")
        jokoTextQuotes.add("Gods, dragons, nations—soon all will grovel at the feet of Palawa Joko!")
    }
}