package com.brena.beerschallengeapp.presentation.model

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
data class Beer(
    val id: Int,
    val name: String,
    val description: String,
    val image_url: String,
    val volume: Volume
)
