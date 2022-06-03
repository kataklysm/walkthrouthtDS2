package com.daveapps.walkthrouthds2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ItemsAdapterCovenants (var context: Context, var clickListener: ClickListener) : BaseAdapter(), Filterable{
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var itemsModalList = ArrayList<ItemsModalCovenants>()
    var itemsModalFilter = ArrayList<ItemsModalCovenants>()

    fun setData(itemsModalList: ArrayList<ItemsModalCovenants>){
        this.itemsModalList = itemsModalList
        this.itemsModalFilter = itemsModalList
        notifyDataSetChanged()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        val itemsModal = itemsModalList[position]
        if (view == null){
            view = layoutInflater.inflate(R.layout.row_items_covenants, viewGroup, false)
        }
        val tvItemName = view?.findViewById<TextView>(R.id.tvCovenants)
        val ivImageItem = view?.findViewById<ImageView>(R.id.ivCovenants)
        tvItemName?.text = itemsModalList[position].covenants
        ivImageItem?.setImageResource(itemsModalList[position].image!!)
        view?.setOnClickListener{
            clickListener.clickedItemCovenants(itemsModal)
        }
        return view!!
    }

    interface ClickListener{
        fun clickedItemCovenants(itemsModalCovenants: ItemsModalCovenants)
    }

    override fun getCount(): Int {
        return itemsModalList.size
    }

    override fun getItem(p0: Int): Any {
        return itemsModalList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }



    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence == null || charSequence.length < 0){
                    filterResults.count = itemsModalFilter.size
                    filterResults.values = itemsModalFilter
                }else{
                    val searchChr = charSequence.toString().lowercase(Locale.ROOT)
                    val itemModal = ArrayList<ItemsModalCovenants>()
                    for (item in itemsModalFilter){
                        if (item.covenants!!.lowercase(Locale.ROOT).contains(searchChr)){
                            itemModal.add(item)
                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults?.values as ArrayList<ItemsModalCovenants>
                notifyDataSetChanged()
            }

        }
    }


}


