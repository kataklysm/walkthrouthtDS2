package com.daveapps.walkthrouthds2

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
import androidx.fragment.app.FragmentTransaction
import com.daveapps.walkthrouthds2.databinding.FragmentSpellsBinding


class SpellsFragment : Fragment(), ItemsAdapterItems.ClickListener {
    private var _binding: FragmentSpellsBinding? = null
    private val binding get() = _binding!!
    private var provider: String? = null
    private var transaction: FragmentTransaction? = null
    private var spellName = arrayListOf("")
    private var spellImage = intArrayOf()


    private var modalListPyromancies = ArrayList<Modal>()
    private var modalListHexes = ArrayList<Modal>()
    private var modalListSorceries = ArrayList<Modal>()
    private var modalListMiracles = ArrayList<Modal>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.spells)
        _binding = FragmentSpellsBinding.inflate(inflater,container,false)
        provider = arguments?.getString("provider")


        ////////////////////////////////////////////////////////////////////////////////////////////PYROMANCIES//////////////////////////////////////////////////////////////
        spellImage = intArrayOf(R.drawable.acidsurge,R.drawable.chaosstorm,R.drawable.combustion,R.drawable.danceoffire,R.drawable.fireball,R.drawable.fireorb,R.drawable.firesnake,R.drawable.firestorm,
            R.drawable.firetempest,R.drawable.firewhip,R.drawable.flameswathe,R.drawable.flameweapon,R.drawable.flashsweat,R.drawable.forbiddensun,R.drawable.greatchaosfireball,R.drawable.greatcombustion,
            R.drawable.greatfireball,R.drawable.immolation,R.drawable.ironflesh,R.drawable.lingeringflame,R.drawable.outcry,R.drawable.poisonmist,R.drawable.toxicmist,R.drawable.warmth)
        spellName = arrayListOf(getString(R.string.acid_surge),getString(R.string.chaos_storm),getString(R.string.combustion),getString(R.string.dance_of_fire),getString(R.string.fireball),getString(R.string.fire_orb),getString(R.string.fire_snake),getString(R.string.fire_storm),
            getString(R.string.fire_tempest),getString(R.string.fire_whip),getString(R.string.flame_swathe),getString(R.string.flame_weapon),getString(R.string.flash_sweat),getString(R.string.forbidden_sun),getString(R.string.great_chaos_fireball),getString(R.string.great_combustion),
            getString(R.string.great_fireball),getString(R.string.immolation),getString(R.string.iron_flesh),getString(R.string.lingering_flame),getString(R.string.outcry),getString(R.string.poison_mist),getString(R.string.toxic_mist),getString(R.string.warmth))

        for (items in spellName.indices) if (modalListPyromancies.size < 25) modalListPyromancies.add(Modal(this.spellName[items],spellImage[items]))
        var adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListPyromancies)
        binding.gridViewPyromancies.adapter = adapter
        binding.gridViewPyromancies.onItemClickListener
        binding.tvExpandListPyromancies.setOnClickListener {
            expandList(binding.gridViewPyromancies,binding.ivExpandIconPyromancies)
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////HEXES/////////////////////////////////////////////////////
        spellImage = intArrayOf(R.drawable.affinity,R.drawable.climax,R.drawable.darkstorm,R.drawable.darkdance,R.drawable.darkfog,R.drawable.darkgreatsword,R.drawable.darkhail,R.drawable.darkorb,
            R.drawable.darkweapon,R.drawable.deadagain,R.drawable.greatresonantsoul,R.drawable.lifedrainpatch,R.drawable.numbness,R.drawable.profoundstill,R.drawable.promisedwalkofpeace,
            R.drawable.recollection,R.drawable.repel,R.drawable.resonantflesh,R.drawable.resonantsoul,R.drawable.resonantweapon,R.drawable.scrapsoflife,R.drawable.twistedbarricade,R.drawable.whisperofdespair)
        spellName = arrayListOf(getString(R.string.affinity),getString(R.string.climax),getString(R.string.darkstorm),getString(R.string.dark_dance),getString(R.string.dark_fog),getString(R.string.dark_greatsword),getString(R.string.dark_hail),getString(R.string.dark_orb),
            getString(R.string.dark_weapon),getString(R.string.dead_again),getString(R.string.great_resonant_soul),getString(R.string.lifedrain_patch),getString(R.string.numbness),getString(R.string.profound_still), getString(R.string.promisedwalkofpeace),
            getString(R.string.recollection),getString(R.string.repel),getString(R.string.resonant_flesh),getString(R.string.resonant_soul), getString(R.string.resonant_weapon),getString(R.string.scraps_of_life),getString(R.string.twisted_barricade),getString(R.string.whisper_of_despair),
        )

        for (items in spellName.indices) if (modalListHexes.size < 23) modalListHexes.add(Modal(this.spellName[items],spellImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListHexes)
        binding.gridViewHexes.adapter = adapter
        binding.gridViewHexes.onItemClickListener
        binding.tvExpandListHexes.setOnClickListener {
            expandList(binding.gridViewHexes,binding.ivExpandIconHexes)
        }

        ////////////////////////////////////////////////////////////////////////////////////////////SORCERIES//////////////////////////////////////////////////////////////
        spellImage = intArrayOf(R.drawable.castlight,R.drawable.chameleon,R.drawable.crystalmagicweapon,R.drawable.crystalsoulspear,R.drawable.fallcontrol,R.drawable.focussouls,R.drawable.greatheavysoularrow,
            R.drawable.greatmagicweapon,R.drawable.greatsoularrow,R.drawable.heavyhomingsoularrow,R.drawable.heavysoularrow,R.drawable.hiddenweapon,R.drawable.homingcrystalsoulmass,R.drawable.homingsoularrow,
            R.drawable.homingsoulmass,R.drawable.hush,R.drawable.magicweapon,R.drawable.repair,R.drawable.shockwave,R.drawable.soularrow,R.drawable.soulbolt,R.drawable.soulflash,R.drawable.soulgeyser,
            R.drawable.soulgreatsword,R.drawable.soulshower,R.drawable.soulspear,R.drawable.soulspearbarrage,R.drawable.soulvortex,R.drawable.strongmagicshield,R.drawable.unleashmagic,R.drawable.yearn)
        spellName = arrayListOf(getString(R.string.cast_light),getString(R.string.chameleon),getString(R.string.crystal_magic_weapon),getString(R.string.crystal_soul_spear),getString(R.string.fall_control),getString(R.string.focus_souls),getString(R.string.great_heavy_soul_arrow),
            getString(R.string.great_magic_weapon),getString(R.string.great_soul_arrow),getString(R.string.heavy_homing_soul_arrow),getString(R.string.heavy_soul_arrow),getString(R.string.hidden_weapon),getString(R.string.homing_crystal_soulmass),
            getString(R.string.homing_soul_arrow),getString(R.string.homing_soul_mass),getString(R.string.hush),getString(R.string.magic_weapon),getString(R.string.repair),getString(R.string.shockwave),getString(R.string.soul_arrow),getString(R.string.soul_bolt),getString(R.string.soul_flash), getString(R.string.soul_geyser),
            getString(R.string.soul_greatsword),getString(R.string.soul_shower),getString(R.string.soul_spear),getString(R.string.soul_spear_barrage),getString(R.string.soul_vortex), getString(R.string.strong_magic_shield),getString(R.string.unleash_magic),getString(R.string.yearn))

        for (items in spellName.indices) if (modalListSorceries.size < 31) modalListSorceries.add(Modal(this.spellName[items],spellImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListSorceries)
        binding.gridViewSorceries.adapter = adapter
        binding.gridViewSorceries.onItemClickListener
        binding.tvExpandListSorceries.setOnClickListener {
            expandList(binding.gridViewSorceries,binding.ivExpandIconSorceries)
        }

        ////////////////////////////////////////////////////////////////////////////////////////////MIRACLES//////////////////////////////////////////////////////////////
        spellImage = intArrayOf(R.drawable.blindingbolt,R.drawable.bountifulsunlight,R.drawable.caressingprayer,R.drawable.denial,R.drawable.emitforce,R.drawable.force,R.drawable.greatheal,
            R.drawable.greathealexcerpt,R.drawable.greatlightningspear,R.drawable.greatmagicbarrier,R.drawable.guidance,R.drawable.heal,R.drawable.heavenlythunder,R.drawable.homeward,R.drawable.lightningspear,
            R.drawable.magicbarrier,R.drawable.medheal,R.drawable.perseverance,R.drawable.replenishment,R.drawable.resplendentlife,R.drawable.sacredoath,R.drawable.soothingsunlight,R.drawable.soulappease,
            R.drawable.splinteringlightningspear,R.drawable.sunlightblade,R.drawable.sunlightspear,R.drawable.unveil,R.drawable.wrathofthegods)
        spellName = arrayListOf(getString(R.string.blinding_bolt),getString(R.string.bountiful_sunlight),getString(R.string.caressing_prayer),getString(R.string.denial),getString(R.string.emit_force),getString(R.string.force),getString(R.string.great_heal),
            getString(R.string.great_heal_excerpt),getString(R.string.great_lightning_spear),getString(R.string.great_magic_barrier),getString(R.string.guidance),getString(R.string.heal),getString(R.string.heavenly_thunder),getString(R.string.homeward),getString(R.string.lightning_spear),
            getString(R.string.magic_barrier),getString(R.string.med_heal),getString(R.string.perseverance),getString(R.string.replenishment),getString(R.string.resplendent_life),getString(R.string.sacred_oath),getString(R.string.soothing_sunlight),getString(R.string.soul_appease),
            getString(R.string.splintering_lightning_spear),getString(R.string.sunlight_blade),getString(R.string.sunlight_spear),getString(R.string.unveil),getString(R.string.wrath_of_the_gods))

        for (items in spellName.indices) if (modalListMiracles.size < 28) modalListMiracles.add(Modal(this.spellName[items],spellImage[items]))
        adapter = ItemsAdapterItems(this.requireContext(),this)
        adapter.setData(modalListMiracles)
        binding.gridViewMiracles.adapter = adapter
        binding.gridViewMiracles.onItemClickListener
        binding.tvExpandListMiracles.setOnClickListener {
            expandList(binding.gridViewMiracles,binding.ivExpandIconMiracles)
        }


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