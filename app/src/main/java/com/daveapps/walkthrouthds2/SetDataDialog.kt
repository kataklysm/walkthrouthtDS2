package com.daveapps.walkthrouthds2

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class SetDataDialog(context: Context, private var name: String) : Fragment() {
    private var contextDialog = context
    private var imageDialog: ImageView? = null
    private var tvItemDialog: TextView? = null
    private var tvItemDes: TextView? = null
    private var ivIconWpPhysicalAttackPhysicalDef: ImageView? = null
    private var tvIconWpPhysicalAttackPhysicalDef: TextView? = null
    private var ivIconMagicBonusMagicDef: ImageView? = null
    private var tvIconMagicBonusMagicDef: TextView? = null
    private var ivIconFireBonusFireDef: ImageView? = null
    private var tvIconFireBonusFireDef: TextView? = null
    private var ivIconLightningBonusLightningDef: ImageView? = null
    private var tvIconLightningBonusLightningDef: TextView? = null
    private var ivIconDarkBonusDarkDef: ImageView? = null
    private var tvIconDarkBonusDarkDef: TextView? = null
    private var ivIconWpCounterStrengthPoisonDef: ImageView? = null
    private var tvIconWpCounterStrengthPoisonDEf: TextView? = null
    private var ivIconWpPoiseDamageBleedDef: ImageView? = null
    private var tvIconWpPoiseDamageBleedDef:TextView? = null
    private var ivIconWpStabilityPetrifyDef: ImageView? = null
    private var tvIconWpStabilityPetrifyDef: TextView? = null
    private var ivIconDurabilityCurseDef: ImageView? = null
    private var tvIconDurabilityCurseDef: TextView? = null
    private var ivIconWeightDurability: ImageView? = null
    private var tvIconWeightDurability: TextView? = null
    private var ivIconStability: ImageView? = null
    private var tvIconStability: TextView? = null
    private var ivIconWeight: ImageView? = null
    private var tvIconWeight: TextView? = null
    private var ivIconStrength: ImageView? = null
    private var tvIconStrength: TextView? = null
    private var ivIconDexterity: ImageView? = null
    private var tvIconDexterity: TextView? = null
    private var ivIconIntelligence: ImageView? = null
    private var tvIconIntelligence: TextView? = null
    private var ivIconFaith: ImageView? = null
    private var tvIconFaith: TextView? = null
    private var ivIconFireDef: ImageView? = null
    private var tvIconFireDef: TextView? = null
    private var ivIconLightningDef: ImageView? = null
    private var tvIconLightningDef: TextView? = null
    private var ivIconDurability: ImageView? = null
    private var tvIconDurability: TextView? = null
    private var layoutDes1: LinearLayout? = null
    private var layoutDes2: LinearLayout? = null
    private var layoutDes3: LinearLayout? = null
    private var layoutDes4: LinearLayout? = null
    private var dialog: AlertDialog? = null




    fun  setDataDialog(): Boolean {
        val builder = AlertDialog.Builder(contextDialog)
        val view = View.inflate(contextDialog,R.layout.dialog_view,null)

        layoutDes1 = view.findViewById(R.id.layoutDes1)
        layoutDes2 = view.findViewById(R.id.layoutDes2)
        layoutDes3 = view.findViewById(R.id.layoutDes3)
        layoutDes4 = view.findViewById(R.id.layoutDes4)
        imageDialog = view.findViewById(R.id.ivItemDialog)
        tvItemDialog = view.findViewById(R.id.tvItemDialog)
        tvItemDes = view.findViewById(R.id.tvItemDescription)
        ivIconWpPhysicalAttackPhysicalDef = view.findViewById(R.id.ivIconWpPhysicalAttackPhysicalDef)
        tvIconWpPhysicalAttackPhysicalDef = view.findViewById(R.id.tvIconWpPhysicalAttackPhysicalDef)
        ivIconMagicBonusMagicDef = view.findViewById(R.id.ivIconMagicBonusMagicDef)
        tvIconMagicBonusMagicDef = view.findViewById(R.id.tvIconMagicBonusMagicDef)
        ivIconFireBonusFireDef = view.findViewById(R.id.ivIconFireBonusFireDef)
        tvIconFireBonusFireDef = view.findViewById(R.id.tvIconFireBonusFireDef)
        ivIconLightningBonusLightningDef = view.findViewById(R.id.ivIconLightningBonusLightningDef)
        tvIconLightningBonusLightningDef = view.findViewById(R.id.tvIconLightningBonusLightningDef)
        ivIconDarkBonusDarkDef = view.findViewById(R.id.ivIconDarkBonusDarkDef)
        tvIconDarkBonusDarkDef = view.findViewById(R.id.tvIconDarkBonusDarkDef)
        ivIconWpCounterStrengthPoisonDef = view.findViewById(R.id.ivIconWpCounterStrengthPoisonDef)
        tvIconWpCounterStrengthPoisonDEf = view.findViewById(R.id.tvIconWpCounterStrengthPoisonDef)
        ivIconWpPoiseDamageBleedDef = view.findViewById(R.id.ivIconWpPoiseDamageBleedDef)
        tvIconWpPoiseDamageBleedDef = view.findViewById(R.id.tvIconWpPoiseDamageBleedDef)
        ivIconWpStabilityPetrifyDef = view.findViewById(R.id.ivIconWpStabilityPetrifyDef)
        tvIconWpStabilityPetrifyDef = view.findViewById(R.id.tvIconWpStabilityPetrifyDef)
        ivIconDurabilityCurseDef = view.findViewById(R.id.ivIconDurabilityCurseDef)
        tvIconDurabilityCurseDef = view.findViewById(R.id.tvIconDurabilityCurseDef)
        ivIconWeightDurability = view.findViewById(R.id.ivIconWeightDurability)
        tvIconWeightDurability = view.findViewById(R.id.tvIconWeightDurability)
        ivIconStability = view.findViewById(R.id.ivIconWpStability)
        tvIconStability = view.findViewById(R.id.tvIconWpStability)
        ivIconWeight  = view.findViewById(R.id.ivIconWeight)
        tvIconWeight = view.findViewById(R.id.tvIconWeight)
        ivIconStrength = view.findViewById(R.id.ivIconStrength)
        tvIconStrength = view.findViewById(R.id.tvIconStrength)
        ivIconDexterity = view.findViewById(R.id.ivIconDexterity)
        tvIconDexterity = view.findViewById(R.id.tvIconDexterity)
        ivIconIntelligence = view.findViewById(R.id.ivIconIntelligence)
        tvIconIntelligence = view.findViewById(R.id.tvIconIntelligence)
        ivIconFaith = view.findViewById(R.id.ivIconFaith)
        tvIconFaith = view.findViewById(R.id.tvIconFaith)
        ivIconFireDef = view.findViewById(R.id.ivIconFireDef)
        tvIconFireDef = view.findViewById(R.id.tvIconFireDef)
        ivIconLightningDef = view.findViewById(R.id.ivIconLightningDef)
        tvIconLightningDef = view.findViewById(R.id.tvIconLightningDef)
        ivIconDurability = view.findViewById(R.id.ivIconDurability)
        tvIconDurability = view.findViewById(R.id.tvIconDurability)


        builder.setView(view)
        dialog = builder.create()


        when(name){
         contextDialog.getString(R.string.sorcerers_twinblade) -> setDataDialogWeapon("sorcererstwinblade",contextDialog.getString(R.string.sorcerers_twinblade),contextDialog.getString(R.string.sorcerers_twinblade_des),"","120","100","15", "","30","","100","100","10.0","11","20","20","6")
         contextDialog.getString(R.string.curved_twinblade) -> setDataDialogWeapon("curvedtwinblade",contextDialog.getString(R.string.curved_twinblade),contextDialog.getString(R.string.curved_twinblade_des),"170","110","","25", "","30","","125","","10.0","16","20","","")
         contextDialog.getString(R.string.dragonrider_twin_blade) -> setDataDialogWeapon("dragonridertwinblade",contextDialog.getString(R.string.dragonrider_twin_blade),contextDialog.getString(R.string.dragonrider_twin_blade_des),"185","120","110","25", "","30","","120","","18.0","20","22","","")
         contextDialog.getString(R.string.scythe_of_the_forlorn) -> setDataDialogWeapon("scytheoftheforlorn",contextDialog.getString(R.string.scythe_of_the_forlorn),contextDialog.getString(R.string.scythe_of_the_forlorn_des),"210","110","","15", "","20","","55","70","11.0","15","20","10","10")
         contextDialog.getString(R.string.scythe_of_want) -> setDataDialogWeapon("scytheofwant",contextDialog.getString(R.string.scythe_of_want),contextDialog.getString(R.string.scythe_of_want_des),"260","110","","15", "","20","","60","200","12.0","14","20","18","18")
         contextDialog.getString(R.string.bone_scythe) -> setDataDialogWeapon("bonescythe",contextDialog.getString(R.string.bone_scythe),contextDialog.getString(R.string.bone_scythe_des),"325","110","","15", "","20","","40","","10.0","28","20","","")
         contextDialog.getString(R.string.full_moon_sickle) -> setDataDialogWeapon("fullmoonsickle",contextDialog.getString(R.string.full_moon_sickle),contextDialog.getString(R.string.full_moon_sickle_des),"270","110","","15", "","20","","90","","8.0","20","18","","")
         contextDialog.getString(R.string.great_machete) -> setDataDialogWeapon("greatmachete",contextDialog.getString(R.string.great_machete),contextDialog.getString(R.string.great_machete_des),"250","110","","15", "","20","","30","","6.0","18","16","","")
         contextDialog.getString(R.string.silverblack_sickle) -> setDataDialogWeapon("silverblacksickle",contextDialog.getString(R.string.silverblack_sickle),contextDialog.getString(R.string.silverblack_sickle_des),"160","110","","20", "","15","","60","105","0.5","15","10","8","8")
         contextDialog.getString(R.string.great_scythe) -> setDataDialogWeapon("greatscythe",contextDialog.getString(R.string.great_scythe),contextDialog.getString(R.string.great_scythe_des),"260","110","","15", "","20","","60","","5.0","12","14","","")
         contextDialog.getString(R.string.rampart_golem_lance) -> setDataDialogWeapon("rampartgolemlance",contextDialog.getString(R.string.rampart_golem_lance),contextDialog.getString(R.string.rampart_golem_lance_des),"200","160","100","35", "","15","","40","","16.0","35","20","","")
         contextDialog.getString(R.string.chariot_lance) -> setDataDialogWeapon("chariotlance",contextDialog.getString(R.string.chariot_lance),contextDialog.getString(R.string.chariot_lance_des),"310","160","","35", "","15","","70","","16.0","35","20","","")
         contextDialog.getString(R.string.heide_great_lance) -> setDataDialogWeapon("heidegreatlance",contextDialog.getString(R.string.heide_great_lance),contextDialog.getString(R.string.heide_great_lance_des),"330","160","","30", "","15","","50","","10.0","20","22","","28")
         contextDialog.getString(R.string.wrathful_axe) -> setDataDialogWeapon("wrathfulaxe",contextDialog.getString(R.string.wrathful_axe),contextDialog.getString(R.string.wrathful_axe_des),"330","120","","35", "","40","","60","","15.0","20","22","","28")
         contextDialog.getString(R.string.roaring_halberd) -> setDataDialogWeapon("roaringhalberd",contextDialog.getString(R.string.roaring_halberd),contextDialog.getString(R.string.roaring_halberd_des),"310","120","","35", "","40","","40","","16.0","16","12","12","12")
         contextDialog.getString(R.string.syans_halberd) -> setDataDialogWeapon("syanshalberd",contextDialog.getString(R.string.syans_halberd),contextDialog.getString(R.string.syans_halberd_des),"330","120","","35", "","40","","60","","12.0","20","25","","")
         contextDialog.getString(R.string.blue_knights_halberd) -> setDataDialogWeapon("blueknightshalberd",contextDialog.getString(R.string.blue_knights_halberd),contextDialog.getString(R.string.blue_knights_halberd_des),"350","120","","35", "","40","","60","","5.0","18","20","","")
         contextDialog.getString(R.string.mastodon_halberd) -> setDataDialogWeapon("mastodonhalberd",contextDialog.getString(R.string.mastodon_halberd),contextDialog.getString(R.string.mastodon_halberd_des),"410","120","","40", "","40","","70","","16.0","26","15","","")
         contextDialog.getString(R.string.lucerne) -> setDataDialogWeapon("lucerne",contextDialog.getString(R.string.lucerne),contextDialog.getString(R.string.lucerne_des),"325","120","","35", "","40","","70","","6.5","18","14","","")
         contextDialog.getString(R.string.yorghs_spear) -> setDataDialogWeapon("yorghsspear",contextDialog.getString(R.string.yorghs_spear),contextDialog.getString(R.string.yorghs_spear_des),"300","130","","20", "","25","","60","","19.0","30","25","","")
         contextDialog.getString(R.string.pilgrims_spontoon) -> setDataDialogWeapon("pilgrimsspontoon",contextDialog.getString(R.string.pilgrims_spontoon),contextDialog.getString(R.string.pilgrims_spontoon_des),"","130","180","15", "","25","","40","180","3.5","11","12","30","30")
         contextDialog.getString(R.string.gargoyle_bident) -> setDataDialogWeapon("gargoylebident",contextDialog.getString(R.string.gargoyle_bident),contextDialog.getString(R.string.gargoyle_bident_des),"260","130","","20", "","25","","60","","12.0","22","15","","")
         contextDialog.getString(R.string.dragonslayer_spear) -> setDataDialogWeapon("dragonslayerspear",contextDialog.getString(R.string.dragonslayer_spear),contextDialog.getString(R.string.dragonslayer_spear_des),"180","130","","20", "","25","105","30","","10.0","16","25","","14")
         contextDialog.getString(R.string.spitfire_spear) -> setDataDialogWeapon("spitfirespear",contextDialog.getString(R.string.spitfire_spear),contextDialog.getString(R.string.spitfire_spear_des),"160","130","","20", "120","25","","40","","10.0","10","18","","")
         contextDialog.getString(R.string.channelers_trident) -> setDataDialogWeapon("channelerstrident",contextDialog.getString(R.string.channelers_trident),contextDialog.getString(R.string.channelers_trident_des),"240","130","","20", "","25","","40","","0.5","11","15","","")
         contextDialog.getString(R.string.pates_spear) -> setDataDialogWeapon("patesspear",contextDialog.getString(R.string.pates_spear),contextDialog.getString(R.string.pates_spear_des),"270","130","","20", "","25","","50","","6.0","11","27","","")
         contextDialog.getString(R.string.heide_spear) -> setDataDialogWeapon("heidespear",contextDialog.getString(R.string.heide_spear),contextDialog.getString(R.string.heide_spear_des),"210","130","","20", "","15","100","60","","0.5","12","25","","")
         contextDialog.getString(R.string.silverblack_spear) -> setDataDialogWeapon("silverblackspear",contextDialog.getString(R.string.silverblack_spear),contextDialog.getString(R.string.silverblack_spear_des),"150","130","","20", "","25","","50","60","6.0","9","16","8","8")
         contextDialog.getString(R.string.pike) -> setDataDialogWeapon("pike",contextDialog.getString(R.string.pike),contextDialog.getString(R.string.pike_des),"190","130","","20", "","25","","50","","8.0","12","16","","")
         contextDialog.getString(R.string.spear) -> setDataDialogWeapon("spear",contextDialog.getString(R.string.spear),contextDialog.getString(R.string.spear_des),"230","130","","20", "","25","","60","","4.5","12","20","","")
         contextDialog.getString(R.string.partizan) -> setDataDialogWeapon("partizan",contextDialog.getString(R.string.partizan),contextDialog.getString(R.string.partizan_des),"230","130","","20", "","25","","60","","4.5","12","20","","")
         contextDialog.getString(R.string.smelter_hammer) -> setDataDialogWeapon("smelterhammer",contextDialog.getString(R.string.smelter_hammer),contextDialog.getString(R.string.smelter_hammer_des),"500","100","","60", "","30","","300","","35.0","70","6","","")
         contextDialog.getString(R.string.sanctum_mace) -> setDataDialogWeapon("sanctummace",contextDialog.getString(R.string.sanctum_mace),contextDialog.getString(R.string.sanctum_mace_des),"400","100","","30", "","30","","30","","17.0","35","6","","")
         contextDialog.getString(R.string.drakekeepers_warpick) -> setDataDialogWeapon("drakekeeperswarpick",contextDialog.getString(R.string.drakekeepers_warpick),contextDialog.getString(R.string.drakekeepers_warpick_des),"420","100","","35", "","30","","70","","20.0","40","14","","")
         contextDialog.getString(R.string.sacred_chime_hammer) -> setDataDialogWeapon("sacredchimehammer",contextDialog.getString(R.string.sacred_chime_hammer),contextDialog.getString(R.string.sacred_chime_hammer_des),"380","100","","60", "","30","","70","150","22.0","40","12","12","12")
         contextDialog.getString(R.string.drakekeepers_great_hammer) -> setDataDialogWeapon("drakekeepersgreathammer",contextDialog.getString(R.string.drakekeepers_great_hammer),contextDialog.getString(R.string.drakekeepers_great_hammer_des),"450","100","","60", "","30","","70","","20.0","50","10","","")
         contextDialog.getString(R.string.old_knight_hammer) -> setDataDialogWeapon("oldknighthammer",contextDialog.getString(R.string.old_knight_hammer),contextDialog.getString(R.string.old_knight_hammer_des),"500","100","","65", "","30","","30","","18.0","30","6","","")
         contextDialog.getString(R.string.archdrake_mace) -> setDataDialogWeapon("archdrakemace",contextDialog.getString(R.string.archdrake_mace),contextDialog.getString(R.string.archdrake_mace_des),"250","100","","60", "","30","","60","","6.0","20","16","","")
         contextDialog.getString(R.string.giant_warrior_club) -> setDataDialogWeapon("giantwarriorclub",contextDialog.getString(R.string.giant_warrior_club),contextDialog.getString(R.string.giant_warrior_club_des),"520","100","","30", "","30","","50","","30.0","60","6","","")
         contextDialog.getString(R.string.iron_king_hammer) -> setDataDialogWeapon("ironkinghammer",contextDialog.getString(R.string.iron_king_hammer),contextDialog.getString(R.string.iron_king_hammer_des),"280","100","","60", "180","30","","60","","24.0","50","8","","")
         contextDialog.getString(R.string.barbed_club) -> setDataDialogWeapon("barbedclub",contextDialog.getString(R.string.barbed_club),contextDialog.getString(R.string.barbed_club_des),"270","120","","25", "","40","","60","","5.0","20","18","","")
         contextDialog.getString(R.string.aldia_hammer) -> setDataDialogWeapon("aldiahammer",contextDialog.getString(R.string.aldia_hammer),contextDialog.getString(R.string.aldia_hammer_des),"240","120","","20", "","40","","60","","3.5","18","16","","")
         contextDialog.getString(R.string.black_dragon_warpick) -> setDataDialogWeapon("blackdragonwarpick",contextDialog.getString(R.string.black_dragon_warpick),contextDialog.getString(R.string.black_dragon_warpick_des),"330","120","","25", "","40","","70","","6.0","20","15","","")
         contextDialog.getString(R.string.reinforced_club) -> setDataDialogWeapon("reinforcedclub",contextDialog.getString(R.string.reinforced_club),contextDialog.getString(R.string.reinforced_club_des),"280","120","","25", "","20","","20","","4.0","16","3","","")
         contextDialog.getString(R.string.gyrm_greataxe) -> setDataDialogWeapon("gyrmgreataxe",contextDialog.getString(R.string.gyrm_greataxe),contextDialog.getString(R.string.gyrm_greataxe_des),"410","140","","55", "","40","","80","","24.0","50","8","","")
         contextDialog.getString(R.string.giant_stone_axe) -> setDataDialogWeapon("giantstoneaxe",contextDialog.getString(R.string.giant_stone_axe),contextDialog.getString(R.string.giant_stone_axe_des),"400","100","","55", "","40","","70","","25.0","45","8","","")
         contextDialog.getString(R.string.lion_greataxe) -> setDataDialogWeapon("liongreataxe",contextDialog.getString(R.string.lion_greataxe),contextDialog.getString(R.string.lion_greataxe_des),"310","110","","45", "","40","","60","","12.0","30","8","","")
         contextDialog.getString(R.string.velstadts_helm) -> setDataDialogArmor("velstadtshelm",contextDialog.getString(R.string.velstadts_helm),contextDialog.getString(R.string.velstadt_helm_des),"113 ","14","103","10","123","29","108","21","15","21","15","7","140","35","7.5","","","","")
         contextDialog.getString(R.string.moon_butterfly_skirt) -> setDataDialogArmor("moonbutterflyskirt",contextDialog.getString(R.string.moon_butterfly_skirt),contextDialog.getString(R.string.moon_butterfly_skirt_des),"41 ","","45","39","39","17","39","22","21","24","14","22","35","18","1.2","","","","")
         contextDialog.getString(R.string.bandit_great_axe) -> setDataDialogWeapon("banditgreataxe",contextDialog.getString(R.string.bandit_great_axe),contextDialog.getString(R.string.banditgreataxe_des),"370","110","","45", "","40","","60","","10.0","28","8","","")
         contextDialog.getString(R.string.butchersk_nife) -> setDataDialogWeapon("butchersknife",contextDialog.getString(R.string.butchersk_nife),contextDialog.getString(R.string.butchersk_nife_des),"280","100","","40", "","40","","40","","16.0","25","8","","")
         contextDialog.getString(R.string.infantry_axe) -> setDataDialogWeapon("infantryaxe",contextDialog.getString(R.string.infantry_axe),contextDialog.getString(R.string.infantry_axe_des),"200","110","","30", "","30","","30","","3.5","9","1","","")
         contextDialog.getString(R.string.bound_hand_axe) -> setDataDialogWeapon("boundhandaxe",contextDialog.getString(R.string.bound_hand_axe),contextDialog.getString(R.string.bound_hand_axe_des),"180","110","","25", "","30","","60","","3.5","15","7","","")
         contextDialog.getString(R.string.ice_rapier) -> setDataDialogWeapon("icerapier",contextDialog.getString(R.string.ice_rapier),contextDialog.getString(R.string.ice_rapier_des),"220","140","","10", "","30","","50","","1.5","13","15","","")
         contextDialog.getString(R.string.espada_ropera) -> setDataDialogWeapon("espadaropera",contextDialog.getString(R.string.espada_ropera),contextDialog.getString(R.string.espada_ropera_des),"235","140","","10", "","20","","45","","2.0","11","18","","")
         contextDialog.getString(R.string.spiders_silk) -> setDataDialogWeapon("spiderssilk",contextDialog.getString(R.string.spiders_silk),contextDialog.getString(R.string.spiders_silk_des),"195","110","","10", "","10","","30","","0.5","5","20","","")
         contextDialog.getString(R.string.black_scorpion_stinger) -> setDataDialogWeapon("blackscorpionstinger",contextDialog.getString(R.string.black_scorpion_stinger),contextDialog.getString(R.string.black_scorpion_stinger_des),"300","100","","10", "","10","","30","","2.0","10","18","","")
         contextDialog.getString(R.string.chaos_rapier) -> setDataDialogWeapon("chaosrapier",contextDialog.getString(R.string.chaos_rapier),contextDialog.getString(R.string.chaos_rapier_des),"110","140","","10", "110","20","","45","","0.5","7","14","","")
         contextDialog.getString(R.string.curved_nil_greatsword) -> setDataDialogWeapon("curvednilgreatsword",contextDialog.getString(R.string.curved_nil_greatsword),contextDialog.getString(R.string.curved_nil_greatsword_des),"290","110","","45", "","40","","50","","17.0","28","26","","")
         contextDialog.getString(R.string.curved_dragon_greatsword) -> setDataDialogWeapon("curveddragongreatsword",contextDialog.getString(R.string.curved_dragon_greatsword),contextDialog.getString(R.string.curved_dragon_greatsword_des),"400","110","","45", "","40","","60","","18.0","30","18","","")
         contextDialog.getString(R.string.arced_sword) -> setDataDialogWeapon("arcedsword",contextDialog.getString(R.string.arced_sword),contextDialog.getString(R.string.arced_sword_des),"360","110","","45", "","40","","70","","14.0","26","16","","")
         contextDialog.getString(R.string.bewitched_alonne_sword) -> setDataDialogWeapon("bewitchedalonnesword",contextDialog.getString(R.string.bewitched_alonne_sword),contextDialog.getString(R.string.bewitched_alonne_sword_des),"180","150","","20", "","30","","20","","9.0","22","30","","")
         contextDialog.getString(R.string.berserker_blade) -> setDataDialogWeapon("berserkerblade",contextDialog.getString(R.string.berserker_blade),contextDialog.getString(R.string.berserker_blade_des),"240","150","","20", "","30","","40","","6.0","18","18","","")
         contextDialog.getString(R.string.blacksteel_katana) -> setDataDialogWeapon("blacksteelkatana",contextDialog.getString(R.string.blacksteel_katana),contextDialog.getString(R.string.blacksteel_katana_des),"190","150","","20", "","30","","40","","8.0","14","25","","")
         contextDialog.getString(R.string.chaos_blade) -> setDataDialogWeapon("chaosblade",contextDialog.getString(R.string.chaos_blade),contextDialog.getString(R.string.chaos_blade_des),"250","160","","20", "","30","","50","","6.0","12","25","","")
         contextDialog.getString(R.string.moon_butterfly_cuffs) -> setDataDialogArmor("moonbutterflycuffs",contextDialog.getString(R.string.moon_butterfly_cuffs),contextDialog.getString(R.string.moon_butterfly_cuffs_des),"27 ","","30","26","26","11","26","15","14","16","9","14","35","12","0.8","","","","")
         contextDialog.getString(R.string.moon_butterfly_wings) -> setDataDialogArmor("moonbutterflywingsframe",contextDialog.getString(R.string.moon_butterfly_wings),contextDialog.getString(R.string.moon_butterfly_wings_des),"48 ","","52","46","45","20","45","26","25","28","16","25","35","21","1.4","","","","")
         contextDialog.getString(R.string.moon_butterfly_hat) -> setDataDialogArmor("moonbutterflyhat",contextDialog.getString(R.string.moon_butterfly_hat),contextDialog.getString(R.string.moon_butterfly_hat_des),"27 ","","30","26","26","11","26","15","14","16","9","14","35","12","0.8","","","","")
         contextDialog.getString(R.string.eleum_loyce) -> setDataDialogWeapon("eleumloyce",contextDialog.getString(R.string.eleum_loyce),contextDialog.getString(R.string.eleum_loyce_des),"165","110","","20", "","30","","65","","3.5","18","27","","14")
         contextDialog.getString(R.string.manikin_sabre) -> setDataDialogWeapon("manikinsabre",contextDialog.getString(R.string.manikin_sabre),contextDialog.getString(R.string.manikin_sabre_des),"245","110","","15", "","30","","45","","2.5","6","19","","")
         contextDialog.getString(R.string.warped_sword) -> setDataDialogWeapon("warpedsword",contextDialog.getString(R.string.warped_sword),contextDialog.getString(R.string.warped_sword_des),"250","130","","25", "","30","","50","","3.5","15","25","","")
         contextDialog.getString(R.string.monastery_scimitar) -> setDataDialogWeapon("monasteryscimitar",contextDialog.getString(R.string.monastery_scimitar),contextDialog.getString(R.string.monastery_scimitar_des),"190","110","","15", "","30","","40","","1.5","9","22","","")
         contextDialog.getString(R.string.melu_scimitar) -> setDataDialogWeapon("meluscimitar",contextDialog.getString(R.string.melu_scimitar),contextDialog.getString(R.string.melu_scimitar_des),"250","100","","15", "","30","","75","","4.0","12","9","","")
         contextDialog.getString(R.string.spider_fang) -> setDataDialogWeapon("spiderfang",contextDialog.getString(R.string.spider_fang),contextDialog.getString(R.string.spider_fang_des),"210","110","","10", "","30","","40","","2.0","10","25","","")
         contextDialog.getString(R.string.red_rust_scimitar) -> setDataDialogWeapon("redrustscimitar",contextDialog.getString(R.string.red_rust_scimitar),contextDialog.getString(R.string.red_rust_scimitar_des),"270","100","","25", "","30","","60","","6.0","18","15","","")
         contextDialog.getString(R.string.ivory_king_ultra_greatsword) -> setDataDialogWeapon("ivorykingultragreatsword",contextDialog.getString(R.string.ivory_king_ultra_greatsword),contextDialog.getString(R.string.ivory_king_ultra_greatsword_des),"300","130","80","45", "","45","","200","","14.0","30","30","8","")
         contextDialog.getString(R.string.aged_smelter_sword) -> setDataDialogWeapon("agedsmeltersword",contextDialog.getString(R.string.aged_smelter_sword),contextDialog.getString(R.string.smelter_sword_des),"430","130","170","50", "","45","","90","","22.0","40","10","","")
         contextDialog.getString(R.string.fume_ultra_greatsword) -> setDataDialogWeapon("fumeultragreatsword",contextDialog.getString(R.string.fume_ultra_greatsword),contextDialog.getString(R.string.fume_ultra_greatsword_des),"430","110","","60", "","60","","70","","28.0","40","30","","")
         contextDialog.getString(R.string.lost_sinners_sword) -> setDataDialogWeapon("lostsinnerssword",contextDialog.getString(R.string.lost_sinners_sword),contextDialog.getString(R.string.lost_sinners_sword_des),"460","130","","50", "","45","","50","","12.0","24","18","","")
         contextDialog.getString(R.string.crypt_blacksword) -> setDataDialogWeapon("cryptblacksword",contextDialog.getString(R.string.crypt_blacksword),contextDialog.getString(R.string.crypt_blacksword_des),"370","130","","60", "","45","","70","130","24.0","40","10","","")
         contextDialog.getString(R.string.smelter_sword) -> setDataDialogWeapon("smeltersword",contextDialog.getString(R.string.smelter_sword),contextDialog.getString(R.string.smelter_sword_des),"400","130","","50", "170","45","","70","","22.0","40","10","","")
         contextDialog.getString(R.string.greatsword) -> setDataDialogWeapon("greatsword",contextDialog.getString(R.string.greatsword),contextDialog.getString(R.string.greatsword_des),"400","130","","50", "","45","","70","","22.0","28","10","","")
         contextDialog.getString(R.string.old_knight_ultra_greatsword) -> setDataDialogWeapon("oldknightultragreatsword",contextDialog.getString(R.string.old_knight_ultra_greatsword),contextDialog.getString(R.string.old_knight_ultra_greatsword_des),"350","130","","50", "","45","","30","","20.0","24","10","","")
         contextDialog.getString(R.string.drakekeepers_ultra_greatsword) -> setDataDialogWeapon("drakekeepersultragreatsword",contextDialog.getString(R.string.drakekeepers_ultra_greatsword),contextDialog.getString(R.string.drakekeepers_ultra_greatsword_des),"330","130","","50", "","45","","70","","20.0","38","13","","")
         contextDialog.getString(R.string.kings_ultra_greatsword) -> setDataDialogWeapon("kingsultragreatsword",contextDialog.getString(R.string.kings_ultra_greatsword),contextDialog.getString(R.string.kings_ultra_greatsword_des),"450","110","","60", "","60","","100","","28.0","50","10","","")
         contextDialog.getString(R.string.drakewing_ultra_greatsword) -> setDataDialogWeapon("drakewingultragreatsword",contextDialog.getString(R.string.drakewing_ultra_greatsword),contextDialog.getString(R.string.drakewing_ultra_greatsword_des),"335","130","","50", "","45","","70","","12.0","20","18","","")
         contextDialog.getString(R.string.greatsword_of_the_forlorn) -> setDataDialogWeapon("greatswordoftheforlorn",contextDialog.getString(R.string.greatsword_of_the_forlorn),contextDialog.getString(R.string.greatsword_of_the_forlorn_des),"220","110","","35", "","40","","65","80","9.0","20","15","","")
         contextDialog.getString(R.string.loyce_greatsword) -> setDataDialogWeapon("loycegreatsword",contextDialog.getString(R.string.loyce_greatsword),contextDialog.getString(R.string.loyce_greatsword_des),"230","110","","35", "","40","","60","","6.0","25","28","","")
         contextDialog.getString(R.string.charred_loyce_greatsword) -> setDataDialogWeapon("charredloycegreatsword",contextDialog.getString(R.string.charred_loyce_greatsword),contextDialog.getString(R.string.charred_loyce_greatsword_des),"180","150","","10", "90","15","","60","","9.0","25","28","","")
         contextDialog.getString(R.string.majestic_greatsword) -> setDataDialogWeapon("majesticgreatsword",contextDialog.getString(R.string.majestic_greatsword),contextDialog.getString(R.string.majestic_greatsword_des),"290","130","","35", "","40","","60","","9.0","25","25","","")
         contextDialog.getString(R.string.drakeblood_greatsword) -> setDataDialogWeapon("drakebloodgreatsword",contextDialog.getString(R.string.drakeblood_greatsword),contextDialog.getString(R.string.drakeblood_greatsword_des),"210","140","50","35", "","40","50","60","","6.0","20","18","","")
         contextDialog.getString(R.string.watcher_greatsword) -> setDataDialogWeapon("watchergreatsword",contextDialog.getString(R.string.watcher_greatsword),contextDialog.getString(R.string.watcher_greatsword_des),"185","110","150","35", "","40","","50","","7.0","18","16","15","")
         contextDialog.getString(R.string.defender_greatsword) -> setDataDialogWeapon("defendergreatsword",contextDialog.getString(R.string.defender_greatsword),contextDialog.getString(R.string.defender_greatsword_des),"280","110","","35", "","30","80","50","","12.0","20","12","","")
         contextDialog.getString(R.string.old_knight_greatsword) -> setDataDialogWeapon("oldknightgreatsword",contextDialog.getString(R.string.old_knight_greatsword),contextDialog.getString(R.string.old_knight_greatsword_des),"280","100","","50", "","40","","30","","13.0","17","12","","")
         contextDialog.getString(R.string.royal_greatsword) -> setDataDialogWeapon("royalgreatsword",contextDialog.getString(R.string.royal_greatsword),contextDialog.getString(R.string.royal_greatsword_des),"270","110","","35", "","40","","70","","6.0","20","15","","")
         contextDialog.getString(R.string.black_knight_greatsword) -> setDataDialogWeapon("blackknightgreatsword",contextDialog.getString(R.string.black_knight_greatsword),contextDialog.getString(R.string.black_knight_greatsword_des),"280","110","","35", "80","40","","70","","12.0","20","26","8","12")
         contextDialog.getString(R.string.black_dragon_greatsword) -> setDataDialogWeapon("blackdragongreatsword",contextDialog.getString(R.string.black_dragon_greatsword),contextDialog.getString(R.string.black_dragon_greatsword_des),"340","100","","35", "","40","","70","","9.0","25","16","","")
         contextDialog.getString(R.string.old_mirrah_greatsword) -> setDataDialogWeapon("oldmirrahgreatsword",contextDialog.getString(R.string.old_mirrah_greatsword),contextDialog.getString(R.string.old_mirrah_greatsword_des),"220","120","","35", "","40","","20","","7.0","16","20","","")
         contextDialog.getString(R.string.rulers_sword) -> setDataDialogWeapon("rulerssword",contextDialog.getString(R.string.rulers_sword),contextDialog.getString(R.string.rulers_sword_des),"280","110","","35", "","40","","60","","8.0","20","20","16","16")
         contextDialog.getString(R.string.mastodon_greatsword) -> setDataDialogWeapon("mastodongreatsword",contextDialog.getString(R.string.mastodon_greatsword),contextDialog.getString(R.string.mastodon_greatsword_des),"300","100","","40", "","40","","70","","16.0","30","12","18","")
         contextDialog.getString(R.string.moonlight_greatsword) -> setDataDialogWeapon("moonlightgreatswordframe",contextDialog.getString(R.string.moonlight_greatsword),contextDialog.getString(R.string.moonlight_greatsword_des),"","120","380","35", "","40","","75","","8.0","18","18","18","")
         contextDialog.getString(R.string.thorned_greatsword) -> setDataDialogWeapon("thornedgreatsword",contextDialog.getString(R.string.thorned_greatsword),contextDialog.getString(R.string.thorned_greatsword_des),"210","150","","10", "","15","","85","","8.0","20","15","","")
         contextDialog.getString(R.string.alva_leggings) -> setDataDialogArmor("alvaleggings",contextDialog.getString(R.string.alva_leggings),contextDialog.getString(R.string.alva_helm_des),"53 ","9","50","16","55","20","52","","52","","16","11","80","16","5.2","","","","")
         contextDialog.getString(R.string.alva_gauntlets) -> setDataDialogArmor("alvagauntlets",contextDialog.getString(R.string.alva_gauntlets),contextDialog.getString(R.string.alva_helm_des),"29","4","28","9","30","11","29","","8","","9","6","80","9","2.9","","","","")
         contextDialog.getString(R.string.alva_armor) -> setDataDialogArmor("alvaarmor",contextDialog.getString(R.string.alva_armor),contextDialog.getString(R.string.alva_helm_des),"89","15","85","26","92","35","88","","25","","27","19","80","26","8.8","","","","")
         contextDialog.getString(R.string.alva_helm) -> setDataDialogArmor("alvahelm",contextDialog.getString(R.string.alva_helm),contextDialog.getString(R.string.alva_helm_des),"38","6","36","11","39","15","37","","10","","11","8","80","11","3.7","","","","")
         contextDialog.getString(R.string.penal_skirt) -> setDataDialogArmor("penalskirt",contextDialog.getString(R.string.penal_skirt),contextDialog.getString(R.string.penal_straight_jaket_des),"68 ","11","","11","70","9","63","22","28","29","35","26","55","32","4.8","","","","")
         contextDialog.getString(R.string.penal_handcuffs) -> setDataDialogArmor("penalhandcuffs",contextDialog.getString(R.string.penal_handcuffs),contextDialog.getString(R.string.penal_handcuffs_des),"55","","57","11","57","9","50","22","21","29","35","19","55","25","4.8","","","","")
         contextDialog.getString(R.string.penal_straight_jacket) -> setDataDialogArmor("penalstraightjacket",contextDialog.getString(R.string.penal_straight_jacket),contextDialog.getString(R.string.penal_straight_jaket_des),"75","","77","12","77","9","70","25","31","32","39","28","55","35","6.2","","","","")
         contextDialog.getString(R.string.penal_mask) -> setDataDialogArmor("penalmask",contextDialog.getString(R.string.penal_mask),contextDialog.getString(R.string.penal_mask_des),"65","5","59","10","73","15","60","21","27","41","33","17","120","30","5.1","","","","")
         contextDialog.getString(R.string.looking_glass_leggings) -> setDataDialogArmor("lookingglassleggings",contextDialog.getString(R.string.looking_glass_leggings),contextDialog.getString(R.string.looking_glass_mask_des),"145","27","125","17","165","35","144","","18","","20","33","150","18","10.4","16","","","")
         contextDialog.getString(R.string.looking_glass_gauntlets) -> setDataDialogArmor("lookingglassgauntlets",contextDialog.getString(R.string.looking_glass_gauntlets),contextDialog.getString(R.string.looking_glass_mask_des),"114","27","125","17","165","35","144","","18","","20","33","150","18","10.4","16","","","")
         contextDialog.getString(R.string.looking_glass_armor) -> setDataDialogArmor("lookingglassarmor",contextDialog.getString(R.string.looking_glass_armor),contextDialog.getString(R.string.looking_glass_mask_des),"253","44","220","30","289","62","253","","32","","36","57","150","32","18.3","16","","","")
         contextDialog.getString(R.string.looking_glass_mask) -> setDataDialogArmor("lookingglassmask",contextDialog.getString(R.string.looking_glass_mask),contextDialog.getString(R.string.looking_glass_mask_des),"97","18","85","12","110","24","97","","13","","14","22","150","13","7.0","16","","","")
         contextDialog.getString(R.string.smelter_demon_leggings) -> setDataDialogArmor("smelterdemonleggingsframe",contextDialog.getString(R.string.smelter_demon_leggings),contextDialog.getString(R.string.smelter_demon_helm_des),"145","26","130","11","161","30","145","19","18","19","38","18","160","18","10.4","16","","","")
         contextDialog.getString(R.string.smelter_demon_gauntlets) -> setDataDialogArmor("smelterdemongauntletsframe",contextDialog.getString(R.string.smelter_demon_gauntlets),contextDialog.getString(R.string.smelter_demon_helm_des),"145","26","130","11","161","30","145","19","18","19","38","18","160","18","10.4","16","","","")
         contextDialog.getString(R.string.smelter_demon_armor) -> setDataDialogArmor("smelterdemonarmorframe",contextDialog.getString(R.string.smelter_demon_armor),contextDialog.getString(R.string.smelter_demon_helm_des),"243","43","245","19","298","52","172","32","31","32","65","29","160","31","17.6","16","","","")
         contextDialog.getString(R.string.smelter_demon_helm) -> setDataDialogArmor("smelterdemonhelmframe",contextDialog.getString(R.string.smelter_demon_helm),contextDialog.getString(R.string.smelter_demon_helm_des),"113","17","99","10","128","27","113","17","16","17","33","15","160","16","9.0","16","","","")
         contextDialog.getString(R.string.elite_knight_leggings) -> setDataDialogArmor("eliteknightleggings",contextDialog.getString(R.string.elite_knight_leggings),contextDialog.getString(R.string.elite_knight_helm_des),"61","9","59","14","67","20","61","","17","","19","13","85","17","6.9","","","","")
         contextDialog.getString(R.string.elite_knight_gloves) -> setDataDialogArmor("eliteknightgloves",contextDialog.getString(R.string.elite_knight_gloves),contextDialog.getString(R.string.elite_knight_helm_des),"33","4","32","8","36","11","3","","9","","10","7","85","9","3.7","","","","")
         contextDialog.getString(R.string.elite_knight_armor) -> setDataDialogArmor("eliteknightarmor",contextDialog.getString(R.string.elite_knight_armor),contextDialog.getString(R.string.elite_knight_helm_des),"104","15","101","24","114","34","104","","29","","32","21","85","29","11.7","","","","")
         contextDialog.getString(R.string.elite_knight_helm) -> setDataDialogArmor("eliteknighthelm",contextDialog.getString(R.string.elite_knight_helm),contextDialog.getString(R.string.elite_knight_helm_des),"40","6","39","9","44","13","40","","11","","12","8","85","11","4.5","","","","")
         contextDialog.getString(R.string.drangleic_sword) -> setDataDialogWeapon("drangleicsword",contextDialog.getString(R.string.drangleic_sword),contextDialog.getString(R.string.drangleic_sword_des),"280","120","","35", "","40","","70","","9.0","20","25","","")
         contextDialog.getString(R.string.claymore) -> setDataDialogWeapon("claymore",contextDialog.getString(R.string.claymore),contextDialog.getString(R.string.claymore_des),"290","110","","35", "","40","","60","","8.0","20","13","","")
         contextDialog.getString(R.string.bluemoon_greatsword) -> setDataDialogWeapon("bluemoongreatsword",contextDialog.getString(R.string.bluemoon_greatsword),contextDialog.getString(R.string.bluemoon_greatsword_des),"375","110","","35", "","40","","30","","15.0","28","10","","")
         contextDialog.getString(R.string.ivory_straight_sword) -> setDataDialogWeapon("ivorystraightsword",contextDialog.getString(R.string.ivory_straight_sword),contextDialog.getString(R.string.ivory_straight_sword_des),"252","120","","10", "","5","","250","","0.5","6","40","","")
         contextDialog.getString(R.string.possessed_armor_sword) -> setDataDialogWeapon("possessedarmorsword",contextDialog.getString(R.string.possessed_armor_sword),contextDialog.getString(R.string.possessed_armor_sword_des),"166","110","","25", "93","30","","50","","5.0","20","13","","")
         contextDialog.getString(R.string.fume_sword) -> setDataDialogWeapon("fumesword",contextDialog.getString(R.string.fume_sword),contextDialog.getString(R.string.fume_sword_des),"140","120","","25", "","30","","40","70","3.0","15","22","","")
         contextDialog.getString(R.string.ashen_warrior_sword) -> setDataDialogWeapon("ashenwarriorsword",contextDialog.getString(R.string.ashen_warrior_sword),contextDialog.getString(R.string.ashen_warrior_sword_des),"180","110","","25", "","30","","30","","3.0","10","18","","")
         contextDialog.getString(R.string.puzzling_stone_sword) -> setDataDialogWeapon("puzzlingstonesword",contextDialog.getString(R.string.puzzling_stone_sword),contextDialog.getString(R.string.puzzling_stone_sword_des),"145","120","","25", "","20","","60","","2.0","7","6","","")
         contextDialog.getString(R.string.drakekeepers_sword) -> setDataDialogWeapon("drakekeeperssword",contextDialog.getString(R.string.drakekeepers_sword),contextDialog.getString(R.string.drakekeepers_sword_des),"245","100","","25", "","30","","90","","6.0","16","8","","")
         contextDialog.getString(R.string.sun_sword) -> setDataDialogWeapon("sunsword",contextDialog.getString(R.string.sun_sword),contextDialog.getString(R.string.sun_sword_des),"175","110","","20", "","30","","60","","3.0","15","13","","")
         contextDialog.getString(R.string.red_rust_sword) -> setDataDialogWeapon("redrustsword",contextDialog.getString(R.string.red_rust_sword),contextDialog.getString(R.string.red_rust_sword_des),"205","100","","30", "","30","","80","","8.0","23","13","","")
         contextDialog.getString(R.string.blue_flame) -> setDataDialogWeapon("blueflame",contextDialog.getString(R.string.blue_flame),contextDialog.getString(R.string.blue_flame_des),"130","110","180","20", "","20","","60","","3.0","13","15","12","")
         contextDialog.getString(R.string.heide_knight_sword) -> setDataDialogWeapon("heideknightsword",contextDialog.getString(R.string.heide_knight_sword),contextDialog.getString(R.string.heide_knight_sword_des),"150","110","107","20", "","30","90","70","","4.0","10","11","","")
         contextDialog.getString(R.string.varangian_sword) -> setDataDialogWeapon("varangiansword",contextDialog.getString(R.string.varangian_sword),contextDialog.getString(R.string.varangian_sword_des),"250","110","","20", "","30","","40","","5.0","14","6","","")
         contextDialog.getString(R.string.foot_soldier_sword) -> setDataDialogWeapon("footsoldiersword",contextDialog.getString(R.string.foot_soldier_sword),contextDialog.getString(R.string.foot_soldier_sword_des),"230","110","","25", "","20","","20","","2.0","7","6","","")
         contextDialog.getString(R.string.broken_straight_sword) -> setDataDialogWeapon("brokenstraightsword",contextDialog.getString(R.string.broken_straight_sword),contextDialog.getString(R.string.broken_straight_sword_des),"160","100","","15", "","5","","40","","2.0","2","3","","")
         contextDialog.getString(R.string.black_dragon_sword) -> setDataDialogWeapon("blackdragonsword",contextDialog.getString(R.string.black_dragon_sword),contextDialog.getString(R.string.black_dragon_sword_des),"300","110","","20", "","30","","60","","4.0","20","15","","")
         contextDialog.getString(R.string.yellow_quartz_longsword) -> setDataDialogWeapon("yellowquartzlongsword",contextDialog.getString(R.string.yellow_quartz_longsword),contextDialog.getString(R.string.yellow_quartz_longsword_des),"220","120","","10", "","30","","30","","2.0","13","8","","")
         contextDialog.getString(R.string.yorghs_ring) -> setDataDialogObjects("yorghsring",contextDialog.getString(R.string.yorghs_ring),contextDialog.getString(R.string.yorghs_ring_des))
         contextDialog.getString(R.string.white_ring) -> setDataDialogObjects("whitering",contextDialog.getString(R.string.white_ring),contextDialog.getString(R.string.white_ring_des))
         contextDialog.getString(R.string.vanquishers_seal) -> setDataDialogObjects("vanquishersseal",contextDialog.getString(R.string.vanquishers_seal),contextDialog.getString(R.string.vanquishers_seal_des))
         contextDialog.getString(R.string.thunder_quartz_ring) -> setDataDialogObjects("thunderquartzring",contextDialog.getString(R.string.thunder_quartz_ring),contextDialog.getString(R.string.thunder_quartz_ring_des))
         contextDialog.getString(R.string.sun_seal) -> setDataDialogObjects("sunseal",contextDialog.getString(R.string.sun_seal),contextDialog.getString(R.string.sun_seal_des))
         contextDialog.getString(R.string.strength_ring) -> setDataDialogObjects("strengthring",contextDialog.getString(R.string.strength_ring),contextDialog.getString(R.string.strength_ring_des))
         contextDialog.getString(R.string.sorcery_clutch_ring) -> setDataDialogObjects("sorceryclutchring",contextDialog.getString(R.string.sorcery_clutch_ring),contextDialog.getString(R.string.sorcery_clutch_ring_des))
         contextDialog.getString(R.string.slumbering_dragon_crest_ring) -> setDataDialogObjects("slumberingdragoncrestring",contextDialog.getString(R.string.slumbering_dragon_crest_ring),contextDialog.getString(R.string.slumbering_dragon_crest_ring_des))
         contextDialog.getString(R.string.simpletons_ring) -> setDataDialogObjects("simpletonsring",contextDialog.getString(R.string.simpletons_ring),contextDialog.getString(R.string.simpletons_ring_des))
         contextDialog.getString(R.string.second_dragon_ring) -> setDataDialogObjects("seconddragonring",contextDialog.getString(R.string.second_dragon_ring),contextDialog.getString(R.string.second_dragon_ring_des))
         contextDialog.getString(R.string.ring_of_thorns) -> setDataDialogObjects("ringofthorns",contextDialog.getString(R.string.ring_of_thorns),contextDialog.getString(R.string.ring_of_thorns_des))
         contextDialog.getString(R.string.ring_of_the_embedded) -> setDataDialogObjects("ringoftheembedded",contextDialog.getString(R.string.ring_of_the_embedded),contextDialog.getString(R.string.ring_of_the_embedded_des))
         contextDialog.getString(R.string.ring_of_the_living) -> setDataDialogObjects("ringoftheliving",contextDialog.getString(R.string.ring_of_the_living),contextDialog.getString(R.string.ring_of_the_living_des))
         contextDialog.getString(R.string.ring_of_the_dead) -> setDataDialogObjects("ringofthedead",contextDialog.getString(R.string.ring_of_the_dead),contextDialog.getString(R.string.ring_of_the_dead_des))
         contextDialog.getString(R.string.ringof_steel_protection) -> setDataDialogObjects("ringofsteelprotection",contextDialog.getString(R.string.ringof_steel_protection),contextDialog.getString(R.string.ringof_steel_protection_des))
         contextDialog.getString(R.string.ring_of_soul_protection) -> setDataDialogObjects("ringofsoulprotection",contextDialog.getString(R.string.ring_of_soul_protection),contextDialog.getString(R.string.ring_of_soul_protection_des))
         contextDialog.getString(R.string.ring_of_restoration) -> setDataDialogObjects("ringofrestoration",contextDialog.getString(R.string.ring_of_restoration),contextDialog.getString(R.string.ring_of_restoration_des))
         contextDialog.getString(R.string.ring_of_resistance) -> setDataDialogObjects("ringofresistance",contextDialog.getString(R.string.ring_of_resistance),contextDialog.getString(R.string.ring_of_resistance_des))
         contextDialog.getString(R.string.ring_of_prayer) -> setDataDialogObjects("ringofprayer",contextDialog.getString(R.string.ring_of_prayer),contextDialog.getString(R.string.ring_of_prayer_des))
         contextDialog.getString(R.string.ring_of_knowledge) -> setDataDialogObjects("ringofknowledge",contextDialog.getString(R.string.ring_of_knowledge),contextDialog.getString(R.string.ring_of_knowledge_des))
         contextDialog.getString(R.string.name_engraved_ring) -> setDataDialogObjects("nameengravedring",contextDialog.getString(R.string.name_engraved_ring),contextDialog.getString(R.string.name_engraved_ring_des))
         contextDialog.getString(R.string.lingering_dragoncrest_ring) -> setDataDialogObjects("lingeringdragoncrestring",contextDialog.getString(R.string.lingering_dragoncrest_ring),contextDialog.getString(R.string.lingering_dragoncrest_ring_des))
         contextDialog.getString(R.string.lightning_clutch_ring) -> setDataDialogObjects("lightningclutchring",contextDialog.getString(R.string.lightning_clutch_ring),contextDialog.getString(R.string.lightning_clutch_ring_des))
         contextDialog.getString(R.string.kings_ring) -> setDataDialogObjects("kings_ring",contextDialog.getString(R.string.kings_ring),contextDialog.getString(R.string.kings_ring_des))
         contextDialog.getString(R.string.ivory_warrior_ring) -> setDataDialogObjects("ivorywarriorring",contextDialog.getString(R.string.ivory_warrior_ring),contextDialog.getString(R.string.ivory_warrior_ring_des))
         contextDialog.getString(R.string.illusory_ring_of_the_exalted) -> setDataDialogObjects("illusoryringoftheexalted",contextDialog.getString(R.string.illusory_ring_of_the_exalted),contextDialog.getString(R.string.illusory_ring_of_the_exalted_des))
         contextDialog.getString(R.string.illusory_ring_of_a_conqueror) -> setDataDialogObjects("illusoryringofaconqueror",contextDialog.getString(R.string.illusory_ring_of_a_conqueror),contextDialog.getString(R.string.illusory_ring_of_a_conqueror_des))
         contextDialog.getString(R.string.guardians_seal) -> setDataDialogObjects("guardiansseal",contextDialog.getString(R.string.guardians_seal),contextDialog.getString(R.string.guardians_seal_des))
         contextDialog.getString(R.string.flynns_ring) -> setDataDialogObjects("flynnsring",contextDialog.getString(R.string.flynns_ring),contextDialog.getString(R.string.flynns_ring_des))
         contextDialog.getString(R.string.first_dragon_ring) -> setDataDialogObjects("firstdragonring",contextDialog.getString(R.string.first_dragon_ring),contextDialog.getString(R.string.first_dragon_ring_des))
         contextDialog.getString(R.string.fire_clutch_ring) -> setDataDialogObjects("fireclutchring",contextDialog.getString(R.string.fire_clutch_ring),contextDialog.getString(R.string.fire_clutch_ring_des))
         contextDialog.getString(R.string.dispelling_ring) -> setDataDialogObjects("dispellingring",contextDialog.getString(R.string.dispelling_ring),contextDialog.getString(R.string.dispelling_ring_des))
         contextDialog.getString(R.string.dexterity_ring) -> setDataDialogObjects("dexterityring",contextDialog.getString(R.string.dexterity_ring),contextDialog.getString(R.string.dexterity_ring_des))
         contextDialog.getString(R.string.delicate_string) -> setDataDialogObjects("delicatestring",contextDialog.getString(R.string.delicate_string),contextDialog.getString(R.string.delicate_string_des))
         contextDialog.getString(R.string.dark_clutch_ring) -> setDataDialogObjects("darkclutchring",contextDialog.getString(R.string.dark_clutch_ring),contextDialog.getString(R.string.dark_clutch_ring_des))
         contextDialog.getString(R.string.cursebite_ring) -> setDataDialogObjects("cursebitering",contextDialog.getString(R.string.cursebite_ring),contextDialog.getString(R.string.cursebite_ring_des))
         contextDialog.getString(R.string.crest_of_the_rat) -> setDataDialogObjects("crestoftherat",contextDialog.getString(R.string.crest_of_the_rat),contextDialog.getString(R.string.crest_of_the_rat_des))
         contextDialog.getString(R.string.crest_of_blood) -> setDataDialogObjects("crestofblood",contextDialog.getString(R.string.crest_of_blood),contextDialog.getString(R.string.crest_of_blood_des))
         contextDialog.getString(R.string.blue_seal) -> setDataDialogObjects("blueseal",contextDialog.getString(R.string.blue_seal),contextDialog.getString(R.string.blue_seal_des))
         contextDialog.getString(R.string.bloodbite_ring) -> setDataDialogObjects("bloodbitering",contextDialog.getString(R.string.bloodbite_ring),contextDialog.getString(R.string.bloodbite_ring_des))
         contextDialog.getString(R.string.bell_keepers_seal) -> setDataDialogObjects("bellkeepersseal",contextDialog.getString(R.string.bell_keepers_seal),contextDialog.getString(R.string.bell_keepers_seal_des))
         contextDialog.getString(R.string.baneful_bird_ring) -> setDataDialogObjects("banefulbirdring",contextDialog.getString(R.string.baneful_bird_ring),contextDialog.getString(R.string.baneful_bird_ring_des))
         contextDialog.getString(R.string.ancient_dragon_seal) -> setDataDialogObjects("ancientdragonseal",contextDialog.getString(R.string.ancient_dragon_seal),contextDialog.getString(R.string.ancient_dragon_seal_des))
         contextDialog.getString(R.string.abyss_seal) -> setDataDialogObjects("abyssseal",contextDialog.getString(R.string.abyss_seal),contextDialog.getString(R.string.abyss_seal_des))
         contextDialog.getString(R.string.agape_ring) -> setDataDialogObjects("agapering",contextDialog.getString(R.string.agape_ring),contextDialog.getString(R.string.agape_ring_des))
         contextDialog.getString(R.string.royal_soldier_gauntlets) -> setDataDialogArmor("royalsoldiergauntlets",contextDialog.getString(R.string.royal_soldier_gauntlets),contextDialog.getString(R.string.royal_soldier_helmet_des),"32 ","6","31","9","34","10","33","","10","","10","7","70","10","3.8","","","","")
         contextDialog.getString(R.string.royal_soldier_leggings) -> setDataDialogArmor("royalsoldierleggings",contextDialog.getString(R.string.royal_soldier_leggings),contextDialog.getString(R.string.royal_soldier_helmet_des),"45 ","8","43","12","47","14","46","","14","","14","10","70","14","5.3","","","","")
         contextDialog.getString(R.string.royal_soldier_armor) -> setDataDialogArmor("royalsoldierarmor",contextDialog.getString(R.string.royal_soldier_armor),contextDialog.getString(R.string.royal_soldier_helmet_des),"79 ","16","74","21","82","23","80","","24","","25","17","70","24","9.2","","","","")
         contextDialog.getString(R.string.royal_soldier_helmet) -> setDataDialogArmor("royalsoldierhelmet",contextDialog.getString(R.string.royal_soldier_helmet),contextDialog.getString(R.string.royal_soldier_helmet_des),"41 ","8","39","11","43","12","42","","13","","13","9","70","13","4.8","","","","")
         contextDialog.getString(R.string.falconer_boots) -> setDataDialogArmor("falconerboots",contextDialog.getString(R.string.falconer_boots),"","55 ","8","59","18","54","15","54","","17","","14","19","75","17","5.8","","","","")
         contextDialog.getString(R.string.falconer_gloves) -> setDataDialogArmor("falconergloves",contextDialog.getString(R.string.falconer_gloves),"","31 ","4","32","10","30","8","30","","9","","8","10","75","9","3.2","","","","")
         contextDialog.getString(R.string.falconer_helm) -> setDataDialogArmor("falconerhelm",contextDialog.getString(R.string.falconer_helm),"","43 ","6","45","9","47","17","44","","13","13","19","7","75","13","4.5","","","","")
         contextDialog.getString(R.string.infantry_boots) -> setDataDialogArmor("infantryboots",contextDialog.getString(R.string.infantry_boots),"","43 ","","45","11","42","11","42","","11","","10","14","55","11","4.5","","","","")
         contextDialog.getString(R.string.infantry_gloves) -> setDataDialogArmor("infantrygloves",contextDialog.getString(R.string.infantry_gloves),"","27 ","","28","7","26","7","26","","7","","6","9","55","7","2.8","","","","")
         contextDialog.getString(R.string.infantry_armor) -> setDataDialogArmor("infantryarmor",contextDialog.getString(R.string.infantry_armor),"","57 ","","59","15","55","15","55","","14","","13","18","55","14   ","5.9","","","","")
         contextDialog.getString(R.string.hard_leather_boots) -> setDataDialogArmor("hardleatherboots",contextDialog.getString(R.string.hard_leather_boots   ),"","40 ","","42","14","39","13","39","","13","","8","16","65","13   ","3.8","","","","")
         contextDialog.getString(R.string.hard_leather_gauntlets) -> setDataDialogArmor("hardleathergauntlets",contextDialog.getString(R.string.hard_leather_gauntlets),"","40 ","","42","14","39","13","39","","13","","8","16","65","13   ","3.8","","","","")
         contextDialog.getString(R.string.hard_leather_armor) -> setDataDialogArmor("hardleatherarmor",contextDialog.getString(R.string.hard_leather_armor),"","68 ","","71","26","66","24","67","","21","","14","26","65","22   ","7.2","","","","")
         contextDialog.getString(R.string.standard_helm) -> setDataDialogArmor("standardhelm",contextDialog.getString(R.string.standard_helm),"","40 ","5","28","10","53","18","39","","8","","10","3","65","8","4.0","","","","")
         contextDialog.getString(R.string.heal) -> setDataDialogMagics("heal",contextDialog.getString(R.string.heal),contextDialog.getString(R.string.heal_des),"", "12")
         contextDialog.getString(R.string.soul_arrow) -> setDataDialogMagics("soularrow",contextDialog.getString(R.string.soul_arrow),contextDialog.getString(R.string.soul_arrow_des),"10","")
         contextDialog.getString(R.string.targrays_leggings) -> setDataDialogArmor("targraysleggings",contextDialog.getString(R.string.targrays_leggings),contextDialog.getString(R.string.targrays_helm_des),"53 ","10","49","16","57","17","53","","13","","13","28","75","15","5.8","","","","")
         contextDialog.getString(R.string.targrays_manifers) -> setDataDialogArmor("targraysmanifers",contextDialog.getString(R.string.targrays_manifers),contextDialog.getString(R.string.targrays_helm_des),"30 ","7","28","9","32","10","30","","7","","7","13","75","8","3.3","","","","")
         contextDialog.getString(R.string.targrays_armor) -> setDataDialogArmor("targraysarmor",contextDialog.getString(R.string.targrays_armor),contextDialog.getString(R.string.targrays_helm_des),"89 ","17","83","27","96","30","89","","22","","22","18","75","25","9.8","","","","")
         contextDialog.getString(R.string.targrays_helm) -> setDataDialogArmor("targrayshelm",contextDialog.getString(R.string.targrays_helm),contextDialog.getString(R.string.targrays_helm_des),"36 ","5","34","11","39","12","36","","9","","9","18","75","10","4.0","","","","")
         contextDialog.getString(R.string.lenigrasts_key) -> setDataDialogObjects("lenigrastskey",contextDialog.getString(R.string.lenigrasts_key),contextDialog.getString(R.string.lenigrasts_key_des))
         contextDialog.getString(R.string.hexers_boots) -> setDataDialogArmor("hexersboots",contextDialog.getString(R.string.hexers_boots),contextDialog.getString(R.string.hexers_hood_des),"52 ","","55","23","49","20","49","30","38","27","56","38","55","38","2.0","","","","")
         contextDialog.getString(R.string.hexers_gloves) -> setDataDialogArmor("hexersgloves",contextDialog.getString(R.string.hexers_gloves),contextDialog.getString(R.string.hexers_hood_des),"26 ","","28","12","25","10","25","15","19","14","28","19","55","19","1.0","","","","")
         contextDialog.getString(R.string.hexers_robes) -> setDataDialogArmor("hexersrobes",contextDialog.getString(R.string.hexers_robes),contextDialog.getString(R.string.hexers_hood_des),"67 ","","72","30","64","26","64","39","49","35","73","49","55","49","2.6","","","","")
         contextDialog.getString(R.string.hexers_hood) -> setDataDialogArmor("hexershood",contextDialog.getString(R.string.hexers_hood),contextDialog.getString(R.string.hexers_hood_des),"23 ","","25","10","22","9","22","13","17","12","25","17","55","17","0.9","","","","")
         contextDialog.getString(R.string.saints_trousers) -> setDataDialogArmor("saintstrousers",contextDialog.getString(R.string.saints_trousers),contextDialog.getString(R.string.saints_hood_des),"52 ","","55","23","49","10","49","44","38","41","38","47","55","38","2.0","","","","16")
         contextDialog.getString(R.string.saints_long_gloves) -> setDataDialogArmor("saintslonggloves",contextDialog.getString(R.string.saints_long_gloves),contextDialog.getString(R.string.saints_hood_des),"26 ","","28","12","25","26","25","22","19","20","19","23","55","19","1.0","","","","16")
         contextDialog.getString(R.string.saints_dress) -> setDataDialogArmor("saintsdress",contextDialog.getString(R.string.saints_dress),contextDialog.getString(R.string.saints_dress_des),"67 ","","72","30","64","26","64","57","49","53","49","61","55","49","2.6","","","","16")
         contextDialog.getString(R.string.saints_hood) -> setDataDialogArmor("saintshood",contextDialog.getString(R.string.saints_hood),contextDialog.getString(R.string.saints_hood_des),"23 ","","25","10","22","9","22","20","17","18","17","21","55","17","0.9","","","","16")
         contextDialog.getString(R.string.creightons_chain_leggins) -> setDataDialogArmor("creightonschainleggings",contextDialog.getString(R.string.creightons_chain_leggins),contextDialog.getString(R.string.creightons_chainmail_des),"42 ","7","41","10","43","24","42","","13","","14","7","70","13","4.5","","","","")
         contextDialog.getString(R.string.creightons_chain_gloves) -> setDataDialogArmor("creightonschaingloves",contextDialog.getString(R.string.creightons_chain_gloves),contextDialog.getString(R.string.creightons_chainmail_des),"32 ","6","31","7","33","18","32","","10","","11","5","70","10","3.4","","","","")
         contextDialog.getString(R.string.creightons_chainmail) -> setDataDialogArmor("creightonschainmail",contextDialog.getString(R.string.creightons_chainmail),contextDialog.getString(R.string.creightons_chainmail_des),"90 ","14","88","21","93","51","90","","27","","30","16","70","27","9.7","","","","")
         contextDialog.getString(R.string.lucatiels_trousers) -> setDataDialogArmor("lucatielstrousers",contextDialog.getString(R.string.lucatiels_trousers),contextDialog.getString(R.string.lucatiels_vest_des),"51 ","","55","22","49","17","49","9","28","18","25","30","65","28","4.0","","","","")
         contextDialog.getString(R.string.lucatiels_gloves) -> setDataDialogArmor("lucatielsgloves",contextDialog.getString(R.string.lucatiels_gloves),contextDialog.getString(R.string.lucatiels_vest_des),"25 ","","27","11","25","9","25","5","14","9","12","15","65","14","2.0","","","","")
         contextDialog.getString(R.string.lucatiels_vest) -> setDataDialogArmor("lucatielsvest",contextDialog.getString(R.string.lucatiels_vest),contextDialog.getString(R.string.lucatiels_vest_des),"76 ","","82","33","74","26","74","14","42","27","37","46","65","42","6.0","","","","")
         contextDialog.getString(R.string.cales_shoes) -> setDataDialogArmor("calesshoes",contextDialog.getString(R.string.cales_shoes),contextDialog.getString(R.string.cales_leather_armor_des),"83 ","","82","37","82","23","86","","24","","25","9","20","24","29.5","","","","")
         contextDialog.getString(R.string.cales_leather_armor) -> setDataDialogArmor("calesleatherarmor",contextDialog.getString(R.string.cales_leather_armor),contextDialog.getString(R.string.cales_leather_armor_des),"39 ","","38","17","38","11","40","","11","","12","9","72","11","29.5","","","","")
         contextDialog.getString(R.string.benharts_set) -> setDataDialogArmor("benhartsset",contextDialog.getString(R.string.benharts_set),contextDialog.getString(R.string.benharts_set_des),"585 ","49","563","153","607","118","585","","135","","128","117","72","135","29.5","","","","")
         contextDialog.getString(R.string.pates_set) -> setDataDialogArmor("patesset",contextDialog.getString(R.string.pates_set),contextDialog.getString(R.string.pates_set_des),"395 ","5","395","65","414","62","365","138","161","198","214","134","120","181","20.9","","","","")
         contextDialog.getString(R.string.traveling_merchant_set) -> setDataDialogArmor("travelingmerchantset",contextDialog.getString(R.string.traveling_merchant_set),"","344 ","","367","122","333","137","333","","98","","107","114","60","98","17.9","","","","")
         contextDialog.getString(R.string.darkdrift) -> setDataDialogWeapon("darkdrift",contextDialog.getString(R.string.darkdrift),contextDialog.getString(R.string.darkdrift_des),"130","130","","15","","30","","20","","3.0","12","28","","")
         contextDialog.getString(R.string.mirrah_greatsword) -> setDataDialogWeapon("mirrahgreatsword",contextDialog.getString(R.string.mirrah_greatsword),contextDialog.getString(R.string.mirrah_greatsword_des),"125","120","","35","","40","","60","","7.0","16","20","","")
         contextDialog.getString(R.string.scythe_of_nahr_alma) -> setDataDialogWeapon("scytheofnahralma",contextDialog.getString(R.string.scythe_of_nahr_alma),contextDialog.getString(R.string.scythe_of_nahr_alma_des),"93","110","","15","","20","","90","","5.0","14","12","","")
         contextDialog.getString(R.string.club) -> setDataDialogWeapon("club",contextDialog.getString(R.string.club),contextDialog.getString(R.string.club_des),"105","120","","25","","20","","50","","3.0","12","3","","")
         contextDialog.getString(R.string.flying_feline_boots) -> setDataDialogArmor("flyingfelineboots",contextDialog.getString(R.string.flying_feline_boots),contextDialog.getString(R.string.flying_feline_boots_des),"40","","49","17","35","19","35","","15","50","9","25","2.0","16","66","","","","")
         contextDialog.getString(R.string.vessel_shield) -> setDataDialogShield("vesselshield",contextDialog.getString(R.string.vessel_shield),contextDialog.getString(R.string.vessel_shield_des),"65","20","25","20","40","70","25","70","25","60","45","7.0","20","17","","")
         contextDialog.getString(R.string.rampart_golem_shield) -> setDataDialogShield("rampartgolemshield",contextDialog.getString(R.string.rampart_golem_shield),contextDialog.getString(R.string.rampart_golem_shield_des),"65","80","90","80","90","80","90","80","90","5","40","8.0","19","","","")
         contextDialog.getString(R.string.charred_loyce_shield) -> setDataDialogShield("charredloyceshield",contextDialog.getString(R.string.charred_loyce_shield),contextDialog.getString(R.string.charred_loyce_shield_des),"55","55","45","55","80","40","50","40","50","40","50","5.0","12","16","","")
         contextDialog.getString(R.string.reeves_greatshield) -> setDataDialogShield("reevesgreatshield",contextDialog.getString(R.string.reeves_greatshield),contextDialog.getString(R.string.reeves_greatshield_des),"100","60","30","60","55","80","55","55","65","90","70","16.0","33","","","")
         contextDialog.getString(R.string.pursuers_greatshield) -> setDataDialogShield("pursuersgreatshield",contextDialog.getString(R.string.pursuers_greatshield),contextDialog.getString(R.string.pursuers_greatshield_des),"100","65","50","65","80","65","40","65","60","80","70","16.0","38","","","")
         contextDialog.getString(R.string.pates_shield) -> setDataDialogShield("patesshield",contextDialog.getString(R.string.pates_shield),contextDialog.getString(R.string.pates_shield_des),"95","75","45","75","45","70","45","70","55","70","65","10.5","25","","","")
         contextDialog.getString(R.string.ormas_greatshield) -> setDataDialogShield("ormasgreatshield",contextDialog.getString(R.string.ormas_greatshield),contextDialog.getString(R.string.ormas_greatshield_des),"100","60","30","60","55","80","55","55","65","90","70","16.0","33","","","")
         contextDialog.getString(R.string.mastodon_greatshield) -> setDataDialogShield("mastodongreatshield",contextDialog.getString(R.string.mastodon_greatshield),contextDialog.getString(R.string.mastodon_greatshield_des),"90","50","65","50","65","50","90","50","65","65","65","14.0","30","","","")
         contextDialog.getString(R.string.kings_mirror) -> setDataDialogShield("kingsmirror",contextDialog.getString(R.string.kings_mirror),contextDialog.getString(R.string.kings_mirror_des),"95","35","75","35","70","35","70","35","70","80","65","14.5","35","","","")
         contextDialog.getString(R.string.havels_greatshield) -> setDataDialogShield("havelsgreatshield",contextDialog.getString(R.string.havels_greatshield),contextDialog.getString(R.string.havels_greatshield_des),"100","70","90","70","80","90","80","70","75","120","75","20.0","45","","","")
         contextDialog.getString(R.string.gyrm_greatshield) -> setDataDialogShield("gyrmgreatshield",contextDialog.getString(R.string.gyrm_greatshield),contextDialog.getString(R.string.gyrm_greatshield_des),"100","30","30","30","100","30","30","30","30","100","75","15.0","32","","","")
         contextDialog.getString(R.string.greatshield_of_glory) -> setDataDialogShield("greatshieldofglory",contextDialog.getString(R.string.greatshield_of_glory),contextDialog.getString(R.string.greatshield_of_glory_des),"100","60","40","60","90","60","50","60","60","80","65","15.0","35","","","")
         contextDialog.getString(R.string.dragonrider_greatshield) -> setDataDialogShield("dragonridergreatshield",contextDialog.getString(R.string.dragonrider_greatshield),contextDialog.getString(R.string.dragonrider_greatshield_des),"100","55","60","55","75","20","75","20","50","100","70","13.5","35","","","")
         contextDialog.getString(R.string.ring_of_whispers) -> setDataDialogObjects("ringofwhispers",contextDialog.getString(R.string.ring_of_whispers),contextDialog.getString(R.string.ring_of_whispers_des))
         contextDialog.getString(R.string.nameengraved_ring) -> setDataDialogObjects("nameengravedring",contextDialog.getString(R.string.nameengraved_ring),contextDialog.getString(R.string.nameengraved_ring_des))
         contextDialog.getString(R.string.redeye_ring) -> setDataDialogObjects("redeyering",contextDialog.getString(R.string.redeye_ring),contextDialog.getString(R.string.redeye_ring_des))
         contextDialog.getString(R.string.silvercat_ring) -> setDataDialogObjects("silvercatring",contextDialog.getString(R.string.silvercat_ring),contextDialog.getString(R.string.silvercat_ring_des))
         contextDialog.getString(R.string.wood_arrow) -> setDataDialogObjects("woodarrow",contextDialog.getString(R.string.wood_arrow),contextDialog.getString(R.string.wood_arrow_des))
         contextDialog.getString(R.string.spear) -> setDataDialogWeapon("spear",contextDialog.getString(R.string.spear),contextDialog.getString(R.string.spear_des),"210","130","","20","","25","","50","","3.5","9","12","","")
         contextDialog.getString(R.string.battle_axe) -> setDataDialogWeapon("battleaxe",contextDialog.getString(R.string.battle_axe),contextDialog.getString(R.string.battle_axe_des),"280","120","","30","","30","","60","","4.0","15","5","","")
         contextDialog.getString(R.string.rapier) -> setDataDialogWeapon("rapier",contextDialog.getString(R.string.rapier),contextDialog.getString(R.string.rapier_des),"230","140","","10","","20","","45","","1.5","5","12","","")
         contextDialog.getString(R.string.alonne_greatbow) -> setDataDialogWeapon("alonnegreatbow",contextDialog.getString(R.string.alonne_greatbow),contextDialog.getString(R.string.alonne_greatbow_des),"260","100","","15","","10","","70","","8.0","20","25","","")
         contextDialog.getString(R.string.caestus) -> setDataDialogWeapon("caestus",contextDialog.getString(R.string.caestus),contextDialog.getString(R.string.caestus_des),"45","130","","15","","5","","60","","0.5","10","7","","")
         contextDialog.getString(R.string.blacksmiths_hammer) -> setDataDialogWeapon("blacksmithshammer",contextDialog.getString(R.string.blacksmiths_hammer),contextDialog.getString(R.string.blacksmiths_hammer_des),"145","100","","40","","20","","60","","5.0","15","17","","")
         contextDialog.getString(R.string.aged_feather) -> setDataDialogObjects("agedfeather",contextDialog.getString(R.string.aged_feather),contextDialog.getString(R.string.aged_feather_des))
         contextDialog.getString(R.string.demons_great_hammer) -> setDataDialogWeapon("demonsgreathammer",contextDialog.getString(R.string.demons_great_hammer),contextDialog.getString(R.string.demons_great_hammer_des),"450","100","","60","","30","","70","","26.0","50","8","","")
         contextDialog.getString(R.string.handmaids_ladle) -> setDataDialogWeapon("handmaidsladle",contextDialog.getString(R.string.handmaids_ladle),contextDialog.getString(R.string.handmaids_ladle_des),"40","130","","10","","10","","10","",".2","6","5","","")
         contextDialog.getString(R.string.yellow_quartz_shield) -> setDataDialogShield("yellowquartzshield",contextDialog.getString(R.string.yellow_quartz_shield),contextDialog.getString(R.string.yellow_quartz_shield_des),"80","30","35","30","40","30","40","30","25","60","55","3.0","12","","","")
         contextDialog.getString(R.string.wooden_shield) -> setDataDialogShield("woodenshieldframe",contextDialog.getString(R.string.wooden_shield),contextDialog.getString(R.string.wooden_shield_des),"80","35","15","35","15","35","15","35","5","60","40","1.5","7","","","")
         contextDialog.getString(R.string.stone_parma) -> setDataDialogShield("stoneparma",contextDialog.getString(R.string.stone_parma),contextDialog.getString(R.string.stone_parma_des),"100","55","20","55","20","85","20","55","45","80","55","5.0","18","","","")
         contextDialog.getString(R.string.spirit_tree_shield) -> setDataDialogShield("spirittreeshield",contextDialog.getString(R.string.spirit_tree_shield),contextDialog.getString(R.string.spirit_tree_shield_des),"60","45","65","45","55","45","55","45","45","60","50","5.0","10","","","")
         contextDialog.getString(R.string.slumbering_dragon_shield) -> setDataDialogShield("slumberingdragonshield",contextDialog.getString(R.string.slumbering_dragon_shield),contextDialog.getString(R.string.slumbering_dragon_shield_des),"65","65","60","65","60","65","90","85","60","60","45","4.5","14","","","")
         contextDialog.getString(R.string.silverblack_shield) -> setDataDialogShield("silverblackshield",contextDialog.getString(R.string.silverblack_shield),contextDialog.getString(R.string.silverblack_shield_des),"80","40","80","40","70","40","70","40","85","70","45","5.5","16","","","")
         contextDialog.getString(R.string.silver_eagle_kite_shield) -> setDataDialogShield("silvereaglekiteshield",contextDialog.getString(R.string.silver_eagle_kite_shield),contextDialog.getString(R.string.silver_eagle_kite_shield_des),"90","45","30","45","60","45","50","45","30","80","50","3.0","10","","","")
         contextDialog.getString(R.string.shield_of_the_insolent) -> setDataDialogShield("shieldoftheinsolent",contextDialog.getString(R.string.shield_of_the_insolent),contextDialog.getString(R.string.shield_of_the_insolent_des),"55","35","40","35","40","35","40","35","75","40","45","6.0","10","","","")
         contextDialog.getString(R.string.royal_kite_shield) -> setDataDialogShield("royalkiteshield",contextDialog.getString(R.string.royal_kite_shield),contextDialog.getString(R.string.royal_kite_shield_des),"100","45","45","45","65","45","50","45","40","60","50","4.0","12","","","")
         contextDialog.getString(R.string.red_rust_shield) -> setDataDialogShield("redrustshield",contextDialog.getString(R.string.red_rust_shield),contextDialog.getString(R.string.red_rust_shield_des),"100","70","10","70","10","10","10","10","10","70","55","5.0","17","","","")
         contextDialog.getString(R.string.porcine_shield) -> setDataDialogShield("porcineshield",contextDialog.getString(R.string.porcine_shield),contextDialog.getString(R.string.porcine_shield_des),"65","30","40","30","65","30","40","30","40","20","40","4.0","9","","","")
         contextDialog.getString(R.string.old_knights_shield) -> setDataDialogShield("oldknightsshield",contextDialog.getString(R.string.old_knights_shield),contextDialog.getString(R.string.old_knights_shield_des),"100","0","70","0","70","0","70","0","40","20","60","8.0","24","","","")
         contextDialog.getString(R.string.moon_butterfly_shield) -> setDataDialogShield("moonbutterflyshield",contextDialog.getString(R.string.moon_butterfly_shield),contextDialog.getString(R.string.moon_butterfly_shield_des),"20","90","15","15","15","15","15","15","15","50","35","1.0","6","","","")
         contextDialog.getString(R.string.loyce_shield) -> setDataDialogShield("loyceshield",contextDialog.getString(R.string.loyce_shield),contextDialog.getString(R.string.loyce_shield_des),"60","55","80","55","45","40","50","40","50","60","50","4.5","12","15","","")
         contextDialog.getString(R.string.lion_clan_shield) -> setDataDialogShield("lionclanshield",contextDialog.getString(R.string.lion_clan_shield),contextDialog.getString(R.string.lion_clan_shield_des),"90","30","45","30","20","30","45","30","35","70","45","2.5","7","","","")
         contextDialog.getString(R.string.kings_shield) -> setDataDialogShield("kingsshield",contextDialog.getString(R.string.kings_shield),contextDialog.getString(R.string.kings_shield_des),"100","60","60","60","85","60","65","60","45","80","55","5.0","16","","","")
         contextDialog.getString(R.string.homunculus_wooden_shield) -> setDataDialogShield("homunculuswoodenshield",contextDialog.getString(R.string.homunculus_wooden_shield),contextDialog.getString(R.string.homunculus_wooden_shield_des),"85","35","65","35","30","35","65","35","45","70","45","3.5","8","","","")
         contextDialog.getString(R.string.hollow_soldier_shield) -> setDataDialogShield("hollowsoldiershield",contextDialog.getString(R.string.hollow_soldier_shield),contextDialog.getString(R.string.hollow_soldier_shield_des),"80","20","15","20","15","20","15","20","5","40","35","3.0","8","","","")
         contextDialog.getString(R.string.grand_spirit_tree_shield) -> setDataDialogShield("grandspirittreeshield",contextDialog.getString(R.string.grand_spirit_tree_shield),contextDialog.getString(R.string.grands_pirit_tree_shield_des),"60","45","65","45","60","45","80","45","70","70","45","5.5","10","","","")
         contextDialog.getString(R.string.golden_wing_shield) -> setDataDialogShield("goldenwingshield",contextDialog.getString(R.string.golden_wing_shield),contextDialog.getString(R.string.golden_wing_shield_des),"60","45","80","45","60","45","60","45","55","70","55","5.5","12","","","")
         contextDialog.getString(R.string.drangleic_shield) -> setDataDialogShield("drangleicshield",contextDialog.getString(R.string.drangleic_shield),contextDialog.getString(R.string.drangleic_shield_des),"100","25","70","25","55","25","55","25","35","70","55","6.0","16","","","")
         contextDialog.getString(R.string.drakekeepers_shield) -> setDataDialogShield("drakekeepersshield",contextDialog.getString(R.string.drakekeepers_shield),contextDialog.getString(R.string.drakekeepers_shield_des),"100","65","65","65","65","65","65","65","45","110","55","7.0","17","","","")
         contextDialog.getString(R.string.defenders_shield) -> setDataDialogShield("defendersshield",contextDialog.getString(R.string.defenders_shield),contextDialog.getString(R.string.defenders_shield_des),"100","40","70","40","60","40","65","40","50","70","60","5.0","15","","","")
         contextDialog.getString(R.string.chaos_shield) -> setDataDialogShield("chaosshield",contextDialog.getString(R.string.chaos_shield),contextDialog.getString(R.string.chaos_shield_des),"45","65","60","65","60","65","60","65","85","60","45","4.5","10","","","")
         contextDialog.getString(R.string.bound_wooden_shield) -> setDataDialogShield("boundwoodenshield",contextDialog.getString(R.string.bound_wooden_shield),contextDialog.getString(R.string.bound_woodenshield_des),"90","35","20","75","30","45","65","45","40","60","40","3.0","11","","","")
         contextDialog.getString(R.string.bone_shield) -> setDataDialogShield("boneshield",contextDialog.getString(R.string.bone_shield),contextDialog.getString(R.string.bone_shield_des),"50","30","50","70","20","70","20","70","70","30","90","6.0","8","8","","")
         contextDialog.getString(R.string.black_flamestone_parma) -> setDataDialogShield("blackflamestoneparma",contextDialog.getString(R.string.black_flamestone_parma),contextDialog.getString(R.string.black_flamestone_parma_des),"85","30","45","25","25","65","45","25","45","40","45","2.5","8","10","","")
         contextDialog.getString(R.string.black_dragon_shield) -> setDataDialogShield("blackdragonshield",contextDialog.getString(R.string.black_dragon_shield),contextDialog.getString(R.string.black_dragon_shield_des),"100","55","60","55","60","55","60","55","60","70","51","5.5","15","","","")
         contextDialog.getString(R.string.bell_keeper_shield) -> setDataDialogShield("bellkeepershield",contextDialog.getString(R.string.bell_keeper_shield),contextDialog.getString(R.string.bell_keeper_shield_des),"60","20","85","20","20","20","20","20","20","50","45","2.0","7","","","")
         contextDialog.getString(R.string.watchers_shield) -> setDataDialogShield("watchersshield",contextDialog.getString(R.string.watchers_shield),contextDialog.getString(R.string.watchers_shield_des),"95","40","65","40","65","50","90","50","80","70","40","3.0","8","11","","")
         contextDialog.getString(R.string.varangian_shield) -> setDataDialogShield("varangianshield",contextDialog.getString(R.string.varangian_shield),contextDialog.getString(R.string.varangian_shield_des),"80","60","40","60","40","60","40","60","20","70","40","3.0","9","11","","")
         contextDialog.getString(R.string.transgressors_leather_shield) -> setDataDialogShield("transgressorsleathershield",contextDialog.getString(R.string.transgressors_leather_shield),contextDialog.getString(R.string.transgressors_leather_shield_des),"75","50","35","40","50","40","60","40","90","70","45","3.0","7","","","")
         contextDialog.getString(R.string.sunlight_parma) -> setDataDialogShield("sunlightparma",contextDialog.getString(R.string.sunlight_parma),contextDialog.getString(R.string.sunlight_parma_des),"65","70","45","70","30","70","45","70","40","50","35","1.5","7","11","","")
         contextDialog.getString(R.string.manikin_shield) -> setDataDialogShield("manikinshield",contextDialog.getString(R.string.manikin_shield),contextDialog.getString(R.string.manikin_shield_des),"85","65","35","65","35","65","35","65","35","40","40","1.5","9","12","","")
         contextDialog.getString(R.string.magic_shield) -> setDataDialogShield("magicshield",contextDialog.getString(R.string.magic_shield),contextDialog.getString(R.string.magic_shield_des),"75","10","95","10","70","10","70","10","70","60","25","2.0","8","14","","")
         contextDialog.getString(R.string.llewellyn_shield) -> setDataDialogShield("llewellynshield",contextDialog.getString(R.string.llewellyn_shield),contextDialog.getString(R.string.llewelyn_shield_des),"90","50","75","50","70","45","70","45","70","60","45","2.5","9","7","","")
         contextDialog.getString(R.string.iron_parma) -> setDataDialogShield("ironparma",contextDialog.getString(R.string.iron_parma),contextDialog.getString(R.string.iron_parma_des),"85","30","30","30","65","30","65","30","50","80","45","3.0","10","","","")
         contextDialog.getString(R.string.golden_falcon_shield) -> setDataDialogShield("goldenfalconshield",contextDialog.getString(R.string.golden_falcon_shield),contextDialog.getString(R.string.golden_falcon_shield_des),"80","20","65","20","65","20","65","20","65","50","35","2.0","7","10","","")
         contextDialog.getString(R.string.cursed_bone_shield) -> setDataDialogShield("cursedboneshield",contextDialog.getString(R.string.cursed_bone_shield),contextDialog.getString(R.string.cursed_bone_shield_des),"85","30","70","30","85","60","70","60","70","70","30","3.0","12","12","","")
         contextDialog.getString(R.string.benharts_parma) -> setDataDialogShield("benhartsparma",contextDialog.getString(R.string.benharts_parma),contextDialog.getString(R.string.benharts_parma_des),"80","50","80","50","40","50","50","50","50","60","40","2.0","7","","","")
         contextDialog.getString(R.string.sanctum_shield) -> setDataDialogShield("sanctumshield",contextDialog.getString(R.string.sanctum_shield),contextDialog.getString(R.string.sanctum_shield_des),"85","30","70","30","85","60","70","60","70","30","40","2.0","6","7","18","18")
         contextDialog.getString(R.string.twin_dragon_greatshield) -> setDataDialogShield("twindragongreatshield",contextDialog.getString(R.string.twin_dragon_greatshield),contextDialog.getString(R.string.twin_dragon_greatshield_des),"95","40","55","40","45","40","65","40","40","80","65","7","20","","","")
         contextDialog.getString(R.string.crescent_sickle) -> setDataDialogWeapon("crescentsickle",contextDialog.getString(R.string.crescent_sickle),contextDialog.getString(R.string.crescent_sickle_des),"180","110","120","15","","20","","50","","8.0","12","19","","")
         contextDialog.getString(R.string.dragonriders_halberd) -> setDataDialogWeapon("dragonridershalberd",contextDialog.getString(R.string.dragonriders_halberd),contextDialog.getString(R.string.dragonriders_halberd_des),"360","120","","35","","40","","70","","6.0","18","17","","")
         contextDialog.getString(R.string.homunculus_mace) -> setDataDialogWeapon("homunculusmace",contextDialog.getString(R.string.homunculus_mace),contextDialog.getString(R.string.homunculus_mace_des),"290","120","","25","","40","","60","","6.0","14","9","","")
         contextDialog.getString(R.string.greataxe) -> setDataDialogWeapon("greataxe",contextDialog.getString(R.string.greataxe),contextDialog.getString(R.string.greataxe_des),"390","110","","50","","40","","80","","15.0","32","10","","")
         contextDialog.getString(R.string.estoc) -> setDataDialogWeapon("estoc",contextDialog.getString(R.string.estoc),contextDialog.getString(R.string.estoc_des),"210","120","","20","","30","","45","","3.0","12","12","","")
         contextDialog.getString(R.string.murakumo) -> setDataDialogWeapon("murakumo",contextDialog.getString(R.string.murakumo),contextDialog.getString(R.string.murakumo_des),"380","100","","45","","40","","70","","12","20","20","","")
         contextDialog.getString(R.string.uchigatana) -> setDataDialogWeapon("uchigatana",contextDialog.getString(R.string.uchigatana),contextDialog.getString(R.string.uchigatana_des),"230","150","","20","","30","","40","","5","10","16","","")
         contextDialog.getString(R.string.pursuer_ultra_greatsword) -> setDataDialogWeapon("pursuersultragreatsword",contextDialog.getString(R.string.pursuer_ultra_greatsword),contextDialog.getString(R.string.pursuer_ultra_greatsword_des),"156","130","","50","","45","","60","","18","30","18","","")
         contextDialog.getString(R.string.retainers_short_sword) -> setDataDialogWeapon("retainersshortsword",contextDialog.getString(R.string.retainers_short_sword),contextDialog.getString(R.string.retainers_short_sword_des),"70","110","","10","","15","","30","","1.0","11","15","","")
         contextDialog.getString(R.string.blue_dagger) -> setDataDialogWeapon("bluedagger",contextDialog.getString(R.string.blue_dagger),contextDialog.getString(R.string.blue_dagger_des),"115","120","","10","","15","","60","","0.5","6","14","","")
         contextDialog.getString(R.string.umbral_dagger) -> setDataDialogWeapon("umbraldagger",contextDialog.getString(R.string.umbral_dagger),contextDialog.getString(R.string.umbral_dagger_des),"53","130","","10","","15","","30","","2.0","12","20","","")
         contextDialog.getString(R.string.manikin_knife) -> setDataDialogWeapon("manikinknife",contextDialog.getString(R.string.manikin_knife),contextDialog.getString(R.string.manikin_knife_des),"105","150","","10","","15","","80","","1.0","6","14","","")
         contextDialog.getString(R.string.broken_thief_sword) -> setDataDialogWeapon("brokenthiefsword",contextDialog.getString(R.string.broken_thief_sword),contextDialog.getString(R.string.broken_thief_sword_des),"120","150","","20","","5","","30","","1.0","9","5","","")
         contextDialog.getString(R.string.thief_dagger) -> setDataDialogWeapon("thiefdagger",contextDialog.getString(R.string.thief_dagger),contextDialog.getString(R.string.thief_dagger_des),"158","110","","10","","15","","30","","0.5","2","7","","")
         contextDialog.getString(R.string.shadow_dagger) -> setDataDialogWeapon("shadowdagger", contextDialog.getString(R.string.shadow_dagger),contextDialog.getString(R.string.shadow_dagger_des),"120","150","","10","","20","","60","","1.5","4","16","","")
         contextDialog.getString(R.string.mythas_bent_blade) -> setDataDialogWeapon("mythasbentblade",contextDialog.getString(R.string.mythas_bent_blade),contextDialog.getString(R.string.mythas_bent_blade_des),"100","150","","10","","15","","40","","0.5","5","20","","")
         contextDialog.getString(R.string.black_flamestone_dagger) -> setDataDialogWeapon("blackflamestonedagger",contextDialog.getString(R.string.black_flamestone_dagger),contextDialog.getString(R.string.black_flamestone_dagger_des),"140","130","","10","","15","","50","","4.0","10","12","","")
         contextDialog.getString(R.string.royal_dirk) -> setDataDialogWeapon("royaldirk",contextDialog.getString(R.string.royal_dirk),contextDialog.getString(R.string.royal_dirk_des),"150","140","","10","","15","","90","","2.0","11","15","","")
         contextDialog.getString(R.string.soul_of_nashandra) -> setDataDialogObjects("soulofnashandra",contextDialog.getString(R.string.soul_of_nashandra),contextDialog.getString(R.string.soul_of_nashandra_des))
         contextDialog.getString(R.string.throne_defender_soul) -> setDataDialogObjects("defendersoul",contextDialog.getString(R.string.throne_defender_soul),contextDialog.getString(R.string.throne_defender_soul_des))
         contextDialog.getString(R.string.throne_watcher_soul) -> setDataDialogObjects("defendersoul",contextDialog.getString(R.string.throne_watcher_soul),contextDialog.getString(R.string.throne_watcher_soul_des))
         contextDialog.getString(R.string.giants_kinship) -> setDataDialogObjects("giantskinship",contextDialog.getString(R.string.giants_kinship),contextDialog.getString(R.string.giants_kinship_des))
         contextDialog.getString(R.string.old_paledrake_soul) -> setDataDialogObjects("oldsoul",contextDialog.getString(R.string.old_paledrake_soul),contextDialog.getString(R.string.old_paledrake_soul_des))
         contextDialog.getString(R.string.soul_of_the_dukes_dear_freja) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.soul_of_the_dukes_dear_freja),contextDialog.getString(R.string.soul_of_the_dukes_dear_freja_des))
         contextDialog.getString(R.string.soul_of_velstadt) -> setDataDialogObjects("defendersoul",contextDialog.getString(R.string.soul_of_velstadt),contextDialog.getString(R.string.soul_of_velstadt_des))
         contextDialog.getString(R.string.demon_of_song_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.demon_of_song_soul),contextDialog.getString(R.string.demon_of_song_soul_des))
         contextDialog.getString(R.string.looking_glass_knight_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.looking_glass_knight_soul),contextDialog.getString(R.string.looking_glass_knight_soul_des))
         contextDialog.getString(R.string.guardian_dragon_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.guardian_dragon_soul),contextDialog.getString(R.string.guardian_dragon_soul_des))
         contextDialog.getString(R.string.royal_rat_authority_suol) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.royal_rat_authority_suol),contextDialog.getString(R.string.royal_rat_authority_suol_des))
         contextDialog.getString(R.string.scorpioness_najka_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.scorpioness_najka_soul),contextDialog.getString(R.string.scorpioness_najka_soul_des))
         contextDialog.getString(R.string.old_dead_ones_soul) -> setDataDialogObjects("oldsoul",contextDialog.getString(R.string.old_dead_ones_soul),contextDialog.getString(R.string.old_dead_ones_soul_des))
         contextDialog.getString(R.string.soul_of_the_rotten) -> setDataDialogObjects("souloftheking",contextDialog.getString(R.string.soul_of_the_rotten),contextDialog.getString(R.string.soul_of_the_rotten_des))
         contextDialog.getString(R.string.royal_rat_vanguard_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.royal_rat_vanguard_soul),contextDialog.getString(R.string.royal_rat_vanguard_soul_des))
         contextDialog.getString(R.string.old_king_soul) -> setDataDialogObjects("oldsoul",contextDialog.getString(R.string.old_king_soul),contextDialog.getString(R.string.old_king_soul_des))
         contextDialog.getString(R.string.old_iron_king_soul) -> setDataDialogObjects("souloftheking",contextDialog.getString(R.string.old_iron_king_soul),contextDialog.getString(R.string.old_iron_king_soul_des))
         contextDialog.getString(R.string.smelter_demon_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.smelter_demon_soul),contextDialog.getString(R.string.smelter_demon_soul_des))
         contextDialog.getString(R.string.mytha_the_baneful_queen_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.mytha_the_baneful_queen_soul),contextDialog.getString(R.string.mytha_the_baneful_queen_soul_des))
         contextDialog.getString(R.string.covetous_demon_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.covetous_demon_soul),contextDialog.getString(R.string.covetous_demon_soul_des))
         contextDialog.getString(R.string.executioners_chariot_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.executioners_chariot_soul),contextDialog.getString(R.string.executioners_chariot_soul_des))
         contextDialog.getString(R.string.skeleton_lords_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.skeleton_lords_soul),contextDialog.getString(R.string.skeleton_lords_soul_des))
         contextDialog.getString(R.string.ruin_sentinels_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.ruin_sentinels_soul),contextDialog.getString(R.string.ruin_sentinels_soul_des))
         contextDialog.getString(R.string.old_witch_soul) -> setDataDialogObjects("oldsoul",contextDialog.getString(R.string.old_witch_soul),contextDialog.getString(R.string.old_witch_soul_des))
         contextDialog.getString(R.string.soul_of_the_lost_sinner) -> setDataDialogObjects("souloftheking",contextDialog.getString(R.string.soul_of_the_lost_sinner),contextDialog.getString(R.string.soul_of_the_lost_sinner_des))
         contextDialog.getString(R.string.belfry_gargoyles_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.belfry_gargoyles_soul),contextDialog.getString(R.string.belfry_gargoyles_soul_des))
         contextDialog.getString(R.string.awestone) -> setDataDialogObjects("awestone",contextDialog.getString(R.string.awestone),contextDialog.getString(R.string.awestone_des))
         contextDialog.getString(R.string.flexile_sentry_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.flexile_sentry_soul),contextDialog.getString(R.string.flexile_sentry_soul_des))
         contextDialog.getString(R.string.old_leo_ring) -> setDataDialogObjects("oldleoring",contextDialog.getString(R.string.old_leo_ring),contextDialog.getString(R.string.old_leo_ring_des))
         contextDialog.getString(R.string.dragonrider_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.dragonrider_soul),contextDialog.getString(R.string.dragonrider_soul_des))
         contextDialog.getString(R.string.soul_of_the_last_giant) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.soul_of_the_last_giant),contextDialog.getString(R.string.soul_of_the_last_giant_des))
         contextDialog.getString(R.string.old_dragonslayer_soul) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.old_dragonslayer_soul),contextDialog.getString(R.string.old_dragonslayer_soul_des))
         contextDialog.getString(R.string.ring_of_blades) -> setDataDialogObjects("ringofblades",contextDialog.getString(R.string.ring_of_blades),contextDialog.getString(R.string.ring_of_blades_des))
         contextDialog.getString(R.string.soul_of_the_pursuer) -> setDataDialogObjects("bosssoul",contextDialog.getString(R.string.soul_of_the_pursuer),contextDialog.getString(R.string.soul_of_the_pursuer_des))
         contextDialog.getString(R.string.third_dragon_ring) -> setDataDialogObjects("thirddragonring", contextDialog.getString(R.string.third_dragon_ring),contextDialog.getString(R.string.third_dragon_ring_des))
         contextDialog.getString(R.string.black_dragon_greataxe)-> setDataDialogWeapon("blackdragongreataxe",contextDialog.getString(R.string.black_dragon_greataxe),contextDialog.getString(R.string.black_dragon_greataxe_des),"410","110","", "45","","40","","70","60","12","35","15","","")
         contextDialog.getString(R.string.drakekeepers_greatshield)-> setDataDialogShield("drakekeepersgreatshield",contextDialog.getString(R.string.drakekeepers_greatshield),contextDialog.getString(R.string.drakekeepers_greatshield_des),"100","70","70", "70","75","70","75","70","60","90","65","16.5","37","","","")
         contextDialog.getString(R.string.drakekeppers_great_axe)-> setDataDialogWeapon("drakekeppersgreataxe",contextDialog.getString(R.string.drakekeppers_great_axe),contextDialog.getString(R.string.drakekeppers_great_axe_des),"380","110","", "50","","40","","90","","16","40","14","","")
         contextDialog.getString(R.string.ashen_mist_heart)-> setDataDialogObjects("ashenmistheart",contextDialog.getString(R.string.ashen_mist_heart),contextDialog.getString(R.string.ashen_mist_heart_des))
         contextDialog.getString(R.string.petrified_egg)-> setDataDialogObjects("petrifiedegg",contextDialog.getString(R.string.petrified_egg),contextDialog.getString(R.string.petrified_egg_des))
         contextDialog.getString(R.string.crystal_magic_weapon)-> setDataDialogMagics("crystalmagicweapon",contextDialog.getString(R.string.crystal_magic_weapon),contextDialog.getString(R.string.crystal_magic_weapon_des),"28","")
         contextDialog.getString(R.string.dragon_tooth)-> setDataDialogWeapon("dragontooth",contextDialog.getString(R.string.dragon_tooth),contextDialog.getString(R.string.dragon_tooth_des),"470","100","", "60","","30","","70","","20","50","10","","")
         contextDialog.getString(R.string.boltstone)-> setDataDialogObjects("boltstone",contextDialog.getString(R.string.boltstone),contextDialog.getString(R.string.boltstone_des))
         contextDialog.getString(R.string.malformed_skull)-> setDataDialogWeapon("malformedskull",contextDialog.getString(R.string.malformed_skull),contextDialog.getString(R.string.malformed_skull_des),"520","100","", "60","","30","","20","","12","35","7","","")
         contextDialog.getString(R.string.malformed_shell)-> setDataDialogWeapon("malformedshell",contextDialog.getString(R.string.malformed_shell),contextDialog.getString(R.string.malformed_shell_des),"430","100","", "60","","30","","50","","18","35","8","","")
         contextDialog.getString(R.string.soul_geyser)-> setDataDialogMagics("soulgeyser",contextDialog.getString(R.string.soul_geyser),contextDialog.getString(R.string.soul_geyser_des),"64","")
         contextDialog.getString(R.string.aldia_key)-> setDataDialogObjects("aldiakey",contextDialog.getString(R.string.aldia_key),contextDialog.getString(R.string.aldia_key_des))
         contextDialog.getString(R.string.great_magic_barrier)-> setDataDialogMagics("greatmagicbarrier",contextDialog.getString(R.string.great_magic_barrier),contextDialog.getString(R.string.great_magic_barrier_des),"","28")
         contextDialog.getString(R.string.mace_of_the_insolent)-> setDataDialogWeapon("maceoftheinsolent",contextDialog.getString(R.string.mace_of_the_insolent),contextDialog.getString(R.string.mace_of_the_insolent_des),"100","120","", "25","","20","90","60","160","4.0","15","10","","")
         contextDialog.getString(R.string.olenfords_staff)-> setDataDialogWeapon("olenfordsstaff",contextDialog.getString(R.string.olenfords_staff),contextDialog.getString(R.string.olenfords_staff_des),"","100","210","10","", "15","","30","250","20","","","40","")
         contextDialog.getString(R.string.great_lightning_spears)-> setDataDialogMagics("greatlightningspear",contextDialog.getString(R.string.great_lightning_spears),contextDialog.getString(R.string.great_lightning_spears_des),"","42")
         contextDialog.getString(R.string.avelyn)-> setDataDialogWeapon("avelyn",contextDialog.getString(R.string.avelyn),contextDialog.getString(R.string.avelyn_des),"170","100","", "10","","10","","40","","6.0","25","15","","")
         contextDialog.getString(R.string.darknight_stone)-> setDataDialogObjects("darknightstone",contextDialog.getString(R.string.darknight_stone),contextDialog.getString(R.string.darknight_stone_des))
         contextDialog.getString(R.string.magic_stone)-> setDataDialogObjects("magicstone",contextDialog.getString(R.string.magic_stone),contextDialog.getString(R.string.magic_stone_des))
         contextDialog.getString(R.string.human_effigy)-> setDataDialogObjects("humaneffigy",contextDialog.getString(R.string.human_effigy),contextDialog.getString(R.string.human_effigy_des))
         contextDialog.getString(R.string.estus_flask_shard) -> setDataDialogObjects("estusflaskshard",contextDialog.getString(R.string.estus_flask_shard),contextDialog.getString(R.string.estus_flask_shard_des))
         contextDialog.getString(R.string.amber_herb) -> setDataDialogObjects("amberherb", contextDialog.getString(R.string.amber_herb),contextDialog.getString(R.string.amber_herb_des))
         contextDialog.getString(R.string.cracked_red_eye_orb) -> setDataDialogObjects("crackedredeyeorb", contextDialog.getString(R.string.cracked_red_eye_orb),contextDialog.getString(R.string.cracked_red_eye_orb_des))
         contextDialog.getString(R.string.life_gem) -> setDataDialogObjects("lifegem",contextDialog.getString(R.string.life_gem),contextDialog.getString(R.string.life_gem_des))
         contextDialog.getString(R.string.rusted_coin) -> setDataDialogObjects("rustedcoin",contextDialog.getString(R.string.rusted_coin),contextDialog.getString(R.string.rusted_coin_des))
         contextDialog.getString(R.string.small_smooth_silky_stone) -> setDataDialogObjects("smallsmoothandsilkystone",contextDialog.getString(R.string.small_smooth_silky_stone),contextDialog.getString(R.string.small_smooth_silky_stone_des))
         contextDialog.getString(R.string.soul_of_a_lost_undead) -> setDataDialogObjects("soulofalostundead",contextDialog.getString(R.string.soul_of_a_lost_undead),contextDialog.getString(R.string.soul_of_a_lost_undead_des)+" X200")
         contextDialog.getString(R.string.soul_of_a_name_less_soldier) -> setDataDialogObjects("soulofanamelesssoldier", contextDialog.getString(R.string.soul_of_a_name_less_soldier),contextDialog.getString(R.string.soul_of_a_name_less_soldier_des)+" X800")
         contextDialog.getString(R.string.torch) -> setDataDialogObjects("torch",contextDialog.getString(R.string.torch),contextDialog.getString(R.string.torch_des))
         contextDialog.getString(R.string.petrified_something) -> setDataDialogObjects("petrifiedsomething",contextDialog.getString(R.string.petrified_something),contextDialog.getString(R.string.petrified_something_des))
         contextDialog.getString(R.string.gold_pine_resin) -> setDataDialogObjects("goldpineresin",contextDialog.getString(R.string.gold_pine_resin),contextDialog.getString(R.string.gold_pine_resin_des))
         contextDialog.getString(R.string.stone_ring) -> setDataDialogObjects("stonering",contextDialog.getString(R.string.stone_ring),contextDialog.getString(R.string.stone_ring_des))
         contextDialog.getString(R.string.dagger) -> setDataDialogWeapon("dagger",contextDialog.getString(R.string.dagger),contextDialog.getString(R.string.dagger_des),"115","150","", "10","","15","","60","","0.5","2","15","","")
         contextDialog.getString(R.string.estus_flask) -> setDataDialogObjects("estusflask",contextDialog.getString(R.string.estus_flask),contextDialog.getString(R.string.estus_flask_des))
         contextDialog.getString(R.string.titanite_shard) -> setDataDialogObjects("titaniteshard",contextDialog.getString(R.string.titanite_shard),contextDialog.getString(R.string.titanite_shard_des))
         contextDialog.getString(R.string.divine_blessing) -> setDataDialogObjects("divineblessing",contextDialog.getString(R.string.divine_blessing),contextDialog.getString(R.string.divine_blessing_des))
         contextDialog.getString(R.string.homeward_bone) -> setDataDialogObjects("homewardbone",contextDialog.getString(R.string.homeward_bone),contextDialog.getString(R.string.homeward_bone_des))
         contextDialog.getString(R.string.lloyds_talisman) -> setDataDialogObjects("lloydstalisman",contextDialog.getString(R.string.lloyds_talisman),contextDialog.getString(R.string.lloyds_talisman_des))
         contextDialog.getString(R.string.soul_vessel) -> setDataDialogObjects("soulvessel",contextDialog.getString(R.string.soul_vessel),contextDialog.getString(R.string.soul_vessel_des))
         contextDialog.getString(R.string.pharros_lockstone) -> setDataDialogObjects("pharroslockstone",contextDialog.getString(R.string.pharros_lockstone),contextDialog.getString(R.string.pharros_lockstone_des))
         contextDialog.getString(R.string.radiant_life_gem) -> setDataDialogObjects("radiantlifegem",contextDialog.getString(R.string.radiant_life_gem),contextDialog.getString(R.string.radiant_life_gem_des))
         contextDialog.getString(R.string.poison_moss) -> setDataDialogObjects("poisonmoss",contextDialog.getString(R.string.poison_moss),contextDialog.getString(R.string.poison_moss_des))
         contextDialog.getString(R.string.clerics_sacred_chime) -> setDataDialogWeapon("clericssacredchime",contextDialog.getString(R.string.clerics_sacred_chime),contextDialog.getString(R.string.clerics_sacred_chime_des),"","100", "","5","","5","180","30","160","0.5","","","","10")
         contextDialog.getString(R.string.crimson_parma) -> setDataDialogShield("crimsonparma",contextDialog.getString(R.string.crimson_parma),contextDialog.getString(R.string.crimson_parma_des),"70","30","40","25","20","25", "45","25","45","40","35","1.0","6","","","")
         contextDialog.getString(R.string.ring_of_the_evil_eye) -> setDataDialogObjects("ringoftheevileye",contextDialog.getString(R.string.ring_of_the_evil_eye),contextDialog.getString(R.string.ring_of_the_evil_eye_des))
         contextDialog.getString(R.string.morning_star) -> setDataDialogWeapon("morningstar",contextDialog.getString(R.string.morning_star),contextDialog.getString(R.string.morning_star_des),"220","120", "","30","","40","","60","","4.0","15","7","","")
         contextDialog.getString(R.string.binoculars) -> setDataDialogObjects("binoculars",contextDialog.getString(R.string.binoculars),contextDialog.getString(R.string.binoculars_des))
         contextDialog.getString(R.string.short_bow) -> setDataDialogWeapon("shortbow",contextDialog.getString(R.string.short_bow),contextDialog.getString(R.string.short_bow_des),"130","100", "","5","","10","","60","","1.0","7","12","","")
         contextDialog.getString(R.string.broken_thief_sword) -> setDataDialogWeapon("brokenstraightsword",contextDialog.getString(R.string.broken_thief_sword),contextDialog.getString(R.string.broken_straigh_sword_des),"120","150", "","20","","5","","30","","1.0","9","5","","")
         contextDialog.getString(R.string.ring_of_the_steel_protection) -> setDataDialogObjects("ringofthesteelprotection",contextDialog.getString(R.string.ring_of_the_steel_protection),contextDialog.getString(R.string.ring_of_the_steel_protection_des))
         contextDialog.getString(R.string.aromatic_ooze) -> setDataDialogObjects("aromaticooze",contextDialog.getString(R.string.aromatic_ooze),contextDialog.getString(R.string.aromatic_ooze_des))
         contextDialog.getString(R.string.buckler) -> setDataDialogShield("bucklerframe",contextDialog.getString(R.string.buckler),contextDialog.getString(R.string.buckler_des),"75","50","30,","40","65","40", "50","40","50","50","50","1.5","7","13","","")
         contextDialog.getString(R.string.fire_arrow) -> setDataDialogObjects("firearrow",contextDialog.getString(R.string.fire_arrow),contextDialog.getString(R.string.fire_arrow_des))
         contextDialog.getString(R.string.firedrake_stone) -> setDataDialogObjects("firedrakestone",contextDialog.getString(R.string.firedrake_stone),contextDialog.getString(R.string.firedrake_stone_des))
         contextDialog.getString(R.string.great_soul_arrow) -> setDataDialogMagics("greatsoularrow",contextDialog.getString(R.string.great_soul_arrow),contextDialog.getString(R.string.great_soul_arrow_des),"14","")
         contextDialog.getString(R.string.green_blossom) -> setDataDialogObjects("greenblossom",contextDialog.getString(R.string.green_blossom),contextDialog.getString(R.string.green_blossom_des))
         contextDialog.getString(R.string.halberd)-> setDataDialogWeapon("halberd",contextDialog.getString(R.string.halberd),contextDialog.getString(R.string.halberd_des),"350","120","", "35","","40","","70","","6.0","20","14","","")
         contextDialog.getString(R.string.large_soul_of_a_lost_undead) -> setDataDialogObjects("largesoulofalostundead",contextDialog.getString(R.string.large_soul_of_a_lost_undead),contextDialog.getString(R.string.large_soul_of_a_lost_undead_des))
         contextDialog.getString(R.string.large_titanite_shard) -> setDataDialogObjects("largetitaniteshard",contextDialog.getString(R.string.large_titanite_shard),contextDialog.getString(R.string.large_titanite_shard_des))
         contextDialog.getString(R.string.old_radiant_life_gem) -> setDataDialogObjects("oldradiantlifegem",contextDialog.getString(R.string.old_radiant_life_gem),contextDialog.getString(R.string.old_radiant_life_gem_des))
         contextDialog.getString(R.string.repair_powder) -> setDataDialogObjects("repairpowder",contextDialog.getString(R.string.repair_powder),contextDialog.getString(R.string.repair_powder_des))
         contextDialog.getString(R.string.seed_of_a_tree_of_giants) -> setDataDialogObjects("seedofatreeofgiants",contextDialog.getString(R.string.seed_of_a_tree_of_giants),contextDialog.getString(R.string.seed_of_a_tree_of_giants_des))
         contextDialog.getString(R.string.small_white_sign_soapstone) -> setDataDialogObjects("smallwhitesignsoapstone",contextDialog.getString(R.string.small_white_sign_soapstone),contextDialog.getString(R.string.small_white_sign_soapstone_des))
         contextDialog.getString(R.string.soul_of_a_proud_knight) -> setDataDialogObjects("soulofaproudknight",contextDialog.getString(R.string.soul_of_a_proud_knight),contextDialog.getString(R.string.soul_of_a_proud_knight_des))
         contextDialog.getString(R.string.titanite_slab) -> setDataDialogObjects("titaniteslab",contextDialog.getString(R.string.titanite_slab),contextDialog.getString(R.string.titanite_slab_des))
         contextDialog.getString(R.string.titanite_chunk) -> setDataDialogObjects("titanitechunk",contextDialog.getString(R.string.titanite_chunk),contextDialog.getString(R.string.titanite_chunk_des))
         contextDialog.getString(R.string.throwing_knife) -> setDataDialogObjects("throwingknife",contextDialog.getString(R.string.throwing_knife),contextDialog.getString(R.string.throwing_knife_des))
         contextDialog.getString(R.string.twinkling_titanite) -> setDataDialogObjects("twinklingtitanite",contextDialog.getString(R.string.twinkling_titanite),contextDialog.getString(R.string.twinkling_titanite_des))
         contextDialog.getString(R.string.white_sign_soapstone) -> setDataDialogObjects("whitesignsoapstone",contextDialog.getString(R.string.white_sign_soapstone),contextDialog.getString(R.string.white_sign_soapstone_des))
         contextDialog.getString(R.string.witching_urn) -> setDataDialogObjects("witchingurn",contextDialog.getString(R.string.witching_urn),contextDialog.getString(R.string.witching_urn_des))
         contextDialog.getString(R.string.wood_bolt) -> setDataDialogObjects("woodbolt",contextDialog.getString(R.string.wood_bolt),contextDialog.getString(R.string.wood_bolt_des))
         contextDialog.getString(R.string.black_firebomb) -> setDataDialogObjects("blackfirebomb",contextDialog.getString(R.string.black_firebomb),contextDialog.getString(R.string.black_firebomb_des))
         contextDialog.getString(R.string.large_soul_of_a_proud_knight) -> setDataDialogObjects("largesoulofaproudknight",contextDialog.getString(R.string.large_soul_of_a_proud_knight),contextDialog.getString(R.string.large_soul_of_a_proud_knight_des))
         contextDialog.getString(R.string.heavy_iron_key) -> setDataDialogObjects("heavyironkey",contextDialog.getString(R.string.heavy_iron_key),contextDialog.getString(R.string.heavy_iron_key_des))
         contextDialog.getString(R.string.foot_soldier_shield) -> setDataDialogShield("footsoldiershield",contextDialog.getString(R.string.foot_soldier_shield),contextDialog.getString(R.string.foot_soldier_shield_des),"60","30", "55","25","20","25","35","25","20","40","20","1.5","6","","","")
         contextDialog.getString(R.string.grand_lance) -> setDataDialogWeapon("grandlance",contextDialog.getString(R.string.grand_lance),contextDialog.getString(R.string.grand_lance_des),"340","160", "", "35", "","15","","70","","12.0","22","18","","")
         contextDialog.getString(R.string.life_ring) -> setDataDialogObjects("lifering",contextDialog.getString(R.string.life_ring),contextDialog.getString(R.string.life_ring_des))
         contextDialog.getString(R.string.light_crossbow) -> setDataDialogWeapon("lightcrossbow",contextDialog.getString(R.string.light_crossbow),contextDialog.getString(R.string.light_crossbow_des),"250","100","","10", "","10","","60","","3.0","13","4","","")
         contextDialog.getString(R.string.mail_breker) -> setDataDialogWeapon("mailbreker",contextDialog.getString(R.string.mail_breker),contextDialog.getString(R.string.mail_breker_des),"150","140","","10", "","30","","45","","0.5","5","12","","")
         contextDialog.getString(R.string.ring_of_the_restoration) -> setDataDialogObjects("ringoftherestoration",contextDialog.getString(R.string.ring_of_the_restoration),contextDialog.getString(R.string.ring_of_the_restoration_des))
         contextDialog.getString(R.string.soldier_key) -> setDataDialogObjects("soldierkey",contextDialog.getString(R.string.soldier_key),contextDialog.getString(R.string.soldier_key_des))
         contextDialog.getString(R.string.long_sword) -> setDataDialogWeapon("longsword",contextDialog.getString(R.string.long_sword),contextDialog.getString(R.string.long_sword_des),"225","110","","20", "","20","","60","","3.0","10","9","","")
         contextDialog.getString(R.string.bastard_sword) -> setDataDialogWeapon("bastardsword",contextDialog.getString(R.string.bastard_sword),contextDialog.getString(R.string.bastard_sword_des),"280","120","","35", "","40","","60","","6.0","20","11","","")
         contextDialog.getString(R.string.blue_wooden_shield) -> setDataDialogShield("bluewoodenshield",contextDialog.getString(R.string.blue_wooden_shield),contextDialog.getString(R.string.blue_wooden_shield_des),"85","35","40","35", "30","35","65","35","40","35","35","1.0","6","","","")
         contextDialog.getString(R.string.whip) -> setDataDialogWeapon("whip",contextDialog.getString(R.string.whip),contextDialog.getString(R.string.whip_des),"210","100","","15", "","15","","50","","1.5","6","17","","")
         contextDialog.getString(R.string.rebels_greats_shield) -> setDataDialogShield("rebelsgreatshield",contextDialog.getString(R.string.rebels_greats_shield),contextDialog.getString(R.string.rebels_greats_shield_des),"70","90","90","90", "90","90","90","90","85","90","65","13.5","29","","","")
         contextDialog.getString(R.string.large_leather_shield) -> setDataDialogShield("largeleathershield",contextDialog.getString(R.string.large_leather_shield),contextDialog.getString(R.string.large_leather_shield_des),"90","50","35","50","60","50","60","50,","45","60","40","1.5","7","","","")
         contextDialog.getString(R.string.chloranthy_ring) -> setDataDialogObjects("chloranthyring",contextDialog.getString(R.string.chloranthy_ring),contextDialog.getString(R.string.chloranthy_ring_des))
         contextDialog.getString(R.string.hand_axe) -> setDataDialogWeapon("handaxe",contextDialog.getString(R.string.hand_axe),contextDialog.getString(R.string.hand_axe_des),"135","110","","25", "","20","","50","","2.0","9","3","","")
         contextDialog.getString(R.string.shortsword) -> setDataDialogWeapon("shortsword",contextDialog.getString(R.string.shortsword),contextDialog.getString(R.string.shortsword_des),"200","110","","10", "","15","","60","","2.0","7","10","","")
         contextDialog.getString(R.string.small_leather_shield) -> setDataDialogShield("smallleathershield",contextDialog.getString(R.string.small_leather_shield),contextDialog.getString(R.string.small_leather_shield_des),"75","50","35","40", "50","40","60","40","40","70","30","0.5","5","","","")
         contextDialog.getString(R.string.hawk_ring) -> setDataDialogObjects("hawkring",contextDialog.getString(R.string.hawk_ring),contextDialog.getString(R.string.hawk_ring_des))
         contextDialog.getString(R.string.flame_quartz_ring) -> setDataDialogObjects("flamequartzring",contextDialog.getString(R.string.flame_quartz_ring),contextDialog.getString(R.string.flame_quartz_ring_des))
         contextDialog.getString(R.string.sublime_bone_dust) -> setDataDialogObjects("sublimebonedust",contextDialog.getString(R.string.sublime_bone_dust),contextDialog.getString(R.string.sublime_bone_dust_des))
         contextDialog.getString(R.string.dark_troches) -> setDataDialogObjects("darktroches",contextDialog.getString(R.string.dark_troches),contextDialog.getString(R.string.dark_troches_des))
         contextDialog.getString(R.string.petrified_dragon_bone) -> setDataDialogObjects("petrifieddragonbone", contextDialog.getString(R.string.petrified_dragon_bone),contextDialog.getString(R.string.petrified_dragon_bone_des))
         contextDialog.getString(R.string.monastery_charm) -> setDataDialogObjects("monasterycharm",contextDialog.getString(R.string.monastery_charm),contextDialog.getString(R.string.monastery_charm_des))
         contextDialog.getString(R.string.ring_of_binding) -> setDataDialogObjects("ringofbinding",contextDialog.getString(R.string.ring_of_binding),contextDialog.getString(R.string.ring_of_binding_des))
         contextDialog.getString(R.string.old_knight_halberd) -> setDataDialogWeapon("oldknighthalberd",contextDialog.getString(R.string.old_knight_halberd),contextDialog.getString(R.string.old_knight_halberd_des),"360","120","","35", "","40","","20","","16.0","16","20","","")
         contextDialog.getString(R.string.watchdragon_parma) -> setDataDialogShield("watchdragonparma",contextDialog.getString(R.string.watchdragon_parma),contextDialog.getString(R.string.watchdragon_parma_des),"90","40","75","40", "75","85","60","85","60","60","50","4.5","10","","","")
         contextDialog.getString(R.string.cracked_blue_eye_orb) -> setDataDialogObjects("crackedblueeyeorb",contextDialog.getString(R.string.cracked_blue_eye_orb),contextDialog.getString(R.string.cracked_blue_eye_orb_des))
         contextDialog.getString(R.string.tower_shield) -> setDataDialogShield("towershield",contextDialog.getString(R.string.tower_shield),contextDialog.getString(R.string.tower_shield_des),"100","45","40","45", "75","45","50","45","40","90","70","13.0","30","","","")
         contextDialog.getString(R.string.clerics_parma) -> setDataDialogShield("clericsparma",contextDialog.getString(R.string.clerics_parma),contextDialog.getString(R.string.clerics_parma_des),"50","30","70","30", "75","30","75","30","65","50","20","1.5","7","13","","")
         contextDialog.getString(R.string.great_sword) -> setDataDialogWeapon("greatsword",contextDialog.getString(R.string.great_sword),contextDialog.getString(R.string.great_sword_des),"400","130","","50", "","45","","70","","22.0","28","10","","")
         contextDialog.getString(R.string.royal_soldiers_ring) -> setDataDialogObjects("royalsoldiersring",contextDialog.getString(R.string.royal_soldiers_ring),contextDialog.getString(R.string.royal_soldiers_ring_des))
         contextDialog.getString(R.string.bandit_axe) -> setDataDialogWeapon("banditaxe",contextDialog.getString(R.string.bandit_axe),contextDialog.getString(R.string.bandit_axe_des),"310","120","","30", "","30","0","50","","5.0","18","5","","")
         contextDialog.getString(R.string.pyromancy_flame) -> setDataDialogWeapon("pyromancyflame",contextDialog.getString(R.string.pyromancy_flame),contextDialog.getString(R.string.pyromancy_flame_des),"","100","","5", "250","10","","70","","0","","","","")
         contextDialog.getString(R.string.emit_force) -> setDataDialogMagics("emitforce",contextDialog.getString(R.string.emit_force),contextDialog.getString(R.string.emit_force_des),"","20")
         contextDialog.getString(R.string.fireball) -> setDataDialogObjects("fireball",contextDialog.getString(R.string.fireball),contextDialog.getString(R.string.fireball_des))
         contextDialog.getString(R.string.fire_bomb) -> setDataDialogObjects("firebomb",contextDialog.getString(R.string.fire_bomb),contextDialog.getString(R.string.fire_bomb_des))
         contextDialog.getString(R.string.flame_butterfly) -> setDataDialogObjects("flamebutterfly",contextDialog.getString(R.string.flame_butterfly),contextDialog.getString(R.string.flame_butterfly_des))
         contextDialog.getString(R.string.fragrant_branch_of_yore) -> setDataDialogObjects("fragrantbranchofyore",contextDialog.getString(R.string.fragrant_branch_of_yore),contextDialog.getString(R.string.fragrant_branch_of_yore_des))
         contextDialog.getString(R.string.fading_soul) -> setDataDialogObjects("fadingsoul",contextDialog.getString(R.string.fading_soul),contextDialog.getString(R.string.fading_soul_des))
         contextDialog.getString(R.string.large_soul_of_a_nameless_soldier) -> setDataDialogObjects("largesoulofanamelesssoldier",contextDialog.getString(R.string.large_soul_of_a_nameless_soldier),contextDialog.getString(R.string.large_soul_of_a_nameless_soldier_des))
         contextDialog.getString(R.string.iron_arrow) -> setDataDialogObjects("ironarrow",contextDialog.getString(R.string.iron_arrow),contextDialog.getString(R.string.iron_arrow_des))
         contextDialog.getString(R.string.dark_pine_resin) -> setDataDialogObjects("darkpineresin",contextDialog.getString(R.string.dark_pine_resin),contextDialog.getString(R.string.dark_pine_resin_des))
         contextDialog.getString(R.string.silver_talisman) -> setDataDialogObjects("silvertalisman",contextDialog.getString(R.string.silver_talisman),contextDialog.getString(R.string.silver_talisman_des))
         contextDialog.getString(R.string.dullember) -> setDataDialogObjects("dullember",contextDialog.getString(R.string.dullember),contextDialog.getString(R.string.dullember_des))
         contextDialog.getString(R.string.alluring_skull) -> setDataDialogObjects("alluringskull",contextDialog.getString(R.string.alluring_skull),contextDialog.getString(R.string.alluring_skull_des))
         contextDialog.getString(R.string.soul_of_a_breave_warrior) -> setDataDialogObjects("soulofabravewarrior",contextDialog.getString(R.string.soul_of_a_breave_warrior),contextDialog.getString(R.string.soul_of_a_breave_warrior_des)+" X5000")
         contextDialog.getString(R.string.heavy_bolt) -> setDataDialogObjects("heavybolt",contextDialog.getString(R.string.heavy_bolt),contextDialog.getString(R.string.heavy_bolt_des))
         contextDialog.getString(R.string.hush) -> setDataDialogMagics("hush",contextDialog.getString(R.string.hush),contextDialog.getString(R.string.hush_des),"15","")
         contextDialog.getString(R.string.rouge_water) -> setDataDialogObjects("rougewater",contextDialog.getString(R.string.rouge_water),contextDialog.getString(R.string.rouge_water_des))
         contextDialog.getString(R.string.antiquated_key) -> setDataDialogObjects("antiquatedkey",contextDialog.getString(R.string.antiquated_key),contextDialog.getString(R.string.antiquated_key_des))
         contextDialog.getString(R.string.bonfire_ascetic) -> setDataDialogObjects("bonfireascetic",contextDialog.getString(R.string.bonfire_ascetic),contextDialog.getString(R.string.bonfire_ascetic_des))
         contextDialog.getString(R.string.large_club) -> setDataDialogWeapon("largeclub",contextDialog.getString(R.string.large_club),contextDialog.getString(R.string.large_club_des),"360","100","","60", "","30","","70","","12.0","26","4","","")
         contextDialog.getString(R.string.target_shield) -> setDataDialogShield("targetshield",contextDialog.getString(R.string.target_shield),contextDialog.getString(R.string.target_shield_des),"80","50","30","40", "65","40","50","40","45","50","35","2.0","8","","","")
         contextDialog.getString(R.string.scimitar) -> setDataDialogWeapon("scimitar",contextDialog.getString(R.string.scimitar),contextDialog.getString(R.string.scimitar_des),"220","110", "","20","","30","","40","","1.5","7", "16","","")
         contextDialog.getString(R.string.craftsmans_hammer) -> setDataDialogWeapon("craftsmanshammer",contextDialog.getString(R.string.craftsmans_hammer),contextDialog.getString(R.string.craftsmans_hammer_des),"250","130", "","30","","20","","80","","3.0","20", "10","","")
         contextDialog.getString(R.string.covetous_silver_serpent_ring) -> setDataDialogObjects("covetoussilverserpentring",contextDialog.getString(R.string.covetous_silver_serpent_ring),contextDialog.getString(R.string.covetous_silver_serpent_ring_des))
         contextDialog.getString(R.string.archdrake_shield) -> setDataDialogShield("archdrakeshield",contextDialog.getString(R.string.archdrake_shield),contextDialog.getString(R.string.archdrake_shield_des),"95","40", "65","40","50","40","50","40","40","80","50","4.0","14","","","")
         contextDialog.getString(R.string.bone_staff) -> setDataDialogWeapon("bonestaff",contextDialog.getString(R.string.bone_staff),contextDialog.getString(R.string.bone_staff_des),"","110","190","15", "","15","","50","190","4.5","","","20","")
         contextDialog.getString(R.string.parrying_dagger) -> setDataDialogWeapon("parryingdagger",contextDialog.getString(R.string.parrying_dagger),contextDialog.getString(R.string.parrying_dagger_des),"80","120","","10", "","15","","60","","0.5","4","9","","")
         contextDialog.getString(R.string.twinblade) -> setDataDialogWeapon("twinblade",contextDialog.getString(R.string.twinblade),contextDialog.getString(R.string.twin_blade_des),"150","120","","25", "","50","","150","","8.0","14","26","","")
         contextDialog.getString(R.string.priest_schime) -> setDataDialogWeapon("priestschime",contextDialog.getString(R.string.priest_schime),contextDialog.getString(R.string.priest_schime_des),"","100","","5", "","5","190","30","190","0.5","","","","18")
         contextDialog.getString(R.string.bracing_knuckle_ring) -> setDataDialogObjects("bracingknucklering",contextDialog.getString(R.string.bracing_knuckle_ring),contextDialog.getString(R.string.bracing_knuckle_ring_des))
         contextDialog.getString(R.string.skeptics_spice) -> setDataDialogObjects("skepticsspice",contextDialog.getString(R.string.skeptics_spice),contextDialog.getString(R.string.skeptics_spice_des))
         contextDialog.getString(R.string.twilight_herb) -> setDataDialogObjects("twilightherb",contextDialog.getString(R.string.twilight_herb),contextDialog.getString(R.string.twilight_herb_des))
         contextDialog.getString(R.string.brightbug) -> setDataDialogObjects("brightbug",contextDialog.getString(R.string.brightbug),contextDialog.getString(R.string.brightbug_des))
         contextDialog.getString(R.string.blue_tearstone_ring) -> setDataDialogObjects("bluetearstonering",contextDialog.getString(R.string.blue_tearstone_ring),contextDialog.getString(R.string.blue_tearstone_ring_des))
         contextDialog.getString(R.string.southern_ritual_band) -> setDataDialogObjects("southernritual",contextDialog.getString(R.string.southern_ritual_band),contextDialog.getString(R.string.southern_ritual_band_des))
         contextDialog.getString(R.string.dragon_tooth) -> setDataDialogWeapon("dragontooth",contextDialog.getString(R.string.dragon_tooth),contextDialog.getString(R.string.dragon_tooth_des),"470","100","0","60", "","30","","70","","20.0","50","10","","")
         contextDialog.getString(R.string.falchion) -> setDataDialogWeapon("falchion",contextDialog.getString(R.string.falchion),contextDialog.getString(R.string.falchion_des),"240","150","","10", "","15","","60","","2.5","9","13","","")
         contextDialog.getString(R.string.elizabeth_mushroom) -> setDataDialogObjects("elizabethmushroom",contextDialog.getString(R.string.elizabeth_mushroom),contextDialog.getString(R.string.elizabeth_mushroom_des))
         contextDialog.getString(R.string.bleed_stone) -> setDataDialogObjects("bleedstone",contextDialog.getString(R.string.bleed_stone),contextDialog.getString(R.string.bleed_stone_des))
         contextDialog.getString(R.string.fire_seed) -> setDataDialogObjects("fireseed",contextDialog.getString(R.string.fire_seed),contextDialog.getString(R.string.fire_seed_des))
         contextDialog.getString(R.string.northern_ritual_band) -> setDataDialogObjects("northernritualband",contextDialog.getString(R.string.northern_ritual_band),contextDialog.getString(R.string.northern_ritual_band_des))
         contextDialog.getString(R.string.blossom_kite_shield) -> setDataDialogShield("blossomkiteshield",contextDialog.getString(R.string.blossom_kite_shield),contextDialog.getString(R.string.blossom_kite_shield_des),"75","95","70","80", "65","65","65","65","65","60","45","4.0","12","","","")
         contextDialog.getString(R.string.bandits_knife) -> setDataDialogWeapon("banditsknife",contextDialog.getString(R.string.bandits_knife),contextDialog.getString(R.string.bandits_knife_des),"130","130","","10", "","15","","60","","1.0","3","","","")
         contextDialog.getString(R.string.token_of_fidelity) -> setDataDialogObjects("tokenoffidelity",contextDialog.getString(R.string.token_of_fidelity),contextDialog.getString(R.string.token_of_fidelity_des))
         contextDialog.getString(R.string.undead_lockaway_key) -> setDataDialogObjects("undeadlockawaykey",contextDialog.getString(R.string.undead_lockaway_key),contextDialog.getString(R.string.undead_lockaway_key_des))
         contextDialog.getString(R.string.poison_throwing_knife) -> setDataDialogObjects("poisonthrowingknife",contextDialog.getString(R.string.poison_throwing_knife),contextDialog.getString(R.string.poison_throwing_knife_des))
         contextDialog.getString(R.string.flamberge) -> setDataDialogWeapon("flamberge",contextDialog.getString(R.string.flamberge),contextDialog.getString(R.string.flamberge_des),"290","110","","35", "","40","","60","","8.0","20","13","","")
         contextDialog.getString(R.string.combustion) -> setDataDialogMagics("combustion",contextDialog.getString(R.string.combustion),contextDialog.getString(R.string.combustion_des),"","")
         contextDialog.getString(R.string.ricards_rapier) -> setDataDialogWeapon("ricardsrapier",contextDialog.getString(R.string.ricards_rapier),contextDialog.getString(R.string.ricards_rapier_des),"160","140","","10", "","20","","45","","2.0","8","25","","")
         contextDialog.getString(R.string.notched_whip) -> setDataDialogWeapon("notchedwhip",contextDialog.getString(R.string.notched_whip),contextDialog.getString(R.string.notched_whip_des),"205","100","","15", "","15","","50","","2.0","12","20","","")
         contextDialog.getString(R.string.soul_spear) -> setDataDialogMagics("soulspear",contextDialog.getString(R.string.soul_spear),contextDialog.getString(R.string.soul_spear_des),"40","")
         contextDialog.getString(R.string.mace) -> setDataDialogWeapon("mace",contextDialog.getString(R.string.mace),contextDialog.getString(R.string.mace_des),"240","120","","30", "","20","","60","","4.0","12","5","","")
         contextDialog.getString(R.string.raw_stone) -> setDataDialogObjects("rawstone",contextDialog.getString(R.string.raw_stone),contextDialog.getString(R.string.raw_stone_des))
         contextDialog.getString(R.string.hexing_urn) -> setDataDialogObjects("hexingurn",contextDialog.getString(R.string.hexing_urn),contextDialog.getString(R.string.hexing_urn_des))
         contextDialog.getString(R.string.simpletons_spice) -> setDataDialogObjects("simpletonsspice",contextDialog.getString(R.string.simpletons_spice),contextDialog.getString(R.string.simpletons_spice_des))
         contextDialog.getString(R.string.poison_stone) -> setDataDialogObjects("poisonstone",contextDialog.getString(R.string.poison_stone),contextDialog.getString(R.string.poison_stone_des))
         contextDialog.getString(R.string.rotten_pine_resin) -> setDataDialogObjects("rottenpineresin",contextDialog.getString(R.string.rotten_pine_resin),contextDialog.getString(R.string.rotten_pine_resin_des))
         contextDialog.getString(R.string.old_knight_pike) -> setDataDialogWeapon("oldknightpike",contextDialog.getString(R.string.old_knight_pike),contextDialog.getString(R.string.old_knight_pike_des),"380","120","","35", "","40","","20","","16.0","20","16","","")
         contextDialog.getString(R.string.old_knight_greatshield) -> setDataDialogShield("oldknightgreatshield",contextDialog.getString(R.string.old_knight_greatshield),contextDialog.getString(R.string.old_knight_greatshield_des),"100","85","20","85", "20","85","20","85","20","40","65","13.0","28","","","")
         contextDialog.getString(R.string.chameleon) -> setDataDialogMagics("chameleon",contextDialog.getString(R.string.chameleon),contextDialog.getString(R.string.chameleon_des),"14","")
         contextDialog.getString(R.string.washin_pole) -> setDataDialogWeapon("washinpole",contextDialog.getString(R.string.washin_pole),contextDialog.getString(R.string.washin_pole_des),"240","130","","20", "","30","","20","","10.0","18","20","","")
         contextDialog.getString(R.string.dragon_charm) -> setDataDialogObjects("dragoncharm",contextDialog.getString(R.string.dragon_charm),contextDialog.getString(R.string.dragon_charm_des))
         contextDialog.getString(R.string.broadsword) -> setDataDialogWeapon("broadsword",contextDialog.getString(R.string.broadsword),contextDialog.getString(R.string.broadsword_des),"240","110","","20", "","30","","60","","3.0","11","6","","")
         contextDialog.getString(R.string.poisonbite_ring) -> setDataDialogObjects("poisonbitering",contextDialog.getString(R.string.poisonbite_ring),contextDialog.getString(R.string.poisonbite_ring_des))
         contextDialog.getString(R.string.mirrah_shield) -> setDataDialogShield("mirrahshield",contextDialog.getString(R.string.mirrah_shield),contextDialog.getString(R.string.mirrah_shield_des),"90","30","40","30", "45","30","45","30","45","70","50","4.5","12","","","")
         contextDialog.getString(R.string.heavy_crossbow) -> setDataDialogWeapon("heavycrossbow",contextDialog.getString(R.string.heavy_crossbow),contextDialog.getString(R.string.heavy_crossbow_des),"190","100","","10", "","10","","70","","4.0","20","6","","")
         contextDialog.getString(R.string.lightning_spear) -> setDataDialogMagics("lightningspear",contextDialog.getString(R.string.lightning_spear),contextDialog.getString(R.string.lightning_spear_des),"","22")
         contextDialog.getString(R.string.great_heavy_soul_arrow) -> setDataDialogMagics("greatheavysoularrow",contextDialog.getString(R.string.great_heavy_soul_arrow),contextDialog.getString(R.string.great_heavy_soul_arrow_des),"16","")
         contextDialog.getString(R.string.iron_key) -> setDataDialogObjects("ironkey",contextDialog.getString(R.string.iron_key),contextDialog.getString(R.string.iron_key_des))
         contextDialog.getString(R.string.winged_spear) -> setDataDialogWeapon("wingedspear",contextDialog.getString(R.string.winged_spear),contextDialog.getString(R.string.winged_spear_des),"240","130","","20", "","25","","50","","4.5","11","18","","")
         contextDialog.getString(R.string.destructive_great_arrow) -> setDataDialogObjects("destructivegreatarrow",contextDialog.getString(R.string.destructive_great_arrow),contextDialog.getString(R.string.destructive_great_arrow_des))
         contextDialog.getString(R.string.porcine_shield) -> setDataDialogShield("porcineshield",contextDialog.getString(R.string.porcine_shield),contextDialog.getString(R.string.porcine_shield_des),"65","30","40","30", "65","30","40","30","40","20","40","4.0","9","","","")
         contextDialog.getString(R.string.black_knight_greataxe) -> setDataDialogWeapon("blackknightgreataxe",contextDialog.getString(R.string.black_knight_greataxe),contextDialog.getString(R.string.black_knight_greataxe_des),"340","110","","50", "120","40","","60","","20.0","40","18","","")
         contextDialog.getString(R.string.covetous_gold_serpent_ring) -> setDataDialogObjects("covetousgoldserpentring",contextDialog.getString(R.string.covetous_gold_serpent_ring),contextDialog.getString(R.string.covetous_gold_serpent_ring_des))
         contextDialog.getString(R.string.zweihander) -> setDataDialogWeapon("zweihander",contextDialog.getString(R.string.zweihander),contextDialog.getString(R.string.zweihander_des),"360","130","","50", "","45","","60","","12.0","24","12","","")
         contextDialog.getString(R.string.phoenix_parma) -> setDataDialogShield("phoenixparma",contextDialog.getString(R.string.phoenix_parma),contextDialog.getString(R.string.phoenix_parma_des),"70","45","40","45", "90","45","40","45","40","50","40","2.5","9","10","","")
         contextDialog.getString(R.string.immolation) -> setDataDialogObjects("immolation",contextDialog.getString(R.string.immolation),contextDialog.getString(R.string.immolation_des))
         contextDialog.getString(R.string.soul_vortex) -> setDataDialogMagics("soulvortex",contextDialog.getString(R.string.soul_vortex),contextDialog.getString(R.string.soul_vortex_des),"37","")
         contextDialog.getString(R.string.warmth) -> setDataDialogObjects("warmth",contextDialog.getString(R.string.warmth),contextDialog.getString(R.string.warmth_des))
         contextDialog.getString(R.string.ash_knuckle_ring) -> setDataDialogObjects("ashknucklering",contextDialog.getString(R.string.ash_knuckle_ring),contextDialog.getString(R.string.ash_knuckle_ring_des))
         contextDialog.getString(R.string.dark_pyromancy_flame) -> setDataDialogWeapon("darkpyromancyflame",contextDialog.getString(R.string.dark_pyromancy_flame),contextDialog.getString(R.string.dark_pyromancy_flame_des),"","100","","5", "300","10","","60","","0","","","","")
         contextDialog.getString(R.string.forgotten_key) -> setDataDialogObjects("forgottenkey",contextDialog.getString(R.string.forgotten_key),contextDialog.getString(R.string.forgotten_key_des))
         contextDialog.getString(R.string.great_club) -> setDataDialogWeapon("greatclub",contextDialog.getString(R.string.great_club),contextDialog.getString(R.string.great_club_des),"420","100","","60", "","30","","70","","15","28","4","","")
         contextDialog.getString(R.string.wicked_eye_greatshield) -> setDataDialogShield("wickedeyegreatshieldframe",contextDialog.getString(R.string.wicked_eye_greatshield),contextDialog.getString(R.string.wicked_eye_greatshield_des),"90","50","65","50", "70","50","70","50","40","70","60","13.8","31","","","")
         contextDialog.getString(R.string.ring_of_the_soul_protection) -> setDataDialogObjects("ringofthesoulprotection",contextDialog.getString(R.string.ring_of_the_soul_protection),contextDialog.getString(R.string.ring_of_the_soul_protection_des))
         contextDialog.getString(R.string.heide_lance) -> setDataDialogWeapon("heidelance",contextDialog.getString(R.string.heide_lance),contextDialog.getString(R.string.heide_lance_des),"230","160","","30", "","15","","60","","8.0","18","12","","")
         contextDialog.getString(R.string.great_magic_weapon) -> setDataDialogMagics("greatmagicweapon",contextDialog.getString(R.string.great_magic_weapon),contextDialog.getString(R.string.great_magic_weapon_des),"18","")
         contextDialog.getString(R.string.soul_of_a_giant) -> setDataDialogObjects("soulofagiant",contextDialog.getString(R.string.soul_of_a_giant),contextDialog.getString(R.string.soul_of_a_giant_des))
         contextDialog.getString(R.string.ring_of_giants) -> setDataDialogObjects("ringofgiants",contextDialog.getString(R.string.ring_of_giants),contextDialog.getString(R.string.ring_of_giants_des))
         contextDialog.getString(R.string.homing_soul_mass) -> setDataDialogMagics("homingsoulmass",contextDialog.getString(R.string.homing_soul_mass),contextDialog.getString(R.string.homing_soul_mass_des),"24","")
         contextDialog.getString(R.string.repair) -> setDataDialogMagics("repair",contextDialog.getString(R.string.repair),contextDialog.getString(R.string.repair_des),"15","")
         contextDialog.getString(R.string.old_sun_ring) -> setDataDialogObjects("oldsunring",contextDialog.getString(R.string.old_sun_ring),contextDialog.getString(R.string.old_sun_ring_des))
         contextDialog.getString(R.string.clear_bluestone_ring) -> setDataDialogObjects("clearbluestonering",contextDialog.getString(R.string.clear_bluestone_ring),contextDialog.getString(R.string.clear_bluestone_ring_des))
         contextDialog.getString(R.string.red_tearstone_ring) -> setDataDialogObjects("redtearstonering",contextDialog.getString(R.string.red_tearstone_ring),contextDialog.getString(R.string.red_tearstone_ring_des))
         contextDialog.getString(R.string.ring_of_life_protection) -> setDataDialogObjects("ringoflifeprotection",contextDialog.getString(R.string.ring_of_life_protection),contextDialog.getString(R.string.ring_of_life_protection_des))
         contextDialog.getString(R.string.dragonslayers_crescent_axe) -> setDataDialogWeapon("dragonslayerscrescentaxe",contextDialog.getString(R.string.dragonslayers_crescent_axe),contextDialog.getString(R.string.dragonslayers_crescent_axe_des),"200","130","","30", "","30","60","60","","7.0.","18","12","","")
         contextDialog.getString(R.string.black_knight_halberd) -> setDataDialogWeapon("blackknighthalberd",contextDialog.getString(R.string.black_knight_halberd),contextDialog.getString(R.string.black_knight_halberd_des),"330","120","130","35", "","40","","70","","14.0","17","26","","")
         contextDialog.getString(R.string.scythe) -> setDataDialogWeapon("scythe",contextDialog.getString(R.string.scythe),contextDialog.getString(R.string.scythe_des),"330","120","","35", "","40","","60","","5.0","20","11","","")
         contextDialog.getString(R.string.large_soul_of_a_brave_warrior) -> setDataDialogObjects("largesoulofabravewarrior",contextDialog.getString(R.string.large_soul_of_a_brave_warrior),contextDialog.getString(R.string.large_soul_of_a_brave_warrior_des))
         contextDialog.getString(R.string.rat_tail) -> setDataDialogObjects("rattail",contextDialog.getString(R.string.rat_tail),contextDialog.getString(R.string.rat_tail_des))
         contextDialog.getString(R.string.prism_stone) -> setDataDialogObjects("prismstone",contextDialog.getString(R.string.prism_stone),contextDialog.getString(R.string.prism_stone_des))
         contextDialog.getString(R.string.santiers_spear) -> setDataDialogWeapon("santiersspear",contextDialog.getString(R.string.santiers_spear),contextDialog.getString(R.string.santiers_spear_des),"350","120","","35", "","40","","500","","12.0","20","22","","")
         contextDialog.getString(R.string.gyrm_axe) -> setDataDialogWeapon("gyrmaxe",contextDialog.getString(R.string.gyrm_axe),contextDialog.getString(R.string.gyrm_axe_des),"380","110","","30", "","30","","120","0","18","28","6","","")
         contextDialog.getString(R.string.gyrm_great_hammer) -> setDataDialogWeapon("gyrmgreathammer",contextDialog.getString(R.string.gyrm_great_hammer),contextDialog.getString(R.string.gyrm_great_hammer_des),"450","100","","60", "","30","","80","","20","40","4","","")
         contextDialog.getString(R.string.staff_of_wisdom) -> setDataDialogWeapon("staffofwisdom",contextDialog.getString(R.string.staff_of_wisdom),contextDialog.getString(R.string.staff_of_wisdom_des),"","100","277","5", "","5","","60","","1.0","","","50","")
         contextDialog.getString(R.string.great_fireball) -> setDataDialogObjects("greatfireball",contextDialog.getString(R.string.great_fireball),contextDialog.getString(R.string.great_fireball_des))
         contextDialog.getString(R.string.lacerating_arrow) -> setDataDialogObjects("laceratingarrow",contextDialog.getString(R.string.lacerating_arrow),contextDialog.getString(R.string.lacerating_arrow_des))
         contextDialog.getString(R.string.black_knight_ultra_greatsword) -> setDataDialogWeapon("blackknightultragreatsword",contextDialog.getString(R.string.black_knight_ultra_greatsword),contextDialog.getString(R.string.black_knight_ultra_greatsword_des),"280","130","0","50", "110","45","","70","","18.0","30","16","","")
         contextDialog.getString(R.string.clerics_small_shield) -> setDataDialogShield("clericssmallshield",contextDialog.getString(R.string.clerics_small_shield),contextDialog.getString(R.string.clerics_small_shield_des),"75","40","70","40", "75","40","90","40","65","60","30","2.5","8","12","","")
         contextDialog.getString(R.string.faint_stone) -> setDataDialogObjects("faintstone",contextDialog.getString(R.string.faint_stone),contextDialog.getString(R.string.faint_stone_des))
         contextDialog.getString(R.string.crescent_axe) -> setDataDialogWeapon("crescentaxe",contextDialog.getString(R.string.crescent_axe),contextDialog.getString(R.string.crescent_axe_des),"210","110","80","30", "","30","","60","","12.0","25","14","","")
         contextDialog.getString(R.string.pick_axe) -> setDataDialogWeapon("pickaxe",contextDialog.getString(R.string.pick_axe),contextDialog.getString(R.string.pick_axe_des),"300","150","","50", "","30","","60","","8.0","22","8","","")
         contextDialog.getString(R.string.dark_quartz_ring) -> setDataDialogObjects("darkquartzring",contextDialog.getString(R.string.dark_quartz_ring),contextDialog.getString(R.string.dark_quartz_ring_des))
         contextDialog.getString(R.string.brightstone_key) -> setDataDialogObjects("brightstonekey",contextDialog.getString(R.string.brightstone_key),contextDialog.getString(R.string.brightstone_key_des))
         contextDialog.getString(R.string.holy_water_urn) -> setDataDialogObjects("holywaterurn",contextDialog.getString(R.string.holy_water_urn),contextDialog.getString(R.string.holy_water_urn_des))
         contextDialog.getString(R.string.frozen_flower) -> setDataDialogObjects("frozenflower",contextDialog.getString(R.string.frozen_flower),contextDialog.getString(R.string.frozen_flower_des))
         contextDialog.getString(R.string.great_combustion) -> setDataDialogObjects("greatcombustion",contextDialog.getString(R.string.great_combustion),contextDialog.getString(R.string.great_combustion_des))
         contextDialog.getString(R.string.fire_storm) -> setDataDialogObjects("firestorm",contextDialog.getString(R.string.fire_storm),contextDialog.getString(R.string.fire_storm_des))
         contextDialog.getString(R.string.strong_magic_shield) -> setDataDialogMagics("strongmagicshield",contextDialog.getString(R.string.strong_magic_shield),contextDialog.getString(R.string.strong_magic_shield_des),"18","")
         contextDialog.getString(R.string.hunters_black_bow) -> setDataDialogWeapon("huntersblackbow",contextDialog.getString(R.string.hunters_black_bow),contextDialog.getString(R.string.hunters_black_bow_des),"155","100","","5", "","10","","70","","2.0","9","25","","")
         contextDialog.getString(R.string.soul_of_a_hero) -> setDataDialogObjects("soulofahero",contextDialog.getString(R.string.soul_of_a_hero),contextDialog.getString(R.string.soul_of_a_hero_des))
         contextDialog.getString(R.string.corrosive_urn) -> setDataDialogObjects("corrosiveurn",contextDialog.getString(R.string.corrosive_urn),contextDialog.getString(R.string.corrosive_urn_des))
         contextDialog.getString(R.string.caithas_chime) -> setDataDialogWeapon("caithaschime",contextDialog.getString(R.string.caithas_chime),contextDialog.getString(R.string.caithas_chime_des),"","100","","5", "","5","","30","250","0.5","","","18","22")
         contextDialog.getString(R.string.gowers_ring_of_protection) -> setDataDialogObjects("gowersringofprotection",contextDialog.getString(R.string.gowers_ring_of_protection),contextDialog.getString(R.string.gowers_ring_of_protection_des))
         contextDialog.getString(R.string.stone_soldier_spear) -> setDataDialogWeapon("stonesoldierspear",contextDialog.getString(R.string.stone_soldier_spear),contextDialog.getString(R.string.stone_soldier_spear_des),"190","130","","20", "","25","","50","","7.0","16","20","","")
         contextDialog.getString(R.string.stone_twinblade) -> setDataDialogWeapon("stonetwinblade",contextDialog.getString(R.string.stone_twinblade),contextDialog.getString(R.string.stone_twinblade_des),"180","120","","25", "","30","","120","","10.0","18","22","","")
         contextDialog.getString(R.string.soul_greatsword) -> setDataDialogMagics("soulgreatsword",contextDialog.getString(R.string.soul_greatsword),contextDialog.getString(R.string.soul_greatsword_des),"27","")
         contextDialog.getString(R.string.spell_quartz_ring) -> setDataDialogObjects("spellquartzring",contextDialog.getString(R.string.spell_quartz_ring),contextDialog.getString(R.string.spell_quartz_ring_des))
         contextDialog.getString(R.string.wilted_dusk_herb) -> setDataDialogObjects("wiltedduskherb",contextDialog.getString(R.string.wilted_dusk_herb),contextDialog.getString(R.string.wilted_dusk_herb_des))
         contextDialog.getString(R.string.crimson_water) -> setDataDialogObjects("crimsonwater",contextDialog.getString(R.string.crimson_water),contextDialog.getString(R.string.crimson_water_des))
         contextDialog.getString(R.string.sunlight_blade) -> setDataDialogMagics("sunlightblade",contextDialog.getString(R.string.sunlight_blade),contextDialog.getString(R.string.sunlight_blade_des),"","36")
         contextDialog.getString(R.string.soul_of_the_king) -> setDataDialogObjects("souloftheking",contextDialog.getString(R.string.soul_of_the_king),contextDialog.getString(R.string.soul_of_the_king_des))
         contextDialog.getString(R.string.fire_tempest) -> setDataDialogObjects("firetempest",contextDialog.getString(R.string.fire_tempest),contextDialog.getString(R.string.fire_tempest_des))
         contextDialog.getString(R.string.homing_crystal_soulmass) -> setDataDialogMagics("homingcrystalsoulmass",contextDialog.getString(R.string.homing_crystal_soulmass),contextDialog.getString(R.string.homing_crystal_soulmass_des),"32","")
         contextDialog.getString(R.string.key_to_the_embedded) -> setDataDialogObjects("keytotheembedded",contextDialog.getString(R.string.key_to_the_embedded),contextDialog.getString(R.string.key_to_the_embedded_des))
         contextDialog.getString(R.string.magic_arrow) -> setDataDialogObjects("magicarrow",contextDialog.getString(R.string.magic_arrow),contextDialog.getString(R.string.magic_arrow_des))
         contextDialog.getString(R.string.manslayer) -> setDataDialogWeapon("manslayer",contextDialog.getString(R.string.manslayer),contextDialog.getString(R.string.manslayer_des),"230","150","","20", "","30","","40","","6","11","18","","")
         contextDialog.getString(R.string.helix_halberd) -> setDataDialogWeapon("helixhalberd",contextDialog.getString(R.string.helix_halberd),contextDialog.getString(R.string.helix_halberd_des),"280","120","","35", "","40","","70","","9,0","16","20","","")
         contextDialog.getString(R.string.red_iron_twinblade) -> setDataDialogWeapon("redirontwinblade",contextDialog.getString(R.string.red_iron_twinblade),contextDialog.getString(R.string.red_iron_twinblade_des),"340","120","","30", "","20","","90","","14.0","26","20","","")
         contextDialog.getString(R.string.soul_of_a_great_hero) -> setDataDialogObjects("soulofagreathero",contextDialog.getString(R.string.soul_of_a_great_hero),contextDialog.getString(R.string.soul_of_a_great_hero_des))
         contextDialog.getString(R.string.crushed_eye_orb) -> setDataDialogObjects("crushedeyeorb",contextDialog.getString(R.string.crushed_eye_orb),contextDialog.getString(R.string.crushed_eye_orb_des))
         contextDialog.getString(R.string.dried_fingers) -> setDataDialogObjects("driedfingers",contextDialog.getString(R.string.dried_fingers),contextDialog.getString(R.string.dried_fingers_des))
         contextDialog.getString(R.string.shotel)-> setDataDialogWeapon("shotel",contextDialog.getString(R.string.shotel),contextDialog.getString(R.string.shotel_des),"200","110","","15", "","30","","40","","2.5","10","16","","")
            else -> {
             return false
            }
        }

     view?.findViewById<Button>(R.id.btnOkDialog)?.setOnClickListener {
      dialog?.dismiss()
     }
     view?.findViewById<ConstraintLayout>(R.id.constLayout)?.setOnClickListener {
      dialog?.dismiss()
     }
     return true
    }
    private fun setDataDialogMagics(image: String,itemTitle: String,description: String,intelligence: String,faith: String) {
        dialog?.show()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)
        layoutDes1?.visibility = View.GONE
        layoutDes2?.visibility = View.GONE
        layoutDes3?.visibility = View.GONE
        layoutDes4?.visibility = View.GONE
        imageDialog?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable",contextDialog.packageName))
        tvItemDialog?.text = itemTitle
        tvItemDialog?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        if (description.length > 300) tvItemDes?.textSize = 14F
        tvItemDes?.text = description
        tvItemDes?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        ivIconStrength?.setImageResource(R.drawable.iconstrength)
        ivIconDexterity?.setImageResource(R.drawable.icondexterity)
        ivIconIntelligence?.setImageResource(R.drawable.iconintelligence)
        tvIconIntelligence?.text = intelligence
        ivIconFaith?.setImageResource(R.drawable.iconfaith)
        tvIconFaith?.text = faith
    }
    private fun setDataDialogShield(image: String, itemTitle: String, description: String, physicalDef: String, poisonDef: String, magicDef: String, bleedDef: String, fireDef: String,
                                    petrifyDef: String, lightningDef: String, curseDef: String, darkDef: String, durability: String, stability: String, weight: String, strength: String,
                                    dexterity: String,intelligence: String, faith: String){
        dialog?.show()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)

        imageDialog?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable",contextDialog.packageName))
        tvItemDialog?.text = itemTitle
        tvItemDialog?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        if (description.length > 200) tvItemDes?.textSize = 14F
        if (description.length > 300) tvItemDes?.textSize = 13F
        tvItemDes?.text = description
        tvItemDes?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        ivIconWpPhysicalAttackPhysicalDef?.setImageResource(R.drawable.iconwpphysicaldef)
        tvIconWpPhysicalAttackPhysicalDef?.text = physicalDef
        ivIconWpCounterStrengthPoisonDef?.setImageResource(R.drawable.iconwppoisondef)
        tvIconWpCounterStrengthPoisonDEf?.text = poisonDef
        ivIconMagicBonusMagicDef?.setImageResource(R.drawable.iconwpmagicdef)
        tvIconMagicBonusMagicDef?.text = magicDef
        ivIconWpPoiseDamageBleedDef?.setImageResource(R.drawable.iconwpbleeddef)
        tvIconWpPoiseDamageBleedDef?.text = bleedDef
        ivIconFireBonusFireDef?.setImageResource(R.drawable.iconwpfiredef)
        tvIconFireBonusFireDef?.text = fireDef
        ivIconWpStabilityPetrifyDef?.setImageResource(R.drawable.iconwppetrifydef)
        tvIconWpStabilityPetrifyDef?.text = petrifyDef
        ivIconLightningBonusLightningDef?.setImageResource(R.drawable.iconwplightningdef)
        tvIconLightningBonusLightningDef?.text = lightningDef
        ivIconDurabilityCurseDef?.setImageResource(R.drawable.iconwpcursedef)
        tvIconDurabilityCurseDef?.text = curseDef
        ivIconDarkBonusDarkDef?.setImageResource(R.drawable.iconwpdarkdef)
        tvIconDarkBonusDarkDef?.text = darkDef
        ivIconWeightDurability?.setImageResource(R.drawable.icondurability)
        tvIconWeightDurability?.text = durability
        ivIconStability?.setImageResource(R.drawable.iconwpstability)
        tvIconStability?.text = stability
        ivIconWeight?.setImageResource(R.drawable.iconweight)
        tvIconWeight?.text = weight
        ivIconStrength?.setImageResource(R.drawable.iconstrength)
        tvIconStrength?.text = strength
        ivIconDexterity?.setImageResource(R.drawable.icondexterity)
        tvIconDexterity?.text = dexterity
        ivIconIntelligence?.setImageResource(R.drawable.iconintelligence)
        tvIconIntelligence?.text = intelligence
        ivIconFaith?.setImageResource(R.drawable.iconfaith)
        tvIconFaith?.text = faith
    }

    private fun setDataDialogObjects(image: String, itemTitle: String, description: String){

        dialog?.show()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)

        imageDialog?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable", contextDialog.packageName))
        tvItemDialog?.text = itemTitle
        tvItemDialog?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        tvItemDes?.text = description
        tvItemDes?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
    }

    private fun setDataDialogArmor(image: String, itemTitle: String,description: String, physicalDef: String, poiseDef: String, strikeDef: String, poisonRes: String, slashDef: String,
                                   bleedRes: String, thrustDef: String, petrifyRes: String, magicDef: String, curseRes: String, fireDef: String, lightningDef: String, durability: String,
                                   darkDef: String, weight: String, strength: String, dexterity: String, intelligence: String, faith: String){

        dialog?.show()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)

        imageDialog?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable", contextDialog.packageName))
        tvItemDialog?.text = itemTitle
        if (description.length > 200) tvItemDes?.textSize = 14F
        if (description.length > 300) tvItemDes?.textSize = 13F

        tvItemDes?.text = description
        tvItemDes?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        tvItemDialog?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")

        ivIconWpPhysicalAttackPhysicalDef?.setImageResource(R.drawable.iconphysicaldef)
        tvIconWpPhysicalAttackPhysicalDef?.text = physicalDef
        ivIconWpCounterStrengthPoisonDef?.setImageResource(R.drawable.iconpoisedef)
        tvIconWpCounterStrengthPoisonDEf?.text = poiseDef
        ivIconMagicBonusMagicDef?.setImageResource(R.drawable.iconstrikedef)
        tvIconMagicBonusMagicDef?.text = strikeDef
        ivIconWpPoiseDamageBleedDef?.setImageResource(R.drawable.iconpoisonres)
        tvIconWpPoiseDamageBleedDef?.text = poisonRes
        ivIconFireBonusFireDef?.setImageResource(R.drawable.iconslashdef)
        tvIconFireBonusFireDef?.text = slashDef
        ivIconWpStabilityPetrifyDef?.setImageResource(R.drawable.iconbleedres)
        tvIconWpStabilityPetrifyDef?.text = bleedRes
        ivIconLightningBonusLightningDef?.setImageResource(R.drawable.iconthrustdef)
        tvIconLightningBonusLightningDef?.text = thrustDef
        ivIconDurabilityCurseDef?.setImageResource(R.drawable.iconpetrifyres)
        tvIconDurabilityCurseDef?.text = petrifyRes
        ivIconDarkBonusDarkDef?.setImageResource(R.drawable.iconmagicdef)
        tvIconDarkBonusDarkDef?.text = magicDef
        ivIconWeightDurability?.setImageResource(R.drawable.iconcurseres)
        tvIconWeightDurability?.text = curseRes
        ivIconStability?.setImageResource(R.drawable.iconfiredef)
        tvIconStability?.text = fireDef
        ivIconWeight?.setImageResource(R.drawable.iconlightningdef)
        tvIconWeight?.text = lightningDef
        ivIconFireDef?.setImageResource(R.drawable.icondurability)
        tvIconFireDef?.text = durability
        ivIconLightningDef?.setImageResource(R.drawable.icondarkdef)
        tvIconLightningDef?.text = darkDef
        ivIconDurability?.setImageResource(R.drawable.iconweight)
        tvIconDurability?.text = weight
        ivIconStrength?.setImageResource(R.drawable.iconstrength)
        tvIconStrength?.text = strength
        ivIconDexterity?.setImageResource(R.drawable.icondexterity)
        tvIconDexterity?.text = dexterity
        ivIconIntelligence?.setImageResource(R.drawable.iconintelligence)
        tvIconIntelligence?.text = intelligence
        ivIconFaith?.setImageResource(R.drawable.iconfaith)
        tvIconFaith?.text = faith
    }

    private fun setDataDialogWeapon(image: String, itemTitle: String , description: String, physicalAttack: String, counterStrength: String,magicBonus: String,poiseDamage: String,
                                    fireBonus: String, stability: String,lightningBonus: String,durability: String, darkBonus: String, weight: String, strength: String, dexterity: String, intelligence: String,
                                    faith:String){

        dialog?.show()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCancelable(false)

        imageDialog?.setImageResource(contextDialog.resources.getIdentifier(image,"drawable",contextDialog.packageName))
        tvItemDialog?.text = itemTitle
        tvItemDialog?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        if (description.length > 200) tvItemDes?.textSize = 14F
        if (description.length > 300) tvItemDes?.textSize = 13F
        tvItemDes?.text = description
        tvItemDes?.typeface = Typeface.createFromAsset(contextDialog.assets,"fonts/optimussemibold.ttf")
        ivIconWpPhysicalAttackPhysicalDef?.setImageResource(R.drawable.iconwpphysicalattack)
        tvIconWpPhysicalAttackPhysicalDef?.text = physicalAttack
        ivIconWpCounterStrengthPoisonDef?.setImageResource(R.drawable.iconwpcounterstrength)
        tvIconWpCounterStrengthPoisonDEf?.text = counterStrength
        ivIconMagicBonusMagicDef?.setImageResource(R.drawable.iconmagicbonus)
        tvIconMagicBonusMagicDef?.text = magicBonus
        ivIconWpPoiseDamageBleedDef?.setImageResource(R.drawable.iconwppoisedamage)
        tvIconWpPoiseDamageBleedDef?.text = poiseDamage
        ivIconFireBonusFireDef?.setImageResource(R.drawable.iconfirebonus)
        tvIconFireBonusFireDef?.text = fireBonus
        ivIconWpStabilityPetrifyDef?.setImageResource(R.drawable.iconwpstability)
        tvIconWpStabilityPetrifyDef?.text = stability
        ivIconLightningBonusLightningDef?.setImageResource(R.drawable.iconlightningbonus)
        tvIconLightningBonusLightningDef?.text = lightningBonus
        ivIconDurabilityCurseDef?.setImageResource(R.drawable.icondurability)
        tvIconDurabilityCurseDef?.text = durability
        ivIconDarkBonusDarkDef?.setImageResource(R.drawable.icondarkbonus)
        tvIconDarkBonusDarkDef?.text = darkBonus
        ivIconWeightDurability?.setImageResource(R.drawable.iconweight)
        tvIconWeightDurability?.text = weight
        ivIconStrength?.setImageResource(R.drawable.iconstrength)
        tvIconStrength?.text = strength
        ivIconDexterity?.setImageResource(R.drawable.icondexterity)
        tvIconDexterity?.text = dexterity
        ivIconIntelligence?.setImageResource(R.drawable.iconintelligence)
        tvIconIntelligence?.text = intelligence
        ivIconFaith?.setImageResource(R.drawable.iconfaith)
        tvIconFaith?.text = faith

    }
}

