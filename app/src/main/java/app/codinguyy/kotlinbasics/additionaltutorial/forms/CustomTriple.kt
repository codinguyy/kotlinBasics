package app.codinguyy.kotlinbasics.additionaltutorial.forms

/**
 * We restrict to have nullable types with Any
 */

class CustomTriple<A : Any, B : Any, C : Any>(
    var first: A,
    var second: B,
    var third: C
) {

    fun printTypes() {
        println("The type if first ${first::class}")
        println("The type if first ${second::class}")
        println("The type if first ${third::class}")
    }
}
