package app.codinguyy.kotlinbasics.chapter10.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.codinguyy.kotlinbasics.R
import app.codinguyy.kotlinbasics.chapter10.animals.Animal
import app.codinguyy.kotlinbasics.chapter10.animals.Contest
import app.codinguyy.kotlinbasics.chapter10.animals.Tiger
import app.codinguyy.kotlinbasics.chapter10.animals.Vet
import app.codinguyy.kotlinbasics.chapter10.vehicles.AudiRetailer
import app.codinguyy.kotlinbasics.chapter10.vehicles.Retailer
import app.codinguyy.kotlinbasics.chapter10.vehicles.Vehicles

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TenthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TenthFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_tenth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * without in: type mismatch
         * Required: Tiger
         * Found: Animal
         *
         * We dont want to use the subtype of an Animal for a contest. A petVet can treat all animals
         * In another words, we want to be able to use generic supertype in place of a generic subtype
         */
        val animalVet = Vet<Animal>()
        val tigerVet = Vet<Tiger>()

        tigerVet.treat(Tiger())
        // tigerVet.treat(GreyHound()) wont compile, because tigerVet cannot treat dogs

        val tigerContest = Contest<Tiger>(tigerVet)
        val animalContest = Contest<Animal>(animalVet)
        // An animalVet can treat all types of Animal, including Tigers, but we cant assign a Vet<Animal> to
        // a Contest<Tiger>

        val tigerContest2 = Contest<Tiger>(animalVet) // this line will only compile if we add the "in" keyword into the vet class

        // generic - out
        /**
         * without out: type mismatch
         * Required: Retailer<Vehicles>
         * Found: AudiRetailer  - AudiRetailer is a subtype of Retailer
         *
         * We dont want to use the supertype Retailer. Retailer is an interface and its not possible to create an object of it
         * With out, we can call a subtype of Retailer: AudiRetailer
         *
         * In this way we can use pholimorphism
         */
        val foo: Retailer<Vehicles> = AudiRetailer()
        foo.sell()
    }
}
