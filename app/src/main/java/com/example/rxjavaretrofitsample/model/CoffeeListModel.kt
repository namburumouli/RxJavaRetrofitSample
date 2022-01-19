package com.example.rxjavaretrofitsample.model

import com.google.gson.annotations.SerializedName

data class CoffeeListModel (
    @SerializedName("title"       ) var title       : String?           = null,
    @SerializedName("description" ) var description : String?           = null,
    @SerializedName("ingredients" ) var ingredients : ArrayList<String> = arrayListOf(),
    @SerializedName("id"          ) var id          : Int?              = null

)