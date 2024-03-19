package br.com.hellodev.navigation.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsScreen(
    onBackPressed: (String?) -> Unit
) {
    ProductDetailsContent(
        onBackPressed = onBackPressed
    )
}

@Composable
fun ProductDetailsContent(
    onBackPressed: (String?) -> Unit
) {

    var resultValue by remember {
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
        Text(text = "ProductDetailsScreen")

        OutlinedTextField(
            value = resultValue,
            onValueChange = {
                resultValue = it
            }
        )

        Button(onClick = { onBackPressed(resultValue) }) {
            Text(text = "Go back")
        }
    }
}

@Preview
@Composable
fun ProductDetailsPreview() {
    ProductDetailsContent(
        onBackPressed = {}
    )
}