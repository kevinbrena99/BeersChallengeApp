package com.brena.beerschallengeapp.data.di

import com.brena.beerschallengeapp.data.mapper.BeerMapperDataToDomain
import com.brena.beerschallengeapp.data.mapper.BeerMapperDataToDomainImpl
import org.koin.dsl.module

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/

val mapperDataModule = module {
    single<BeerMapperDataToDomain> { BeerMapperDataToDomainImpl() }
}