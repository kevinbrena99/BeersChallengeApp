package com.brena.beerschallengeapp.presentation.ui.adapter

import android.view.View
import com.brena.beerschallengeapp.R
import com.brena.beerschallengeapp.databinding.ItemBeerBinding
import com.brena.beerschallengeapp.presentation.model.Beer
import com.brena.beerschallengeapp.presentation.ui.base.BaseAdapter

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerAdapter(private val onClick:(beer: Beer, position: Int) -> Unit): BaseAdapter<ItemBeerBinding,Beer>(mutableListOf(), onClick) {

    override fun getLayoutResId(): Int = R.layout.item_beer

    override fun onBindData(items: List<Beer>, position: Int, view: View) {

    }
}