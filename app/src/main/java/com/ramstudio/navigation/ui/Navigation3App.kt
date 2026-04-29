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
import com.ramstudio.navigation.ui.navigation.AppDestinations
import com.ramstudio.navigation.ui.navigation.DetailNavKey
import com.ramstudio.navigation.ui.navigation.FavoriteNavKey
import com.ramstudio.navigation.ui.navigation.HomeNavKey
import com.ramstudio.navigation.ui.navigation.NavigationState
import com.ramstudio.navigation.ui.navigation.Navigator
import com.ramstudio.navigation.ui.navigation.ProfileNavKey
import com.ramstudio.navigation.ui.navigation.SettingsNavKey
import com.ramstudio.navigation.ui.navigation.TOP_LEVEL_NAV_ITEMS
import com.ramstudio.navigation.ui.navigation.toEntries
import com.ramstudio.navigation.ui.presentation.DetailScreen
import com.ramstudio.navigation.ui.presentation.FavoriteScreen
import com.ramstudio.navigation.ui.presentation.HomeScreen
import com.ramstudio.navigation.ui.presentation.ProfileScreen
import com.ramstudio.navigation.ui.presentation.SettingScreen


@Composable
fun Navigation3App(
    navState: NavigationState
) {
    val currentDestination = TOP_LEVEL_NAV_ITEMS[navState.topLevelRoute] ?: AppDestinations.HOME

    val navigator = remember(navState) { Navigator(navState) }

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
                        when (key) {
                            is HomeNavKey -> NavEntry(key) {
                                HomeScreen(
                                    onNavigateToDetail = { id ->
                                        navigator.navigate(DetailNavKey(id))
                                    }
                                )
                            }

                            is ProfileNavKey -> NavEntry(key) {
                                ProfileScreen()
                            }

                            is FavoriteNavKey -> NavEntry(key) {
                                FavoriteScreen(
                                    onNavigateToProfile = {}
                                )
                            }

                            is SettingsNavKey -> NavEntry(key) {
                                SettingScreen()
                            }

                            is DetailNavKey -> NavEntry(key) {
                                DetailScreen(id = key.id)
                            }

                            else -> NavEntry(key) {
                                Text("Unknown")
                            }
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