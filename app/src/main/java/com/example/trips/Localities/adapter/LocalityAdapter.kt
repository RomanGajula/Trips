package com.example.trips.Localities.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trips.Common.dialog.AddLocalityDialog
import com.example.trips.Common.dialog.CancelDialog
import com.example.trips.Lists.adapter.AllListsAdapter
import com.example.trips.Lists.model.List
import com.example.trips.Lists.repository.AllListRepository
import com.example.trips.Lists.view.MainActivity
import com.example.trips.Localities.model.LocalityModel
import com.example.trips.Localities.repository.LocalityRepository
import com.example.trips.Localities.view.Locality
import com.example.trips.databinding.ListsItemBinding
import com.example.trips.databinding.LocalityItemBinding
import org.koin.core.KoinComponent

class LocalityAdapter : RecyclerView.Adapter<LocalityAdapter.LocalityViewHolder>(), KoinComponent {

    companion object {
        var locality: MutableList<LocalityModel> = arrayListOf()
    }

    lateinit var supportFragmentManager: FragmentManager

    inner class LocalityViewHolder(val binding: LocalityItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val location = locality[bindingAdapterPosition]
            val view = binding.root
            binding.addInList.setOnClickListener {
                AddLocalityDialog(location.id!!).show(supportFragmentManager,"AddLocality")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalityViewHolder {
        val itemsView = LocalityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocalityViewHolder(itemsView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LocalityViewHolder, position: Int) {

        holder.bind()

        val localityList = locality[position]

        holder.binding.nameLocality.text = localityList.name
        holder.binding.distanceLocality.text = "${localityList.distance.toString()} km"
        holder.binding.tellPastor.text = localityList.tellPastor.toString()
    }

    override fun getItemCount(): Int {
        return locality.size
    }

    fun setData(locality: MutableList<LocalityModel>, supportFragmentManager: FragmentManager) {
        LocalityAdapter.locality = locality
        notifyDataSetChanged()
        this.supportFragmentManager = supportFragmentManager
    }

}