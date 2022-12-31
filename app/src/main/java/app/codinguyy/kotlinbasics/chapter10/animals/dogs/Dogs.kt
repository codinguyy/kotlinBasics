package app.codinguyy.kotlinbasics.chapter10.animals.dogs

import android.util.Log
import app.codinguyy.kotlinbasics.chapter10.animals.Animal


abstract class Dogs : Animal() {

    override fun roam() {
        Log.i("Logging", "dog is roaming")
    }

    /**
     * This means that the run method cannot be overriden
     * further down in the class hierarchy
     */
    final override fun run() {
        Log.i("Logging", "dog is runnning")
    }

    override fun eat() {
        Log.i("Logging", "dog is eating")
    }

    override fun name() {
        println("My name is Dogs")
    }
}
