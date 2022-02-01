package com.example.fourthmodulexam

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fourthmodulexam.adapter.MealsViewAdapter
import com.example.fourthmodulexam.model.Meal
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        refreshAdapter()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.view_recycler)
        recyclerView.layoutManager = getLayoutManager()
    }

    private fun getLayoutManager(): GridLayoutManager {
        val orientation: Int = this.resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_PORTRAIT)
            GridLayoutManager(this, 1)
        else
            GridLayoutManager(this, 3)
    }

    private fun refreshAdapter() {
        val adapter = MealsViewAdapter(getMeals())

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)){
                    if (count < 5){
                        adapter.setMeals(getMeals())
                        Toast.makeText(this@MainActivity,"Loading...",Toast.LENGTH_SHORT).show()
                        count++
                    }
                    else Toast.makeText(this@MainActivity,"You have showed all meals",Toast.LENGTH_SHORT).show()
                }
            }
        })

        recyclerView.adapter = adapter
    }

    private fun getMeals(): ArrayList<Meal> {
        val meals = ArrayList<Meal>()
        for (i in 0..20) {
            when (i % 5) {
                0 -> meals.add(
                    Meal(
                        R.drawable.meal_photo_1,
                        "Nourish",
                        10,
                        "Gluten Free",
                        "Clean Eating"
                    )
                )
                1 -> meals.add(
                    Meal(
                        R.drawable.meal_photo_2,
                        "Course",
                        8,
                        "Winnipeg",
                        "Canada"
                    )
                )
                2 -> meals.add(
                    Meal(
                        R.drawable.meal_photo_3,
                        "Supper",
                        15,
                        "Lunch",
                        "Dinner"
                    )
                )
                3 -> meals.add(
                    Meal(
                        R.drawable.meal_photo_4,
                        "Boa Vista",
                        14,
                        "Cape Verde",
                        "Plate"
                    )
                )
                4 -> meals.add(
                    Meal(
                        R.drawable.meal_photo_5,
                        "Queensland",
                        19,
                        "Australia",
                        "Old"
                    )
                )
            }
        }
        return meals
    }
}