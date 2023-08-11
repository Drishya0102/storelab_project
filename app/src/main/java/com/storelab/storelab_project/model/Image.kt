package com.storelab.storelab_project.model

import java.io.Serializable

data class Image(
    val id: String,
    val author: String?,
    val download_url: String?,
    var isFavorite: Boolean = false): Serializable
