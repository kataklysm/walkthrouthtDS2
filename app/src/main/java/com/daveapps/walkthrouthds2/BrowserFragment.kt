package com.daveapps.walkthrouthds2

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.daveapps.walkthrouthds2.databinding.FragmentBrowserBinding


class BrowserFragment : Fragment(), ItemsAdapterLocations.ClickListener,ItemsAdapterBosses.ClickListener,ItemsAdapterItems.ClickListener,ItemsAdapterCovenants.ClickListener{
    private var _binding: FragmentBrowserBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: Communicator

    private var itemsAdapterLocations: ItemsAdapterLocations? = null
    private val itemModalListLocations = ArrayList<ItemsModalLocations>()
    private var itemsAdapterBosses: ItemsAdapterBosses? = null
    private val itemModalListBosses = ArrayList<ItemsModalBosses>()
    private var itemsAdapterItems: ItemsAdapterItems? = null
    private val modalList = ArrayList<Modal>()
    private var itemsAdapterCovenants: ItemsAdapterCovenants? = null
    private val itemsModalListCovenants = ArrayList<ItemsModalCovenants>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.browser)
        _binding = FragmentBrowserBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        communicator = activity as Communicator

        val imagesNameCovenants = arrayOf(
            ItemsModalCovenants(getString(R.string.bell_keeper),R.drawable.bellkeeperscovenant),
            ItemsModalCovenants(getString(R.string.blue_sentinels),R.drawable.bluesentinelscovenant),
            ItemsModalCovenants(getString(R.string.brotherhood_of_blood),R.drawable.brotherhoodofbloodcovenant),
            ItemsModalCovenants(getString(R.string.company_of_champions),R.drawable.companyofchampionscovenant),
            ItemsModalCovenants(getString(R.string.dragon_remnants),R.drawable.dragonremnantscovenant),
            ItemsModalCovenants(getString(R.string.heirs_of_the_sun),R.drawable.heirsofthesuncovenant),
            ItemsModalCovenants(getString(R.string.pilgrims_of_dark),R.drawable.pilgrimsofdarkcovenant),
            ItemsModalCovenants(getString(R.string.rat_king_covenant),R.drawable.ratkingcovenant),
            ItemsModalCovenants(getString(R.string.way_of_blue),R.drawable.wayofbluecovenant)
        )
        for (items in imagesNameCovenants) if (itemsModalListCovenants.size < 9 ) itemsModalListCovenants.add(items)
        itemsAdapterCovenants = ItemsAdapterCovenants(this.requireContext(),this)
        itemsAdapterCovenants?.setData(itemsModalListCovenants)

        val imagesNameItems = arrayOf(


            Modal(getString(R.string.tseldora_manchettes),R.drawable.tseldoramanchettes),Modal(getString(R.string.varangian_cuffs),R.drawable.varangiancuffs),
            Modal(getString(R.string.tattered_cloth_manchettes),R.drawable.tatteredclothmanchettes),Modal(getString(R.string.traveling_merchant_gloves),R.drawable.travelingmerchantgloves),
            Modal(getString(R.string.steel_gauntlets),R.drawable.steelgauntlets),Modal(getString(R.string.syans_gauntlets),R.drawable.syansgauntlets),
            Modal(getString(R.string.sanctum_soldier_gauntlets),R.drawable.sanctumsoldiergauntlets),Modal(getString(R.string.shadow_gauntlets),R.drawable.shadowgauntlets),
            Modal(getString(R.string.rusted_mastodon_gauntlets),R.drawable.rustedmastodongauntlets),Modal(getString(R.string.sanctum_knight_gauntlets),R.drawable.sanctumknightgauntlets),
            Modal(getString(R.string.rampart_golem_gauntlets),R.drawable.rampartgolemgauntlets),Modal(getString(R.string.ruin_gauntlets),R.drawable.ruingauntlets),
            Modal(getString(R.string.peasant_long_gloves),R.drawable.peasantlonggloves),Modal(getString(R.string.prisoners_gloves),R.drawable.prisonersgloves),
            Modal(getString(R.string.old_knight_gauntlets),R.drawable.oldknightgauntlets),Modal(getString(R.string.pates_gloves),R.drawable.patesgloves),
            Modal(getString(R.string.northwarder_manchettes),R.drawable.northwardermanchettes),Modal(getString(R.string.old_ironclad_gauntlets),R.drawable.oldironcladgauntlets),
            Modal(getString(R.string.mastodon_gauntlets),R.drawable.mastodongauntlets),Modal(getString(R.string.monastery_long_gloves),R.drawable.monasterylonggloves),
            Modal(getString(R.string.white_hollow_mage_robe),R.drawable.whitehollowmagerobe),Modal(getString(R.string.xanthous_overcoat),R.drawable.xanthousovercoat),
            Modal(getString(R.string.tseldora_robe),R.drawable.tseldorarobe),Modal(getString(R.string.varangian_armor),R.drawable.varangianarmor),
            Modal(getString(R.string.tattered_cloth_robe),R.drawable.tatteredclothrobe),Modal(getString(R.string.traveling_merchant_coat),R.drawable.travelingmerchantcoat),
            Modal(getString(R.string.steel_armor),R.drawable.steelarmor),Modal(getString(R.string.syans_armor),R.drawable.syansarmor),
            Modal(getString(R.string.sanctum_knight_armor),R.drawable.sanctumknightarmor),Modal(getString(R.string.shadow_top),R.drawable.shadowtop),
            Modal(getString(R.string.ruin_armor),R.drawable.ruinarmor),Modal(getString(R.string.rusted_mastodon_armor),R.drawable.rustedmastodonarmor),
            Modal(getString(R.string.retainer_robe),R.drawable.retainerrobe),Modal(getString(R.string.robe_of_judgment),R.drawable.robeofjudgment),
            Modal(getString(R.string.rampart_golem_armor),R.drawable.rampartgolemarmor),Modal(getString(R.string.red_lion_warrior_cape),R.drawable.redlionwarriorcape),
            Modal(getString(R.string.prisoners_tatters_left),R.drawable.prisonerstattersleft),Modal(getString(R.string.prisoners_tatters_right),R.drawable.prisonerstattersright),
            Modal(getString(R.string.mad_warrior_gauntlets),R.drawable.madwarriorgauntlets),Modal(getString(R.string.manchettes_of_judgement),R.drawable.manchettesofjudgement),
            Modal(getString(R.string.llewellyn_gloves),R.drawable.llewellyngloves),Modal(getString(R.string.loyce_gauntlets),R.drawable.loycegauntlets),
            Modal(getString(R.string.lion_mage_cuffs),R.drawable.lionmagecuffs),Modal(getString(R.string.lion_warrior_cuffs),R.drawable.lionwarriorcuffs),
            Modal(getString(R.string.ivory_king_gauntlets),R.drawable.ivorykinggauntlets),Modal(getString(R.string.leydia_gauntlets),R.drawable.leydiagauntlets),
            Modal(getString(R.string.imported_manchettes),R.drawable.importedmanchettes),Modal(getString(R.string.ironclad_gauntlets),R.drawable.ironcladgauntlets),
            Modal(getString(R.string.hollow_soldier_gauntlets),R.drawable.hollowsoldiergauntlets),Modal(getString(R.string.imperious_gloves),R.drawable.imperiousgloves),
            Modal(getString(R.string.heide_knight_gauntlets),R.drawable.heideknightgauntlets),Modal(getString(R.string.hollow_infantry_gloves),R.drawable.hollowinfantrygloves),
            Modal(getString(R.string.gyrm_warrior_gloves),R.drawable.gyrmwarriorgloves),Modal(getString(R.string.havels_gauntlets),R.drawable.havelsgauntlets),
            Modal(getString(R.string.grave_warden_cuffs),R.drawable.gravewardencuffs),Modal(getString(R.string.gyrm_gloves),R.drawable.gyrmgloves),
            Modal(getString(R.string.gauntlets_of_aurous),R.drawable.gauntletsofaurous),Modal(getString(R.string.gauntlets_of_aurous_transparent),R.drawable.gauntletsofauroustransparent),
            Modal(getString(R.string.drakekeeper_gauntlets),R.drawable.drakekeepergauntlets),Modal(getString(R.string.fume_sorcerer_gloves),R.drawable.fumesorcerergloves),
            Modal(getString(R.string.dragon_acolyte_gloves),R.drawable.dragonacolytegloves),Modal(getString(R.string.drakeblood_gauntlets),R.drawable.drakebloodgauntlets),
            Modal(getString(R.string.pates_armor),R.drawable.patesarmor),Modal(getString(R.string.peasant_attire),R.drawable.peasantattire),
            Modal(getString(R.string.old_ironclad_armor),R.drawable.oldironcladarmor),Modal(getString(R.string.old_knight_armor),R.drawable.oldknightarmor),
            Modal(getString(R.string.nahr_alma_robes),R.drawable.nahralmarobes),Modal(getString(R.string.northwarder_robe),R.drawable.northwarderrobe),
            Modal(getString(R.string.mastodon_armor),R.drawable.mastodonarmor),Modal(getString(R.string.monastery_longshirt),R.drawable.monasterylongshirt),
            Modal(getString(R.string.loyce_armor),R.drawable.loycearmor),Modal(getString(R.string.mad_warrior_armor),R.drawable.madwarriorarmor),
            Modal(getString(R.string.lion_warrior_cape),R.drawable.lionwarriorcape),Modal(getString(R.string.llewellyn_armor),R.drawable.llewellynarmor),
            Modal(getString(R.string.leydia_white_robe),R.drawable.leydiawhiterobe),Modal(getString(R.string.lion_mage_robe),R.drawable.lionmagerobe),
            Modal(getString(R.string.ivory_king_armor),R.drawable.ivorykingarmor),Modal(getString(R.string.leydia_black_robe),R.drawable.leydiablackrobe),
            Modal(getString(R.string.imported_tunic),R.drawable.importedtunic),Modal(getString(R.string.ironclad_armor),R.drawable.ironcladarmor),
            Modal(getString(R.string.hollow_soldier_armor),R.drawable.hollowsoldierarmor),Modal(getString(R.string.imperious_armor),R.drawable.imperiousarmor),
            Modal(getString(R.string.desert_sorceress_gloves),R.drawable.desertsorceressgloves),Modal(getString(R.string.dingy_cuffs),R.drawable.dingycuffs),
            Modal(getString(R.string.charred_loyce_gauntlets),R.drawable.charredloycegauntlets),Modal(getString(R.string.dark_gauntlets),R.drawable.darkgauntlets),
            Modal(getString(R.string.catarina_gauntlets),R.drawable.catarinagauntlets),Modal(getString(R.string.chaos_gloves),R.drawable.chaosgloves),
            Modal(getString(R.string.black_gloves),R.drawable.blackgloves),Modal(getString(R.string.brigand_gauntlets),R.drawable.brigandgauntlets),
            Modal(getString(R.string.benharts_gauntlets),R.drawable.benhartsgauntlets),Modal(getString(R.string.black_dragon_gauntlets),R.drawable.blackdragongauntlets),
            Modal(getString(R.string.alonne_knight_gauntlets),R.drawable.alonneknightgauntlets),Modal(getString(R.string.archdrake_gloves),R.drawable.archdrakegloves),
            Modal(getString(R.string.varangian_leggings),R.drawable.varangianleggings),Modal(getString(R.string.xanthous_waistcloth),R.drawable.xanthouswaistcloth),
            Modal(getString(R.string.traveling_merchant_boots),R.drawable.travelingmerchantboots),Modal(getString(R.string.tseldora_trousers),R.drawable.tseldoratrousers),
            Modal(getString(R.string.syans_leggings),R.drawable.syansleggings),Modal(getString(R.string.tights_of_judgment),R.drawable.tightsofjudgment),
            Modal(getString(R.string.shadow_leggings),R.drawable.shadowleggings),Modal(getString(R.string.steel_leggings),R.drawable.steelleggings),
            Modal(getString(R.string.rusted_mastodon_leggings),R.drawable.rustedmastodonleggings),Modal(getString(R.string.sanctum_knight_leggings),R.drawable.sanctumknightleggings),
            Modal(getString(R.string.rampart_golem_leggings),R.drawable.rampartgolemleggings),Modal(getString(R.string.ruin_leggings),R.drawable.ruinleggings),
            Modal(getString(R.string.peasant_trousers),R.drawable.peasanttrousers),Modal(getString(R.string.prisoners_waistcloth),R.drawable.prisonerswaistcloth),
            Modal(getString(R.string.pates_trousers),R.drawable.patestrousers),Modal(getString(R.string.old_knight_leggings),R.drawable.oldknightleggings),
            Modal(getString(R.string.northwarder_trousers),R.drawable.northwardertrousers),Modal(getString(R.string.old_ironclad_leggings),R.drawable.oldironcladleggings),
            Modal(getString(R.string.mastodon_leggings),R.drawable.mastodonleggings),Modal(getString(R.string.monastery_skirt),R.drawable.monasteryskirt),
            Modal(getString(R.string.loyce_leggings),R.drawable.loyceleggings),Modal(getString(R.string.mad_warrior_leggings),R.drawable.madwarriorleggings),
            Modal(getString(R.string.lion_warrior_skirt),R.drawable.lionwarriorskirt),Modal(getString(R.string.llewellyn_shoes),R.drawable.loyceleggings),
            Modal(getString(R.string.leggings_of_aurous_transparent),R.drawable.leggingsofauroustransparent),Modal(getString(R.string.lion_mage_skirt),R.drawable.lionmageskirt),
            Modal(getString(R.string.ivory_king_leggings),R.drawable.ivorykingleggings),Modal(getString(R.string.leggings_of_aurous),R.drawable.leggingsofaurous),
            Modal(getString(R.string.heide_knight_chainmail),R.drawable.heideknightchainmail),Modal(getString(R.string.hollow_infantry_armor),R.drawable.hollowinfantryarmor),
            Modal(getString(R.string.gyrm_warrior_armor),R.drawable.gyrmwarriorarmor),Modal(getString(R.string.havels_armor),R.drawable.havelsarmor),
            Modal(getString(R.string.grave_warden_top),R.drawable.gravewardentop),Modal(getString(R.string.gyrm_armor),R.drawable.gyrmarmor),
            Modal(getString(R.string.falconer_armor),R.drawable.falconerarmor),Modal(getString(R.string.fume_sorcerer_robes),R.drawable.fumesorcererrobes),
            Modal(getString(R.string.drakeblood_armor),R.drawable.drakebloodarmor),Modal(getString(R.string.drakekeeper_armor),R.drawable.drakekeeperarmor),
            Modal(getString(R.string.desert_sorceress_top),R.drawable.desertsorceresstop),Modal(getString(R.string.dingy_robe),R.drawable.dingyrobe),
            Modal(getString(R.string.imported_trousers),R.drawable.importedtrousers),Modal(getString(R.string.ironclad_leggings),R.drawable.ironcladleggings),
            Modal(getString(R.string.hollow_soldier_leggings),R.drawable.hollowsoldierleggings),Modal(getString(R.string.imperious_leggings),R.drawable.imperiousleggings),
            Modal(getString(R.string.hollow_infantry_boots),R.drawable.hollowinfantryboots),Modal(getString(R.string.hollow_soldier_leggings),R.drawable.hollowsoldierleggings),
            Modal(getString(R.string.heavy_boots),R.drawable.heavyboots),Modal(getString(R.string.heide_knight_leggings),R.drawable.heideknightleggings),
            Modal(getString(R.string.gyrm_warrior_boots),R.drawable.gyrmwarriorboots),Modal(getString(R.string.havels_leggings),R.drawable.havelsleggings),
            Modal(getString(R.string.grave_warden_bottoms),R.drawable.gravewardenbottoms),Modal(getString(R.string.gyrm_boots),R.drawable.gyrmboots),
            Modal(getString(R.string.flower_skirt),R.drawable.flowerskirt),Modal(getString(R.string.fume_sorcerer_boots),R.drawable.fumesorcererboots),
            Modal(getString(R.string.drakeblood_leggings),R.drawable.drakebloodleggings),Modal(getString(R.string.drakekeeper_boots),R.drawable.drakekeeperboots),
            Modal(getString(R.string.desert_sorceress_skirt),R.drawable.desertsorceressskirt),Modal(getString(R.string.dragon_acolyte_boots),R.drawable.dragonacolyteboots),
            Modal(getString(R.string.charred_loyce_leggings),R.drawable.charredloyceleggings),Modal(getString(R.string.dark_leggings),R.drawable.darkleggings),
            Modal(getString(R.string.catarina_leggings),R.drawable.catarinaleggings),Modal(getString(R.string.chaos_boots),R.drawable.chaosboots),
            Modal(getString(R.string.dark_armor),R.drawable.darkarmor),Modal(getString(R.string.brigand_trousers),R.drawable.brigandtrousers),
            Modal(getString(R.string.catarina_armor),R.drawable.catarinaarmor),Modal(getString(R.string.charred_loyce_armor),R.drawable.charredloycearmor),
            Modal(getString(R.string.black_robes),R.drawable.blackrobes),Modal(getString(R.string.brigand_armor),R.drawable.brigandarmor),
            Modal(getString(R.string.black_dragon_armor),R.drawable.blackdragonarmor),Modal(getString(R.string.black_hollow_mage_robe),R.drawable.blackhollowmagerobe),
            Modal(getString(R.string.black_dragon_leggings),R.drawable.blackdragonleggings),Modal(getString(R.string.blood_stained_skirt),R.drawable.bloodstainedskirt),
            Modal(getString(R.string.benharts_boots),R.drawable.benhartsboots),Modal(getString(R.string.black_boots),R.drawable.blackboots),
            Modal(getString(R.string.alonne_knight_leggings),R.drawable.alonneknightleggings),Modal(getString(R.string.archdrake_boots),R.drawable.archdrakeboots),
            Modal(getString(R.string.armor_of_aurous),R.drawable.armorofaurous),Modal(getString(R.string.benharts_armor),R.drawable.benhartsarmor),
            Modal(getString(R.string.alonne_captain_armor),R.drawable.alonnecaptainarmor),Modal(getString(R.string.alonne_knight_armor),R.drawable.alonneknightarmor),
            Modal(getString(R.string.white_hollow_mage_hood),R.drawable.whitehollowmagehood),Modal(getString(R.string.xanthous_crown),R.drawable.xanthouscrown),
            Modal(getString(R.string.varangian_helm),R.drawable.varangianhelm),Modal(getString(R.string.warlock_mask),R.drawable.warlockmask),
            Modal(getString(R.string.traveling_merchant_hat),R.drawable.travelingmerchanthat),Modal(getString(R.string.tseldora_cap),R.drawable.tseldoracap),
            Modal(getString(R.string.symbol_of_avarice),R.drawable.symbolofavarice),Modal(getString(R.string.tattered_cloth_hood),R.drawable.tatteredclothhood),
            Modal(getString(R.string.steel_helm),R.drawable.steelhelm),Modal(getString(R.string.syans_helm),R.drawable.syanshelm),
            Modal(getString(R.string.sanctum_priestess_tiara),R.drawable.sanctumpriestesstiara),Modal(getString(R.string.shadow_mask),R.drawable.shadowmask),
            Modal(getString(R.string.black_witch_gloves),R.drawable.blackwitchgloves),Modal(getString(R.string.black_witch_trousers),R.drawable.blackwitchtrousers),
            Modal(getString(R.string.astrologists_bottoms),R.drawable.astrologistsbottoms),Modal(getString(R.string.black_witch_robe),R.drawable.blackwitchrobe),
            Modal(getString(R.string.astrologists_robe),R.drawable.astrologistsrobe),Modal(getString(R.string.astrologists_gauntlets),R.drawable.astrologistsgauntlets),
            Modal(getString(R.string.rusted_mastodon_helm),R.drawable.rustedmastodonhelm),Modal(getString(R.string.sanctum_knight_helm),R.drawable.sanctumknighthelm),
            Modal(getString(R.string.insolent_boots),R.drawable.insolentboots),Modal(getString(R.string.ruin_helm),R.drawable.ruinhelm),
            Modal(getString(R.string.insolent_armor),R.drawable.insolentarmor),Modal(getString(R.string.insolent_gloves),R.drawable.insolentgloves),
            Modal(getString(R.string.prisoners_hood),R.drawable.prisonershood),Modal(getString(R.string.rampart_golem_helm),R.drawable.rampartgolemhelm),
            Modal(getString(R.string.peasant_hat),R.drawable.peasanthat),Modal(getString(R.string.pharros_mask),R.drawable.pharrosmask),
            Modal(getString(R.string.old_knight_helm),R.drawable.oldknighthelm),Modal(getString(R.string.pates_helm),R.drawable.pateshelm),
            Modal(getString(R.string.old_bell_helm),R.drawable.oldbellhelm),Modal(getString(R.string.old_ironclad_helm),R.drawable.oldironcladhelm),
            Modal(getString(R.string.moon_hat),R.drawable.moonhat),Modal(getString(R.string.northwarder_hood),R.drawable.northwarderhood),
            Modal(getString(R.string.mirrah_hat),R.drawable.mirrahhat),Modal(getString(R.string.monastery_headcloth),R.drawable.monasteryheadcloth),
            Modal(getString(R.string.mask_of_judgment),R.drawable.maskofjudgment),Modal(getString(R.string.mastodon_helm),R.drawable.mastodonhelm),
            Modal(getString(R.string.mad_warrior_mask),R.drawable.madwarriormask),Modal(getString(R.string.singers_dress),R.drawable.singersdress),
            Modal(getString(R.string.lion_warrior_helm),R.drawable.lionwarriorhelm),Modal(getString(R.string.loyce_helm),R.drawable.loycehelm),
            Modal(getString(R.string.leydia_black_hood),R.drawable.leydiablackhood),Modal(getString(R.string.leydia_white_hood),R.drawable.leydiawhitehood),
            Modal(getString(R.string.insolent_helm),R.drawable.insolenthelm),Modal(getString(R.string.ironclad_helm),R.drawable.ironcladhelm),
            Modal(getString(R.string.insolent_helm),R.drawable.insolenthelm),Modal(getString(R.string.ironclad_helm),R.drawable.ironcladhelm),
            Modal(getString(R.string.imported_hood),R.drawable.importedhood),Modal(getString(R.string.infantry_helm),R.drawable.infantryhelm),
            Modal(getString(R.string.hollow_soldier_helm),R.drawable.hollowsoldierhelm),Modal(getString(R.string.imperious_helm),R.drawable.imperioushelm),
            Modal(getString(R.string.kings_gauntlets),R.drawable.kingsgauntlets),Modal(getString(R.string.kings_leggings),R.drawable.kingsleggings),
            Modal(getString(R.string.kings_crow),R.drawable.kingscrown),Modal(getString(R.string.kings_armor),R.drawable.kingsarmor),
            Modal(getString(R.string.faraam_armor),R.drawable.faraamarmor),Modal(getString(R.string.faraam_gauntlets),R.drawable.faraamgauntlets),
            Modal(getString(R.string.vengarls_gloves),R.drawable.vengarlsgloves),Modal(getString(R.string.vengarls_boots),R.drawable.vengarlsboots),
            Modal(getString(R.string.priestess_skirt),R.drawable.priestessskirt),Modal(getString(R.string.vengarls_armor),R.drawable.vengarlsarmor),
            Modal(getString(R.string.priestess_robe),R.drawable.priestessrobe),Modal(getString(R.string.priestess_gloves),R.drawable.priestessgloves),
            Modal(getString(R.string.engraved_gauntlets),R.drawable.engravedgauntlets),Modal(getString(R.string.priestess_headpiece),R.drawable.priestessheadpiece),
            Modal(getString(R.string.white_priest_gloves),R.drawable.whitepriestgloves),Modal(getString(R.string.white_priest_skirt),R.drawable.whitepriestskirt),
            Modal(getString(R.string.white_priest_headpiece),R.drawable.whitepriestheadpiece),Modal(getString(R.string.white_priest_robe),R.drawable.whitepriestrobe),
            Modal(getString(R.string.hollow_infantry_helm),R.drawable.hollowinfantryhelm),Modal(getString(R.string.hollow_skin),R.drawable.hollowskin),
            Modal(getString(R.string.helm_of_aurous),R.drawable.helmofaurous),Modal(getString(R.string.helm_of_aurous_transparent),R.drawable.helmofauroustransparent),
            Modal(getString(R.string.havels_helm),R.drawable.havelshelm),Modal(getString(R.string.heide_knight_greathelm),R.drawable.heideknightgreathelm),
            Modal(getString(R.string.gyrm_warrior_greathelm),R.drawable.gyrmwarriorgreathelm),Modal(getString(R.string.gyrm_helm),R.drawable.gyrmhelm),
            Modal(getString(R.string.grave_warden_mask),R.drawable.gravewardenmask),Modal(getString(R.string.gyrm_helm),R.drawable.gyrmhelm),
            Modal(getString(R.string.faraam_helm),R.drawable.faraamhelm),Modal(getString(R.string.fume_sorcerer_mask),R.drawable.fumesorcerermask),
            Modal(getString(R.string.drangleic_helm),R.drawable.drangleichelm),Modal(getString(R.string.durgos_hat),R.drawable.durgoshat),
            Modal(getString(R.string.drakekeeper_helm),R.drawable.drakekeeperhelm),Modal(getString(R.string.vengarls_helm),R.drawable.vengarlshelm),
            Modal(getString(R.string.dragon_sage_hood),R.drawable.dragonsagehood),Modal(getString(R.string.drakeblood_helm),R.drawable.drakebloodhelm),
            Modal(getString(R.string.dingy_hood),R.drawable.dingyhood),Modal(getString(R.string.dragon_acolyte_mask),R.drawable.dragonacolytemask),
            Modal(getString(R.string.dark_mask),R.drawable.darkmask),Modal(getString(R.string.desert_sorceress_hood),R.drawable.desertsorceresshood),
            Modal(getString(R.string.crown_of_the_old_iron_king),R.drawable.crownoftheoldironking),Modal(getString(R.string.crown_of_the_sunken_king),R.drawable.crownofthesunkenking),
            Modal(getString(R.string.creightons_steel_mask),R.drawable.creightonssteelmask),Modal(getString(R.string.crown_of_the_ivory_king),R.drawable.crownoftheivoryking),
            Modal(getString(R.string.chaos_hood),R.drawable.chaoshood),Modal(getString(R.string.charred_loyce_helm),R.drawable.charredloycehelm),
            Modal(getString(R.string.bell_keeper_trousers),R.drawable.bellkeepertrousers),Modal(getString(R.string.catarina_helm),R.drawable.catarinahelm),
            Modal(getString(R.string.bell_keeper_bellyband),R.drawable.bellkeeperbellyband),Modal(getString(R.string.bell_keeper_cuffs),R.drawable.bellkeepercuffs),
            Modal(getString(R.string.raimes_gauntlets),R.drawable.raimesgauntlets),Modal(getString(R.string.raimes_leggings),R.drawable.raimesleggings),
            Modal(getString(R.string.raimes_helm),R.drawable.raimeshelm),Modal(getString(R.string.raimes_armor),R.drawable.raimesarmor),
            Modal(getString(R.string.alonnes_gauntlets),R.drawable.alonnesgauntlets),Modal(getString(R.string.alonnes_leggings),R.drawable.alonnesleggings),
            Modal(getString(R.string.alonnes_helm),R.drawable.alonneshelm),Modal(getString(R.string.alonnes_armor),R.drawable.alonnesarmor),
            Modal(getString(R.string.dragonrider_gauntlets),R.drawable.dragonridergauntlets),Modal(getString(R.string.dragonrider_leggings),R.drawable.dragonriderleggings),
            Modal(getString(R.string.dragonrider_helm),R.drawable.dragonriderhelm),Modal(getString(R.string.dragonrider_armor),R.drawable.dragonriderarmor),
            Modal(getString(R.string.black_witch_veil),R.drawable.blackwitchveil),Modal(getString(R.string.brigand_hood),R.drawable.brigandhood),
            Modal(getString(R.string.black_witch_domino_mask),R.drawable.blackwitchdominomask),Modal(getString(R.string.black_witch_hat),R.drawable.blackwitchhat),
            Modal(getString(R.string.black_hollow_mage_hood),R.drawable.blackhollowmagehood),Modal(getString(R.string.black_hood),R.drawable.blackhood),
            Modal(getString(R.string.benharts_knight_helm),R.drawable.benhartsknighthelm),Modal(getString(R.string.black_dragon_helm),R.drawable.blackdragonhelm),
            Modal(getString(R.string.archdrake_helm),R.drawable.archdrakehelm),Modal(getString(R.string.bell_keeper_helmet),R.drawable.bellkeeperhelmet),
            Modal(getString(R.string.alonne_knight_helm),R.drawable.alonneknighthelm),Modal(getString(R.string.alonnes_helm),R.drawable.alonneshelm),
            Modal(getString(R.string.bandit_gauntlets),R.drawable.banditgauntlets),Modal(getString(R.string.bandit_boots),R.drawable.banditboots),
            Modal(getString(R.string.spiked_bandit_helm),R.drawable.spikedbandithelm),Modal(getString(R.string.bandit_armor),R.drawable.banditarmor),
            Modal(getString(R.string.jesters_gloves),R.drawable.jestersgloves),Modal(getString(R.string.jesters_tights),R.drawable.jesterstights),
            Modal(getString(R.string.jesters_cap),R.drawable.jesterscap),Modal(getString(R.string.jesters_robes),R.drawable.jestersrobes),
            Modal(getString(R.string.agdaynes_cuffs),R.drawable.agdaynescuffs),Modal(getString(R.string.agdaynes_kilt),R.drawable.agdayneskilt),
            Modal(getString(R.string.alonne_captain_helm),R.drawable.alonnecaptainhelm),Modal(getString(R.string.agdaynes_black_robe),R.drawable.agdaynesblackrobe),
            Modal(getString(R.string.manikin_gloves),R.drawable.manikingloves),Modal(getString(R.string.manikin_boots),R.drawable.manikinboots),
            Modal(getString(R.string.manikin_mask),R.drawable.manikinmask),Modal(getString(R.string.manikin_top),R.drawable.manikintop),
            Modal(getString(R.string.wanderer_boots),R.drawable.wandererboots),Modal(getString(R.string.archdrake_robes),R.drawable.archdrakerobes),
            Modal(getString(R.string.wanderer_coat),R.drawable.wanderercoat),Modal(getString(R.string.wanderer_manchettes),R.drawable.wanderermanchettes),
            Modal(getString(R.string.royal_swordsman_leggings),R.drawable.royalswordsmanleggings),Modal(getString(R.string.wanderer_hood),R.drawable.wandererhood),
            Modal(getString(R.string.royal_swordsman_armor),R.drawable.royalswordsmanarmor),Modal(getString(R.string.royal_swordsman_gloves),R.drawable.royalswordsmangloves),
            Modal(getString(R.string.smelter_wedge),R.drawable.smelterwedge),Modal(getString(R.string.royal_swordsman_helm),R.drawable.royalswordsmanhelm),
            Modal(getString(R.string.rubbish),R.drawable.rubbish),Modal(getString(R.string.smooth_and_silky_stone),R.drawable.smoothandsilkystone),
            Modal(getString(R.string.rogue_leggings),R.drawable.rogueleggings),Modal(getString(R.string.darksign),R.drawable.darksign),
            Modal(getString(R.string.rogue_armor),R.drawable.roguearmor),Modal(getString(R.string.rogue_gauntlets),R.drawable.roguegauntlets),
            Modal(getString(R.string.dragon_torso_stone),R.drawable.dragontorsostone),Modal(getString(R.string.rogue_hood),R.drawable.roguehood),
            Modal(getString(R.string.charcoal_pine_resin),R.drawable.charcoalpineresin),Modal(getString(R.string.dragon_head_stone),R.drawable.dragonheadstone),
            Modal(getString(R.string.lightning_urn),R.drawable.lightningurn),Modal(getString(R.string.dung_pie),R.drawable.dungpie),
            Modal(getString(R.string.tower_key),R.drawable.tseldoradenkey),Modal(getString(R.string.palestone),R.drawable.palestone),
            Modal(getString(R.string.rotunda_lockstone),R.drawable.rotundalockstone),Modal(getString(R.string.scorching_iron_scepter),R.drawable.scorchingironscepter),
            Modal(getString(R.string.house_key),R.drawable.housekey),Modal(getString(R.string.key_to_kings_passage),R.drawable.keytokingspassage),
            Modal(getString(R.string.fang_key),R.drawable.fangkey),Modal(getString(R.string.garrison_ward_key),R.drawable.garrisonwardkey),
            Modal(getString(R.string.eye_of_the_priestess),R.drawable.eyeofthepriestess),Modal(getString(R.string.fang_key),R.drawable.fangkey),
            Modal(getString(R.string.bone_king_cuffs),R.drawable.bonekingcuffs),Modal(getString(R.string.bone_king_skirt),R.drawable.bonekingskirt),
            Modal(getString(R.string.bone_crown),R.drawable.bonecrown),Modal(getString(R.string.bone_king_robe),R.drawable.bonekingrobe),
            Modal(getString(R.string.executioner_gauntlets),R.drawable.executionergauntlets),Modal(getString(R.string.executioner_leggings),R.drawable.executionerleggings),
            Modal(getString(R.string.executioner_helm),R.drawable.executionerhelm),Modal(getString(R.string.executioner_armor),R.drawable.executionerarmor),
            Modal(getString(R.string.eternal_sanctum_key),R.drawable.eternalsanctumkey),Modal(getString(R.string.nahr_alma_hood),R.drawable.nahralmahood),
            Modal(getString(R.string.dragon_talon),R.drawable.dragontalon),Modal(getString(R.string.dragon_stone),R.drawable.dragonstone),
            Modal(getString(R.string.antiquated_key),R.drawable.antiquatedkey),Modal(getString(R.string.bastille_key),R.drawable.bastillekey),
            Modal(getString(R.string.im_sorry_carving),R.drawable.imsorrycarving),Modal(getString(R.string.very_good_carving),R.drawable.verygoodcarving),
            Modal(getString(R.string.hello_carving),R.drawable.hellocarving),Modal(getString(R.string.thank_you_carving),R.drawable.thankyoucarving),
            Modal(getString(R.string.champions_tablet),R.drawable.championstablet),Modal(getString(R.string.token_of_spite),R.drawable.tokenofspite),
            Modal(getString(R.string.black_separation_crystal),R.drawable.blackseparationcrystal),Modal(getString(R.string.bone_of_order),R.drawable.boneoforder),
            Modal(getString(R.string.sunlight_medal),R.drawable.sunlightmedal),Modal(getString(R.string.dragon_scale),R.drawable.dragonscale),
            Modal(getString(R.string.fire_greatarrow),R.drawable.firegreatarrow),Modal(getString(R.string.dragon_eye),R.drawable.dragoneye),
            Modal(getString(R.string.destructive_great_arrow),R.drawable.destructivegreatarrow),Modal(getString(R.string.lightning_greatarrow),R.drawable.lightninggreatarrow),
            Modal(getString(R.string.magic_bolt),R.drawable.magicbolt),Modal(getString(R.string.dark_bolt),R.drawable.darkbolt),
            Modal(getString(R.string.vine_balm),R.drawable.vinebalm),Modal(getString(R.string.lightning_arrow),R.drawable.lightningarrow),
            Modal(getString(R.string.goldenfruit_balm),R.drawable.goldenfruitbalm),Modal(getString(R.string.blackweed_balm),R.drawable.blackweedbalm),
            Modal(getString(R.string.dried_root),R.drawable.driedroot),Modal(getString(R.string.old_growth_balm),R.drawable.oldgrowthbalm),
            Modal(getString(R.string.triclops_snake_troches),R.drawable.triclopssnaketroches),Modal(getString(R.string.red_leech_troches),R.drawable.redleechtroches),
            Modal(getString(R.string.leggings_of_the_forlorn),R.drawable.leggingsoftheforlorn),Modal(getString(R.string.common_fruit),R.drawable.commonfruit),
            Modal(getString(R.string.armor_of_the_forlorn),R.drawable.armoroftheforlorn),Modal(getString(R.string.gauntlets_of_the_forlorn),R.drawable.gauntletsoftheforlorn),
            Modal(getString(R.string.red_sign_soapstone),R.drawable.redsignsoapstone),Modal(getString(R.string.hood_of_the_forlorn),R.drawable.hoodoftheforlorn),
            Modal(getString(R.string.lucatiels_mask),R.drawable.lucatielsmask),Modal(getString(R.string.iron_greatarrow),R.drawable.irongreatarrow),
            Modal(getString(R.string.flame_weapon),R.drawable.flameweapon),Modal(getString(R.string.poison_arrow),R.drawable.poisonarrow),
            Modal(getString(R.string.unveil),R.drawable.unveil),Modal(getString(R.string.wrath_of_the_gods),R.drawable.wrathofthegods),
            Modal(getString(R.string.splintering_lightning_spear),R.drawable.splinteringlightningspear),Modal(getString(R.string.sunlight_spear),R.drawable.sunlightspear),
            Modal(getString(R.string.sacred_oath),R.drawable.sacredoath),Modal(getString(R.string.soothing_sunlight),R.drawable.soothingsunlight),
            Modal(getString(R.string.magic_barrier),R.drawable.magicbarrier),Modal(getString(R.string.perseverance),R.drawable.perseverance),
            Modal(getString(R.string.great_heal),R.drawable.greatheal),Modal(getString(R.string.heavenly_thunder),R.drawable.heavenlythunder),
            Modal(getString(R.string.bountiful_sunlight),R.drawable.bountifulsunlight),Modal(getString(R.string.denial),R.drawable.denial),
            Modal(getString(R.string.unleash_magic),R.drawable.unleashmagic),Modal(getString(R.string.blinding_bolt),R.drawable.blindingbolt),
            Modal(getString(R.string.soul_flash),R.drawable.soulflash),Modal(getString(R.string.soul_shower),R.drawable.soulshower),
            Modal(getString(R.string.homing_soul_arrow),R.drawable.homingsoularrow),Modal(getString(R.string.soul_bolt),R.drawable.soulbolt),
            Modal(getString(R.string.heavy_homing_soul_arrow),R.drawable.heavyhomingsoularrow),Modal(getString(R.string.hidden_weapon),R.drawable.hiddenweapon),
            Modal(getString(R.string.focus_souls),R.drawable.focussouls),Modal(getString(R.string.heavy_homing_soul_arrow),R.drawable.heavyhomingsoularrow),
            Modal(getString(R.string.crystal_soul_spear),R.drawable.crystalsoulspear),Modal(getString(R.string.fall_control),R.drawable.fallcontrol),
            Modal(getString(R.string.whisper_of_despair),R.drawable.whisperofdespair),Modal(getString(R.string.cast_light),R.drawable.castlight),
            Modal(getString(R.string.resonant_soul),R.drawable.resonantsoul),Modal(getString(R.string.resonant_weapon),R.drawable.resonantweapon),
            Modal(getString(R.string.repel),R.drawable.repel),Modal(getString(R.string.resonant_flesh),R.drawable.resonantflesh),
            Modal(getString(R.string.promisedwalkofpeace),R.drawable.promisedwalkofpeace),Modal(getString(R.string.recollection),R.drawable.recollection),
            Modal(getString(R.string.numbness),R.drawable.numbness),Modal(getString(R.string.profound_still),R.drawable.profoundstill),
            Modal(getString(R.string.great_resonant_soul),R.drawable.greatresonantsoul),Modal(getString(R.string.lifedrain_patch),R.drawable.lifedrainpatch),
            Modal(getString(R.string.dark_weapon),R.drawable.darkweapon),Modal(getString(R.string.dead_again),R.drawable.deadagain),
            Modal(getString(R.string.flame_weapon),R.drawable.flameweapon),Modal(getString(R.string.dark_orb),R.drawable.darkorb),
            Modal(getString(R.string.fire_whip),R.drawable.firewhip),Modal(getString(R.string.flame_swathe),R.drawable.flameswathe),
            Modal(getString(R.string.dance_of_fire),R.drawable.danceoffire),Modal(getString(R.string.fire_snake),R.drawable.firesnake),
            Modal(getString(R.string.acid_surge),R.drawable.acidsurge),Modal(getString(R.string.chaos_storm),R.drawable.chaosstorm),
            Modal(getString(R.string.twisted_barricade),R.drawable.twistedbarricade),Modal(getString(R.string.whisper_despair),R.drawable.whisperdespair),
            Modal(getString(R.string.dark_greatsword),R.drawable.darkgreatsword),Modal(getString(R.string.dark_hail),R.drawable.darkhail),
            Modal(getString(R.string.darkstorm),R.drawable.darkstorm),Modal(getString(R.string.dark_dance),R.drawable.darkdance),
            Modal(getString(R.string.affinity),R.drawable.affinity),Modal(getString(R.string.climax),R.drawable.climax),
            Modal(getString(R.string.outcry),R.drawable.outcry),Modal(getString(R.string.toxic_mist),R.drawable.toxicmist),
            Modal(getString(R.string.great_chaos_fireball),R.drawable.greatchaosfireball),Modal(getString(R.string.lingering_flame),R.drawable.lingeringflame),
            Modal(getString(R.string.dark_fog),R.drawable.darkfog),Modal(getString(R.string.forbidden_sun),R.drawable.forbiddensun),
            Modal(getString(R.string.dead_again),R.drawable.deadagain),Modal(getString(R.string.scraps_of_life),R.drawable.scrapsoflife),
            Modal(getString(R.string.knight_gauntlets),R.drawable.knightgauntlets),Modal(getString(R.string.knight_leggings),R.drawable.knightleggings),
            Modal(getString(R.string.knight_helm),R.drawable.knighthelm),Modal(getString(R.string.knight_armor),R.drawable.knightarmor),
            Modal(getString(R.string.leather_gloves),R.drawable.leathergloves),Modal(getString(R.string.leather_boots),R.drawable.leatherboots),
            Modal(getString(R.string.hunters_hat),R.drawable.huntershat),Modal(getString(R.string.leather_armor),R.drawable.leatherarmor),
            Modal(getString(R.string.drangleic_gauntlets),R.drawable.drangleicgauntlets),Modal(getString(R.string.drangleic_leggings),R.drawable.drangleicleggings),
            Modal(getString(R.string.chime_of_screams),R.drawable.chimeofscreams),Modal(getString(R.string.drangleic_mail),R.drawable.drangleicmail),
            Modal(getString(R.string.protective_chime),R.drawable.protectivechime),Modal(getString(R.string.disc_chime),R.drawable.discchime),
            Modal(getString(R.string.idols_chime),R.drawable.idolschime),Modal(getString(R.string.caithas_chime),R.drawable.caithaschime),
            Modal(getString(R.string.guidance),R.drawable.guidance),Modal(getString(R.string.archdrake_chime),R.drawable.archdrakechime),
            Modal(getString(R.string.force),R.drawable.force),Modal(getString(R.string.homeward),R.drawable.homeward),
            Modal(getString(R.string.resplendent_life),R.drawable.resplendentlife),Modal(getString(R.string.caressing_prayer),R.drawable.caressingprayer),
            Modal(getString(R.string.great_heal_excerpt),R.drawable.greathealexcerpt),Modal(getString(R.string.replenishment),R.drawable.replenishment),
            Modal(getString(R.string.chime_of_want),R.drawable.chimeofwant),Modal(getString(R.string.med_heal),R.drawable.medheal),
            Modal(getString(R.string.witchtree_bellvine),R.drawable.witchtreebellvine),Modal(getString(R.string.priest_schime),R.drawable.priestschime),
            Modal(getString(R.string.sanctum_repeating_crossbow),R.drawable.sanctumrepeatingcrossbow),Modal(getString(R.string.sanctum_crossbow),R.drawable.sanctumcrossbow),
            Modal(getString(R.string.twin_headed_greatbow),R.drawable.twinheadedgreatbow),Modal(getString(R.string.shield_crossbow),R.drawable.shieldcrossbow),
            Modal(getString(R.string.dragonslayer_greatbow),R.drawable.dragonslayergreatbow),Modal(getString(R.string.possessed_armor_greatbow),R.drawable.possessedarmorgreatbow),
            Modal(getString(R.string.bow_of_want),R.drawable.bowofwant),Modal(getString(R.string.hunters_blackbow),R.drawable.huntersblackbow),
            Modal(getString(R.string.dragonrider_bow),R.drawable.dragonriderbow),Modal(getString(R.string.bell_keeper_bow),R.drawable.bellkeeperbow),
            Modal(getString(R.string.composite_bow),R.drawable.compositebow),Modal(getString(R.string.sea_bow),R.drawable.seabow),
            Modal(getString(R.string.old_whip),R.drawable.oldwhip),Modal(getString(R.string.long_bow),R.drawable.longbow),
            Modal(getString(R.string.bloodied_whip),R.drawable.bloodiedwhip),Modal(getString(R.string.spotted_whip),R.drawable.spottedwhip),
            Modal(getString(R.string.work_hook),R.drawable.workhook),Modal(getString(R.string.bone_fist),R.drawable.bonefist),
            Modal(getString(R.string.retainer_staff),R.drawable.retainerstaff),Modal(getString(R.string.malformed_claws),R.drawable.malformedclaws),
            Modal(getString(R.string.black_witchs_staff),R.drawable.blackwitchsstaff),Modal(getString(R.string.azals_staff),R.drawable.azalsstaff),
            Modal(getString(R.string.bat_staff),R.drawable.batstaff),Modal(getString(R.string.sunset_staff),R.drawable.sunsetstaff),
            Modal(getString(R.string.staff_of_amana),R.drawable.staffofamana),Modal(getString(R.string.archdrake_staff),R.drawable.archdrakestaff),
            Modal(getString(R.string.lizard_staff),R.drawable.lizardstaff),Modal(getString(R.string.transgressors_staff),R.drawable.transgressorsstaff),
            Modal(getString(R.string.ladder_miniature),R.drawable.ladderminiature),Modal(getString(R.string.witchtree_branch),R.drawable.witchtreebranch),
            Modal(getString(R.string.lacerating_knife),R.drawable.laceratingknife),Modal(getString(R.string.bleeding_serum),R.drawable.bleedingserum),
            Modal(getString(R.string.black_leather_gloves),R.drawable.blackleathergloves),Modal(getString(R.string.black_leather_boots),R.drawable.blackleatherboots),
            Modal(getString(R.string.thief_mask),R.drawable.thiefmask),Modal(getString(R.string.black_leather_armor),R.drawable.blackleatherarmor),
            Modal(getString(R.string.soul_appease),R.drawable.soulappease),Modal(getString(R.string.claws),R.drawable.claws),
            Modal(getString(R.string.cales_helm),R.drawable.caleshelm),Modal(getString(R.string.old_mundane_stone),R.drawable.oldmundanestone),
            Modal(getString(R.string.flash_sweat),R.drawable.flashsweat),Modal(getString(R.string.iron_flesh),R.drawable.ironflesh),
            Modal(getString(R.string.fire_orb),R.drawable.fireorb),Modal(getString(R.string.poison_mist),R.drawable.poisonmist),
            Modal(getString(R.string.small_yellow_burr),R.drawable.smallyellowburr),Modal(getString(R.string.small_orange_burr),R.drawable.smallorangeburr),
            Modal(getString(R.string.sorcerers_staff),R.drawable.sorcerersstaff),Modal(getString(R.string.small_blue_burr),R.drawable.smallblueburr),
            Modal(getString(R.string.yearn),R.drawable.yearn),Modal(getString(R.string.magic_weapon),R.drawable.magicweapon),
            Modal(getString(R.string.shockwave),R.drawable.shockwave),Modal(getString(R.string.soul_spear_barrage),R.drawable.soulspearbarrage),
            Modal(getString(R.string.heavy_soul_arrow),R.drawable.heavysoularrow),Modal(getString(R.string.heavy_soul_arrow),R.drawable.heavysoularrow),
            Modal(getString(R.string.throne_watcher_gauntlets),R.drawable.thronewatchergauntlets),Modal(getString(R.string.throne_watcher_leggings),R.drawable.thronewatcherleggings),
            Modal(getString(R.string.throne_watcher_helm),R.drawable.thronewatcherhelm),Modal(getString(R.string.throne_watcher_armor),R.string.throne_watcher_armor),
            Modal(getString(R.string.throne_defender_gauntlets),R.drawable.thronedefendergauntlets),Modal(getString(R.string.throne_defender_leggings),R.drawable.thronedefenderleggings),
            Modal(getString(R.string.throne_defender_helm),R.drawable.thronedefenderhelm),Modal(getString(R.string.throne_defender_armor),R.drawable.thronedefenderarmor),
            Modal(getString(R.string.velstadts_gauntlets),R.drawable.velstadtsgauntlets),Modal(getString(R.string.velstadts_leggings),R.drawable.velstadtsleggings),
            Modal(getString(R.string.sorcerers_twinblade),R.drawable.sorcererstwinblade),Modal(getString(R.string.velstadts_armor),R.drawable.velstadtsarmor),
            Modal(getString(R.string.dragonrider_twin_blade),R.drawable.dragonridertwinblade),Modal(getString(R.string.curved_twinblade),R.drawable.curvedtwinblade),
            Modal(getString(R.string.scythe_of_want),R.drawable.scytheofwant),Modal(getString(R.string.scythe_of_the_forlorn),R.drawable.scytheoftheforlorn),
            Modal(getString(R.string.full_moon_sickle),R.drawable.fullmoonsickle),Modal(getString(R.string.bone_scythe),R.drawable.bonescythe),
            Modal(getString(R.string.silverblack_sickle),R.drawable.silverblacksickle),Modal(getString(R.string.great_machete),R.drawable.greatmachete),
            Modal(getString(R.string.rampart_golem_lance),R.drawable.rampartgolemlance),Modal(getString(R.string.great_scythe),R.drawable.greatscythe),
            Modal(getString(R.string.heide_great_lance),R.drawable.heidegreatlance),Modal(getString(R.string.chariot_lance),R.drawable.chariotlance),
            Modal(getString(R.string.roaring_halberd),R.drawable.roaringhalberd),Modal(getString(R.string.wrathful_axe),R.drawable.wrathfulaxe),
            Modal(getString(R.string.blue_knights_halberd),R.drawable.blueknightshalberd),Modal(getString(R.string.syans_halberd),R.drawable.syanshalberd),
            Modal(getString(R.string.lucerne),R.drawable.lucerne),Modal(getString(R.string.mastodon_halberd),R.drawable.mastodonhalberd),
            Modal(getString(R.string.pilgrims_spontoon),R.drawable.pilgrimsspontoon),Modal(getString(R.string.yorghs_spear),R.drawable.yorghsspear),
            Modal(getString(R.string.dragonslayer_spear),R.drawable.dragonslayerspear),Modal(getString(R.string.gargoyle_bident),R.drawable.gargoylebident),
            Modal(getString(R.string.channelers_trident),R.drawable.channelerstrident),Modal(getString(R.string.spitfire_spear),R.drawable.spitfirespear),
            Modal(getString(R.string.heide_spear),R.drawable.heidespear),Modal(getString(R.string.pates_spear),R.drawable.patesspear),
            Modal(getString(R.string.pike),R.drawable.pike),Modal(getString(R.string.silverblack_spear),R.drawable.silverblackspear),
            Modal(getString(R.string.partizan),R.drawable.partizan),Modal(getString(R.string.spear),R.drawable.spear),
            Modal(getString(R.string.sanctum_mace),R.drawable.sanctummace),Modal(getString(R.string.smelter_hammer),R.drawable.smelterhammer),
            Modal(getString(R.string.sacred_chime_hammer),R.drawable.sacredchimehammer),Modal(getString(R.string.drakekeepers_warpick),R.drawable.drakekeeperswarpick),
            Modal(getString(R.string.old_knight_hammer),R.drawable.oldknighthammer),Modal(getString(R.string.drakekeepers_great_hammer),R.drawable.drakekeepersgreathammer),
            Modal(getString(R.string.giant_warrior_club),R.drawable.giantwarriorclub),Modal(getString(R.string.archdrake_mace),R.drawable.archdrakemace),
            Modal(getString(R.string.barbed_club),R.drawable.barbedclub),Modal(getString(R.string.iron_king_hammer),R.drawable.ironkinghammer),
            Modal(getString(R.string.black_dragon_warpick),R.drawable.blackdragonwarpick),Modal(getString(R.string.aldia_hammer),R.drawable.aldiahammer),
            Modal(getString(R.string.gyrm_greataxe),R.drawable.gyrmgreataxe),Modal(getString(R.string.reinforced_club),R.drawable.reinforcedclub),
            Modal(getString(R.string.lion_greataxe),R.drawable.liongreataxe),Modal(getString(R.string.giant_stone_axe),R.drawable.giantstoneaxe),
            Modal(getString(R.string.moon_butterfly_skirt),R.drawable.moonbutterflyskirt),Modal(getString(R.string.velstadts_helm),R.drawable.velstadtshelm),
            Modal(getString(R.string.butchersk_nife),R.drawable.butchersknife),Modal(getString(R.string.bandit_great_axe),R.drawable.banditgreataxe),
            Modal(getString(R.string.bound_hand_axe),R.drawable.boundhandaxe),Modal(getString(R.string.infantry_axe),R.drawable.infantryaxe),
            Modal(getString(R.string.espada_ropera),R.drawable.espadaropera),Modal(getString(R.string.ice_rapier),R.drawable.icerapier),
            Modal(getString(R.string.black_scorpion_stinger),R.drawable.blackscorpionstinger),Modal(getString(R.string.spiders_silk),R.drawable.spiderssilk),
            Modal(getString(R.string.curved_nil_greatsword),R.drawable.curvednilgreatsword),Modal(getString(R.string.chaos_rapier),R.drawable.chaosblade),
            Modal(getString(R.string.arced_sword),R.drawable.arcedsword),Modal(getString(R.string.curved_dragon_greatsword),R.drawable.curveddragongreatsword),
            Modal(getString(R.string.berserker_blade),R.drawable.berserkerblade),Modal(getString(R.string.bewitched_alonne_sword),R.drawable.bewitchedalonnesword),
            Modal(getString(R.string.chaos_blade),R.drawable.chaosblade),Modal(getString(R.string.blacksteel_katana),R.drawable.blacksteelkatana),
            Modal(getString(R.string.moon_butterfly_cuffs),R.drawable.moonbutterflycuffs),Modal(getString(R.string.moon_butterfly_wings),R.drawable.moonbutterflywings),
            Modal(getString(R.string.eleum_loyce),R.drawable.eleumloyce),Modal(getString(R.string.moon_butterfly_hat),R.drawable.moonbutterflyhat),
            Modal(getString(R.string.warped_sword),R.drawable.warpedsword),Modal(getString(R.string.manikin_sabre),R.drawable.manikinsabre),
            Modal(getString(R.string.melu_scimitar),R.drawable.meluscimitar),Modal(getString(R.string.monastery_scimitar),R.drawable.monasteryscimitar),
            Modal(getString(R.string.red_rust_scimitar),R.drawable.redrustscimitar),Modal(getString(R.string.spider_fang),R.drawable.spiderfang),
            Modal(getString(R.string.aged_smelter_sword),R.drawable.agedsmeltersword),Modal(getString(R.string.ivory_king_ultra_greatsword),R.drawable.ivorykingultragreatsword),
            Modal(getString(R.string.lost_sinners_sword),R.drawable.lostsinnerssword),Modal(getString(R.string.fume_ultra_greatsword),R.drawable.fumeultragreatsword),
            Modal(getString(R.string.smelter_sword),R.drawable.smeltersword),Modal(getString(R.string.crypt_blacksword),R.drawable.cryptblacksword),
            Modal(getString(R.string.old_knight_ultra_greatsword),R.drawable.oldknightultragreatsword),Modal(getString(R.string.greatsword),R.drawable.greatsword),
            Modal(getString(R.string.kings_ultra_greatsword),R.drawable.kingsultragreatsword),Modal(getString(R.string.drakekeepers_ultra_greatsword),R.drawable.drakekeepersultragreatsword),
            Modal(getString(R.string.greatsword_of_the_forlorn),R.drawable.greatswordoftheforlorn),Modal(getString(R.string.drakewing_ultra_greatsword),R.drawable.drakewingultragreatsword),
            Modal(getString(R.string.charred_loyce_greatsword),R.drawable.charredloycegreatsword),Modal(getString(R.string.loyce_greatsword),R.drawable.loycegreatsword),
            Modal(getString(R.string.drakeblood_greatsword),R.drawable.drakebloodgreatsword),Modal(getString(R.string.majestic_greatsword),R.drawable.majesticgreatsword),
            Modal(getString(R.string.defender_greatsword),R.drawable.defendergreatsword),Modal(getString(R.string.watcher_greatsword),R.drawable.watchergreatsword),
            Modal(getString(R.string.royal_greatsword),R.drawable.royalgreatsword),Modal(getString(R.string.old_knight_greatsword),R.drawable.oldknightgreatsword),
            Modal(getString(R.string.black_dragon_greatsword),R.drawable.blackdragongreatsword),Modal(getString(R.string.black_knight_greatsword),R.drawable.blackknightgreatsword),
            Modal(getString(R.string.rulers_sword),R.drawable.rulerssword),Modal(getString(R.string.old_mirrah_greatsword),R.drawable.oldmirrahgreatsword),
            Modal(getString(R.string.moonlight_greatsword),R.drawable.moonlightgreatsword),Modal(getString(R.string.mastodon_greatsword),R.drawable.mastodongreatsword),
            Modal(getString(R.string.alva_leggings),R.drawable.alvaleggings),Modal(getString(R.string.thorned_greatsword),R.drawable.thornedgreatsword),
            Modal(getString(R.string.alva_armor),R.drawable.alvaarmor),Modal(getString(R.string.alva_gauntlets),R.drawable.alvagauntlets),
            Modal(getString(R.string.penal_handcuffs),R.drawable.penalhandcuffs),Modal(getString(R.string.alva_helm),R.drawable.alvahelm),
            Modal(getString(R.string.penal_straight_jacket),R.drawable.penalstraightjacket),Modal(getString(R.string.penal_skirt),R.drawable.penalskirt),
            Modal(getString(R.string.looking_glass_leggings),R.drawable.lookingglassleggings),Modal(getString(R.string.penal_mask),R.drawable.penalmask),
            Modal(getString(R.string.looking_glass_armor),R.drawable.lookingglassarmor),Modal(getString(R.string.looking_glass_gauntlets),R.drawable.lookingglassgauntlets),
            Modal(getString(R.string.smelter_demon_leggings),R.drawable.smelterdemonleggings),Modal(getString(R.string.looking_glass_mask),R.drawable.lookingglassmask),
            Modal(getString(R.string.smelter_demon_gauntlets),R.drawable.smelterdemongauntlets),Modal(getString(R.string.smelter_demon_armor),R.drawable.smelterdemonarmor),
            Modal(getString(R.string.elite_knight_leggings),R.drawable.eliteknightleggings),Modal(getString(R.string.smelter_demon_helm),R.drawable.smelterdemonhelm),
            Modal(getString(R.string.elite_knight_armor),R.drawable.eliteknightarmor),Modal(getString(R.string.elite_knight_gloves),R.drawable.eliteknightgloves),
            Modal(getString(R.string.drangleic_sword),R.drawable.drangleicsword),Modal(getString(R.string.elite_knight_helm),R.drawable.eliteknighthelm),
            Modal(getString(R.string.bluemoon_greatsword),R.drawable.bluemoongreatsword),Modal(getString(R.string.claymore),R.drawable.claymore),
            Modal(getString(R.string.possessed_armor_sword),R.drawable.possessedarmorsword),Modal(getString(R.string.ivory_straight_sword),R.drawable.ivorystraightsword),
            Modal(getString(R.string.ashen_warrior_sword),R.drawable.ashenwarriorsword),Modal(getString(R.string.fume_sword),R.drawable.fumesword),
            Modal(getString(R.string.drakekeepers_sword),R.drawable.drakekeeperssword),Modal(getString(R.string.puzzling_stone_sword),R.drawable.puzzlingstonesword),
            Modal(getString(R.string.red_rust_sword),R.drawable.redrustsword),Modal(getString(R.string.sun_sword),R.drawable.sunsword),
            Modal(getString(R.string.heide_knight_sword),R.drawable.heideknightsword),Modal(getString(R.string.blue_flame),R.drawable.blueflame),
            Modal(getString(R.string.foot_soldier_sword),R.drawable.footsoldiersword),Modal(getString(R.string.varangian_sword),R.drawable.varangiansword),
            Modal(getString(R.string.black_dragon_sword),R.drawable.blackdragonsword),Modal(getString(R.string.broken_straight_sword),R.drawable.brokenstraightsword),
            Modal(getString(R.string.yorghs_ring),R.drawable.yorghsring),Modal(getString(R.string.yellow_quartz_longsword),R.drawable.yellowquartzlongsword),
            Modal(getString(R.string.vanquishers_seal),R.drawable.vanquishersseal),Modal(getString(R.string.white_ring),R.drawable.whitering),
            Modal(getString(R.string.sun_seal),R.drawable.sunseal),Modal(getString(R.string.thunder_quartz_ring),R.drawable.thunderquartzring),
            Modal(getString(R.string.sorcery_clutch_ring),R.drawable.sorceryclutchring),Modal(getString(R.string.strength_ring),R.drawable.strengthring),
            Modal(getString(R.string.simpletons_ring),R.drawable.simpletonsring),Modal(getString(R.string.slumbering_dragon_crest_ring),R.drawable.slumberingdragoncrestring),
            Modal(getString(R.string.ring_of_the_embedded),R.drawable.ringofthorns),Modal(getString(R.string.second_dragon_ring),R.drawable.seconddragonring),
            Modal(getString(R.string.ring_of_the_dead),R.drawable.ringofthedead),Modal(getString(R.string.ring_of_the_living),R.drawable.ringoftheliving),
            Modal(getString(R.string.ring_of_soul_protection),R.drawable.ringofsoulprotection),Modal(getString(R.string.ring_of_the_steel_protection),R.drawable.ringofthesteelprotection),
            Modal(getString(R.string.ring_of_resistance),R.drawable.ringofresistance),Modal(getString(R.string.ring_of_restoration),R.drawable.ringofrestoration),
            Modal(getString(R.string.ring_of_knowledge),R.drawable.ringofknowledge),Modal(getString(R.string.ring_of_prayer),R.drawable.ringofprayer),
            Modal(getString(R.string.lingering_dragoncrest_ring),R.drawable.lingeringdragoncrestring),Modal(getString(R.string.nameengraved_ring),R.drawable.nameengravedring),
            Modal(getString(R.string.kings_ring),R.drawable.kingsring),Modal(getString(R.string.lightning_clutch_ring),R.drawable.lightningclutchring),
            Modal(getString(R.string.illusory_ring_of_the_exalted),R.drawable.illusoryringoftheexalted),Modal(getString(R.string.ivory_warrior_ring),R.drawable.ivorywarriorring),
            Modal(getString(R.string.guardians_seal),R.drawable.guardiansseal),Modal(getString(R.string.illusory_ring_of_a_conqueror),R.drawable.illusoryringofaconqueror),
            Modal(getString(R.string.first_dragon_ring),R.drawable.firstdragonring),Modal(getString(R.string.flynns_ring),R.drawable.flynnsring),
            Modal(getString(R.string.dispelling_ring),R.drawable.dispellingring),Modal(getString(R.string.fire_clutch_ring),R.drawable.fireclutchring),
            Modal(getString(R.string.dexterity_ring),R.drawable.dexterityring),Modal(getString(R.string.dispelling_ring),R.drawable.dispellingring),
            Modal(getString(R.string.dark_clutch_ring),R.drawable.darkclutchring),Modal(getString(R.string.delicate_string),R.drawable.delicatestring),
            Modal(getString(R.string.crest_of_the_rat),R.drawable.crestoftherat),Modal(getString(R.string.cursebite_ring),R.drawable.cursebitering),
            Modal(getString(R.string.blue_seal),R.drawable.blueseal),Modal(getString(R.string.crest_of_blood),R.drawable.crestofblood),
            Modal(getString(R.string.bell_keepers_seal),R.drawable.bellkeepersseal),Modal(getString(R.string.bloodbite_ring),R.drawable.bloodbitering),
            Modal(getString(R.string.ancient_dragon_seal),R.drawable.ancientdragonseal),Modal(getString(R.string.baneful_bird_ring),R.drawable.banefulbirdring),
            Modal(getString(R.string.agape_ring),R.drawable.agapering),Modal(getString(R.string.abyss_seal),R.drawable.abyssseal),
            Modal(getString(R.string.royal_soldier_leggings),R.drawable.royalsoldierleggings),Modal(getString(R.string.royal_soldier_gauntlets),R.drawable.royalsoldiergauntlets),
            Modal(getString(R.string.royal_soldier_helmet),R.drawable.royalsoldierhelmet),Modal(getString(R.string.royal_soldier_armor),R.drawable.royalsoldierarmor),
            Modal(getString(R.string.falconer_gloves),R.drawable.falconergloves),Modal(getString(R.string.falconer_boots),R.drawable.falconerboots),
            Modal(getString(R.string.falconer_helm),R.drawable.falconerhelm),Modal(getString(R.string.falconer_armor),R.drawable.falconerarmor),
            Modal(getString(R.string.infantry_gloves),R.drawable.infantrygloves),Modal(getString(R.string.infantry_boots),R.drawable.infantryboots),
            Modal(getString(R.string.hard_leather_boots),R.drawable.hardleatherboots),Modal(getString(R.string.infantry_armor),R.drawable.infantryarmor),
            Modal(getString(R.string.hard_leather_gauntlets),R.drawable.hardleathergauntlets),Modal(getString(R.string.hard_leather_boots),R.drawable.hardleathergauntlets),
            Modal(getString(R.string.hard_leather_armor),R.drawable.hardleatherarmor),Modal(getString(R.string.hard_leather_armor),R.drawable.hardleatherarmor),
            Modal(getString(R.string.heal),R.drawable.heal),Modal(getString(R.string.standard_helm),R.drawable.standardhelm),
            Modal(getString(R.string.soul_arrow),R.drawable.soularrow),Modal(getString(R.string.heal),R.drawable.heal),
            Modal(getString(R.string.targrays_manifers),R.drawable.targraysmanifers),Modal(getString(R.string.targrays_leggings),R.drawable.targraysleggings),
            Modal(getString(R.string.targrays_helm),R.drawable.targrayshelm),Modal(getString(R.string.targrays_armor),R.drawable.targraysarmor),
            Modal(getString(R.string.lenigrasts_key),R.drawable.lenigrastskey),Modal(getString(R.string.lenigrasts_key),R.drawable.lenigrastskey),
            Modal(getString(R.string.hexers_gloves),R.drawable.hexersgloves),Modal(getString(R.string.hexers_boots),R.drawable.hexersboots),
            Modal(getString(R.string.hexers_hood),R.drawable.hexershood),Modal(getString(R.string.hexers_robes),R.drawable.hexersrobes),
            Modal(getString(R.string.saints_long_gloves),R.drawable.saintslonggloves),Modal(getString(R.string.saints_trousers),R.drawable.saintstrousers),
            Modal(getString(R.string.saints_hood),R.drawable.saintshood),Modal(getString(R.string.saints_dress),R.drawable.saintsdress),
            Modal(getString(R.string.creightons_chain_gloves),R.drawable.creightonschaingloves),Modal(getString(R.string.creightons_chain_leggins),R.drawable.creightonschainleggings),
            Modal(getString(R.string.lucatiels_trousers),R.drawable.lucatielstrousers),Modal(getString(R.string.creightons_chainmail),R.drawable.creightonschainmail),
            Modal(getString(R.string.lucatiels_vest),R.drawable.lucatielsvest),Modal(getString(R.string.lucatiels_gloves),R.drawable.lucatielsgloves),
            Modal(getString(R.string.cales_leather_armor),R.drawable.calesleatherarmor),Modal(getString(R.string.cales_shoes),R.drawable.calesshoes),
            Modal(getString(R.string.pates_set),R.drawable.patesset),Modal(getString(R.string.benharts_set),R.drawable.benhartsset),
            Modal(getString(R.string.darkdrift),R.drawable.darkdrift),Modal(getString(R.string.traveling_merchant_set),R.drawable.travelingmerchantset),
            Modal(getString(R.string.scythe_of_nahr_alma),R.drawable.scytheofnahralma),Modal(getString(R.string.mirrah_greatsword),R.drawable.mirrahgreatsword),
            Modal(getString(R.string.flying_feline_boots),R.drawable.flyingfelineboots),Modal(getString(R.string.club),R.drawable.club),
            Modal(getString(R.string.rampart_golem_shield),R.drawable.rampartgolemshieldframe),Modal(getString(R.string.vessel_shield),R.drawable.vesselshieldframe),
            Modal(getString(R.string.reeves_greatshield),R.drawable.reevesgreatshieldframe),Modal(getString(R.string.charred_loyce_shield),R.drawable.charredloyceshieldframe),
            Modal(getString(R.string.pates_shield),R.drawable.patesshieldframe),Modal(getString(R.string.pursuers_greatshield),R.drawable.pursuersgreatshieldframe),
            Modal(getString(R.string.mastodon_greatshield),R.drawable.mastodongreatshieldframe),Modal(getString(R.string.ormas_greatshield),R.drawable.ormasgreatshieldframe),
            Modal(getString(R.string.havels_greatshield),R.drawable.havelsgreatshieldframe),Modal(getString(R.string.kings_mirror),R.drawable.kingsmirrorframe),
            Modal(getString(R.string.greatshield_of_glory),R.drawable.greatshieldofgloryframe),Modal(getString(R.string.gyrm_greatshield),R.drawable.gyrmgreatshieldframe),
            Modal(getString(R.string.ring_of_whispers),R.drawable.ringofwhispers),Modal(getString(R.string.dragonrider_greatshield),R.drawable.dragonridergreatshieldframe),
            Modal(getString(R.string.redeye_ring),R.drawable.redeyering),Modal(getString(R.string.nameengraved_ring),R.drawable.nameengravedring),
            Modal(getString(R.string.wood_arrow),R.drawable.woodarrow),Modal(getString(R.string.silvercat_ring),R.drawable.silvercatring),
            Modal(getString(R.string.battle_axe),R.drawable.battleaxe),Modal(getString(R.string.spear),R.drawable.spear),
            Modal(getString(R.string.alonne_greatbow),R.drawable.alonnegreatbow),Modal(getString(R.string.rapier),R.drawable.rapier),
            Modal(getString(R.string.blacksmiths_hammer),R.drawable.blacksmithshammer),Modal(getString(R.string.caestus),R.drawable.caestus),
            Modal(getString(R.string.demons_great_hammer),R.drawable.demonsgreathammer),Modal(getString(R.string.aged_feather),R.drawable.agedfeather),
            Modal(getString(R.string.yellow_quartz_shield),R.drawable.yellowquartzshieldframe),Modal(getString(R.string.handmaids_ladle),R.drawable.handmaidsladle),
            Modal(getString(R.string.stone_parma),R.drawable.stoneparmaframe),Modal(getString(R.string.wooden_shield),R.drawable.woodenshield),
            Modal(getString(R.string.slumbering_dragon_shield),R.drawable.slumberingdragonshieldframe),Modal(getString(R.string.spirit_tree_shield),R.drawable.spirittreeshieldframe),
            Modal(getString(R.string.silver_eagle_kite_shield),R.drawable.silvereaglekiteshieldframe),Modal(getString(R.string.silverblack_shield),R.drawable.silverblackshieldframe),
            Modal(getString(R.string.royal_kite_shield),R.drawable.royalkiteshieldframe),Modal(getString(R.string.shield_of_the_insolent),R.drawable.shieldoftheinsolentframe),
            Modal(getString(R.string.porcine_shield),R.drawable.porcineshieldframe),Modal(getString(R.string.red_rust_shield),R.drawable.redrustshieldframe),
            Modal(getString(R.string.moon_butterfly_shield),R.drawable.moonbutterflyshieldframe),Modal(getString(R.string.old_knight_shield),R.drawable.oldknightsshieldframe),
            Modal(getString(R.string.lion_clan_shield),R.drawable.lionclanshieldframe),Modal(getString(R.string.loyce_shield),R.drawable.loyceshieldframe),
            Modal(getString(R.string.homunculus_wooden_shield),R.drawable.homunculuswoodenshieldframe),Modal(getString(R.string.kings_shield),R.drawable.kingsshieldframe),
            Modal(getString(R.string.grand_spirit_tree_shield),R.drawable.grandspirittreeshieldframe),Modal(getString(R.string.hollow_soldier_shield),R.drawable.hollowsoldiershieldframe),
            Modal(getString(R.string.drangleic_shield),R.drawable.drangleicshieldframe),Modal(getString(R.string.golden_wing_shield),R.drawable.goldenwingshieldframe),
            Modal(getString(R.string.defenders_shield),R.drawable.defendersshieldframe),Modal(getString(R.string.drakekeepers_shield),R.drawable.drakekeepersshieldframe),
            Modal(getString(R.string.bound_wooden_shield),R.drawable.boundwoodenshieldframe),Modal(getString(R.string.chaos_shield),R.drawable.chaosshieldframe),
            Modal(getString(R.string.black_flamestone_parma),R.drawable.blackflamestoneparmaframe),Modal(getString(R.string.bone_shield),R.drawable.boneshieldframe),
            Modal(getString(R.string.bell_keeper_shield),R.drawable.bellkeepershieldframe),Modal(getString(R.string.black_dragon_shield),R.drawable.blackdragonshieldframe),
            Modal(getString(R.string.varangian_shield),R.drawable.varangianshieldframe),Modal(getString(R.string.watchers_shield),R.drawable.watchersshieldframe),
            Modal(getString(R.string.transgressors_leather_shield),R.drawable.transgressorsleathershieldframe),Modal(getString(R.string.xanthous_gloves),R.drawable.xanthousgloves),
            Modal(getString(R.string.manikin_shield),R.drawable.manikinshieldframe),Modal(getString(R.string.sunlight_parma),R.drawable.sunlightparmaframe),
            Modal(getString(R.string.llewellyn_shield),R.drawable.llewellynshieldframe),Modal(getString(R.string.magic_shield),R.drawable.magicshieldframe),
            Modal(getString(R.string.golden_falcon_shield),R.drawable.goldenfalconshieldframe),Modal(getString(R.string.iron_parma),R.drawable.ironparmaframe),
            Modal(getString(R.string.benharts_parma),R.drawable.benhartsparmaframe),Modal(getString(R.string.cursed_bone_shield),R.drawable.cursedboneshieldframe),
            Modal(getString(R.string.twin_dragon_greatshield),R.drawable.twindragongreatshieldframe),Modal(getString(R.string.sanctum_shield),R.drawable.sanctumshieldframe),
            Modal(getString(R.string.dragonriders_halberd),R.drawable.dragonridershalberd),Modal(getString(R.string.crescent_sickle),R.drawable.crescentsickle),
            Modal(getString(R.string.great_axes),R.drawable.greataxe),Modal(getString(R.string.homunculus_mace),R.drawable.homunculusmace),
            Modal(getString(R.string.murakumo),R.drawable.murakumo),Modal(getString(R.string.estoc),R.drawable.estoc),
            Modal(getString(R.string.pursuer_ultra_greatsword),R.drawable.pursuersultragreatsword),Modal(getString(R.string.uchigatana),R.drawable.uchigatana),
            Modal(getString(R.string.blue_dagger),R.drawable.bluedagger),Modal(getString(R.string.retainers_short_sword),R.drawable.retainersshortsword),
            Modal(getString(R.string.manikin_knife),R.drawable.manikinknife),Modal(getString(R.string.umbral_dagger),R.drawable.umbraldagger),
            Modal(getString(R.string.thief_dagger),R.drawable.thiefdagger),Modal(getString(R.string.broken_thief_sword),R.drawable.brokenthiefsword),
            Modal(getString(R.string.mythas_bent_blade),R.drawable.mythasbentblade), Modal(getString(R.string.shadow_dagger),R.drawable.shadowdagger),
            Modal(getString(R.string.royal_dirk),R.drawable.royaldirk), Modal(getString(R.string.black_flamestone_dagger),R.drawable.blackflamestonedagger),
            Modal(getString(R.string.throne_defender_soul),R.drawable.defendersoul), Modal(getString(R.string.soul_of_nashandra),R.drawable.soulofnashandra),
            Modal(getString(R.string.giants_kinship),R.drawable.giantskinship), Modal(getString(R.string.throne_watcher_soul),R.drawable.defendersoul),
            Modal(getString(R.string.soul_of_the_dukes_dear_freja),R.drawable.bosssoul), Modal(getString(R.string.old_paledrake_soul),R.drawable.oldsoul),
            Modal(getString(R.string.demon_of_song_soul),R.drawable.bosssoul), Modal(getString(R.string.soul_of_velstadt),R.drawable.defendersoul),
            Modal(getString(R.string.guardian_dragon_soul),R.drawable.bosssoul), Modal(getString(R.string.looking_glass_knight_soul),R.drawable.bosssoul),
            Modal(getString(R.string.scorpioness_najka_soul),R.drawable.bosssoul), Modal(getString(R.string.royal_rat_authority_suol),R.drawable.bosssoul),
            Modal(getString(R.string.soul_of_the_rotten),R.drawable.souloftheking), Modal(getString(R.string.old_dead_ones_soul),R.drawable.oldsoul),
            Modal(getString(R.string.old_king_soul),R.drawable.oldsoul), Modal(getString(R.string.royal_rat_vanguard_soul),R.drawable.bosssoul),
            Modal(getString(R.string.smelter_demon_soul),R.drawable.bosssoul), Modal(getString(R.string.old_iron_king_soul),R.drawable.souloftheking),
            Modal(getString(R.string.covetous_demon_soul),R.drawable.bosssoul), Modal(getString(R.string.mytha_the_baneful_queen_soul),R.drawable.bosssoul),
            Modal(getString(R.string.skeleton_lords_soul),R.drawable.bosssoul), Modal(getString(R.string.executioners_chariot_soul),R.drawable.bosssoul),
            Modal(getString(R.string.old_witch_soul),R.drawable.oldsoul), Modal(getString(R.string.ruin_sentinels_soul),R.drawable.bosssoul),
            Modal(getString(R.string.belfry_gargoyles_soul),R.drawable.bosssoul), Modal(getString(R.string.soul_of_the_lost_sinner),R.drawable.souloftheking),
            Modal(getString(R.string.flexile_sentry_soul),R.drawable.bosssoul), Modal(getString(R.string.awestone),R.drawable.awestone),
            Modal(getString(R.string.dragonrider_soul),R.drawable.bosssoul),Modal(getString(R.string.old_leo_ring),R.drawable.oldleoring),
            Modal(getString(R.string.old_dragonslayer_soul),R.drawable.bosssoul),Modal(getString(R.string.soul_of_the_last_giant),R.drawable.bosssoul),
            Modal(getString(R.string.soul_of_the_pursuer),R.drawable.bosssoul),Modal(getString(R.string.ring_of_blades),R.drawable.ringofblades),
            Modal(getString(R.string.third_dragon_ring),R.drawable.thirddragonring), Modal(getString(R.string.black_dragon_greataxe),R.drawable.blackdragongreataxe),
            Modal(getString(R.string.drakekeppers_great_axe),R.drawable.drakekeppersgreataxe), Modal(getString(R.string.drakekeepers_greatshield),R.drawable.drakekeepersgreatshieldframe),
            Modal(getString(R.string.ashen_mist_heart),R.drawable.ashenmistheart), Modal(getString(R.string.petrified_egg),R.drawable.petrifiedegg),
            Modal(getString(R.string.crystal_magic_weapon),R.drawable.crystalmagicweapon),Modal(getString(R.string.dragon_tooth),R.drawable.dragontooth),
            Modal(getString(R.string.boltstone),R.drawable.boltstone),Modal(getString(R.string.malformed_skull),R.drawable.malformedskull),
            Modal(getString(R.string.malformed_shell),R.drawable.malformedshell),Modal(getString(R.string.soul_geyser),R.drawable.soulgeyser),
            Modal(getString(R.string.aldia_key),R.drawable.aldiakey),Modal(getString(R.string.great_magic_barrier),R.drawable.greatmagicbarrier),
            Modal(getString(R.string.mace_of_the_insolent),R.drawable.maceoftheinsolent), Modal(getString(R.string.olenfords_staff),R.drawable.olenfordsstaff),
            Modal(getString(R.string.great_lightning_spears),R.drawable.greatlightningspear), Modal(getString(R.string.avelyn),R.drawable.avelyn),
            Modal(getString(R.string.darknight_stone),R.drawable.darknightstone),Modal(getString(R.string.magic_stone),R.drawable.magicstone),
            Modal(getString(R.string.human_effigy),R.drawable.humaneffigy),Modal(getString(R.string.estus_flask_shard),R.drawable.estusflaskshard),
            Modal(getString(R.string.amber_herb),R.drawable.amberherb),Modal(getString(R.string.cracked_red_eye_orb),R.drawable.crackedredeyeorb),
            Modal(getString(R.string.life_gem),R.drawable.lifegem),Modal(getString(R.string.rusted_coin),R.drawable.rustedcoin),
            Modal(getString(R.string.small_smooth_silky_stone),R.drawable.smallsmoothandsilkystone),Modal(getString(R.string.soul_of_a_lost_undead),R.drawable.soulofalostundead),
            Modal(getString(R.string.soul_of_a_name_less_soldier),R.drawable.soulofanamelesssoldier),Modal(getString(R.string.torch),R.drawable.torch),
            Modal(getString(R.string.petrified_something),R.drawable.petrifiedsomething),Modal(getString(R.string.gold_pine_resin),R.drawable.goldpineresin),
            Modal(getString(R.string.stone_ring),R.drawable.stonering),Modal(getString(R.string.dagger),R.drawable.dagger),
            Modal(getString(R.string.estus_flask),R.drawable.estusflask),Modal(getString(R.string.titanite_shard),R.drawable.titaniteshard),
            Modal(getString(R.string.divine_blessing),R.drawable.divineblessing),Modal(getString(R.string.homeward_bone),R.drawable.homewardbone),
            Modal(getString(R.string.lloyds_talisman),R.drawable.lloydstalisman),Modal(getString(R.string.soul_vessel),R.drawable.soulvessel),
            Modal(getString(R.string.pharros_lockstone),R.drawable.pharroslockstone),Modal(getString(R.string.radiant_life_gem),R.drawable.radiantlifegem),
            Modal(getString(R.string.poison_moss),R.drawable.poisonmoss),Modal(getString(R.string.clerics_sacred_chime),R.drawable.clericssacredchime),
            Modal(getString(R.string.crimson_parma),R.drawable.crimsonparmaframe),Modal(getString(R.string.ring_of_the_evil_eye),R.drawable.ringoftheevileye),
            Modal(getString(R.string.morning_star),R.drawable.morningstar),Modal(getString(R.string.binoculars),R.drawable.binoculars),
            Modal(getString(R.string.short_bow),R.drawable.shortbow),Modal(getString(R.string.broken_thief_sword),R.drawable.brokenstraightsword),
            Modal(getString(R.string.ring_of_the_steel_protection),R.drawable.ringofthesteelprotection),Modal(getString(R.string.aromatic_ooze),R.drawable.aromaticooze),
            Modal(getString(R.string.buckler),R.drawable.bucklerframe),Modal(getString(R.string.fire_arrow),R.drawable.firearrow),
            Modal(getString(R.string.firedrake_stone),R.drawable.firedrakestone),Modal(getString(R.string.great_soul_arrow),R.drawable.greatsoularrow),
            Modal(getString(R.string.green_blossom),R.drawable.greenblossom),Modal(getString(R.string.halberd),R.drawable.halberd),
            Modal(getString(R.string.large_soul_of_a_lost_undead),R.drawable.largesoulofalostundead),Modal(getString(R.string.large_titanite_shard),R.drawable.largetitaniteshard),
            Modal(getString(R.string.old_radiant_life_gem),R.drawable.oldradiantlifegem),Modal(getString(R.string.repair_powder),R.drawable.repairpowder),
            Modal(getString(R.string.seed_of_a_tree_of_giants),R.drawable.seedofatreeofgiants),Modal(getString(R.string.small_white_sign_soapstone),R.drawable.smallwhitesignsoapstone),
            Modal(getString(R.string.soul_of_a_proud_knight),R.drawable.soulofaproudknight),Modal(getString(R.string.titanite_slab),R.drawable.titaniteslab),
            Modal(getString(R.string.titanite_chunk),R.drawable.titanitechunk),Modal(getString(R.string.throwing_knife),R.drawable.throwingknife),
            Modal(getString(R.string.twinkling_titanite),R.drawable.twinklingtitanite),Modal(getString(R.string.white_sign_soapstone),R.drawable.whitesignsoapstone),
            Modal(getString(R.string.witching_urn),R.drawable.witchingurn),Modal(getString(R.string.wood_bolt),R.drawable.woodbolt),
            Modal(getString(R.string.black_firebomb),R.drawable.blackfirebomb),Modal(getString(R.string.large_soul_of_a_proud_knight),R.drawable.largesoulofaproudknight),
            Modal(getString(R.string.heavy_iron_key),R.drawable.heavyironkey),Modal(getString(R.string.foot_soldier_shield),R.drawable.footsoldiershieldframe),
            Modal(getString(R.string.grand_lance),R.drawable.grandlance),Modal(getString(R.string.life_ring),R.drawable.lifering),
            Modal(getString(R.string.light_crossbow),R.drawable.lightcrossbow),Modal(getString(R.string.mail_breker),R.drawable.mailbreker),
            Modal(getString(R.string.ring_of_the_restoration),R.drawable.ringoftherestoration),Modal(getString(R.string.soldier_key),R.drawable.soldierkey),
            Modal(getString(R.string.long_sword),R.drawable.longsword),Modal(getString(R.string.bastard_sword),R.drawable.bastardsword),
            Modal(getString(R.string.blue_wooden_shield),R.drawable.bluewoodenshieldframe),Modal(getString(R.string.whip),R.drawable.whip),
            Modal(getString(R.string.rebels_greats_shield),R.drawable.rebelsgreatshieldframe),Modal(getString(R.string.large_leather_shield),R.drawable.largeleathershieldframe),
            Modal(getString(R.string.chloranthy_ring),R.drawable.chloranthyring),Modal(getString(R.string.hand_axe),R.drawable.handaxe),
            Modal(getString(R.string.shortsword),R.drawable.shortsword),Modal(getString(R.string.small_leather_shield),R.drawable.smallleathershieldframe),
            Modal(getString(R.string.hawk_ring),R.drawable.hawkring),Modal(getString(R.string.clerics_small_shield),R.drawable.clericsmallshield),
            Modal(getString(R.string.flame_quartz_ring),R.drawable.flamequartzring),Modal(getString(R.string.sublime_bone_dust),R.drawable.sublimebonedust),
            Modal(getString(R.string.dark_troches),R.drawable.darktroches),Modal(getString(R.string.petrified_dragon_bone),R.drawable.petrifieddragonbone),
            Modal(getString(R.string.monastery_charm),R.drawable.monasterycharm), Modal(getString(R.string.ring_of_binding),R.drawable.ringofbinding),
            Modal(getString(R.string.old_knight_halberd),R.drawable.oldknighthalberd),Modal(getString(R.string.watchdragon_parma),R.drawable.watchdragonparmaframe),
            Modal(getString(R.string.cracked_blue_eye_orb),R.drawable.crackedblueeyeorb),Modal(getString(R.string.tower_shield),R.drawable.towershieldframe),
            Modal(getString(R.string.clerics_parma),R.drawable.clericsparmaframe),Modal(getString(R.string.great_sword),R.drawable.greatsword),
            Modal(getString(R.string.royal_soldiers_ring),R.drawable.royalsoldiersring),Modal(getString(R.string.bandit_axe),R.drawable.banditaxe),
            Modal(getString(R.string.pyromancy_flame),R.drawable.pyromancyflame),Modal(getString(R.string.emit_force),R.drawable.emitforce),
            Modal(getString(R.string.fireball),R.drawable.fireball),Modal(getString(R.string.fire_bomb),R.drawable.firebomb),
            Modal(getString(R.string.flame_butterfly),R.drawable.flamebutterfly),Modal(getString(R.string.fragrant_branch_of_yore),R.drawable.fragrantbranchofyore),
            Modal(getString(R.string.fading_soul),R.drawable.fadingsoul),Modal(getString(R.string.large_soul_of_a_nameless_soldier),R.drawable.largesoulofanamelesssoldier),
            Modal(getString(R.string.iron_arrow),R.drawable.ironarrow),Modal(getString(R.string.dark_pine_resin),R.drawable.darkpineresin),
            Modal(getString(R.string.silver_talisman),R.drawable.silvertalisman),Modal(getString(R.string.dullember),R.drawable.dullember),
            Modal(getString(R.string.alluring_skull),R.drawable.alluringskull),Modal(getString(R.string.soul_of_a_breave_warrior),R.drawable.soulofabravewarrior),
            Modal(getString(R.string.heavy_bolt),R.drawable.heavybolt),Modal(getString(R.string.hush),R.drawable.hush),
            Modal(getString(R.string.rouge_water),R.drawable.rougewater),Modal(getString(R.string.antiquated_key),R.drawable.antiquatedkey),
            Modal(getString(R.string.bonfire_ascetic),R.drawable.bonfireascetic),Modal(getString(R.string.large_club),R.drawable.largeclub),
            Modal(getString(R.string.target_shield),R.drawable.targetshieldframe),Modal(getString(R.string.scimitar),R.drawable.scimitar),
            Modal(getString(R.string.craftsmans_hammer),R.drawable.craftsmanshammer),Modal(getString(R.string.covetous_silver_serpent_ring),R.drawable.covetoussilverserpentring),
            Modal(getString(R.string.archdrake_shield),R.drawable.archdrakeshieldframe),Modal(getString(R.string.bone_staff),R.drawable.bonestaff),
            Modal(getString(R.string.parrying_dagger),R.drawable.parryingdagger),Modal(getString(R.string.twinblade),R.drawable.twinblade),
            Modal(getString(R.string.priest_schime),R.drawable.priestschime),Modal(getString(R.string.bracing_knuckle_ring),R.drawable.bracingknucklering),
            Modal(getString(R.string.skeptics_spice),R.drawable.skepticsspice),Modal(getString(R.string.twilight_herb),R.drawable.twilightherb),
            Modal(getString(R.string.brightbug),R.drawable.brightbug),Modal(getString(R.string.blue_tearstone_ring),R.drawable.bluetearstonering),
            Modal(getString(R.string.southern_ritual_band),R.drawable.southernritual), Modal(getString(R.string.dragon_tooth),R.drawable.dragontooth),
            Modal(getString(R.string.falchion),R.drawable.falchion),Modal(getString(R.string.elizabeth_mushroom),R.drawable.elizabethmushroom),
            Modal(getString(R.string.bleed_stone),R.drawable.bleedstone),Modal(getString(R.string.fire_seed),R.drawable.fireseed),
            Modal(getString(R.string.northern_ritual_band),R.drawable.northernritualband),Modal(getString(R.string.blossom_kite_shield),R.drawable.blossomkiteshieldframe),
            Modal(getString(R.string.bandits_knife),R.drawable.banditsknife),Modal(getString(R.string.token_of_fidelity),R.drawable.tokenoffidelity),
            Modal(getString(R.string.undead_lockaway_key),R.drawable.undeadlockawaykey),Modal(getString(R.string.poison_throwing_knife),R.drawable.poisonthrowingknife),
            Modal(getString(R.string.flamberge),R.drawable.flamberge),Modal(getString(R.string.combustion),R.drawable.combustion),
            Modal(getString(R.string.ricards_rapier),R.drawable.ricardsrapier),Modal(getString(R.string.notched_whip),R.drawable.notchedwhip),
            Modal(getString(R.string.soul_spear),R.drawable.soulspear),Modal(getString(R.string.mace),R.drawable.mace),
            Modal(getString(R.string.raw_stone),R.drawable.rawstone), Modal(getString(R.string.hexing_urn),R.drawable.hexingurn),
            Modal(getString(R.string.simpletons_spice),R.drawable.simpletonsspice),Modal(getString(R.string.poison_stone),R.drawable.poisonstone),
            Modal(getString(R.string.rotten_pine_resin),R.drawable.rottenpineresin), Modal(getString(R.string.old_knight_pike),R.drawable.oldknightpike),
            Modal(getString(R.string.old_knight_greatshield),R.drawable.oldknightgreatshieldframe), Modal(getString(R.string.chameleon),R.drawable.chameleon),
            Modal(getString(R.string.washin_pole),R.drawable.washinpole), Modal(getString(R.string.dragon_charm),R.drawable.dragoncharm),
            Modal(getString(R.string.broadsword),R.drawable.broadsword), Modal(getString(R.string.poisonbite_ring),R.drawable.poisonbitering),
            Modal(getString(R.string.mirrah_shield),R.drawable.mirrahshieldframe),Modal(getString(R.string.heavy_crossbow),R.drawable.heavycrossbow),
            Modal(getString(R.string.lightning_spear),R.drawable.lightningspear),Modal(getString(R.string.great_heavy_soul_arrow),R.drawable.greatheavysoularrow),
            Modal(getString(R.string.iron_key),R.drawable.ironkey),Modal(getString(R.string.winged_spear),R.drawable.wingedspear),
            Modal(getString(R.string.destructive_great_arrow),R.drawable.destructivegreatarrow),Modal(getString(R.string.porcine_shield),R.drawable.porcineshieldframe),
            Modal(getString(R.string.black_knight_greataxe),R.drawable.blackknightgreataxe),Modal(getString(R.string.covetous_gold_serpent_ring),R.drawable.covetousgoldserpentring),
            Modal(getString(R.string.zweihander),R.drawable.zweihander),Modal(getString(R.string.phoenix_parma),R.drawable.phoenixparmaframe),
            Modal(getString(R.string.immolation),R.drawable.immolation),Modal(getString(R.string.soul_vortex),R.drawable.soulvortex),
            Modal(getString(R.string.warmth),R.drawable.warmth), Modal(getString(R.string.whisper_despair),R.drawable.whisperdespair),
            Modal(getString(R.string.ash_knuckle_ring),R.drawable.ashknucklering), Modal(getString(R.string.dark_pyromancy_flame),R.drawable.darkpyromancyflame),
            Modal(getString(R.string.dark_fog),R.drawable.darkfog),Modal(getString(R.string.forgotten_key),R.drawable.forgottenkey),
            Modal(getString(R.string.great_club),R.drawable.greatclub),Modal(getString(R.string.wicked_eye_greatshield),R.drawable.wickedeyegreatshield),
            Modal(getString(R.string.ring_of_the_soul_protection),R.drawable.ringofthesoulprotection),Modal(getString(R.string.heide_lance),R.drawable.heidelance),
            Modal(getString(R.string.great_magic_weapon),R.drawable.greatmagicweapon),Modal(getString(R.string.scraps_of_life),R.drawable.scrapsoflife),
            Modal(getString(R.string.soul_of_a_giant),R.drawable.soulofagiant),Modal(getString(R.string.ring_of_giants),R.drawable.ringofgiants),
            Modal(getString(R.string.homing_soul_mass),R.drawable.homingsoulmass),Modal(getString(R.string.repair),R.drawable.repair),
            Modal(getString(R.string.old_sun_ring),R.drawable.oldsunring),Modal(getString(R.string.clear_bluestone_ring),R.drawable.clearbluestonering),
            Modal(getString(R.string.red_tearstone_ring),R.drawable.redtearstonering),Modal(getString(R.string.ring_of_life_protection),R.drawable.ringoflifeprotection),
            Modal(getString(R.string.dragonslayers_crescent_axe),R.drawable.dragonslayerscrescentaxe),Modal(getString(R.string.black_knight_halberd),R.drawable.blackknighthalberd),
            Modal(getString(R.string.scythe),R.drawable.scythe),Modal(getString(R.string.twisted_barricade),R.drawable.twistedbarricade),
            Modal(getString(R.string.large_soul_of_a_brave_warrior),R.drawable.largesoulofabravewarrior),Modal(getString(R.string.rat_tail),R.drawable.rattail),
            Modal(getString(R.string.prism_stone),R.drawable.prismstone),Modal(getString(R.string.santiers_spear),R.drawable.santiersspear),
            Modal(getString(R.string.gyrm_axe),R.drawable.gyrmaxe),Modal(getString(R.string.gyrm_great_hammer),R.drawable.gyrmgreathammer),
            Modal(getString(R.string.staff_of_wisdom),R.drawable.staffofwisdom),Modal(getString(R.string.great_fireball),R.drawable.greatfireball),
            Modal(getString(R.string.lacerating_arrow),R.drawable.laceratingarrow),Modal(getString(R.string.black_knight_ultra_greatsword),R.drawable.blackknightultragreatsword),
            Modal(getString(R.string.faint_stone),R.drawable.faintstone),Modal(getString(R.string.crescent_axe),R.drawable.crescentaxe),
            Modal(getString(R.string.pick_axe),R.drawable.pickaxe),Modal(getString(R.string.dark_quartz_ring),R.drawable.darkquartzring),
            Modal(getString(R.string.brightstone_key),R.drawable.brightstonekey),Modal(getString(R.string.holy_water_urn),R.drawable.holywaterurn),
            Modal(getString(R.string.frozen_flower),R.drawable.frozenflower),Modal(getString(R.string.great_combustion),R.drawable.greatcombustion),
            Modal(getString(R.string.fire_storm),R.drawable.firestorm),Modal(getString(R.string.strong_magic_shield),R.drawable.strongmagicshield),
            Modal(getString(R.string.hunters_black_bow),R.drawable.huntersblackbow),Modal(getString(R.string.soul_of_a_hero),R.drawable.soulofahero),
            Modal(getString(R.string.corrosive_urn),R.drawable.corrosiveurn),Modal(getString(R.string.caithas_chime),R.drawable.caithaschime),
            Modal(getString(R.string.gowers_ring_of_protection),R.drawable.gowersringofprotection),Modal(getString(R.string.stone_soldier_spear),R.drawable.stonesoldierspear),
            Modal(getString(R.string.stone_twinblade),R.drawable.stonetwinblade),Modal(getString(R.string.soul_greatsword),R.drawable.soulgreatsword),
            Modal(getString(R.string.spell_quartz_ring),R.drawable.spellquartzring),Modal(getString(R.string.wilted_dusk_herb),R.drawable.wiltedduskherb),
            Modal(getString(R.string.crimson_water),R.drawable.crimsonwater),Modal(getString(R.string.sunlight_blade),R.drawable.sunlightblade),
            Modal(getString(R.string.soul_of_the_king),R.drawable.souloftheking),Modal(getString(R.string.fire_tempest),R.drawable.firetempest),
            Modal(getString(R.string.homing_crystal_soulmass),R.drawable.homingcrystalsoulmass),Modal(getString(R.string.key_to_the_embedded),R.drawable.keytotheembedded),
            Modal(getString(R.string.magic_arrow),R.drawable.magicarrow),Modal(getString(R.string.manslayer),R.drawable.manslayer),
            Modal(getString(R.string.helix_halberd),R.drawable.helixhalberd),Modal(getString(R.string.red_iron_twinblade),R.drawable.redirontwinblade),
            Modal(getString(R.string.soul_of_a_great_hero),R.drawable.soulofagreathero),Modal(getString(R.string.crushed_eye_orb),R.drawable.crushedeyeorb),
            Modal(getString(R.string.dried_fingers),R.drawable.driedfingers),Modal(getString(R.string.shotel),R.drawable.shotel)
        )

        for (items in imagesNameItems.indices) if (modalList.size < 1163) modalList.add(Modal(imagesNameItems[items].item.toString(),imagesNameItems[items].image!!))

        itemsAdapterItems = ItemsAdapterItems(this.requireContext(),this)
        itemsAdapterItems?.setData(modalList)


        val imagesNameBosses = arrayOf(
            ItemsModalBosses(getString(R.string.pursuer),"3110",getString(R.string.lightning)+", "+getString(R.string.dark_mist)+", "+getString(R.string.poison_toxic),getString(R.string.physical),R.drawable.pursuer),
            ItemsModalBosses(getString(R.string.the_last_giant),"2530","??","??",R.drawable.thelastgiant),
            ItemsModalBosses(getString(R.string.dragonrider),"3050","??","??",R.drawable.dragonrider),
            ItemsModalBosses(getString(R.string.old_dragonslayer),"2880",getString(R.string.poison_toxic)+" ,"+getString(R.string.fire),"??",R.drawable.olddragonslayer),
            ItemsModalBosses(getString(R.string.flexile_sentry),"3150",getString(R.string.lightning),getString(R.string.fire),R.drawable.flexilesentry),
            ItemsModalBosses(getString(R.string.belfry_gargoyles),"1400x5",getString(R.string.lightning),getString(R.string.physical),R.drawable.bellfrygargoyles),
            ItemsModalBosses(getString(R.string.lost_sinner),"3560",getString(R.string.magic),getString(R.string.fire)+" ,"+ getString(R.string.lightning)+" ,"+getString(R.string.dark),R.drawable.lostsinner),
            ItemsModalBosses(getString(R.string.ruin_sentinels),"2330",getString(R.string.poison_toxic)+", "+getString(R.string.lightning)+", "+getString(R.string.fire),getString(R.string.dark_mist)+", "+getString(R.string.slash),R.drawable.ruinsentinels),
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
        for (items in imagesNameBosses) if (itemModalListBosses.size < 30) itemModalListBosses.add(items)


        itemsAdapterBosses = ItemsAdapterBosses(this)
        itemsAdapterBosses?.setData(itemModalListBosses)
        binding.recyclerViewBossesBrowser.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerViewBossesBrowser.setHasFixedSize(true)
        if (itemModalListBosses.size > 1) binding.recyclerViewBossesBrowser.isVisible = true
        val imagesNameLocations = arrayOf(
            ItemsModalLocations(getString(R.string.things_betwixt),getString(R.string.majula),"0","1",R.drawable.thingsbetwixt),
            ItemsModalLocations(getString(R.string.majula),getString(R.string.forest_of_fallen_giants),"0","1",R.drawable.majula),
            ItemsModalLocations(getString(R.string.forest_of_fallen_giants),getString(R.string.heides_tower_of_flame)+", " + getString(R.string.memories_of_the_giants),getString(R.string.pursuer)+", "+getString(R.string.the_last_giant),"4",R.drawable.forestoffallengiants),
            ItemsModalLocations(getString(R.string.heides_tower_of_flame),getString(R.string.cathedral_of_blue)+", "+getString(R.string.no_mans_wharf),getString(R.string.dragonrider),"2",R.drawable.heidetowerofflame),
            ItemsModalLocations(getString(R.string.cathedral_of_blue),getString(R.string.no_mans_wharf),getString(R.string.old_dragonslayer),"1",R.drawable.cathedralofblue),
            ItemsModalLocations(getString(R.string.no_mans_wharf),getString(R.string.lost_bastille),getString(R.string.flexile_sentry),"1",R.drawable.nomanswharf),
            ItemsModalLocations(getString(R.string.lost_bastille),getString(R.string.ruin_sentinels),getString(R.string.belfry_gargoyles),"1",R.drawable.lostbastille),
            ItemsModalLocations(getString(R.string.belfry_luna),getString(R.string.sinners_rise),getString(R.string.belfry_gargoyles),"1",R.drawable.belfryluna),
            ItemsModalLocations(getString(R.string.sinners_rise),getString(R.string.huntsmans_copse),getString(R.string.lost_sinner),"0",R.drawable.sinnersrise),
            ItemsModalLocations(getString(R.string.huntsmans_copse),getString(R.string.undead_purgatory)+", "+getString(R.string.harvest_valley),"0","2",R.drawable.huntsmanscopse),
            ItemsModalLocations(getString(R.string.undead_purgatory), getString(R.string.harvest_valley),getString(R.string.executioners_chariot),"1",R.drawable.undeadpurgatory),
            ItemsModalLocations(getString(R.string.harvest_valley),getString(R.string.earthen_peak),"0","2",R.drawable.harvestvalley),
            ItemsModalLocations(getString(R.string.earthen_peak),getString(R.string.iron_keep),getString(R.string.covetous_demon)+", "+getString(R.string.mytha_the_baneful_queen),"3",R.drawable.earthenpeak),
            ItemsModalLocations(getString(R.string.iron_keep),getString(R.string.belfry_sol),getString(R.string.smelter_demon)+", "+getString(R.string.pursuer)+", "+getString(R.string.old_iron_king),"3",R.drawable.ironkeep),
            ItemsModalLocations(getString(R.string.belfry_sol),getString(R.string.grave_of_saints),"0","1",R.drawable.belfrysol),
            ItemsModalLocations(getString(R.string.the_pit),getString(R.string.grave_of_saints),"0","0",R.drawable.thepit),
            ItemsModalLocations(getString(R.string.grave_of_saints),getString(R.string.the_gutter),getString(R.string.royal_rat_vanguard),"2",R.drawable.graveofsaints),
            ItemsModalLocations(getString(R.string.the_gutter),getString(R.string.black_gulch),"0","2",R.drawable.thegutter),
            ItemsModalLocations(getString(R.string.black_gulch),getString(R.string.shaded_woods),getString(R.string.the_rotten),"2",R.drawable.theblackgulch),
            ItemsModalLocations(getString(R.string.shaded_woods),getString(R.string.shrine_of_winter)+", "+getString(R.string.doors_of_pharros),getString(R.string.scorpioness_najka),"3",R.drawable.shadedwoods),
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
        binding.recyclerViewLocationsBrowser.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerViewLocationsBrowser.setHasFixedSize(true)
        if(itemModalListLocations.size > 1) binding.recyclerViewLocationsBrowser.isVisible = true

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu,menu)
        val menuItem = menu.findItem(R.id.actionSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                itemsAdapterCovenants!!.filter.filter(filterString)
                binding.gridViewCovenantsBrowser.adapter = itemsAdapterCovenants
                itemsAdapterLocations!!.filter.filter(filterString)
                itemsAdapterBosses!!.filter.filter(filterString)
                binding.recyclerViewLocationsBrowser.adapter = itemsAdapterLocations
                binding.recyclerViewBossesBrowser.adapter = itemsAdapterBosses
                itemsAdapterItems!!.filter.filter(filterString)
                binding.gridViewItemsBrowser.adapter = itemsAdapterItems
                return true
            }
            override fun onQueryTextChange(filterString: String?): Boolean {
                if (filterString!!.length >= 2){
                    itemsAdapterCovenants!!.filter.filter(filterString)
                    binding.gridViewCovenantsBrowser.adapter = itemsAdapterCovenants
                    itemsAdapterLocations!!.filter.filter(filterString)
                    itemsAdapterBosses!!.filter.filter(filterString)
                    binding.recyclerViewLocationsBrowser.adapter = itemsAdapterLocations
                    binding.recyclerViewBossesBrowser.adapter = itemsAdapterBosses
                    itemsAdapterItems!!.filter.filter(filterString)
                    binding.gridViewItemsBrowser.adapter = itemsAdapterItems
                }
                return true
            }
        })

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(context)
                builder.setMessage(getString(R.string.exit_message))
                builder.setCancelable(true)
                builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
                    requireActivity().moveTaskToBack(true)
                }
                builder.setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }
    override fun clickedItemBosses(itemsModalBosses: ItemsModalBosses) {
        Log.e("TAG BOSS",itemsModalBosses.boss)
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
            getString(R.string.giant_lord) ->communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.throne_watcher_and_throne_defender) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.nashandra) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            getString(R.string.aldia_scholar_of_the_first_sin) -> communicator.passDataCom(itemsModalBosses.boss,"bossesFragment")
            else->{
                Toast.makeText(this.context , "No Action", Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun clickedItemLocations(itemsModalLocations: ItemsModalLocations) {
        Log.e("TAG LOCATION",itemsModalLocations.location)
        when(itemsModalLocations.location){
            getString(R.string.things_betwixt) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
            getString(R.string.majula) -> communicator.passDataCom(itemsModalLocations.location,"locationFragment")
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
            else->{
                Toast.makeText(this.context , "No Action", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun clickedItem(itemsModalItems: Modal) {
        Log.e("TAG-DB",itemsModalItems.item.toString())

        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }

    override fun clickedItemCovenants(itemsModalCovenants: ItemsModalCovenants) {

        when(itemsModalCovenants.covenants){
            getString(R.string.bell_keeper) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.blue_sentinels) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.brotherhood_of_blood) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.company_of_champions) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.dragon_remnants) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.heirs_of_the_sun) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.pilgrims_of_dark) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.rat_king_covenant) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
            getString(R.string.way_of_blue) -> communicator.passDataCom(itemsModalCovenants.covenants!!,"covenantsFragment")
        }
    }
}