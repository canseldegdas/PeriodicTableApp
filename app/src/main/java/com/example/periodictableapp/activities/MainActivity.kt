package com.example.periodictableapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.periodictableapp.R
import com.example.periodictableapp.adapter.AdapterClassOfPeriodicTable
import com.example.periodictableapp.databinding.ActivityMainBinding
import com.example.periodictableapp.dummydata.DummyData


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recylerView.setHasFixedSize(true)
        binding.recylerView.scheduleLayoutAnimation()
        binding.layoutmanager= GridLayoutManager(this,10,GridLayoutManager.HORIZONTAL,false)
        binding.recylerView.adapter= AdapterClassOfPeriodicTable(DummyData.generatePeriodicTableData())
    }


}