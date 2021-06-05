package com.brena.beerschallengeapp.data.response

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
data class BeerResponse(
    val id: Int,
    val name: String,
    val description: String,
    val image_url: String?,
    val volume: VolumeResponse
)
