package com.app.instacompose.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.VectorAsset

@Immutable
data class BottomBarOptionsModel(
    val itemId: Int,
    val selectedIcon: VectorAsset,
    val unSelectedIcon: VectorAsset,
    val itemTitle: String,
    var isSelected: Boolean
)