package com.example.pembelajaranreproduksihewan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pembelajaranreproduksihewan.R
import com.example.pembelajaranreproduksihewan.data.Class
import kotlin.collections.ArrayList

class ClassAdapter(private val classList:ArrayList<Class>) : RecyclerView.Adapter<ClassAdapter.ProductsViewHolder>() {

    var onItemClick : ((Array<String>) -> Unit)? = null

    var list = classList //kalau mau gunakan notifyDataSetChanged, yang di ubah variabel ini

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.classes_rv_item,parent,false)
        return ProductsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        var currentItem = list[position]

        holder.tvClass.text = currentItem.name
        holder.container.setOnClickListener {
            onItemClick?.invoke(arrayOf(currentItem.id, currentItem.teacher_id, currentItem.name)
            )
        }
    }

    class ProductsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val container : ConstraintLayout = itemView.findViewById(R.id.classes_rv_item_container)
        val tvClass : TextView = itemView.findViewById(R.id.classes_rv_item_tv_class)
    }
}