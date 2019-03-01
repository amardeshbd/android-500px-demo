package com.hossainkhan.android.dpx.network.models

import com.google.gson.annotations.SerializedName

/**
 * Model class representing a photo object
 *
 * Example JSON with short format
 *  {
 *       "id": 4910421,
 *       "name": "Orange or lemon",
 *       "description": "",
 *       "times_viewed": 709,
 *       "rating": 97.4,
 *       "created_at": "2012-02-09T02:27:16-05:00",
 *       "category": 0,
 *       "privacy": false,
 *       "width": 472,
 *       "height": 709,
 *       "votes_count": 88,
 *       "comments_count": 58,
 *       "nsfw": false,
 *       "image_url": "http://pcdn.500px.net/4910421/c4a10b46e857e33ed2df35749858a7e45690dae7/2.jpg",
 *       "user": {
 *         "id": 386047,
 *         "username": "Lluisdeharo",
 *         "firstname": "Lluis ",
 *         "lastname": "de Haro Sanchez",
 *         "city": "Sabadell",
 *         "country": "Catalunya",
 *         "fullname": "Lluis de Haro Sanchez",
 *         "userpic_url": "http://acdn.500px.net/386047/f76ed05530afec6d1d0bd985b98a91ce0ce49049/1.jpg?0",
 *         "upgrade_status": 0
 *       }
 *  }
 */
data class Photo(
    var id: Long,
    var name: String,
    @SerializedName("image_url")
    var imageUrls: List<String>
) {
    val imageUrl: String?
        get() = imageUrls.firstOrNull()
}