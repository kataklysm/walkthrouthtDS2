package com.daveapps.walkthrouthds2

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class SetDataDialogEnemies(context: Context):Fragment() {
    private var contextDialog = context
    private var ivImageDialogEnemies: ImageView? = null
    private var tvEnemiesSouls: TextView? = null
    private var tvEnemiesHP: TextView? = null
    private var tvEnemiesWeakness: TextView? = null
    private var tvEnemiesResistance: TextView? = null
    private var tvEnemiesDrops: TextView? = null

    fun setDataDialogEnemies(name: String){
        val builderEnemies = AlertDialog.Builder(contextDialog)
        val viewEnemies = View.inflate(contextDialog,R.layout.dialog_view_enemies,null)

        ivImageDialogEnemies = viewEnemies.findViewById(R.id.ivEnemiesDialog)
        tvEnemiesSouls = viewEnemies.findViewById(R.id.tvEnemiesSouls)
        tvEnemiesHP = viewEnemies.findViewById(R.id.tvEnemiesHP)
        tvEnemiesWeakness = viewEnemies.findViewById(R.id.tvEnemiesWeakness)
        tvEnemiesResistance = viewEnemies.findViewById(R.id.tvEnemiesResistance)
        tvEnemiesDrops = viewEnemies.findViewById(R.id.tvEnemiesDrops)

        builderEnemies.setView(viewEnemies)
        val dialog = builderEnemies.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        when(name){
            contextDialog.getString(R.string.dual_avelyn_bell_keeper) -> setDataEnemies("dualavelynbellkeeper","1000",contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.physical),"",contextDialog.getString(R.string.black_witch_domino_mask),"900")
            contextDialog.getString(R.string.bell_keeper_mage) -> setDataEnemies("bellkeepermage","1000",contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.dark),contextDialog.getString(R.string.black_witch_veil),"900")
            contextDialog.getString(R.string.bell_keeper_doll) -> setDataEnemies("bellkeeperdoll","800",contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.rusted_coin)+", "+contextDialog.getString(R.string.flame_swathe)+", "+contextDialog.getString(R.string.large_titanite_shard),"550")
            contextDialog.getString(R.string.oliver_the_collector) -> setDataEnemies("oliverthecollector","2800",contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire),contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.minotaur_helm),"3000")
            contextDialog.getString(R.string.armorer_dennis) -> setDataEnemies("armorerdennis","2570",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.clear_bluestone_ring),"1800")
            contextDialog.getString(R.string.fencer_sharron) -> setDataEnemies("fencersharron","2800",contextDialog.getString(R.string.poison)+", "+contextDialog.getString(R.string.poison_toxic),contextDialog.getString(R.string.magic),contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.sanctum_priestess_tiara),"3300")
            contextDialog.getString(R.string.alonne_knight_captain) -> setDataEnemies("alonneknightcaptain","840",contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.magic),contextDialog.getString(R.string.fire),contextDialog.getString(R.string.blacksteel_katana)+", "+contextDialog.getString(R.string.alonne_greatbow)+", "+contextDialog.getString(R.string.destructive_great_arrow),"1500")
            contextDialog.getString(R.string.alonne_knight) -> setDataEnemies("alonneknight","590",contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire),contextDialog.getString(R.string.blacksteel_katana)+", "+contextDialog.getString(R.string.alonne_greatbow)+", "+contextDialog.getString(R.string.destructive_great_arrow),"450")
            contextDialog.getString(R.string.entity_of_avarice) -> setDataEnemies("entityofavarice","720",contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.work_hook)+", "+contextDialog.getString(R.string.winged_spear),"1500")
            contextDialog.getString(R.string.masked_manikin) -> setDataEnemies("maskedmanikin","260",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.manikin_claws)+", "+contextDialog.getString(R.string.manikin_knife)+","+contextDialog.getString(R.string.manikin_shield),"160")
            contextDialog.getString(R.string.desert_sorceress) -> setDataEnemies("desertsorceress","320",contextDialog.getString(R.string.physical),"",contextDialog.getString(R.string.magic_stone)+", "+contextDialog.getString(R.string.dragon_charm)+","+contextDialog.getString(R.string.lingering_dragoncrest_ring),"300")
            contextDialog.getString(R.string.undeadsteel_worker) -> setDataEnemies("undeadsteelworker","560",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.titanite_shard)+", "+contextDialog.getString(R.string.old_mundane_stone)+","+contextDialog.getString(R.string.small_smooth_silky_stone),"400")
            contextDialog.getString(R.string.banedigger) -> setDataEnemies("banedigger","1200",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.small_smooth_silky_stone)+", "+contextDialog.getString(R.string.sunlight_medal),"750")
            contextDialog.getString(R.string.merciless_roenna) -> setDataEnemies("mercilessroenna","1550","","",contextDialog.getString(R.string.cursed_bone_shield)+", "+contextDialog.getString(R.string.awestone),"2301")
            contextDialog.getString(R.string.greatsword_phantom) -> setDataEnemies("greatswordphantom","1650","","",contextDialog.getString(R.string.great_sword)+", "+contextDialog.getString(R.string.ormas_greatshield)+", "+contextDialog.getString(R.string.human_effigy),"2150")
            contextDialog.getString(R.string.executioner) -> setDataEnemies("executioner","800",contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.yearn),"",contextDialog.getString(R.string.cracked_red_eye_orb)+", "+contextDialog.getString(R.string.bloody_whip),"780")
            contextDialog.getString(R.string.hollow_mage) -> setDataEnemies("hollowmage","600",contextDialog.getString(R.string.alluring_skull)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.thrust_attack),contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.falchion)+", "+contextDialog.getString(R.string.mail_breker)+", "+contextDialog.getString(R.string.long_bow)+", "+contextDialog.getString(R.string.titanite_shard),"110")
            contextDialog.getString(R.string.hollow_rogue) -> setDataEnemies("hollowrogue","300, 270",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.thief_dagger)+", "+contextDialog.getString(R.string.club)+","+contextDialog.getString(R.string.flame_butterfly)+" ,"+contextDialog.getString(R.string.throwing_knife),"90")
            contextDialog.getString(R.string.undead_huntsman) -> setDataEnemies("undeadhuntsman","800",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.full_moon_sickle)+", "+contextDialog.getString(R.string.soul_of_a_name_less_soldier)+", "+contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.rotten_pine_resin),"630")
            contextDialog.getString(R.string.poison_moth) -> setDataEnemies("poisonmoth","170",contextDialog.getString(R.string.fire),"",contextDialog.getString(R.string.poison_moss),"60")
            contextDialog.getString(R.string.dragonfang_villard)-> setDataEnemies("dragonfangvillard","2300",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.dragon_scale)+", "+contextDialog.getString(R.string.awestone),"3600")
            contextDialog.getString(R.string.drakekeeper)-> setDataEnemies("drakekeeper","1061",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.projectile)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.fire)+","+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.drakekeepers_sword)+", "+contextDialog.getString(R.string.drakekeepers_great_hammer)+", "+contextDialog.getString(R.string.drakekeeper_warpick)+", "+contextDialog.getString(R.string.drakekeepers_ultra_greatsword)+", "+contextDialog.getString(R.string.drakekeepers_shield),"1900")
            contextDialog.getString(R.string.dragon_knight)-> setDataEnemies("dragonknight","2300",contextDialog.getString(R.string.projectile),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.dragon_scale)+", "+contextDialog.getString(R.string.black_dragon_warpick)+", "+contextDialog.getString(R.string.black_dragon_sword)+", "+contextDialog.getString(R.string.black_dragon_greataxe)+", "+contextDialog.getString(R.string.black_dragon_shield),"3000")
            contextDialog.getString(R.string.dark_priestess)-> setDataEnemies("darkpriestess","500",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.projectile),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.clerics_parma)+", "+contextDialog.getString(R.string.silver_talisman),"1400")
            contextDialog.getString(R.string.red_dragon)-> setDataEnemies("reddragon","5300",contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.petrified_something)+", "+contextDialog.getString(R.string.petrified_dragon_bone)+", "+contextDialog.getString(R.string.twinkling_titanite)+", "+contextDialog.getString(R.string.flame_quartz_ring)+", "+contextDialog.getString(R.string.fire_tempest),"4000")
            contextDialog.getString(R.string.nameless_usurper)-> setDataEnemies("namelessusurper","2300",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.awestone),"2100")
            contextDialog.getString(R.string.grave_warden)-> setDataEnemies("gravewarden","950",contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.silverblack_spear)+", "+contextDialog.getString(R.string.silverblack_shield),"380")
            contextDialog.getString(R.string.wall_spectre)-> setDataEnemies("wallspectre","240",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.dark), "","200")
            contextDialog.getString(R.string.imperious_knight)-> setDataEnemies("imperiousknight","1500",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.ormas_greatshield)+", "+contextDialog.getString(R.string.reeves_greatshield),"1900")
            contextDialog.getString(R.string.leydia_pyromancer)-> setDataEnemies("leydiapyromancer","360",contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.poison),contextDialog.getString(R.string.blue_flame)+", "+contextDialog.getString(R.string.magic_shield)+", "+contextDialog.getString(R.string.darknight_stone)+", "+contextDialog.getString(R.string.faint_stone)+", "+contextDialog.getString(R.string.magic_stone),"380")
            contextDialog.getString(R.string.leydia_witch)-> setDataEnemies("leydiawitch","900",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark)+", "+contextDialog.getString(R.string.magic),contextDialog.getString(R.string.black_witchs_staff)+", "+contextDialog.getString(R.string.dark_quartz_ring)+", "+contextDialog.getString(R.string.simpletons_spice)+", "+contextDialog.getString(R.string.skeptics_spice)+", "+contextDialog.getString(R.string.magic_stone),"1100")
            contextDialog.getString(R.string.great_poison_brumer)-> setDataEnemies("greatpoisonbrumer","1000",contextDialog.getString(R.string.physical),"",contextDialog.getString(R.string.corrosive_urn),"1200")


            contextDialog.getString(R.string.amana_aberration)->{
                setDataEnemies("amanaaberration","500",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire),contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.smoth_and_silky_stone)+", "+contextDialog.getString(R.string.red_leech_troches)+", "+contextDialog.getString(R.string.bleed_stone)+", "+contextDialog.getString(R.string.bleeding_serum),"300")
            }

            contextDialog.getString(R.string.aldia_warlock)->{
                setDataEnemies("aldiawarlock","1200",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.dark)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.fire),contextDialog.getString(R.string.awestone)+", "+contextDialog.getString(R.string.cursed_bone_shield)+", "+contextDialog.getString(R.string.wilted_dusk_herb),"2500")
            }

            contextDialog.getString(R.string.amana_priestess)->{
                setDataEnemies("amanapriestess","700",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic),contextDialog.getString(R.string.crimson_water)+", "+contextDialog.getString(R.string.dragon_charm)+", "+contextDialog.getString(R.string.staff_of_amana)+", "+contextDialog.getString(R.string.twinkling_titanite)+", "+contextDialog.getString(R.string.holy_water_urn)+", "+contextDialog.getString(R.string.radiant_life_gem),"380")
            }

            contextDialog.getString(R.string.archdrake_pilgrim)->{
                setDataEnemies("archdrakepilgrim","760",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic),contextDialog.getString(R.string.twinkling_titanite)+", "+contextDialog.getString(R.string.old_radiant_life_gem)+", "+contextDialog.getString(R.string.archdrake_mace)+", "+contextDialog.getString(R.string.slumbering_dragon_shield),"450")
            }

            contextDialog.getString(R.string.stone_soldier)->{
                setDataEnemies("stonesoldier","720",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.dark),"",contextDialog.getString(R.string.llewellyn_shield)+", "+contextDialog.getString(R.string.stone_soldier_spear)+", "+contextDialog.getString(R.string.titanite_slab),"350")
            }

            contextDialog.getString(R.string.royal_soldier)->{
                setDataEnemies("royalsoldier","500",contextDialog.getString(R.string.magic),"","","250")
            }

            contextDialog.getString(R.string.forest_guardian)->{
                setDataEnemies("forestguardian","900",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.fire)+","+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.awestone),"450")
            }

            contextDialog.getString(R.string.headless_vengarl)->{
                setDataEnemies("headlessvengarl","1375","","","","8000")
            }

            contextDialog.getString(R.string.tseldoran_settler)->{
                setDataEnemies("tseldoransettler","400",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.brightstone_key)+", "+contextDialog.getString(R.string.fragrant_branch_of_yore)+", "+contextDialog.getString(R.string.dark_quartz_ring),"700")
            }

            contextDialog.getString(R.string.aslatiel_of_mirrah)->{
                setDataEnemies("aslatielofmirrah","2300",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.old_mirrah_greatsword),"3200")
            }

            contextDialog.getString(R.string.poison_horn_beetle)->{
                setDataEnemies("poisonhornbeetle","300",contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.poison),contextDialog.getString(R.string.green_blossom)+", "+contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.fire_storm),"60")
            }

            contextDialog.getString(R.string.dragon_acolyte)->{
                setDataEnemies("dragonacolyte","1000",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.aldia_hammer)+", "+contextDialog.getString(R.string.bone_shield)+", "+contextDialog.getString(R.string.elizabeth_mushroom)+", "+contextDialog.getString(R.string.petrified_dragon_bone),"600")
            }

            contextDialog.getString(R.string.giant_basilisk)->{
                setDataEnemies("giantbasilisk","4600",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.petrified_dragon_bone)+", "+contextDialog.getString(R.string.large_titanite_shard)+", "+contextDialog.getString(R.string.dragon_sage_hood)+", "+contextDialog.getString(R.string.magic_stone),"3000")
            }

            contextDialog.getString(R.string.hollow_mage)->{
                setDataEnemies("hollowmage","430","",contextDialog.getString(R.string.magic),contextDialog.getString(R.string.rouge_water)+", "+contextDialog.getString(R.string.amber_herb)+", "+contextDialog.getString(R.string.crimson_water)+", "+contextDialog.getString(R.string.skeptics_spice)+", "+contextDialog.getString(R.string.bat_staff),"400")
            }

            contextDialog.getString(R.string.ducal_spider)->{
                setDataEnemies("ducalspider","200",contextDialog.getString(R.string.fire),"",contextDialog.getString(R.string.zweihander)+", "+contextDialog.getString(R.string.bandit_axe)+", "+contextDialog.getString(R.string.great_scythe)+", "+contextDialog.getString(R.string.mail_breker)+", "+contextDialog.getString(R.string.mastodon_greatsword)+", "+contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.parrying_dagger)+", "+contextDialog.getString(R.string.ricards_rapier),"160")
            }

            contextDialog.getString(R.string.hollow_peasant)->{
                setDataEnemies("hollowpeasant","670",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.titanite_shard)+", "+contextDialog.getString(R.string.large_titanite_shard)+", "+contextDialog.getString(R.string.titanite_chunk)+", "+contextDialog.getString(R.string.small_smooth_silky_stone),"220")
            }

            contextDialog.getString(R.string.spider_drone)->{
                setDataEnemies("spiderdrone","700",contextDialog.getString(R.string.fire),"",contextDialog.getString(R.string.large_titanite_shard)+", "+contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.prism_stone),"360")
            }

            contextDialog.getString(R.string.bowman_guthry)->{
                setDataEnemies("bowmanguthry","1700","","",contextDialog.getString(R.string.avelyn)+", "+contextDialog.getString(R.string.awestone),"450")
            }

            contextDialog.getString(R.string.gyrm_warrior)->{
                setDataEnemies("gyrmwarrior","630","","",contextDialog.getString(R.string.gyrm_great_hammer)+", "+contextDialog.getString(R.string.gyrm_greatshiel)+", "+contextDialog.getString(R.string.gyrm_greataxe)+", "+contextDialog.getString(R.string.titanite_chunk)+", "+contextDialog.getString(R.string.magic_stone)+", "+contextDialog.getString(R.string.old_mundane_stone),"300")
            }

            contextDialog.getString(R.string.mongrel_rat)->{
                setDataEnemies("mongrelrat","160",contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.projectile),contextDialog.getString(R.string.fire)+","+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.old_radiant_life_gem)+", "+contextDialog.getString(R.string.pharros_lockstone)+", "+contextDialog.getString(R.string.rat_tail),"80")
            }

            contextDialog.getString(R.string.headless_vengarl)->{
                setDataEnemies("headlessvengarl","1375","",contextDialog.getString(R.string.fire)+","+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.dark),"","8000")
            }

            contextDialog.getString(R.string.hollow_falconer)->{
                setDataEnemies("hollowfalconer","420",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic)+","+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.sunlight_medalmedal),"700")
            }


            contextDialog.getString(R.string.lion_clan_warrior)->{
                setDataEnemies("lionclanwarrior","650",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic),contextDialog.getString(R.string.lion_greataxe)+", "+contextDialog.getString(R.string.lion_clan_shield),"400")
            }

            contextDialog.getString(R.string.goblin)->{
                setDataEnemies("goblin","160",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.various_weapons),"90")
            }

            contextDialog.getString(R.string.forlorn)->{
                setDataEnemies("forlorn","1900",contextDialog.getString(R.string.projectile),"",contextDialog.getString(R.string.human_effigy),"7200")
            }

            contextDialog.getString(R.string.woodland_child_gully)->{
                setDataEnemies("woodlandchildgully","","","",contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.ormas_greatshield),"")
            }

            contextDialog.getString(R.string.elite_giant)->{
                setDataEnemies("elitegiant","2650",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.projectile),contextDialog.getString(R.string.magic)+","+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark)+", "+contextDialog.getString(R.string.poison),contextDialog.getString(R.string.forgotten_key)+", "+contextDialog.getString(R.string.soul_of_a_giant),"4000")
            }

            contextDialog.getString(R.string.razorback_nightcrawle)->{
                setDataEnemies("razorbacknightcrawle","1600",contextDialog.getString(R.string.physical),"",contextDialog.getString(R.string.poison_stone)+", "+contextDialog.getString(R.string.dead_again)+", "+contextDialog.getString(R.string.puzzling_stone_sword)+", "+contextDialog.getString(R.string.twinkling_titanite),"1400")
            }

            contextDialog.getString(R.string.mimic)->{
                setDataEnemies("mimic","720",contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.work_hook)+", "+contextDialog.getString(R.string.lightning_spear)+", "+contextDialog.getString(R.string.black_scorpion_stinger)+", "+contextDialog.getString(R.string.sunset_staff)+", "+contextDialog.getString(R.string.washin_pole)+", "+contextDialog.getString(R.string.twinkling_titanite),"1500")
            }

            contextDialog.getString(R.string.dark_sucker)->{
                setDataEnemies("darksucker","475",contextDialog.getString(R.string.fire),"",contextDialog.getString(R.string.large_titanite_shard)+", "+contextDialog.getString(R.string.titanite_chunk),"300")
            }


            contextDialog.getString(R.string.hunting_dog)->{
                setDataEnemies("huntingdog","1100",contextDialog.getString(R.string.fire),contextDialog.getString(R.string.magic)+","+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.aromatic_ooze),"660")
            }

            contextDialog.getString(R.string.corpse_rat)->{
                setDataEnemies("corpserat","240",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.projectile),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark)+", "+contextDialog.getString(R.string.poison),contextDialog.getString(R.string.warmth)+", "+contextDialog.getString(R.string.poison_moss)+", "+contextDialog.getString(R.string.repair_powder)+", "+contextDialog.getString(R.string.rat_tail)+", "+contextDialog.getString(R.string.old_radiant_life_gem),"70")
            }


            contextDialog.getString(R.string.crystal_lizard)->{
                setDataEnemies("crystallizard","700","","",contextDialog.getString(R.string.titanite_shard)+", "+contextDialog.getString(R.string.large_titanite_shard)+", "+contextDialog.getString(R.string.titanite_chunk)+", "+contextDialog.getString(R.string.titanite_slab)+","+contextDialog.getString(R.string.twinkling_titanite)+", "+contextDialog.getString(R.string.petrified_dragon_bone)+", "+ contextDialog.getString(R.string.element_stones),"1")
            }

            contextDialog.getString(R.string.rhoy_the_explorer)->{
                setDataEnemies("rhoytheexplorer","1420",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.slash)+","+contextDialog.getString(R.string.poison)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.heavy_crossbow)+", "+contextDialog.getString(R.string.shotel)+", "+contextDialog.getString(R.string.awestone),"2600")
            }

            contextDialog.getString(R.string.abandoned_hollow)->{
                setDataEnemies("abandonedhollow","220",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.torch)+", "+contextDialog.getString(R.string.broken_straight_sword)+", "+contextDialog.getString(R.string.small_blue_burr)+", "+contextDialog.getString(R.string.small_yellow_burr)+", "+contextDialog.getString(R.string.small_orange_burr)+", "+contextDialog.getString(R.string.poison_throwing_knife),"60")
            }

            contextDialog.getString(R.string.undead_aberration)->{
                setDataEnemies("undeadaberration","1100",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.poison),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.bell_keeper_shield)+", "+contextDialog.getString(R.string.malformed_skull)+", "+contextDialog.getString(R.string.bell_keeper_bow)+", "+contextDialog.getString(R.string.awestone)+", "+contextDialog.getString(R.string.chaos_rapier)+", "+contextDialog.getString(R.string.chaos_shield),"1600")
            }
            contextDialog.getString(R.string.vorgel_the_sinner)->{
                setDataEnemies("vorgelthesinner","","","",contextDialog.getString(R.string.winged_spear)+", "+contextDialog.getString(R.string.awestone),"20")
            }
            contextDialog.getString(R.string.bell_keeper_doll)->{
                setDataEnemies("bellkeeperdoll","2100","","",contextDialog.getString(R.string.rusted_coin),"350")
            }
            contextDialog.getString(R.string.rupturing_hollow)->{
                setDataEnemies("rupturinghollow","80",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.alluring_skull),"260")
            }
            contextDialog.getString(R.string.hollow_prisoner)->{
                setDataEnemies("hollowprisoner","180",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.torch)+", "+contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.small_orange_burr)+", "+contextDialog.getString(R.string.small_blue_burr),"40")
            }
            contextDialog.getString(R.string.undead_jailer)->{
                setDataEnemies("undeadjailer","290",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.lingering_flame)+", "+contextDialog.getString(R.string.twilight_herb)+", "+contextDialog.getString(R.string.great_machete),"1100")
            }
            contextDialog.getString(R.string.nimble_shadow)->{
                setDataEnemies("nimbleshadow","330",contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire),contextDialog.getString(R.string.malformed_claws)+", "+contextDialog.getString(R.string.shadow_dagger),"350")
            }
            contextDialog.getString(R.string.darkdweller)->{
                setDataEnemies("darkdweller","620",contextDialog.getString(R.string.fire),"",contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.radiant_life_gem)+", "+contextDialog.getString(R.string.long_sword)+", "+contextDialog.getString(R.string.broadsword),"370")
            }
            contextDialog.getString(R.string.hollow_varangian)->{
                setDataEnemies("hollowvarangian","260",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.allelementalattacks),"",contextDialog.getString(R.string.varangian_sword)+", "+contextDialog.getString(R.string.varangian_shield)+", "+contextDialog.getString(R.string.scimitar),"200")
            }
            contextDialog.getString(R.string.primal_knight)->{
                setDataEnemies("primalknight","1800",contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.slash),contextDialog.getString(R.string.old_knight_greatsword)+", "+contextDialog.getString(R.string.cracked_blue_eye_orb)+", "+contextDialog.getString(R.string.palestone)+", "+contextDialog.getString(R.string.old_knight_shield),"1100, 1800")
            }
            contextDialog.getString(R.string.hellkite_dragon)->{
                setDataEnemies("hellkitedragon","5300",contextDialog.getString(R.string.lightning),"",contextDialog.getString(R.string.petrified_something)+", "+contextDialog.getString(R.string.petrified_dragon_bone)+", "+contextDialog.getString(R.string.twinkling_titanite)+", "+contextDialog.getString(R.string.flame_quartz_ring)+", "+contextDialog.getString(R.string.fire_tempest),"4000")
            }
            contextDialog.getString(R.string.heide_knight)->{
                setDataEnemies("heideknight","1250","","",contextDialog.getString(R.string.heide_knight_sword)+", "+contextDialog.getString(R.string.heide_spear)+", "+contextDialog.getString(R.string.heide_lance)+", "+contextDialog.getString(R.string.heide_great_lance),"3000")
            }
            contextDialog.getString(R.string.old_knight)->{
                setDataEnemies("oldknight","700",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.slash)+","+contextDialog.getString(R.string.poison)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.old_knight_greatsword)+", "+contextDialog.getString(R.string.cracked_blue_eye_orb)+", "+contextDialog.getString(R.string.palestone)+", "+contextDialog.getString(R.string.old_knight_shield),"400")
            }
            contextDialog.getString(R.string.syan_soldier)->{
                setDataEnemies("syansoldier","960",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.slash),contextDialog.getString(R.string.syans_halberd)+", "+contextDialog.getString(R.string.great_sword)+", "+contextDialog.getString(R.string.green_blossom)+", "+contextDialog.getString(R.string.monastery_charm),"900")
            }
            contextDialog.getString(R.string.royal_swordsman)->{
                setDataEnemies("royalswordsman","400",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.magic)+","+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.heavy_crossbow)+", "+contextDialog.getString(R.string.royal_great_sword)+", "+contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.common_fruit)+", "+contextDialog.getString(R.string.radiant_life_gem),"180")
            }
            contextDialog.getString(R.string.flame_lizard)->{
                setDataEnemies("flamelizard","3325",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.poison),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.fire),contextDialog.getString(R.string.cracked_red_eye_orb)+", "+contextDialog.getString(R.string.fireball)+", "+contextDialog.getString(R.string.fire_orb)+", "+contextDialog.getString(R.string.great_fireball),"900")
            }
            contextDialog.getString(R.string.iron_clad_soldier)->{
                setDataEnemies("ironcladsoldier","900",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.slash),contextDialog.getString(R.string.human_effigy)+", "+contextDialog.getString(R.string.large_titanite_shard),"250")
            }
            contextDialog.getString(R.string.hollow_infantry)->{
                setDataEnemies("hollowinfantry","270",contextDialog.getString(R.string.magic),contextDialog.getString(R.string.physical),contextDialog.getString(R.string.short_bow)+", "+contextDialog.getString(R.string.infantry_axe)+", "+contextDialog.getString(R.string.bandits_knife)+", "+contextDialog.getString(R.string.foot_soldier_sword)+", "+contextDialog.getString(R.string.foot_soldier_shield)+", "+contextDialog.getString(R.string.throwing_knife)+", "+contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.fire_arrow),"50")
            }
            contextDialog.getString(R.string.hollow_royal_soldier)->{
                setDataEnemies("hollowroyalsoldier","290",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.life_gem)+", "+contextDialog.getString(R.string.hollow_soldier_shield),"90")
            }
            contextDialog.getString(R.string.undead_devourer) ->{
                setDataEnemies("undeaddevourer","330",contextDialog.getString(R.string.physical)+", "+contextDialog.getString(R.string.slash)+", "+contextDialog.getString(R.string.fire),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.dark),contextDialog.getString(R.string.cracked_red_eye_orb),"20, 140, 700")
            }
            contextDialog.getString(R.string.skeleton) ->{
                setDataEnemies("skeleton","110",contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic),contextDialog.getString(R.string.human_effigy)+" "+contextDialog.getString(R.string.falchion)+", "+contextDialog.getString(R.string.mail_breker)+" ,"+contextDialog.getString(R.string.foot_soldier_shield)+" ,"+contextDialog.getString(R.string.long_bow),"600")
            }
            contextDialog.getString(R.string.prowler_hound_kobold) ->{
                setDataEnemies("prowlerhoundkobold","150",contextDialog.getString(R.string.fire)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.magic)+", "+contextDialog.getString(R.string.dark)+", "+contextDialog.getString(R.string.lightning),contextDialog.getString(R.string.affinity)+" "+contextDialog.getString(R.string.black_knight_greataxe)+" ,"+contextDialog.getString(R.string.shotel)+", "+contextDialog.getString(R.string.black_knight_greatsword)+", "+contextDialog.getString(R.string.black_knight_halberd)+", "+contextDialog.getString(R.string.black_knight_ultra_greatsword)+", "+contextDialog.getString(R.string.drakekeppers_great_axe)+", "+contextDialog.getString(R.string.crescent_axe),"30, 180")
            }
            contextDialog.getString(R.string.ogre) ->{
                setDataEnemies("ogre","1300",contextDialog.getString(R.string.lightning)+", "+contextDialog.getString(R.string.fire),contextDialog.getString(R.string.slash)+", "+contextDialog.getString(R.string.physical),contextDialog.getString(R.string.stone_ring)+" ,"+contextDialog.getString(R.string.soul_of_a_proud_knight)+" ,"+contextDialog.getString(R.string.radiant_life_gem)+" ,"+contextDialog.getString(R.string.titanite_shard)+","+contextDialog.getString(R.string.awestone),"1000, 1100, 2200")
            }
            contextDialog.getString(R.string.foreign_wanderer) ->{
                setDataEnemies("foreignwanderer","30, 40",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.life_gem),"160")
            }
            contextDialog.getString(R.string.basilisk) ->{
                setDataEnemies("basilisk","270",contextDialog.getString(R.string.magic),"",contextDialog.getString(R.string.faint_stone)+", "+contextDialog.getString(R.string.boltstone)+", "+contextDialog.getString(R.string.firedrake_stone)+", "+contextDialog.getString(R.string.darknight_stone)+", "+contextDialog.getString(R.string.poison_stone)+", "+contextDialog.getString(R.string.bleed_stone)+", "+contextDialog.getString(R.string.raw_stone)+", "+contextDialog.getString(R.string.magic_stone)+", "+contextDialog.getString(R.string.old_mundane_stone),"200")
            }
            contextDialog.getString(R.string.stray_hound_dog) ->{
                setDataEnemies("strayhounddog","190",contextDialog.getString(R.string.fire),"?",contextDialog.getString(R.string.soul_of_a_lost_undead)+" ,"+contextDialog.getString(R.string.human_effigy),"100")
            }
        }

        viewEnemies.findViewById<Button>(R.id.btnOkDialog).setOnClickListener {
            dialog.dismiss()
        }


    }

    private fun setDataEnemies(image: String, hp: String, weakness: String, resistance: String, drops: String, souls: String){
        ivImageDialogEnemies?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable", contextDialog.packageName))
        tvEnemiesSouls?.text = souls
        tvEnemiesHP?.text = hp
        tvEnemiesWeakness?.text = weakness
        tvEnemiesResistance?.text = resistance
        tvEnemiesDrops?.text = drops

    }
}