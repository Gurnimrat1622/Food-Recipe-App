package com.example.foodrecipieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_drinks.*

class DrinksPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks_page)
        val arrList3 = ArrayList<Drinks>()

        arrList3.add(Drinks(R.drawable.tea,"Tea","100","10 min","sugar",R.drawable.fav,R.drawable.timer,R.drawable.sugar))
        arrList3.add(Drinks(R.drawable.cola,"Coca-Cola","120","0","diet",R.drawable.fav,R.drawable.timer,R.drawable.img))
        arrList3.add(Drinks(R.drawable.coffee,"Coffee","90","10 min","sugar",R.drawable.fav,R.drawable.timer,R.drawable.sugar))
        arrList3.add(Drinks(R.drawable.greentea,"Green Tea","70","5 min","No sugar",R.drawable.fav,R.drawable.timer,R.drawable.img))
        arrList3.add(Drinks(R.drawable.coconut,"Coconut Water","100","0","No sugar",R.drawable.fav,R.drawable.timer,R.drawable.img))
        val DrinksAdapter = DrinksAdapter(arrList3,this)
        receyclerView.layoutManager = LinearLayoutManager(this)
        receyclerView.adapter = DrinksAdapter
    }
}