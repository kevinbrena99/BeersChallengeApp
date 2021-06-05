package com.brena.beerschallengeapp.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brena.beerschallengeapp.R
import com.bumptech.glide.Glide

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/

@BindingAdapter("app:recyclerHorizontal")
fun recyclerHorizontal(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
    recyclerView.adapter = adapter
}

@BindingAdapter("app:urlServer")
fun setImageUrl(imageView: ImageView, url: String){
    if(url.isNotEmpty()){
        Glide.with(imageView.context)
            .load(url)
            .centerCrop()
            .into(imageView)
    }else{
        Glide.with(imageView.context)
            .load(R.drawable.image_beer_not_found)
            .centerCrop()
            .into(imageView)
    }
}