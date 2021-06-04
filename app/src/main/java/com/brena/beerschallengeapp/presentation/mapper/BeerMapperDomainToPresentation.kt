package com.brena.beerschallengeapp.presentation.mapper

import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.presentation.model.Beer

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface BeerMapperDomainToPresentation {
    suspend fun beerListDomainToPresentation(beers: List<BeerEntity>): List<Beer>
}