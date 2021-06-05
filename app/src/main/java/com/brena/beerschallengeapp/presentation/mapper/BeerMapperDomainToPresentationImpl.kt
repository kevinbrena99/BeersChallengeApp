package com.brena.beerschallengeapp.presentation.mapper

import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.presentation.model.Beer
import com.brena.beerschallengeapp.presentation.model.Volume

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerMapperDomainToPresentationImpl : BeerMapperDomainToPresentation {
    override suspend fun beerListDomainToPresentation(beers: List<BeerEntity>): List<Beer> {
        return beers.map { beer ->
            Beer(
                id = beer.id,
                name = beer.name,
                description = beer.description,
                image_url = beer.image_url ?: "",
                volume = Volume(
                    value = beer.volume.value.toInt(),
                    unit = beer.volume.unit
                )
            )
        }
    }
}