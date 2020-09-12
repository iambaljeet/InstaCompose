package com.app.instacompose.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.instacompose.model.PostType
import com.app.instacompose.model.PostsDataModel
import com.app.instacompose.ui.getIconColor
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun postComponent(postsDataModel: PostsDataModel) {
    Column(
            modifier = Modifier.padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 18.dp
            ).fillMaxWidth().wrapContentHeight()
    ) {
        val ownerData = postsDataModel.ownerData
        if (ownerData != null) {
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    verticalGravity = Alignment.CenterVertically
            ) {
                ownerData.userImage?.let {
                    CircularImage(
                            image = it,
                            modifier = Modifier.preferredSize(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                            text = ownerData.userName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                            text = postsDataModel.postTimeStamp,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Image(asset = Icons.Default.MoreVert,
                        colorFilter = ColorFilter.tint(
                                color = getIconColor()
                        )
                )
            }
            when (postsDataModel.postType) {
                PostType.TYPE_IMAGE -> {
                    postsDataModel.postImageUrl?.let {
                        CoilImage(data = it,
                                modifier = Modifier.fillMaxWidth()
                                        .aspectRatio(1f)
                                        .padding(
                                                top = 10.dp
                                        )
                                        .clip(RoundedCornerShape(
                                                size = 10.dp
                                        )),
                                contentScale = ContentScale.Crop)
                    }
                }
                PostType.TYPE_MULTI_IMAGE -> {
                    postsDataModel.postImagesUrlList?.let {
                        LazyRowFor(items = it) { imageUrl: String ->
                            CoilImage(data = imageUrl,
                                    modifier = Modifier.fillMaxWidth()
                                            .aspectRatio(.8f)
                                            .padding(
                                                    top = 10.dp,
                                                    start = 10.dp,
                                                    end = 10.dp
                                            )
                                            .clip(RoundedCornerShape(
                                                    size = 10.dp
                                            )),
                                    contentScale = ContentScale.Crop)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                postOptions(
                        icon = Icons.Outlined.Star,
                        count = postsDataModel.likeCount.toString()
                )
                postOptions(
                        icon = Icons.Default.Send,
                        count = postsDataModel.commentCount.toString()
                )
                postOptions(
                        icon = Icons.Outlined.Share,
                        count = null
                )
            }
        }
    }
}

@Composable
fun postOptions(icon: VectorAsset, count: String?) {
    Row(
            verticalGravity = Alignment.CenterVertically
    ) {
        Icon(
                asset = icon,
                modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        if (count != null) {
            Text(text = count,
                    maxLines = 1,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis)
        }
    }
}