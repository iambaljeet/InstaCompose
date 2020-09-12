package com.app.instacompose.model

import androidx.compose.runtime.Immutable

@Immutable
data class UserDataModel(
        val userId: Int,
        val userName: String,
        val userImage: String? = null,
        val userDescription: String? = null,
        val userFollowingCount: Int,
        val userFollowersCount: Int,
)