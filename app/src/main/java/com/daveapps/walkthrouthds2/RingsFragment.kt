package com.daveapps.walkthrouthds2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class RingsFragment : Fragment(),ItemsAdapterItems.ClickListener {
    private var root: View? = null
    private var provider: String? = null
    private var transaction: FragmentTransaction? = null
    private var ringsName = arrayListOf("")
    private var ringsImage = intArrayOf()

    private var modalListRings = ArrayList<Modal>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.rings)
        root = inflater.inflate(R.layout.fragment_rings, container, false)
        provider = arguments?.getString("provider")

        val gridViewRings = root?.findViewById<GridView>(R.id.gridViewRings)
        val adapter = ItemsAdapterItems(this.requireContext(),this)



        ringsImage = intArrayOf(R.drawable.agapering,R.drawable.abyssseal,R.drawable.ancientdragonseal,R.drawable.ashknucklering,R.drawable.banefulbirdring,R.drawable.bellkeepersseal,R.drawable.bloodbitering,
            R.drawable.blueseal,R.drawable.bluetearstonering,R.drawable.bracingknucklering,R.drawable.chloranthyring,R.drawable.clearbluestonering,R.drawable.covetousgoldserpentring,R.drawable.covetoussilverserpentring,
            R.drawable.crestofblood,R.drawable.crestoftherat,R.drawable.cursebitering,R.drawable.darkclutchring,R.drawable.darkquartzring,R.drawable.delicatestring,R.drawable.dexterityring,R.drawable.dispellingring,
            R.drawable.fireclutchring,R.drawable.firstdragonring,R.drawable.flamequartzring,R.drawable.flynnsring,R.drawable.gowersringofprotection,R.drawable.guardiansseal,R.drawable.hawkring,
            R.drawable.illusoryringofaconqueror,R.drawable.illusoryringoftheexalted,R.drawable.ivorywarriorring,R.drawable.kingsring,R.drawable.lifering,R.drawable.lightningclutchring,R.drawable.lingeringdragoncrestring,
            R.drawable.nameengravedring,R.drawable.northernritualband,R.drawable.oldleoring,R.drawable.oldsunring,R.drawable.poisonbitering,R.drawable.redeyering,R.drawable.redtearstonering,R.drawable.ringofbinding,
            R.drawable.ringofblades,R.drawable.ringofgiants,R.drawable.ringofknowledge,R.drawable.ringoflifeprotection,R.drawable.ringofprayer,R.drawable.ringofresistance, R.drawable.ringofrestoration,
            R.drawable.ringofsoulprotection,R.drawable.ringofsteelprotection,R.drawable.ringofthedead,R.drawable.ringoftheliving,R.drawable.ringoftheembedded,R.drawable.ringoftheevileye,R.drawable.ringofthorns,
            R.drawable.ringofwhispers,R.drawable.royalsoldiersring,R.drawable.seconddragonring,R.drawable.silvercatring,R.drawable.simpletonsring,R.drawable.slumberingdragoncrestring,R.drawable.sorceryclutchring,
            R.drawable.southernritualband,R.drawable.spellquartzring,R.drawable.stonering,R.drawable.strengthring,R.drawable.sunseal,R.drawable.thirddragonring,R.drawable.thunderquartzring,R.drawable.vanquishersseal,
            R.drawable.whitering,R.drawable.yorghsring)

        ringsName = arrayListOf(getString(R.string.agape_ring),getString(R.string.abyss_seal),getString(R.string.ancient_dragon_seal),getString(R.string.ash_knuckle_ring),getString(R.string.baneful_bird_ring),getString(R.string.bell_keepers_seal),getString(R.string.bloodbite_ring),
            getString(R.string.blue_seal),getString(R.string.blue_tearstone_ring),getString(R.string.bracing_knuckle_ring),getString(R.string.chloranthy_ring),getString(R.string.clear_bluestone_ring),getString(R.string.covetous_gold_serpent_ring),getString(R.string.covetous_silver_serpent_ring),
            getString(R.string.crest_of_blood),getString(R.string.crest_of_the_rat),getString(R.string.cursebite_ring),getString(R.string.dark_clutch_ring),getString(R.string.dark_quartz_ring),getString(R.string.delicate_string),getString(R.string.dexterity_ring),getString(R.string.dispelling_ring),
            getString(R.string.fire_clutch_ring),getString(R.string.first_dragon_ring),getString(R.string.flame_quartz_ring),getString(R.string.flynns_ring),getString(R.string.gowers_ring_of_protection),getString(R.string.guardians_seal),getString(R.string.hawk_ring),
            getString(R.string.illusory_ring_of_a_conqueror),getString(R.string.illusory_ring_of_the_exalted),getString(R.string.ivory_warrior_ring),getString(R.string.kings_ring),getString(R.string.life_ring),getString(R.string.lightning_clutch_ring),getString(R.string.lingering_dragoncrest_ring),
            getString(R.string.name_engraved_ring),getString(R.string.northern_ritual_band),getString(R.string.old_leo_ring),getString(R.string.old_sun_ring),getString(R.string.poisonbite_ring),getString(R.string.redeye_ring),getString(R.string.red_tearstone_ring), getString(R.string.ring_of_binding),
            getString(R.string.ring_of_blades),getString(R.string.ring_of_giants),getString(R.string.ring_of_knowledge),getString(R.string.ring_of_life_protection),getString(R.string.ring_of_prayer),getString(R.string.ring_of_resistance),getString(R.string.ring_of_restoration),
            getString(R.string.ring_of_soul_protection),getString(R.string.ringof_steel_protection),getString(R.string.ring_of_the_dead),getString(R.string.ring_of_the_living),getString(R.string.ring_of_the_embedded),getString(R.string.ring_of_the_evil_eye),getString(R.string.ring_of_thorns),
            getString(R.string.ring_of_whispers),getString(R.string.royal_soldiers_ring),getString(R.string.second_dragon_ring),getString(R.string.silvercat_ring),getString(R.string.simpletons_ring),getString(R.string.slumbering_dragon_crest_ring),getString(R.string.sorcery_clutch_ring),
            getString(R.string.southern_ritual_band),getString(R.string.spell_quartz_ring),getString(R.string.stone_ring),getString(R.string.strength_ring),getString(R.string.sun_seal),getString(R.string.third_dragon_ring),getString(R.string.thunder_quartz_ring),getString(R.string.vanquishers_seal),
            getString(R.string.white_ring),getString(R.string.yorghs_ring),

            )
        for (items in ringsName.indices) if (modalListRings.size < 75) modalListRings.add(Modal(this.ringsName[items],ringsImage[items]))

        adapter.setData(modalListRings)
        gridViewRings?.adapter = adapter
        gridViewRings?.onItemClickListener

        return root
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.action_about -> {
            Toast.makeText(this.context,"about", Toast.LENGTH_LONG).show()
            //transaction = parentFragmentManager.beginTransaction()
            //transaction?.disallowAddToBackStack()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun clickedItem(itemsModalItems: Modal) {
        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }


}