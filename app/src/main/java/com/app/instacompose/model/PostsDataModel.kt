package com.app.instacompose.model

import androidx.compose.runtime.Immutable

enum class PostType {
    TYPE_IMAGE, TYPE_MULTI_IMAGE
}

@Immutable
data class PostsDataModel(
        val ownerId: Int,
        val ownerData: UserDataModel?,
        val postId: Int,
        val postCaption: String? = null,
        val postImageUrl: String? = null,
        val postImagesUrlList: List<String>? = null,
        val postType: PostType,
        val postTimeStamp: String,
        val likeCount: Int = 0,
        val commentCount: Int = 0
)