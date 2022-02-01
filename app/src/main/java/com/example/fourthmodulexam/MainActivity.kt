package com.example.fourthmodulexam

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fourthmodulexam.adapter.MealsViewAdapter
import com.example.fourthmodulexam.model.Meal
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        refreshAdapter()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.view_recycler)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    private fun refreshAdapter() {
        recyclerView.adapter = MealsViewAdapter(getMeals())
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