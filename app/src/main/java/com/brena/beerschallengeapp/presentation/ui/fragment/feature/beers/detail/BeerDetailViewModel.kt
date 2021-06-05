package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brena.beerschallengeapp.presentation.model.Beer
import com.brena.beerschallengeapp.presentation.ui.base.BaseViewModel

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerDetailViewModel: BaseViewModel<Any>() {

    private val _beerDetailMutable = MutableLiveData<Beer>()
    val beerDetailLiveData: LiveData<Beer> = _beerDetailMutable

    fun setBeerDetail(beer: Beer){
        _beerDetailMutable.value = beer
    }
}