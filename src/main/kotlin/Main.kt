import kotlin.Exception

fun createAuto_Heure() : Automate {

    val Etats_heure = State.createStates("e",0,9)
    val Auto_heure = Automate("heure")
    Auto_heure.addDeltaFromString(Etats_heure[0],"0 | 1",Etats_heure[1])
    Auto_heure.addDeltaFromString(Etats_heure[0],"2",Etats_heure[2])
    Auto_heure.addDeltaFromString(Etats_heure[1],"0..9",Etats_heure[3])
    Auto_heure.addDeltaFromString(Etats_heure[2],"0..3",Etats_heure[3])
    Auto_heure.addDeltaFromString(Etats_heure[3],":",Etats_heure[4])
    Auto_heure.addDeltaFromString(Etats_heure[4],"0..5",Etats_heure[5])
    Auto_heure.addDeltaFromString(Etats_heure[5],"0..9",Etats_heure[6])
    Auto_heure.addDeltaFromString(Etats_heure[6],":",Etats_heure[7])
    Auto_heure.addDeltaFromString(Etats_heure[7],"0..5",Etats_heure[8])
    Auto_heure.addDeltaFromString(Etats_heure[8],"0..9",Etats_heure[9])

    Auto_heure.setStartingState(Etats_heure[0])
    Auto_heure.addFinalState(Etats_heure[9])

    return Auto_heure
}

fun createAuto_Date() : Automate {
    val Etats_Date = State.createStates("D",0,29)
    val Auto_Date = Automate("jj/mm/aaaa")

    Auto_Date.addDeltaFromString(Etats_Date[0], "0", Etats_Date[1])
    Auto_Date.addDeltaFromString(Etats_Date[0], "1", Etats_Date[2])
    Auto_Date.addDeltaFromString(Etats_Date[0], "2", Etats_Date[3])
    Auto_Date.addDeltaFromString(Etats_Date[1], "1..9", Etats_Date[4])
    Auto_Date.addDeltaFromString(Etats_Date[2], "0..9", Etats_Date[4])
    Auto_Date.addDeltaFromString(Etats_Date[3], "0..8", Etats_Date[4])
    Auto_Date.addDeltaFromString(Etats_Date[4], "/", Etats_Date[5])
    Auto_Date.addDeltaFromString(Etats_Date[5], "0", Etats_Date[6])
    Auto_Date.addDeltaFromString(Etats_Date[5], "1", Etats_Date[7])
    Auto_Date.addDeltaFromString(Etats_Date[3], "9", Etats_Date[8])
    Auto_Date.addDeltaFromString(Etats_Date[8], "/", Etats_Date[9])
    Auto_Date.addDeltaFromString(Etats_Date[9], "0", Etats_Date[10])
    Auto_Date.addDeltaFromString(Etats_Date[9], "1", Etats_Date[11])
    Auto_Date.addDeltaFromString(Etats_Date[12], "0", Etats_Date[13])
    Auto_Date.addDeltaFromString(Etats_Date[13], "/", Etats_Date[14])
    Auto_Date.addDeltaFromString(Etats_Date[14], "0", Etats_Date[15])
    Auto_Date.addDeltaFromString(Etats_Date[14], "1", Etats_Date[16])
    Auto_Date.addDeltaFromString(Etats_Date[12], "1", Etats_Date[17])
    Auto_Date.addDeltaFromString(Etats_Date[17], "1", Etats_Date[18])
    Auto_Date.addDeltaFromString(Etats_Date[18], "0", Etats_Date[19])
    Auto_Date.addDeltaFromString(Etats_Date[18], "1", Etats_Date[20])
    Auto_Date.addDeltaFromString(Etats_Date[6], "1..9", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[7], "0..2", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[10], "1 | 3..9", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[11], "0..2", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[15], "1 | 3..9", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[16], "0..2", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[19], "1 | 3 | 5 | 7 | 8", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[20], "0 | 2", Etats_Date[21])
    Auto_Date.addDeltaFromString(Etats_Date[21], "/", Etats_Date[22])
    Auto_Date.addDeltaFromString(Etats_Date[22], "0", Etats_Date[23])
    Auto_Date.addDeltaFromString(Etats_Date[23], "0", Etats_Date[24])
    Auto_Date.addDeltaFromString(Etats_Date[24], "0", Etats_Date[25])
    Auto_Date.addDeltaFromString(Etats_Date[22], "1..9", Etats_Date[26])
    Auto_Date.addDeltaFromString(Etats_Date[26], "0..9", Etats_Date[27])
    Auto_Date.addDeltaFromString(Etats_Date[27], "0..9", Etats_Date[28])
    Auto_Date.addDeltaFromString(Etats_Date[28], "0..9", Etats_Date[29])
    Auto_Date.addDeltaFromString(Etats_Date[25], "1..9", Etats_Date[29])
    Auto_Date.addDeltaFromString(Etats_Date[23], "1..9", Etats_Date[27])
    Auto_Date.addDeltaFromString(Etats_Date[24], "1..9", Etats_Date[28])
    //set Start and End
    Auto_Date.setStartingState(Etats_Date[0])
    Auto_Date.addFinalState(Etats_Date[29])
    return Auto_Date
}

