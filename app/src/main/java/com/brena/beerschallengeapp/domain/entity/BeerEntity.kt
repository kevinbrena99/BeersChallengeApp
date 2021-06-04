package com.brena.beerschallengeapp.domain.entity

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
data class BeerEntity(
    val id: Int,
    val name: String,
    val description: String,
    val image_url: String,
    val volume: VolumeEntity
)
