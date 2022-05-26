package com.daveapps.walkthrouthds2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*
import kotlin.collections.ArrayList

class ItemsAdapterItems(var context: Context,var clickListener: ClickListener): BaseAdapter() ,Filterable {
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var itemsModalList = ArrayList<Modal>()
    var itemsModalFilter = ArrayList<Modal>()

    fun setData(itemsModalList: ArrayList<Modal>){
        this.itemsModalList = itemsModalList
        this.itemsModalFilter = itemsModalList
        notifyDataSetChanged()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        val itemsModal = itemsModalList[position]
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_items_items, viewGroup, false)
        }
        val tvItemName = view?.findViewById<TextView>(R.id.tvItemDetails)
        val ivImageItem = view?.findViewById<ImageView>(R.id.ivItemsDetails)
        tvItemName?.text = itemsModalList[position].item
        ivImageItem?.setImageResource(itemsModalList[position].image!!)
        view?.setOnClickListener {
            clickListener.clickedItem(itemsModal)
        }
        return view!!

    }
    interface ClickListener{
        fun clickedItem(itemsModalItems:Modal)
    }
    override fun getItem(p0: Int): Any {
        return itemsModalList[p0]

    }
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return itemsModalList.size
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
                    val itemModal = ArrayList<Modal>()
                    for (item in itemsModalFilter){
                        if (item.item!!.lowercase(Locale.ROOT).contains(searchChr)){
                            itemModal.add(item)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }
                return filterResults
            }
            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults?.values as ArrayList<Modal>
                notifyDataSetChanged()
            }
        }
    }
}