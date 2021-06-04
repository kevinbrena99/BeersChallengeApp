package com.brena.beerschallengeapp.domain.di

import com.brena.beerschallengeapp.domain.usecases.GetBeersUseCase
import org.koin.dsl.module

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
val useCasesModule = module {
    factory { GetBeersUseCase(get()) }
}