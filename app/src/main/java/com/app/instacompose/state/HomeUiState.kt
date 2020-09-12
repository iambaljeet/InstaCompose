package com.app.instacompose.state

import androidx.compose.runtime.mutableStateListOf
import com.app.instacompose.model.PostsDataModel
import com.app.instacompose.model.StoriesDataModel

class HomeUiState(
    allStories: List<StoriesDataModel>,
    allPosts: List<PostsDataModel>
) {
    private val _posts: MutableList<PostsDataModel> =
        mutableStateListOf(*allPosts.toTypedArray())
    val postsList: List<PostsDataModel> = _posts

    private val _stories: MutableList<StoriesDataModel> =
        mutableStateListOf(*allStories.toTypedArray())
    val storiesList: List<StoriesDataModel> = _stories
}