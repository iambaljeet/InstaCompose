package com.app.instacompose.model

import androidx.compose.runtime.Immutable

@Immutable
data class StoriesDataModel(
    val ownerId: Int,
    val ownerData: UserDataModel?,
    val storyId: Int,
    val storyThumb: String,
    val storyImage: String
)