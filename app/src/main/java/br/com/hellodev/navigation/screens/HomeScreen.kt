package br.com.hellodev.navigation.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.hellodev.navigation.User

@Composable
fun HomeScreen(
    navigateToProductListScreen: (String?) -> Unit
) {
    HomeContent(
        navigateToProductListScreen = navigateToProductListScreen,
    )
}

@Composable
private fun HomeContent(
    navigateToProductListScreen: (String?) -> Unit
) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    var nameValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "HomeScreen")

        val user = User(name = nameValue, age = 10)
        Button(onClick = {
            navigateToProductListScreen(nameValue.ifEmpty { null })
        }) {
            Text(text = "Navigate to ProductListScreen")
        }

        OutlinedTextField(
            value = nameValue,
            onValueChange = {
                nameValue = it
            }
        )

        Button(onClick = { activity?.finish() }) {
            Text(text = "Go back")
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    HomeContent(
        navigateToProductListScreen = {}
    )
}