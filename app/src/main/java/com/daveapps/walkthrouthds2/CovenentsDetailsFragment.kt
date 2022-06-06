package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.daveapps.walkthrouthds2.databinding.FragmentCharactersDetailsBinding
import com.daveapps.walkthrouthds2.databinding.FragmentCovenentsDetailsBinding


class CovenentsDetailsFragment : Fragment(), ItemsAdapterItems.ClickListener{
    private var _binding: FragmentCovenentsDetailsBinding? = null
    private val binding get( ) = _binding!!
    private lateinit var communicator: Communicator
    private var modalListItems = ArrayList<Modal>()
    private var modalListLocations = ArrayList<Modal>()
    private var items = arrayOf("")
    private var itemsImages = intArrayOf()
    private var locations = arrayOf("")
    private var locationsImages = intArrayOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.covenant)
        _binding = FragmentCovenentsDetailsBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        communicator = activity as Communicator
        val covenant = arguments?.getString("name")
        binding.tvCovenant.typeface = Typeface.createFromAsset(context?.assets, "fonts/optimussemibold.ttf")
        when (covenant){
            getString(R.string.bell_keeper) ->{
                binding.tvRank.text = "1"
                binding.tvVictories.text = "1-10"
                binding.ivRewards.setImageResource(R.drawable.bellkeepersseal)
            }
        }


        return binding.root
    }

    override fun clickedItem(itemsModalItems: Modal) {
        TODO("Not yet implemented")
    }

}