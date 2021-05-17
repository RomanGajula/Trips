package com.example.trips.localities.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trips.common.dialog.AddLocalityDialog
import com.example.trips.localities.model.LocalityModel
import com.example.trips.databinding.LocalityItemBinding
import com.example.trips.detailsLocaties.view.DetaliesLocalities
import com.example.trips.list.view.MainActivity
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
                AddLocalityDialog(location.id!!).show(supportFragmentManager, "AddLocality")
            }
            binding.locality.setOnClickListener {
                val intent = Intent(view.context, DetaliesLocalities::class.java)
                intent.putExtra("id", location.id.toString())
                println("--------------> ${location.id.toString()}")
                view.context.startActivity(intent)
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