class Automate(nom : String) {

    private lateinit var s0 : State
    private var sf : MutableSet<State> = mutableSetOf()
    private var nom : String = nom
    private var alpha : MutableSet<Char> = mutableSetOf()
    private var etats : MutableSet<State> = mutableSetOf()
    private var delta : HashMap<State,HashMap<Char,State>> = hashMapOf() /// E0 -> {'c' -> {"E1"}}
    ///////////////////////////////////Starting State | where we start
    fun setStartingState(s0 : State) {
        this.s0 = s0
    }

    fun getStartingState() = this.s0
    ///////////////////////////////////Final State | set of ending states
    fun addFinalState(s : State) {
        this.sf.add(s)
    }

    fun getFinalStates() = this.sf

    ///////////////////////////////////Delta | all transition within
    fun getDeltas() = this.delta //

    fun addDelta(source : State, c : Char ,destination : State) {
        alpha.add(c)
        etats.add(source)
        etats.add(destination)

        val h : HashMap<Char,State> = hashMapOf()
        source.addTransition(c,destination)

        delta.put(source,source.getTransition())
    }

    fun addDeltaFromList(source : State, ls : List<Char> ,destination : State) {
        ls.forEach{it -> (
            addDelta(source,it,destination)
        )}
    }

    fun addDeltaFromString(source : State, exp : String, destination : State) { //from like "a | b..c"
        val orexp = exp.split(" | ")
        orexp.forEach { it -> (
            if (it.contains("..")) { //is a..b
                val interexp = it.split("..")
                val a = interexp[0]
                val b = interexp[1]
                if (a.length==1 && b.length==1) {
                    addDeltaFromList(source,(a.toCharArray()[0]..b.toCharArray()[0]).toList(),destination)
                } else {
                    println("Impossible d'ajouté l'expression suivante : "+interexp)
                }

            } else  {
                if (it.length==1) { //is just a char
                    addDelta(source,it.toCharArray()[0],destination)
                } else {
                    println("Impossible d'ajouté l'expression suivante : "+it)
                }
            }
        )}
    }
    ///////////////////////////////////Alpha | all characters that can be checked
    fun getAlpha() = this.alpha

    ///////////////////////////////////States | all states within
    fun getStates() = this.etats

    ///////////////////////////////////Nom
    fun getNom() = this.nom

    ///////////////////////////////////Acceptor
    fun DoYouAccept(word : String, debug_Output : Boolean = true) : Boolean {
        var finalsState = getFinalStates()
        if (finalsState.size==0) {
            error("Pas de point de fin déclaré")
        }

        var currentState = getStartingState()
        var currentWord = word

        while (currentWord.isNotEmpty() || !finalsState.contains(currentState)) { // while not at one of the end AND still has characters left to check
            try {
                val old = currentState //save the state we are on

                currentState = currentState.getTransition().get(currentWord[0]) ?: return false // if it found one state linked to the 1st letter then move to it, else return false (nothing linked, stuck)

                if (debug_Output) {
                    println(old.getNom()+" ➜ "+currentState.getNom()) //told where we moved
                }

                currentWord = currentWord.drop(1) // edit word so that it remove the letter that was analysed
            } catch (e : Exception) { //In case of StringIndexesOutOfBound
                return false
            }
        }

        return true // no characters left AND reach one of the end
    }
}