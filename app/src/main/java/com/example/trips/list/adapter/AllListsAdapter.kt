package com.example.trips.list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trips.list.model.List
import com.example.trips.localities.view.Locality
import com.example.trips.databinding.ListsItemBinding
import org.koin.core.KoinComponent

class AllListsAdapter : RecyclerView.Adapter<AllListsAdapter.MyViewHolder>(), KoinComponent {

    companion object {
        var lists: MutableList<List> = arrayListOf()
    }

    inner class MyViewHolder(val binding: ListsItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val view = binding.root
            binding.cardList.setOnClickListener {
                AllListsAdapter.lists.forEach {
                    if (binding.nameList.text == it.name) {
                        if (it.description == "all") {
                            val intent = Intent(view.context, Locality::class.java)
                            view.context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = ListsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind()

        val allList = AllListsAdapter.lists[position]

        holder.binding.nameList.text = allList.name
        holder.binding.quantity.text = allList.quantity.toString()
    }

    override fun getItemCount(): Int {
        return AllListsAdapter.lists.size
    }

    fun setData(lists: MutableList<List>) {
        AllListsAdapter.lists = lists
        notifyDataSetChanged()
    }

}