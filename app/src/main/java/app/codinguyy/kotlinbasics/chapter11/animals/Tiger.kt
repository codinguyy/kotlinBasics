package app.codinguyy.kotlinbasics.chapter11.animals

import android.util.Log
import app.codinguyy.kotlinbasics.chapter6.animal.Animal

class Tiger : Animal() {

    /**
     * These methods cannot be implemented in the Animal class
     * Every animal has its only behavior of roaming, running or eating
     */
    override fun roam() {
        Log.i("Logging", "A tiger is roaming")
    }

    override fun run() {
        Log.i("Logging", "A tiger is running")
    }

    override fun eat() {
        Log.i("Logging", "A tiger is eating")
    }

    override fun name() {
        Log.i("Logging", "My name is Tiger")
    }
    /**
     * A tiger object can also use the sleep function, which is
     * implemented in the Animal class
     *
     * //sleep()
     */
}
