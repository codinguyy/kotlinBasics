package app.codinguyy.kotlinbasics.chapter7And12.data

data class Person(
    val name: String,
    val age: Int,
    val driversLiscence: Boolean = false
)

var friendsGroup: List<Person> = listOf(
    Person("Jo", 10),
    Person("Mic", 15),
    Person("May", 23, true),
    Person("Cal", 22),
    Person("Paul", 22),
    Person("Robert", 20),
    Person("Marcel", 22)
)

val nobody = emptyList<Person>()
