package com.example.rxjavaretrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavaretrofitsample.MainActivity
import com.example.rxjavaretrofitsample.R

class CoffeeListAdapter( private val mainActivity: MainActivity, private val coffeeList: ArrayList<String>) :RecyclerView.Adapter<CoffeeListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // to inflate the layout for each item of recycler view.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coffeeTitle.text = coffeeList[position]
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var coffeeTitle: TextView = itemView.findViewById(R.id.textview)
    }



}