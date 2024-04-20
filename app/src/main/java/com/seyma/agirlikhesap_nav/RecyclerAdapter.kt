package com.seyma.agirlikhesap_nav

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.seyma.agirlikhesap_nav.RecyclerAdapter.RecyclerViewHolder
import com.seyma.agirlikhesap_nav.databinding.RecyclerViewBinding



interface RecyclerViewItemClickListener {
    fun onItemClicked(position: Int)
}
class RecyclerAdapter(val malzemeListesi: ArrayList<Malzemeler>, val listener: RecyclerViewItemClickListener)
    : RecyclerView.Adapter<RecyclerViewHolder>() {

    class RecyclerViewHolder (val binding: RecyclerViewBinding,private val clickListener: RecyclerViewItemClickListener) :
    ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener.onItemClicked(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder { //ilk oluşturuldugunda ne olacak
        val binding =RecyclerViewBinding.inflate(LayoutInflater.from(parent.context))
        return RecyclerViewHolder(binding, listener)

    }

    override fun getItemCount(): Int { //kaç tane olacak
        return malzemeListesi.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) { //baglandıktan sonra ne olacak
        holder.binding.textView.text = malzemeListesi.get(position).malzemeName
        holder.binding.imageView.setImageResource(malzemeListesi[position].malzemeResim)

        holder.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }



    }


