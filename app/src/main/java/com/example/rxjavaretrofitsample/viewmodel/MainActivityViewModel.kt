package com.example.rxjavaretrofitsample.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavaretrofitsample.model.CoffeeListModel
import com.example.rxjavaretrofitsample.network.RetrofitInstance
import com.example.rxjavaretrofitsample.network.WebService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io

class MainActivityViewModel:ViewModel()
{

    var coffeeList: MutableLiveData<List<CoffeeListModel>> = MutableLiveData()

    fun getCoffeeListObserver():MutableLiveData<List<CoffeeListModel>>{
        return  coffeeList
    }

    fun makeApiCall(){
        val request = RetrofitInstance.getRetrofitInstance().create(WebService::class.java)
        request.getBookListFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getCoffeeListObserverRx())
    }

    private fun getCoffeeListObserverRx():Observer<List<CoffeeListModel>>{
        return  object :Observer<List<CoffeeListModel>>{
            override fun onSubscribe(d: Disposable?) {

                // used to start showing progress
            }

            override fun onNext(t: List<CoffeeListModel>) {
                coffeeList.postValue(t)
            }

            override fun onError(e: Throwable?) {
               coffeeList.postValue(null)
            }

            override fun onComplete() {

                // use to hide progress bar
            }

        }

    }


}