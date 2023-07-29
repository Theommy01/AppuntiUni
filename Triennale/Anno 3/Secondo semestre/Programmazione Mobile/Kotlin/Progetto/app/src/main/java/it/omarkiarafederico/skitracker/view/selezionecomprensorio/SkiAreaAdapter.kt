package it.omarkiarafederico.skitracker.view.selezionecomprensorio

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.omarkiarafederico.skitracker.R

class SkiAreaAdapter(private val skiAreaList:ArrayList<SkiAreaItem>) : RecyclerView.Adapter<SkiAreaAdapter.SkiAreaViewHolder>(){
    var onItemClick: ((SkiAreaItem) -> Unit)? = null
    private var skiAreaListBackup = ArrayList<SkiAreaItem>()

    init {
        this.skiAreaListBackup.addAll(skiAreaList)
    }

    class SkiAreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val skiAreaNameText: TextView = itemView.findViewById(R.id.skiAreaItemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkiAreaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comprensorio_item, parent, false)
        return SkiAreaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return skiAreaList.size
    }

    override fun onBindViewHolder(holder: SkiAreaViewHolder, position: Int) {
        val skiArea = skiAreaList[position]
        holder.skiAreaNameText.text = skiArea.nome

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(skiArea)
        }
    }

    fun filter(text: String) {
        skiAreaList.clear()

        if (text.isEmpty()) {
            skiAreaList.addAll(skiAreaListBackup)
        } else {
            val query = text.lowercase()
            for (item in skiAreaListBackup) {
                if (item.nome.lowercase().contains(query))
                    skiAreaList.add(item)
            }
        }
        notifyDataSetChanged()
    }

}