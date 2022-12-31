package app.codinguyy.kotlinbasics.chapter11.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.chapter11.animals.Tiger


/**
 * Beginning of functional programming
 */



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
typealias DoubleTypeAlias = (Double) -> Double

/**
 * Its a placeholder, not needed to write Array<Tiger>, instead I can write DuckArray
 */
typealias DuckArray = Array<Tiger>

class ForthFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_forth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * When you assign a lambda to a variable, youre assigning a block of code to it, not
         * the result of the code being run. To run the code in lambda, you need to explicity
         * invoke it
         *
         */
        val addFive = { x: Int ->
            x + 5
        }
        val result = addFive.invoke(1)
        val result2 = addFive(1)
        val addSix: (Int) -> Int = { x ->
            x + 6
        }
        val calculation: (Int, Int) -> Int = { x: Int, y: Int ->
            x + y
        }

        /**
         * Use Unit to say the lambda has no return value
         */
        val myLambda: () -> Unit = {
            println("No return value")
        }

        /**
         * This lambda will return nothing, because the return type is Unit
         */
        val calc: (Int, Int) -> Unit = { x, y ->
            x + y
        }

        /**
         * Use a lambda as a input to a function
         */

        convert(20.0, { c: Double -> c * 1.8 + 32 })

        convert(20.0) { c: Double ->
            c * 1.8 + 32
        }
        convert(20.0) {
            it * 1.8 + 32
        }

        convert2 {
            it * 8.0 + 2.0
        }

        // After ",": This is the lambda expression that we will use for converting
        // This code creates a double with the name c. It has the value 20 and is the input to the lamda function. On the right side of the arrow we
        // get the output of the lambda.
        // The value of the lambda is c:Double -> c*1.8+32
        // result is the converted value

        /**
         *
         */
        val foo = getConversionalLambda("test2")(2.5)
        convert(20.0, getConversionalLambda("test1"))

        /**
         * Example of: Combining two lambdas into one lambda
         */

        val kgsToPounds = { x: Double -> x * 2.2 }
        val poundsToUsTons = { x: Double -> x / 2000.0 }
        val kgsToUsTons = combine(kgsToPounds, poundsToUsTons)

        val usTons = kgsToUsTons(100.0) // invoke by passing 100.0
    }

    /**
     * convert1 and convert 2 are doing the same thing
     */
    fun convert(x: Double, converter: (Double) -> Double): Double {
        val result = converter(x)
        println("$x is converted to $result")
        return result
    }

    fun convert2(converter: (Double) -> Double): Double {
        val result = converter(3.0)
        println("3.0 is converted to $result")
        return result
    }

    /**
     * This function returns a lambda
     */
    fun getConversionalLambda(str: String): (Double) -> Double {
        if (str == "test1") {
            return { it * 2.0 }
        } else if (str == "test2") {
            return { it * 3 }
        } else {
            return { it }
        }
    }

    /**
     * Combine two lambdas
     * lambda1 is kgsToPounds:      x: Double -> x * 2.2 - return is:   x*2.2
     * lambda2 is poundsToUsTons:   x: Double -> x / 2000.0
     */

    fun combine(lambda1: (Double) -> Double, lambda2: (Double) -> Double): (Double) -> Double {
        // This is the new lambda
        return { x: Double ->
            lambda2(lambda1(x))
            // lambda2({x:Double -> x * 2.2})
            // in lambda 2: the input x is: x=x*2.2
            // in lambda 2 - val poundsToUsTons = { x: Double -> x / 2000.0 }
            // poundsToUsTons={ x:Double -> (x*2.2) / 2000.0  }
        }
    }

    /**
     * Another way of using lambdas with typealias
     */
    fun combine2(lambda1: DoubleTypeAlias, lambda2: DoubleTypeAlias): (Double) -> Double {
        // This is the new lambda
        return { x: Double ->
            lambda2(lambda1(x))
        }
    }
}
