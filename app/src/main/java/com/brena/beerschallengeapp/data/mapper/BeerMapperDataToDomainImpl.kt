package com.brena.beerschallengeapp.data.mapper

import com.brena.beerschallengeapp.data.response.BeerResponse
import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.domain.entity.VolumeEntity

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class BeerMapperDataToDomainImpl: BeerMapperDataToDomain {
    override suspend fun beersListDataToDomain(beers: List<BeerResponse>): List<BeerEntity> {
        return beers.map { beer ->
            BeerEntity(
                id = beer.id,
                name = beer.name,
                description = beer.description,
                image_url = beer.image_url,
                volume = VolumeEntity(
                    value = beer.volume.value,
                    unit = beer.volume.unit
                )
            )
        }
    }
}