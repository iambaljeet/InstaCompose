package com.app.instacompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CircularImage(modifier: Modifier, image: String) {
    CoilImage(data = image,
            modifier = Modifier.clickable(onClick = {})
                    .clip(CircleShape)
                    then modifier,
            contentScale = ContentScale.Crop)
}