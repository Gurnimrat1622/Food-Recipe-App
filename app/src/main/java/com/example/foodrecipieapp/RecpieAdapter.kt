package com.example.foodrecipieapp

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recepiecard.view.*


class RecpieAdapter (val arrayList: ArrayList<Modal>,val context:Context):
    RecyclerView.Adapter<RecpieAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView:View,listener : onItemClickListener): RecyclerView.ViewHolder(itemView){
        fun bindItems(modal: Modal){
            itemView.Title.text = modal.title
            itemView.textView15.text = modal.des1
            itemView.textView16.text = modal.des2
            itemView.textView17.text = modal.des3
//            itemView.description.text = modal.des
            itemView.imageView4.setImageResource(modal.image)
            itemView.imageView5.setImageResource(modal.image1)
            itemView.imageView6.setImageResource(modal.image2)
            itemView.imageView7.setImageResource(modal.image3)
        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recepiecard,parent,false)
        return ViewHolder(v,mListener)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(arrayList[position])
//        holder.itemView.setOnClickListener {
//
//              val modal = arrayList.get(position)
//            var gTitle : String = modal.title
//            var gImageView : Int = modal.image
//
//
//
//            val intent = Intent(context,RecepieData::class.java)
//
//            intent.putExtra("iTitle",gTitle)
//            intent.putExtra("iImageView",gImageView)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}