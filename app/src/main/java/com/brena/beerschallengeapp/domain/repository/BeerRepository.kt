package com.brena.beerschallengeapp.domain.repository

import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.domain.handle.Either
import com.brena.beerschallengeapp.domain.handle.Failure

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface BeerRepository {

    suspend fun getBeers(page: Int): Either<Failure, List<BeerEntity>>

}