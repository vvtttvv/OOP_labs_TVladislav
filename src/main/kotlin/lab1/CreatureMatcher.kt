package lab1

//Selected object to have opportunity to use function immediately
object CreatureMatcher {
    fun matches(creature: Creatures, individual: Node): Boolean {
        return  creature.planet == individual.planetName ||
                (individual.traits?.all { it in creature.traits } == true &&
                        creature.isHumanoid == (individual.isHumanoid ?: creature.isHumanoid) &&
                        creature.age >= (individual.age ?: 0)) ||
                (creature.age >= (individual.age ?: 0) && (individual.age ?: 0) > 5000)
    }
}

