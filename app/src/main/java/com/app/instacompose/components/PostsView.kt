package com.app.instacompose.components

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import com.app.instacompose.state.HomeUiState

@Composable
fun postsView(homeUiState: HomeUiState) {
    LazyColumnFor(items = homeUiState.postsList)
    {
        postsModel -> postComponent(postsDataModel = postsModel)
    }
}