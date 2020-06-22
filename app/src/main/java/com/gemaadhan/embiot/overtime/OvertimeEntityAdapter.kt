package com.gemaadhan.embiot.overtime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gemaadhan.embiot.database.OvertimeEntity
import com.gemaadhan.embiot.databinding.RecycleviewAllovertimeBinding


class OvertimeEntityAdapter(val clickListener: OvertimeEntityListener) : ListAdapter<OvertimeEntity, OvertimeEntityAdapter.ViewHolder>(
    OvertimeEntityCallback()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: RecycleviewAllovertimeBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: OvertimeEntity, clickListener: OvertimeEntityListener){
            binding.overtime = item
            binding.executePendingBindings()
            binding.clicklistener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecycleviewAllovertimeBinding.inflate(layoutInflater,parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }

}

class OvertimeEntityCallback : DiffUtil.ItemCallback<OvertimeEntity>() {

    override fun areItemsTheSame(oldItem: OvertimeEntity, newItem: OvertimeEntity): Boolean {
        return oldItem.overtimeId == newItem.overtimeId
    }

    override fun areContentsTheSame(oldItem: OvertimeEntity, newItem: OvertimeEntity): Boolean {
        return oldItem == newItem
    }
}

class OvertimeEntityListener(val clickListener: (overtimeId: Long) -> Unit) {
    fun onClick(overtime: OvertimeEntity) = clickListener(overtime.overtimeId)
}