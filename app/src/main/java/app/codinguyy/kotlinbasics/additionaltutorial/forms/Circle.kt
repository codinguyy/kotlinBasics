package app.codinguyy.kotlinbasics.additionaltutorial.forms

class Circle(val radius: Int) : Shapes() {
    override fun draw(parameter: Int) {
        TODO("Not yet implemented")
    }

    override fun area(): Double {
        return (radius).toDouble()
    }
}
