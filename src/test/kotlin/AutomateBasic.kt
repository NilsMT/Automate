import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AutomateBasic {

    var auto = Automate("test")
    val a = State("A")
    val b = State("B")
    val c = State("C")

    @BeforeEach
    fun initauto() //autorize : "00" "1"
    {
        auto.addDelta(a,'0',b)// a -> 0 b
        auto.addDelta(a,'1',c)// a -> 1 c
        auto.addDelta(b,'0',c)// b -> 0 c
    }

    @Test
    fun addDelta() {
        val res = hashMapOf(a to hashMapOf('1' to c,'0' to b),b to hashMapOf('0' to c))
        assertEquals(auto.getDeltas(),res)
    }

    @Test
    fun getAlpha() {
        assertEquals(auto.getAlpha(),mutableSetOf('0','1'))
    }

    @Test
    fun getStates() {
        assertEquals(auto.getStates(),mutableSetOf(a,b,c))
    }

    @Test
    fun noFinalState() {
        auto.setStartingState(a)
        assertThrows<IllegalStateException>({auto.DoYouAccept("something")})
    }

    @Test
    fun noStartingState() {
        auto.addFinalState(c)
        assertThrows<Exception>({auto.DoYouAccept("something")})
    }

    @Test
    fun Accepting() {
        auto.setStartingState(a)
        auto.addFinalState(c)
        assertTrue(auto.DoYouAccept("00",true))
        assertTrue(auto.DoYouAccept("1",true))
    }

    @Test
    fun NotAccepting() {
        auto.setStartingState(a)
        auto.addFinalState(c)
        assertFalse(auto.DoYouAccept("11",true))
    }
}