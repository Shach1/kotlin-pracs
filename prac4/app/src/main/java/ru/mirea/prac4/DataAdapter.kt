package ru.mirea.prac4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.prac4.databinding.DateItemBinding

class DataAdapter(private val dataList: List<String>) : RecyclerView.Adapter<DataAdapter.DataHolder>()
{
    class DataHolder(private val itemBinding: DateItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: String) {
            itemBinding.itemTextView.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val itemBinding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}