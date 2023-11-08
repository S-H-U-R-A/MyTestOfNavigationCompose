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
fun Pantalla2Screen(
    mensaje: String,
    goToScreen3: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Pantalla 2  $mensaje" ,
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                goToScreen3("Pantalla 2")
            }
        ) {
            Text(
                text = "Ir a la pantalla 3"
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Pantalla2ScreenPreview(){
    Pantalla2Screen(
        mensaje = "",
        goToScreen3 = {}
    )
}