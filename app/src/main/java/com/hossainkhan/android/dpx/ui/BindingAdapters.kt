package com.hossainkhan.android.dpx.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/*
 * Binding Adapters
 * https://developer.android.com/topic/libraries/data-binding/binding-adapters.html
 */

@BindingAdapter(value = ["imageUrl", "placeHolder", "isCircle"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String, placeHolder: Drawable?, isCircle: Boolean?) {
    if (url == null) {
        imageView.setImageDrawable(placeHolder)
    } else {
        val imageRequest = Picasso.get().load(url)

        if (isCircle == true) {
            imageRequest.transform(RoundedCornersTransformation(200, 20))
        }

        imageRequest.into(imageView)
    }
}
