package app.codinguyy.kotlinbasics.chapter6

import android.util.Log
import app.codinguyy.kotlinbasics.util.Constants.TAG

interface ITransportable {
    /**
     * This is an abstract method.
     * The abstract keyword is not needed, because we are in a interface here.
     * Its already clear that this method needs to be overriden
     */
    fun transport()

    fun pull(type: String) {
        Log.i(TAG, "$type + pulling")
    }
}
