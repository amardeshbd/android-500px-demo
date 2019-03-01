package com.hossainkhan.android.dpx.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Model class for photo owner.
 *
 * Example JSON:
 *  {
 *     "upgrade_status":0,
 *     "affection":2042730,
 *     "fullname":"Maxim Maximov",
 *     "city":"Moscow",
 *     "username":"The-Maksimov",
 *     "lastname":"Maximov",
 *     "id":23896,
 *     "store_on":true,
 *     "userpic_https_url":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D300_h%3D300/v2?webp=true&v=5&sig=59d154366279e1d2f1c56677ed023371049bc8db96af1b397f95a8fb4d9f678c",
 *     "cover_url":"https://drscdn.500px.org/user_cover/23896/q%3D65_m%3D2048/v2?webp=true&v=25&sig=4e2542eedd5b927e00bf088ede6462b62da55bbd6a2a8135b353a5c14b21628e",
 *     "firstname":"Maxim",
 *     "country":"Rassia",
 *     "avatars":{
 *        "small":{
 *           "https":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D50_h%3D50/v2?webp=true&v=5&sig=7d2acf7c885a01e6a23fe22444d710e1208ba9c862fab11918393ced311004e1"
 *        },
 *        "default":{
 *           "https":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D300_h%3D300/v2?webp=true&v=5&sig=59d154366279e1d2f1c56677ed023371049bc8db96af1b397f95a8fb4d9f678c"
 *        },
 *        "tiny":{
 *           "https":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D30_h%3D30/v2?webp=true&v=5&sig=cbfcf9e4a297784bc06b2daec3db9c0adb2a0526b8914376b8c8d9b7fe10e29c"
 *        },
 *        "large":{
 *           "https":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D100_h%3D100/v2?webp=true&v=5&sig=6d70bd7fcd0fa68baa5ff4174b8917ca9d74fca8a44de6986c905f76abbce18f"
 *        }
 *     },
 *     "usertype":0,
 *     "userpic_url":"https://drscdn.500px.org/user_avatar/23896/q%3D85_w%3D300_h%3D300/v2?webp=true&v=5&sig=59d154366279e1d2f1c56677ed023371049bc8db96af1b397f95a8fb4d9f678c"
 *  }
 */
@Parcelize
data class User(
    var id: String,
    var username: String,
    var firstname: String,
    var lastname: String,
    var fullname: String
) : Parcelable