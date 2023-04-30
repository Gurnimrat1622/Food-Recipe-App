package com.example.foodrecipieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_drinks.*
import kotlinx.android.synthetic.main.fragment_feed_back.view.*


class DrinksFragment : Fragment() {

val arrList3 = ArrayList<Drinks>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        arrList3.add(Drinks(R.drawable.steak,"Drink1","1","1","1",R.drawable.fav,R.drawable.timer,R.drawable.dish))
        arrList3.add(Drinks(R.drawable.steak,"Drink1","1","1","1",R.drawable.fav,R.drawable.timer,R.drawable.dish))
        arrList3.add(Drinks(R.drawable.steak,"Drink1","1","1","1",R.drawable.fav,R.drawable.timer,R.drawable.dish))
        arrList3.add(Drinks(R.drawable.steak,"Drink1","1","1","1",R.drawable.fav,R.drawable.timer,R.drawable.dish))
        arrList3.add(Drinks(R.drawable.steak,"Drink1","1","1","1",R.drawable.fav,R.drawable.timer,R.drawable.dish))
        val DrinksAdapter = DrinksAdapter(arrList3,requireContext())
        receyclerView.layoutManager = LinearLayoutManager(requireContext())
        receyclerView.adapter = DrinksAdapter
        return inflater.inflate(R.layout.fragment_drinks, container, false)
    }


}