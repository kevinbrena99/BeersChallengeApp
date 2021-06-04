package com.brena.beerschallengeapp.data.repository

import com.brena.beerschallengeapp.data.mapper.BeerMapperDataToDomain
import com.brena.beerschallengeapp.data.network.EndPoints
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
class BeerRepositoryImpl(
    private val endPoints: EndPoints,
    private val beerMapper: BeerMapperDataToDomain
    ) : BeerRepository {

    override suspend fun getBeers(page: Int): Either<Failure, List<BeerEntity>> {
        return when (val response = endPoints.getBeers(page)) {
            is Either.Right -> Either.Right(beerMapper.beersListDataToDomain(response.b))
            is Either.Left -> Either.Left(response.a)
        }
    }
}