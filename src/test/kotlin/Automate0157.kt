import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Automate0157 {
    val Etats_0157 = State.createStates("A",0,7)
    val Auto_0157 = Automate("01-57")

    @BeforeEach
    fun initAuto() {
        Auto_0157.addDeltaFromString(Etats_0157[0],"0",Etats_0157[1])
        Auto_0157.addDeltaFromString(Etats_0157[1],"1..9",Etats_0157[7])
        Auto_0157.addDeltaFromString(Etats_0157[0],"1..4",Etats_0157[3])
        Auto_0157.addDeltaFromString(Etats_0157[3],"0..9",Etats_0157[7])
        Auto_0157.addDeltaFromString(Etats_0157[0],"5",Etats_0157[5])
        Auto_0157.addDeltaFromString(Etats_0157[5],"0..7",Etats_0157[7])

        Auto_0157.setStartingState(Etats_0157[0])
        Auto_0157.addFinalState(Etats_0157[7])
    }
    @Test
    fun AcceptIncorrectSize1() { // too long
        assertFalse(Auto_0157.DoYouAccept("111"))
    }
    @Test
    fun AcceptIncorrectSize2() { // too short
        assertFalse(Auto_0157.DoYouAccept("1"))
    }

    @Test
    fun AcceptIncorrectValue1() { // under the possible value
        assertFalse(Auto_0157.DoYouAccept("00"))
    }
    @Test
    fun AcceptIncorrectValue2() { // above the last possible value
        assertFalse(Auto_0157.DoYouAccept("58"))
    }


    @Test
    fun AcceptCorrectValue1() { // something in 01-09
        assertTrue(Auto_0157.DoYouAccept("01"))
    }
    @Test
    fun AcceptCorrectValue2() { // something in 10-49
        assertTrue(Auto_0157.DoYouAccept("42"))
    }
    @Test
    fun AcceptCorrectValue3() { // something in 50-57
        assertTrue(Auto_0157.DoYouAccept("55"))
    }
}