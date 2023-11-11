package com.example.tapcounter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tapcounter.ui.theme.TapCounterTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tapcounter.viewmodel.CounterViewModel

@Composable
fun CounterComponent() {
    val startingCount = 0
    val counterViewModel: CounterViewModel = viewModel {
        CounterViewModel(startingCount)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Times pressed: ${counterViewModel.count.value}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { counterViewModel.incrementCounter() }) {
            Text("Press me")
        }
    }
}

@Preview(showBackground =  true, showSystemUi = true)
@Composable
fun CounterScreenPreview() {
    TapCounterTheme {
        CounterComponent()
    }
}