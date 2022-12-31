package app.codinguyy.kotlinbasics.chapter6.animal

import app.codinguyy.kotlinbasics.chapter6.ITransportable


abstract class Animal : ITransportable {
    /**
     * An interface can also have variables, how?
     *
     */

    /**
     * We need to override this methods in the subclasses,
     * because every animal has its own way to roam, run or eat
     */
    abstract fun roam()
    abstract fun run()
    abstract fun eat()
    abstract fun name()

    /**
     * Every animal is sl¬eeping the same way: Eyes closed.
     */
    fun sleeping() {
        println("sleeping")
    }

    /**
     * We need to add add a interface method.
     * In this way dogs can transport things from place A to B
     */
    override fun transport() {
        TODO("Not yet implemented")
    }
}
