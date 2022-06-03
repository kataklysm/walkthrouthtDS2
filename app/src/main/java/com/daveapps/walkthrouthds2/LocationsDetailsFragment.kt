package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
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
import androidx.fragment.app.FragmentTransaction
import com.daveapps.walkthrouthds2.databinding.FragmentLocationsDetailsBinding


class LocationsDetailsFragment : Fragment(), ItemsAdapterItems.ClickListener {
    private var _binding: FragmentLocationsDetailsBinding? = null
    private val binding get() = _binding!!

    private var transaction: FragmentTransaction? = null
    private var provider: String? = null
    private lateinit var communicator: Communicator
    private var location: String? = ""
    private var modalList = ArrayList<Modal>()
    private var modalListEnemies = ArrayList<ModalEnemies>()
    private var items = arrayOf("")
    private var images = intArrayOf()
    private var enemiesImages = intArrayOf()
    private var enemiesName = arrayOf("")
    private var characterNames = arrayOf("")
    private var characterImages = intArrayOf()
    private var modalListCharacters = ArrayList<Modal>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.location)
        setHasOptionsMenu(true)
        communicator = activity as Communicator
        _binding = FragmentLocationsDetailsBinding.inflate(inflater,container,false)

        location = arguments?.getString("name")
        provider = arguments?.getString("provider")
        binding.tvLocationDetails.text = location
        binding.tvLocationDetails.typeface = Typeface.createFromAsset(context?.assets,"fonts/optimussemibold.ttf")


        binding.tvExpandListCharacterLocation.setOnClickListener {
            expandList(binding.gridViewCharactersLocation,binding.ivExpandIconCharacters)
        }

        binding.tvExpandListEnemies.setOnClickListener {
            expandList(binding.gridViewEnemies,binding.ivExpandIconCharacters)
        }

        binding.tvExpandListItemsLocations.setOnClickListener {
            expandList(binding.gridViewItems,binding.ivExpandIconItemsLocation)
        }

        when(location){
            getString(R.string.things_betwixt) ->{
                binding.ivLocation.setImageResource(R.drawable.thingsbetwixtarea)
                images = intArrayOf(R.drawable.humaneffigy,R.drawable.estusflaskshard,R.drawable.amberherb, R.drawable.crackedredeyeorb, R.drawable.goldpineresin, R.drawable.lifegem,
                    R.drawable.rustedcoin,R.drawable.smallsmoothandsilkystone,R.drawable.soulofalostundead,R.drawable.soulofanamelesssoldier, R.drawable.petrifiedsomething,
                    R.drawable.stonering,R.drawable.dagger,R.drawable.handmaidsladle)
                items = arrayOf(getString(R.string.human_effigy),getString(R.string.estus_flask_shard),getString(R.string.amber_herb),getString(R.string.cracked_red_eye_orb),getString(R.string.gold_pine_resin),getString(R.string.life_gem),getString(R.string.rusted_coin),
                    getString(R.string.small_smooth_silky_stone),getString(R.string.soul_of_a_lost_undead),getString(R.string.soul_of_a_name_less_soldier),getString(R.string.petrified_something),getString(R.string.stone_ring),getString(R.string.dagger),getString(R.string.handmaids_ladle))
                enemiesImages = intArrayOf(R.drawable.ogre,R.drawable.prowlerhoundkobold,R.drawable.foreignwanderer,R.drawable.basilisk)
                enemiesName = arrayOf(getString(R.string.ogre),getString(R.string.prowler_hound_kobold),getString(R.string.foreign_wanderer),getString(R.string.basilisk))
                ////////////////////////////////////////NPCs
                characterImages = intArrayOf(R.drawable.milibeth,R.drawable.strowen,R.drawable.dynaandtillo)
                characterNames = arrayOf(getString(R.string.milibeth),getString(R.string.strowen),getString(R.string.dynatillo))
                for (items in items.indices) if (modalList.size < 14) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 4) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.majula) ->{
                binding.ivLocation.setImageResource(R.drawable.majulaarea)
                images = intArrayOf(R.drawable.humaneffigy,R.drawable.estusflask, R.drawable.estusflaskshard, R.drawable.titaniteshard, R.drawable.divineblessing,
                    R.drawable.lifegem, R.drawable.homewardbone, R.drawable.lloydstalisman, R.drawable.soulofanamelesssoldier, R.drawable.soulofalostundead,
                    R.drawable.soulvessel, R.drawable.rustedcoin, R.drawable.pharroslockstone, R.drawable.torch, R.drawable.ringoftheevileye, R.drawable.radiantlifegem,
                    R.drawable.clericssacredchime,R.drawable.crimsonparmaframe,R.drawable.morningstar,R.drawable.binoculars,R.drawable.shortbow,R.drawable.brokenstraightsword,
                    R.drawable.ringofthesteelprotection,R.drawable.flamequartzring)
                items = arrayOf(getString(R.string.human_effigy),getString(R.string.estus_flask),getString(R.string.estus_flask_shard),getString(R.string.titanite_shard),getString(R.string.divine_blessing),getString(R.string.life_gem),getString(R.string.homeward_bone),getString(R.string.lloyds_talisman),
                    getString(R.string.soul_of_a_name_less_soldier),getString(R.string.soul_of_a_lost_undead),getString(R.string.soul_vessel),getString(R.string.rusted_coin),getString(R.string.pharros_lockstone),getString(R.string.torch),getString(R.string.ring_of_the_evil_eye),getString(R.string.radiant_life_gem),
                    getString(R.string.clerics_sacred_chime), getString(R.string.crimson_parma),getString(R.string.morning_star),getString(R.string.binoculars),getString(R.string.short_bow),getString(R.string.broken_thief_sword),getString(R.string.ring_of_the_steel_protection),
                    getString(R.string.flame_quartz_ring))

                enemiesImages = intArrayOf(R.drawable.skeleton, R.drawable.undeaddevourer)
                enemiesName = arrayOf(getString(R.string.skeleton),getString(R.string.undead_devourer))
                ////////////////////////////////////////NPCs
                characterImages = intArrayOf(R.drawable.shanalotte,R.drawable.saulden,R.drawable.lenigrast,R.drawable.shalquoir,R.drawable.melentia,R.drawable.armourer,R.drawable.carhillion,R.drawable.rosabeth,
                    R.drawable.cale,R.drawable.chloanne,R.drawable.gilligan,R.drawable.licia)
                characterNames = arrayOf(getString(R.string.emerald_herald),getString(R.string.saulden),getString(R.string.lenigrast),getString(R.string.shalquoir),getString(R.string.melentia),getString(R.string.maughlin_the_armourer),getString(R.string.carhillion),getString(R.string.rosabeth),
                    getString(R.string.cale_the_cartographer),getString(R.string.stone_trader_chloanne),getString(R.string.laddersmith_gilligan),getString(R.string.licia_of_lindelt))

                for (items in items.indices) if (modalList.size < 24) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 2) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 11) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.forest_of_fallen_giants) ->{
                binding.ivLocation.setImageResource(R.drawable.forestoffallengiantsarea)
                images = intArrayOf(R.drawable.amberherb,R.drawable.aromaticooze,R.drawable.buckler,R.drawable.divineblessing,R.drawable.estusflaskshard,R.drawable.firearrow,
                    R.drawable.firedrakestone,R.drawable.greatsoularrow,R.drawable.greenblossom,R.drawable.halberd,R.drawable.homewardbone,R.drawable.humaneffigy,
                    R.drawable.largesoulofalostundead,R.drawable.largetitaniteshard,R.drawable.lifegem,R.drawable.oldradiantlifegem,R.drawable.repairpowder,R.drawable.seedofatreeofgiants,
                    R.drawable.smallwhitesignsoapstone,R.drawable.soulofaproudknight,R.drawable.titaniteslab,R.drawable.titanitechunk,R.drawable.throwingknife,R.drawable.twinklingtitanite,
                    R.drawable.whitesignsoapstone,R.drawable.witchingurn,R.drawable.woodbolt,R.drawable.blackfirebomb,R.drawable.largesoulofaproudknight,R.drawable.heavyironkey,R.drawable.footsoldiershieldframe,
                    R.drawable.grandlance,R.drawable.lifering,R.drawable.lightcrossbow,R.drawable.mailbreker,R.drawable.ringoftherestoration,R.drawable.soldierkey,R.drawable.longsword,
                    R.drawable.bastardsword,R.drawable.bluewoodenshieldframe,R.drawable.whip,R.drawable.rebelsgreatshieldframe,R.drawable.largeleathershieldframe,R.drawable.chloranthyring,R.drawable.handaxe,
                    R.drawable.shortsword,R.drawable.smallleathershieldframe,R.drawable.hawkring,R.drawable.drangleicmail,R.drawable.drangleicgauntlets,R.drawable.drangleicleggings,
                    R.drawable.huntershat,R.drawable.leatherarmor,R.drawable.leathergloves,R.drawable.leatherboots)
                items = arrayOf(getString(R.string.amber_herb),getString(R.string.aromatic_ooze),getString(R.string.buckler),getString(R.string.divine_blessing),getString(R.string.estus_flask_shard),getString(R.string.fire_arrow),getString(R.string.firedrake_stone),getString(R.string.great_soul_arrow),getString(R.string.green_blossom),getString(R.string.halberd),getString(R.string.homeward_bone),
                    getString(R.string.human_effigy),getString(R.string.large_soul_of_a_lost_undead),getString(R.string.large_titanite_shard),getString(R.string.life_gem),getString(R.string.old_radiant_life_gem),getString(R.string.repair_powder),getString(R.string.seed_of_a_tree_of_giants),getString(R.string.small_white_sign_soapstone),getString(R.string.soul_of_a_proud_knight),
                    getString(R.string.titanite_slab),getString(R.string.titanite_chunk),getString(R.string.throwing_knife),getString(R.string.twinkling_titanite),getString(R.string.white_sign_soapstone),getString(R.string.witching_urn),getString(R.string.wood_bolt),getString(R.string.black_firebomb),getString(R.string.large_soul_of_a_proud_knight),getString(R.string.heavy_iron_key),
                    getString(R.string.foot_soldier_shield),getString(R.string.grand_lance),getString(R.string.life_ring),getString(R.string.light_crossbow),getString(R.string.mail_breker),getString(R.string.ring_of_the_restoration),getString(R.string.soldier_key),getString(R.string.long_sword),getString(R.string.bastard_sword),getString(R.string.blue_wooden_shield),
                    getString(R.string.whip),getString(R.string.rebels_greats_shield),getString(R.string.large_leather_shield),getString(R.string.chloranthy_ring),getString(R.string.hand_axe),getString(R.string.shortsword),getString(R.string.small_leather_shield),getString(R.string.hawk_ring),getString(R.string.drangleic_mail),getString(R.string.drangleic_gauntlets),getString(R.string.drangleic_leggings),
                    getString(R.string.hunters_hat),getString(R.string.leather_armor),getString(R.string.leather_gloves),getString(R.string.leather_boots))
                enemiesImages = intArrayOf(R.drawable.ogre,R.drawable.hollowroyalsoldier,R.drawable.hollowinfantry,R.drawable.ironcladsoldier,R.drawable.ogre,R.drawable.flamelizard,
                    R.drawable.royalswordsman,R.drawable.syansoldier)
                enemiesName = arrayOf(getString(R.string.ogre),getString(R.string.hollow_royal_soldier),getString(R.string.hollow_infantry),getString(R.string.iron_clad_soldier),getString(R.string.ogre),getString(R.string.flame_lizard),
                    getString(R.string.royal_swordsman),getString(R.string.syan_soldier))
                ////////////////////////////////////////NPCs
                characterImages = intArrayOf(R.drawable.melentia,R.drawable.cale,R.drawable.pate)
                characterNames = arrayOf(getString(R.string.melentia),getString(R.string.cale_the_cartographer),getString(R.string.mild_mannered_pate))
                for (items in items.indices) if (modalList.size < 55) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 8) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                Toast.makeText(this.requireContext(),modalList.size.toString(), Toast.LENGTH_LONG).show()
                for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.heides_tower_of_flame) ->{
                binding.ivLocation.setImageResource(R.drawable.heidestowerofflamearea)
                images = intArrayOf(R.drawable.sublimebonedust,R.drawable.humaneffigy,R.drawable.divineblessing,R.drawable.soulofanamelesssoldier,R.drawable.oldradiantlifegem,R.drawable.darktroches,
                    R.drawable.estusflaskshard,R.drawable.petrifieddragonbone,R.drawable.monasterycharm,R.drawable.lloydstalisman,R.drawable.ringofbinding,R.drawable.oldknighthalberd,R.drawable.watchdragonparmaframe,
                    R.drawable.knighthelm,R.drawable.knightarmor,R.drawable.knightgauntlets,R.drawable.knightleggings)
                items = arrayOf(getString(R.string.sublime_bone_dust),getString(R.string.human_effigy),getString(R.string.divine_blessing),getString(R.string.soul_of_a_name_less_soldier),
                    getString(R.string.old_radiant_life_gem),getString(R.string.dark_troches),getString(R.string.estus_flask_shard),getString(R.string.petrified_dragon_bone),getString(R.string.monastery_charm),
                    getString(R.string.lloyds_talisman),getString(R.string.ring_of_binding),getString(R.string.old_knight_halberd),getString(R.string.watchdragon_parma),
                    getString(R.string.knight_helm),getString(R.string.knight_armor),getString(R.string.knight_gauntlets),getString(R.string.knight_leggings))
                enemiesImages = intArrayOf(R.drawable.oldknight,R.drawable.heideknight,R.drawable.hellkitedragon,R.drawable.hollowinfantry,R.drawable.basilisk,R.drawable.primalknight)
                enemiesName = arrayOf(getString(R.string.old_knight),getString(R.string.heide_knight),getString(R.string.hellkite_dragon),getString(R.string.hollow_infantry),getString(R.string.basilisk),getString(R.string.primal_knight))
                characterImages = intArrayOf(R.drawable.licia)
                characterNames = arrayOf(getString(R.string.licia_of_lindelt))
                for (items in items.indices) if (modalList.size < 17) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 6) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                //Toast.makeText(this.requireContext(),modalList.size.toString(),Toast.LENGTH_LONG).show()
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.cathedral_of_blue) ->{
                binding.ivLocation.setImageResource(R.drawable.cathedralofbluearea)
                images = intArrayOf(R.drawable.oldradiantlifegem,R.drawable.humaneffigy,R.drawable.crackedblueeyeorb,R.drawable.towershieldframe,R.drawable.clericsparma)
                items = arrayOf(getString(R.string.old_radiant_life_gem),getString(R.string.human_effigy),getString(R.string.cracked_blue_eye_orb),getString(R.string.tower_shield),getString(R.string.clerics_parma))
                enemiesImages = intArrayOf(0)
                enemiesName = arrayOf("")
                characterImages = intArrayOf(R.drawable.targray)
                characterNames = arrayOf(getString(R.string.blue_sentinel_targray))
                for (items in items.indices) if (modalList.size < 5) modalList.add(Modal(this.items[items],images[items]))
                //for (items in nameEnemies.indices) if (modalListEnemies.size < 6) modalListEnemies.add(ModalEnemies(this.nameEnemies[items],imagesEnemies[items]))
                //Toast.makeText(this.requireContext(),modalList.size.toString(),Toast.LENGTH_LONG).show()
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.no_mans_wharf) ->{
                binding.ivLocation.setImageResource(R.drawable.nomanswharfarea)
                images = intArrayOf(R.drawable.greatsword,R.drawable.royalsoldiersring,R.drawable.banditaxe,R.drawable.pyromancyflame,R.drawable.fireball,R.drawable.emitforce,
                    R.drawable.firebomb,R.drawable.flamebutterfly,R.drawable.repairpowder,R.drawable.humaneffigy,R.drawable.fragrantbranchofyore,R.drawable.fadingsoul,
                    R.drawable.largesoulofanamelesssoldier,R.drawable.ironarrow,R.drawable.largesoulofaproudknight,R.drawable.largetitaniteshard,R.drawable.titaniteshard,
                    R.drawable.darkpineresin,R.drawable.firearrow,R.drawable.silvertalisman)
                items = arrayOf(getString(R.string.great_sword),getString(R.string.royal_soldiers_ring),getString(R.string.bandit_axe),getString(R.string.pyromancy_flame),getString(R.string.fireball),getString(R.string.emit_force),
                    getString(R.string.fire_bomb),getString(R.string.flame_butterfly),getString(R.string.repair_powder),getString(R.string.human_effigy),getString(R.string.fragrant_branch_of_yore),getString(R.string.fading_soul),
                    getString(R.string.large_soul_of_a_nameless_soldier),getString(R.string.iron_arrow),getString(R.string.large_soul_of_a_proud_knight),getString(R.string.large_titanite_shard),getString(R.string.titanite_shard),
                    getString(R.string.dark_pine_resin),getString(R.string.fire_arrow),getString(R.string.silver_talisman))
                enemiesImages = intArrayOf(R.drawable.hollowvarangian,R.drawable.hollowinfantry,R.drawable.darkdweller,R.drawable.strayhounddog,R.drawable.nimbleshadow)
                enemiesName = arrayOf(getString(R.string.hollow_varangian),getString(R.string.hollow_infantry),getString(R.string.darkdweller),getString(R.string.stray_hound_dog),getString(R.string.nimble_shadow))
                characterImages = intArrayOf(R.drawable.carhillion,R.drawable.gavlan,R.drawable.lucatiel)
                characterNames = arrayOf(getString(R.string.carhillion),getString(R.string.lonesome_gavlan),getString(R.string.lucatiel_of_mirrah))

                for (items in items.indices) if (modalList.size < 20) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                //Toast.makeText(this.requireContext(),modalList.size.toString(),Toast.LENGTH_LONG).show()
                for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.lost_bastille) -> {
                binding.ivLocation.setImageResource(R.drawable.lostbastillearea)
                images = intArrayOf(R.drawable.dullember,R.drawable.estusflaskshard,R.drawable.largetitaniteshard,R.drawable.humaneffigy,R.drawable.alluringskull,R.drawable.soulofabravewarrior,R.drawable.goldpineresin,
                    R.drawable.heavybolt,R.drawable.titaniteshard,R.drawable.hush,R.drawable.rougewater,R.drawable.repairpowder,R.drawable.flamebutterfly,R.drawable.twinklingtitanite,R.drawable.antiquatedkey,
                    R.drawable.bonfireascetic,R.drawable.largeclub,R.drawable.targetshieldframe,R.drawable.scimitar,R.drawable.craftsmanshammer,R.drawable.covetoussilverserpentring,R.drawable.archdrakeshieldframe,
                    R.drawable.bonestaff,R.drawable.parryingdagger,R.drawable.twinblade,R.drawable.priestschime,R.drawable.bracingknucklering,R.drawable.wandererhood,R.drawable.wanderercoat,
                    R.drawable.wanderermanchettes,R.drawable.wandererboots,R.drawable.archdrakerobes)
                items = arrayOf(getString(R.string.dullember),getString(R.string.estus_flask_shard),getString(R.string.large_titanite_shard),getString(R.string.human_effigy),getString(R.string.alluring_skull),getString(R.string.soul_of_a_breave_warrior),getString(R.string.gold_pine_resin),
                    getString(R.string.heavy_bolt),getString(R.string.titanite_shard),getString(R.string.hush),getString(R.string.rouge_water),getString(R.string.repair_powder),getString(R.string.flame_butterfly),getString(R.string.twinkling_titanite),getString(R.string.antiquated_key),
                    getString(R.string.bonfire_ascetic),getString(R.string.large_club),getString(R.string.target_shield),getString(R.string.scimitar),getString(R.string.craftsmans_hammer),getString(R.string.covetous_silver_serpent_ring),getString(R.string.archdrake_shield),
                    getString(R.string.bone_staff),getString(R.string.parrying_dagger),getString(R.string.twinblade),getString(R.string.priest_schime),getString(R.string.bracing_knuckle_ring),getString(R.string.wanderer_hood),getString(R.string.wanderer_coat),
                    getString(R.string.wanderer_manchettes),getString(R.string.wanderer_boots),getString(R.string.archdrake_robes))
                enemiesImages = intArrayOf(R.drawable.royalswordsman,R.drawable.strayhounddog,R.drawable.undeadjailer,R.drawable.hollowprisoner,R.drawable.rupturinghollow)
                enemiesName = arrayOf(getString(R.string.royal_swordsman),getString(R.string.stray_hound_dog),getString(R.string.undead_jailer),getString(R.string.hollow_prisoner),getString(R.string.rupturing_hollow))
                characterImages = intArrayOf(R.drawable.lucatiel,R.drawable.mcduff,R.drawable.straid)
                characterNames = arrayOf(getString(R.string.lucatiel_of_mirrah),getString(R.string.steady_hand_mcduff),getString(R.string.straid_of_olaphis))
                for (items in items.indices) if (modalList.size < 32) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()
                for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.belfry_luna) -> {
                binding.ivLocation.setImageResource(R.drawable.belfrylunaarea)
                images = intArrayOf(R.drawable.skepticsspice,R.drawable.radiantlifegem,R.drawable.twilightherb,R.drawable.humaneffigy,R.drawable.petrifiedsomething,R.drawable.brightbug,R.drawable.bluetearstonering,
                    R.drawable.southernritual,R.drawable.dragontooth,R.drawable.falchion)
                items = arrayOf(getString(R.string.skeptics_spice),getString(R.string.radiant_life_gem),getString(R.string.twilight_herb),getString(R.string.human_effigy),getString(R.string.petrified_something),getString(R.string.brightbug),getString(R.string.blue_tearstone_ring),
                    getString(R.string.southern_ritual_band),getString(R.string.dragon_tooth),getString(R.string.falchion))
                enemiesImages = intArrayOf(R.drawable.strayhounddog,R.drawable.bellkeeper,R.drawable.vorgelthesinner)
                enemiesName = arrayOf(getString(R.string.stray_hound_dog),getString(R.string.bell_keeper_doll),getString(R.string.vorgel_the_sinner))
                for (items in items.indices) if (modalList.size < 10) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 3) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()
                //for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.sinners_rise) -> {
                binding.ivLocation.setImageResource(R.drawable.sinnersrisearea)
                images = intArrayOf(R.drawable.pharroslockstone,R.drawable.fragrantbranchofyore,R.drawable.elizabethmushroom,R.drawable.bleedstone,R.drawable.fireseed,R.drawable.largesoulofalostundead,
                    R.drawable.humaneffigy,R.drawable.soulofaproudknight,R.drawable.radiantlifegem,R.drawable.northernritualband,R.drawable.blossomkiteshieldframe,R.drawable.royalswordsmanhelm,R.drawable.royalswordsmanarmor,R.drawable.royalswordsmangloves,R.drawable.royalswordsmanleggings)
                items = arrayOf(getString(R.string.pharros_lockstone),getString(R.string.fragrant_branch_of_yore),getString(R.string.elizabeth_mushroom),getString(R.string.bleed_stone),getString(R.string.fire_seed),getString(R.string.large_soul_of_a_lost_undead),
                    getString(R.string.human_effigy),getString(R.string.soul_of_a_proud_knight),getString(R.string.radiant_life_gem),getString(R.string.northern_ritual_band),getString(R.string.blossom_kite_shield),getString(R.string.royal_swordsman_helm),getString(R.string.royal_swordsman_armor),getString(R.string.royal_swordsman_gloves),getString(R.string.royal_swordsman_leggings))
                enemiesImages = intArrayOf(R.drawable.rupturinghollow,R.drawable.undeadaberration,R.drawable.heideknight,R.drawable.royalswordsman)
                enemiesName = arrayOf(getString(R.string.rupturing_hollow),getString(R.string.undead_aberration),getString(R.string.heide_knight),getString(R.string.royal_swordsman))
                for (items in items.indices) if(modalList.size < 15) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 4) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
            }
            getString(R.string.huntsmans_copse) -> {
                binding.ivLocation.setImageResource(R.drawable.huntsmanscopsearea)
                images = intArrayOf(R.drawable.flamebutterfly,R.drawable.poisonmoss,R.drawable.banditsknife,R.drawable.pharroslockstone,R.drawable.tokenoffidelity,R.drawable.undeadlockawaykey,R.drawable.rougewater,
                    R.drawable.largesoulofalostundead,R.drawable.aromaticooze,R.drawable.morningstar,R.drawable.poisonthrowingknife,R.drawable.largetitaniteshard,R.drawable.titaniteshard,R.drawable.flamberge,
                    R.drawable.combustion,R.drawable.greenblossom,R.drawable.monasterycharm,R.drawable.ricardsrapier,R.drawable.notchedwhip,R.drawable.soulspear,R.drawable.mace,R.drawable.roguehood,
                    R.drawable.roguearmor,R.drawable.roguegauntlets,R.drawable.rogueleggings)
                items = arrayOf(getString(R.string.flame_butterfly),getString(R.string.poison_moss),getString(R.string.bandits_knife),getString(R.string.pharros_lockstone),getString(R.string.token_of_fidelity),getString(R.string.undead_lockaway_key),getString(R.string.rouge_water),
                    getString(R.string.large_soul_of_a_lost_undead),getString(R.string.aromatic_ooze),getString(R.string.morning_star),getString(R.string.poison_throwing_knife),getString(R.string.large_titanite_shard),getString(R.string.titanite_shard),getString(R.string.flamberge),
                    getString(R.string.combustion),getString(R.string.green_blossom),getString(R.string.monastery_charm),getString(R.string.ricards_rapier),getString(R.string.notched_whip),getString(R.string.soul_spear),getString(R.string.mace),getString(R.string.rogue_hood),
                    getString(R.string.rogue_armor),getString(R.string.rogue_gauntlets),getString(R.string.rogue_leggings))
                enemiesImages = intArrayOf(R.drawable.hollowprisoner, R.drawable.poisonmoth, R.drawable.undeadhuntsman,R.drawable.hollowrogue,R.drawable.skeleton, R.drawable.hollowmage,R.drawable.executioner, R.drawable.greatswordphantom,
                    R.drawable.mercilessroenna,R.drawable.forlorn)
                enemiesName = arrayOf(getString(R.string.hollow_prisoner), getString(R.string.poison_moth), getString(R.string.undead_huntsman),getString(R.string.hollow_rogue), getString(R.string.skeleton), getString(R.string.hollow_mage), getString(R.string.executioner), getString(R.string.greatsword_phantom),
                    getString(R.string.merciless_roenna),getString(R.string.forlorn))
                characterImages = intArrayOf(R.drawable.felkin,R.drawable.creighton)
                characterNames = arrayOf(getString(R.string.felkin_the_outcast),getString(R.string.creighton_of_mirrah))
                for (items in items.indices) if(modalList.size < 25) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 10) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 2) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
                //Toast.makeText(this.requireContext(),items.size.toString(),Toast.LENGTH_LONG).show()

            }
            getString(R.string.undead_purgatory) -> {
                binding.ivLocation.setImageResource(R.drawable.undeadpurgatoryarea)
                images = intArrayOf(R.drawable.soulofabravewarrior,R.drawable.crackedredeyeorb,R.drawable.fireseed)
                items = arrayOf(getString(R.string.soul_of_a_breave_warrior),getString(R.string.cracked_red_eye_orb),getString(R.string.fire_seed))
                enemiesImages = intArrayOf(R.drawable.hollowmage, R.drawable.skeleton)
                enemiesName = arrayOf(getString(R.string.hollow_mage),getString(R.string.skeleton))
                characterImages = intArrayOf(R.drawable.gren)
                characterNames = arrayOf(getString(R.string.titchy_gren))
                for (items in items.indices) if(modalList.size < 3) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 2) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.harvest_valley) -> {
                binding.ivLocation.setImageResource(R.drawable.harvestvalleyarea)
                images = intArrayOf(R.drawable.fragrantbranchofyore,R.drawable.rawstone,R.drawable.hexingurn,R.drawable.lifegem,R.drawable.fadingsoul,R.drawable.titaniteshard,R.drawable.torch,
                    R.drawable.smallsmoothandsilkystone,R.drawable.titanitechunk,R.drawable.fireseed,R.drawable.divineblessing,R.drawable.radiantlifegem,R.drawable.smallsmoothandsilkystone,
                    R.drawable.largetitaniteshard,R.drawable.simpletonsspice,R.drawable.skepticsspice,R.drawable.poisonstone,R.drawable.rottenpineresin,R.drawable.soulofanamelesssoldier,
                    R.drawable.titaniteslab,R.drawable.oldknightpike,R.drawable.oldknightgreatshieldframe,R.drawable.chameleon,R.drawable.washinpole,R.drawable.dragoncharm)
                items = arrayOf(getString(R.string.fragrant_branch_of_yore),getString(R.string.raw_stone),getString(R.string.hexing_urn),getString(R.string.life_gem),getString(R.string.fading_soul),getString(R.string.titanite_shard),getString(R.string.torch),
                    getString(R.string.small_smooth_silky_stone),getString(R.string.titanite_chunk),getString(R.string.fire_seed),getString(R.string.divine_blessing),getString(R.string.radiant_life_gem),getString(R.string.small_smooth_silky_stone),
                    getString(R.string.large_titanite_shard),getString(R.string.simpletons_spice),getString(R.string.skeptics_spice),getString(R.string.poison_stone),getString(R.string.rotten_pine_resin),getString(R.string.soul_of_a_name_less_soldier),
                    getString(R.string.titanite_slab),getString(R.string.old_knight_pike),getString(R.string.old_knight_greatshield),getString(R.string.chameleon),getString(R.string.washin_pole),getString(R.string.dragon_charm))
                enemiesImages = intArrayOf(R.drawable.banedigger,R.drawable.skeleton,R.drawable.hollowprisoner,R.drawable.undeadhuntsman,R.drawable.undeadsteelworker)
                enemiesName = arrayOf(getString(R.string.banedigger),getString(R.string.skeleton),getString(R.string.hollow_prisoner),getString(R.string.undead_huntsman),getString(R.string.undeadsteel_worker))
                characterImages = intArrayOf(R.drawable.chloanne,R.drawable.gavlan)
                characterNames = arrayOf(getString(R.string.stone_trader_chloanne),getString(R.string.lonesome_gavlan))
                for (items in items.indices) if(modalList.size < 26) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 2) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.earthen_peak) -> {
                binding.ivLocation.setImageResource(R.drawable.earthenpeakarea)
                images = intArrayOf(R.drawable.petrifiedsomething,R.drawable.simpletonsspice,R.drawable.humaneffigy,R.drawable.largesoulofaproudknight,R.drawable.divineblessing,R.drawable.heavybolt,R.drawable.estusflaskshard,
                    R.drawable.pharroslockstone,R.drawable.twinklingtitanite,R.drawable.skepticsspice,R.drawable.titaniteshard,R.drawable.soulofanamelesssoldier,R.drawable.soulofaproudknight,R.drawable.broadsword,
                    R.drawable.poisonbitering,R.drawable.mirrahshieldframe,R.drawable.heavycrossbow,R.drawable.lightningspear,R.drawable.greatheavysoularrow,R.drawable.manikinmask,R.drawable.manikintop,R.drawable.manikingloves,
                    R.drawable.manikinboots)
                items = arrayOf(getString(R.string.petrified_something),getString(R.string.simpletons_spice),getString(R.string.human_effigy),getString(R.string.large_soul_of_a_proud_knight),getString(R.string.divine_blessing),getString(R.string.heavy_bolt),getString(R.string.estus_flask_shard),
                    getString(R.string.pharros_lockstone),getString(R.string.twinkling_titanite),getString(R.string.skeptics_spice),getString(R.string.titanite_shard),getString(R.string.soul_of_a_name_less_soldier),getString(R.string.soul_of_a_proud_knight),getString(R.string.broadsword),
                    getString(R.string.poisonbite_ring),getString(R.string.mirrah_shield),getString(R.string.heavy_crossbow),getString(R.string.lightning_spear),getString(R.string.great_heavy_soul_arrow),getString(R.string.manikin_mask),getString(R.string.manikin_top),getString(R.string.manikin_gloves),
                    getString(R.string.manikin_boots))
                enemiesImages = intArrayOf(R.drawable.undeadsteelworker,R.drawable.poisonhornbeetle,R.drawable.desertsorceress,R.drawable.maskedmanikin,R.drawable.undeadhuntsman,R.drawable.gravewarden,R.drawable.entityofavarice)
                enemiesName = arrayOf(getString(R.string.undeadsteel_worker),getString(R.string.poison_horn_beetle),getString(R.string.desert_sorceress),getString(R.string.masked_manikin),getString(R.string.undead_huntsman),getString(R.string.grave_warden),getString(R.string.entity_of_avarice))
                characterImages = intArrayOf(R.drawable.lucatiel,R.drawable.gilligan,R.drawable.pate)
                characterNames = arrayOf(getString(R.string.lucatiel_of_mirrah),getString(R.string.laddersmith_gilligan),getString(R.string.mild_mannered_pate))
                for (items in items.indices) if(modalList.size < 23) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 7) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 3) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.iron_keep) -> {
                binding.ivLocation.setImageResource(R.drawable.ironkeeparea)
                images = intArrayOf(R.drawable.petrifieddragonbone,R.drawable.ironkey,R.drawable.petrifiedsomething,R.drawable.twinklingtitanite,R.drawable.pharroslockstone,R.drawable.largetitaniteshard,
                    R.drawable.oldradiantlifegem,R.drawable.greenblossom,R.drawable.soulofaproudknight,R.drawable.repairpowder,R.drawable.wingedspear,R.drawable.destructivegreatarrow,R.drawable.simpletonsspice,
                    R.drawable.porcineshieldframe,R.drawable.blackknightgreataxe,R.drawable.covetousgoldserpentring,R.drawable.zweihander,R.drawable.lifering,R.drawable.phoenixparmaframe)
                items = arrayOf(getString(R.string.petrified_dragon_bone),getString(R.string.iron_key),getString(R.string.petrified_something),getString(R.string.twinkling_titanite),getString(R.string.pharros_lockstone),getString(R.string.large_titanite_shard),
                    getString(R.string.old_radiant_life_gem),getString(R.string.green_blossom),getString(R.string.soul_of_a_proud_knight),getString(R.string.repair_powder),getString(R.string.winged_spear),getString(R.string.destructive_great_arrow),getString(R.string.simpletons_spice),
                    getString(R.string.porcine_shield),getString(R.string.black_knight_greataxe),getString(R.string.covetous_gold_serpent_ring),getString(R.string.zweihander),getString(R.string.life_ring),getString(R.string.phoenix_parma))
                enemiesImages = intArrayOf(R.drawable.alonneknight,R.drawable.alonneknightcaptain,R.drawable.ironcladsoldier,R.drawable.fencersharron,R.drawable.armorerdennis,R.drawable.oliverthecollector)
                enemiesName = arrayOf(getString(R.string.alonne_knight),getString(R.string.alonne_knight_captain),getString(R.string.iron_clad_soldier),getString(R.string.fencer_sharron),getString(R.string.armorer_dennis),getString(R.string.oliver_the_collector))
                characterImages = intArrayOf(R.drawable.magerold)
                characterNames = arrayOf(getString(R.string.magerold_of_lanafir))
                for (items in items.indices) if(modalList.size < 19) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 7) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.belfry_sol) -> {
                binding.ivLocation.setImageResource(R.drawable.belfrysolarea)
                images = intArrayOf(R.drawable.simpletonsspice,R.drawable.immolation,R.drawable.humaneffigy,R.drawable.triclopssnaketroches)
                items = arrayOf(getString(R.string.simpletons_spice),getString(R.string.immolation),getString(R.string.human_effigy),getString(R.string.triclops_snake_troches))
                enemiesImages = intArrayOf(R.drawable.bellkeeperdoll,R.drawable.bellkeepermage,R.drawable.dualavelynbellkeeper)
                enemiesName = arrayOf(getString(R.string.bell_keeper_doll),getString(R.string.bell_keeper_mage),getString(R.string.dual_avelyn_bell_keeper))
                characterImages = intArrayOf(R.drawable.bellkeeper)
                characterNames = arrayOf(getString(R.string.bell_keeper))
                for (items in items.indices) if(modalList.size < 19) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 3) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.the_pit) -> {
                binding.ivLocation.setImageResource(R.drawable.thepitarea)
                images = intArrayOf(R.drawable.soulvortex,R.drawable.radiantlifegem,R.drawable.pharroslockstone,R.drawable.poisonmoss)
                items = arrayOf(getString(R.string.soul_vortex),getString(R.string.radiant_life_gem),getString(R.string.pharros_lockstone),getString(R.string.poison_moss))
                enemiesImages = intArrayOf(0)
                enemiesName = arrayOf("")
                for (items in items.indices) if(modalList.size < 4) modalList.add(Modal(this.items[items],images[items]))

            }
            getString(R.string.grave_of_saints) -> {
                binding.ivLocation.setImageResource(R.drawable.graveofsaintsarea)
                images = intArrayOf(R.drawable.repairpowder,R.drawable.largesoulofanamelesssoldier,R.drawable.warmth,R.drawable.smallsmoothandsilkystone,R.drawable.homewardbone,R.drawable.poisonmoss,
                    R.drawable.whisperdespair,R.drawable.torch,R.drawable.pharroslockstone,R.drawable.sublimebonedust,R.drawable.ashknucklering,R.drawable.crestoftherat)
                items = arrayOf(getString(R.string.repair_powder),getString(R.string.large_soul_of_a_nameless_soldier),getString(R.string.warmth),getString(R.string.small_smooth_silky_stone),getString(R.string.homeward_bone),getString(R.string.poison_moss),
                    getString(R.string.whisper_despair),getString(R.string.torch),getString(R.string.pharros_lockstone),getString(R.string.sublime_bone_dust),getString(R.string.ash_knuckle_ring),getString(R.string.crest_of_the_rat))
                enemiesImages = intArrayOf(R.drawable.abandonedhollow,R.drawable.rhoytheexplorer,R.drawable.rupturinghollow,R.drawable.crystallizard, R.drawable.corpserat)
                enemiesName = arrayOf(getString(R.string.abandoned_hollow),getString(R.string.rhoy_the_explorer),getString(R.string.rupturing_hollow),getString(R.string.crystal_lizard),getString(R.string.corpse_rat))
                characterImages = intArrayOf(R.drawable.ratking)
                characterNames = arrayOf(getString(R.string.rat_king))
                for (items in items.indices) if(modalList.size < 12) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.the_gutter) -> {
                binding.ivLocation.setImageResource(R.drawable.thegutterarea)
                images = intArrayOf(R.drawable.estusflaskshard,R.drawable.twinklingtitanite,R.drawable.fragrantbranchofyore,R.drawable.darkpyromancyflame,R.drawable.flamebutterfly,R.drawable.titanitechunk,R.drawable.darkfog,
                    R.drawable.smallsmoothandsilkystone,R.drawable.greatclub,R.drawable.wickedeyegreatshield,R.drawable.ringofthesoulprotection,R.drawable.heidelance,R.drawable.wingedspear)
                items = arrayOf(getString(R.string.estus_flask_shard),getString(R.string.twinkling_titanite),getString(R.string.fragrant_branch_of_yore),getString(R.string.dark_pyromancy_flame),getString(R.string.flame_butterfly),getString(R.string.titanite_chunk),getString(R.string.dark_fog),
                    getString(R.string.small_smooth_silky_stone),getString(R.string.great_club),getString(R.string.wicked_eye_greatshield),getString(R.string.ring_of_the_soul_protection),getString(R.string.heide_lance),getString(R.string.winged_spear))
                enemiesImages = intArrayOf(R.drawable.abandonedhollow,R.drawable.huntingdog,R.drawable.rupturinghollow,R.drawable.poisonhornbeetle,R.drawable.darksucker,R.drawable.mimic)
                enemiesName = arrayOf(getString(R.string.abandoned_hollow),getString(R.string.hunting_dog),getString(R.string.rupturing_hollow),getString(R.string.poison_horn_beetle),getString(R.string.dark_sucker),getString(R.string.mimic))
                for (items in items.indices) if(modalList.size < 13) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 6) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))

            }
            getString(R.string.black_gulch) -> {
                binding.ivLocation.setImageResource(R.drawable.theblackgulcharea)
                images = intArrayOf(R.drawable.fireseed,R.drawable.silvertalisman,R.drawable.petrifiedsomething,R.drawable.simpletonsspice,R.drawable.skepticsspice,R.drawable.greatmagicweapon,R.drawable.scrapsoflife,
                    R.drawable.pharroslockstone,R.drawable.forgottenkey,R.drawable.soulofagiant,R.drawable.petrifieddragonbone,R.drawable.shotel,R.drawable.ringofgiants)
                items = arrayOf(getString(R.string.fire_seed),getString(R.string.silver_talisman),getString(R.string.petrified_something),getString(R.string.simpletons_spice),getString(R.string.skeptics_spice),getString(R.string.great_magic_weapon),getString(R.string.scraps_of_life),
                    getString(R.string.pharros_lockstone),getString(R.string.forgotten_key),getString(R.string.soul_of_a_giant),getString(R.string.petrified_dragon_bone),getString(R.string.shotel),getString(R.string.ring_of_giants))
                enemiesImages = intArrayOf(R.drawable.darksucker,R.drawable.razorbacknightcrawle,R.drawable.elitegiant,R.drawable.woodlandchildgully,R.drawable.forlorn)
                enemiesName = arrayOf(getString(R.string.dark_sucker),getString(R.string.razorback_nightcrawle),getString(R.string.elite_giant),getString(R.string.woodland_child_gully),getString(R.string.forlorn))
                characterImages = intArrayOf(R.drawable.grandahl,R.drawable.lucatiel)
                characterNames = arrayOf(getString(R.string.darkdiver_grandahl),getString(R.string.lucatiel_of_mirrah))
                for (items in items.indices) if(modalList.size < 13) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 2) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.shaded_woods) ->{
                binding.ivLocation.setImageResource(R.drawable.shadedwoodsarea)
                images = intArrayOf(R.drawable.humaneffigy,R.drawable.fragrantbranchofyore,R.drawable.pharroslockstone,R.drawable.homingsoulmass,R.drawable.twinklingtitanite,R.drawable.repair,
                    R.drawable.oldsunring,R.drawable.chloranthyring,R.drawable.clearbluestonering,R.drawable.redtearstonering,R.drawable.ringoflifeprotection,R.drawable.dragonslayerscrescentaxe,
                    R.drawable.blackknighthalberd,R.drawable.scythe)
                items = arrayOf(getString(R.string.human_effigy),getString(R.string.fragrant_branch_of_yore),getString(R.string.pharros_lockstone),getString(R.string.homing_soul_mass),getString(R.string.twinkling_titanite),getString(R.string.repair),
                    getString(R.string.old_sun_ring),getString(R.string.chloranthy_ring),getString(R.string.clear_bluestone_ring),getString(R.string.red_tearstone_ring),getString(R.string.ring_of_life_protection),getString(R.string.dragonslayers_crescent_axe),
                    getString(R.string.black_knight_halberd),getString(R.string.scythe))
                characterImages = intArrayOf(R.drawable.grandahl,R.drawable.vengarl,R.drawable.creighton,R.drawable.tark,R.drawable.ornifex)
                characterNames = arrayOf(getString(R.string.darkdiver_grandahl),getString(R.string.head_of_vengarl),getString(R.string.creighton_of_mirrah),getString(R.string.manscorpion_tark),getString(R.string.weaponsmith_ornifex))
                enemiesImages = intArrayOf(R.drawable.forestguardian,R.drawable.goblin,R.drawable.lionclanwarrior,R.drawable.hollowfalconer,R.drawable.basilisk,R.drawable.headlessvengarl)
                enemiesName = arrayOf(getString(R.string.forest_guardian),getString(R.string.goblin),getString(R.string.lion_clan_warrior),getString(R.string.hollow_falconer),getString(R.string.basilisk),getString(R.string.headless_vengarl))
                for (items in items.indices) if(modalList.size < 14) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 6) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 5) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.doors_of_pharros) -> {
                binding.ivLocation.setImageResource(R.drawable.doorsofpharros)
                images = intArrayOf(R.drawable.amberherb,R.drawable.twistedbarricade,R.drawable.soulofaproudknight,R.drawable.titanitechunk,R.drawable.petrifieddragonbone,R.drawable.pharroslockstone,R.drawable.largesoulofabravewarrior,
                    R.drawable.torch,R.drawable.rattail,R.drawable.lifegem,R.drawable.dragoncharm,R.drawable.radiantlifegem,R.drawable.prismstone,R.drawable.twinklingtitanite,R.drawable.faintstone,R.drawable.santiersspear,
                    R.drawable.gyrmaxe,R.drawable.gyrmgreathammer)
                items = arrayOf(getString(R.string.amber_herb),getString(R.string.twisted_barricade),getString(R.string.soul_of_a_proud_knight),getString(R.string.titanite_chunk),getString(R.string.petrified_dragon_bone),getString(R.string.pharros_lockstone),getString(R.string.large_soul_of_a_brave_warrior),
                    getString(R.string.torch),getString(R.string.rat_tail),getString(R.string.life_gem),getString(R.string.dragon_charm),getString(R.string.radiant_life_gem),getString(R.string.prism_stone),getString(R.string.twinkling_titanite),getString(R.string.faint_stone),getString(R.string.santiers_spear),
                    getString(R.string.gyrm_axe),getString(R.string.gyrm_great_hammer))
                enemiesImages = intArrayOf(R.drawable.crystallizard,R.drawable.mongrelrat,R.drawable.primalknight,R.drawable.gyrmwarrior,R.drawable.bowmanguthry)
                enemiesName = arrayOf(getString(R.string.crystal_lizard),getString(R.string.mongrel_rat),getString(R.string.primal_knight),getString(R.string.gyrm_warrior),getString(R.string.bowman_guthry))
                characterImages = intArrayOf(R.drawable.gavlan)
                characterNames = arrayOf(getString(R.string.lonesome_gavlan))
                for (items in items.indices) if(modalList.size < 18) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.brightstone_cove_tseldora) -> {
                binding.ivLocation.setImageResource(R.drawable.brightstonecovetseldoraarea)
                images = intArrayOf(R.drawable.estusflaskshard,R.drawable.staffofwisdom,R.drawable.fireseed,R.drawable.fragrantbranchofyore,R.drawable.greatfireball,R.drawable.heavybolt,R.drawable.largesoulofaproudknight,
                    R.drawable.laceratingarrow,R.drawable.largetitaniteshard,R.drawable.petrifieddragonbone,R.drawable.pharroslockstone,R.drawable.soulofanamelesssoldier,R.drawable.soulvortex,R.drawable.southernritual,
                    R.drawable.titaniteshard,R.drawable.titanitechunk,R.drawable.titaniteslab,R.drawable.twinklingtitanite,R.drawable.blackknightultragreatsword,R.drawable.clericsmallshield,R.drawable.crescentaxe,
                    R.drawable.pickaxe,R.drawable.darkquartzring,R.drawable.engravedgauntlets,R.drawable.priestessheadpiece,R.drawable.priestessrobe,R.drawable.priestessgloves,R.drawable.priestessskirt)
                items = arrayOf(getString(R.string.estus_flask_shard),getString(R.string.staff_of_wisdom),getString(R.string.fire_seed),getString(R.string.fragrant_branch_of_yore),getString(R.string.great_fireball),getString(R.string.heavy_bolt),getString(R.string.large_soul_of_a_proud_knight),
                    getString(R.string.lacerating_arrow),getString(R.string.large_titanite_shard),getString(R.string.petrified_dragon_bone),getString(R.string.pharros_lockstone),getString(R.string.soul_of_a_name_less_soldier),getString(R.string.soul_vortex),getString(R.string.southern_ritual_band),
                    getString(R.string.titanite_shard),getString(R.string.titanite_chunk),getString(R.string.titanite_slab),getString(R.string.twinkling_titanite),getString(R.string.black_knight_ultra_greatsword),getString(R.string.clerics_small_shield),getString(R.string.crescent_axe),
                    getString(R.string.pick_axe),getString(R.string.dark_quartz_ring),getString(R.string.engraved_gauntlets),getString(R.string.priestess_headpiece),getString(R.string.priestess_robe),getString(R.string.priestess_gloves),getString(R.string.priestess_skirt))
                enemiesImages = intArrayOf(R.drawable.undeaddevourer,R.drawable.hollowfalconer,R.drawable.spiderdrone,R.drawable.hollowpeasant,R.drawable.ducalspider,R.drawable.hollowmage,R.drawable.basilisk,
                    R.drawable.prowlerhoundkobold,R.drawable.giantbasilisk,R.drawable.dragonacolyte,R.drawable.poisonhornbeetle,R.drawable.aslatielofmirrah,R.drawable.mimic,R.drawable.ogre)
                enemiesName = arrayOf(getString(R.string.undead_devourer),getString(R.string.hollow_falconer),getString(R.string.spider_drone),getString(R.string.hollow_peasant),getString(R.string.ducal_spider),getString(R.string.hollow_mage),getString(R.string.basilisk),
                    getString(R.string.prowler_hound_kobold),getString(R.string.giant_basilisk),getString(R.string.dragon_acolyte),getString(R.string.poison_horn_beetle),getString(R.string.aslatiel_of_mirrah),getString(R.string.mimic),getString(R.string.ogre))
                characterImages = intArrayOf(R.drawable.cromwell,R.drawable.ornifex,R.drawable.pate,R.drawable.creighton)
                characterNames = arrayOf(getString(R.string.cromwell_the_pardoner),getString(R.string.weaponsmith_ornifex),getString(R.string.mild_mannered_pate),getString(R.string.creighton_of_mirrah))
                for (items in items.indices) if(modalList.size < 33) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 14) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 4) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.lords_private_chamber) -> {
                binding.ivLocation.setImageResource(R.drawable.lordsprivatechamberarea)
                images = intArrayOf(R.drawable.brightstonekey,R.drawable.fragrantbranchofyore,R.drawable.darkquartzring,R.drawable.vengarlsarmor,R.drawable.vengarlsgloves,R.drawable.vengarlsboots)
                items = arrayOf(getString(R.string.brightstone_key),getString(R.string.fragrant_branch_of_yore),getString(R.string.dark_quartz_ring),getString(R.string.vengarls_armor),getString(R.string.vengarls_gloves),getString(R.string.vengarls_boots))
                enemiesImages = intArrayOf(R.drawable.tseldoransettler,R.drawable.headlessvengarl)
                enemiesName = arrayOf(getString(R.string.tseldoran_settler),getString(R.string.headless_vengarl))
                for (items in items.indices) if(modalList.size < 6) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 2) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))

            }
            getString(R.string.shrine_of_winter) -> {
                binding.ivLocation.setImageResource(R.drawable.shrineofwinterarea)
                images = intArrayOf(R.drawable.divineblessing,R.drawable.largesoulofanamelesssoldier,R.drawable.humaneffigy,R.drawable.holywaterurn)
                items = arrayOf(getString(R.string.divine_blessing),getString(R.string.large_soul_of_a_nameless_soldier),getString(R.string.human_effigy),getString(R.string.holy_water_urn))
                enemiesImages = intArrayOf(R.drawable.forestguardian,R.drawable.royalsoldier,R.drawable.crystallizard)
                enemiesName = arrayOf(getString(R.string.forest_guardian),getString(R.string.royal_soldier),getString(R.string.crystal_lizard))
                for (items in items.indices) if(modalList.size < 4) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 3) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))

            }
            getString(R.string.drangleic_castle) -> {
                binding.ivLocation.setImageResource(R.drawable.drangleiccastlearea)
                images = intArrayOf(R.drawable.sublimebonedust,R.drawable.frozenflower,R.drawable.titaniteslab,R.drawable.greatcombustion,R.drawable.firestorm,R.drawable.fireseed,R.drawable.soulvessel,
                    R.drawable.strongmagicshield,R.drawable.huntersblackbow,R.drawable.estusflaskshard,R.drawable.oldradiantlifegem,R.drawable.monasterycharm,R.drawable.soulofahero,R.drawable.corrosiveurn,
                    R.drawable.elizabethmushroom,R.drawable.caithaschime,R.drawable.gowersringofprotection,R.drawable.stonesoldierspear,R.drawable.stonetwinblade,R.drawable.soulgreatsword,R.drawable.spellquartzring,
                    R.drawable.faraamhelm,R.drawable.faraamarmor,R.drawable.faraamgauntlets,R.drawable.faraamboots)
                items = arrayOf(getString(R.string.sublime_bone_dust),getString(R.string.frozen_flower),getString(R.string.titanite_slab),getString(R.string.great_combustion),getString(R.string.fire_storm),getString(R.string.fire_seed),getString(R.string.soul_vessel),
                    getString(R.string.strong_magic_shield),getString(R.string.hunters_black_bow),getString(R.string.estus_flask_shard),getString(R.string.radiant_life_gem),getString(R.string.monastery_charm),getString(R.string.soul_of_a_hero),getString(R.string.corrosive_urn),
                    getString(R.string.elizabeth_mushroom),getString(R.string.caithas_chime),getString(R.string.gowers_ring_of_protection),getString(R.string.stone_soldier_spear),getString(R.string.stone_twinblade),getString(R.string.soul_greatsword),getString(R.string.spell_quartz_ring),
                    getString(R.string.faraam_helm),getString(R.string.faraam_armor),getString(R.string.faraam_gauntlets),getString(R.string.faraam_boots))
                enemiesImages = intArrayOf(R.drawable.royalswordsman,R.drawable.stonesoldier,R.drawable.crystallizard,R.drawable.primalknight)
                enemiesName = arrayOf(getString(R.string.royal_swordsman),getString(R.string.stone_soldier),getString(R.string.crystal_lizard),getString(R.string.primal_knight))
                characterImages = intArrayOf(R.drawable.wellager,R.drawable.grandahl)
                characterNames = arrayOf(getString(R.string.chancellor_wellager),getString(R.string.darkdiver_grandahl))
                for (items in items.indices) if(modalList.size < 25) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 4) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 2) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.shrine_of_amana) -> {
                binding.ivLocation.setImageResource(R.drawable.shrineofamanaarea)
                images = intArrayOf(R.drawable.skepticsspice,R.drawable.torch,R.drawable.oldradiantlifegem,R.drawable.wiltedduskherb,R.drawable.crimsonwater,R.drawable.elizabethmushroom,R.drawable.flamebutterfly,R.drawable.twinklingtitanite,
                    R.drawable.dragoncharm,R.drawable.estusflaskshard,R.drawable.fireseed,R.drawable.sunlightblade,R.drawable.souloftheking,R.drawable.firetempest,R.drawable.homingcrystalsoulmass,R.drawable.alluringskull,R.drawable.soulofahero,
                    R.drawable.divineblessing,R.drawable.petrifieddragonbone,R.drawable.soulofaproudknight,R.drawable.greenblossom,R.drawable.keytotheembedded,R.drawable.magicarrow,R.drawable.manslayer,R.drawable.helixhalberd,R.drawable.lifering,
                    R.drawable.redirontwinblade,R.drawable.kingscrown,R.drawable.kingsarmor,R.drawable.kingsgauntlets,R.drawable.kingsleggings,R.drawable.singersdress)
                items = arrayOf(getString(R.string.skeptics_spice),getString(R.string.torch),getString(R.string.old_radiant_life_gem),getString(R.string.wilted_dusk_herb),getString(R.string.crimson_water),getString(R.string.elizabeth_mushroom),getString(R.string.flame_butterfly),getString(R.string.twinkling_titanite),
                    getString(R.string.dragon_charm),getString(R.string.estus_flask_shard),getString(R.string.fire_seed),getString(R.string.sunlight_blade),getString(R.string.soul_of_the_king),getString(R.string.fire_tempest),getString(R.string.homing_crystal_soulmass),getString(R.string.alluring_skull),getString(R.string.soul_of_a_hero),
                    getString(R.string.divine_blessing),getString(R.string.petrified_dragon_bone),getString(R.string.soul_of_a_proud_knight),getString(R.string.green_blossom),getString(R.string.key_to_the_embedded),getString(R.string.magic_arrow),getString(R.string.manslayer),getString(R.string.helix_halberd),getString(R.string.life_ring),
                    getString(R.string.red_iron_twinblade),getString(R.string.kings_crow),getString(R.string.kings_armor),getString(R.string.kings_gauntlets),getString(R.string.kings_leggings),getString(R.string.singers_dress))
                enemiesImages = intArrayOf(R.drawable.basilisk,R.drawable.archdrakepilgrim,R.drawable.amanapriestess,R.drawable.aldiawarlock,R.drawable.amanaaberration,R.drawable.ogre,R.drawable.poisonhornbeetle,
                    R.drawable.greatpoisonbrumer)
                enemiesName = arrayOf(getString(R.string.basilisk),getString(R.string.archdrake_pilgrim),getString(R.string.amana_priestess),getString(R.string.aldia_warlock),getString(R.string.amana_aberration),getString(R.string.ogre),getString(R.string.poison_horn_beetle),
                    getString(R.string.great_poison_brumer))
                characterImages = intArrayOf(R.drawable.milfanito)
                characterNames = arrayOf(getString(R.string.milfanito))
                for (items in items.indices) if(modalList.size < 32) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 8) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))
            }
            getString(R.string.undead_crypt) -> {
                binding.ivLocation.setImageResource(R.drawable.undeadcryptarea)
                images = intArrayOf(R.drawable.radiantlifegem,R.drawable.largesoulofanamelesssoldier,R.drawable.simpletonsspice,R.drawable.soulofagreathero, R.drawable.crushedeyeorb,R.drawable.fireseed,
                    R.drawable.driedfingers,R.drawable.titanitechunk,R.drawable.petrifieddragonbone,R.drawable.bonfireascetic,R.drawable.magicstone,R.drawable.twinklingtitanite,R.drawable.firebomb,
                    R.drawable.soulofalostundead,R.drawable.divineblessing,R.drawable.heavybolt,R.drawable.soulofahero,R.drawable.largesoulofaproudknight,R.drawable.dragoncharm,R.drawable.darknightstone,
                    R.drawable.soulvessel,R.drawable.torch,R.drawable.fragrantbranchofyore,R.drawable.avelyn,R.drawable.greatlightningspear,R.drawable.bracingknucklering,R.drawable.olenfordsstaff,
                    R.drawable.maceoftheinsolent)
                items = arrayOf(getString(R.string.radiant_life_gem),getString(R.string.large_soul_of_a_nameless_soldier),getString(R.string.simpletons_spice), getString(R.string.soul_of_a_great_hero),getString(R.string.crushed_eye_orb),getString(R.string.fire_seed),getString(R.string.dried_fingers),
                    getString(R.string.titanite_chunk),getString(R.string.petrified_dragon_bone),getString(R.string.bonfire_ascetic),getString(R.string.magic_stone),getString(R.string.twinkling_titanite),getString(R.string.fire_bomb),getString(R.string.soul_of_a_lost_undead),
                    getString(R.string.divine_blessing),getString(R.string.heavy_bolt),getString(R.string.soul_of_a_hero),getString(R.string.large_soul_of_a_proud_knight),getString(R.string.dragon_charm),getString(R.string.darknight_stone),getString(R.string.soul_vessel),
                    getString(R.string.torch),getString(R.string.fragrant_branch_of_yore),getString(R.string.avelyn),getString(R.string.great_lightning_spears),getString(R.string.bracing_knuckle_ring),getString(R.string.olenfords_staff),getString(R.string.mace_of_the_insolent))
                enemiesImages = intArrayOf(R.drawable.leydiawitch,R.drawable.leydiapyromancer,R.drawable.imperiousknight,R.drawable.wallspectre, R.drawable.hollowprisoner,R.drawable.gravewarden,
                    R.drawable.syansoldier,R.drawable.namelessusurper)
                enemiesName = arrayOf(getString(R.string.leydia_witch),getString(R.string.leydia_pyromancer),getString(R.string.imperious_knight),getString(R.string.wall_spectre),getString(R.string.hollow_prisoner),getString(R.string.grave_warden),
                    getString(R.string.syan_soldier),getString(R.string.nameless_usurper))
                characterImages = intArrayOf(R.drawable.agdayne)
                characterNames = arrayOf(getString(R.string.grave_warden_agdayne))
                for (items in items.indices) if(modalList.size < 28) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 8) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.aldias_keep) -> {

                binding.ivLocation.setImageResource(R.drawable.aldiaskeeparea)
                images= intArrayOf(R.drawable.soulofanamelesssoldier,R.drawable.petrifieddragonbone,R.drawable.poisonthrowingknife,R.drawable.alluringskull,R.drawable.fireseed,R.drawable.radiantlifegem,R.drawable.twilightherb,
                    R.drawable.fadingsoul,R.drawable.crimsonwater,R.drawable.bonfireascetic,R.drawable.greatmagicbarrier,R.drawable.pharroslockstone,R.drawable.largesoulofanamelesssoldier,R.drawable.corrosiveurn,
                    R.drawable.aldiakey,R.drawable.soulgeyser,R.drawable.soulofaproudknight,R.drawable.largesoulofabravewarrior,R.drawable.malformedshell,R.drawable.malformedskull,R.drawable.wiltedduskherb,
                    R.drawable.elizabethmushroom,R.drawable.northernritualband,R.drawable.moonhat,R.drawable.astrologistsrobe,R.drawable.astrologistsgauntlets,R.drawable.astrologistsbottoms)

                items = arrayOf(getString(R.string.soul_of_a_name_less_soldier),getString(R.string.petrified_dragon_bone),getString(R.string.poison_throwing_knife),getString(R.string.alluring_skull),getString(R.string.fire_seed),getString(R.string.radiant_life_gem),getString(R.string.twilight_herb),
                    getString(R.string.fading_soul),getString(R.string.crimson_water),getString(R.string.bonfire_ascetic),getString(R.string.great_magic_barrier),getString(R.string.pharros_lockstone),getString(R.string.large_soul_of_a_nameless_soldier),getString(R.string.corrosive_urn),
                    getString(R.string.aldia_key),getString(R.string.soul_geyser),getString(R.string.soul_of_a_proud_knight),getString(R.string.large_soul_of_a_brave_warrior),getString(R.string.malformed_shell),getString(R.string.malformed_skull),getString(R.string.wilted_dusk_herb),
                    getString(R.string.elizabeth_mushroom),getString(R.string.northern_ritual_band),getString(R.string.moon_hat),getString(R.string.astrologists_robe),getString(R.string.astrologists_gauntlets),getString(R.string.astrologists_bottoms))
                enemiesImages = intArrayOf(R.drawable.prowlerhoundkobold,R.drawable.ogre,R.drawable.basilisk,R.drawable.giantbasilisk,R.drawable.dragonacolyte,R.drawable.poisonhornbeetle)
                enemiesName = arrayOf(getString(R.string.prowler_hound_kobold),getString(R.string.ogre),getString(R.string.basilisk),getString(R.string.giant_basilisk),getString(R.string.dragon_acolyte),getString(R.string.poison_horn_beetle))
                characterImages = intArrayOf(R.drawable.navlaan)
                characterNames = arrayOf(getString(R.string.royal_sorcerer_navlaan))
                for (items in items.indices) if(modalList.size < 23) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 8) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.dragon_aerie) -> {
                binding.ivLocation.setImageResource(R.drawable.dragonaeriearea)
                images= intArrayOf(R.drawable.twinklingtitanite,R.drawable.radiantlifegem,R.drawable.soulofabravewarrior,R.drawable.darknightstone,R.drawable.boltstone,R.drawable.petrifieddragonbone,R.drawable.soulofagreathero,
                    R.drawable.largesoulofabravewarrior,R.drawable.firedrakestone,R.drawable.dragoncharm,R.drawable.pharroslockstone,R.drawable.petrifiedsomething,R.drawable.dragontooth,R.drawable.ringoftheevileye)
                items= arrayOf(getString(R.string.twinkling_titanite),getString(R.string.radiant_life_gem),getString(R.string.soul_of_a_breave_warrior),getString(R.string.darknight_stone),getString(R.string.boltstone),getString(R.string.petrified_dragon_bone),getString(R.string.soul_of_a_great_hero),
                    getString(R.string.large_soul_of_a_brave_warrior),getString(R.string.firedrake_stone),getString(R.string.dragon_charm),getString(R.string.pharros_lockstone),getString(R.string.petrified_something),getString(R.string.dragon_tooth),getString(R.string.ring_of_the_evil_eye))
                enemiesImages = intArrayOf(R.drawable.rupturinghollow,R.drawable.crystallizard,R.drawable.reddragon)
                enemiesName = arrayOf(getString(R.string.rupturing_hollow),getString(R.string.crystal_lizard),getString(R.string.red_dragon))
                characterImages = intArrayOf(R.drawable.shanalotte)
                characterNames = arrayOf(getString(R.string.emerald_herald))
                for (items in items.indices) if(modalList.size < 14) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 3) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))
                for (items in characterNames.indices) if (modalListCharacters.size < 1) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

            }
            getString(R.string.dragon_shrine) -> {
                binding.ivLocation.setImageResource(R.drawable.dragonshrinearea)
                images= intArrayOf(R.drawable.bonfireascetic,R.drawable.petrifieddragonbone,R.drawable.twinklingtitanite,R.drawable.twilightherb,R.drawable.skepticsspice,R.drawable.titaniteslab,R.drawable.crystalmagicweapon,
                    R.drawable.staffofwisdom,R.drawable.petrifiedegg,R.drawable.ashenmistheart,R.drawable.drakekeppersgreataxe,R.drawable.drakekeepersgreatshieldframe,R.drawable.blackdragongreataxe,R.drawable.watchdragonparmaframe,
                    R.drawable.washinpole,R.drawable.thirddragonring)
                items= arrayOf(getString(R.string.bonfire_ascetic),getString(R.string.petrified_dragon_bone),getString(R.string.twinkling_titanite),getString(R.string.twilight_herb),getString(R.string.skeptics_spice),getString(R.string.titanite_slab),getString(R.string.crystal_magic_weapon),
                    getString(R.string.staff_of_wisdom),getString(R.string.petrified_egg),getString(R.string.ashen_mist_heart),getString(R.string.drakekeppers_great_axe),getString(R.string.drakekeepers_greatshield),getString(R.string.black_dragon_greataxe),getString(R.string.watchdragon_parma),
                    getString(R.string.washin_pole), getString(R.string.third_dragon_ring))
                enemiesImages = intArrayOf(R.drawable.darkpriestess,R.drawable.dragonknight,R.drawable.drakekeeper,R.drawable.mimic,R.drawable.dragonfangvillard)
                enemiesName = arrayOf(getString(R.string.dark_priestess),getString(R.string.dragon_knight),getString(R.string.drakekeeper),getString(R.string.mimic),getString(R.string.dragonfang_villard))
                for (items in items.indices) if(modalList.size < 16) modalList.add(Modal(this.items[items],images[items]))
                for (items in enemiesName.indices) if (modalListEnemies.size < 5) modalListEnemies.add(ModalEnemies(this.enemiesName[items],enemiesImages[items]))

            }
        }


        val adapterItems = ItemsAdapterItems(this.requireContext(),this)
        adapterItems.setData(modalList)
        binding.gridViewItems.adapter = adapterItems
        binding.gridViewItems.onItemClickListener

        val adapterEnemies = ItemsAdapterEnemies(modalListEnemies,this.requireContext())
        binding.gridViewEnemies.adapter = adapterEnemies
        binding.gridViewEnemies.onItemClickListener
        binding.gridViewEnemies.setOnItemClickListener { _, _, i, _ ->
            Log.e("TAGE",modalListEnemies[i].name.toString())
            SetDataDialogEnemies(this.requireContext()).setDataDialogEnemies(modalListEnemies[i].name.toString())
        }

        val adapterCharacters = ItemsAdapterItems(this.requireContext(),this)
        adapterCharacters.setData(modalListCharacters)
        binding.gridViewCharactersLocation.adapter = adapterCharacters
        binding.gridViewCharactersLocation.onItemClickListener

        return binding.root
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
        when (itemsModalItems.item.toString()){
            getString(R.string.milibeth) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.strowen) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.dynatillo) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.emerald_herald) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.saulden) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.lenigrast) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.shalquoir) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.melentia) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.maughlin_the_armourer) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.carhillion) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.rosabeth) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.cale_the_cartographer) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.stone_trader_chloanne) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.laddersmith_gilligan) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.licia_of_lindelt) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.mild_mannered_pate) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.blue_sentinel_targray) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.lonesome_gavlan) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.lucatiel_of_mirrah) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.steady_hand_mcduff) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.straid_of_olaphis) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.felkin_the_outcast) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.titchy_gren) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.magerold_of_lanafir) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.bell_keeper) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.rat_king) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.darkdiver_grandahl) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.head_of_vengarl) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.creighton_of_mirrah) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.manscorpion_tark) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.weaponsmith_ornifex) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.cromwell_the_pardoner) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.chancellor_wellager) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.milfanito) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.grave_warden_agdayne) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.grave_warden_agdayne) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
            getString(R.string.royal_sorcerer_navlaan) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")

            else->{
                if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
                    SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
                }
            }
        }
    }

}