package app.codinguyy.kotlinbasics.chapter6.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.chapter6.ITransportable
import app.codinguyy.kotlinbasics.chapter6.animal.Animal
import app.codinguyy.kotlinbasics.chapter6.animal.Tiger
import app.codinguyy.kotlinbasics.chapter6.animal.dogs.Boxer
import app.codinguyy.kotlinbasics.chapter6.animal.dogs.GreyHound
import app.codinguyy.kotlinbasics.chapter6.vehicles.Vehicles
import app.codinguyy.kotlinbasics.util.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SixFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SixFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val tiger = Tiger()
    private val boxer = Boxer()
    private val greyHound = GreyHound()
    private val vehicle = Vehicles()

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
        return inflater.inflate(R.layout.fragment_six, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
         * tiger.sleeping() comes from animal class,
         * because every animal is sleeping the same way
         */
        tiger.sleeping()

        /**
         * the tiger has a specific behavior, which is only
         * valid for the class Tiger
         * So the medhods eat(), roam() and run() are
         * overriden in the class Tiger
         */
        tiger.eat()
        tiger.roam()
        tiger.run()

        /**
         * From dog class
         * Using setter and getter for the variable hunger
         */
        Log.i(Constants.TAG, "hunger boxer" + boxer.hunger.toString())
        Log.i(Constants.TAG, "run greyhound" + greyHound.run())
        /**
         * Polymorphism means "many forms". It allows different subclasses to have different
         * implementations of the same function.
         */
        val animal: Animal = GreyHound()
        animal.eat()

        /**
         * An animal can pull things, a car can also pull things
         */

        tiger.pull("tiger")
        vehicle.pull("vehicle")

        /**
         * Creates transportables of type ITransportable
         */
        val transportables = arrayOf(Tiger(), GreyHound(), Vehicles())

        for (item in transportables) {
            item.transport()
        }

        /**
         * is operator
         *
         *
         * We are using an array of type transportables in the for loop
         * the variable transportables holds values of type Tiger and Dog, which
         * both have the supertype Animal. In the variable there is also an element
         * from the type Vehicle.
         *
         * The is keyword checks if an element is from type Animal. If so, we
         * can call the eat method from the animal class.
         * In the Vehicle class there is no eat method. Thats why we need to check
         * what type the element in the array has.
         */

        for (item in transportables) {
            item.transport()
            if (item is Animal) {
                item.eat()
            }
        }

        /**
         * as operator
         * Casting r into a GreyHound
         * r is grom type ITransportable, so we can call r.transport()
         * After the cast:
         * We can call greyhound specific methods
         *
         * as? let you perform a safe explicit cast. If the cast fails, it returns null
         *
         */

        val r: ITransportable = GreyHound()
        var grehound2 = r as? GreyHound
    }
}
