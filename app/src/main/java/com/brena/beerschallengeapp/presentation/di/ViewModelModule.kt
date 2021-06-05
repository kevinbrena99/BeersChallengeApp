package com.brena.beerschallengeapp.presentation.di

import com.brena.beerschallengeapp.presentation.ui.fragment.feature.beers.list.BeerListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
val viewModelModule = module {
    viewModel { BeerListViewModel() }
}