package com.example.shayari

import DataEntity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shayari.databinding.RvItemBinding
import java.util.ArrayList

class RvAdapter(var context:Context, var shayariList:ArrayList<DataEntity>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.txtView.text=shayariList[position].shayari
    }
    override fun getItemCount(): Int {
        return shayariList.size

    }

    class ViewHolder( val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root) {}

}