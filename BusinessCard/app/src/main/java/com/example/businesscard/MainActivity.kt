package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.LightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(LightGreen)
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Name()
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Contacts(
            modifier = Modifier
                .padding(bottom = 40.dp)
        )
    }
}

@Composable
fun Name(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 34.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(R.string.title),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun Contacts(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val phoneIcon = painterResource(R.drawable.baseline_phone_24)
        val shareIcon = painterResource(R.drawable.baseline_share_24)
        val emailIcon = painterResource(R.drawable.baseline_email_24)
        ContactRow(
            icon = phoneIcon,
            contentDescription = "Phone number",
            contact = "+44 (75) 322 223",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        ContactRow(
            icon = shareIcon,
            contentDescription = "Social media",
            contact = "@socialmediahandler",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        ContactRow(
            icon = emailIcon,
            contentDescription = "Email",
            contact = "email@domail.com"
        )
    }
}

@Composable
fun ContactRow(
    icon: Painter,
    contentDescription: String,
    contact: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier.padding(end = 12.dp)
        )
        Text(
            text = contact,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}