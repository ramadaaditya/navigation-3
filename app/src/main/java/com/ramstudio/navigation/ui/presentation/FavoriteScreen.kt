package com.ramstudio.navigation.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteScreen(onNavigateToProfile: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Ini Layar Home")
        Button(onClick = onNavigateToProfile) { Text("Buka Profile") }
    }
}