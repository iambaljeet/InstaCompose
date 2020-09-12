package com.app.instacompose.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import com.app.instacompose.model.BottomBarOptionsModel
import com.app.instacompose.state.HomeUiState

val bottomBarList = listOf(
    BottomBarOptionsModel(
        itemId = 1,
        unSelectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        itemTitle = "Home",
        isSelected = false
    ),
    BottomBarOptionsModel(
        itemId = 1,
        unSelectedIcon = Icons.Outlined.PlayArrow,
        selectedIcon = Icons.Filled.PlayArrow,
        itemTitle = "Reels",
        isSelected = false
    ),
    BottomBarOptionsModel(
        itemId = 1,
        unSelectedIcon = Icons.Outlined.Add,
        selectedIcon = Icons.Filled.Add,
        itemTitle = "Add",
        isSelected = false
    ),
    BottomBarOptionsModel(
        itemId = 1,
        unSelectedIcon = Icons.Outlined.Star,
        selectedIcon = Icons.Filled.Star,
        itemTitle = "Notifications",
        isSelected = false
    ),
    BottomBarOptionsModel(
        itemId = 1,
        unSelectedIcon = Icons.Outlined.Person,
        selectedIcon = Icons.Filled.Person,
        itemTitle = "Profile",
        isSelected = false
    )
)

val homeUiState = HomeUiState(
    allPosts = postsList,
    allStories = storiesList
)