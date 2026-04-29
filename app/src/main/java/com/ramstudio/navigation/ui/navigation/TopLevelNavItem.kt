package com.ramstudio.navigation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestinations(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val label: String,
) {
    HOME(
        Icons.Default.Home,
        Icons.Outlined.Home,
        "Home"
    ),
    FAVORITES(
        Icons.Default.Favorite,
        Icons.Outlined.FavoriteBorder,
        "Favorites"
    ),
    PROFILE(
        Icons.Default.AccountBox,
        Icons.Outlined.AccountBox,
        "Profile"
    ),
    SETTINGS(
        Icons.Default.Settings,
        Icons.Outlined.Settings,
        "Settings"
    ),
}


val TOP_LEVEL_NAV_ITEMS = mapOf(
    HomeNavKey to AppDestinations.HOME,
    FavoriteNavKey to AppDestinations.FAVORITES,
    ProfileNavKey(null) to AppDestinations.PROFILE,
    SettingsNavKey to AppDestinations.SETTINGS
)