fun createAuto_0157() : Automate {
    val Etats_0157 = State.createStates("A",0,7)
    val Auto_0157 = Automate("01-57")

    Auto_0157.addDeltaFromString(Etats_0157[0],"0",Etats_0157[1])
    Auto_0157.addDeltaFromString(Etats_0157[1],"1..9",Etats_0157[7])
    Auto_0157.addDeltaFromString(Etats_0157[0],"1..4",Etats_0157[3])
    Auto_0157.addDeltaFromString(Etats_0157[3],"0..9",Etats_0157[7])
    Auto_0157.addDeltaFromString(Etats_0157[0],"5",Etats_0157[5])
    Auto_0157.addDeltaFromString(Etats_0157[5],"0..7",Etats_0157[7])

    Auto_0157.setStartingState(Etats_0157[0])
    Auto_0157.addFinalState(Etats_0157[7])
    return Auto_0157
}


// ANSI Codes found online : https://gist.github.com/JBlond/2fea43a3049b38287e5e9cefc87b2124
// light red : ${"\u001B[91m"}
// light purple : ${"\u001B[95m"}
// light yellow : ${"\u001B[93m"}
// light green : ${"\u001B[92m"}
// blue : ${"\u001B[34m"}
// end ANSI : ${"\u001B[0m"}

fun main(args: Array<String>) {
    lateinit var auto : Automate
    var input : String

    while (true) {

        ////INPUT CHOIX AUTOMATE
        println("""
            ${"\u001B[93m"}--------------- Menu de mon TP ------------------${"\u001B[0m"}
            ${"\u001B[93m"}1. 01-57 (pour reconnaitre un chiffre entre 01 et 57)${"\u001B[0m"}
            ${"\u001B[93m"}2. HH:MM (pour reconnaitre une heure bien formée)${"\u001B[0m"}
            ${"\u001B[93m"}3. JJ/MM/AAAA (pour reconnaitre une date bien formée)${"\u001B[0m"}
            ${"\u001B[93m"}99. Arrêt de l'application${"\u001B[0m"}
        """.trimIndent())
        println("""
            ${"\u001B[95m"}--------------- Question ------------------------${"\u001B[0m"}
            ${"\u001B[95m"}Quel est votre choix ? (1-99)${"\u001B[0m"}
            ${"\u001B[95m"}-------------------------------------------------${"\u001B[0m"}
        """.trimIndent())
        input = readln()
        try {
            input.toInt()
            when(input.toInt()) {
                99 -> {break}
                1 -> auto = createAuto_0157()
                2 -> auto = createAuto_Heure()
                3 -> auto = createAuto_Date()
                else -> throw Exception()
            }

            while (true) {
                ////INPUT CHAINE A ANALYSER
                println("""
                    ${"\u001B[95m"}--------------- Question ------------------------${"\u001B[0m"}
                    ${"\u001B[95m"}Quel est la chaine de caractère que vous voulez analyser ?${"\u001B[0m"}
                    ${"\u001B[95m"}-------------------------------------------------${"\u001B[0m"}
                """.trimIndent())

                input = readln()

                val answer = auto.DoYouAccept(input,false)
                var m = ""
                m = if (answer) {
                    "la chaine \""+input+"\" \u001B[92m est acceptée\u001B[0m"
                } else {
                    "la chaine \""+input+"\" \u001B[91m n'est pas acceptée\u001B[0m"
                }

                ////INPUT ACTION RETOUR MENU (OU NON)


                println("""
                    --------------- Résultat ------------------------
                    ${m}
                """.trimIndent())
                println("""
                    ${"\u001B[95m"}--------------- Question ------------------------${"\u001B[0m"}
                    ${"\u001B[95m"}Voulez-vous retourner au menu [o/n] ?${"\u001B[0m"}
                    ${"\u001B[95m"}-------------------------------------------------${"\u001B[0m"}
                """.trimIndent())

                input = readln()

                when(input) {
                    "O" -> {break}
                    "o" -> {break}
                }
            }
        } catch (e : Exception) {
            println("""
            ${"\u001B[91m"}--------------- Erreur --------------------------${"\u001B[0m"}
            ${"\u001B[91m"}"${input}" n'est pas mode disponible, ${"\u001B[0m"}
            ${"\u001B[91m"}Veuillez réessayer${"\u001B[0m"}
            """.trimIndent())
        }
    }
    println("\n\u001B[34mAurevoir \uD83D\uDC4B \u001B[0m \n")
}