package com.brena.beerschallengeapp.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.brena.beerschallengeapp.R
import com.brena.beerschallengeapp.BR

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
@Suppress("UNCHECKED_CAST")
abstract class BaseAdapter<D : ViewDataBinding, T : Any>(
    private val items: MutableList<T>,
    private val onClick: (T, position: Int) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    companion object {
        const val VIEW_TYPE_NORMAL = 1
        const val VIEW_TYPE_LOADING = 2
    }

    var isLoading = false

    abstract fun getLayoutResId(): Int

    //abstract fun onCreateBind(context: Context, view: View)
    abstract fun onBindData(items: List<T>, position: Int, view: View)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val dataBinding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_beer, parent, false)
        //onCreateBind(parent.context, dataBinding.root)
        return MyViewHolder(dataBinding as D)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoading) {
            if (items.size - 1 == position) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myHolder = (holder as BaseAdapter<*, *>.MyViewHolder)
        myHolder.setItem(items[position])
        myHolder.itemView.setOnClickListener {
            onClick(items[position], position)
        }
        onBindData(items, position, myHolder.itemView)
    }

    override fun getItemCount(): Int = items.size

    fun setData(data: List<T>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    internal inner class MyViewHolder(private val binding: D) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(model: Any) {
            binding.setVariable(BR.model, model)
            binding.executePendingBindings()
        }
    }

}