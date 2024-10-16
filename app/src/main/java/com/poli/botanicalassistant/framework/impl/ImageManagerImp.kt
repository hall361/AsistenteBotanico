package com.poli.botanicalassistant.framework.impl

import android.app.Application
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poli.botanicalassistant.framework.ImageManager

class ImageManagerImp(
    private val application: Application
) : ImageManager {

    override fun loadCircleImage(
        imageView: ImageView,
        imageUrl: String,
        placeholder: Int
    ) {
        Glide.with(application)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(placeholder)
            .into(imageView)
    }
}
