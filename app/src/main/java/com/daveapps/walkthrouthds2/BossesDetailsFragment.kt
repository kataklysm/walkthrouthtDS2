package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daveapps.walkthrouthds2.databinding.FragmentBossesDetailsBinding

class BossesDetailsFragment : Fragment(), ItemsAdapterItems.ClickListener {


    private var provider: String? = null
    private var boss: String? = null
    private var modalList = ArrayList<Modal>()
    private var drops = arrayOf("")
    private var images = intArrayOf()
    private var _binding: FragmentBossesDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.boss)
        setHasOptionsMenu(true)
        _binding = FragmentBossesDetailsBinding.inflate(inflater, container, false)

        boss = arguments?.getString("name")
        provider = arguments?.getString("provider")
        binding.tvBossDetails.text = boss
        binding.tvBossDetails.typeface = Typeface.createFromAsset(context?.assets,"fonts/optimussemibold.ttf")

        when(boss){
            getString(R.string.pursuer) ->{
                binding.ivBoss.setImageResource(R.drawable.pursuer)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.ringofblades)
                drops = arrayOf(getString(R.string.soul_of_the_pursuer),getString(R.string.ring_of_blades))

                binding.tvSoulsAwarded.text = 17000.toString()
            }
            getString(R.string.the_last_giant) ->{
                binding.ivBoss.setImageResource(R.drawable.thelastgiantboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.soldierkey)
                drops = arrayOf(getString(R.string.soul_of_the_last_giant),getString(R.string.soldier_key))
                binding.tvSoulsAwarded.text = 10000.toString()
            }
            getString(R.string.dragonrider) ->{
                binding.ivBoss.setImageResource(R.drawable.dragonriderboss)
                images = intArrayOf(R.drawable.bosssoul)
                drops = arrayOf(getString(R.string.dragonrider_soul))
                binding.tvSoulsAwarded.text = 12000.toString()
            }
            getString(R.string.old_dragonslayer) ->{
                binding.ivBoss.setImageResource(R.drawable.olddragonslayerboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.oldleoring)
                drops = arrayOf(getString(R.string.old_dragonslayer_soul),getString(R.string.old_leo_ring))
                binding.tvSoulsAwarded.text = 20000.toString()
            }
            getString(R.string.flexile_sentry) ->{
                binding.ivBoss.setImageResource(R.drawable.flexilesentryboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.awestone)
                drops = arrayOf(getString(R.string.flexile_sentry_soul),getString(R.string.awestone))
                binding.tvSoulsAwarded.text = 14000.toString()
            }
            getString(R.string.belfry_gargoyles) ->{
                binding.ivBoss.setImageResource(R.drawable.bellfrygargoyles)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.covetousgoldserpentring)
                drops = arrayOf(getString(R.string.belfry_gargoyles_soul),getString(R.string.covetous_gold_serpent_ring))
                binding.tvSoulsAwarded.text = 25000.toString()
            }
            getString(R.string.lost_sinner) ->{
                binding.ivBoss.setImageResource(R.drawable.lostsinnerboss)
                images = intArrayOf(R.drawable.souloftheking,R.drawable.oldsoul)
                drops = arrayOf(getString(R.string.soul_of_the_lost_sinner),getString(R.string.old_witch_soul))
                binding.tvSoulsAwarded.text = 45000.toString()
            }
            getString(R.string.ruin_sentinels) ->{
                binding.ivBoss.setImageResource(R.drawable.ruinsentinelsboss)
                images = intArrayOf(R.drawable.bosssoul)
                drops = arrayOf(getString(R.string.ruin_sentinels_soul))
                binding.tvSoulsAwarded.text = 33000.toString()
            }
            getString(R.string.the_skeleton_lords) ->{
                binding.ivBoss.setImageResource(R.drawable.theskeletonlordsboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.clearbluestonering)
                drops = arrayOf(getString(R.string.skeleton_lords_soul),getString(R.string.clear_bluestone_ring))
                binding.tvSoulsAwarded.text = 15000.toString()
            }
            getString(R.string.executioners_chariot) ->{
                binding.ivBoss.setImageResource(R.drawable.executionerschariot)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.chloranthyring)
                drops = arrayOf(getString(R.string.executioners_chariot_soul),getString(R.string.chloranthy_ring))
                binding.tvSoulsAwarded.text = 19000.toString()
            }
            getString(R.string.covetous_demon) ->{
                binding.ivBoss.setImageResource(R.drawable.covetousdemon)
                images = intArrayOf(R.drawable.bosssoul)
                drops = arrayOf(getString(R.string.covetous_demon_soul))
                binding.tvSoulsAwarded.text = 13000.toString()
            }
            getString(R.string.mytha_the_baneful_queen) ->{
                binding.ivBoss.setImageResource(R.drawable.mythathebanefulqueen)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.covetousgoldserpentring)
                drops = arrayOf(getString(R.string.mytha_the_baneful_queen_soul),getString(R.string.covetous_gold_serpent_ring))
                binding.tvSoulsAwarded.text = 20000.toString()
            }
            getString(R.string.smelter_demon) ->{
                binding.ivBoss.setImageResource(R.drawable.smelterdemonboss)
                images = intArrayOf(R.drawable.bosssoul)
                drops = arrayOf(getString(R.string.smelter_demon_soul))
                binding.tvSoulsAwarded.text = 32000.toString()
            }
            getString(R.string.old_iron_king) ->{
                binding.ivBoss.setImageResource(R.drawable.oldironkingboss)
                images = intArrayOf(R.drawable.souloftheking,R.drawable.oldsoul)
                drops = arrayOf(getString(R.string.old_iron_king_soul),getString(R.string.old_king_soul))
                binding.tvSoulsAwarded.text = 48000.toString()
            }
            getString(R.string.royal_rat_vanguard) ->{
                binding.ivBoss.setImageResource(R.drawable.royalratvanguardboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.rattail)
                drops = arrayOf(getString(R.string.royal_rat_vanguard_soul),getString(R.string.rat_tail))
                binding.tvSoulsAwarded.text = 11000.toString()
            }
            getString(R.string.the_rotten) ->{
                binding.ivBoss.setImageResource(R.drawable.therottenboss)
                images = intArrayOf(R.drawable.souloftheking,R.drawable.oldsoul)
                drops = arrayOf(getString(R.string.soul_of_the_rotten),getString(R.string.old_dead_ones_soul))
                binding.tvSoulsAwarded.text = 47000.toString()
            }
            getString(R.string.scorpioness_najka) ->{
                binding.ivBoss.setImageResource(R.drawable.scorpionessnajkaboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.southernritual)
                drops = arrayOf(getString(R.string.scorpioness_najka_soul),getString(R.string.southern_ritual_band))
                binding.tvSoulsAwarded.text = 23000.toString()
            }
            getString(R.string.royal_rat_authority) ->{
                binding.ivBoss.setImageResource(R.drawable.royalratauthorityboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.rattail)
                drops = arrayOf(getString(R.string.royal_rat_authority_suol),getString(R.string.rat_tail))
                binding.tvSoulsAwarded.text = 14000.toString()
            }
            getString(R.string.guardian_dragon) ->{
                binding.ivBoss.setImageResource(R.drawable.guardiandragonboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.firetempest)
                drops = arrayOf(getString(R.string.guardian_dragon_soul),getString(R.string.fire_tempest))
                binding.tvSoulsAwarded.text = 38000.toString()
            }
            getString(R.string.prowling_magus_and_congregation) ->{
                binding.ivBoss.setImageResource(R.drawable.prowlingmagusandcongregationboss)
                images = intArrayOf(R.drawable.titaniteslab)
                drops = arrayOf(getString(R.string.titanite_slab))
                binding.tvSoulsAwarded.text = 7000.toString()

            }
            getString(R.string.looking_glass_knight) ->{
                binding.ivBoss.setImageResource(R.drawable.lookingglassknight)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.ringofthesteelprotection)
                drops = arrayOf(getString(R.string.looking_glass_knight_soul),getString(R.string.ring_of_the_steel_protection))
                binding.tvSoulsAwarded.text = 25500.toString()
            }
            getString(R.string.demon_of_song) ->{
                binding.ivBoss.setImageResource(R.drawable.demonofsongboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.keytotheembedded)
                drops = arrayOf(getString(R.string.demon_of_song_soul),getString(R.string.key_to_the_embedded))
                binding.tvSoulsAwarded.text = 26000.toString()
            }
            getString(R.string.velstadt_the_royal_aegis) ->{
                binding.ivBoss.setImageResource(R.drawable.velstadttheroyalaegisboss)
                images = intArrayOf(R.drawable.defendersoul,R.drawable.royalsoldiersring)
                drops = arrayOf(getString(R.string.soul_of_velstadt),getString(R.string.royal_soldiers_ring))
                binding.tvSoulsAwarded.text = 50000.toString()
            }
            getString(R.string.vendrick) ->{
                binding.ivBoss.setImageResource(R.drawable.vendrick)
                images = intArrayOf(R.drawable.souloftheking)
                drops = arrayOf(getString(R.string.soul_of_the_king))
                binding.tvSoulsAwarded.text = 90000.toString()
            }
            getString(R.string.ancient_dragon) ->{
                binding.ivBoss.setImageResource(R.drawable.ancientdragonboss)
                images  = intArrayOf(R.drawable.soulofagiant,R.drawable.ashenmistheart,R.drawable.petrifieddragonbone)
                drops = arrayOf(getString(R.string.soul_of_a_giant),getString(R.string.ashen_mist_heart),getString(R.string.petrified_dragon_bone))
                binding.tvSoulsAwarded.text = 120000.toString()
            }
            getString(R.string.the_dukes_dear_freja) ->{
                binding.ivBoss.setImageResource(R.drawable.dukesdearfrejaboss)
                images = intArrayOf(R.drawable.bosssoul,R.drawable.oldsoul)
                drops = arrayOf(getString(R.string.soul_of_the_dukes_dear_freja),getString(R.string.old_paledrake_soul))
                binding.tvSoulsAwarded.text = 42000.toString()
            }
            getString(R.string.giant_lord) ->{
                binding.ivBoss.setImageResource(R.drawable.giantlordboss)
                images = intArrayOf(R.drawable.souloftheking,R.drawable.giantskinship)
                drops = arrayOf(getString(R.string.giant_lord_soul),getString(R.string.giants_kinship))
                binding.tvSoulsAwarded.text = 75000.toString()
            }
            getString(R.string.throne_watcher_and_throne_defender) ->{
                binding.ivBoss.setImageResource(R.drawable.thronewatcherandthronedefenderboss)
                images = intArrayOf(R.drawable.defendersoul,R.drawable.defendersoul,R.drawable.ringoftheevileye)
                drops = arrayOf(getString(R.string.throne_watcher_soul),getString(R.string.throne_defender_soul),getString(R.string.ring_of_the_evil_eye))
                binding.tvSoulsAwarded.text = 68000.toString()
            }
            getString(R.string.nashandra) ->{
                binding.ivBoss.setImageResource(R.drawable.nashandraboss)
                images = intArrayOf(R.drawable.soulofnashandra)
                drops = arrayOf(getString(R.string.soul_of_nashandra))
                binding.tvSoulsAwarded.text = 90000.toString()
            }
            getString(R.string.aldia_scholar_of_the_first_sin) ->{
                binding.ivBoss.setImageResource(R.drawable.aldiascholarfirstsinboss)
                images = intArrayOf(0)
                drops = arrayOf("")
                binding.tvSoulsAwarded.text = 0.toString()
            }
        }

        for (items in drops.indices)modalList.add(Modal(this.drops[items],images[items]))

        val adapterItems = ItemsAdapterItems(this.requireContext(),this)
        adapterItems.setData(modalList)
        binding.gridViewBossesDrops.adapter = adapterItems
        binding.gridViewBossesDrops.onItemClickListener

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

    override fun clickedItem(itemsModalItems: Modal) {

        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }


}