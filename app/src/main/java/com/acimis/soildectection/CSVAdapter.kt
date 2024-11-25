package com.acimis.soildectection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CSVAdapter(private val dataList: List<List<String>>) : RecyclerView.Adapter<CSVAdapter.CSVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CSVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return CSVViewHolder(view)
    }

    override fun onBindViewHolder(holder: CSVViewHolder, position: Int) {
        val row = dataList[position]
        if (row.size >= 13) { // Ensure you have at least 5 columns
            holder.dateTv.text = row[2]
            holder.timeTv.text = row[3]
            holder.nitrogenTv.text = row[4]
            holder.nitrogenValueTv.text = row[5]
            holder.nitrogenUnitTv.text = row[6]
            holder.phosphorusTv.text = row[7]
            holder.phosphorusValueTv.text = row[8]
            holder.phosphorusUnitTv.text = row[9]
            holder.potassiumTv.text = row[10]
            holder.potassiumValueTv.text = row[11]
            holder.potassiumUnitTv.text = row[12]
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class CSVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTv: TextView = itemView.findViewById(R.id.dateTv)
        val timeTv: TextView = itemView.findViewById(R.id.timeTv)
        val nitrogenTv: TextView = itemView.findViewById(R.id.nitrogenTv)
        val nitrogenValueTv: TextView = itemView.findViewById(R.id.nitrogenValueTv)
        val nitrogenUnitTv: TextView = itemView.findViewById(R.id.nitrogenUnitTv)
        val phosphorusTv: TextView = itemView.findViewById(R.id.phosphorusTv)
        val phosphorusValueTv: TextView = itemView.findViewById(R.id.phosphorusValueTv)
        val phosphorusUnitTv: TextView = itemView.findViewById(R.id.phosphorusUnitTv)
        val potassiumTv: TextView = itemView.findViewById(R.id.potassiumTv)
        val potassiumValueTv: TextView = itemView.findViewById(R.id.potassiumValueTv)
        val potassiumUnitTv: TextView = itemView.findViewById(R.id.potassiumUnitTv)
    }
}
