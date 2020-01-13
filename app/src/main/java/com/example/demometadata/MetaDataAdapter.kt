package com.example.demometadata

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_meta.view.*

class MetaDataAdapter : RecyclerView.Adapter<MetaDataAdapter.ViewHolder>() {
    private var list: List<MetaData> = ArrayList()

    fun add(list: List<MetaData>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun clear() {
        list = ArrayList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_meta, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val metaData = list[p1]

        p0.tvKey.text = "Key Code: " + metaData.getKey().toString()
        p0.tvValue.text = "Value: " + metaData.getValue().toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvKey = itemView.tvKey!!
        var tvValue = itemView.tvValue!!
    }
}
