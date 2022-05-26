package com.daveapps.walkthrouthds2

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*
import kotlin.collections.ArrayList

class ItemsAdapterLocations(var clickListener: ClickListener) : Adapter<ItemsAdapterLocations.ItemsAdapterVH>(), Filterable {


    var itemsModalList = ArrayList<ItemsModalLocations>()
    var itemsModalListFilter = ArrayList<ItemsModalLocations>()

    fun setData(itemsModalList: ArrayList<ItemsModalLocations>){
        this.itemsModalList = itemsModalList
        this.itemsModalListFilter = itemsModalList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        val root = ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items_locations,parent,false))
        root.location.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        root.nextLocation.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        root.bosses.typeface = Typeface.createFromAsset(parent.context.assets,"fonts/optimussemibold.ttf")
        return root
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position]
        holder.location.text = itemsModal.location
        holder.nextLocation.text = itemsModal.nextLocation
        holder.bosses.text = itemsModal.bosess
        holder.bonfires.text = itemsModal.bonfires
        holder.image.setImageResource(itemsModal.image)
        holder.itemView.setOnClickListener {
            clickListener.clickedItemLocations(itemsModal)
        }
    }

    class ItemsAdapterVH(itemView: View) : ViewHolder(itemView){
        val location: TextView = itemView.findViewById(R.id.tvLocation)
        val nextLocation: TextView = itemView.findViewById(R.id.tvNextLocation)
        val bosses: TextView = itemView.findViewById(R.id.tvLocationBosses)
        val bonfires: TextView = itemView.findViewById(R.id.tvBonfires)
        val image: ImageView = itemView.findViewById(R.id.imageView)
    }

    interface ClickListener{
        fun clickedItemLocations(itemsModalLocations: ItemsModalLocations)
    }

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charsequence == null || charsequence.length < 0 ){
                    filterResults.count = itemsModalListFilter.size
                    filterResults.values = itemsModalListFilter
                }else{
                    val searchChr = charsequence.toString().lowercase(Locale.ROOT)
                    val itemModal = ArrayList<ItemsModalLocations>()
                    for (item in itemsModalListFilter) {
                        if(item.location.lowercase(Locale.ROOT).contains(searchChr)){
                            itemModal.add(item)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults!!.values as ArrayList<ItemsModalLocations>
                notifyDataSetChanged()
            }

        }
    }
}