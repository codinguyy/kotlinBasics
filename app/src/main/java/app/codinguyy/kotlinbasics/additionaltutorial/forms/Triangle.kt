package app.codinguyy.kotlinbasics.additionaltutorial.forms

class Triangle(val a: Int, val b: Int, val c: Int) : Shapes() {
    override fun draw(parameter: Int) {
        TODO("Not yet implemented")
    }

    override fun area(): Double {
        return (a * b * c).toDouble()
    }
}
