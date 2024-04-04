package com.example.cloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.cloneapp.R
import com.example.cloneapp.databinding.PersonalItemListBinding
import com.example.cloneapp.model.PersonalData

class PersonalItemAdapter(context: Context, val itemList: List<PersonalData>): RecyclerView.Adapter<PersonalItemAdapter.PersonalViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        val binding = PersonalItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    class PersonalViewHolder(private val binding: PersonalItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(personalData: PersonalData) {
            //all the view
            binding.apply {
                tvName.text = personalData.name
                tvAddress.text = personalData.address
                tvWork.text = personalData.work
                tvDistance.text = personalData.distance

            }
        }
    }
}