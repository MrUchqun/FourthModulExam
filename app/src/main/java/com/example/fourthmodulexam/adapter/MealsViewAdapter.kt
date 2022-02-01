package com.example.fourthmodulexam.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fourthmodulexam.R
import com.example.fourthmodulexam.model.Meal

class MealsViewAdapter(private val meals: ArrayList<Meal>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MealsViewHolder(view)
    }

    class MealsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.iv_meal)
        val mealName: TextView = view.findViewById(R.id.tv_meal_name)
        val price: TextView = view.findViewById(R.id.tv_price)
        val mealAboutOne: TextView = view.findViewById(R.id.tv_meal_about_one)
        val mealAboutTwo: TextView = view.findViewById(R.id.tv_meal_about_two)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val meal: Meal = meals[position]
        if (holder is MealsViewHolder){
            holder.image.setImageResource(meal.photo)
            holder.mealName.text = meal.name
            holder.price.text = "${meal.price} $"
            holder.mealAboutOne.text = meal.aboutOne
            holder.mealAboutTwo.text = meal.aboutTwo
        }
    }

    override fun getItemCount(): Int {
        return meals.size
    }
}