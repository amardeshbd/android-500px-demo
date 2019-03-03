package com.hossainkhan.android.dpx.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Model class representing a photo object
 *
 * Example JSON with short format
 *  {
 *    "voted":false,
 *    "editors_choice_date":null,
 *    "hi_res_uploaded":0,
 *    "watermark":false,
 *    "latitude":51.4309209,
 *    "category":9,
 *    "comments_count":31,
 *    "camera":"ILCE-7M2",
 *    "images":[
 *      {
 *        "https_url":"https://drscdn.500px.org/photo/296464527/q%3D50_w%3D140_h%3D140/v2?client_application_id=8016&webp=true&v=0&sig
 *        "format":"jpeg",
 *        "size":2,
 *        "url":"https://drscdn.500px.org/photo/296464527/q%3D50_w%3D140_h%3D140/v2?client_application_id=8016&webp=true&v=0&sig
 *      }
 *    ],
 *    "nsfw":false,
 *    "image_url":[
 *      "https://drscdn.500px.org/photo/296464527/q%3D50_w%3D140_h%3D140/v2?client_application_id=8016&webp=true&v=0&sig
 *    ],
 *    "votes_count":1160,
 *    "for_sale":false,
 *    "converted_bits":0,
 *    "liked":false,
 *    "longitude":-0.0936496,
 *    "positive_votes_count":1160,
 *    "shutter_speed":"20",
 *    "image_format":"jpeg",
 *    "exclude_gads":false,
 *    "rating":99.7,
 *    "user_id":13103481,
 *    "aperture":"11",
 *    "collections_count":21,
 *    "height":3415,
 *    "comments":[
 *    ],
 *    "converted":false,
 *    "iso":"100",
 *    "privacy":false,
 *    "sales_count":0,
 *    "favorites_count":0,
 *    "store_width":5123,
 *    "is_free_photo":false,
 *    "license_requests_enabled":true,
 *    "feature_date":"2019-02-28T16:14:09+00:00",
 *    "description":"Early morning blue hour panorama of Tower Bridge.  I actually went 180 degrees to include the city too, but that is far too wide when 52% of
 *    "highest_rating":99.7,
 *    "lens":"FE 16-35mm F4 ZA OSS",
 *    "taken_at":"2018-07-18T00:00:40-04:00",
 *    "for_critique":false,
 *    "name":"Tower Bridge Blues",
 *    "for_sale_date":null,
 *    "disliked":false,
 *    "store_height":3415,
 *    "created_at":"2019-02-28T11:11:50-05:00",
 *    "editors_choice":false,
 *    "status":1,
 *    "editored_by":{
 *    },
 *    "licensing_status":2,
 *    "critiques_callout_dismissed":false,
 *    "request_to_buy_enabled":true,
 *    "licensing_requested":false,
 *    "highest_rating_date":"2019-03-01T03:57:28-05:00",
 *    "focal_length":"16",
 *    "width":5123,
 *    "url":"/photo/296464527/tower-bridge-blues-by-brett-gasser",
 *    "licensing_suggested":false,
 *    "id":296464527,
 *    "purchased":false,
 *    "profile":true,
 *    "location":null,
 *    "license_type":0,
 *    "feature":"popular",
 *    "crop_version":0,
 *    "times_viewed":6864,
 *    "user":{
 *      "upgrade_status":2,
 *      "affection":545976,
 *      "fullname":"Brett Gasser",
 *      "city":"Lee-on-the-Solent",
 *      "username":"Brett_G",
 *      "lastname":"Gasser",
 *      "id":13103481,
 *      "store_on":true,
 *      "userpic_https_url":"https://drscdn.500px
 *      "cover_url":"https://drscdn.500px.org/user_cover/13103481/q%3D65_m%3D2048/v2?webp=true&v=35&sig
 *      "firstname":"Brett",
 *      "country":"United Kingdom ",
 *      "avatars":{
 *        "small":{
 *          "https":"https://drscdn.500px.org/user_avatar/13103481/q%3D85_w%3D50_h%3D50/v2?webp=true&v=2&sig
 *        },
 *        "default":{
 *          "https":"https://drscdn.500px.org/user_avatar/13103481/q%3D85_w%3D300_h%3D300/v2?webp=true&v=2&sig
 *        },
 *        "tiny":{
 *          "https":"https://drscdn.500px.org/user_avatar/13103481/q%3D85_w%3D30_h%3D30/v2?webp=true&v=2&sig
 *        },
 *        "large":{
 *          "https":"https://drscdn.500px.org/user_avatar/13103481/q%3D85_w%3D100_h%3D100/v2?webp=true&v=2&sig
 *        }
 *      },
 *      "usertype":0,
 *      "userpic_url":"https://drscdn.500px.org/user_avatar/13103481/q%3D85_w%3D300_h%3D300/v2?webp=true&v=2&sig
 *    }
 *  }
 */
@Parcelize
data class Photo(
    var id: Long,
    var name: String,
    @SerializedName("url")
    var websiteUrl: String,
    @SerializedName("image_url")
    var imageUrls: List<String>,
    var camera: String? = null,
    @SerializedName("shutter_speed")
    var shutterSpeed: String? = null,
    var aperture: String? = null,
    var lens: String? = null,
    @SerializedName("votes_count")
    var votes: Int,
    @SerializedName("positive_votes_count")
    var votesUp: Int,
    @SerializedName("times_viewed")
    var totalViews: Int,
    var longitude: Float,
    var latitude: Float,
    var height: Int,
    var width: Int,
    var user: User
) : Parcelable {
    val imageUrl: String
        get() = imageUrls.firstOrNull() ?: ""
}