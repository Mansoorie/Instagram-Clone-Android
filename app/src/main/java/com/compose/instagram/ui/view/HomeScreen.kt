
package com.compose.instagram.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.instagram.NavItem
import com.compose.instagram.data.model.Feed
import com.compose.instagram.data.model.Story
import com.compose.instagram.data.repository.feedList
import com.compose.instagram.data.repository.stories
import com.compose.instagram.ui.theme.InstagramTheme
import com.compose.instagram.ui.theme.spacingMedium

@Composable
fun HomeScreen() {

    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        item {
            FitConnectToolBar()
        }

        item {
            StoryList(stories = stories)
        }

        item {
            Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
        }

        feedList(feedList = feedList)
    }
}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(stories) { _, item ->          // part of lazyrow gives index works same as item
            StoryItem(story = item)
        }
    }
}

fun LazyListScope.feedList(feedList: List<Feed>) {
    itemsIndexed(feedList) { _, item ->
        FeedItem(feed = item)
    }
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun DarkHomeScreenPreview() {
    InstagramTheme(darkTheme = true) {
        HomeScreen()
    }
}