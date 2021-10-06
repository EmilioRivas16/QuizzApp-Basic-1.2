package com.example.quizappbasic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val dataSet: List<Data>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var checkbox: CheckBox = itemView.findViewById(R.id.checkSett)
        fun populate(item : Data){
            checkbox.text = item.checkSett
            checkbox.isChecked = item.isSelected
        }

        fun setSelectedItemState(item: Data, function:(item: Data) -> Unit){
            checkbox.setOnClickListener{
                item.isSelected = !item.isSelected
                function(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.checkbox_row, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populate(dataSet[position])
        holder.setSelectedItemState(dataSet[position], selectedItemsSetter)
    }

    private var selectedItemsSetter = fun(dataSet: Data){
        if (dataSet.isFirst){
            setIsSelectedAllItems(dataSet.isSelected)
        } else {
            setIsSelectAllOptionsItem()
        }

        notifyDataSetChanged()
    }

    private fun setIsSelectedAllItems(isChecked: Boolean){
        dataSet.map{
            it.isSelected = isChecked
        }
    }

    private fun setIsSelectAllOptionsItem() {
        setIsSelectAllOptionsItemToTrueState()
        setIsSelectAllOptionsItemToFalseState()
    }

    private fun setIsSelectAllOptionsItemToTrueState() {
        val selectedFilters = dataSet.filter { it.isSelected }

        if (selectedFilters.size == dataSet.size - 1) {
            dataSet.find {
                it.checkSett == dataSet.first().checkSett
            }?.isSelected = true
        }
    }

    private fun setIsSelectAllOptionsItemToFalseState() {
        val deselectFilters =
            dataSet.filter { !it.isSelected }

        if (deselectFilters.isNotEmpty() && dataSet.first().isSelected) {
            dataSet.find {
                it.checkSett == dataSet.first().checkSett
            }?.isSelected = false
        }
    }

    override fun getItemCount(): Int = dataSet.size

}