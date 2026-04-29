package com.ramstudio.navigation.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavKey : NavKey

@Serializable
data object FavoriteNavKey : NavKey

@Serializable
data class ProfileNavKey(val userId: String?) : NavKey

@Serializable
data object SettingsNavKey : NavKey