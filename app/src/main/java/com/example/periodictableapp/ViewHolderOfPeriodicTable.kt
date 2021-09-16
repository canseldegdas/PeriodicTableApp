package com.example.periodictableapp

import android.app.Dialog
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictableapp.databinding.PeriodictableItemBinding

class ViewHolderOfPeriodicTable(private val binding: PeriodictableItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        previousItem: ModelPeriodicTable,
        item: ModelPeriodicTable,
        nextItem: ModelPeriodicTable
    ) {


        binding.elementnumber = item.elementNumber.toString()
        binding.elementshortname = item.elementShortName
        binding.elementlongname = item.elementLongName
        binding.materalcard.isVisible = item.isVisible
        binding.linearLayoutItem.setBackgroundResource(item.elementBackgroundColor)

        binding.materalcard.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (view != null) {
                    showDialog(previousItem,item,nextItem,view)
                }
            }

        })


    }

    private fun showDialog(
        previousItem: ModelPeriodicTable,
        item: ModelPeriodicTable,
        nextItem: ModelPeriodicTable,
        view: View
    ) {
        val dialog = Dialog(view.context)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_layout)


        val previouselementNumber = dialog.findViewById(R.id.text_previousElementNumber) as TextView
        val previouselementShortName =
            dialog.findViewById(R.id.text_previousElementShortName) as TextView
        val previouselementLongName =
            dialog.findViewById(R.id.text_previousElemetLongName) as TextView
        //val previousElementCnstrLayout = dialog.findViewById(R.id.PreviousElementCnstrLayout) as TextView

        previouselementNumber.text = previousItem.elementNumber.toString()
        previouselementShortName.text = previousItem.elementShortName
        previouselementLongName.text = previousItem.elementLongName
       // previousElementCnstrLayout.setBackgroundResource(previousItem.elementBackgroundColor)


        val elementNumber = dialog.findViewById(R.id.text_elemetNumber) as TextView
        val elementShortName = dialog.findViewById(R.id.text_elemetShortName) as TextView
        val elementLongName = dialog.findViewById(R.id.text_elemetLongName) as TextView
        val elementAtomicWeight = dialog.findViewById(R.id.text_elemetAtomicWeight) as TextView
       // val elementElectronConfig = dialog.findViewById(R.id.text_elemetElectronConfig) as TextView

        elementNumber.text = item.elementNumber.toString()
        elementShortName.text = item.elementShortName
        elementLongName.text = item.elementLongName
        elementAtomicWeight.text = item.elementAtomicWeight.toString()
       // elementElectronConfig.text = item.elementElectronConfig

        val nextelementNumber = dialog.findViewById(R.id.text_nextelementNumber) as TextView
        val nextelementShortName = dialog.findViewById(R.id.text_nextelementShortName) as TextView
        val nextelementLongName = dialog.findViewById(R.id.text_nextelementLongName) as TextView
       // val nextElementCnstrLayout = dialog.findViewById(R.id.NextElementCnstrLayout) as TextView

        nextelementNumber.text=nextItem.elementNumber.toString()
        nextelementShortName.text=nextItem.elementShortName
        nextelementLongName.text=nextItem.elementLongName
        //nextElementCnstrLayout.setBackgroundResource(nextItem.elementBackgroundColor)


        dialog.show()

    }
}