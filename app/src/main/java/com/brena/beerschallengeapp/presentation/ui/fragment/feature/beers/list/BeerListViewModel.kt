package com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.list

import androidx.lifecycle.*
import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.domain.usecases.GetBeersUseCase
import com.brena.beerschallengeapp.presentation.mapper.BeerMapperDomainToPresentation
import com.brena.beerschallengeapp.presentation.model.Beer
import com.brena.beerschallengeapp.presentation.ui.adapter.BeerAdapter
import com.brena.beerschallengeapp.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerListViewModel(private val getBeersUseCase: GetBeersUseCase,
                        private val mapperBeerMapperDomainToPresentation: BeerMapperDomainToPresentation): BaseViewModel<ListenerBeerClick>() {

    companion object{
        const val PAGE = 10
    }

    private val _beersMutableLiveData = MutableLiveData<List<BeerEntity>>()
    val beersLiveData: LiveData<List<Beer>> = _beersMutableLiveData.switchMap {
        liveData(Dispatchers.IO) { emit(mapperBeerMapperDomainToPresentation.beerListDomainToPresentation(it)) }
    }

    init {
        executeGetBeerByPage()
    }

    val adapter = BeerAdapter{ beer: Beer, position: Int ->
        getNavigator()?.onClickBeer(beer)
    }

    fun setItemAfterMapping(beers: List<Beer>){
        adapter.setData(beers)
        showLoading(false)
    }

    private fun executeGetBeerByPage(){
        showLoading(true)
        getBeersUseCase.invoke(viewModelScope, GetBeersUseCase.Params(PAGE)){
            it.either(::handleUseCaseFailureFromBase,::handleGetBeersSuccess)
        }
    }

    private fun handleGetBeersSuccess(beers: List<BeerEntity>){
        _beersMutableLiveData.value = beers
    }
}