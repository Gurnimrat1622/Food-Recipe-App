package com.example.foodrecipieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_recepie_data.*

class RecepieData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recepie_data)


//        val actionBar:ActionBar? = supportActionBar
//        actionBar!!.setDisplayHomeAsUpEnabled(true)
//        actionBar!!.setDisplayShowHomeEnabled(true)
//
//        var intent = intent
//        var aTitle = intent.getStringExtra("iTitle")
//        val aImageView = intent.getIntExtra("iImageView",0)
//        actionBar.setTitle(aTitle)
//        textView13.text = aTitle
//        imageView6.setImageResource(aImageView)


        val bundle:Bundle?=intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle!!.getInt("imageId")
        val description = bundle!!.getString("description")
        val steps = bundle!!.getString("steps")
        val ingredients = bundle!!.getString("ingredients")

        textView14.text = description
        textView17.text = steps
        textView16.text = ingredients
        textView13.text = heading
        imageView6.setImageResource(imageId)
    }
}