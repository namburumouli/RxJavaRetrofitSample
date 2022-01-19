package com.example.rxjavaretrofitsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavaretrofitsample.adapter.CoffeeListAdapter
import com.example.rxjavaretrofitsample.databinding.ActivityMainBinding
import com.example.rxjavaretrofitsample.model.CoffeeListModel
import com.example.rxjavaretrofitsample.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var  binding:ActivityMainBinding
    private var  coffeeRecyclerView: RecyclerView? = null
    private lateinit var mainActivityViewModel:MainActivityViewModel

    private lateinit var coffeeListAdapter: CoffeeListAdapter
    private var coffeeList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        coffeeRecyclerView = binding.coffeeRecyclerView



        //coffee adapter
        coffeeListAdapter =  CoffeeListAdapter(this,coffeeList)
        coffeeRecyclerView?.adapter = coffeeListAdapter
        coffeeRecyclerView?.layoutManager = LinearLayoutManager(this)

        loadAPIData()

    }

    private fun loadAPIData() {
        mainActivityViewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.makeApiCall()
        mainActivityViewModel.getCoffeeListObserver().observe(this, Observer<List<CoffeeListModel>> {
            if(it!=null){
                it.forEach{
                    coffeeList.add(it.title!!)
                    coffeeListAdapter.notifyDataSetChanged()
                }



            }else{
                Toast.makeText(this, "SomeThing Went Wrong", Toast.LENGTH_SHORT).show()
            }
        })


    }
}