package com.example.trips.Common.api

import com.example.trips.Lists.model.List
import com.example.trips.Localities.model.LocalityModel
import retrofit2.Call
import retrofit2.http.*


interface Api {
//    @POST("list")
//    fun addList(
//            @Body list: com.example.trips.Lists.model.List
//    ): Call<com.example.trips.Lists.model.List>

    @GET("locatity")
    fun getLocality(): Call<MutableList<LocalityModel>>

    @GET("list")
    fun getLists(): Call<MutableList<List>>
//
//    @GET("employees")
//    fun getEmployeeSearch(@Query("employee_name") employee_name: String): Call<List<Employee>>
//
//    @GET("employees")
//    fun getEmployeeById(@Query("id") id: Int): Call<List<Employee>>
//
//    @DELETE("employees/{id}")
//    fun deleteEmployee(@Path("id") id: Int): Call<Void>
//
//    @PUT("employees/{id}")
//    fun updateEmployee(@Path("id") id: Int, @Body employee: Employee): Call<Employee>
}