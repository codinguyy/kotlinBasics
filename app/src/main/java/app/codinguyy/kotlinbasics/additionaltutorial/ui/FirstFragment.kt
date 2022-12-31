package app.codinguyy.kotlinbasics.additionaltutorial.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.databinding.FragmentFirstBinding
import app.codinguyy.kotlinbasics.additionaltutorial.forms.Shapes
import app.codinguyy.kotlinbasics.additionaltutorial.forms.Circle
import app.codinguyy.kotlinbasics.additionaltutorial.forms.CustomTriple
import app.codinguyy.kotlinbasics.additionaltutorial.forms.Rectangle
import app.codinguyy.kotlinbasics.additionaltutorial.forms.Triangle

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val circle1 = Circle(5)
    private val rectangle1 = Rectangle(1, 2)
    private val triangle1 = Triangle(1, 2, 3)
    private val circle2 = Circle(5)
    private val rectangle2 = Rectangle(1, 2)
    private val triangle2 = Triangle(1, 2, 3)
    private val circle3 = Circle(5)
    private val rectangle3 = Rectangle(1, 2)
    private val triangle3 = Triangle(1, 2, 3)
    private val customTriple = CustomTriple(3, "test", false)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customTriple.printTypes()

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        /**
         * List<Shapes>
         */
        val shapes = listOf(
            circle1,
            circle2,
            circle3,
            triangle1,
            triangle3,
            triangle2,
            rectangle1,
            rectangle2,
            rectangle3
        )

        /**
         * List<Int>
         */
        val numbers = (1..10).toList()

        /**
         * customFilter only for shapes
         */
        val filteredList = shapes.customFilter {
            it.area() < 5.0
        }

        /**
         * genericFilter
         */
        val filteredInt2 = numbers.genericFilter {
            it > 3 // filterFunction
        }

        val filteredShapes2 = shapes.genericFilter {
            it.area() < 10.0
        }

        /**
         * Filter numbers
         */

        val filteredNumbers3 = numbers.genericFilterForNumbers {
            it < 3.0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Filtering only available for Shapes
     */
    fun List<Shapes>.customFilter(filterFunction: (Shapes) -> (Boolean)): List<Shapes> {
        val resultList = mutableListOf<Shapes>()
        for (item in this) {
            if (filterFunction(item)) {
                resultList.add(item)
            }
        }
        return resultList
    }

    /**
     * Generic method for filtering shapes or integers...
     */

    fun <T> List<T>.genericFilter(filterFunction: (T) -> (Boolean)): List<T> {
        val resultList = mutableListOf<T>()
        for (item in this) {
            if (filterFunction(item)) {
                resultList.add(item)
            }
        }
        return resultList
    }

    /**
     * Generic method only available for Numbers
     */

    fun <T : Number> List<T>.genericFilterForNumbers(filterFunction: (T) -> (Boolean)): List<T> {
        val resultList = mutableListOf<T>()
        for (item in this) {
            if (filterFunction(item)) {
                resultList.add(item)
            }
        }
        return resultList
    }
}
