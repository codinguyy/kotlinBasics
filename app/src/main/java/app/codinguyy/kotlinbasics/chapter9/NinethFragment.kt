package app.codinguyy.kotlinbasics.chapter9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.chapter9.animal.Animal
import app.codinguyy.kotlinbasics.chapter9.animal.Dog
import app.codinguyy.kotlinbasics.chapter9.animal.Tiger

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NinethFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NinethFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_nineth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfAnimals = mutableListOf<Animal>(Dog(), Tiger())
        val listOfGroceries = mutableListOf<String>("Apple", "Orange", "Rice", "Banana")

        /**
         * contains
         */
        if (listOfAnimals.contains(Dog())) {
            println("list contains dogs")
        }

        /**
         * remove
         * removeAt
         */
        listOfAnimals.removeAt(0)
        listOfAnimals.remove(Dog())

        /**
         * sortBy
         */
        val result = listOfAnimals.sortBy {
            it is Tiger
        }

        /**
         * sort()
         * reverse()
         */
        listOfGroceries.sort()
        listOfGroceries.reverse()
        listOfGroceries.shuffle()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NinethFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NinethFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
