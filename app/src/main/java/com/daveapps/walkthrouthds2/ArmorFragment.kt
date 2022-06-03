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


class ArmorFragment : Fragment(), ItemsAdapterItems.ClickListener {
    private var root: View? = null
    private var provider: String? = null

    private var armorName = arrayListOf("")
    private var armorImage = intArrayOf()

    private var modalListHead = ArrayList<Modal>()
    private var icExpandIconHead: ImageView? = null

    private var modalListChest = ArrayList<Modal>()
    private var icExpandIconChest: ImageView? = null

    private var modalListHands = ArrayList<Modal>()
    private var icExpandIconHands: ImageView? = null

    private var modalListLegs = ArrayList<Modal>()
    private var icExpandIconLegs: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.armor)
        root = inflater.inflate(R.layout.fragment_armor, container, false)
        provider = arguments?.getString("provider")
        

        val expandListHead = root?.findViewById<TextView>(R.id.tvExpandListHead)
        val gridViewHead = root?.findViewById<GridView>(R.id.gridViewHead)
        icExpandIconHead = root?.findViewById(R.id.ivExpandIconHead)

        val expandListChest = root?.findViewById<TextView>(R.id.tvExpandListChest)
        val gridViewChest = root?.findViewById<GridView>(R.id.gridViewChest)
        icExpandIconChest = root?.findViewById(R.id.ivExpandIconChest)

        val expandListHands = root?.findViewById<TextView>(R.id.tvExpandListHands)
        val gridViewHands = root?.findViewById<GridView>(R.id.gridViewHands)
        icExpandIconHands = root?.findViewById(R.id.ivExpandIconHands)

        val expandListLegs = root?.findViewById<TextView>(R.id.tvExpandListLegs)
        val gridViewLegs = root?.findViewById<GridView>(R.id.gridViewLegs)
        icExpandIconLegs = root?.findViewById(R.id.ivExpandIconLegs)

        ////////////////////////////////////////////HEAD 120

        armorImage = intArrayOf(R.drawable.alonnecaptainhelm,R.drawable.alonneknighthelm,R.drawable.alonneshelm,R.drawable.alvahelm,R.drawable.archdrakehelm,R.drawable.bellkeeperhelmet,
            R.drawable.benhartsknighthelm,R.drawable.blackdragonhelm,R.drawable.blackhollowmagehood,R.drawable.blackhood,R.drawable.blackwitchdominomask,R.drawable.blackwitchhat, R.drawable.blackwitchveil,
            R.drawable.bonecrown,R.drawable.brigandhood,R.drawable.caleshelm,R.drawable.catarinahelm,R.drawable.chaoshood,R.drawable.charredloycehelm,R.drawable.creightonssteelmask,R.drawable.crownoftheivoryking,
            R.drawable.crownoftheoldironking,R.drawable.crownofthesunkenking,R.drawable.darkmask,R.drawable.desertsorceresshood,R.drawable.dingyhood,R.drawable.dragonacolytemask,R.drawable.dragonsagehood,
            R.drawable.dragonriderhelm,R.drawable.drakebloodhelm,R.drawable.drakekeeperhelm,R.drawable.drangleichelm,R.drawable.durgoshat,R.drawable.eliteknighthelm,R.drawable.executionerhelm,
            R.drawable.falconerhelm,R.drawable.faraamhelm,R.drawable.fumesorcerermask,R.drawable.gravewardenmask,R.drawable.gyrmhelm,R.drawable.gyrmwarriorgreathelm,R.drawable.gyrmwarriorhelm, R.drawable.havelshelm,
            R.drawable.heideknightgreathelm,R.drawable.heideknightironmask,R.drawable.helmofaurous,R.drawable.helmofauroustransparent,R.drawable.hexershood,R.drawable.hollowinfantryhelm,R.drawable.hollowskin,
            R.drawable.hollowsoldierhelm,R.drawable.hoodoftheforlorn,R.drawable.huntershat,R.drawable.imperioushelm,R.drawable.importedhood,R.drawable.infantryhelm,R.drawable.insolenthelm,R.drawable.ironcladhelm,
            R.drawable.ivorykinghelm,R.drawable.jesterscap,R.drawable.kingscrown,R.drawable.knighthelm,R.drawable.leydiablackhood,R.drawable.leydiawhitehood,R.drawable.lionwarriorhelm,R.drawable.lookingglassmask,
            R.drawable.loycehelm,R.drawable.lucatielsmask,R.drawable.madwarriormask,R.drawable.manikinmask,R.drawable.maskofjudgment,R.drawable.mastodonhelm,R.drawable.minotaurhelm,R.drawable.mirrahhat,
            R.drawable.monasteryheadcloth,R.drawable.moonbutterflyhat,R.drawable.moonhat,R.drawable.nahralmahood,R.drawable.northwarderhood,R.drawable.oldbellhelm,R.drawable.oldironcladhelm,R.drawable.oldknighthelm,
            R.drawable.pateshelm,R.drawable.peasanthat,R.drawable.penalmask,R.drawable.pharrosmask,R.drawable.priestessheadpiece,R.drawable.prisonershood,R.drawable.raimeshelm,R.drawable.rampartgolemhelm,
            R.drawable.roguehood,R.drawable.royalsoldierhelmet,R.drawable.royalswordsmanhelm,R.drawable.ruinhelm,R.drawable.rustedmastodonhelm,R.drawable.saintshood,R.drawable.sanctumknighthelm,
            R.drawable.sanctumpriestesstiara,R.drawable.shadowmask,R.drawable.smelterdemonhelm,R.drawable.spikedbandithelm,R.drawable.standardhelm,R.drawable.steelhelm,R.drawable.syanshelm,R.drawable.symbolofavarice,
            R.drawable.targrayshelm,R.drawable.tatteredclothhood,R.drawable.thiefmask,R.drawable.thronedefenderhelm,R.drawable.thronewatcherhelm,R.drawable.travelingmerchanthat,R.drawable.tseldoracap,
            R.drawable.varangianhelm,R.drawable.velstadtshelm,R.drawable.vengarlshelm,R.drawable.wandererhood,R.drawable.warlockmask,R.drawable.whitehollowmagehood,R.drawable.whitepriestheadpiece,R.drawable.xanthouscrown,)

        armorName = arrayListOf(getString(R.string.alonne_captain_helm),getString(R.string.alonne_knight_helm),getString(R.string.alonnes_helm),getString(R.string.alva_helm),getString(R.string.archdrake_helm),getString(R.string.bell_keeper_helmet),
            getString(R.string.benharts_knight_helm),getString(R.string.black_dragon_helm),getString(R.string.black_hollow_mage_hood),getString(R.string.black_hood),getString(R.string.black_witch_domino_mask),getString(R.string.black_witch_hat),getString(R.string.black_witch_veil),
            getString(R.string.bone_crown),getString(R.string.brigand_hood),getString(R.string.cales_helm),getString(R.string.catarina_helm),getString(R.string.chaos_hood),getString(R.string.charred_loyce_helm),getString(R.string.creightons_steel_mask),getString(R.string.crown_of_the_ivory_king),
            getString(R.string.crown_of_the_old_iron_king),getString(R.string.crown_of_the_sunken_king),getString(R.string.dark_mask),getString(R.string.desert_sorceress_hood),getString(R.string.dingy_hood),getString(R.string.dragon_acolyte_mask),getString(R.string.dragon_sage_hood),
            getString(R.string.dragonrider_helm),getString(R.string.drakeblood_helm),getString(R.string.drakekeeper_helm),getString(R.string.drangleic_helm),getString(R.string.durgos_hat),getString(R.string.elite_knight_helm),getString(R.string.executioner_helm),
            getString(R.string.falconer_helm),getString(R.string.faraam_helm),getString(R.string.fume_sorcerer_mask),getString(R.string.grave_warden_mask),getString(R.string.gyrm_helm),getString(R.string.gyrm_warrior_greathelm),getString(R.string.gyrm_warrior_helm),getString(R.string.havels_helm),
            getString(R.string.heide_knight_greathelm),getString(R.string.heide_knight_iron_mask),getString(R.string.helm_of_aurous),getString(R.string.helm_of_aurous_transparent),getString(R.string.hexers_hood),getString(R.string.hollow_infantry_helm),getString(R.string.hollow_skin),
            getString(R.string.hollow_soldier_helm),getString(R.string.hood_of_the_forlorn),getString(R.string.hunters_hat),getString(R.string.imperious_helm),getString(R.string.imported_hood),getString(R.string.infantry_helm),getString(R.string.insolent_helm),getString(R.string.ironclad_helm),
            getString(R.string.ivory_king_helm),getString(R.string.jesters_cap),getString(R.string.kings_crown),getString(R.string.knight_helm),getString(R.string.leydia_black_hood),getString(R.string.leydia_white_hood),getString(R.string.lion_warrior_helm),getString(R.string.looking_glass_mask),
            getString(R.string.loyce_helm),getString(R.string.lucatiels_mask),getString(R.string.mad_warrior_mask),getString(R.string.manikin_mask),getString(R.string.mask_of_judgment),getString(R.string.mastodon_helm),getString(R.string.minotaur_helm),getString(R.string.mirrah_hat),
            getString(R.string.monastery_headcloth),getString(R.string.moon_butterfly_hat),getString(R.string.moon_hat),getString(R.string.nahr_alma_hood),getString(R.string.northwarder_hood),getString(R.string.old_bell_helm),getString(R.string.old_ironclad_helm),getString(R.string.old_knight_helm),
            getString(R.string.pates_helm),getString(R.string.peasant_hat),getString(R.string.penal_mask),getString(R.string.pharros_mask),getString(R.string.priestess_headpiece),getString(R.string.prisoners_hood),getString(R.string.raimes_helm),getString(R.string.rampart_golem_helm),
            getString(R.string.rogue_hood),getString(R.string.royal_soldier_helmet),getString(R.string.royal_swordsman_helm),getString(R.string.ruin_helm),getString(R.string.rusted_mastodon_helm),getString(R.string.saints_hood),getString(R.string.sanctum_knight_helm),
            getString(R.string.sanctum_priestess_tiara),getString(R.string.shadow_mask),getString(R.string.smelter_demon_helm),getString(R.string.spiked_bandit_helm),getString(R.string.standard_helm),getString(R.string.steel_helm),getString(R.string.syans_helm),getString(R.string.symbol_of_avarice),
            getString(R.string.targrays_helm),getString(R.string.tattered_cloth_hood),getString(R.string.thief_mask),getString(R.string.throne_defender_helm),getString(R.string.throne_watcher_helm),getString(R.string.traveling_merchant_hat),getString(R.string.tseldora_cap),
            getString(R.string.varangian_helm),getString(R.string.velstadts_helm),getString(R.string.vengarls_helm),getString(R.string.wanderer_hood),getString(R.string.warlock_mask),getString(R.string.white_hollow_mage_hood),getString(R.string.white_priest_headpiece),getString(R.string.xanthous_crown))


        for(items in armorName.indices) if (modalListHead.size < 120) modalListHead.add(Modal(this.armorName[items],armorImage[items]))

        var adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListHead)
        gridViewHead?.adapter = adapter
        gridViewHead?.onItemClickListener
        expandListHead?.setOnClickListener {
            if (gridViewHead != null) expandList(gridViewHead,icExpandIconHead!!)
        }

        ///////////////////////////////////////////CHEST

        armorImage = intArrayOf(R.drawable.agdaynesblackrobe,R.drawable.alonnecaptainarmor,R.drawable.alonneknightarmor,R.drawable.alonnesarmor,R.drawable.alvaarmor,R.drawable.archdrakerobes,R.drawable.armorofaurous,
            R.drawable.armorofauroustransparent,R.drawable.astrologistsrobe,R.drawable.banditarmor,R.drawable.bellkeeperbellyband,R.drawable.benhartsarmor,R.drawable.blackdragonarmor,R.drawable.blackhollowmagerobe,
            R.drawable.blackleatherarmor,R.drawable.blackrobes,R.drawable.blackwitchrobe,R.drawable.bonekingrobe,R.drawable.brigandarmor,R.drawable.calesleatherarmor,R.drawable.catarinaarmor,R.drawable.chaosrobe,
            R.drawable.charredloycearmor,R.drawable.creightonschainmail,R.drawable.darkarmor,R.drawable.desertsorceresstop,R.drawable.dingyrobe,R.drawable.dragonacolyterobe,R.drawable.dragonriderarmor,
            R.drawable.drakebloodarmor,R.drawable.drakekeeperarmor,R.drawable.drangleicmail,R.drawable.eliteknightarmor,R.drawable.executionerarmor,R.drawable.falconerarmor,R.drawable.faraamarmor,
            R.drawable.armoroftheforlorn,R.drawable.fumesorcererrobes,R.drawable.gravewardentop,R.drawable.gyrmarmor,R.drawable.gyrmwarriorarmor,R.drawable.hardleatherarmor,R.drawable.havelsarmor,
            R.drawable.heideknightchainmail,R.drawable.hexersrobes,R.drawable.hollowinfantryarmor,R.drawable.hollowsoldierarmor,R.drawable.imperiousarmor,R.drawable.importedtunic,R.drawable.infantryarmor,
            R.drawable.insolentarmor,R.drawable.ironcladarmor,R.drawable.ivorykingarmor,R.drawable.jestersrobes,R.drawable.kingsarmor,R.drawable.knightarmor,R.drawable.leatherarmor,R.drawable.leydiablackrobe,
            R.drawable.leydiawhiterobe,R.drawable.lionmagerobe,R.drawable.lionwarriorcape,R.drawable.llewellynarmor,R.drawable.lookingglassarmor,R.drawable.loycearmor,R.drawable.lucatielsvest,R.drawable.madwarriorarmor,
            R.drawable.manikintop,R.drawable.mastodonarmor,R.drawable.monasterylongshirt,R.drawable.moonbutterflywings,R.drawable.nahralmarobes,R.drawable.northwarderrobe,R.drawable.oldironcladarmor,
            R.drawable.oldknightarmor,R.drawable.patesarmor,R.drawable.peasantattire,R.drawable.penalstraightjacket,R.drawable.priestessrobe,R.drawable.prisonerstattersleft,R.drawable.prisonerstattersright,
            R.drawable.raimesarmor,R.drawable.rampartgolemarmor,R.drawable.redlionwarriorcape,R.drawable.retainerrobe,R.drawable.robeofjudgment,R.drawable.roguearmor,R.drawable.royalsoldierarmor,
            R.drawable.royalswordsmanarmor,R.drawable.ruinarmor,R.drawable.rustedmastodonarmor,R.drawable.saintsdress,R.drawable.sanctumknightarmor,R.drawable.shadowtop,R.drawable.singersdress,R.drawable.smelterdemonarmor,
            R.drawable.steelarmor,R.drawable.syansarmor,R.drawable.targraysarmor,R.drawable.tatteredclothrobe,R.drawable.thronedefenderarmor,R.drawable.thronewatcherarmor,R.drawable.travelingmerchantcoat,
            R.drawable.tseldorarobe,R.drawable.varangianarmor,R.drawable.velstadtsarmor,R.drawable.vengarlsarmor,R.drawable.wanderercoat,R.drawable.whitehollowmagerobe,R.drawable.whitepriestrobe,R.drawable.xanthousovercoat,

            )
        armorName = arrayListOf(getString(R.string.agdaynes_black_robe),getString(R.string.alonne_captain_armor),getString(R.string.alonne_knight_armor),getString(R.string.alonnes_armor),getString(R.string.alva_armor),getString(R.string.archdrake_robes),getString(R.string.armor_of_aurous),
            getString(R.string.armor_of_aurous_transparent),getString(R.string.astrologists_robe),getString(R.string.bandit_armor),getString(R.string.bell_keeper_bellyband),getString(R.string.benharts_armor),getString(R.string.black_dragon_armor),getString(R.string.black_hollow_mage_robe),
            getString(R.string.black_leather_armor),getString(R.string.black_robes),getString(R.string.black_witch_robe),getString(R.string.bone_king_robe),getString(R.string.brigand_armor),getString(R.string.cales_leather_armor),getString(R.string.catarina_armor),getString(R.string.chaos_robe),
            getString(R.string.charred_loyce_armor),getString(R.string.creightons_chainmail),getString(R.string.dark_armor),getString(R.string.desert_sorceress_top),getString(R.string.dingy_robe),getString(R.string.dragon_acolyte_robe),getString(R.string.dragonrider_armor),
            getString(R.string.drakeblood_armor),getString(R.string.drakekeeper_armor),getString(R.string.drangleic_mail),getString(R.string.elite_knight_armor),getString(R.string.executioner_armor),getString(R.string.falconer_armor),getString(R.string.faraam_armor),
            getString(R.string.armor_of_the_forlorn),getString(R.string.fume_sorcerer_robes),getString(R.string.grave_warden_top),getString(R.string.gyrm_armor),getString(R.string.gyrm_warrior_armor),getString(R.string.hard_leather_armor),getString(R.string.havels_armor),
            getString(R.string.heide_knight_chainmail),getString(R.string.hexers_robes),getString(R.string.hollow_infantry_armor),getString(R.string.hollow_soldier_armor),getString(R.string.imperious_armor),getString(R.string.imported_tunic),getString(R.string.infantry_armor),
            getString(R.string.insolent_armor),getString(R.string.ironclad_armor),getString(R.string.ivory_king_armor),getString(R.string.jesters_robes),getString(R.string.kings_armor),getString(R.string.knight_armor),getString(R.string.leather_armor),getString(R.string.leydia_black_robe),
            getString(R.string.leydia_white_robe),getString(R.string.lion_mage_robe),getString(R.string.lion_warrior_cape),getString(R.string.llewellyn_armor),getString(R.string.looking_glass_armor),getString(R.string.loyce_armor),getString(R.string.lucatiels_vest),getString(R.string.mad_warrior_armor),
            getString(R.string.manikin_top),getString(R.string.mastodon_armor),getString(R.string.monastery_longshirt),getString(R.string.moon_butterfly_wings),getString(R.string.nahr_alma_robes),getString(R.string.northwarder_robe),getString(R.string.old_ironclad_armor),
            getString(R.string.old_knight_armor),getString(R.string.pates_armor),getString(R.string.peasant_attire),getString(R.string.penal_straight_jacket),getString(R.string.priestess_robe),getString(R.string.prisoners_tatters_left),getString(R.string.prisoners_tatters_right),
            getString(R.string.raimes_armor),getString(R.string.rampart_golem_armor),getString(R.string.red_lion_warrior_cape),getString(R.string.retainer_robe),getString(R.string.robe_of_judgment),getString(R.string.rogue_armor),getString(R.string.royal_soldier_armor),
            getString(R.string.royal_swordsman_armor),getString(R.string.ruin_armor),getString(R.string.rusted_mastodon_armor),getString(R.string.saints_dress),getString(R.string.sanctum_knight_armor),getString(R.string.shadow_top),getString(R.string.singers_dress),getString(R.string.smelter_demon_armor),
            getString(R.string.steel_armor),getString(R.string.syans_armor),getString(R.string.targrays_armor),getString(R.string.tattered_cloth_robe),getString(R.string.throne_defender_armor),getString(R.string.throne_watcher_armor),getString(R.string.traveling_merchant_coat),
            getString(R.string.tseldora_robe),getString(R.string.varangian_armor),getString(R.string.velstadts_armor),getString(R.string.vengarls_armor),getString(R.string.wanderer_coat),getString(R.string.white_hollow_mage_robe),getString(R.string.white_priest_robe),getString(R.string.xanthous_overcoat))

        for(items in armorName.indices) if (modalListChest.size < 110) modalListChest.add(Modal(this.armorName[items],armorImage[items]))

        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListChest)
        gridViewChest?.adapter = adapter
        gridViewChest?.onItemClickListener
        expandListChest?.setOnClickListener {
            if (gridViewChest != null) expandList(gridViewChest,icExpandIconChest!!)
        }

        ///////////////////////////////////////////HANDS

        armorImage = intArrayOf(R.drawable.agdaynescuffs,R.drawable.alonneknightgauntlets,R.drawable.alonnesgauntlets,R.drawable.alvagauntlets,R.drawable.archdrakegloves,R.drawable.astrologistsgauntlets,
            R.drawable.banditgauntlets,R.drawable.bellkeepercuffs,R.drawable.benhartsgauntlets,R.drawable.blackdragongauntlets,R.drawable.blackgloves,R.drawable.blackleathergloves,R.drawable.blackwitchgloves,
            R.drawable.bonekingcuffs,R.drawable.brigandgauntlets,R.drawable.catarinagauntlets,R.drawable.chaosgloves,R.drawable.charredloycegauntlets,R.drawable.creightonschaingloves,R.drawable.darkgauntlets,
            R.drawable.desertsorceressgloves,R.drawable.dingycuffs,R.drawable.dragonacolytegloves,R.drawable.dragonridergauntlets,R.drawable.drakebloodgauntlets,R.drawable.drakekeepergauntlets,R.drawable.drangleicgauntlets,
            R.drawable.eliteknightgloves,R.drawable.engravedgauntlets,R.drawable.executionergauntlets,R.drawable.falconergloves,R.drawable.faraamgauntlets,R.drawable.fumesorcerergloves,R.drawable.gauntletsofaurous,
            R.drawable.gauntletsofauroustransparent,R.drawable.gauntletsoftheforlorn,R.drawable.gravewardencuffs,R.drawable.gyrmgloves,R.drawable.gyrmwarriorgloves,R.drawable.hardleathergauntlets,R.drawable.havelsgauntlets,
            R.drawable.heideknightgauntlets,R.drawable.hexersgloves,R.drawable.hollowinfantrygloves,R.drawable.hollowsoldiergauntlets,R.drawable.imperiousgloves,R.drawable.importedmanchettes,R.drawable.infantrygloves,
            R.drawable.insolentgloves,R.drawable.ironcladgauntlets,R.drawable.ivorykinggauntlets,R.drawable.jestersgloves,R.drawable.kingsgauntlets,R.drawable.knightgauntlets,R.drawable.leathergloves,R.drawable.leydiagauntlets,
            R.drawable.lionmagecuffs,R.drawable.lionwarriorcuffs,R.drawable.llewellyngloves,R.drawable.lookingglassgauntlets,R.drawable.loycegauntlets,R.drawable.lucatielsgloves,R.drawable.madwarriorgauntlets,
            R.drawable.manchettesofjudgement,R.drawable.manikingloves,R.drawable.mastodongauntlets,R.drawable.monasterylonggloves,R.drawable.moonbutterflycuffs,R.drawable.northwardermanchettes,R.drawable.oldironcladgauntlets,
            R.drawable.oldknightgauntlets,R.drawable.patesgloves,R.drawable.peasantlonggloves,R.drawable.penalhandcuffs,R.drawable.priestessgloves,R.drawable.prisonersgloves,R.drawable.raimesgauntlets,R.drawable.rampartgolemgauntlets,
            R.drawable.roguegauntlets,R.drawable.royalsoldiergauntlets,R.drawable.royalswordsmangloves,R.drawable.ruingauntlets,R.drawable.rustedmastodongauntlets,R.drawable.saintslonggloves,R.drawable.sanctumknightgauntlets,
            R.drawable.sanctumsoldiergauntlets,R.drawable.shadowgauntlets,R.drawable.smelterdemongauntlets,R.drawable.steelgauntlets,R.drawable.syansgauntlets,R.drawable.targraysmanifers,R.drawable.tatteredclothmanchettes,
            R.drawable.thronedefendergauntlets,R.drawable.thronewatchergauntlets,R.drawable.travelingmerchantgloves,R.drawable.tseldoramanchettes,R.drawable.varangiancuffs,R.drawable.velstadtsgauntlets,
            R.drawable.vengarlsgloves,R.drawable.wanderermanchettes,R.drawable.whitepriestgloves,R.drawable.xanthousgloves)

        armorName = arrayListOf(getString(R.string.agdaynes_cuffs),getString(R.string.alonne_knight_gauntlets),getString(R.string.alonnes_gauntlets),getString(R.string.alva_gauntlets),getString(R.string.archdrake_gloves),getString(R.string.astrologists_gauntlets),
            getString(R.string.bandit_gauntlets),getString(R.string.bell_keeper_cuffs),getString(R.string.benharts_gauntlets),getString(R.string.black_dragon_gauntlets),getString(R.string.black_gloves),getString(R.string.black_leather_gloves),getString(R.string.black_witch_gloves),
            getString(R.string.bone_king_cuffs),getString(R.string.brigand_gauntlets),getString(R.string.catarina_gauntlets),getString(R.string.chaos_gloves),getString(R.string.charred_loyce_gauntlets),getString(R.string.creightons_chain_gloves),getString(R.string.dark_gauntlets),
            getString(R.string.desert_sorceress_gloves),getString(R.string.dingy_cuffs),getString(R.string.dragon_acolyte_gloves),getString(R.string.dragonrider_gauntlets),getString(R.string.drakeblood_gauntlets),getString(R.string.drakekeeper_gauntlets),getString(R.string.drangleic_gauntlets),
            getString(R.string.elite_knight_gloves),getString(R.string.engraved_gauntlets),getString(R.string.executioner_gauntlets),getString(R.string.falconer_gloves),getString(R.string.faraam_gauntlets),getString(R.string.fume_sorcerer_gloves),getString(R.string.gauntlets_of_aurous),
            getString(R.string.gauntlets_of_aurous_transparent),getString(R.string.gauntlets_of_the_forlorn),getString(R.string.grave_warden_cuffs),getString(R.string.gyrm_gloves),getString(R.string.gyrm_warrior_gloves),getString(R.string.hard_leather_gauntlets),getString(R.string.havels_gauntlets),
            getString(R.string.heide_knight_gauntlets),getString(R.string.hexers_gloves),getString(R.string.hollow_infantry_gloves),getString(R.string.hollow_soldier_gauntlets),getString(R.string.imperious_gloves),getString(R.string.imported_manchettes),getString(R.string.infantry_gloves),
            getString(R.string.insolent_gloves),getString(R.string.ironclad_gauntlets),getString(R.string.ivory_king_gauntlets),getString(R.string.jesters_gloves),getString(R.string.kings_gauntlets),getString(R.string.knight_gauntlets),getString(R.string.leather_gloves),getString(R.string.leydia_gauntlets),
            getString(R.string.lion_mage_cuffs),getString(R.string.lion_warrior_cuffs),getString(R.string.llewellyn_gloves),getString(R.string.looking_glass_gauntlets),getString(R.string.loyce_gauntlets),getString(R.string.lucatiels_gloves),getString(R.string.mad_warrior_gauntlets),
            getString(R.string.manchettes_of_judgement),getString(R.string.manikin_gloves),getString(R.string.mastodon_gauntlets),getString(R.string.monastery_long_gloves),getString(R.string.moon_butterfly_cuffs),getString(R.string.northwarder_manchettes),getString(R.string.old_ironclad_gauntlets),
            getString(R.string.old_knight_gauntlets),getString(R.string.pates_gloves),getString(R.string.peasant_long_gloves),getString(R.string.penal_handcuffs),getString(R.string.priestess_gloves),getString(R.string.prisoners_gloves),getString(R.string.raimes_gauntlets),getString(R.string.rampart_golem_gauntlets),
            getString(R.string.rogue_gauntlets),getString(R.string.royal_soldier_gauntlets),getString(R.string.royal_swordsman_gloves),getString(R.string.ruin_gauntlets),getString(R.string.rusted_mastodon_gauntlets),getString(R.string.saints_long_gloves),getString(R.string.sanctum_knight_gauntlets),
            getString(R.string.sanctum_soldier_gauntlets),getString(R.string.shadow_gauntlets),getString(R.string.smelter_demon_gauntlets),getString(R.string.steel_gauntlets),getString(R.string.syans_gauntlets),getString(R.string.targrays_manifers),getString(R.string.tattered_cloth_manchettes),
            getString(R.string.throne_defender_gauntlets),getString(R.string.throne_watcher_gauntlets),getString(R.string.traveling_merchant_gloves),getString(R.string.tseldora_manchettes),getString(R.string.varangian_cuffs),getString(R.string.velstadts_gauntlets),
            getString(R.string.vengarls_gloves),getString(R.string.wanderer_manchettes),getString(R.string.white_priest_gloves),getString(R.string.xanthous_gloves))


        for(items in armorName.indices) if (modalListHands.size < 102) modalListHands.add(Modal(this.armorName[items],armorImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListHands)
        gridViewHands?.adapter = adapter
        gridViewHands?.onItemClickListener
        expandListHands?.setOnClickListener {
            if (gridViewHands != null) expandList(gridViewHands,icExpandIconHands!!)
        }

        ///////////////////////////////////////////LEGS

        armorImage = intArrayOf(R.drawable.agdayneskilt,R.drawable.alonneknightleggings,R.drawable.alonnesleggings,R.drawable.alvaleggings,R.drawable.archdrakeboots,R.drawable.astrologistsbottoms,
            R.drawable.banditboots,R.drawable.bellkeepertrousers,R.drawable.benhartsboots,R.drawable.blackboots,R.drawable.blackdragonleggings,R.drawable.blackleatherboots,R.drawable.blackwitchtrousers,
            R.drawable.bloodstainedskirt,R.drawable.bonekingskirt,R.drawable.brigandtrousers,R.drawable.calesshoes,R.drawable.catarinaleggings,R.drawable.chaosboots,R.drawable.charredloyceleggings,
            R.drawable.creightonschainleggings,R.drawable.darkleggings,R.drawable.desertsorceressskirt,R.drawable.dragonacolyteboots,R.drawable.dragonriderleggings,R.drawable.drakebloodleggings,
            R.drawable.drakekeeperboots,R.drawable.drangleicleggings,R.drawable.eliteknightleggings,R.drawable.executionerleggings,R.drawable.falconerboots,R.drawable.faraamboots,R.drawable.flowerskirt,
            R.drawable.flyingfelinebootsframe,R.drawable.fumesorcererboots,R.drawable.gravewardenbottoms,R.drawable.gyrmboots,R.drawable.gyrmwarriorboots,R.drawable.hardleatherboots,R.drawable.havelsleggings,
            R.drawable.heavyboots,R.drawable.heideknightleggings,R.drawable.hexersboots,R.drawable.hollowinfantryboots,R.drawable.hollowsoldierleggings,R.drawable.imperiousleggings,R.drawable.importedtrousers,
            R.drawable.infantryboots,R.drawable.insolentboots,R.drawable.ironcladleggings,R.drawable.ivorykingleggings,R.drawable.jesterstights,R.drawable.kingsleggings,R.drawable.knightleggings,
            R.drawable.leatherboots,R.drawable.leggingsofaurous,R.drawable.leggingsofauroustransparent,R.drawable.leggingsoftheforlorn,R.drawable.lionmageskirt,R.drawable.lionwarriorskirt,
            R.drawable.llewellynshoes,R.drawable.lookingglassleggings,R.drawable.loyceleggings,R.drawable.lucatielstrousers,R.drawable.madwarriorleggings,R.drawable.manikinboots,R.drawable.mastodonleggings,
            R.drawable.monasteryskirt,R.drawable.moonbutterflyskirt,R.drawable.northwardertrousers,R.drawable.oldironcladleggings,R.drawable.oldknightleggings,R.drawable.patestrousers,R.drawable.peasanttrousers,
            R.drawable.penalskirt,R.drawable.priestessskirt,R.drawable.prisonerswaistcloth,R.drawable.raimesleggings,R.drawable.rampartgolemleggings,R.drawable.rogueleggings,R.drawable.royalsoldierleggings,
            R.drawable.royalswordsmanleggings,R.drawable.ruinleggings,R.drawable.rustedmastodonleggings,R.drawable.saintstrousers,R.drawable.sanctumknightleggings,R.drawable.shadowleggings,
            R.drawable.smelterdemonleggings,R.drawable.steelleggings,R.drawable.syansleggings,R.drawable.targraysleggings,R.drawable.thronedefenderleggings,R.drawable.thronewatcherleggings,
            R.drawable.tightsofjudgment,R.drawable.travelingmerchantboots,R.drawable.tseldoratrousers,R.drawable.varangianleggings,R.drawable.velstadtsleggings,R.drawable.vengarlsboots,R.drawable.wandererboots,
            R.drawable.whitepriestskirt,R.drawable.xanthouswaistcloth)
        armorName = arrayListOf(getString(R.string.agdaynes_kilt),getString(R.string.alonne_knight_leggings),getString(R.string.alonnes_leggings),getString(R.string.alva_leggings),getString(R.string.archdrake_boots),getString(R.string.astrologists_bottoms),
            getString(R.string.bandit_boots),getString(R.string.bell_keeper_trousers),getString(R.string.benharts_boots),getString(R.string.black_boots),getString(R.string.black_dragon_leggings),getString(R.string.black_leather_boots),getString(R.string.black_witch_trousers),
            getString(R.string.blood_stained_skirt),getString(R.string.bone_king_skirt),getString(R.string.brigand_trousers),getString(R.string.cales_shoes),getString(R.string.catarina_leggings),getString(R.string.chaos_boots),getString(R.string.charred_loyce_leggings),
            getString(R.string.creightons_chain_leggins),getString(R.string.dark_leggings),getString(R.string.desert_sorceress_skirt),getString(R.string.dragon_acolyte_boots),getString(R.string.dragonrider_leggings),getString(R.string.drakeblood_leggings),
            getString(R.string.drakekeeper_boots),getString(R.string.drangleic_leggings),getString(R.string.elite_knight_leggings),getString(R.string.executioner_leggings),getString(R.string.falconer_boots),getString(R.string.faraam_boots),getString(R.string.flower_skirt),
            getString(R.string.flying_feline_boots),getString(R.string.fume_sorcerer_boots),getString(R.string.grave_warden_bottoms),getString(R.string.gyrm_boots),getString(R.string.gyrm_warrior_boots),getString(R.string.hard_leather_boots),getString(R.string.havels_leggings),
            getString(R.string.heavy_boots),getString(R.string.heide_knight_leggings),getString(R.string.hexers_boots),getString(R.string.hollow_infantry_boots),getString(R.string.hollow_soldier_leggings),getString(R.string.imperious_leggings),getString(R.string.imported_trousers),
            getString(R.string.infantry_boots),getString(R.string.insolent_boots),getString(R.string.ironclad_leggings),getString(R.string.ivory_king_leggings),getString(R.string.jesters_tights),getString(R.string.kings_leggings),getString(R.string.knight_leggings),
            getString(R.string.leather_boots),getString(R.string.leggings_of_aurous),getString(R.string.leggings_of_aurous_transparent),getString(R.string.leggings_of_the_forlorn),getString(R.string.lion_mage_skirt),getString(R.string.lion_warrior_skirt),
            getString(R.string.llewellyn_shoes),getString(R.string.looking_glass_leggings),getString(R.string.loyce_leggings),getString(R.string.lucatiels_trousers),getString(R.string.mad_warrior_leggings),getString(R.string.manikin_boots),getString(R.string.mastodon_leggings),
            getString(R.string.monastery_skirt),getString(R.string.moon_butterfly_skirt),getString(R.string.northwarder_trousers),getString(R.string.old_ironclad_leggings),getString(R.string.old_knight_leggings),getString(R.string.pates_trousers),getString(R.string.peasant_trousers),
            getString(R.string.penal_skirt),getString(R.string.priestess_skirt),getString(R.string.prisoners_waistcloth),getString(R.string.raimes_leggings),getString(R.string.rampart_golem_leggings),getString(R.string.rogue_leggings),getString(R.string.royal_soldier_leggings),
            getString(R.string.royal_swordsman_leggings),getString(R.string.ruin_leggings),getString(R.string.rusted_mastodon_leggings),getString(R.string.saints_trousers),getString(R.string.sanctum_knight_leggings),getString(R.string.shadow_leggings),
            getString(R.string.smelter_demon_leggings),getString(R.string.steel_leggings),getString(R.string.syans_leggings),getString(R.string.targrays_leggings),getString(R.string.throne_defender_leggings),getString(R.string.throne_watcher_leggings),
            getString(R.string.tights_of_judgment),getString(R.string.traveling_merchant_boots),getString(R.string.tseldora_trousers),getString(R.string.varangian_leggings),getString(R.string.velstadts_leggings),getString(R.string.vengarls_boots),getString(R.string.wanderer_boots),
            getString(R.string.white_priest_skirt),getString(R.string.xanthous_waistcloth))

        for(items in armorName.indices) if (modalListLegs.size < 102 ) modalListLegs.add(Modal(this.armorName[items],armorImage[items]))
        //Toast.makeText(this.requireContext(),modalListLegs.size.toString(),Toast.LENGTH_LONG).show()
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListLegs)
        gridViewLegs?.adapter = adapter
        gridViewLegs?.onItemClickListener
        expandListLegs?.setOnClickListener {
            if (gridViewLegs != null) expandList(gridViewLegs,icExpandIconLegs!!)
        }

        return root

    }

    private fun expandList(gridView: GridView,imageView: ImageView){
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
        val name = itemsModalItems.item.toString()
        if (!SetDataDialog(requireContext(),name).setDataDialog()){

            SetDialogData(requireContext(),name).setDialogData()
        }
    }


}