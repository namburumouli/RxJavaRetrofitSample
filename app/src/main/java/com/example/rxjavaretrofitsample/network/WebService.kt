package com.example.rxjavaretrofitsample.network


import com.example.rxjavaretrofitsample.model.CoffeeListModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface WebService {

    @GET("coffee/hot")
    fun getBookListFromApi(): Observable<List<CoffeeListModel>>
}