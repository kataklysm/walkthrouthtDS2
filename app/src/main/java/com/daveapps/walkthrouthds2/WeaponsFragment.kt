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


class WeaponsFragment : Fragment(), ItemsAdapterItems.ClickListener{
    private var root: View? = null
    private var provider: String? = null
    private var transaction: FragmentTransaction? = null
    private var weaponName = arrayListOf("")
    private var weaponImage = intArrayOf()

    private var modalListDaggers = ArrayList<Modal>()
    private var icExpandIconDaggers: ImageView? = null

    private var modalListStraightSword = ArrayList<Modal>()
    private var icExpandIconStraightSword: ImageView? = null

    private var modalListGreatswords = ArrayList<Modal>()
    private var icExpandIconGreatswords: ImageView? = null

    private var modalListUltraGreatswords = ArrayList<Modal>()
    private var icExpandIconUltraGreatswords: ImageView? = null

    private var modalListCurvedSwords = ArrayList<Modal>()
    private var icExpandIconCurvedSwords: ImageView? = null

    private var modalListKatanas = ArrayList<Modal>()
    private var icExpandIconKatanas: ImageView? = null

    private var modalListCurvedGreatswords = ArrayList<Modal>()
    private var icExpandIconCurvedGreatswords: ImageView? = null

    private var modalListPiercingSwords = ArrayList<Modal>()
    private var icExpandIconPiercingSwords: ImageView? = null

    private var modalListAxes = ArrayList<Modal>()
    private var icExpandIconAxes: ImageView? = null

    private var modalListGreatAxes = ArrayList<Modal>()
    private var icExpandIconGreatAxes: ImageView? = null

    private var modalListHammers = ArrayList<Modal>()
    private var icExpandIconHammers: ImageView? = null

    private var modalListGreatHammers = ArrayList<Modal>()
    private var icExpandIconGreatHammers: ImageView? = null

    private var modalListSpears = ArrayList<Modal>()
    private var icExpandIconSpears: ImageView? = null

    private var modalListHalberds = ArrayList<Modal>()
    private var icExpandIconHalberds: ImageView? = null

    private var modalListLances = ArrayList<Modal>()
    private var icExpandIconLances: ImageView? = null

    private var modalListReapers = ArrayList<Modal>()
    private var icExpandIconReapers: ImageView? = null

