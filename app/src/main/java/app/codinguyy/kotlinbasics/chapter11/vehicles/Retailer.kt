package app.codinguyy.kotlinbasics.chapter11.vehicles

interface Retailer<out T> {
    fun sell(): T
}
