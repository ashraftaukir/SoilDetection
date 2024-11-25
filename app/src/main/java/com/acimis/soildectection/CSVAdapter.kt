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
        if (row.size >= 5) { // Ensure you have at least 5 columns
            holder.column1.text = row[0]
            holder.column2.text = row[1]
            holder.column3.text = row[2]
            holder.column4.text = row[3]
            holder.column5.text = row[4]
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class CSVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val column1: TextView = itemView.findViewById(R.id.column1)
        val column2: TextView = itemView.findViewById(R.id.column2)
        val column3: TextView = itemView.findViewById(R.id.column3)
        val column4: TextView = itemView.findViewById(R.id.column4)
        val column5: TextView = itemView.findViewById(R.id.column5)
    }
}
