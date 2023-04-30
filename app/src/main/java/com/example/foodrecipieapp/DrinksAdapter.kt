package com.example.foodrecipieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recepiecard.view.*

class DrinksAdapter(val arrayList: ArrayList<Drinks>,val context: Context):
    RecyclerView.Adapter<DrinksAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(drinks: Drinks){
            itemView.Title.text = drinks.heading
            itemView.imageView4.setImageResource(drinks.mainImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recepiecard,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItems(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}