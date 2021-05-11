package com.example.trips.Lists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.trips.Lists.repository.AllListRepository
import com.example.trips.databinding.ListsItemBinding
import org.koin.core.KoinComponent

class AllListsAdapter : RecyclerView.Adapter<AllListsAdapter.MyViewHolder>(), KoinComponent {

    inner class MyViewHolder(val binding: ListsItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = ListsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val allList = AllListRepository.allList[position]

        holder.binding.nameList.text = allList.name
        holder.binding.quantity.text = allList.quantity.toString()

        holder.binding.cardList.setOnClickListener {
            AllListRepository.allList.forEach {
                if (holder.binding.nameList.text == it.name) {
                    println(it.name)
                    println(it.id)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return AllListRepository.allList.size
    }

}