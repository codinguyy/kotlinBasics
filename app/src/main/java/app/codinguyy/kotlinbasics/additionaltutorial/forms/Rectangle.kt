package app.codinguyy.kotlinbasics.additionaltutorial.forms

class Rectangle(val a: Int, val b: Int) : Shapes() {
    override fun draw(parameter: Int) {
        TODO("Not yet implemented")
    }

    override fun area(): Double {
        return (a * b).toDouble()
    }
}
