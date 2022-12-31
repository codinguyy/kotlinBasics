package app.codinguyy.kotlinbasics.chapter11.animals.dogs

class GreyHound : Dogs() {
    /**
     * run cannot be overriden, because its final
     */
    /*
    override fun run() {
        super.run()
    }
     */

    override fun name() {
        println("My name is GreyHound")
    }
}
