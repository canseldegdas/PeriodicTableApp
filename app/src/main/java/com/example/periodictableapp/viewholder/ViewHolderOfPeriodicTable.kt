package com.example.periodictableapp.viewholder

import android.app.Dialog
import android.os.Build
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.R
import com.example.periodictableapp.databinding.PeriodictableItemBinding
import com.example.periodictableapp.model.ModelPeriodicTable

class ViewHolderOfPeriodicTable(private val binding: PeriodictableItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ModelPeriodicTable) {

        binding.elementnumber = item.elementNumber.toString()
        binding.elementshortname = item.elementShortName
        binding.elementlongname = item.elementLongName
        binding.materalcard.isVisible = item.isVisible
        binding.linearLayoutItem.setBackgroundResource(item.elementBackgroundColor)

        binding.materalcard.setOnClickListener(object : View.OnClickListener {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(view: View?) {
                if (view != null) {
                    showDialog(item, view)
                }
            }
        })
    }

    private fun showDialog(
        item: ModelPeriodicTable,
        view: View
    ) {
        val dialog = Dialog(view.context)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme

        val elementNumber = dialog.findViewById(R.id.text_elemetNumber) as TextView
        val elementShortName = dialog.findViewById(R.id.text_elemetShortName) as TextView
        val elementLongName = dialog.findViewById(R.id.text_elemetLongName) as TextView
        val elementAtomicWeight = dialog.findViewById(R.id.text_elemetAtomicWeight) as TextView
        val elementElectronConfig = dialog.findViewById(R.id.text_elemetElectronConfig) as TextView
        val elementBackground = dialog.findViewById<LinearLayout>(R.id.linear_layout_item)
        elementNumber.text = item.elementNumber.toString()
        elementShortName.text = item.elementShortName
        elementLongName.text = item.elementLongName
        elementAtomicWeight.text = item.elementAtomicWeight.toString()
        elementElectronConfig.text = item.elementElectronConfig
        elementBackground.setBackgroundResource(item.elementBackgroundColor)

        dialog.show()

    }
}