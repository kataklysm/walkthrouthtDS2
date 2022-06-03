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

class ObjectsFragment : Fragment(),ItemsAdapterItems.ClickListener {

    private var root: View? = null
    private var provider: String? = null
    private var transaction: FragmentTransaction? = null

    private var objectName = arrayListOf("")
    private var objectImage = intArrayOf()
    private var modalListConsumables = ArrayList<Modal>()
    private var icExpandIconConsumables: ImageView? = null
    private var modalListAmmo = ArrayList<Modal>()
    private var icExpandIconAmmo: ImageView? = null
    private var modalListMultiplayerItems = ArrayList<Modal>()
    private var icExpandIconMultiplayerItems: ImageView? = null
    private var modalListKeys = ArrayList<Modal>()
    private var icExpandIconKeys: ImageView? = null
    private var modalListUpgradeMaterials = ArrayList<Modal>()
    private var icExpandIconUpgradeMaterials: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.items)
        root = inflater.inflate(R.layout.fragment_objects, container, false)
        provider = arguments?.getString("provider")

        val expandListConsumables = root?.findViewById<TextView>(R.id.tvExpandListConsumables)
        val gridViewConsumables = root?.findViewById<GridView>(R.id.gridViewConsumables)
        icExpandIconConsumables = root?.findViewById(R.id.ivExpandIconConsumables)

        val expandListAmmo = root?.findViewById<TextView>(R.id.tvExpandListAmmo)
        val gridViewAmmo = root?.findViewById<GridView>(R.id.gridViewAmmo)
        icExpandIconAmmo = root?.findViewById(R.id.ivExpandIconAmmo)

        val expandListMultiplayerItems = root?.findViewById<TextView>(R.id.tvExpandListMultiplayerItems)
        val gridViewMultiplayerItems = root?.findViewById<GridView>(R.id.gridViewMultiplayerItems)
        icExpandIconMultiplayerItems = root?.findViewById(R.id.ivExpandIconMultiplayerItems)

        val expandListKeys = root?.findViewById<TextView>(R.id.tvExpandListKeys)
        val gridViewKeys = root?.findViewById<GridView>(R.id.gridViewKeys)
        icExpandIconKeys = root?.findViewById(R.id.ivExpandIconKeys)

        val expandListUpgradeMaterials = root?.findViewById<TextView>(R.id.tvExpandListUpgradeMaterial)
        val gridViewUpgradeMaterial = root?.findViewById<GridView>(R.id.gridViewUpgradeMaterial)
        icExpandIconUpgradeMaterials = root?.findViewById(R.id.ivExpandIconUpgradeMaterial)


        var adapter: ItemsAdapterItems

        ///////////////////////////////////////////////////////////CONSUMABLES

        objectImage = intArrayOf(R.drawable.estusflask,R.drawable.humaneffigy,R.drawable.lifegem,R.drawable.radiantlifegem,R.drawable.oldradiantlifegem,R.drawable.elizabethmushroom,R.drawable.amberherb,
            R.drawable.twilightherb,R.drawable.wiltedduskherb,R.drawable.poisonmoss,R.drawable.monasterycharm,R.drawable.dragoncharm,R.drawable.divineblessing,R.drawable.greenblossom,R.drawable.darktroches,
            R.drawable.commonfruit,R.drawable.triclopssnaketroches,R.drawable.redleechtroches,R.drawable.repairpowder,R.drawable.rougewater,R.drawable.crimsonwater,R.drawable.smallblueburr,
            R.drawable.smallyellowburr,R.drawable.smallorangeburr,R.drawable.driedroot,R.drawable.oldgrowthbalm,R.drawable.goldenfruitbalm,R.drawable.blackweedbalm,R.drawable.vinebalm,R.drawable.brightbug,
            R.drawable.firebomb,R.drawable.blackfirebomb,R.drawable.witchingurn,R.drawable.lightningurn,R.drawable.hexingurn,R.drawable.holywaterurn,R.drawable.corrosiveurn,R.drawable.throwingknife,
            R.drawable.laceratingknife,R.drawable.poisonthrowingknife,R.drawable.dungpie,R.drawable.aromaticooze,R.drawable.goldpineresin,R.drawable.charcoalpineresin,R.drawable.darkpineresin,
            R.drawable.rottenpineresin,R.drawable.bleedingserum,R.drawable.alluringskull,R.drawable.lloydstalisman,R.drawable.dragonheadstone,R.drawable.dragontorsostone,R.drawable.homewardbone,
            R.drawable.agedfeather,R.drawable.darksign,R.drawable.flamebutterfly,R.drawable.silvertalisman,R.drawable.rustedcoin,R.drawable.bonfireascetic,R.drawable.rubbish,R.drawable.simpletonsspice,
            R.drawable.skepticsspice,R.drawable.crushedeyeorb,R.drawable.pharroslockstone,R.drawable.fragrantbranchofyore,R.drawable.prismstone,R.drawable.smallsmoothandsilkystone,R.drawable.smoothandsilkystone,
            R.drawable.petrifiedsomething,R.drawable.soulvessel,R.drawable.estusflaskshard,R.drawable.petrifiedegg,R.drawable.smelterwedge)

        objectName = arrayListOf(getString(R.string.estus_flask),getString(R.string.human_effigy),getString(R.string.life_gem),getString(R.string.radiant_life_gem),getString(R.string.old_radiant_life_gem),getString(R.string.elizabeth_mushroom),getString(R.string.amber_herb),
            getString(R.string.twilight_herb),getString(R.string.wilted_dusk_herb),getString(R.string.poison_moss),getString(R.string.monastery_charm),getString(R.string.dragon_charm),getString(R.string.divine_blessing),getString(R.string.green_blossom),getString(R.string.dark_troches),
            getString(R.string.common_fruit),getString(R.string.triclops_snake_troches),getString(R.string.red_leech_troches),getString(R.string.repair_powder),getString(R.string.rouge_water),getString(R.string.crimson_water),getString(R.string.small_blue_burr),
            getString(R.string.small_yellow_burr),getString(R.string.small_orange_burr),getString(R.string.dried_root),getString(R.string.old_growth_balm),getString(R.string.goldenfruit_balm),getString(R.string.blackweed_balm),getString(R.string.vine_balm),getString(R.string.brightbug),
            getString(R.string.fire_bomb),getString(R.string.black_firebomb),getString(R.string.witching_urn),getString(R.string.lightning_urn),getString(R.string.hexing_urn),getString(R.string.holy_water_urn),getString(R.string.corrosive_urn),getString(R.string.throwing_knife),
            getString(R.string.lacerating_knife),getString(R.string.poison_throwing_knife),getString(R.string.dung_pie),getString(R.string.aromatic_ooze),getString(R.string.gold_pine_resin),getString(R.string.charcoal_pine_resin),getString(R.string.dark_pine_resin),
            getString(R.string.rotten_pine_resin),getString(R.string.bleeding_serum),getString(R.string.alluring_skull),getString(R.string.lloyds_talisman),getString(R.string.dragon_head_stone),getString(R.string.dragon_torso_stone),getString(R.string.homeward_bone),
            getString(R.string.aged_feather),getString(R.string.darksign),getString(R.string.flame_butterfly),getString(R.string.silver_talisman),getString(R.string.rusted_coin),getString(R.string.bonfire_ascetic),getString(R.string.rubbish),getString(R.string.simpletons_spice),
            getString(R.string.skeptics_spice),getString(R.string.crushed_eye_orb),getString(R.string.pharros_lockstone),getString(R.string.fragrant_branch_of_yore),getString(R.string.prism_stone),getString(R.string.small_smooth_silky_stone),getString(R.string.smooth_and_silky_stone),
            getString(R.string.petrified_something),getString(R.string.soul_vessel),getString(R.string.estus_flask_shard),getString(R.string.petrified_egg),getString(R.string.smelter_wedge))
        for (items in objectName.indices) if (modalListConsumables.size < 72) modalListConsumables.add(Modal(this.objectName[items],objectImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListConsumables)
        gridViewConsumables?.adapter = adapter
        gridViewConsumables?.onItemClickListener
        expandListConsumables?.setOnClickListener {
            if (gridViewConsumables != null) expandList(gridViewConsumables,icExpandIconConsumables!!)
        }
        ///////////////////////////////////////////////////////////AMMO

        objectImage = intArrayOf(R.drawable.woodarrow,R.drawable.ironarrow,R.drawable.magicarrow,R.drawable.lightningarrow,R.drawable.firearrow,R.drawable.darkarrow,R.drawable.poisonarrow,
            R.drawable.laceratingarrow,R.drawable.woodbolt,R.drawable.heavybolt,R.drawable.firebolt,R.drawable.lightningbolt,R.drawable.magicbolt,R.drawable.darkbolt,R.drawable.irongreatarrow,
            R.drawable.destructivegreatarrow,R.drawable.lightninggreatarrow,R.drawable.firegreatarrow)
        objectName = arrayListOf(getString(R.string.wood_arrow),getString(R.string.iron_arrow),getString(R.string.magic_arrow),getString(R.string.lightning_arrow),getString(R.string.fire_arrow),getString(R.string.dark_arrow),getString(R.string.poison_arrow),
            getString(R.string.lacerating_arrow),getString(R.string.wood_bolt),getString(R.string.heavy_bolt),getString(R.string.fire_bolt),getString(R.string.lightning_bolt),getString(R.string.magic_bolt),getString(R.string.dark_bolt),getString(R.string.iron_greatarrow),
            getString(R.string.destructive_greatarrow),getString(R.string.lightning_greatarrow),getString(R.string.fire_greatarrow))
        for (items in objectName.indices) if (modalListAmmo.size < 18) modalListAmmo.add(Modal(this.objectName[items],objectImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListAmmo)
        gridViewAmmo?.adapter = adapter
        gridViewAmmo?.onItemClickListener
        expandListAmmo?.setOnClickListener {
            if (gridViewAmmo != null) expandList(gridViewAmmo,icExpandIconAmmo!!)
        }
        ///////////////////////////////////////////////////////////MULTIPLAYER ITEMS

        objectImage = intArrayOf(R.drawable.redsignsoapstone,R.drawable.smallwhitesignsoapstone,R.drawable.whitesignsoapstone,R.drawable.dragoneye,R.drawable.crackedredeyeorb,R.drawable.crackedblueeyeorb,
            R.drawable.awestone,R.drawable.rattail,R.drawable.sunlightmedal,R.drawable.dragonscale,R.drawable.blackseparationcrystal,R.drawable.boneoforder,R.drawable.championstablet,R.drawable.driedfingers,
            R.drawable.tokenoffidelity,R.drawable.tokenofspite,R.drawable.seedofatreeofgiants,R.drawable.hellocarving,R.drawable.thankyoucarving,R.drawable.imsorrycarving,R.drawable.verygoodcarving)


        objectName = arrayListOf(getString(R.string.red_sign_soapstone),getString(R.string.small_white_sign_soapstone),getString(R.string.white_sign_soapstone),getString(R.string.dragon_eye),getString(R.string.cracked_red_eye_orb),getString(R.string.cracked_blue_eye_orb),
            getString(R.string.awestone),getString(R.string.rat_tail),getString(R.string.sunlight_medal),getString(R.string.dragon_scale),getString(R.string.black_separation_crystal),getString(R.string.bone_of_order),getString(R.string.champions_tablet),getString(R.string.dried_fingers),
            getString(R.string.token_of_fidelity),getString(R.string.token_of_spite),getString(R.string.seed_of_a_tree_of_giants),getString(R.string.hello_carving),getString(R.string.thank_you_carving),getString(R.string.im_sorry_carving),getString(R.string.very_good_carving))
        for (items in objectName.indices) if (modalListMultiplayerItems.size < 21 ) modalListMultiplayerItems.add(Modal(this.objectName[items],objectImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListMultiplayerItems)
        gridViewMultiplayerItems?.adapter = adapter
        gridViewMultiplayerItems?.onItemClickListener
        expandListMultiplayerItems?.setOnClickListener {
            if (gridViewMultiplayerItems != null) expandList(gridViewMultiplayerItems,icExpandIconMultiplayerItems!!)
        }
        ///////////////////////////////////////////////////////////KEYS

        objectImage = intArrayOf(R.drawable.aldiakey,R.drawable.antiquatedkey,R.drawable.ashenmistheart,R.drawable.bastillekey,R.drawable.brightstonekey,R.drawable.dragontalon,R.drawable.dragonstone,
            R.drawable.dullember,R.drawable.eternalsanctumkey,R.drawable.eyeofthepriestess,R.drawable.fangkey,R.drawable.forgottenkey,R.drawable.frozenflower,R.drawable.garrisonwardkey,
            R.drawable.giantskinship,R.drawable.heavyironkey,R.drawable.housekey,R.drawable.ironkey,R.drawable.keytokingspassage,R.drawable.keytotheembedded,R.drawable.ladderminiature,R.drawable.lenigrastskey,
            R.drawable.rotundalockstone,R.drawable.scorchingironscepter,R.drawable.soldierkey,R.drawable.towerkey,R.drawable.tseldoradenkey)
        objectName = arrayListOf(getString(R.string.aldia_key),getString(R.string.antiquated_key),getString(R.string.ashen_mist_heart),getString(R.string.bastille_key),getString(R.string.brightstone_key),getString(R.string.dragon_talon),getString(R.string.dragon_stone),
            getString(R.string.dullember),getString(R.string.eternal_sanctum_key),getString(R.string.eye_of_the_priestess),getString(R.string.fang_key),getString(R.string.forgotten_key),getString(R.string.frozen_flower),getString(R.string.garrison_ward_key),
            getString(R.string.giants_kinship),getString(R.string.heavy_iron_key),getString(R.string.house_key),getString(R.string.iron_key),getString(R.string.key_to_kings_passage),getString(R.string.key_to_the_embedded),getString(R.string.ladder_miniature),getString(R.string.lenigrasts_key),
            getString(R.string.rotunda_lockstone),getString(R.string.scorching_iron_scepter),getString(R.string.soldier_key),getString(R.string.tower_key),getString(R.string.tseldoraden_key))

        for (items in objectName.indices) if (modalListKeys.size < 27) modalListKeys.add(Modal(this.objectName[items],objectImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListKeys)
        gridViewKeys?.adapter = adapter
        gridViewKeys?.onItemClickListener
        expandListKeys?.setOnClickListener {
            if (gridViewKeys != null) expandList(gridViewKeys,icExpandIconKeys!!)
        }
        ///////////////////////////////////////////////////////////UPGRADEMATERIAL

        objectImage = intArrayOf(R.drawable.titaniteshard,R.drawable.largetitaniteshard,R.drawable.titanitechunk,R.drawable.titaniteslab,R.drawable.twinklingtitanite,R.drawable.petrifieddragonbone,
            R.drawable.fireseed,R.drawable.faintstone,R.drawable.firedrakestone,R.drawable.boltstone,R.drawable.darknightstone,R.drawable.poisonstone,R.drawable.bleedstone,R.drawable.rawstone,
            R.drawable.magicstone,R.drawable.oldmundanestone,R.drawable.palestone)
        objectName = arrayListOf(getString(R.string.titanite_shard),getString(R.string.large_titanite_shard),getString(R.string.titanite_chunk),getString(R.string.titanite_slab),getString(R.string.twinkling_titanite),getString(R.string.petrified_dragon_bone),
            getString(R.string.fire_seed),getString(R.string.faint_stone),getString(R.string.firedrake_stone),getString(R.string.boltstone),getString(R.string.darknight_stone),getString(R.string.poison_stone),getString(R.string.bleed_stone),getString(R.string.raw_stone),
            getString(R.string.magic_stone),getString(R.string.old_mundane_stone),getString(R.string.palestone))
        for (items in objectName.indices) if(modalListUpgradeMaterials.size < 17) modalListUpgradeMaterials.add(Modal(this.objectName[items],objectImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListUpgradeMaterials)
        gridViewUpgradeMaterial?.adapter = adapter
        gridViewUpgradeMaterial?.onItemClickListener
        expandListUpgradeMaterials?.setOnClickListener {
            if (gridViewUpgradeMaterial != null) expandList(gridViewUpgradeMaterial,icExpandIconUpgradeMaterials!!)
        }

        return root
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