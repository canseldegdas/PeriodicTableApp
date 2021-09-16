package com.example.periodictableapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.databinding.PeriodictableItemBinding

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
        Log.e("posiiton", position.toString())
        if(position==0)
            holder.bind(modelList[position], modelList[position], modelList[position+1])
        else if (position >0 && position < modelList.size-1 )
            holder.bind(modelList[position - 1], modelList[position], modelList[position + 1])
        else if (position == modelList.size-1)
            holder.bind(modelList[position - 1], modelList[position], modelList[position])



    }

    override fun getItemCount(): Int {
        return modelList.size
    }
}