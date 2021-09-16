package com.example.periodictableapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.R
import com.example.periodictableapp.viewholder.ViewHolderOfPeriodicTable
import com.example.periodictableapp.databinding.PeriodictableItemBinding
import com.example.periodictableapp.model.ModelPeriodicTable

class AdapterClassOfPeriodicTable(private val modelList: ArrayList<ModelPeriodicTable>) :
    RecyclerView.Adapter<ViewHolderOfPeriodicTable>() {
    private lateinit var binding: PeriodictableItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOfPeriodicTable {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.periodictable_item, parent, false
        )
        return ViewHolderOfPeriodicTable(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderOfPeriodicTable, position: Int) {
            holder.bind(modelList[position])


    }

    override fun getItemCount(): Int {
        return modelList.size
    }
}