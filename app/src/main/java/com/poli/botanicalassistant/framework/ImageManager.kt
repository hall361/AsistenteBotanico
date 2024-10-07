package com.poli.botanicalassistant.framework

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface ImageManager {

    fun loadCircleImage(
        imageView: ImageView,
        imageUrl: String,
        @DrawableRes placeholder: Int
    )
}
