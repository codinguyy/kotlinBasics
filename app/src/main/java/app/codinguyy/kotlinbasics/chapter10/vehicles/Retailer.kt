package app.codinguyy.kotlinbasics.chapter10.vehicles

interface Retailer<out T> {
    fun sell(): T
}
