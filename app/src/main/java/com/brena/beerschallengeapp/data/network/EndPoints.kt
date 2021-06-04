package com.brena.beerschallengeapp.data.network

import com.brena.beerschallengeapp.data.response.BeerResponse
import com.brena.beerschallengeapp.domain.handle.Either
import com.brena.beerschallengeapp.domain.handle.Failure

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface EndPoints {
    suspend fun getBeers(page: Int): Either<Failure, List<BeerResponse>>
}