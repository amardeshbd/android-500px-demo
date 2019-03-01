package com.hossainkhan.android.dpx.extensions

import androidx.databinding.Observable
import androidx.databinding.ObservableField

/**
 * Wraps [ObservableField.addOnPropertyChangedCallback] with a cleaner interface.
 *
 * ## Usage
 * ```
 * observableField.onChanged { newValue ->
 *    // Do operation with new changed value
 * }
 * ```
 */
inline fun <T> ObservableField<T>.onChanged(crossinline callback: (T) -> Unit) {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            callback.invoke(get()!!)
        }
    })
}
