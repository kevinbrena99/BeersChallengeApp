package com.brena.beerschallengeapp.data.network

import com.brena.beerschallengeapp.data.response.BeerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
interface EndPointService {

    @GET("/beers")
    suspend fun getBeers(@Query("page")page: Int): Response<List<BeerResponse>>

}