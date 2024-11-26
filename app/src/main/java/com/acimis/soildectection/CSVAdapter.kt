package com.acimis.soildectection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CSVAdapter(private val dataList: List<List<String>>) :
    RecyclerView.Adapter<CSVAdapter.CSVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CSVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return CSVViewHolder(view)
    }

    override fun onBindViewHolder(holder: CSVViewHolder, position: Int) {
        val row = dataList[position]
        if (row.size >= 21) { // Ensure you have at least 5 columns
            holder.dateTv.text = row[2]
            holder.timeTv.text = row[3]
            if (row[4] == "N")
                holder.nitrogenTv.text = "Nitrogen"
            holder.nitrogenValueTv.text = row[5]
            holder.nitrogenUnitTv.text = row[6]
            if (row[7] == "P")
                holder.phosphorusTv.text = "Phosphorus"
            holder.phosphorusValueTv.text = row[8]
            holder.phosphorusUnitTv.text = row[9]
            if (row[10] == "K")
                holder.potassiumTv.text = "Potassium"
            holder.potassiumValueTv.text = row[11]
            holder.potassiumUnitTv.text = row[12]
            holder.phTv.text = row[13]
            holder.phValueTv.text = row[14]
            holder.temperatureTv.text = row[16]
            holder.temperatureValueTv.text = "${row[17]}°C"
            holder.humidityTv.text = row[19]
            holder.humidityValueTv.text = "${row[20]}%"
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
        val phTv: TextView = itemView.findViewById(R.id.phTv)
        val phValueTv: TextView = itemView.findViewById(R.id.phValueTv)
        val temperatureTv: TextView = itemView.findViewById(R.id.temperatureTv)
        val temperatureValueTv: TextView = itemView.findViewById(R.id.temperatureValueTv)
        val humidityTv: TextView = itemView.findViewById(R.id.humidityTv)
        val humidityValueTv: TextView = itemView.findViewById(R.id.humidityValueTv)
    }
}
