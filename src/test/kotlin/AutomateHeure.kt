import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AutomateHeure {
    val Etats_heure = State.createStates("e",0,9)
    val Auto_heure = Automate("heure")

    @BeforeEach
    fun initAuto() {
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
    }

    @Test
    fun AcceptIncorrectSize1() { // one digit missing for the hour
        assertFalse(Auto_heure.DoYouAccept("0:01:01"))
    }
    @Test
    fun AcceptIncorrectSize2() { // one digit missing for the day
        assertFalse(Auto_heure.DoYouAccept("01:0:01"))
    }
    @Test
    fun AcceptIncorrectSize3() { // one digit missing for the second
        assertFalse(Auto_heure.DoYouAccept("01:01:0"))
    }


    @Test
    fun AcceptIncorrectValue1() { // too many hour
        assertFalse(Auto_heure.DoYouAccept("24:01:01"))
    }
    @Test
    fun AcceptIncorrectValue2() { // too many minute
        assertFalse(Auto_heure.DoYouAccept("01:60:01"))
    }
    @Test
    fun AcceptIncorrectValue3() { // too many second
        assertFalse(Auto_heure.DoYouAccept("01:01:60"))
    }


    @Test
    fun AcceptCorrectValue1() { // too many second
        assertTrue(Auto_heure.DoYouAccept("01:01:01"))
    }
}