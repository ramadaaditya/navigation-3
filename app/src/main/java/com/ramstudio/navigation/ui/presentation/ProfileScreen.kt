package com.ramstudio.navigation.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(userId: String, onBack: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Ini Layar Profile")
        Text("User ID: $userId")
        Button(onClick = onBack) { Text("Kembali") }
    }
}