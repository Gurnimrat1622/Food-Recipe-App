package com.example.foodrecipieapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_feed_back.*


class FeedBackFrag : Fragment() {
    lateinit var button: Button

//    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View= inflater.inflate(R.layout.fragment_feed_back, container, false)
        button=v.findViewById(R.id.button2)
        button.setOnClickListener {
            if(ratingBar3.rating.isNaN() || ratingBar4.rating.isNaN() || feedbacktext.text.isEmpty()){

                Toast.makeText(requireContext(), "fill all fields", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "thank for your feedback ", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), RecepiePage::class.java)
                startActivity(intent)
            }
        }
        return  v
    }
}