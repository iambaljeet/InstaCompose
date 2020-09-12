package com.app.instacompose.components

import androidx.compose.foundation.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.app.instacompose.model.BottomBarOptionsModel
import com.app.instacompose.ui.getIconColor

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    bottomBarList: List<BottomBarOptionsModel>,
    bottomItemSelected: (BottomBarOptionsModel) -> Unit
) {
    Surface {
        Row(modifier = modifier, verticalGravity = Alignment.Bottom) {
            bottomBarList.fastForEachIndexed { index, bottomBarOptionsModel ->
                listItem(bottomBarOptionsModel, index, bottomItemSelected)
            }
        }
    }
}

@Composable
fun listItem(
    bottomAppBarOptionsModel: BottomBarOptionsModel,
    index: Int,
    bottomItemSelected: (BottomBarOptionsModel) -> Unit
) {
    if (index == 2) {
        Box(
                modifier = Modifier.weight(1f).height(50.dp)
        ) {
        }
    } else {
        val asset =
            if (bottomAppBarOptionsModel.isSelected) bottomAppBarOptionsModel.selectedIcon else bottomAppBarOptionsModel.unSelectedIcon
        Image(
            modifier = Modifier.weight(1f).height(50.dp).padding(bottom = 0.dp).padding(
                InnerPadding(
                    top = 10.dp,
                    bottom = 10.dp
                )
            )
                .clickable(onClick = { bottomItemSelected(bottomAppBarOptionsModel) }),
            asset = asset,
            colorFilter = ColorFilter.tint(
                color = getIconColor()
            )
        )
    }
}