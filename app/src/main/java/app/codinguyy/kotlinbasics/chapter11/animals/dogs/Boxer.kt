package app.codinguyy.kotlinbasics.chapter11.animals.dogs

import android.util.Log

class Boxer : Dogs() {
    var hunger: Int = 0
        get() = 10
        set(value) {
            if (value < 10) field = value
        }

    /**
     * Class hierarchy: Animals -> Dogs -> Boxer
     * Dogs have specific behavior how to eat in comparisson to other
     * types of animals. So we need to implement this behavior in the
     * class Dogs
     *
     * But the way how a Boxer eats is also differnt in comparission to other
     * dogs. So we need to implement a more specific eat method here.
     */

    /**
     * The rest of the methods (roaming, running) is the same with other dogs
     * So the system will look for methods in the dogs class.
     */

    override fun eat() {
        // super.eat() // this will execute the eat method from the dogs class
        Log.i("Logging", "A boxer is eating")
    }

    override fun name() {
        println("Mt name is Boxer")
    }
}
