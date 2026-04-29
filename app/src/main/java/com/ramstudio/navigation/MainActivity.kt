package com.ramstudio.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ramstudio.navigation.ui.Navigation3App
import com.ramstudio.navigation.ui.navigation.HomeNavKey
import com.ramstudio.navigation.ui.navigation.TOP_LEVEL_NAV_ITEMS
import com.ramstudio.navigation.ui.navigation.rememberNavigationState
import com.ramstudio.navigation.ui.theme.Navigation3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                val navState = rememberNavigationState(
                    startRoute = HomeNavKey,
                    topLevelRoutes = TOP_LEVEL_NAV_ITEMS.keys
                )

                Navigation3App(
                    navState
                )
            }
        }
    }
}