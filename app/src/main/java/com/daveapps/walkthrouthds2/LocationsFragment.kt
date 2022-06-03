package com.daveapps.walkthrouthds2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.daveapps.walkthrouthds2.databinding.FragmentLocationsBinding

class LocationsFragment : Fragment(), ItemsAdapterLocations.ClickListener {
    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: Communicator
    private var itemsAdapterLocations: ItemsAdapterLocations? = null
    private var itemModalListLocations = ArrayList<ItemsModalLocations>()
    private var provider: String? = ""
    private var transaction: FragmentTransaction? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (activity as AppCompatActivity).supportActionBar?.title =  getString(R.string.locations)
        setHasOptionsMenu(true)
        _binding = FragmentLocationsBinding.inflate(inflater,container,false)
        provider = arguments?.getString("provider")
        communicator = activity as Communicator


        val imagesNameLocations = arrayOf(
            ItemsModalLocations(getString(R.string.things_betwixt),getString(R.string.majula),"0","1",R.drawable.thingsbetwixt),
            ItemsModalLocations(getString(R.string.majula),getString(R.string.forest_of_fallen_giants),"0","1",R.drawable.majula),
            ItemsModalLocations(getString(R.string.forest_of_fallen_giants),getString(R.string.heides_tower_of_flame)+", " + getString(R.string.memories_of_the_giants),getString(R.string.pursuer)+", "+getString(R.string.the_last_giant),"4",R.drawable.forestoffallengiants),
            ItemsModalLocations(getString(R.string.heides_tower_of_flame),getString(R.string.cathedral_of_blue)+", "+getString(R.string.no_mans_wharf),getString(R.string.dragonrider),"2",R.drawable.heidetowerofflame),
            ItemsModalLocations(getString(R.string.cathedral_of_blue),getString(R.string.no_mans_wharf),getString(R.string.old_dragonslayer),"1",R.drawable.cathedralofblue),
            ItemsModalLocations(getString(R.string.no_mans_wharf),getString(R.string.lost_bastille),getString(R.string.flexile_sentry),"1",R.drawable.nomanswharf),
            ItemsModalLocations(getString(R.string.lost_bastille),getString(R.string.belfry_luna)+", "+getString(R.string.sinners_rise),getString(R.string.ruin_sentinels),"1",R.drawable.lostbastille),
            ItemsModalLocations(getString(R.string.belfry_luna),getString(R.string.sinners_rise),getString(R.string.belfry_gargoyles),"1",R.drawable.belfryluna),
            ItemsModalLocations(getString(R.string.sinners_rise),getString(R.string.huntsmans_copse),getString(R.string.lost_sinner),"1",R.drawable.sinnersrise),
            ItemsModalLocations(getString(R.string.huntsmans_copse),getString(R.string.undead_purgatory)+", "+getString(R.string.harvest_valley),"0","2",R.drawable.huntsmanscopse),
            ItemsModalLocations(getString(R.string.undead_purgatory), getString(R.string.harvest_valley),getString(R.string.executioners_chariot),"1",R.drawable.undeadpurgatory),
            ItemsModalLocations(getString(R.string.harvest_valley),getString(R.string.earthen_peak),"0","2",R.drawable.harvestvalley),
            ItemsModalLocations(getString(R.string.earthen_peak),getString(R.string.iron_keep),getString(R.string.covetous_demon)+", "+getString(R.string.mytha_the_baneful_queen),"3",R.drawable.earthenpeak),
            ItemsModalLocations(getString(R.string.iron_keep),getString(R.string.belfry_sol),getString(R.string.smelter_demon)+", "+getString(R.string.pursuer)+", "+getString(R.string.old_iron_king),"3",R.drawable.ironkeep),
            ItemsModalLocations(getString(R.string.belfry_sol),getString(R.string.grave_of_saints),"0","1",R.drawable.belfrysol),
            ItemsModalLocations(getString(R.string.the_pit),getString(R.string.grave_of_saints),"0","0",R.drawable.thepit),
            ItemsModalLocations(getString(R.string.grave_of_saints),getString(R.string.the_gutter),getString(R.string.royal_rat_vanguard),"2",R.drawable.graveofsaints),
            ItemsModalLocations(getString(R.string.the_gutter),getString(R.string.black_gulch),"0","2",R.drawable.thegutter),
            ItemsModalLocations(getString(R.string.shaded_woods),getString(R.string.shrine_of_winter)+", "+getString(R.string.doors_of_pharros),getString(R.string.scorpioness_najka),"3",R.drawable.shadedwoods),
            ItemsModalLocations(getString(R.string.black_gulch),getString(R.string.shaded_woods),getString(R.string.the_rotten),"2",R.drawable.theblackgulch),
            ItemsModalLocations(getString(R.string.doors_of_pharros),getString(R.string.brightstone_cove_tseldora),getString(R.string.royal_rat_authority),"2",R.drawable.doorsofpharros),
            ItemsModalLocations(getString(R.string.brightstone_cove_tseldora),getString(R.string.shrine_of_winter),getString(R.string.prowling_magus_and_congregation)+", "+getString(R.string.the_dukes_dear_freja),"3",R.drawable.brightstonecovetseldora),
            ItemsModalLocations(getString(R.string.lords_private_chamber),"0","0","1",R.drawable.lordsprivatechamber),
            ItemsModalLocations(getString(R.string.shrine_of_winter),getString(R.string.drangleic_castle)+", "+getString(R.string.frozen_eleum_loyce)+" (DLC)","0","2",R.drawable.shrineofwinter),
            ItemsModalLocations(getString(R.string.drangleic_castle),getString(R.string.shrine_of_amana),getString(R.string.dragonrider),"4",R.drawable.drangleiccastle),
            ItemsModalLocations(getString(R.string.shrine_of_amana),getString(R.string.undead_crypt),getString(R.string.demon_of_song),"4",R.drawable.shrineofamana),
            ItemsModalLocations(getString(R.string.undead_crypt),getString(R.string.aldias_keep),getString(R.string.velstadt_the_royal_aegis)+" and "+getString(R.string.vendrick),"2",R.drawable.undeadcrypt),
            ItemsModalLocations(getString(R.string.aldias_keep),getString(R.string.dragon_aerie),getString(R.string.guardian_dragon),"2",R.drawable.aldiaskeep),
            ItemsModalLocations(getString(R.string.dragon_aerie),getString(R.string.dragon_shrine),"0","1",R.drawable.dragonaerie),
            ItemsModalLocations(getString(R.string.dragon_shrine),"0",getString(R.string.ancient_dragon),"0",R.drawable.dragonshrine)

        )

