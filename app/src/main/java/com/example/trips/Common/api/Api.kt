package com.example.trips.common.api

import com.example.trips.Lists.model.List
import com.example.trips.Localities.model.LocalityModel
import retrofit2.Call
import retrofit2.http.*


interface Api {
//    @POST("list")
//    fun addList(
//            @Body list: com.example.trips.Lists.model.List
//    ): Call<com.example.trips.Lists.model.List>

    @GET("locality")
    fun getLocality(): Call<MutableList<LocalityModel>>

    @GET("list")
    fun getLists(): Call<MutableList<List>>
//
//    @GET("employees")
//    fun getEmployeeSearch(@Query("employee_name") employee_name: String): Call<List<Employee>>
//
    @GET("locality")
    fun getLocalityById(@Query("id") id: Int): Call<kotlin.collections.List<LocalityModel>>
//
//    @DELETE("employees/{id}")
//    fun deleteEmployee(@Path("id") id: Int): Call<Void>
//
    @PUT("locality/{id}")
    fun updateList(@Path("id") id: Int, @Body localityModel: LocalityModel): Call<LocalityModel>
}