package com.brena.beerschallengeapp.presentation.di

import com.brena.beerschallengeapp.presentation.mapper.BeerMapperDomainToPresentation
import com.brena.beerschallengeapp.presentation.mapper.BeerMapperDomainToPresentationImpl
import org.koin.dsl.module

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
val mapperPresentationModule = module {
    single<BeerMapperDomainToPresentation> { BeerMapperDomainToPresentationImpl() }
}