package app.codinguyy.kotlinbasics.chapter7And12.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.chapter7And12.data.friendsGroup
import app.codinguyy.kotlinbasics.chapter7And12.data.nobody

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SeventhFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeventhFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seventh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Returns true if there is any Person, which has a driversLiscence
         */
        val isLiscenceAvailable = friendsGroup.any() {
            it.driversLiscence
        }

        /**
         * Returns true if there is no single person, which is under the age of 18
         */
        friendsGroup.none() {
            it.age < 18
        }

        /**
         * Returns true if each element matches: it.name.length < 4
         */
        friendsGroup.all {
            it.name.length < 4
        }

        /**
         * returns false
         */
        nobody.any {
            it.driversLiscence
        }

        /**
         * returns true
         */
        nobody.none {
            it.age < 18
        }

        /**
         * returns true
         */
        nobody.all {
            it.name.length < 4
        }

        /**
         * chunked()
         * split the list into multiple small lists in a list
         */
        friendsGroup.chunked(3)
        friendsGroup.chunked(3) {
            it.reversed()
        }

        /**
         * windowed()
         */
        friendsGroup.windowed(3)
        friendsGroup.windowed(4, 2, true)

        /**
         * flatten()
         */
        friendsGroup.windowed(3).flatten()

        /**
         * flatmap
         */
        val listOf = listOf("Foo1", "Foo2", "Foo3")
        listOf.flatMap {
            it.toList()
        }

        /**
         * zip()
         */

        val germanCities = listOf("Aachen", "Bielefeld", "Muenchen")
        val germanLiscencePlates = listOf("AA", "BI", "M")

        germanCities zip germanLiscencePlates
        val cityToPlates = germanCities.zip(germanLiscencePlates)
        // [(Aachen, AC),(Bielefeld,BI),(Muenchen,M)]

        germanCities.zip(germanLiscencePlates) { city, plate ->
            city.uppercase() to plate.lowercase()
        }

        /**
         * unzip
         */

        val (cities, plates) = cityToPlates.unzip()

        /**
         *  zipWithNext()
         */
        val random = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 4)
        random.zipWithNext()
        // [(3,1),(1,4),(4,1),(1,5),(5,9),(9,2),(2,6),(6,5),(5,4)]
        random.zipWithNext() { a, b -> b - a }
        // [-2,3,-3,4,4,-7,4,-1,-1]

        /**
         * reduce
         */
        random.reduce { acc, value ->
            acc * value
        }

        /**
         * forEach
         */

        val fruits = listOf("Apple", "Orange", "Cherry")
        fruits.forEach {
        }

        /**
         * fold
         * reduceRight()
         * foldRight()
         * reduceOrNull()
         */

        fruits.fold(1) { acc, value ->
            acc * value.length
        }

        fruits.runningFold(1) { acc, value ->
            acc * value.length
        }
        // fruits.runningReduce()
    }

    /**
     * map: Doubles the elements of the list ints
     * The map function returns a new list and leaves the original collection intact.
     */
    val ints = listOf(1, 2, 3, 4)
    val doubleInts = ints.map {
        it * 2
    }

    /**
     * Chaining methods
     */

    val friendsNames = friendsGroup
        .filter { it.age > 3.0 }
        .map { it.age * 2 }

    /**
     * forEach
     */

    /**
     * groupBy
     * groupBy returns a map. It uses the criteria passed via the lambda body for the keys
     * and each associated value is a List of items from to the original collection
     */

    val orderPersonsList = friendsGroup.groupBy {
        it.name
    }

    /**
     * minBy()
     * maxBy()
     * min()
     * max()
     * sumBy()
     * sumByDouble()
     * filter()
     * filterTo()
     * filterIsInstance()
     * filterNot()
     *
     */
}

/**
 * Overloading functions
 */
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun addNumbers(a: Double, b: Double): Double {
    return a + b
}
