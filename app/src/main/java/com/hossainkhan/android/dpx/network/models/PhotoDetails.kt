package com.hossainkhan.android.dpx.network.models

/**
 * Data class for Photo details response.
 *
 * FIXME: Unfortunately the details response has different format for `image_url` resulting following error.
 * ```
 * com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was STRING at line 1 column 1303 path $.photo.image_url
 * ```
 *
 * So, instead of duplicating the model class, using the existing data from model class and passing via parcelable
 * using Kotlin's experimental feature `@Parcelize`
 */
data class PhotoDetails(var photo: Photo)