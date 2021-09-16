package com.example.periodictableapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recylerView.setHasFixedSize(true)
        binding.recylerView.scheduleLayoutAnimation()
        binding.layoutmanager= GridLayoutManager(this,10,GridLayoutManager.HORIZONTAL,false)
        binding.recylerView.adapter=AdapterClassOfPeriodicTable(DummyData.generatePeriodicTableData())
    }
}