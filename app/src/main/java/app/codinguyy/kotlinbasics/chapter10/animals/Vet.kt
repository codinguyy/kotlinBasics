package app.codinguyy.kotlinbasics.chapter10.animals

class Vet<in T : Animal> {
    fun treat(t: T) {
        println("Treat Animal ${t.name()}")
    }
}
