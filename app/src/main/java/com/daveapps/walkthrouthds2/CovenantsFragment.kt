package com.daveapps.walkthrouthds2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daveapps.walkthrouthds2.databinding.FragmentCharactersBinding
import com.daveapps.walkthrouthds2.databinding.FragmentCovenantsBinding


class CovenantsFragment : Fragment(), ItemsAdapterCovenants.ClickListener {
    private var _binding: FragmentCovenantsBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: Communicator
    private var modalListCovenants = ArrayList<ItemsModalCovenants>()
    private var covenantNames = arrayListOf("")
    private var covenantImages = intArrayOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.covenants)
        _binding = FragmentCovenantsBinding.inflate(inflater, container, false)
        communicator = activity as Communicator

        covenantImages = intArrayOf(R.drawable.bellkeeperscovenant,R.drawable.bluesentinelscovenant)
        covenantNames = arrayListOf(getString(R.string.bell_keeper),getString(R.string.blue_sentinels))

        for (items in covenantNames.indices) if (modalListCovenants.size < 2) modalListCovenants.add(ItemsModalCovenants(this.covenantNames[items],covenantImages[items]))
        val adapterCovenants = ItemsAdapterCovenants(this.requireContext(),this)
        adapterCovenants.setData(modalListCovenants)
        binding.gridViewCovenants.adapter = adapterCovenants
        binding.gridViewCovenants.onItemClickListener

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.action_about -> {
            Toast.makeText(this.context,"about", Toast.LENGTH_LONG).show()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun clickedItemCovenants(itemsModalCovenants: ItemsModalCovenants) {
        when(itemsModalCovenants.covenants){
            getString(R.string.bell_keeper) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
        }
    }


}