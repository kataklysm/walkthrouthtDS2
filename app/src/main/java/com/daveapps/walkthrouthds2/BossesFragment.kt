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
import androidx.recyclerview.widget.LinearLayoutManager
import com.daveapps.walkthrouthds2.databinding.FragmentBossesBinding


class BossesFragment : Fragment(), ItemsAdapterBosses.ClickListener {

    private var _binding: FragmentBossesBinding? = null
    private val binding get() = _binding!!
    private var provider: String ?= null

    private lateinit var communicator: Communicator
    private var itemsAdapterBosses: ItemsAdapterBosses? = null
    private var itemModalListBosses = ArrayList<ItemsModalBosses>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBossesBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.bosses)
        setHasOptionsMenu(true)
        provider = arguments?.getString("provider")
        _binding = FragmentBossesBinding.inflate(inflater,container,false)
        communicator = activity as Communicator
        val imagesNameBosses = arrayOf(

            ItemsModalBosses(getString(R.string.pursuer),"3110",getString(R.string.lightning)+", "+getString(R.string.dark_mist)+", "+getString(R.string.poison),getString(R.string.physical),R.drawable.pursuer),
            ItemsModalBosses(getString(R.string.the_last_giant),"2530",getString(R.string.fire)+", "+getString(R.string.lightning),getString(R.string.physical),R.drawable.thelastgiant),
            ItemsModalBosses(getString(R.string.dragonrider),"3050",getString(R.string.lightning),getString(R.string.physical),R.drawable.dragonrider),
            ItemsModalBosses(getString(R.string.old_dragonslayer),"2880",getString(R.string.poison)+" ,"+getString(R.string.fire),getString(R.string.physical),R.drawable.olddragonslayer),
            ItemsModalBosses(getString(R.string.flexile_sentry),"3150",getString(R.string.lightning),getString(R.string.fire),R.drawable.flexilesentry),
            ItemsModalBosses(getString(R.string.belfry_gargoyles),"1400x5",getString(R.string.lightning),getString(R.string.physical),R.drawable.bellfrygargoyles),
            ItemsModalBosses(getString(R.string.lost_sinner),"3560",getString(R.string.magic),getString(R.string.fire)+" ,"+ getString(R.string.lightning)+" ,"+getString(R.string.dark),R.drawable.lostsinner),
            ItemsModalBosses(getString(R.string.ruin_sentinels),"2330",getString(R.string.poison)+", "+getString(R.string.lightning)+", "+getString(R.string.fire),getString(R.string.dark_mist)+", "+getString(R.string.slash),R.drawable.ruinsentinels),
            ItemsModalBosses(getString(R.string.the_skeleton_lords),"780x2",getString(R.string.magic)+" ,"+getString(R.string.lightning),getString(R.string.poison)+" ,"+getString(R.string.dark),R.drawable.theskeletonlords),
            ItemsModalBosses(getString(R.string.executioners_chariot),"4000",getString(R.string.magic),"?",R.drawable.executionerschariot),
            ItemsModalBosses(getString(R.string.covetous_demon),"4440",getString(R.string.physical),getString(R.string.lightning),R.drawable.covetousdemon),
            ItemsModalBosses(getString(R.string.mytha_the_baneful_queen),"3570",getString(R.string.fire),getString(R.string.poison_toxic),R.drawable.mythathebanefulqueen),
            ItemsModalBosses(getString(R.string.smelter_demon),"5970",getString(R.string.poison)+" ,"+getString(R.string.dark),getString(R.string.fire),R.drawable.smelterdemon),
            ItemsModalBosses(getString(R.string.old_iron_king),"6070",getString(R.string.lightning),getString(R.string.fire),R.drawable.oldironking),
            ItemsModalBosses(getString(R.string.royal_rat_vanguard),"1410",getString(R.string.fire)+" ,"+getString(R.string.dark),"?",R.drawable.royalratvanguard),
            ItemsModalBosses(getString(R.string.the_rotten),"7080",getString(R.string.lightning)+" ,"+getString(R.string.magic),getString(R.string.poison)+" ,"+getString(R.string.dark),R.drawable.therotten),
            ItemsModalBosses(getString(R.string.scorpioness_najka),"5741",getString(R.string.fire),getString(R.string.dark),R.drawable.scorpionessnajka),
            ItemsModalBosses(getString(R.string.royal_rat_authority),"4330",getString(R.string.lightning),"?",R.drawable.royalratauthority),
            ItemsModalBosses(getString(R.string.guardian_dragon),"?",getString(R.string.magic)+" ,"+getString(R.string.lightning),"?",R.drawable.guardiandragon),
            ItemsModalBosses(getString(R.string.prowling_magus_and_congregation),"1000",getString(R.string.physical),getString(R.string.magic),R.drawable.prowlingmagusandcongregation),
            ItemsModalBosses(getString(R.string.looking_glass_knight),"6540","?",getString(R.string.fire)+" ,"+getString(R.string.lightning)+" ,"+getString(R.string.magic),R.drawable.lookingglassknight),
            ItemsModalBosses(getString(R.string.demon_of_song),"6500",getString(R.string.lightning)+" ,"+getString(R.string.dark),getString(R.string.physical),R.drawable.demonofsong),
            ItemsModalBosses(getString(R.string.velstadt_the_royal_aegis),"6290",getString(R.string.lightning)+" ,"+getString(R.string.magic),getString(R.string.dark)+" ,"+getString(R.string.fire),R.drawable.velstadttheroyalaegis),
            ItemsModalBosses(getString(R.string.vendrick),"11450","?",getString(R.string.magic)+" ,"+getString(R.string.poison),R.drawable.vendrick),
            ItemsModalBosses(getString(R.string.ancient_dragon),"19840","?","?",R.drawable.ancientdragon),
            ItemsModalBosses(getString(R.string.the_dukes_dear_freja),"4224",getString(R.string.fire),getString(R.string.dark),R.drawable.dukesdearfreja),
            ItemsModalBosses(getString(R.string.giant_lord),"5300",getString(R.string.dark),"?",R.drawable.giantlord),
            ItemsModalBosses(getString(R.string.throne_watcher_and_throne_defender),"3910, 2760", getString(R.string.fire)+" ,"+getString(R.string.lightning),"?",R.drawable.thronewatcherandthronedefender),
            ItemsModalBosses(getString(R.string.nashandra),"8770","?","?",R.drawable.nashandra),
            ItemsModalBosses(getString(R.string.aldia_scholar_of_the_first_sin),"6800", "?","?",R.drawable.aldiascholarfirstsin)


        )
        for (items in imagesNameBosses){
            if (itemModalListBosses.size < 30){
                itemModalListBosses.add(items)
            }
        }

        itemsAdapterBosses = ItemsAdapterBosses(this)
        itemsAdapterBosses?.setData(itemModalListBosses)
        binding.recyclerViewBosses.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerViewBosses.setHasFixedSize(true)
        binding.recyclerViewBosses.adapter = itemsAdapterBosses
        return binding.root
    }


    override fun clickedItemBosses(itemsModalBosses: ItemsModalBosses) {
        Log.e("TAG ", itemsModalBosses.boss)
        when(itemsModalBosses.boss){
            getString(R.string.pursuer) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.the_last_giant) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.dragonrider) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.old_dragonslayer) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.flexile_sentry) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.belfry_gargoyles) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.lost_sinner) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.ruin_sentinels) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.the_skeleton_lords) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.executioners_chariot) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.covetous_demon) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.mytha_the_baneful_queen) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.smelter_demon) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.old_iron_king) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.royal_rat_vanguard) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.the_rotten) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.scorpioness_najka) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.royal_rat_authority) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.guardian_dragon) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.prowling_magus_and_congregation) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.looking_glass_knight) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.demon_of_song) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.velstadt_the_royal_aegis) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.vendrick) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.ancient_dragon) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.the_dukes_dear_freja) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.giant_lord) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.throne_watcher_and_throne_defender) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.nashandra) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.aldia_scholar_of_the_first_sin) ->communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            else ->{
                Toast.makeText(this.context,"No Action", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_about -> {
            Toast.makeText(this.context, "about", Toast.LENGTH_LONG).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}