    private var modalListTwinblades = ArrayList<Modal>()
    private var icExpandIconTwinblades: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.weapons)
        root = inflater.inflate(R.layout.fragment_weapons, container, false)
        provider = arguments?.getString("provider")


        val expandListDagger = root?.findViewById<TextView>(R.id.tvExpandListDagger)
        val gridViewDaggers = root?.findViewById<GridView>(R.id.gridViewWeaponDaggers)
        icExpandIconDaggers = root?.findViewById(R.id.ivExpandIconDaggers)

        val expandListStraightSword = root?.findViewById<TextView>(R.id.tvExpandListStraightSword)
        val gridViewStraightSword = root?.findViewById<GridView>(R.id.gridViewStraightSword)
        icExpandIconStraightSword = root?.findViewById(R.id.ivExpandIconStraightSword)

        val expandListGreatswords = root?.findViewById<TextView>(R.id.tvExpandListGreatsword)
        val gridViewGreatswords = root?.findViewById<GridView>(R.id.gridViewGreatsword)
        icExpandIconGreatswords = root?.findViewById(R.id.ivExpandIconGreatsword)

        val expandListUltraGreatswords = root?.findViewById<TextView>(R.id.tvExpandListUltraGreatsword)
        val gridViewUltraGreatswords = root?.findViewById<GridView>(R.id.gridViewUltraGreatsword)
        icExpandIconUltraGreatswords = root?.findViewById(R.id.ivExpandIconUltraGreatsword)

        val expandListCurvedSwords = root?.findViewById<TextView>(R.id.tvExpandListCurvedSwords)
        val gridViewCurvedSwords = root?.findViewById<GridView>(R.id.gridViewCurvedSwords)
        icExpandIconCurvedSwords = root?.findViewById(R.id.ivExpandIconCurvedSwords)

        val expandListKatanas = root?.findViewById<TextView>(R.id.tvExpandListKatanas)
        val gridViewKatanas = root?.findViewById<GridView>(R.id.gridViewKatanas)
        icExpandIconKatanas = root?.findViewById(R.id.ivExpandIconKatanas)

        val expandListCurvedGreatswords = root?.findViewById<TextView>(R.id.tvExpandListCurvedGreatswords)
        val gridViewCurvedGreatswords = root?.findViewById<GridView>(R.id.gridViewCurvedGreatswords)
        icExpandIconCurvedGreatswords = root?.findViewById(R.id.ivExpandIconCurvedGreatswords)

        val expandListPiercingSwords = root?.findViewById<TextView>(R.id.tvExpandListPiercingSwords)
        val gridViewPiercingSwords = root?.findViewById<GridView>(R.id.gridViewPiercingSwords)
        icExpandIconPiercingSwords = root?.findViewById(R.id.ivExpandIconPiercingSwords)

        val expandListAxes = root?.findViewById<TextView>(R.id.tvExpandListAxes)
        val gridViewAxes = root?.findViewById<GridView>(R.id.gridViewAxes)
        icExpandIconAxes = root?.findViewById(R.id.ivExpandIconAxes)

        val expandListGreatAxes = root?.findViewById<TextView>(R.id.tvExpandListGreatAxes)
        val gridViewGreatAxes = root?.findViewById<GridView>(R.id.gridViewGreatAxes)
        icExpandIconGreatAxes = root?.findViewById(R.id.ivExpandIconGreatAxes)

        val expandListHammers = root?.findViewById<TextView>(R.id.tvExpandListHammers)
        val gridViewHammers = root?.findViewById<GridView>(R.id.gridViewHammers)
        icExpandIconHammers = root?.findViewById(R.id.ivExpandIconHammers)

        val expandListGreatHammers = root?.findViewById<TextView>(R.id.tvExpandListGreatHammers)
        val gridViewGreatHammers = root?.findViewById<GridView>(R.id.gridViewGreatHammers)
        icExpandIconGreatHammers = root?.findViewById(R.id.ivExpandIconGreatHammers)

        val expandListSpears = root?.findViewById<TextView>(R.id.tvExpandListSpears)
        val gridViewSpears = root?.findViewById<GridView>(R.id.gridViewSpears)
        icExpandIconSpears = root?.findViewById(R.id.ivExpandIconSpears)

        val expandListHalberds = root?.findViewById<TextView>(R.id.tvExpandListHalberds)
        val gridViewHalberds = root?.findViewById<GridView>(R.id.gridViewHalberds)
        icExpandIconHalberds = root?.findViewById(R.id.ivExpandIconHalberds)

        val expandListLances = root?.findViewById<TextView>(R.id.tvExpandListLances)
        val gridViewLances = root?.findViewById<GridView>(R.id.gridViewLances)
        icExpandIconLances = root?.findViewById(R.id.ivExpandIconLances)

        val expandListReapers = root?.findViewById<TextView>(R.id.tvExpandListReapers)
        val gridViewReapers = root?.findViewById<GridView>(R.id.gridViewReapers)
        icExpandIconReapers = root?.findViewById(R.id.ivExpandIconReapers)

        val expandListTwinblades = root?.findViewById<TextView>(R.id.tvExpandListTwinblades)
        val gridViewTwinblades = root?.findViewById<GridView>(R.id.gridViewTwinblades)
        icExpandIconTwinblades = root?.findViewById(R.id.ivExpandIconTwinblades)

        //initLoadAds()
        var adapter = ItemsAdapterItems(this.requireContext(),this)
        ///////////////////////////////////////////////////////////////////////////////////DAGGERS/////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.dagger,R.drawable.royaldirk,R.drawable.blackflamestonedagger,R.drawable.parryingdagger,R.drawable.banditsknife,R.drawable.mythasbentblade,
            R.drawable.shadowdagger,R.drawable.thiefdagger,R.drawable.brokenthiefsword,R.drawable.manikinknife,R.drawable.umbraldagger,R.drawable.bluedagger,R.drawable.retainersshortsword)
        weaponName = arrayListOf(getString(R.string.dagger),getString(R.string.royal_dirk),getString(R.string.black_flamestone_dagger),getString(R.string.parrying_dagger),getString(R.string.bandits_knife),getString(R.string.mythas_bent_blade),
            getString(R.string.shadow_dagger),getString(R.string.thief_dagger),getString(R.string.broken_thief_sword),getString(R.string.manikin_knife),getString(R.string.umbral_dagger),getString(R.string.blue_dagger),getString(R.string.retainers_short_sword))

        for(items in weaponName.indices) if (modalListDaggers.size < 13) modalListDaggers.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter.setData(modalListDaggers)
        gridViewDaggers?.adapter = adapter
        gridViewDaggers?.onItemClickListener

        expandListDagger?.setOnClickListener {
            if (gridViewDaggers != null) expandList(gridViewDaggers,icExpandIconDaggers!!)
        }

        /////////////////////////////////////////////////////////////////////////////////STRAIGHT SWORDS////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.shortsword,R.drawable.longsword,R.drawable.yellowquartzlongsword,R.drawable.blackdragonsword,R.drawable.brokenstraightsword,R.drawable.broadsword,
            R.drawable.footsoldiersword,R.drawable.varangiansword,R.drawable.heideknightsword,R.drawable.blueflame,R.drawable.redrustsword,R.drawable.sunsword,R.drawable.drakekeeperssword,
            R.drawable.puzzlingstonesword,R.drawable.ashenwarriorsword,R.drawable.fumesword,R.drawable.possessedarmorsword,R.drawable.ivorystraightsword)
        weaponName = arrayListOf(getString(R.string.shortsword),getString(R.string.long_sword),getString(R.string.yellow_quartz_longsword),getString(R.string.black_dragon_sword),getString(R.string.broken_straight_sword),getString(R.string.broadsword),
            getString(R.string.foot_soldier_sword),getString(R.string.varangian_sword),getString(R.string.heide_knight_sword),getString(R.string.blue_flame),getString(R.string.red_rust_sword),getString(R.string.sun_sword),getString(R.string.drakekeepers_sword),
            getString(R.string.puzzling_stone_sword),getString(R.string.ashen_warrior_sword),getString(R.string.fume_sword),getString(R.string.possessed_armor_sword),getString(R.string.ivory_straight_sword))

        for (items in weaponName.indices) if (modalListStraightSword.size < 18) modalListStraightSword.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListStraightSword)
        gridViewStraightSword?.adapter = adapter
        gridViewStraightSword?.onItemClickListener

        expandListStraightSword?.setOnClickListener {
            if (gridViewStraightSword != null) expandList(gridViewStraightSword,icExpandIconStraightSword!!)
        }

        //////////////////////////////////////////////////////////////////////////////GREATSWORDS//////////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.bastardsword,R.drawable.bluemoongreatsword,R.drawable.claymore,R.drawable.flamberge,R.drawable.drangleicsword,R.drawable.thornedgreatsword,
            R.drawable.moonlightgreatsword,R.drawable.mastodongreatsword,R.drawable.rulerssword,R.drawable.mirrahgreatsword,R.drawable.oldmirrahgreatsword,R.drawable.blackdragongreatsword,
            R.drawable.blackknightgreatsword,R.drawable.royalgreatsword,R.drawable.oldknightgreatsword,R.drawable.defendergreatsword,R.drawable.watchergreatsword,R.drawable.keytotheembedded,
            R.drawable.drakebloodgreatsword,R.drawable.majesticgreatsword,R.drawable.charredloycegreatsword,R.drawable.loycegreatsword,R.drawable.greatswordoftheforlorn)
        weaponName = arrayListOf(
            getString(R.string.bastard_sword),getString(R.string.bluemoon_greatsword),getString(R.string.claymore),getString(R.string.flamberge),getString(R.string.drangleic_sword),getString(R.string.thorned_greatsword),
            getString(R.string.moonlight_greatsword),getString(R.string.mastodon_greatsword),getString(R.string.rulers_sword),getString(R.string.mirrah_greatsword),getString(R.string.old_mirrah_greatsword),getString(R.string.black_dragon_greatsword),
            getString(R.string.black_knight_greatsword),getString(R.string.royal_greatsword),getString(R.string.old_knight_greatsword),getString(R.string.defender_greatsword),getString(R.string.watcher_greatsword),getString(R.string.key_to_the_embedded),
            getString(R.string.drakeblood_greatsword),getString(R.string.majestic_greatsword),getString(R.string.charred_loyce_greatsword),getString(R.string.loyce_greatsword),getString(R.string.greatsword_of_the_forlorn))

        for (items in weaponName.indices) if(modalListCurvedGreatswords.size < 23) modalListGreatswords.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListGreatswords)
        gridViewGreatswords?.adapter = adapter
        gridViewGreatswords?.onItemClickListener
        expandListGreatswords?.setOnClickListener {
            if (gridViewGreatswords != null) expandList(gridViewGreatswords,icExpandIconGreatswords!!)
        }

        /////////////////////////////////////////////////////////////////////////ULTRA GREATSWORDS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.pursuersultragreatsword,R.drawable.zweihander,R.drawable.drakewingultragreatsword,R.drawable.kingsultragreatsword,R.drawable.drakekeepersultragreatsword,
            R.drawable.oldknightultragreatsword,R.drawable.blackknightultragreatsword,R.drawable.greatsword,R.drawable.smeltersword,R.drawable.cryptblacksword,R.drawable.lostsinnerssword,
            R.drawable.fumeultragreatsword,R.drawable.agedsmeltersword,R.drawable.ivorykingultragreatsword,
        )
        weaponName = arrayListOf(
            getString(R.string.pursuer_ultra_greatsword),getString(R.string.zweihander),getString(R.string.drakewing_ultra_greatsword),getString(R.string.kings_ultra_greatsword),getString(R.string.drakekeepers_ultra_greatsword),
            getString(R.string.old_knight_ultra_greatsword),getString(R.string.black_knight_ultra_greatsword),getString(R.string.greatsword),getString(R.string.smelter_sword),getString(R.string.crypt_blacksword),getString(R.string.lost_sinners_sword),
            getString(R.string.fume_ultra_greatsword),getString(R.string.aged_smelter_sword),getString(R.string.ivory_king_ultra_greatsword))

        for (items in weaponName.indices) if (modalListUltraGreatswords.size < 14) modalListUltraGreatswords.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListUltraGreatswords)
        gridViewUltraGreatswords?.adapter = adapter
        gridViewUltraGreatswords?.onItemClickListener
        expandListUltraGreatswords?.setOnClickListener {
            if (gridViewUltraGreatswords != null) expandList(gridViewUltraGreatswords,icExpandIconUltraGreatswords!!)
        }

        /////////////////////////////////////////////////////////////////////////CURVED SWORDS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.scimitar,R.drawable.redrustscimitar,R.drawable.spiderfang,R.drawable.meluscimitar,R.drawable.monasteryscimitar,R.drawable.falchion,
            R.drawable.shotel,R.drawable.warpedsword,R.drawable.manikinsabre,R.drawable.eleumloyce)
        weaponName = arrayListOf(getString(R.string.scimitar),getString(R.string.red_rust_scimitar),getString(R.string.spider_fang),getString(R.string.melu_scimitar),getString(R.string.monastery_scimitar),getString(R.string.falchion),
            getString(R.string.shotel),getString(R.string.warped_sword),getString(R.string.manikin_sabre),getString(R.string.eleum_loyce))

        for (items in weaponName.indices) if (modalListCurvedSwords.size < 10) modalListCurvedSwords.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListCurvedSwords)
        gridViewCurvedSwords?.adapter = adapter
        gridViewCurvedSwords?.onItemClickListener
        expandListCurvedSwords?.setOnClickListener {
            if (gridViewCurvedSwords != null) expandList(gridViewCurvedSwords,icExpandIconCurvedSwords!!)
        }

        /////////////////////////////////////////////////////////////////////////KATANAS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.uchigatana,R.drawable.washinpole,R.drawable.chaosblade,R.drawable.blacksteelkatana,R.drawable.manslayer,R.drawable.berserkerblade,
            R.drawable.darkdriftframe,R.drawable.bewitchedalonnesword)
        weaponName = arrayListOf(getString(R.string.uchigatana),getString(R.string.washin_pole),getString(R.string.chaos_blade),getString(R.string.blacksteel_katana),getString(R.string.manslayer),getString(R.string.berserker_blade),
            getString(R.string.darkdrift),getString(R.string.bewitched_alonne_sword))

        for (items in weaponName.indices) if (modalListKatanas.size < 8) modalListKatanas.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListKatanas)
        gridViewKatanas?.adapter = adapter
        gridViewKatanas?.onItemClickListener
        expandListKatanas?.setOnClickListener {
            if (gridViewKatanas != null) expandList(gridViewKatanas,icExpandIconKatanas!!)
        }

        /////////////////////////////////////////////////////////////////////////CURVED GREATSWORDS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.murakumo,R.drawable.arcedsword,R.drawable.curveddragongreatsword,R.drawable.curvednilgreatsword)
        weaponName = arrayListOf(getString(R.string.murakumo),getString(R.string.arced_sword),getString(R.string.curved_dragon_greatsword),getString(R.string.curved_nil_greatsword))

        for (items in weaponName.indices) if (modalListCurvedGreatswords.size < 4) modalListCurvedGreatswords.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListCurvedGreatswords)
        gridViewCurvedGreatswords?.adapter = adapter
        gridViewCurvedGreatswords?.onItemClickListener
        expandListCurvedGreatswords?.setOnClickListener {
            if (gridViewCurvedGreatswords != null) expandList(gridViewCurvedGreatswords,icExpandIconCurvedGreatswords!!)
        }

        /////////////////////////////////////////////////////////////////////////PIERCING SWORDS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.estoc,R.drawable.mailbreker,R.drawable.rapier,R.drawable.ricardsrapier,R.drawable.chaosrapier,R.drawable.blackscorpionstinger,
            R.drawable.spiderssilk,R.drawable.espadaropera,R.drawable.icerapier)
        weaponName = arrayListOf(getString(R.string.estoc),getString(R.string.mail_breker),getString(R.string.rapier),getString(R.string.ricards_rapier),getString(R.string.chaos_rapier),getString(R.string.black_scorpion_stinger),
            getString(R.string.spiders_silk),getString(R.string.espada_ropera),getString(R.string.ice_rapier))

        for (items in weaponName.indices) if (modalListPiercingSwords.size < 9) modalListPiercingSwords.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListPiercingSwords)
        gridViewPiercingSwords?.adapter = adapter
        gridViewPiercingSwords?.onItemClickListener
        expandListPiercingSwords?.setOnClickListener {
            if (gridViewPiercingSwords != null) expandList(gridViewPiercingSwords,icExpandIconPiercingSwords!!)
        }

        /////////////////////////////////////////////////////////////////////////AXES//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.dragonslayerscrescentaxe,R.drawable.boundhandaxe,R.drawable.handaxe,R.drawable.battleaxe,R.drawable.banditaxe,R.drawable.infantryaxe,
            R.drawable.gyrmaxe,R.drawable.butchersknife)
        weaponName = arrayListOf(getString(R.string.dragonslayers_crescent_axe),getString(R.string.bound_hand_axe),getString(R.string.hand_axe),getString(R.string.battle_axe),getString(R.string.bandit_axe),getString(R.string.infantry_axe),
            getString(R.string.gyrm_axe),getString(R.string.butchersk_nife))

        for (items in weaponName.indices) if (modalListAxes.size < 8) modalListAxes.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListAxes)
        gridViewAxes?.adapter = adapter
        gridViewAxes?.onItemClickListener
        expandListAxes?.setOnClickListener {
            if (gridViewAxes != null) expandList(gridViewAxes,icExpandIconAxes!!)
        }

        /////////////////////////////////////////////////////////////////////////GREAT AXES//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.greataxe,R.drawable.banditgreataxe,R.drawable.liongreataxe,R.drawable.giantstoneaxe,R.drawable.gyrmgreataxe,R.drawable.blackdragongreataxe,
            R.drawable.blackknightgreataxe,R.drawable.drakekeppersgreataxe,R.drawable.crescentaxe)
        weaponName = arrayListOf(getString(R.string.greataxe),getString(R.string.bandit_great_axe), getString(R.string.lion_greataxe),getString(R.string.giant_stone_axe),getString(R.string.gyrm_greataxe),getString(R.string.black_dragon_greataxe),
            getString(R.string.black_knight_greataxe),getString(R.string.drakekeppers_great_axe),getString(R.string.crescent_axe))

        for (items in weaponName.indices) if (modalListGreatAxes.size < 9) modalListGreatAxes.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListGreatAxes)
        gridViewGreatAxes?.adapter = adapter
        gridViewGreatAxes?.onItemClickListener
        expandListGreatAxes?.setOnClickListener {
            if (gridViewGreatAxes != null) expandList(gridViewGreatAxes,icExpandIconGreatAxes!!)
        }

        /////////////////////////////////////////////////////////////////////////HAMMERS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.homunculusmace,R.drawable.craftsmanshammer,R.drawable.mace,R.drawable.club,R.drawable.morningstar,R.drawable.reinforcedclub,R.drawable.maceoftheinsolent,
            R.drawable.handmaidsladle,R.drawable.blacksmithshammer,R.drawable.blackdragonwarpick,R.drawable.aldiahammer,R.drawable.barbedclub)
        weaponName = arrayListOf(getString(R.string.homunculus_mace),getString(R.string.craftsmans_hammer),getString(R.string.mace),getString(R.string.club),getString(R.string.morning_star),getString(R.string.reinforced_club),getString(R.string.mace_of_the_insolent),
            getString(R.string.handmaids_ladle),getString(R.string.blacksmiths_hammer),getString(R.string.black_dragon_warpick),getString(R.string.aldia_hammer),getString(R.string.barbed_club))

        for (items in weaponName.indices) if (modalListHammers.size < 12) modalListHammers.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListHammers)
        gridViewHammers?.adapter = adapter
        gridViewHammers?.onItemClickListener
        expandListHammers?.setOnClickListener {
            if (gridViewHammers != null) expandList(gridViewHammers,icExpandIconHammers!!)
        }

        /////////////////////////////////////////////////////////////////////////GREAT HAMMERS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.largeclub,R.drawable.greatclub,R.drawable.gyrmgreathammer,R.drawable.ironkinghammer,R.drawable.malformedshell,R.drawable.malformedskull,
            R.drawable.dragontooth,R.drawable.giantwarriorclub,R.drawable.demonsgreathammer,R.drawable.archdrakemace,R.drawable.oldknighthammer,R.drawable.drakekeepersgreathammer,
            R.drawable.sacredchimehammer,R.drawable.drakekeeperswarpick,R.drawable.pickaxe,R.drawable.sanctummace,R.drawable.smelterhammer)
        weaponName = arrayListOf(getString(R.string.large_club),getString(R.string.great_club),getString(R.string.gyrm_great_hammer),getString(R.string.iron_king_hammer),getString(R.string.malformed_shell),getString(R.string.malformed_skull),
            getString(R.string.dragon_tooth),getString(R.string.giant_warrior_club),getString(R.string.demons_great_hammer),getString(R.string.archdrake_mace),getString(R.string.old_knight_hammer),getString(R.string.drakekeepers_great_hammer),
            getString(R.string.sacred_chime_hammer),getString(R.string.drakekeepers_warpick),getString(R.string.pick_axe),getString(R.string.sanctum_mace),getString(R.string.smelter_hammer))

        for (items in weaponName.indices) if ( modalListGreatHammers.size < 17 ) modalListGreatHammers.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListGreatHammers)
        gridViewGreatHammers?.adapter = adapter
        gridViewGreatHammers?.onItemClickListener
        expandListGreatHammers?.setOnClickListener {
            if (gridViewGreatHammers != null) expandList(gridViewGreatHammers,icExpandIconGreatHammers!!)
        }

        /////////////////////////////////////////////////////////////////////////SPEARS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.wingedspear,R.drawable.partizan,R.drawable.spear,R.drawable.pike,R.drawable.stonesoldierspear,R.drawable.silverblackspear,R.drawable.heidespear,
            R.drawable.patesspear,R.drawable.channelerstrident,R.drawable.spitfirespear,R.drawable.dragonslayerspear,R.drawable.gargoylebident,R.drawable.pilgrimsspontoon,R.drawable.yorghsspear)
        weaponName = arrayListOf(getString(R.string.winged_spear),getString(R.string.partizan),getString(R.string.spear),getString(R.string.pike),getString(R.string.stone_soldier_spear),getString(R.string.silverblack_spear),getString(R.string.heide_spear),
            getString(R.string.pates_spear),getString(R.string.channelers_trident),getString(R.string.spitfire_spear),getString(R.string.dragonslayer_spear),getString(R.string.gargoyle_bident),getString(R.string.pilgrims_spontoon),getString(R.string.yorghs_spear))

        for (items in weaponName.indices) if (modalListSpears.size < 14) modalListSpears.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListSpears)
        gridViewSpears?.adapter = adapter
        gridViewSpears?.onItemClickListener
        expandListSpears?.setOnClickListener {
            if (gridViewSpears != null) expandList(gridViewSpears,icExpandIconSpears!!)
        }

        /////////////////////////////////////////////////////////////////////////HALBERD//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.dragonridershalberd,R.drawable.halberd,R.drawable.lucerne,R.drawable.scythe,R.drawable.mastodonhalberd,R.drawable.santiersspear,R.drawable.blueknightshalberd,
            R.drawable.oldknighthalberd,R.drawable.oldknightpike,R.drawable.syanshalberd,R.drawable.blackknighthalberd,R.drawable.roaringhalberd,R.drawable.helixhalberd,R.drawable.wrathfulaxe)
        weaponName = arrayListOf(getString(R.string.dragonriders_halberd),getString(R.string.halberd),getString(R.string.lucerne),getString(R.string.scythe),getString(R.string.mastodon_halberd),getString(R.string.santiers_spear),getString(R.string.blue_knights_halberd),
            getString(R.string.old_knight_halberd),getString(R.string.old_knight_pike),getString(R.string.syans_halberd),getString(R.string.black_knight_halberd),getString(R.string.roaring_halberd),getString(R.string.helix_halberd),getString(R.string.wrathful_axe))

        for (items in weaponName.indices) if (modalListHalberds.size < 14) modalListHalberds.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListHalberds)
        gridViewHalberds?.adapter = adapter
        gridViewHalberds?.onItemClickListener
        expandListHalberds?.setOnClickListener {
            if (gridViewHalberds != null) expandList(gridViewHalberds,icExpandIconHalberds!!)
        }

        /////////////////////////////////////////////////////////////////////////LANCES//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.heidelance,R.drawable.heidegreatlance,R.drawable.grandlance,R.drawable.chariotlance,R.drawable.rampartgolemlance)
        weaponName = arrayListOf(getString(R.string.heide_lance),getString(R.string.heide_great_lance),getString(R.string.grand_lance),getString(R.string.chariot_lance),getString(R.string.rampart_golem_lance))

        for (items in weaponName.indices) if (modalListLances.size < 5 ) modalListLances.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListLances)
        gridViewLances?.adapter = adapter
        gridViewLances?.onItemClickListener
        expandListLances?.setOnClickListener {
            if (gridViewLances != null) expandList(gridViewLances,icExpandIconLances!!)
        }

        /////////////////////////////////////////////////////////////////////////REAPERS//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.crescentsickle,R.drawable.greatscythe,R.drawable.silverblacksickle,R.drawable.greatmachete,R.drawable.fullmoonsickle,R.drawable.scytheofnahralmaframe,
            R.drawable.bonescythe,R.drawable.scytheofwant,R.drawable.scytheoftheforlorn)
        weaponName = arrayListOf(getString(R.string.crescent_sickle),getString(R.string.great_scythe),getString(R.string.silverblack_sickle),getString(R.string.great_machete),getString(R.string.full_moon_sickle),getString(R.string.scythe_of_nahr_alma),
            getString(R.string.bone_scythe),getString(R.string.scythe_of_want),getString(R.string.scythe_of_the_forlorn))

        for (items in weaponName.indices) if (modalListReapers.size < 9) modalListReapers.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListReapers)
        gridViewReapers?.adapter = adapter
        gridViewReapers?.onItemClickListener
        expandListReapers?.setOnClickListener {
            if (gridViewReapers != null) expandList(gridViewReapers,icExpandIconReapers!!)
        }

        /////////////////////////////////////////////////////////////////////////TWINBLADES//////////////////////////////////////////////////////////////////////
        weaponImage = intArrayOf(R.drawable.twinblade,R.drawable.stonetwinblade,R.drawable.dragonridertwinblade,R.drawable.redirontwinblade,R.drawable.curvedtwinblade,R.drawable.sorcererstwinblade,)
        weaponName = arrayListOf(getString(R.string.twinblade),getString(R.string.stone_twinblade),getString(R.string.dragonrider_twin_blade),getString(R.string.red_iron_twinblade),getString(R.string.curved_twinblade),getString(R.string.sorcerers_twinblade))

        for (items in weaponName.indices) if (modalListTwinblades.size < 6) modalListTwinblades.add(Modal(this.weaponName[items],weaponImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListTwinblades)
        gridViewTwinblades?.adapter = adapter
        gridViewTwinblades?.onItemClickListener
        expandListTwinblades?.setOnClickListener {
            if (gridViewTwinblades != null) expandList(gridViewTwinblades,icExpandIconTwinblades!!)
        }

        return root
    }

    private fun expandList(gridView: GridView, imageView: ImageView) {
        if (!gridView.isVisible) {
            gridView.isVisible = true
            imageView.setImageResource(R.drawable.ic_expand_less_dark)
        } else if (gridView.isVisible) {
            gridView.isVisible = false
            imageView.setImageResource(R.drawable.ic_expand_more_dark)
        }
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

    override fun clickedItem(itemsModalItems: Modal) {
        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }


}