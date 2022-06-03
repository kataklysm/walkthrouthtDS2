package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.daveapps.walkthrouthds2.databinding.FragmentCharactersDetailsBinding

class CharactersDetailsFragment : Fragment(),ItemsAdapterItems.ClickListener {
    private var _binding: FragmentCharactersDetailsBinding? = null
    private val binding get() = _binding!!
    private var provider: String? = null
    private lateinit var communicator: Communicator
    private var modalListItems = ArrayList<Modal>()
    private var modalListLocations = ArrayList<Modal>()
    private var items = arrayOf("")
    private var itemsImages = intArrayOf()
    private var locations = arrayOf("")
    private var locationsImages = intArrayOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.character)
        _binding = FragmentCharactersDetailsBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)
        communicator = activity as Communicator

        val character = arguments?.getString("name")
        provider = arguments?.getString("provider")

        binding.tvCharactersName.typeface = Typeface.createFromAsset(context?.assets, "fonts/optimussemibold.ttf")

        binding.tvExpandListItemsCharacters.setOnClickListener {
            expandList(binding.gridViewCharactersItems,binding.ivExpandIconItemsCharacter)
        }
        when (character) {
            getString(R.string.milibeth) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.milibethframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.humaneffigy, R.drawable.handmaidsladle)
                items = arrayOf(getString(R.string.human_effigy), getString(R.string.handmaids_ladle))
                locationsImages = intArrayOf(R.drawable.thingsbetwixt)
                locations = arrayOf(getString(R.string.things_betwixt))
                for (items in items.indices) if (modalListItems.size < 2) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.strowen) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.strowenframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.humaneffigy)
                items = arrayOf(getString(R.string.human_effigy))
                locationsImages = intArrayOf(R.drawable.thingsbetwixt)
                locations = arrayOf(getString(R.string.things_betwixt))
                for (items in items.indices) if (modalListItems.size < 1) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))

            }
            getString(R.string.dynatillo) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.dynatillo)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.titaniteslab,R.drawable.petrifieddragonbone,R.drawable.demonsgreathammer)
                items = arrayOf(getString(R.string.titanite_slab),getString(R.string.petrified_dragon_bone),getString(R.string.demons_great_hammer))
                locationsImages = intArrayOf(R.drawable.thingsbetwixt)
                locations = arrayOf(getString(R.string.things_betwixt))
                for (items in items.indices) if (modalListItems.size < 3) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.emerald_herald) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.shanalotteframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.agedfeather)
                items = arrayOf(getString(R.string.aged_feather))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.drangleiccastle,R.drawable.dragonaerie)
                locations = arrayOf(getString(R.string.majula),getString(R.string.drangleic_castle),getString(R.string.dragon_aerie))
                for (items in items.indices) if (modalListItems.size < 1) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 3) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.saulden) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.sauldenframe)
                binding.tvCharactersName .text = character
                itemsImages = intArrayOf(R.drawable.ringofthesteelprotection,R.drawable.soulvessel)
                items = arrayOf(getString(R.string.ring_of_the_steel_protection),getString(R.string.soul_vessel))
                locationsImages = intArrayOf(R.drawable.majula)
                locations = arrayOf(getString(R.string.majula))
                for (items in items.indices) if (modalListItems.size < 2) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.lenigrast) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.lenigrastframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.blacksmithshammer,R.drawable.longsword,R.drawable.broadsword,R.drawable.falchion,R.drawable.estoc,R.drawable.rapier,R.drawable.battleaxe,R.drawable.mace,
                    R.drawable.spear,R.drawable.woodarrow,R.drawable.ironarrow,R.drawable.woodbolt,R.drawable.heavybolt,R.drawable.titaniteshard,R.drawable.repairpowder)
                items = arrayOf(getString(R.string.blacksmiths_hammer),getString(R.string.long_sword),getString(R.string.broadsword),getString(R.string.falchion),getString(R.string.estoc),getString(R.string.rapier),getString(R.string.battle_axe),getString(R.string.mace),
                    getString(R.string.spear),getString(R.string.wood_arrow),getString(R.string.iron_arrow),getString(R.string.wood_bolt),getString(R.string.heavy_bolt),getString(R.string.titanite_shard),getString(R.string.repair_powder))
                locationsImages = intArrayOf(R.drawable.majula)
                locations = arrayOf(getString(R.string.majula))
                for (items in items.indices) if (modalListItems.size < 15) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.shalquoir) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.shalquoirframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.ringoftheevileye,R.drawable.silvercatring,R.drawable.redeyering,R.drawable.nameengravedring,R.drawable.ringofwhispers,R.drawable.homewardbone,
                    R.drawable.prismstone,R.drawable.alluringskull,R.drawable.lloydstalisman,R.drawable.flyingfelinebootsframe)
                items = arrayOf(getString(R.string.ring_of_the_evil_eye),getString(R.string.silvercat_ring),getString(R.string.redeye_ring),getString(R.string.nameengraved_ring),getString(R.string.ring_of_whispers),getString(R.string.homeward_bone),
                    getString(R.string.prism_stone),getString(R.string.alluring_skull),getString(R.string.lloyds_talisman),getString(R.string.flying_feline_boots))
                locationsImages = intArrayOf(R.drawable.majula)
                locations = arrayOf(getString(R.string.majula))
                for (items in items.indices) if (modalListItems.size < 10) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.melentia) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.melentiaframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.brokenstraightsword,R.drawable.handaxe,R.drawable.club,R.drawable.caestus,R.drawable.patesshieldframe,R.drawable.benhartsparmaframe,
                    R.drawable.scytheofnahralmaframe,R.drawable.mirrahgreatsword,R.drawable.darkdriftframe,R.drawable.travelingmerchantset,R.drawable.patesset,R.drawable.benhartsset,R.drawable.calesleatherarmor,
                    R.drawable.calesshoes,R.drawable.lucatielsvest,R.drawable.lucatielsgloves,R.drawable.lucatielstrousers,R.drawable.creightonschainmail,R.drawable.creightonschaingloves,
                    R.drawable.creightonschainleggings,R.drawable.saintshood,R.drawable.saintsdress,R.drawable.saintslonggloves,R.drawable.saintstrousers,R.drawable.hexershood,
                    R.drawable.hexersrobes,R.drawable.hexersgloves,R.drawable.hexersboots,R.drawable.targrayshelm,R.drawable.targraysarmor,R.drawable.targraysmanifers,R.drawable.targraysleggings,
                    R.drawable.pharroslockstone,R.drawable.fragrantbranchofyore,R.drawable.lenigrastskey,R.drawable.humaneffigy,R.drawable.lifegem,R.drawable.radiantlifegem,
                    R.drawable.amberherb,R.drawable.firebomb,R.drawable.witchingurn,R.drawable.throwingknife,R.drawable.brightbug,R.drawable.soularrow,R.drawable.heal)
                items = arrayOf(getString(R.string.broken_straight_sword),getString(R.string.hand_axe),getString(R.string.club),getString(R.string.caestus),getString(R.string.pates_shield),getString(R.string.benharts_parma),
                    getString(R.string.scythe_of_nahr_alma),getString(R.string.mirrah_greatsword),getString(R.string.darkdrift),getString(R.string.traveling_merchant_set),getString(R.string.pates_set),getString(R.string.benharts_set), getString(R.string.cales_leather_armor),
                    getString(R.string.cales_shoes),getString(R.string.lucatiels_vest),getString(R.string.lucatiels_gloves),getString(R.string.lucatiels_trousers),getString(R.string.creightons_chainmail),getString(R.string.creightons_chain_gloves),
                    getString(R.string.creightons_chain_leggins),getString(R.string.saints_hood),getString(R.string.saints_dress),getString(R.string.saints_long_gloves),getString(R.string.saints_trousers),getString(R.string.hexers_hood),
                    getString(R.string.hexers_robes),getString(R.string.hexers_gloves),getString(R.string.hexers_boots),getString(R.string.targrays_helm),getString(R.string.targrays_armor),getString(R.string.targrays_manifers),getString(R.string.targrays_leggings),
                    getString(R.string.pharros_lockstone),getString(R.string.fragrant_branch_of_yore),getString(R.string.lenigrasts_key),getString(R.string.human_effigy),getString(R.string.life_gem),getString(R.string.radiant_life_gem),
                    getString(R.string.amber_herb),getString(R.string.fire_bomb),getString(R.string.witching_urn),getString(R.string.throwing_knife),getString(R.string.brightbug),getString(R.string.soul_arrow),getString(R.string.heal))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.forestoffallengiants)
                locations = arrayOf(getString(R.string.majula),getString(R.string.forest_of_fallen_giants))
                for (items in items.indices) if (modalListItems.size < 45) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.maughlin_the_armourer) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.armourerframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.ironparmaframe,R.drawable.silvereaglekiteshieldframe,R.drawable.twindragongreatshieldframe,R.drawable.standardhelm,R.drawable.hardleatherarmor,R.drawable.hardleathergauntlets,
                    R.drawable.hardleatherboots,R.drawable.infantryarmor,R.drawable.infantrygloves,R.drawable.infantryboots,R.drawable.falconerhelm,R.drawable.falconerarmor,R.drawable.falconergloves,R.drawable.falconerboots,
                    R.drawable.royalsoldierhelmet,R.drawable.royalsoldierarmor,R.drawable.royalsoldiergauntlets,R.drawable.royalsoldierleggings,R.drawable.eliteknighthelm,R.drawable.eliteknightarmor,R.drawable.eliteknightgloves,
                    R.drawable.eliteknightleggings,R.drawable.smelterdemonhelm,R.drawable.smelterdemonarmor,R.drawable.smelterdemongauntlets,R.drawable.smelterdemonleggings,R.drawable.lookingglassmask,R.drawable.lookingglassarmor,
                    R.drawable.lookingglassgauntlets,R.drawable.lookingglassleggings,R.drawable.penalmask,R.drawable.penalstraightjacket,R.drawable.penalhandcuffs,R.drawable.penalskirt,R.drawable.alvahelm,R.drawable.alvaarmor,
                    R.drawable.alvagauntlets,R.drawable.alvaleggings,R.drawable.moonbutterflyhat,R.drawable.moonbutterflywings,R.drawable.moonbutterflycuffs,R.drawable.moonbutterflyskirt,R.drawable.velstadtshelm,R.drawable.velstadtsarmor,
                    R.drawable.velstadtsgauntlets,R.drawable.velstadtsleggings,R.drawable.thronedefenderhelm,R.drawable.thronedefenderarmor,R.drawable.thronedefendergauntlets,R.drawable.thronedefenderleggings,R.drawable.thronewatcherhelm,
                    R.drawable.thronewatcherarmor,R.drawable.thronewatchergauntlets,R.drawable.thronewatcherleggings)
                items = arrayOf(getString(R.string.iron_parma),getString(R.string.silver_eagle_kite_shield),getString(R.string.twin_dragon_greatshield),getString(R.string.standard_helm),getString(R.string.hard_leather_armor),getString(R.string.hard_leather_gauntlets),
                    getString(R.string.hard_leather_boots),getString(R.string.infantry_armor),getString(R.string.infantry_gloves),getString(R.string.infantry_boots),getString(R.string.falconer_helm),getString(R.string.falconer_armor),getString(R.string.falconer_gloves),getString(R.string.falconer_boots),
                    getString(R.string.royal_soldier_helmet),getString(R.string.royal_soldier_armor),getString(R.string.royal_soldier_gauntlets),getString(R.string.royal_soldier_leggings),getString(R.string.elite_knight_helm),getString(R.string.elite_knight_armor),getString(R.string.elite_knight_gloves),
                    getString(R.string.elite_knight_leggings),getString(R.string.smelter_demon_helm),getString(R.string.smelter_demon_armor),getString(R.string.smelter_demon_gauntlets),getString(R.string.smelter_demon_leggings),getString(R.string.looking_glass_mask),getString(R.string.looking_glass_armor),
                    getString(R.string.looking_glass_gauntlets),getString(R.string.looking_glass_leggings),getString(R.string.penal_mask),getString(R.string.penal_straight_jacket),getString(R.string.penal_handcuffs),getString(R.string.penal_skirt),getString(R.string.alva_helm),getString(R.string.alva_armor),
                    getString(R.string.alva_gauntlets),getString(R.string.alva_leggings),getString(R.string.moon_butterfly_hat),getString(R.string.moon_butterfly_wings),getString(R.string.moon_butterfly_cuffs),getString(R.string.moon_butterfly_skirt),getString(R.string.velstadts_helm),getString(R.string.velstadts_armor),
                    getString(R.string.velstadts_gauntlets),getString(R.string.velstadts_leggings),getString(R.string.throne_defender_helm),getString(R.string.throne_defender_armor),getString(R.string.throne_defender_gauntlets),getString(R.string.throne_defender_leggings),getString(R.string.throne_watcher_helm),
                    getString(R.string.throne_watcher_armor),getString(R.string.throne_watcher_gauntlets),getString(R.string.throne_watcher_leggings))
                locationsImages = intArrayOf(R.drawable.majula)
                locations = arrayOf(getString(R.string.majula))
                for (items in items.indices) if (modalListItems.size < 54) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.carhillion) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.carhillionframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.soularrow,R.drawable.greatsoularrow,R.drawable.heavysoularrow,R.drawable.greatheavysoularrow,R.drawable.shockwave,R.drawable.soulspearbarrage,R.drawable.magicweapon,R.drawable.yearn,
                    R.drawable.sorcerersstaff,R.drawable.spellquartzring,R.drawable.clearbluestonering,R.drawable.amberherb,R.drawable.twilightherb,R.drawable.simpletonsspice)
                items = arrayOf(getString(R.string.soul_arrow),getString(R.string.great_soul_arrow),getString(R.string.heavy_soul_arrow),getString(R.string.great_heavy_soul_arrow),getString(R.string.shockwave),getString(R.string.soul_spear_barrage),getString(R.string.magic_weapon),getString(R.string.yearn),
                    getString(R.string.sorcerers_staff),getString(R.string.spell_quartz_ring),getString(R.string.clear_bluestone_ring),getString(R.string.amber_herb),getString(R.string.twilight_herb),getString(R.string.simpletons_spice))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.nomanswharf)
                locations = arrayOf(getString(R.string.majula),getString(R.string.no_mans_wharf))
                for (items in items.indices) if (modalListItems.size < 14) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.rosabeth) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.rosabethframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.flamequartzring,R.drawable.thunderquartzring,R.drawable.darkquartzring,R.drawable.smallblueburr,R.drawable.smallyellowburr,R.drawable.smallorangeburr,R.drawable.fireseed,R.drawable.fireball,
                    R.drawable.fireorb,R.drawable.combustion,R.drawable.poisonmist,R.drawable.flashsweat,R.drawable.ironflesh)
                items = arrayOf(getString(R.string.flame_quartz_ring),getString(R.string.thunder_quartz_ring),getString(R.string.dark_quartz_ring),getString(R.string.small_blue_burr),getString(R.string.small_yellow_burr),getString(R.string.small_orange_burr),getString(R.string.fire_seed),getString(R.string.fireball),
                    getString(R.string.fire_orb),getString(R.string.combustion),getString(R.string.poison_mist),getString(R.string.flash_sweat),getString(R.string.iron_flesh))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.shadedwoods)
                locations = arrayOf(getString(R.string.majula),getString(R.string.shaded_woods))
                for (items in items.indices) if (modalListItems.size < 13 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.cale_the_cartographer) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.caleframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.caleshelm)
                items = arrayOf(getString(R.string.cales_helm))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.forestoffallengiants)
                locations = arrayOf(getString(R.string.majula),getString(R.string.forest_of_fallen_giants))
                for (items in items.indices) if (modalListItems.size < 4 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.stone_trader_chloanne) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.chloanneframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.bonfireascetic,R.drawable.titaniteshard,R.drawable.largetitaniteshard,R.drawable.titanitechunk,R.drawable.titaniteslab,R.drawable.twinklingtitanite,
                    R.drawable.petrifieddragonbone,R.drawable.faintstone,R.drawable.boltstone,R.drawable.firedrakestone,R.drawable.darknightstone,R.drawable.poisonstone,R.drawable.bleedstone,R.drawable.rawstone,
                    R.drawable.magicstone,R.drawable.oldmundanestone,R.drawable.soulappease,R.drawable.deadagain)
                items = arrayOf(getString(R.string.bonfire_ascetic),getString(R.string.titanite_shard),getString(R.string.large_titanite_shard),getString(R.string.titanite_chunk),getString(R.string.titanite_slab), getString(R.string.twinkling_titanite),
                    getString(R.string.petrified_dragon_bone),getString(R.string.faint_stone),getString(R.string.boltstone),getString(R.string.firedrake_stone),getString(R.string.darknight_stone),getString(R.string.poison_stone),getString(R.string.bleed_stone),getString(R.string.raw_stone),
                    getString(R.string.magic_stone),getString(R.string.old_mundane_stone),getString(R.string.soul_appease),getString(R.string.dead_again))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.harvestvalley)
                locations = arrayOf(getString(R.string.majula),getString(R.string.harvest_valley))
                for (items in items.indices) if (modalListItems.size < 18 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.laddersmith_gilligan) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.gilliganframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.reinforcedclub,R.drawable.whip,R.drawable.claws,R.drawable.woodenshield,R.drawable.thiefmask,R.drawable.blackleatherarmor,R.drawable.blackleathergloves,
                    R.drawable.blackleatherboots,R.drawable.laceratingknife,R.drawable.aromaticooze,R.drawable.bleedingserum,R.drawable.ladderminiature,R.drawable.meluscimitar)
                items = arrayOf(getString(R.string.reinforced_club),getString(R.string.whip),getString(R.string.claws),getString(R.string.wooden_shield),getString(R.string.thief_mask),getString(R.string.black_leather_armor),getString(R.string.black_leather_gloves),
                    getString(R.string.black_leather_boots),getString(R.string.lacerating_knife),getString(R.string.aromatic_ooze),getString(R.string.bleeding_serum),getString(R.string.ladder_miniature),getString(R.string.melu_scimitar))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.earthenpeak)
                locations = arrayOf(getString(R.string.majula),getString(R.string.earthen_peak))
                for (items in items.indices) if (modalListItems.size < 13 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.licia_of_lindelt) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.liciaframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.clericssacredchime,R.drawable.ringofprayer,R.drawable.heal,R.drawable.medheal,R.drawable.greathealexcerpt,R.drawable.replenishment,
                    R.drawable.resplendentlife,R.drawable.caressingprayer,R.drawable.force,R.drawable.lightningspear,R.drawable.homeward,R.drawable.guidance)
                items = arrayOf(getString(R.string.clerics_sacred_chime),getString(R.string.ring_of_prayer),getString(R.string.heal),getString(R.string.med_heal),getString(R.string.great_heal_excerpt),getString(R.string.replenishment),
                    getString(R.string.resplendent_life),getString(R.string.caressing_prayer),getString(R.string.force),getString(R.string.lightning_spear),getString(R.string.homeward),getString(R.string.guidance))
                locationsImages = intArrayOf(R.drawable.majula,R.drawable.heidestowerofflame)
                locations = arrayOf(getString(R.string.majula),getString(R.string.heides_tower_of_flame))
                for (items in items.indices) if (modalListItems.size < 13 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.blue_sentinel_targray) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.targrayframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.blueknightshalberd)
                items = arrayOf(getString(R.string.blue_knights_halberd))
                locationsImages = intArrayOf(R.drawable.cathedralofblue)
                locations = arrayOf(getString(R.string.cathedral_of_blue))
                for (items in items.indices) if (modalListItems.size < 1 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.mild_mannered_pate) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.pateframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.patesspear,R.drawable.ringofthorns)
                items = arrayOf(getString(R.string.pates_spear),getString(R.string.ring_of_thorns))
                locationsImages = intArrayOf(R.drawable.forestoffallengiants,R.drawable.earthenpeak,R.drawable.brightstonecovetseldora)
                locations = arrayOf(getString(R.string.forest_of_fallen_giants),getString(R.string.earthen_peak),getString(R.string.brightstone_cove_tseldora))
                for (items in items.indices) if (modalListItems.size < 2 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 3) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.lonesome_gavlan) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.gavlanframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.poisonmoss,R.drawable.rottenpineresin,R.drawable.poisonthrowingknife,R.drawable.poisonarrow,R.drawable.ringofgiants)
                items = arrayOf(getString(R.string.poison_moss),getString(R.string.rotten_pine_resin),getString(R.string.poison_throwing_knife),getString(R.string.poison_arrow),getString(R.string.ring_of_giants))
                locationsImages = intArrayOf(R.drawable.nomanswharf,R.drawable.harvestvalley,R.drawable.doorsofpharros)
                locations = arrayOf(getString(R.string.no_mans_wharf),getString(R.string.harvest_valley),getString(R.string.doors_of_pharros))
                for (items in items.indices) if (modalListItems.size < 5 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 3) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.lucatiel_of_mirrah) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.lucatielframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.humaneffigy,R.drawable.ringofsteelprotection,R.drawable.lucatielsmask,R.drawable.mirrahgreatsword)
                items = arrayOf(getString(R.string.human_effigy),getString(R.string.ring_of_the_steel_protection),getString(R.string.lucatiels_mask),getString(R.string.mirrah_greatsword))
                locationsImages = intArrayOf(R.drawable.nomanswharf,R.drawable.lostbastille,R.drawable.earthenpeak,R.drawable.theblackgulch,R.drawable.aldiaskeep)
                locations = arrayOf(getString(R.string.no_mans_wharf),getString(R.string.lost_bastille),getString(R.string.earthen_peak),getString(R.string.black_gulch),getString(R.string.aldias_keep))
                for (items in items.indices) if (modalListItems.size < 4 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 5) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.steady_hand_mcduff) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.mcduffframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.titaniteslab,R.drawable.repairpowder,R.drawable.largetitaniteshard,R.drawable.woodarrow,R.drawable.ironarrow,R.drawable.irongreatarrow,R.drawable.woodbolt,
                    R.drawable.heavybolt,R.drawable.bastardsword,R.drawable.uchigatana,R.drawable.greataxe,R.drawable.wingedspear,R.drawable.scythe,R.drawable.longbow,R.drawable.lightcrossbow,R.drawable.royalkiteshield)
                items = arrayOf(getString(R.string.titanite_slab),getString(R.string.repair_powder),getString(R.string.large_titanite_shard),getString(R.string.wood_arrow),getString(R.string.iron_arrow),getString(R.string.iron_greatarrow),getString(R.string.wood_bolt),
                    getString(R.string.heavy_bolt),getString(R.string.bastard_sword),getString(R.string.uchigatana),getString(R.string.great_axes),getString(R.string.winged_spear),getString(R.string.scythe),getString(R.string.long_bow),getString(R.string.light_crossbow),getString(R.string.royal_kite_shield))
                locationsImages = intArrayOf(R.drawable.lostbastille)
                locations = arrayOf(getString(R.string.lost_bastille))
                for (items in items.indices) if (modalListItems.size < 16 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.straid_of_olaphis) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.straidframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.greatswordoftheforlorn,R.drawable.scytheoftheforlorn,R.drawable.hoodoftheforlorn,R.drawable.armoroftheforlorn,R.drawable.gauntletsoftheforlorn,
                    R.drawable.leggingsoftheforlorn,R.drawable.ringofknowledge,R.drawable.lingeringdragoncrestring,R.drawable.agapering,R.drawable.rougewater,R.drawable.homingsoularrow,
                    R.drawable.strongmagicshield,R.drawable.castlight,R.drawable.resplendentlife,R.drawable.greatlightningspear,R.drawable.unveil,R.drawable.sunlightblade,R.drawable.lingeringflame,
                    R.drawable.flameswathe,R.drawable.darkorb,R.drawable.darkhail,R.drawable.darkfog,R.drawable.affinity,R.drawable.mythasbentblade,R.drawable.smeltersword,R.drawable.pursuersultragreatsword,
                    R.drawable.pursuersgreatshieldframe,R.drawable.warpedsword,R.drawable.arcedsword,R.drawable.barbedclub,R.drawable.giantstoneaxe,R.drawable.gargoylebident,R.drawable.dragonridershalberd,
                    R.drawable.dragonridertwinblade,R.drawable.dragonriderbow,R.drawable.dragonridergreatshieldframe,R.drawable.roaringhalberd,R.drawable.bonescythe,R.drawable.chariotlance,R.drawable.shieldcrossbow,
                    R.drawable.spottedwhip,R.drawable.heavyhomingsoularrow,R.drawable.soulshower,R.drawable.sacredoath,R.drawable.toxicmist,R.drawable.acidsurge,R.drawable.repel,R.drawable.flameweapon,
                    R.drawable.crystalsoulspear,R.drawable.blindingbolt,R.drawable.numbness,R.drawable.lifedrainpatch,R.drawable.outcry)
                items = arrayOf(getString(R.string.greatsword_of_the_forlorn),getString(R.string.scythe_of_the_forlorn),getString(R.string.hood_of_the_forlorn),getString(R.string.armor_of_the_forlorn),getString(R.string.gauntlets_of_the_forlorn),
                    getString(R.string.leggings_of_the_forlorn),getString(R.string.ring_of_knowledge),getString(R.string.lingering_dragoncrest_ring),getString(R.string.agape_ring),getString(R.string.rouge_water),getString(R.string.homing_soul_arrow),
                    getString(R.string.strong_magic_shield),getString(R.string.cast_light),getString(R.string.resplendent_life),getString(R.string.great_lightning_spear),getString(R.string.unveil),getString(R.string.sunlight_blade),getString(R.string.lingering_flame),
                    getString(R.string.flame_swathe),getString(R.string.dark_orb),getString(R.string.dark_hail),getString(R.string.dark_fog),getString(R.string.affinity),getString(R.string.mythas_bent_blade),getString(R.string.smelter_sword),getString(R.string.pursuer_ultra_greatsword),
                    getString(R.string.pursuers_greatshield),getString(R.string.warped_sword),getString(R.string.arced_sword),getString(R.string.barbed_club),getString(R.string.giant_stone_axe),getString(R.string.gargoyle_bident),getString(R.string.dragonriders_halberd),
                    getString(R.string.dragonrider_twin_blade),getString(R.string.dragonrider_bow),getString(R.string.dragonrider_greatshield),getString(R.string.roaring_halberd),getString(R.string.bone_scythe),getString(R.string.chariot_lance),getString(R.string.shield_crossbow),
                    getString(R.string.spotted_whip),getString(R.string.heavy_homing_soul_arrow),getString(R.string.soul_shower),getString(R.string.sacred_oath),getString(R.string.toxic_mist),getString(R.string.acid_surge),getString(R.string.repel),getString(R.string.flame_weapon),
                    getString(R.string.crystal_soul_spear),getString(R.string.blinding_bolt),getString(R.string.numbness),getString(R.string.lifedrain_patch),getString(R.string.outcry))
                locationsImages = intArrayOf(R.drawable.lostbastille)
                locations = arrayOf(getString(R.string.lost_bastille))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 53 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.felkin_the_outcast) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.felkinframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.archdrakestaff,R.drawable.archdrakechime,R.drawable.chaosrapier,R.drawable.chaosshield,R.drawable.ringoflifeprotection,R.drawable.darkpineresin,
                    R.drawable.magicbarrier,R.drawable.darkorb,R.drawable.darkweapon,R.drawable.greatresonantsoul,R.drawable.resonantsoul,R.drawable.resonantflesh,R.drawable.resonantweapon,R.drawable.sunsetstaff)
                items = arrayOf(getString(R.string.archdrake_staff),getString(R.string.archdrake_chime),getString(R.string.chaos_rapier),getString(R.string.chaos_shield),getString(R.string.ring_of_life_protection),getString(R.string.dark_pine_resin),
                    getString(R.string.magic_barrier),getString(R.string.dark_orb),getString(R.string.dark_weapon),getString(R.string.great_resonant_soul),getString(R.string.resonant_soul),getString(R.string.resonant_flesh),getString(R.string.resonant_weapon),getString(R.string.sunset_staff))
                locationsImages = intArrayOf(R.drawable.huntsmanscopse)
                locations = arrayOf(getString(R.string.huntsmans_copse))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 14 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.titchy_gren) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.grenframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.crestofblood,R.drawable.curvedtwinblade,R.drawable.crescentsickle,R.drawable.greatchaosfireball,R.drawable.nahralmahood,R.drawable.scytheofnahralmaframe,
                    R.drawable.greatscythe,R.drawable.priestschime,R.drawable.executionerhelm,R.drawable.executionerarmor,R.drawable.executionergauntlets,R.drawable.executionerleggings,R.drawable.bonecrown,
                    R.drawable.bonekingrobe,R.drawable.bonekingcuffs,R.drawable.bonekingskirt,R.drawable.delicatestring,R.drawable.hexingurn,R.drawable.silvertalisman,R.drawable.redsignsoapstone,
                    R.drawable.crackedredeyeorb,R.drawable.firestorm,R.drawable.greatcombustion,R.drawable.firewhip)
                items = arrayOf(getString(R.string.crest_of_blood),getString(R.string.curved_twinblade),getString(R.string.crescent_sickle),getString(R.string.great_chaos_fireball),getString(R.string.nahr_alma_hood),getString(R.string.scythe_of_nahr_alma),
                    getString(R.string.great_scythe),getString(R.string.priest_schime),getString(R.string.executioner_helm),getString(R.string.executioner_armor),getString(R.string.executioner_gauntlets),getString(R.string.executioner_leggings),getString(R.string.bone_crown),
                    getString(R.string.bone_king_robe),getString(R.string.bone_king_cuffs),getString(R.string.bone_king_skirt),getString(R.string.delicate_string),getString(R.string.hexing_urn),getString(R.string.silver_talisman),getString(R.string.red_sign_soapstone),
                    getString(R.string.cracked_red_eye_orb),getString(R.string.fire_storm),getString(R.string.great_combustion),getString(R.string.fire_whip))
                locationsImages = intArrayOf(R.drawable.undeadpurgatory)
                locations = arrayOf(getString(R.string.undead_purgatory))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 16 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.magerold_of_lanafir) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.mageroldframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.jesterscap,R.drawable.jestersrobes,R.drawable.jestersgloves,R.drawable.jesterstights,R.drawable.spikedbandithelm,R.drawable.banditarmor,
                    R.drawable.banditgauntlets,R.drawable.banditboots,R.drawable.dragonriderhelm,R.drawable.dragonriderarmor,R.drawable.dragonridergauntlets,R.drawable.dragonriderleggings,
                    R.drawable.alonneshelm,R.drawable.alonnesarmor,R.drawable.alonnesgauntlets,R.drawable.alonnesleggings,R.drawable.raimeshelm,R.drawable.raimesarmor,R.drawable.raimesgauntlets,
                    R.drawable.raimesleggings,R.drawable.cursebitering,R.drawable.humaneffigy,R.drawable.greenblossom,R.drawable.blackfirebomb,R.drawable.charcoalpineresin,R.drawable.repairpowder,
                    R.drawable.rustedcoin,R.drawable.hellocarving,R.drawable.thankyoucarving,R.drawable.imsorrycarving,R.drawable.verygoodcarving,R.drawable.fragrantbranchofyore,R.drawable.soularrow,
                    R.drawable.greatsoularrow,R.drawable.heavysoularrow,R.drawable.greatheavysoularrow,R.drawable.fallcontrol,R.drawable.darkhail,R.drawable.darkstorm)
                items = arrayOf(getString(R.string.jesters_cap),getString(R.string.jesters_robes),getString(R.string.jesters_gloves),getString(R.string.jesters_tights),getString(R.string.spiked_bandit_helm),getString(R.string.bandit_armor),
                    getString(R.string.bandit_gauntlets),getString(R.string.bandit_boots),getString(R.string.dragonrider_helm),getString(R.string.dragonrider_armor),getString(R.string.dragonrider_gauntlets),getString(R.string.dragonrider_leggings),
                    getString(R.string.alonnes_helm),getString(R.string.alonnes_armor),getString(R.string.alonnes_gauntlets),getString(R.string.alonnes_leggings),getString(R.string.raimes_helm),getString(R.string.raimes_armor),getString(R.string.raimes_gauntlets),
                    getString(R.string.raimes_leggings),getString(R.string.cursebite_ring),getString(R.string.human_effigy),getString(R.string.green_blossom),getString(R.string.black_firebomb),getString(R.string.charcoal_pine_resin),getString(R.string.repair_powder),
                    getString(R.string.rusted_coin),getString(R.string.hello_carving),getString(R.string.thank_you_carving),getString(R.string.im_sorry_carving),getString(R.string.very_good_carving),getString(R.string.fragrant_branch_of_yore),getString(R.string.soul_arrow),
                    getString(R.string.great_soul_arrow),getString(R.string.heavy_soul_arrow),getString(R.string.great_heavy_soul_arrow),getString(R.string.fall_control),getString(R.string.dark_hail),getString(R.string.darkstorm))
                locationsImages = intArrayOf(R.drawable.ironkeep)
                locations = arrayOf(getString(R.string.iron_keep))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 39 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.bell_keeper) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.bellkeeperframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.bellkeepersseal,R.drawable.rustedcoin,R.drawable.titaniteslab,R.drawable.hiddenweapon,R.drawable.bellkeeperhelmet,R.drawable.bellkeeperbellyband,
                    R.drawable.bellkeepercuffs,R.drawable.bellkeepertrousers)
                items = arrayOf(getString(R.string.bell_keepers_seal),getString(R.string.rusted_coin),getString(R.string.titanite_slab),getString(R.string.hidden_weapon),getString(R.string.bell_keeper_helmet),getString(R.string.bell_keeper_bellyband),getString(R.string.bell_keeper_cuffs),getString(R.string.bell_keeper_trousers))
                locationsImages = intArrayOf(R.drawable.belfrysol)
                locations = arrayOf(getString(R.string.belfry_sol))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 8 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.rat_king) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.ratkingframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.corrosiveurn,R.drawable.dungpie,R.drawable.commonfruit,R.drawable.redleechtroches,R.drawable.triclopssnaketroches)
                items = arrayOf(getString(R.string.corrosive_urn),getString(R.string.dung_pie),getString(R.string.common_fruit),getString(R.string.red_leech_troches),getString(R.string.triclops_snake_troches))
                locationsImages = intArrayOf(R.drawable.graveofsaints,R.drawable.doorsofpharros)
                locations = arrayOf(getString(R.string.grave_of_saints),getString(R.string.doors_of_pharros))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 5 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.darkdiver_grandahl) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.grandahlframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.humaneffigy,R.drawable.bonfireascetic,R.drawable.castlight,R.drawable.darkorb,R.drawable.darkhail,R.drawable.darkstorm,R.drawable.profoundstill,
                    R.drawable.dragonchime)
                items = arrayOf(getString(R.string.human_effigy),getString(R.string.bonfire_ascetic),getString(R.string.cast_light),getString(R.string.dark_orb),getString(R.string.dark_hail),getString(R.string.darkstorm),getString(R.string.profound_still),
                    getString(R.string.dragon_chime))
                locationsImages = intArrayOf(R.drawable.theblackgulch,R.drawable.shadedwoods,R.drawable.drangleiccastle)
                locations = arrayOf(getString(R.string.black_gulch),getString(R.string.shaded_woods),getString(R.string.drangleic_castle))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 8 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 3) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.head_of_vengarl) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.vengarlframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.lightningurn,R.drawable.goldpineresin,R.drawable.ringofsoulprotection,R.drawable.claymore,R.drawable.greatsword,R.drawable.redrustsword,
                    R.drawable.redrustscimitar,R.drawable.redrustshieldframe,R.drawable.destructivegreatarrow,R.drawable.magicbarrier,R.drawable.vengarlshelm)
                items = arrayOf(getString(R.string.lightning_urn),getString(R.string.gold_pine_resin),getString(R.string.ring_of_soul_protection),getString(R.string.claymore),getString(R.string.greatsword),getString(R.string.red_rust_sword),
                    getString(R.string.red_rust_scimitar),getString(R.string.red_rust_shield),getString(R.string.destructive_great_arrow),getString(R.string.magic_barrier),getString(R.string.vengarls_helm))
                locationsImages = intArrayOf(R.drawable.shadedwoods)
                locations = arrayOf(getString(R.string.shaded_woods))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 11 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.creighton_of_mirrah) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.creightonframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.creightonssteelmask)
                items = arrayOf(getString(R.string.creightons_steel_mask))
                locationsImages = intArrayOf(R.drawable.huntsmanscopse,R.drawable.shadedwoods,R.drawable.brightstonecovetseldora)
                locations = arrayOf(getString(R.string.huntsmans_copse),getString(R.string.shaded_woods),getString(R.string.brightstone_cove_tseldora))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 1 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 3) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.manscorpion_tark) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.tarkframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.fragrantbranchofyore,R.drawable.seconddragonring,R.drawable.blackscorpionstinger)
                items = arrayOf(getString(R.string.fragrant_branch_of_yore),getString(R.string.second_dragon_ring),getString(R.string.black_scorpion_stinger))
                locationsImages = intArrayOf(R.drawable.shadedwoods)
                locations = arrayOf(getString(R.string.shaded_woods))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 3 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.weaponsmith_ornifex) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.ornifexframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.murakumo,R.drawable.partizan,R.drawable.twinblade,R.drawable.compositebow,R.drawable.heavycrossbow,R.drawable.firearrow,R.drawable.firebolt,
                    R.drawable.amberherb,R.drawable.greenblossom,R.drawable.flamebutterfly,R.drawable.homingsoularrow,R.drawable.homingsoulmass,R.drawable.fallcontrol,R.drawable.agedsmeltersword,
                    R.drawable.bewitchedalonnesword,R.drawable.bowofwant,R.drawable.butchersknife,R.drawable.chaosblade,R.drawable.chimeofscreams,R.drawable.chimeofwant,R.drawable.cryptblacksword,
                    R.drawable.curveddragongreatsword,R.drawable.defendergreatsword,R.drawable.defendersshieldframe,R.drawable.dragonslayergreatbow,R.drawable.dragonslayerspear,R.drawable.drakewingultragreatsword,
                    R.drawable.eleumloyce,R.drawable.fumesword,R.drawable.fumeultragreatsword,R.drawable.ironkinghammer,R.drawable.ivorykingultragreatsword,R.drawable.ivorystraightsword,R.drawable.kingsmirrorframe,
                    R.drawable.kingsshieldframe,R.drawable.kingsultragreatsword,R.drawable.loycegreatsword,R.drawable.loyceshieldframe,R.drawable.lostsinnerssword,R.drawable.moonlightgreatsword,R.drawable.rulerssword,
                    R.drawable.sacredchimehammer,R.drawable.scytheofwant,R.drawable.spiderfang,R.drawable.spiderssilk,R.drawable.spitfirespear,R.drawable.thornedgreatsword,R.drawable.watchergreatsword,
                    R.drawable.watchersshieldframe,R.drawable.wrathfulaxe,R.drawable.yorghsspear)
                items = arrayOf(getString(R.string.murakumo),getString(R.string.partizan),getString(R.string.twinblade),getString(R.string.composite_bow),getString(R.string.heavy_crossbow),getString(R.string.fire_arrow),getString(R.string.fire_bolt),
                    getString(R.string.amber_herb),getString(R.string.green_blossom),getString(R.string.flame_butterfly),getString(R.string.homing_soul_arrow),getString(R.string.homing_soul_mass),getString(R.string.fall_control),getString(R.string.aged_smelter_sword),
                    getString(R.string.bewitched_alonne_sword),getString(R.string.bow_of_want),getString(R.string.butchersk_nife),getString(R.string.chaos_blade),getString(R.string.chime_of_screams),getString(R.string.chime_of_want),getString(R.string.crypt_blacksword),
                    getString(R.string.curved_dragon_greatsword),getString(R.string.defender_greatsword),getString(R.string.defenders_shield),getString(R.string.dragonslayer_greatbow),getString(R.string.dragonslayer_spear),getString(R.string.drakewing_ultra_greatsword),
                    getString(R.string.eleum_loyce),getString(R.string.fume_sword),getString(R.string.fume_ultra_greatsword),getString(R.string.iron_king_hammer),getString(R.string.ivory_king_ultra_greatsword),getString(R.string.ivory_straight_sword),getString(R.string.kings_mirror),
                    getString(R.string.kings_shield),getString(R.string.kings_ultra_greatsword),getString(R.string.loyce_greatsword),getString(R.string.loyce_shield),getString(R.string.lost_sinners_sword),getString(R.string.moonlight_greatsword),getString(R.string.rulers_sword),
                    getString(R.string.sacred_chime_hammer),getString(R.string.scythe_of_want),getString(R.string.spider_fang),getString(R.string.spiders_silk),getString(R.string.spitfire_spear),getString(R.string.thorned_greatsword),getString(R.string.watcher_greatsword),
                    getString(R.string.watchers_shield),getString(R.string.wrathful_axe),getString(R.string.yorghs_spear))
                locationsImages = intArrayOf(R.drawable.shadedwoods,R.drawable.brightstonecovetseldora)
                locations = arrayOf(getString(R.string.shaded_woods),getString(R.string.brightstone_cove_tseldora))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()
                for (items in items.indices) if (modalListItems.size < 51 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.cromwell_the_pardoner) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.cromwellframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.scrapsoflife,R.drawable.greatheal,R.drawable.emitforce,R.drawable.heavenlythunder,R.drawable.perseverance,R.drawable.cursebitering,R.drawable.poisonbitering,
                    R.drawable.bloodbitering,R.drawable.darktroches,R.drawable.whitepriestheadpiece,R.drawable.whitepriestrobe,R.drawable.whitepriestgloves,R.drawable.whitepriestskirt)
                items = arrayOf(getString(R.string.scraps_of_life),getString(R.string.great_heal),getString(R.string.emit_force),getString(R.string.heavenly_thunder),getString(R.string.perseverance),getString(R.string.cursebite_ring),getString(R.string.poisonbite_ring),
                    getString(R.string.bloodbite_ring),getString(R.string.dark_troches),getString(R.string.white_priest_headpiece),getString(R.string.white_priest_robe),getString(R.string.white_priest_gloves),getString(R.string.white_priest_skirt))
                locationsImages = intArrayOf(R.drawable.brightstonecovetseldora)
                locations = arrayOf(getString(R.string.brightstone_cove_tseldora))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 13 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.chancellor_wellager) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.wellagerframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.flamberge,R.drawable.lucerne,R.drawable.blackflamestonedagger,R.drawable.yellowquartzlongsword,R.drawable.boundhandaxe,
                    R.drawable.homunculusmace,R.drawable.transgressorsstaff,R.drawable.transgressorsleathershieldframe,R.drawable.blackflamestoneparmaframe,R.drawable.yellowquartzshieldframe,
                    R.drawable.boundwoodenshieldframe,R.drawable.homunculuswoodenshieldframe,R.drawable.crescentsickle,R.drawable.curvedtwinblade,R.drawable.spirittreeshieldframe,
                    R.drawable.bracingknucklering,R.drawable.magicarrow,R.drawable.lightningarrow,R.drawable.magicbolt,R.drawable.lightningbolt,R.drawable.oldradiantlifegem,
                    R.drawable.wiltedduskherb,R.drawable.divineblessing,R.drawable.repairpowder,R.drawable.greatmagicbarrier,R.drawable.bountifulsunlight,R.drawable.wrathofthegods,
                    R.drawable.greatchaosfireball)
                items = arrayOf(getString(R.string.flamberge),getString(R.string.lucerne),getString(R.string.black_flamestone_dagger),getString(R.string.yellow_quartz_longsword),getString(R.string.bound_hand_axe),
                    getString(R.string.homunculus_mace),getString(R.string.transgressors_staff),getString(R.string.transgressors_leather_shield),getString(R.string.black_flamestone_parma),getString(R.string.yellow_quartz_shield),
                    getString(R.string.bound_wooden_shield),getString(R.string.homunculus_wooden_shield),getString(R.string.crescent_sickle),getString(R.string.curved_twinblade),getString(R.string.spirit_tree_shield),
                    getString(R.string.bracing_knuckle_ring),getString(R.string.magic_arrow),getString(R.string.lightning_arrow),getString(R.string.magic_bolt),getString(R.string.lightning_bolt),getString(R.string.old_radiant_life_gem),
                    getString(R.string.wilted_dusk_herb),getString(R.string.divine_blessing),getString(R.string.repair_powder),getString(R.string.great_magic_barrier),getString(R.string.bountiful_sunlight),getString(R.string.wrath_of_the_gods),
                    getString(R.string.great_chaos_fireball))
                locationsImages = intArrayOf(R.drawable.brightstonecovetseldora)
                locations = arrayOf(getString(R.string.brightstone_cove_tseldora))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 28 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.milfanito) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.milfanitoframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.smoothandsilkystone,R.drawable.divineblessing,R.drawable.fireseed,R.drawable.ringofthedead)
                items = arrayOf(getString(R.string.smooth_and_silky_stone),getString(R.string.divine_blessing),getString(R.string.fire_seed),getString(R.string.ring_of_the_dead))
                locationsImages = intArrayOf(R.drawable.shrineofamana,R.drawable.drangleiccastle)
                locations = arrayOf(getString(R.string.shrine_of_amana),getString(R.string.drangleic_castle))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 4 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 2) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))
            }
            getString(R.string.grave_warden_agdayne) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.agdayneframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.shieldoftheinsolentframe,R.drawable.insolenthelm,R.drawable.insolentarmor,R.drawable.insolentgloves,R.drawable.insolentboots,R.drawable.ringofthorns,
                    R.drawable.darkarrow,R.drawable.darkbolt,R.drawable.humaneffigy,R.drawable.elizabethmushroom,R.drawable.soulspear,R.drawable.soulvortex,R.drawable.soulappease,R.drawable.warmth)
                items = arrayOf(getString(R.string.shield_of_the_insolent),getString(R.string.insolent_helm),getString(R.string.insolent_armor),getString(R.string.insolent_gloves),getString(R.string.insolent_boots),getString(R.string.ring_of_thorns),
                    getString(R.string.dark_arrow),getString(R.string.dark_bolt),getString(R.string.human_effigy),getString(R.string.elizabeth_mushroom),getString(R.string.soul_spear),getString(R.string.soul_vortex),getString(R.string.soul_appease),getString(R.string.warmth))
                locationsImages = intArrayOf(R.drawable.undeadcrypt)
                locations = arrayOf(getString(R.string.undead_crypt))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 14 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))

            }
            getString(R.string.royal_sorcerer_navlaan) -> {
                binding.ivImageCharacter.setImageResource(R.drawable.navlaanframe)
                binding.tvCharactersName.text = character
                itemsImages = intArrayOf(R.drawable.moonhat,R.drawable.astrologistsrobe,R.drawable.astrologistsgauntlets,R.drawable.astrologistsbottoms,R.drawable.blackwitchhat,R.drawable.blackwitchrobe,
                    R.drawable.blackwitchgloves,R.drawable.blackwitchtrousers,R.drawable.thunderquartzring,R.drawable.lightninggreatarrow,R.drawable.firegreatarrow,R.drawable.destructivegreatarrow,
                    R.drawable.dragoncharm,R.drawable.crimsonwater,R.drawable.bonfireascetic,R.drawable.greatmagicweapon,R.drawable.strongmagicshield)
                items = arrayOf(getString(R.string.moon_hat),getString(R.string.astrologists_robe),getString(R.string.astrologists_gauntlets),getString(R.string.astrologists_bottoms),getString(R.string.black_witch_hat),getString(R.string.black_witch_robe),
                    getString(R.string.black_witch_gloves),getString(R.string.black_witch_trousers),getString(R.string.thunder_quartz_ring),getString(R.string.lightning_greatarrow),getString(R.string.fire_greatarrow),getString(R.string.destructive_great_arrow),
                    getString(R.string.dragon_charm),getString(R.string.crimson_water),getString(R.string.bonfire_ascetic),getString(R.string.great_magic_weapon),getString(R.string.strong_magic_shield))
                locationsImages = intArrayOf(R.drawable.aldiaskeep)
                locations = arrayOf(getString(R.string.aldias_keep))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

                for (items in items.indices) if (modalListItems.size < 18 ) modalListItems.add(Modal(this.items[items],itemsImages[items]))
                for (items in locations.indices) if (modalListLocations.size < 1) modalListLocations.add(Modal(this.locations[items],locationsImages[items]))

            }
        }



        val adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListItems)
        binding.gridViewCharactersItems.adapter = adapter
        binding.gridViewCharactersItems.onItemClickListener


        val locationAdapter = ItemsAdapterItems(this.requireContext(),this)
        locationAdapter.setData(modalListLocations)
        binding.gridViewCharacterLocation.adapter = locationAdapter
        binding.gridViewCharacterLocation.onItemClickListener


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
        when (itemsModalItems.item.toString()){
            getString(R.string.things_betwixt) ->communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.majula) ->communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.forest_of_fallen_giants) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.heides_tower_of_flame) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.cathedral_of_blue) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.no_mans_wharf) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.lost_bastille) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.belfry_luna) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.sinners_rise) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.huntsmans_copse) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.undead_purgatory) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.harvest_valley) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.earthen_peak) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.iron_keep) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.belfry_sol) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.the_pit) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.grave_of_saints) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.the_gutter) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.black_gulch) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.shaded_woods) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.doors_of_pharros) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.brightstone_cove_tseldora) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.lords_private_chamber) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.shrine_of_winter) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.drangleic_castle) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.shrine_of_amana) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.undead_crypt) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.aldias_keep) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.dragon_aerie) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            getString(R.string.dragon_shrine) -> communicator.passDataCom(itemsModalItems.item.toString(),"locationFragment")
            else -> {
                if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
                    SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
                }
            }
        }

    }

}