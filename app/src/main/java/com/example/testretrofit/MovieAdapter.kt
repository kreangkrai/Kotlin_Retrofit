package com.example.testretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testretrofit.Models.DeviceModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (private val postList: List<DeviceModel>, private val context: Context?) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            holder.itemView.textTitle.text = postList[position].device
            holder.itemView.txtExcept.text = postList[position].value

//            Picasso.get().load(postList[position].thumbnail)
//                .error(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.itemView.imageView);

            holder.itemView.cardView.setOnClickListener { v ->
                Toast.makeText(v.context, "Device : " + postList[position].device + " Value : " + postList[position].value, Toast.LENGTH_SHORT)
                    .show();
            }
        }
        catch (err:Exception){
            Toast.makeText(context,err.message,Toast.LENGTH_LONG).show()
        }
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
