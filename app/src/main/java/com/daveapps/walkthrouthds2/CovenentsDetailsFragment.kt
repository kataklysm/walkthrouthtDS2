package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import com.daveapps.walkthrouthds2.databinding.FragmentCharactersDetailsBinding
import com.daveapps.walkthrouthds2.databinding.FragmentCovenentsDetailsBinding


class CovenentsDetailsFragment : Fragment(), ItemsAdapterItems.ClickListener{
    private var _binding: FragmentCovenentsDetailsBinding? = null
    private val binding get( ) = _binding!!
    private lateinit var communicator: Communicator
    private var modalListItems = ArrayList<Modal>()
    private var modalListItems1 = ArrayList<Modal>()
    private var modalListItems2 = ArrayList<Modal>()
    private var modalListItems3 = ArrayList<Modal>()
    private var items = arrayOf("")
    private var itemsImages = intArrayOf()
    private var items1 = arrayOf("")
    private var itemsImages1 = intArrayOf()
    private var items2 = arrayOf("")
    private var itemsImages2 = intArrayOf()
    private var items3 = arrayOf("")
    private var itemsImages3 = intArrayOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.covenant)
        _binding = FragmentCovenentsDetailsBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        communicator = activity as Communicator
        val covenant = arguments?.getString("name")
        binding.tvCovenant.typeface = Typeface.createFromAsset(context?.assets, "fonts/optimussemibold.ttf")
        binding.tvCovenantsDescription.typeface = Typeface.createFromAsset(context?.assets,"fonts/optimussemibold.ttf")
        val adapter = ItemsAdapterItems(this.requireContext(),this)
        val adapter1 = ItemsAdapterItems(this.requireContext(),this)
        val adapter2 = ItemsAdapterItems(this.requireContext(),this)
        val adapter3 = ItemsAdapterItems(this.requireContext(),this)

        binding.tvRank.text = "1"
        binding.tvRank1.text = "2"
        binding.tvRank2.text = "3"
        binding.tvRank3.text = "4"
        when (covenant){
            getString(R.string.bell_keeper) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                    getString(R.string.bell_keeper_covenant_des),R.drawable.bellkeeperscovenant,R.drawable.bellkeepersseal,getString(R.string.bell_keepers_seal),
                    R.drawable.titaniteslab,getString(R.string.titanite_slab),R.drawable.hiddenweapon,getString(R.string.hidden_weapon),R.drawable.bellkeeperbellyband,getString(R.string.bell_keeper_bellyband),
                    getString(R.string.defeat)+" "+0+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+10+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+30+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+100+" \n"+getString(R.string.trespassers))
            }
            getString(R.string.blue_sentinels) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.blue_sentinels_covenant_des),R.drawable.bluesentinelscovenant,R.drawable.guardiansseal,getString(R.string.guardians_seal),
                    R.drawable.spirittreeshield,getString(R.string.spirit_tree_shield),R.drawable.wrathofthegods,getString(R.string.wrath_of_the_gods),R.drawable.bountifulsunlight,getString(R.string.bountiful_sunlight),
                    "0 "+getString(R.string.victories),
                    "50 "+getString(R.string.victories),
                    "150 "+getString(R.string.victories),
                    "500 "+getString(R.string.victories))
            }
            getString(R.string.heirs_of_the_sun) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.heirs_of_the_sun_des),R.drawable.heirsofthesuncovenant,R.drawable.sunseal,getString(R.string.sun_seal),
                    R.drawable.sunlightparma,getString(R.string.sunlight_parma),R.drawable.sunsword,getString(R.string.sun_sword),R.drawable.sunlightspear,getString(R.string.sunlight_spear),
                    getString(R.string.initial),
                    "10 \n"+getString(R.string.sunlight_medal),
                    "20 \n"+getString(R.string.sunlight_medal),
                    "30 \n"+getString(R.string.sunlight_medal))
            }
            getString(R.string.way_of_blue) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.way_of_blue_des),R.drawable.wayofbluecovenant,R.drawable.blueseal,getString(R.string.blue_seal),
                R.drawable.bloodbitering,getString(R.string.bloodbite_ring),R.drawable.hush,getString(R.string.hush),R.drawable.bluetearstonering,getString(R.string.blue_tearstone_ring),
                    getString(R.string.defeat)+" "+0+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+1+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+5+" \n"+getString(R.string.trespassers),
                    getString(R.string.defeat)+" "+10+" \n"+getString(R.string.trespassers))
            }
            getString(R.string.brotherhood_of_blood) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.brotherhood_of_blood_des),R.drawable.brotherhoodofbloodcovenant,R.drawable.crestofblood,getString(R.string.crest_of_blood),
                R.drawable.curvedtwinblade,getString(R.string.curved_twinblade),R.drawable.crescentsickle,getString(R.string.crescent_sickle),R.drawable.greatchaosfireball,getString(R.string.great_chaos_fireball),
                "0 "+getString(R.string.points),
                "50 "+getString(R.string.points),
                "150 "+getString(R.string.points),
                "500 "+getString(R.string.points))
            }
            getString(R.string.rat_king_covenant) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.rat_king_covenant_des),R.drawable.ratkingcovenant,R.drawable.crestoftherat,getString(R.string.crest_of_the_rat),
                R.drawable.smallsmoothandsilkystone,getString(R.string.small_smooth_silky_stone),R.drawable.smoothandsilkystone,getString(R.string.smooth_and_silky_stone),R.drawable.slumberingdragoncrestring,getString(R.string.slumbering_dragon_crest_ring),
                 "0 "+getString(R.string.rat_tail),
                "10 "+getString(R.string.rat_tail),
                "20 "+getString(R.string.rat_tail),
                "35 "+getString(R.string.rat_tail))
            }
            getString(R.string.dragon_remnants) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.dragon_remnants_des),R.drawable.dragonremnantscovenant,R.drawable.dragoneye,getString(R.string.dragon_eye),
                R.drawable.dragonheadstone,getString(R.string.dragon_head_stone),R.drawable.dragontorsostone,getString(R.string.dragon_torso_stone),R.drawable.blackdragongreatsword,getString(R.string.black_dragon_greatsword),
                "0 \n"+getString(R.string.dragon_scale),
                "10 "+getString(R.string.dragon_scale),
                "20 "+getString(R.string.dragon_scale),
                "30 "+getString(R.string.dragon_scale))
            }
            getString(R.string.company_of_champions) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.company_of_champions_des),R.drawable.companyofchampionscovenant,R.drawable.championstablet,getString(R.string.champions_tablet),
                R.drawable.greatmagicweapon,getString(R.string.great_magic_weapon),R.drawable.firstdragonring,getString(R.string.first_dragon_ring),R.drawable.vanquishersseal,getString(R.string.vanquishers_seal),
                "0 "+getString(R.string.awestone),
                    "10 "+getString(R.string.awestone),
                    "25 "+getString(R.string.awestone),
                    "50 "+getString(R.string.awestone))
            }
            getString(R.string.pilgrims_of_dark) ->{
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3,
                getString(R.string.pilgrims_of_dark_des),R.drawable.pilgrimsofdarkcovenant,R.drawable.abyssseal,getString(R.string.abyss_seal),
                R.drawable.resonantsoul,getString(R.string.resonant_soul),R.drawable.greatresonantsoul,getString(R.string.great_resonant_soul),R.drawable.climax,getString(R.string.climax),
                getString(R.string.initial),
                getString(R.string.rank1),
                getString(R.string.rank2),
                getString(R.string.defeat)+" "+getString(R.string.darklurker))
            }
        }




        return binding.root
    }

    private fun setCovenantData(covenant:String,adapter:ItemsAdapterItems,adapter1:ItemsAdapterItems,adapter2:ItemsAdapterItems,adapter3:ItemsAdapterItems,
                                covenantDes:String,covenantImg:Int,ranking0img:Int,ranking0String:String,ranking1img:Int,ranking1String:String,
                                ranking2img:Int,ranking2String:String,ranking3img:Int,ranking3String:String,
                                ranking:String,ranking1:String,ranking2:String,ranking3:String){
        binding.ivCovenant.setImageResource(covenantImg)
        binding.tvCovenant.text = covenant
        binding.tvVictories.text = ranking
        binding.tvVictories1.text = ranking1
        binding.tvVictories2.text = ranking2
        binding.tvVictories3.text = ranking3
        binding.tvCovenantsDescription.text = covenantDes
        itemsImages = intArrayOf(ranking0img)
        items = arrayOf(ranking0String)
        itemsImages1 = intArrayOf(ranking1img)
        items1 = arrayOf(ranking1String)
        itemsImages2 = intArrayOf(ranking2img)
        items2 = arrayOf(ranking2String)
        itemsImages3 = intArrayOf(ranking3img)
        items3 = arrayOf(ranking3String)
        for (items in items.indices){
            if (modalListItems.size < 1){
                modalListItems.add(Modal(this.items[items],itemsImages[items]))
                adapter.setData(modalListItems)
                binding.gridViewCovenantsItems.adapter = adapter
                binding.gridViewCovenantsItems.onItemClickListener

                modalListItems1.add(Modal(this.items1[items],itemsImages1[items]))
                adapter1.setData(modalListItems1)
                binding.gridViewCovenantsItems1.adapter = adapter1
                binding.gridViewCovenantsItems1.onItemClickListener

                modalListItems2.add(Modal(this.items2[items],itemsImages2[items]))
                adapter2.setData(modalListItems2)
                binding.gridViewCovenantsItems2.adapter = adapter2
                binding.gridViewCovenantsItems2.onItemClickListener

                modalListItems3.add(Modal(this.items3[items],itemsImages3[items]))
                adapter3.setData(modalListItems3)
                binding.gridViewCovenantsItems3.adapter = adapter3
                binding.gridViewCovenantsItems3.onItemClickListener
            }
        }
    }

    override fun clickedItem(itemsModalItems: Modal) {
        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }

}