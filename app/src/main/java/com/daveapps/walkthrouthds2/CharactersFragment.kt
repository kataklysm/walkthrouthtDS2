package com.daveapps.walkthrouthds2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daveapps.walkthrouthds2.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment(),ItemsAdapterItems.ClickListener {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: Communicator
    private var modalListCharacters = ArrayList<Modal>()
    private var characterNames = arrayListOf("")
    private var characterImages = intArrayOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.characters)
        _binding = FragmentCharactersBinding.inflate(inflater,container,false)
        communicator = activity as Communicator


        ///////////////////////////////////////////////////
        characterImages = intArrayOf(R.drawable.strowenframe,R.drawable.milibethframe,R.drawable.dynatillo,R.drawable.shanalotteframe,R.drawable.sauldenframe,R.drawable.lenigrastframe,R.drawable.shalquoirframe,
            R.drawable.melentiaframe, R.drawable.armourerframe,R.drawable.carhillionframe, R.drawable.rosabethframe,R.drawable.caleframe,R.drawable.chloanneframe,R.drawable.gilliganframe,R.drawable.liciaframe,
            R.drawable.pateframe,R.drawable.targrayframe,R.drawable.gavlanframe,R.drawable.lucatielframe,R.drawable.mcduffframe,R.drawable.straidframe,R.drawable.felkinframe,R.drawable.grenframe,
            R.drawable.mageroldframe,R.drawable.bellkeeperframe,R.drawable.ratkingframe,R.drawable.grandahlframe,R.drawable.vengarlframe,R.drawable.creightonframe,R.drawable.tarkframe,R.drawable.ornifexframe,
            R.drawable.cromwellframe,R.drawable.wellagerframe,R.drawable.milfanitoframe,R.drawable.agdayneframe,R.drawable.navlaanframe)
        characterNames = arrayListOf(getString(R.string.strowen),getString(R.string.milibeth),getString(R.string.dynatillo),getString(R.string.emerald_herald),getString(R.string.saulden),getString(R.string.lenigrast),getString(R.string.shalquoir),
            getString(R.string.melentia),getString(R.string.maughlin_the_armourer),getString(R.string.carhillion),getString(R.string.rosabeth),getString(R.string.cale_the_cartographer),getString(R.string.stone_trader_chloanne),getString(R.string.laddersmith_gilligan),getString(R.string.licia_of_lindelt),
            getString(R.string.mild_mannered_pate),getString(R.string.blue_sentinel_targray),getString(R.string.lonesome_gavlan),getString(R.string.lucatiel_of_mirrah),getString(R.string.steady_hand_mcduff),getString(R.string.straid_of_olaphis),getString(R.string.felkin_the_outcast),getString(R.string.titchy_gren),
            getString(R.string.magerold_of_lanafir),getString(R.string.bell_keeper),getString(R.string.rat_king),getString(R.string.darkdiver_grandahl),getString(R.string.head_of_vengarl),getString(R.string.creighton_of_mirrah),getString(R.string.manscorpion_tark),getString(R.string.weaponsmith_ornifex),
            getString(R.string.cromwell_the_pardoner),getString(R.string.chancellor_wellager),getString(R.string.milfanito),getString(R.string.grave_warden_agdayne),getString(R.string.royal_sorcerer_navlaan))

        for (items in characterNames.indices) if(modalListCharacters.size < 36 ) modalListCharacters.add(Modal(this.characterNames[items],characterImages[items]))

        val adapterItems = ItemsAdapterItems(this.requireContext(),this)
        adapterItems.setData(modalListCharacters)
        binding.gridViewCharacters.adapter = adapterItems
        binding.gridViewCharacters.onItemClickListener

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
        Log.e("TAG CHARACTER", itemsModalItems.item.toString())
        when(itemsModalItems.item){
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
            getString(R.string.royal_sorcerer_navlaan) -> communicator.passDataCom(itemsModalItems.item.toString(),"charactersFragment")
        }
    }


}