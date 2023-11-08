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
fun Pantalla3Screen(
    goToPage1: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Pantalla 3",
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                goToPage1("Pantalla 3")
            }
        ) {
            Text(
                text = "Ir a la pantalla 1"
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Pantalla3ScreenPreview(){
    Pantalla3Screen(
        goToPage1 = {}
    )
}