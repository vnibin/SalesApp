package com.vnibin.salesapp

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.items_row.view.*

/**
 * Created by vnibin on 1/6/18.
 */
class ItemAdapter(var context:Context,var list:ArrayList<Items>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ItemHolder).bind(list[position].name,list[position].price,list[position].photo,list[position].id)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
       var v:View=LayoutInflater.from(context).inflate(R.layout.items_row,parent,false)
        return ItemHolder(v)
    }

class ItemHolder(itemview:View):RecyclerView.ViewHolder(itemview)
{

    fun bind(n:String,p:Double,u:String,item_id:Int)
    {
        itemView.item_name.text=n;
        itemView.item_price.text=p.toString()
        var web:String="http://192.168.1.4//Companyweb/salesweb/images/"+u
       // web=web.replace("","%20")
        Picasso.with(itemView.context).load(web).into(itemView.item_photo)

        itemView.item_add_photo.setOnClickListener {

           UserInfo.itemId=item_id
            var obj=QtyFragment()
            var manager=(itemView.context as Activity).fragmentManager   // (itemView.context as Activity) this is used to specify fragmentmanager's context as activity as fragment manager is used in activity,, here it is used in adapter class which is not an activity
             obj.show(manager,"Qty")

        }
    }
}

}