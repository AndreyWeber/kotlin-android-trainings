package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import com.example.composequadrant.ui.theme.Violet1
import com.example.composequadrant.ui.theme.Violet2
import com.example.composequadrant.ui.theme.Violet3
import com.example.composequadrant.ui.theme.Violet4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                header = stringResource(R.string.text_composable_header),
                body = stringResource(R.string.text_composable_body),
                color = Violet1,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                header = stringResource(R.string.image_composable_header),
                body = stringResource(R.string.image_composable_body),
                color = Violet2,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                header = stringResource(R.string.row_composable_header),
                body = stringResource(R.string.row_composable_body),
                color = Violet3,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                header = stringResource(R.string.column_composable_header),
                body = stringResource(R.string.column_composable_body),
                color = Violet4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    header: String,
    body: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color)
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}