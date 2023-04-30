package com.example.foodrecipieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recepie_page.view.*
import kotlinx.android.synthetic.main.categorycard.view.*

class CategoryAdapter(val arrayList1: ArrayList<Model>,val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :  RecyclerView .ViewHolder(itemView){
        fun bindItems(model: Model){
            itemView.tv_dish_name.text = model.title
            itemView.categorydish.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.categorycard,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList1[position])
    }

    override fun getItemCount(): Int {
       return  arrayList1.size
    }
}