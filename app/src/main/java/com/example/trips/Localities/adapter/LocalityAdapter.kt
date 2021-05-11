package com.example.trips.Localities.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trips.Lists.adapter.AllListsAdapter
import com.example.trips.Lists.repository.AllListRepository
import com.example.trips.Localities.repository.LocalityRepository
import com.example.trips.databinding.ListsItemBinding
import com.example.trips.databinding.LocalityItemBinding
import org.koin.core.KoinComponent

class LocalityAdapter : RecyclerView.Adapter<LocalityAdapter.LocalityViewHolder>(), KoinComponent {

    inner class LocalityViewHolder(val binding: LocalityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalityViewHolder {
        val itemsView = LocalityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocalityViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: LocalityViewHolder, position: Int) {
        val allList = LocalityRepository.allListItem[position]

        holder.binding.nameLocality.text = allList.name
        holder.binding.distanceLocality.text = allList.distance.toString()
        holder.binding.tellPastor.text = allList.tellPastor.toString()
    }

    override fun getItemCount(): Int {
        return AllListRepository.allList.size
    }

}