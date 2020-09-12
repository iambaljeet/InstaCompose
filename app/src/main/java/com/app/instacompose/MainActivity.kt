package com.app.instacompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.app.instacompose.components.BottomBar
import com.app.instacompose.components.postsView
import com.app.instacompose.components.storiesView
import com.app.instacompose.data.bottomBarList
import com.app.instacompose.data.homeUiState
import com.app.instacompose.state.HomeUiState
import com.app.instacompose.ui.InstaComposeTheme
import com.app.instacompose.ui.getBottomBarBackgroundColor
import com.app.instacompose.util.ProvideDisplayInsets
import com.app.instacompose.util.statusBarPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaComposeTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    ProvideDisplayInsets {
                        Stack(modifier = Modifier.statusBarPadding()) {
                            Scaffold(
                                bodyContent = {
                                    Stack {
                                        ContentBody(
                                            homeUiState = homeUiState
                                        )
                                    }
                                },
                                bottomBar = {
                                    BottomAppBar()
                                },
                            )
                            FloatingActionButton(
                                onClick = {},
                                icon = { Image(asset = Icons.Default.Add) },
                                modifier = Modifier
                                    .padding(
                                        bottom = 25.dp
                                    )
                                    .gravity(Alignment.BottomCenter),
                                backgroundColor = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ContentBody(homeUiState: HomeUiState) {
    Column(modifier = Modifier.fillMaxSize())
    {
        storiesView(homeUiState = homeUiState)
        Spacer(modifier = Modifier.height(15.dp))
        postsView(homeUiState = homeUiState)
    }
}

@Composable
fun BottomAppBar() {
    BottomBar(
        modifier = Modifier
            .gravity(align = Alignment.CenterVertically)
            .gravity(align = Alignment.Bottom)
            .background(color = getBottomBarBackgroundColor()),
        bottomBarList = bottomBarList,
        bottomItemSelected = {}
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstaComposeTheme {
        BottomAppBar()
    }
}