import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AutomateDate {
    val Etats_Date = State.createStates("D",0,29)
    val Auto_Date = Automate("jj/mm/aaaa")

    @BeforeEach
    fun initAuto() {
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
    }

    @Test
    fun AcceptIncorrectSize1() { // one digit missing for the year
        assertFalse(Auto_Date.DoYouAccept("01/01/005"))
    }
    @Test
    fun AcceptIncorrectSize2() { // one digit missing for the month
        assertFalse(Auto_Date.DoYouAccept("01/1/1000"))
    }
    @Test
    fun AcceptIncorrectSize3() { // one digit missing for the day
        assertFalse(Auto_Date.DoYouAccept("1/01/1000"))
    }


    @Test
    fun AcceptIncorrectDayMonth1() { // 30 day's month not allowed to have 31
        assertFalse(Auto_Date.DoYouAccept("31/04/9999"))
    }
    @Test
    fun AcceptIncorrectDayMonth2() { // 29th of february not allowed
        assertFalse(Auto_Date.DoYouAccept("29/02/9999"))
    }
    @Test
    fun AcceptIncorrectDayMonth3() { // zero day not allowed
        assertFalse(Auto_Date.DoYouAccept("00/01/9999"))
    }
    @Test
    fun AcceptIncorrectDayMonth4() { // zero month not allowed
        assertFalse(Auto_Date.DoYouAccept("01/00/9999"))
    }
    @Test
    fun AcceptIncorrectYear() { // zero year not allowed
        assertFalse(Auto_Date.DoYouAccept("01/01/0000"))
    }


    @Test
    fun AcceptCorrectYear1() { // Year of the form ----
        assertTrue(Auto_Date.DoYouAccept("02/09/9999"))
    }
    @Test
    fun AcceptCorrectYear2() { // Year of the form 0---
        assertTrue(Auto_Date.DoYouAccept("01/01/0999"))
    }
    @Test
    fun AcceptCorrectYear3() { // Year of the form -0--
        assertTrue(Auto_Date.DoYouAccept("01/01/9099"))
    }
    @Test
    fun AcceptCorrectYear4() { // Year of the form --0-
        assertTrue(Auto_Date.DoYouAccept("01/01/9909"))
    }
    @Test
    fun AcceptCorrectYear5() { // Year of the form ---0
        assertTrue(Auto_Date.DoYouAccept("01/01/9990"))
    }
    @Test
    fun AcceptCorrectDayMonth() {
        assertTrue(Auto_Date.DoYouAccept("28/02/9999"))
    }
}