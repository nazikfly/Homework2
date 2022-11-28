package com.geektech.homework2


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TextAdapter (private val list: ArrayList<String>,private val clickListener: (String)->Unit):
    RecyclerView.Adapter<TextAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            ItemTextBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.onBind(list[position])
    }
    override fun getItemCount() = list.size

    inner class MessageViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(tModel: String) {
            binding.itemText.text = tModel

            itemView.setOnClickListener {
                clickListener(tModel)
            }
        }
    }
}
