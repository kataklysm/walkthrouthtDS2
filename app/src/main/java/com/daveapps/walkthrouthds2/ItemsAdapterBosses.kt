package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daveapps.walkthrouthds2.ItemsAdapterBosses.ItemsAdapterVH
import java.util.*
import kotlin.collections.ArrayList


class ItemsAdapterBosses (var clickListener: ClickListener):RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<ItemsModalBosses>()
    var itemsModalFilter = ArrayList<ItemsModalBosses>()

    fun setData(itemsModalList: ArrayList<ItemsModalBosses>){
        this.itemsModalList = itemsModalList
        this.itemsModalFilter = itemsModalList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        val root = ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items_bosses,parent,false))
        root.boss.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        root.weakens.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        root.resistance.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        return root
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position]
        holder.boss.text = itemsModal.boss
        holder.hp.text = itemsModal.hp
        holder.weakens.text = itemsModal.weakness
        holder.resistance.text = itemsModal.resistance
        holder.imagen.setImageResource(itemsModal.image)
        holder.itemView.setOnClickListener {
            clickListener.clickedItemBosses(itemsModal)
        }

    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val boss: TextView = itemView.findViewById(R.id.tvBoss)
        val hp: TextView = itemView.findViewById(R.id.tvHP)
        val weakens: TextView = itemView.findViewById(R.id.tvWeakness)
        val resistance: TextView = itemView.findViewById(R.id.tvResistance)
        val imagen: ImageView = itemView.findViewById(R.id.ivBosses)


    }

    interface ClickListener{
        fun clickedItemBosses(itemsModalBosses: ItemsModalBosses)
    }

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charsequence == null || charsequence.length < 0){
                    filterResults.count = itemsModalFilter.size
                    filterResults.values = itemsModalFilter
                }else{
                    val searchChr = charsequence.toString().lowercase(Locale.ROOT)
                    val itemModal = ArrayList<ItemsModalBosses>()
                    for (item in itemsModalFilter){
                        if (item.boss.lowercase(Locale.ROOT).contains(searchChr)){
                            itemModal.add(item)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults!!.values as ArrayList<ItemsModalBosses>
                notifyDataSetChanged()
            }

        }
    }

}