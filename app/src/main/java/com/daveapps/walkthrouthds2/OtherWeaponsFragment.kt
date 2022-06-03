package com.daveapps.walkthrouthds2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentTransaction


class OtherWeaponsFragment : Fragment(), ItemsAdapterItems.ClickListener {
    private var root: View? = null
    private var provider: String? = null
    private var transaction: FragmentTransaction? = null
    private var weaponName = arrayListOf("")
    private var weaponImage = intArrayOf()

    private var modalListStaves = ArrayList<Modal>()
    private var icExpandIconStaves: ImageView? = null

    private var modalListFists = ArrayList<Modal>()
    private var icExpandIconFists: ImageView? = null

    private var modalListWhips = ArrayList<Modal>()
    private var icExpandIconWhips: ImageView? = null

    private var modalListBows = ArrayList<Modal>()
    private var icExpandIconBows: ImageView? = null

    private var modalListGreatbows = ArrayList<Modal>()
    private var icExpandIconGreatbows: ImageView? = null

    private var modalListCrossBows = ArrayList<Modal>()
    private var icExpandIconCrossBows: ImageView? = null

    private var modalListFlames = ArrayList<Modal>()
    private var icExpandIconFlames: ImageView? = null

    private var modalListChimes = ArrayList<Modal>()
    private var icExpandIconChimes: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.other_weapons)
        root = inflater.inflate(R.layout.fragment_other_weapons, container, false)
        provider = arguments?.getString("provider")


        val expandListStaves = root?.findViewById<TextView>(R.id.tvExpandListStaves)
        val gridViewStaves = root?.findViewById<GridView>(R.id.gridViewStaves)
        icExpandIconStaves = root?.findViewById(R.id.ivExpandIconStaves)

        val expandListFists = root?.findViewById<TextView>(R.id.tvExpandListFistClaws)
        val gridViewFists = root?.findViewById<GridView>(R.id.gridViewFistClaws)
        icExpandIconFists = root?.findViewById(R.id.ivExpandIconFists)

        val expandListWhips = root?.findViewById<TextView>(R.id.tvExpandListWhips)
        val gridViewwhips = root?.findViewById<GridView>(R.id.gridViewWhips)
        icExpandIconWhips = root?.findViewById(R.id.ivExpandIconWhips)

        val expandListBows = root?.findViewById<TextView>(R.id.tvExpandListBows)
        val gridViewBows = root?.findViewById<GridView>(R.id.gridViewBows)
        icExpandIconBows = root?.findViewById(R.id.ivExpandIconBows)

        val expandListGreatbows = root?.findViewById<TextView>(R.id.tvExpandListGreatbows)
        val gridViewGreatbows = root?.findViewById<GridView>(R.id.gridViewGreatbows)
        icExpandIconGreatbows = root?.findViewById(R.id.ivExpandIconGreatbows)

        val expandListCrossbows = root?.findViewById<TextView>(R.id.tvExpandListCrossbows)
        val gridViewCrossbows = root?.findViewById<GridView>(R.id.gridViewCrossbows)
        icExpandIconCrossBows = root?.findViewById(R.id.ivExpandIconCrossbows)

        val expandListFlames = root?.findViewById<TextView>(R.id.tvExpandListFlames)
        val gridViewFlames = root?.findViewById<GridView>(R.id.gridViewFlames)
        icExpandIconFlames = root?.findViewById(R.id.ivExpandIconFlames)

        val expandListChimes = root?.findViewById<TextView>(R.id.tvExpandListChimes)
        val gridViewChimes = root?.findViewById<GridView>(R.id.gridViewChimes)
        icExpandIconChimes = root?.findViewById(R.id.ivExpandIconChimes)


        //////////////////////////////////////////////////////////STAVES///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.bonestaff,R.drawable.witchtreebranch,R.drawable.lizardstaff,R.drawable.transgressorsstaff,R.drawable.sorcerersstaff,R.drawable.staffofamana,R.drawable.olenfordsstaff,
            R.drawable.archdrakestaff,R.drawable.batstaff,R.drawable.staffofwisdom,R.drawable.sunsetstaff,R.drawable.blackwitchsstaff,R.drawable.azalsstaff,R.drawable.retainerstaff)

        weaponName = arrayListOf(getString(R.string.bone_staff),getString(R.string.witchtree_branch),getString(R.string.lizard_staff),getString(R.string.transgressors_staff),getString(R.string.sorcerers_staff),getString(R.string.staff_of_amana),getString(R.string.olenfords_staff),
            getString(R.string.archdrake_staff),getString(R.string.bat_staff),getString(R.string.staff_of_wisdom),getString(R.string.sunset_staff),getString(R.string.black_witchs_staff),getString(R.string.azals_staff),getString(R.string.retainer_staff))

        for (items in weaponName.indices) if (modalListStaves.size < 14) modalListStaves.add(Modal(this.weaponName[items],weaponImage[items]))
        var adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListStaves)
        gridViewStaves?.adapter = adapter
        gridViewStaves?.onItemClickListener

        expandListStaves?.setOnClickListener {
            if (gridViewStaves != null) expandList(gridViewStaves,icExpandIconStaves!!)
        }
        //////////////////////////////////////////////////////////FISTS & CLAWS///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.caestus,R.drawable.claws,R.drawable.malformedclaws,R.drawable.manikinclaws,R.drawable.workhook,R.drawable.bonefist)
        weaponName = arrayListOf(getString(R.string.caestus),getString(R.string.claws),getString(R.string.malformed_claws),getString(R.string.manikin_claws),getString(R.string.work_hook),getString(R.string.bone_fist))
        for (items in weaponName.indices) if (modalListFists.size < 6) modalListFists.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListFists)
        gridViewFists?.adapter = adapter
        gridViewFists?.onItemClickListener

        expandListFists?.setOnClickListener {
            if (gridViewFists != null) expandList(gridViewFists,icExpandIconFists!!)
        }
        //////////////////////////////////////////////////////////WHIPS///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.whip,R.drawable.notchedwhip,R.drawable.bloodiedwhip,R.drawable.spottedwhip,R.drawable.oldwhip)
        weaponName = arrayListOf(getString(R.string.whip),getString(R.string.notched_whip),getString(R.string.bloodied_whip),getString(R.string.spotted_whip),getString(R.string.old_whip))
        for (items in weaponName.indices) if (modalListWhips.size < 5) modalListWhips.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListWhips)
        gridViewwhips?.adapter = adapter
        gridViewwhips?.onItemClickListener

        expandListWhips?.setOnClickListener {
            if (gridViewwhips != null) expandList(gridViewwhips,icExpandIconWhips!!)
        }

        //////////////////////////////////////////////////////////BOWS///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.shortbow,R.drawable.longbow,R.drawable.compositebow,R.drawable.seabow,R.drawable.dragonriderbow,R.drawable.bellkeeperbow,R.drawable.bowofwant,R.drawable.huntersblackbow)
        weaponName = arrayListOf(getString(R.string.short_bow),getString(R.string.long_bow),getString(R.string.composite_bow),getString(R.string.sea_bow),getString(R.string.dragonrider_bow),getString(R.string.bell_keeper_bow),getString(R.string.bow_of_want),getString(R.string.hunters_blackbow))
        for (items in weaponName.indices) if (modalListBows.size < 8) modalListBows.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListBows)
        gridViewBows?.adapter = adapter
        gridViewBows?.onItemClickListener

        expandListBows?.setOnClickListener {
            if (gridViewBows != null) expandList(gridViewBows,icExpandIconBows!!)
        }
        //////////////////////////////////////////////////////////GREATBOWS///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.alonnegreatbow,R.drawable.dragonslayergreatbow,R.drawable.possessedarmorgreatbow,R.drawable.twinheadedgreatbow)
        weaponName = arrayListOf(getString(R.string.alonne_greatbow),getString(R.string.dragonslayer_greatbow),getString(R.string.possessed_armor_greatbow),getString(R.string.twin_headed_greatbow))
        for (items in weaponName.indices) if (modalListGreatbows.size < 4) modalListGreatbows.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListGreatbows)
        gridViewGreatbows?.adapter = adapter
        gridViewGreatbows?.onItemClickListener

        expandListGreatbows?.setOnClickListener {
            if (gridViewGreatbows != null) expandList(gridViewGreatbows,icExpandIconGreatbows!!)
        }
        //////////////////////////////////////////////////////////CROSSBOWS///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.lightcrossbow,R.drawable.heavycrossbow,R.drawable.shieldcrossbow,R.drawable.avelyn,R.drawable.sanctumrepeatingcrossbow,R.drawable.sanctumcrossbow)
        weaponName = arrayListOf(getString(R.string.light_crossbow),getString(R.string.heavy_crossbow),getString(R.string.shield_crossbow),getString(R.string.avelyn),getString(R.string.sanctum_repeating_crossbow),getString(R.string.sanctum_crossbow))
        for (items in weaponName.indices) if (modalListCrossBows.size < 6) modalListCrossBows.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListCrossBows)
        gridViewCrossbows?.adapter = adapter
        gridViewCrossbows?.onItemClickListener

        expandListCrossbows?.setOnClickListener {
            if (gridViewCrossbows != null) expandList(gridViewCrossbows,icExpandIconCrossBows!!)
        }
        //////////////////////////////////////////////////////////FLAMES///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.pyromancyflame,R.drawable.darkpyromancyflame)
        weaponName = arrayListOf(getString(R.string.pyromancy_flame),getString(R.string.dark_pyromancy_flame))
        for (items in weaponName.indices) if (modalListFlames.size < 2) modalListFlames.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListFlames)
        gridViewFlames?.adapter = adapter
        gridViewFlames?.onItemClickListener

        expandListFlames?.setOnClickListener {
            if (gridViewFlames != null) expandList(gridViewFlames,icExpandIconFlames!!)
        }
        //////////////////////////////////////////////////////////CHIMES///////////////////////////////////////////////////////////////////////////////////////

        weaponImage = intArrayOf(R.drawable.clericssacredchime,R.drawable.witchtreebellvine,R.drawable.priestschime,R.drawable.dragonchime,R.drawable.chimeofwant,R.drawable.archdrakechime,
            R.drawable.idolschime,R.drawable.caithaschime,R.drawable.protectivechime,R.drawable.discchime,R.drawable.chimeofscreams)
        weaponName = arrayListOf(getString(R.string.clerics_sacred_chime),getString(R.string.witchtree_bellvine),getString(R.string.priests_chime),getString(R.string.dragon_chime),getString(R.string.chime_of_want),getString(R.string.archdrake_chime),
            getString(R.string.idols_chime),getString(R.string.caithas_chime),getString(R.string.protective_chime),getString(R.string.disc_chime),getString(R.string.chime_of_screams))
        for (items in weaponName.indices) if (modalListChimes.size < 11) modalListChimes.add(Modal(this.weaponName[items],weaponImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListChimes)
        gridViewChimes?.adapter = adapter
        gridViewChimes?.onItemClickListener

        expandListChimes?.setOnClickListener {
            if (gridViewChimes != null) expandList(gridViewChimes,icExpandIconChimes!!)
        }

        return root
    }



    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId){
        R.id.action_about -> {

            //transaction = parentFragmentManager.beginTransaction()
            Toast.makeText(this.context,"about", Toast.LENGTH_LONG).show()
            //transaction?.disallowAddToBackStack()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
    private fun expandList(gridView: GridView, imageView: ImageView){
        if (!gridView.isVisible){
            gridView.isVisible = true
            imageView.setImageResource(R.drawable.ic_expand_less_dark)
        }else if(gridView.isVisible){
            gridView.isVisible = false
            imageView.setImageResource(R.drawable.ic_expand_more_dark)
        }
    }
    override fun clickedItem(itemsModalItems: Modal) {
        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }


}