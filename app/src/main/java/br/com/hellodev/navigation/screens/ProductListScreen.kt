package br.com.hellodev.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.hellodev.navigation.User

@Composable
fun ProductListScreen(
    name: String?,
    result: String?,
    navigateToProductDetailsScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    ProductListContent(
        name = name,
        result = result,
        navigateToProductDetailsScreen = navigateToProductDetailsScreen,
        onBackPressed = onBackPressed
    )
}

@Composable
fun ProductListContent(
    name: String?,
    result: String?,
    navigateToProductDetailsScreen: () -> Unit,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ProductListScreen")

        Text(text = "Name: $name")

        Text(text = "Result: $result")

        Button(onClick = { navigateToProductDetailsScreen() }) {
            Text(text = "Navigate to ProductDetailsScreen")
        }

        Button(onClick = { onBackPressed() }) {
            Text(text = "Go back")
        }
    }
}

@Preview
@Composable
fun ProductListPreview() {
    ProductListContent(
        name = "Arley Santana",
        result = "Jetpack Compose",
        navigateToProductDetailsScreen = {},
        onBackPressed = {}
    )
}