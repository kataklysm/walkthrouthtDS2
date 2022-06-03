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


class ShieldsFragment : Fragment(),ItemsAdapterItems.ClickListener {
    private var root: View? = null
    private var provider: String? = null
    private var shieldName = arrayListOf("")
    private var shieldImage = intArrayOf()
    //private var banner: AdView? = null

    private var modalListSmallShields = ArrayList<Modal>()
    private var icExpandIconSmallShields: ImageView? = null

    private var modalListStandardShields = ArrayList<Modal>()
    private var icExpandIconStandardShields: ImageView? = null

    private var modalListGreatShields = ArrayList<Modal>()
    private var icExpandIconGreatShields: ImageView? = null

    private var modalListDlcShields = ArrayList<Modal>()
    private var icExpandIconDlcShields: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shields)
        root = inflater.inflate(R.layout.fragment_shields, container, false)
        provider = arguments?.getString("provider")

        //banner = root?.findViewById(R.id.bannerShields)
        val expandListSmallShields = root?.findViewById<TextView>(R.id.tvExpandListSmallShields)
        val gridViewSmallShields = root?.findViewById<GridView>(R.id.gridViewSmallShields)
        icExpandIconSmallShields = root?.findViewById(R.id.ivExpandIconSmallShields)

        val expandListStandardShields = root?.findViewById<TextView>(R.id.tvExpandListStandardShields)
        val gridViewStandardShields= root?.findViewById<GridView>(R.id.gridViewStandardShields)
        icExpandIconStandardShields = root?.findViewById(R.id.ivExpandIconStandardShields)

        val expandListGreatShields = root?.findViewById<TextView>(R.id.tvExpandListGreatShields)
        val gridViewGreatShields = root?.findViewById<GridView>(R.id.gridViewGreatShields)
        icExpandIconGreatShields = root?.findViewById(R.id.ivExpandIconGreatShields)

        val expandListDlcShields = root?.findViewById<TextView>(R.id.tvExpandListDlcShields)
        val gridViewDlcShields = root?.findViewById<GridView>(R.id.gridViewDlcShields)
        icExpandIconDlcShields = root?.findViewById(R.id.ivExpandIconDlcShields)

        //initLoadAds()
        var adapter: ItemsAdapterItems
        ///////////////////////////////////////////////////////////////////////////////SMALL SHIELDS//////////////////////////////////////////////////////
        shieldImage = intArrayOf(R.drawable.bucklerframe,R.drawable.benhartsparma,R.drawable.clericsparma,R.drawable.clericssmallshield,R.drawable.crimsonparma,
            R.drawable.cursedboneshield,R.drawable.footsoldiershield,R.drawable.goldenfalconshield,R.drawable.ironparma,R.drawable.llewellynshield,R.drawable.magicshield,
            R.drawable.manikinshield,R.drawable.phoenixparma,R.drawable.smallleathershield,R.drawable.sunlightparma,R.drawable.targetshield,R.drawable.transgressorsleathershield,
            R.drawable.varangianshield,R.drawable.watchersshield)
        shieldName = arrayListOf(getString(R.string.buckler),getString(R.string.benharts_parma),getString(R.string.clerics_parma),getString(R.string.clerics_small_shield),getString(R.string.crimson_parma),getString(R.string.cursed_bone_shield),getString(R.string.foot_soldier_shield),
            getString(R.string.golden_falcon_shield),getString(R.string.iron_parma),getString(R.string.llewellyn_shield),getString(R.string.magic_shield),getString(R.string.manikin_shield),getString(R.string.phoenix_parma),getString(R.string.small_leather_shield),getString(R.string.sunlight_parma),
            getString(R.string.target_shield),getString(R.string.transgressors_leather_shield),getString(R.string.varangian_shield),getString(R.string.watchers_shield))

        for (items in shieldName.indices) if (modalListSmallShields.size < 19) modalListSmallShields.add(Modal(this.shieldName[items],shieldImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListSmallShields)
        gridViewSmallShields?.adapter = adapter
        gridViewSmallShields?.onItemClickListener
        expandListSmallShields?.setOnClickListener {
            if (gridViewSmallShields != null) expandList(gridViewSmallShields,icExpandIconSmallShields!!)
        }

        ///////////////////////////////////////////////////////////////////////////////STANDARD SHIELDS//////////////////////////////////////////////////////
        shieldImage = intArrayOf(R.drawable.largeleathershield,R.drawable.archdrakeshield,R.drawable.bellkeepershield,R.drawable.blackdragonshield,R.drawable.blackflamestoneparma,
            R.drawable.blossomkiteshield,R.drawable.bluewoodenshield,R.drawable.boneshield,R.drawable.boundwoodenshield,R.drawable.chaosshield,R.drawable.defendersshield,
            R.drawable.drakekeepersshield,R.drawable.drangleicshield,R.drawable.goldenwingshield,R.drawable.grandspirittreeshield,R.drawable.hollowsoldiershield,
            R.drawable.homunculuswoodenshield,R.drawable.kingsshield,R.drawable.lionclanshield,R.drawable.loyceshield,R.drawable.mirrahshield,R.drawable.moonbutterflyshield,
            R.drawable.oldknightsshield,R.drawable.porcineshield,R.drawable.redrustshield,R.drawable.royalkiteshield,R.drawable.shieldoftheinsolent,R.drawable.silvereaglekiteshield,
            R.drawable.silverblackshield,R.drawable.slumberingdragonshield,R.drawable.spirittreeshield,R.drawable.stoneparma,R.drawable.watchdragonparma,R.drawable.woodenshieldframe,
            R.drawable.yellowquartzshield)
        shieldName = arrayListOf(getString(R.string.large_leather_shield),getString(R.string.archdrake_shield),getString(R.string.bell_keeper_shield),getString(R.string.black_dragon_shield),getString(R.string.black_flamestone_parma),getString(R.string.blossom_kite_shield),
            getString(R.string.blue_wooden_shield),getString(R.string.bone_shield),getString(R.string.bound_wooden_shield),getString(R.string.chaos_shield),getString(R.string.defenders_shield),getString(R.string.drakekeepers_shield),getString(R.string.drangleic_shield),getString(R.string.golden_wing_shield),getString(R.string.grand_spirit_tree_shield),
            getString(R.string.hollow_soldier_shield),getString(R.string.homunculus_wooden_shield),getString(R.string.kings_shield),getString(R.string.lion_clan_shield),getString(R.string.loyce_shield),getString(R.string.mirrah_shield),getString(R.string.moon_butterfly_shield),
            getString(R.string.old_knights_shield),getString(R.string.porcine_shield),getString(R.string.red_rust_shield),getString(R.string.royal_kite_shield),getString(R.string.shield_of_the_insolent),getString(R.string.silver_eagle_kite_shield),getString(R.string.silverblack_shield),getString(R.string.slumbering_dragon_shield),
            getString(R.string.spirit_tree_shield),getString(R.string.stone_parma),getString(R.string.watchdragon_parma),getString(R.string.wooden_shield),getString(R.string.yellow_quartz_shield))

        for (items in shieldName.indices) if (modalListStandardShields.size < 36)  modalListStandardShields.add(Modal(this.shieldName[items],shieldImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListStandardShields)
        gridViewStandardShields?.adapter = adapter
        gridViewStandardShields?.onItemClickListener
        expandListStandardShields?.setOnClickListener {
            if (gridViewStandardShields != null) expandList(gridViewStandardShields,icExpandIconStandardShields!!)
        }

        ///////////////////////////////////////////////////////////////////////////////GREAT SHIELDS//////////////////////////////////////////////////////
        shieldImage = intArrayOf(R.drawable.twindragongreatshield,R.drawable.dragonridergreatshield,R.drawable.drakekeepersgreatshield,R.drawable.greatshieldofglory,R.drawable.gyrmgreatshield,
            R.drawable.havelsgreatshield,R.drawable.kingsmirror,R.drawable.mastodongreatshield,R.drawable.oldknightgreatshield,R.drawable.ormasgreatshield,R.drawable.patesshield,
            R.drawable.pursuersgreatshield,R.drawable.rebelsgreatshield,R.drawable.reevesgreatshield,R.drawable.towershield,R.drawable.wickedeyegreatshield)
        shieldName = arrayListOf(getString(R.string.twin_dragon_greatshield),getString(R.string.dragonrider_greatshield),getString(R.string.drakekeepers_greatshield),getString(R.string.greatshield_of_glory),getString(R.string.gyrm_greatshield),getString(R.string.havels_greatshield),getString(R.string.kings_mirror),
            getString(R.string.mastodon_greatshield),getString(R.string.old_knight_greatshield),getString(R.string.ormas_greatshield),getString(R.string.pates_shield),getString(R.string.pursuers_greatshield),getString(R.string.rebels_greats_shield),getString(R.string.reeves_greatshield),getString(R.string.tower_shield),
            getString(R.string.wicked_eye_greatshield))

        for (items in shieldName.indices)if (modalListGreatShields.size < 16)  modalListGreatShields.add(Modal(this.shieldName[items],shieldImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListGreatShields)
        gridViewGreatShields?.adapter = adapter
        gridViewGreatShields?.onItemClickListener
        expandListGreatShields?.setOnClickListener {
            if (gridViewGreatShields != null) expandList(gridViewGreatShields,icExpandIconGreatShields!!)
        }

        ///////////////////////////////////////////////////////////////////////////////DLC SHIELDS//////////////////////////////////////////////////////
        shieldImage = intArrayOf(R.drawable.sanctumshield,R.drawable.charredloyceshield,R.drawable.loyceshield,R.drawable.rampartgolemshield,R.drawable.vesselshield)
        shieldName = arrayListOf(getString(R.string.sanctum_shield),getString(R.string.charred_loyce_shield),getString(R.string.loyce_shield),getString(R.string.rampart_golem_shield),getString(R.string.vessel_shield))

        for (items in shieldName.indices) if (modalListDlcShields.size < 5) modalListDlcShields.add(Modal(this.shieldName[items],shieldImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListDlcShields)
        gridViewDlcShields?.adapter = adapter
        gridViewDlcShields?.onItemClickListener
        expandListDlcShields?.setOnClickListener {
            if (gridViewDlcShields != null) expandList(gridViewDlcShields,icExpandIconDlcShields!!)
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