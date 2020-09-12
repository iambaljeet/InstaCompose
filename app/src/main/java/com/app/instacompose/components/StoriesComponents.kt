package com.app.instacompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.instacompose.model.StoriesDataModel
import com.app.instacompose.state.HomeUiState
import com.app.instacompose.ui.getBorderColor
import com.app.instacompose.ui.getIconColor
import com.app.instacompose.ui.stories_outline_color
import dev.chrisbanes.accompanist.coil.CoilImage

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun storiesView(homeUiState: HomeUiState) {
    val columnModifier: Modifier = Modifier
        .preferredHeight(135.dp)
        .preferredWidth(100.dp)
        .padding(
            start = 8.dp, end = 8.dp
        )
    val imageModifierAddStory: Modifier = Modifier
        .border(
            width = 2.dp,
            color = getBorderColor(),
            shape = RoundedCornerShape(
                size = 10.dp
            )
        )
        .fillMaxSize()
        .padding(
            InnerPadding(
                all = 15.dp
            )
        )

    val imageModifierStory: Modifier = Modifier
        .border(
            width = 2.dp,
            color = stories_outline_color,
            shape = RoundedCornerShape(
                size = 10.dp
            )
        )
        .clip(
            shape = RoundedCornerShape(
                size = 10.dp
            )
        )
        .fillMaxSize()

    LazyRowFor(items = homeUiState.storiesList,
    contentPadding = InnerPadding(top = 10.dp, bottom = 10.dp))
    { storiesDataModel: StoriesDataModel ->
        if (storiesDataModel.storyId == -1) {
            addStoryView(onClick = {},
                columnModifier = columnModifier,
                imageModifier = imageModifierAddStory)
        } else {
            storyView(onClick = {},
                storiesDataModel = storiesDataModel,
                columnModifier = columnModifier,
                imageModifier = imageModifierStory)
        }
    }
}

@Composable
fun addStoryView(onClick: (storiesDataModel: StoriesDataModel?) -> Unit,
                 columnModifier: Modifier,
                 imageModifier: Modifier) {
    Stack(
        modifier = columnModifier
            .clickable(onClick = { onClick(null) })
    ) {
        Image(
            asset = Icons.Default.Add,
            modifier = imageModifier,
            colorFilter = ColorFilter.tint(
                color = getIconColor()
            ),
        )
    }
}

@Composable
fun storyView(
    onClick: (storiesDataModel: StoriesDataModel?) -> Unit,
    storiesDataModel: StoriesDataModel,
    columnModifier: Modifier,
    imageModifier: Modifier
) {
    Stack(
        modifier = columnModifier
            .clip(RoundedCornerShape(
                size = 10.dp
            ))
            .clickable(onClick = { onClick(storiesDataModel) })
    ) {
        CoilImage(data = storiesDataModel.storyThumb,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        SingleLineText(text = storiesDataModel.ownerData?.userName)
    }
}

@Composable
fun SingleLineText(text: String?) {
    if (text != null) {
        Text(text = text,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .gravity(Alignment.Bottom)
                .fillMaxWidth())
    }
}