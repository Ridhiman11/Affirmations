package com.example.affirmations.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation


//Context contains the information about how to resolve the string resources and other info. about app
class ItemAdapter(private val context: Context,
                  private val dataset: List<Affirmation>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    //A ViewHolder represents a single list item view in RecyclerView;holds reference to individual view
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //accepts parent("recycler view"), view type; returns a new view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)  //The layout inflater knows how to inflate an XML layout into a hierarchy of view objects.
        //adapterLayout holds a reference to the list item view (from which we can later find child views like the TextView)
        return ItemViewHolder(adapterLayout)
    }

    //This method is called by the layout manager in order to replace the contents of a list item view.
    //has two parameters, an ItemViewHolder previously created by the onCreateViewHolder() method, and an int that represents the current item position in the list
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size  //return the size of your dataset
}