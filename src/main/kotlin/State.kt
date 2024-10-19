class State(nom : String) {
    private var nom : String
    private var transitions: HashMap<Char,State> = hashMapOf()

    public fun getNom() = this.nom
    public fun getTransition() = this.transitions
    public fun addTransition(c : Char, destination : State) {
        transitions.put(c,destination)
    }
    init {
        this.nom = nom
    }

    companion object {
        public fun createStates(word : String,start : Int,end : Int) : MutableList<State> {
            val ls = mutableListOf<State>()
            (start..end).toList().forEach{ it -> (
                    ls.add(State(word+it))
            )}
            return ls
        }
    }
}