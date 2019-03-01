package com.hossainkhan.android.dpx.network.models

/**
 * Model class for photo owner.
 *
 * Example JSON:
 *  {
 *    "id": 386047,
 *    "username": "Lluisdeharo",
 *    "firstname": "Lluis ",
 *    "lastname": "de Haro Sanchez",
 *    "city": "Sabadell",
 *    "country": "Catalunya",
 *    "fullname": "Lluis de Haro Sanchez",
 *    "userpic_url": "http://acdn.500px.net/386047/f76ed05530afec6d1d0bd985b98a91ce0ce49049/1.jpg?0",
 *    "upgrade_status": 0
 *  }
 */
data class User(
    var id: String,
    var username: String,
    var firstname: String,
    var lastname: String

) {
    val fullName: String
        get() = "$firstname $lastname"
}