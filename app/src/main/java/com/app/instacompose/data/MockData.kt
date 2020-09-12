package com.app.instacompose.data

import com.app.instacompose.model.PostType
import com.app.instacompose.model.PostsDataModel
import com.app.instacompose.model.StoriesDataModel
import com.app.instacompose.model.UserDataModel

val userList = listOf(
        UserDataModel(
                userId = 1,
                userName = "Baljeet",
                userImage = "https://picsum.photos/200/200",
                userDescription = null,
                userFollowingCount = 100,
                userFollowersCount = 500,
        ),
        UserDataModel(
                userId = 2,
                userName = "Sam",
                userImage = "https://picsum.photos/200/200",
                userDescription = null,
                userFollowingCount = 25,
                userFollowersCount = 50,
        )
)

fun getUser(userId: Int): UserDataModel? {
    return userList.find { it.userId == userId }
}

@OptIn(ExperimentalStdlibApi::class)
val postsList = listOf(
        PostsDataModel(
                postId = 1,
                ownerData = getUser(1),
                postImageUrl = "https://picsum.photos/700/500",
                postCaption = "Loved this place ❤",
                postType = PostType.TYPE_IMAGE,
                ownerId = 1,
                postTimeStamp = "1h",
                likeCount = 20,
                commentCount = 2
        ),
        PostsDataModel(
                postId = 2,
                ownerData = getUser(2),
                postCaption = "Heaven on earth ❤ ✌",
                postImageUrl = "https://picsum.photos/700/500",
                postType = PostType.TYPE_IMAGE,
                ownerId = 2,
                postTimeStamp = "1h",
                likeCount = 25,
                commentCount = 5
        ),
        PostsDataModel(
                postId = 3,
                ownerData = getUser(1),
                postCaption = "Amazing place ❤ 🌹",
                postImagesUrlList = buildList { repeat((0..4).count()) { add("https://picsum.photos/700/500") } },
                postType = PostType.TYPE_MULTI_IMAGE,
                ownerId = 1,
                postTimeStamp = "2h",
                likeCount = 50,
                commentCount = 10
        ),
        PostsDataModel(
                postId = 4,
                ownerData = getUser(2),
                postCaption = "Look for opportunities in every change in your life.",
                postImageUrl = "https://picsum.photos/700/500",
                postType = PostType.TYPE_IMAGE,
                ownerId = 2,
                postTimeStamp = "2h",
                likeCount = 100,
                commentCount = 25
        ),
)

val storiesList = listOf(
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = -1,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 2,
                ownerData = getUser(2),
                storyId = 1,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 2,
                ownerData = getUser(2),
                storyId = 2,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 2,
                ownerData = getUser(2),
                storyId = 4,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 1,
                ownerData = getUser(1),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        ),
        StoriesDataModel(
                ownerId = 2,
                ownerData = getUser(2),
                storyId = 3,
                storyThumb = "https://picsum.photos/200/200",
                storyImage = "https://picsum.photos/700/900"
        )
)