package com.ramstudio.navigation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.ramstudio.navigation.ui.navigation.NavigationState
import com.ramstudio.navigation.ui.navigation.Navigator
import com.ramstudio.navigation.ui.navigation.TOP_LEVEL_NAV_ITEMS
import com.ramstudio.navigation.ui.navigation.toEntries


@Composable
fun Navigation3App(
    navState: NavigationState
) {
    val currentDestination = TOP_LEVEL_NAV_ITEMS[navState.topLevelRoute]

    val navigator = remember { Navigator(navState) }

    NavigationSuiteScaffold( //Dynamic Suite Scaffold
        navigationSuiteItems = {
            TOP_LEVEL_NAV_ITEMS.forEach { (navKey, navItem) ->
                item(
                    icon = {
                        Icon(
                            imageVector = if (navItem == currentDestination) {
                                navItem.selectedIcon
                            } else {
                                navItem.unselectedIcon
                            },
                            contentDescription = navItem.label
                        )
                    },
                    label = { Text(navItem.label) },
                    selected = navItem == currentDestination,
                    onClick = {
                        navigator.navigate(navKey)
                    }
                )
            }
        }
    ) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                NavDisplay(
                    onBack = {
                        navigator.goBack()
                    },
                    entries = navState.toEntries { key ->
                        val destination = TOP_LEVEL_NAV_ITEMS[key]
                        NavEntry(key) {
                            PlaceholderScreen(text = destination?.label ?: "Unknown")
                        }
                    }
                )
            }
        }
    }
}


@Composable
private fun PlaceholderScreen(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "This is $text screen",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
    }

}