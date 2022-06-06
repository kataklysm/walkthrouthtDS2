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

        covenantImages = intArrayOf(R.drawable.bellkeeperscovenant,R.drawable.bluesentinelscovenant,R.drawable.brotherhoodofbloodcovenant,R.drawable.companyofchampionscovenant,R.drawable.dragonremnantscovenant,R.drawable.heirsofthesuncovenant,R.drawable.pilgrimsofdarkcovenant,R.drawable.ratkingcovenant,R.drawable.wayofbluecovenant)
        covenantNames = arrayListOf(getString(R.string.bell_keeper),getString(R.string.blue_sentinels),getString(R.string.brotherhood_of_blood),getString(R.string.company_of_champions),getString(R.string.dragon_remnants),getString(R.string.heirs_of_the_sun),getString(R.string.pilgrims_of_dark),getString(R.string.rat_king_covenant),getString(R.string.way_of_blue))

        for (items in covenantNames.indices) if (modalListCovenants.size < 9) modalListCovenants.add(ItemsModalCovenants(this.covenantNames[items],covenantImages[items]))
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
            getString(R.string.blue_sentinels) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.brotherhood_of_blood) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.company_of_champions) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.dragon_remnants) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.heirs_of_the_sun) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.pilgrims_of_dark) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.rat_king_covenant) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
            getString(R.string.way_of_blue) -> communicator.passDataCom(itemsModalCovenants.covenants.toString(),"covenantsFragment")
        }
    }


}