        for (items in imagesNameLocations){////////////////////////////incremente the counter in function on the imagesName Array
            if (itemModalListLocations.size < 30){
                itemModalListLocations.add(items)
            }
        }

        itemsAdapterLocations = ItemsAdapterLocations(this)
        itemsAdapterLocations?.setData(itemModalListLocations)
        binding.recyclerViewLocations.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerViewLocations.setHasFixedSize(true)
        binding.recyclerViewLocations.adapter = itemsAdapterLocations

        return binding.root
    }

    override fun clickedItemLocations(itemsModalLocations: ItemsModalLocations) {
        Log.e("TAG",itemsModalLocations.location)
        when(itemsModalLocations.location){
            getString(R.string.things_betwixt) ->communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.majula) ->communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.forest_of_fallen_giants) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.heides_tower_of_flame) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.cathedral_of_blue) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.no_mans_wharf) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.lost_bastille) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.belfry_luna) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.sinners_rise) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.huntsmans_copse) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.undead_purgatory) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.harvest_valley) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.earthen_peak) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.iron_keep) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.belfry_sol) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.the_pit) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.grave_of_saints) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.the_gutter) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.black_gulch) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.shaded_woods) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.doors_of_pharros) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.brightstone_cove_tseldora) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.lords_private_chamber) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.shrine_of_winter) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.drangleic_castle) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.shrine_of_amana) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.undead_crypt) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.aldias_keep) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.dragon_aerie) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.dragon_shrine) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            else ->{
                Toast.makeText(this.context,"No Action", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.action_about -> {
            Toast.makeText(this.context,"about", Toast.LENGTH_LONG).show()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }


}