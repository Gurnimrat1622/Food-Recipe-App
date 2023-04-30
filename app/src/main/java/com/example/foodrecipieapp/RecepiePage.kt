package com.example.foodrecipieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
//import android.widget.SearchView
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_recepie_page.*
import java.util.*
import kotlin.collections.ArrayList

class RecepiePage : AppCompatActivity() {

    val arrayList = ArrayList<Modal>()
    val displayList = ArrayList<Modal>()


    lateinit var toggle : ActionBarDrawerToggle
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var ingredients : Array<String>
    lateinit var steps : Array<String>
    lateinit var description: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recepie_page)


        arrayList.add(Modal("Chole Bhature","description","100","45 min","veg",R.drawable.dish1,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        arrayList.add(Modal("Butter Chicken","description","120","1.5 hr","non-veg",R.drawable.dish2,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        arrayList.add(Modal("Shepherd's Pie","description","80","1.5 hr","vegan",R.drawable.dish3,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        arrayList.add(Modal("Masala Dosa","description","90","30 min","veg",R.drawable.dosa,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        arrayList.add(Modal("Grilled Steak","description","100","30 min","non-veg",R.drawable.steak,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        arrayList.add(Modal("Coconut Curry","description","70","50 min","vegan",R.drawable.dish6,R.drawable.fav,R.drawable.timer,R.drawable.diet))
//        arrayList.add(Modal("Palak Paneer","description","120","1 hr","veg",R.drawable.dish7,R.drawable.fav,R.drawable.timer,R.drawable.diet))
//        arrayList.add(Modal("Spicy Lamb Curry","description","80","2 hr","non-veg",R.drawable.dish8,R.drawable.fav,R.drawable.timer,R.drawable.diet))
//        arrayList.add(Modal("Mushroom Stroganoff:","description","65","50 min","vegan",R.drawable.dish9,R.drawable.fav,R.drawable.timer,R.drawable.diet))
        displayList.addAll(arrayList)




        val myAdapter = RecpieAdapter(displayList,this)
        receycler.layoutManager = LinearLayoutManager(this)
        receycler.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : RecpieAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@RecepiePage,"You clicked on item no",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RecepiePage,RecepieData::class.java)
                intent.putExtra("heading",heading[position])
                intent.putExtra("imageId",imageId[position])
                intent.putExtra("description",description[position])
                intent.putExtra("steps",steps[position])
                intent.putExtra("ingredients",ingredients[position])
                startActivity(intent)
            }

        })


        val arrayList1 = ArrayList<Model>()
        arrayList1.add(Model("VEG",R.drawable.dish))
        arrayList1.add(Model("NON-VEG",R.drawable.dish))
        arrayList1.add(Model("VEGAN",R.drawable.dish))


        val myAdapter1 = CategoryAdapter(arrayList1,this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryrecy.layoutManager = layoutManager
//        categoryrecy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL)
        categoryrecy.adapter = myAdapter1

        description = arrayOf(
            getString(R.string.des1),
            getString(R.string.des2),
            getString(R.string.des3),
            getString(R.string.des4),
            getString(R.string.des5),
            getString(R.string.des6),

        )

        imageId = arrayOf(
            R.drawable.dish1,
            R.drawable.dish2,
            R.drawable.dish3,
            R.drawable.dish4,
            R.drawable.dish5,
            R.drawable.dish6,
        )

        steps = arrayOf(
            getString(R.string.steps1),
            getString(R.string.steps2),
//            getString(R.string.steps3),
            getString(R.string.steps4),
            getString(R.string.steps5),
            getString(R.string.steps6),

        )
        ingredients = arrayOf(
            getString(R.string.ingre1),
            getString(R.string.ingre2),
            getString(R.string.ingre3),
            getString(R.string.ingre4),
            getString(R.string.ingre5),
            getString(R.string.ingre6),
        )

            heading = arrayOf(
                "Chole Bhature",
                "Butter Chicken",
                "Shepherd's Pi",
                "Masala Dosa",
                "Grilled Steak",
                "Coconut Curry",

            )










        var drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        var navView : NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            it.isChecked =  true
            when(it.itemId){
                R.id.home ->  {val intent = Intent(this,RecepiePage::class.java)
                startActivity(intent)
                    true}
                R.id.drinks ->  {val intent = Intent(this,DrinksPage::class.java)
                startActivity(intent)
                true}
                R.id.favorites-> Toast.makeText(this,"Clicked Favourites",Toast.LENGTH_SHORT).show()
                R.id.logout -> { val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                    true}
                R.id.share -> Toast.makeText(this,"Clicked Home",Toast.LENGTH_SHORT).show()
                R.id.FeedBack -> replaceFragment(FeedBackFrag(),it.title.toString())
            }
            true
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search,menu)
        val menuItem = menu!!.findItem(R.id.search)
        if(menuItem != null){
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if(newText!!.isNotEmpty()){
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        arrayList.forEach {
                            if(it.title.toLowerCase(Locale.getDefault()).contains(search)){
                                displayList.add(it)
                            }
                        }
                        receycler.adapter!!.notifyDataSetChanged()
                    }
                    else{
                        displayList.clear()
                        displayList.addAll(arrayList)
                        receycler.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }




    private fun replaceFragment(fragment: Fragment,title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }
}