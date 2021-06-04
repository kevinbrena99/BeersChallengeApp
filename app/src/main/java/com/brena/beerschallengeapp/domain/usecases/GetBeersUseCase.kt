package com.brena.beerschallengeapp.domain.usecases

import com.brena.beerschallengeapp.domain.entity.BeerEntity
import com.brena.beerschallengeapp.domain.handle.Either
import com.brena.beerschallengeapp.domain.handle.Failure
import com.brena.beerschallengeapp.domain.repository.BeerRepository

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class GetBeersUseCase(private val repository: BeerRepository): BaseUseCase<List<BeerEntity>,GetBeersUseCase.Params>() {
    data class Params(val page: Int)

    override suspend fun run(params: Params): Either<Failure, List<BeerEntity>> = repository.getBeers(params.page)
}