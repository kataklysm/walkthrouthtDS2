package com.daveapps.walkthrouthds2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemsAdapterEnemies(var itemModal: ArrayList<ModalEnemies>, var context: Context): BaseAdapter()  {
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        if (view == null){
            view = layoutInflater.inflate(R.layout.row_items_enemies,viewGroup,false)
        }
        val tvItemName = view?.findViewById<TextView>(R.id.tvEnemiesDetails)
        val ivImageItem = view?.findViewById<ImageView>(R.id.ivEnemiesDetails)
        //tvItemName?.text = itemModal[position].name
        ivImageItem?.setImageResource(itemModal[position].image!!)
        return view!!
    }

    override fun getItem(p0: Int): Any {
        return itemModal[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


    override fun getCount(): Int {
        return itemModal.size
    }


}