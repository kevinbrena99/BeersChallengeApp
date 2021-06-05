package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.list

import com.brena.beerschallengeapp.presentation.model.Beer

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface ListenerBeerClick {

    fun onClickBeer(beer: Beer)
}