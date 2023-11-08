package com.example.mytestnavigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pantalla1Screen(
    modifier: Modifier = Modifier,
    goToPage2: (String) -> Unit,
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Pantalla 1",
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                goToPage2("Pantalla 1")
            }
        ) {
            Text(
                text = "Ir a la pantalla 2"
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Pantalla1ScreenPreview(){
    Pantalla1Screen(
        goToPage2 = {}
    )
}