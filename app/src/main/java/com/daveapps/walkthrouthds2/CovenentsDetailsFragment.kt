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
                setCovenantData(covenant,adapter,adapter1,adapter2,adapter3)




            }
            getString(R.string.blue_sentinels) ->{

            }
        }




        return binding.root
    }

    private fun setCovenantData(covenant: String, adapter:ItemsAdapterItems,adapter1:ItemsAdapterItems,adapter2:ItemsAdapterItems,adapter3:ItemsAdapterItems){
        binding.ivCovenant.setImageResource(R.drawable.bellkeeperscovenant)
        binding.tvCovenant.text = covenant
        if (covenant == getString(R.string.bell_keeper)){
            binding.tvVictories.text = "0"
            binding.tvVictories1.text = "0-10"
            binding.tvVictories2.text = "10-30"
            binding.tvVictories3.text = "30-100"
            binding.tvCovenantsDescription.text = getString(R.string.bell_keeper_covenant_des)
            itemsImages = intArrayOf(R.drawable.bellkeepersseal)
            items = arrayOf(getString(R.string.bell_keepers_seal))

            for (items in items.indices){
                if (modalListItems.size < 1){
                    modalListItems.add(Modal(this.items[items],itemsImages[items]))
                    adapter.setData(modalListItems)
                    binding.gridViewCovenantsItems.adapter = adapter
                    binding.gridViewCovenantsItems.onItemClickListener
                }
            }
            itemsImages1 = intArrayOf(R.drawable.titaniteslab)
            items1 = arrayOf(getString(R.string.titanite_slab))
            for (items in items1.indices){
                if (modalListItems1.size < 1) {
                    modalListItems1.add(Modal(this.items1[items],itemsImages1[items]))
                    adapter1.setData(modalListItems1)
                    binding.gridViewCovenantsItems1.adapter = adapter1
                    binding.gridViewCovenantsItems1.onItemClickListener
                }
            }

            itemsImages2 = intArrayOf(R.drawable.hiddenweapon)
            items2 = arrayOf(getString(R.string.hidden_weapon))
            for (items in items2.indices){
                if (modalListItems2.size < 1){
                    modalListItems2.add(Modal(this.items2[items],itemsImages2[items]))
                    adapter2.setData(modalListItems2)
                    binding.gridViewCovenantsItems2.adapter = adapter2
                    binding.gridViewCovenantsItems2.onItemClickListener
                }
            }

            itemsImages3 = intArrayOf(R.drawable.bellkeeperbellyband)
            items3 = arrayOf(getString(R.string.bell_keeper_bellyband))
            for (items in items3.indices){
                if (modalListItems3.size < 1) {
                    modalListItems3.add(Modal(this.items3[items],itemsImages3[items]))
                    adapter3.setData(modalListItems3)
                    binding.gridViewCovenantsItems3.adapter = adapter3
                    binding.gridViewCovenantsItems3.onItemClickListener
                }
            }
        }



    }

    override fun clickedItem(itemsModalItems: Modal) {
        if (!SetDataDialog(this.requireContext(),itemsModalItems.item.toString()).setDataDialog()){
            SetDialogData(this.requireContext(),itemsModalItems.item.toString()).setDialogData()
        }
    }

}