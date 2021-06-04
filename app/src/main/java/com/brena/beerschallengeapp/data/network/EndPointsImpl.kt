package com.brena.beerschallengeapp.data.network

import com.brena.beerschallengeapp.data.util.ConnectionUtils

/**
 * Created by Kevin Breña on 3/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
class EndPointsImpl(
    private val connectionUtils: ConnectionUtils,
    private val endPointService: EndPointService
): EndPoints {
}