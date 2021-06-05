package com.brena.beerschallengeapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/
@Parcelize
data class Volume(
    val value: Int,
    val unit: String
): Parcelable
