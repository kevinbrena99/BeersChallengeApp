package com.brena.beerschallengeapp.data.di

import com.brena.beerschallengeapp.data.repository.BeerRepositoryImpl
import com.brena.beerschallengeapp.domain.repository.BeerRepository
import org.koin.dsl.module

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
val repositoryModule = module {
    single<BeerRepository> { BeerRepositoryImpl(get(),get()) }
}