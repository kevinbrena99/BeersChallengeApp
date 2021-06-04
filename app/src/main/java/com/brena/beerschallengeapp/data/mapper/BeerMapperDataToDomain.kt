package com.brena.beerschallengeapp.data.mapper

import com.brena.beerschallengeapp.data.response.BeerResponse
import com.brena.beerschallengeapp.domain.entity.BeerEntity

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface BeerMapperDataToDomain {

    suspend fun beersListDataToDomain(beers: List<BeerResponse>): List<BeerEntity>

}