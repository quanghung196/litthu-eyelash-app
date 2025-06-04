package com.example.litthu_eyelash_app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.litthu_eyelash_app.presentation.login.view.LoginScreen
import com.example.litthu_eyelash_app.presentation.theme.LitthuTheme

@Composable
fun LitthuApp() {
    LitthuTheme {
        MyScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Litthu Eyelash") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add new item */ }) {
                Text("+")
            }
        },
        content = { paddingValues ->
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues),
//                contentPadding = PaddingValues(16.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                items(5) { index ->
//                    EyelashItem(index)
//                }
//            }
            LoginScreen()
        }
    )
}

@Composable
fun EyelashItem(index: Int) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 4.dp // Tạo bóng nhẹ
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Eyelash Product ${index + 1}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = "Premium quality, natural look",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Button(
                onClick = { /* View details */ },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("View Details")
            }
        }
    }
}