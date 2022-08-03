package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                Column(
                   modifier = Modifier
                       .background(Grey)
                       .fillMaxSize()
                ) {
                    HeaderProfileComponent()
                    SearchInputComponent()
                }
            }
        }
    }
    @Composable
    fun HeaderProfileComponent() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, end = 25.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "Welcome Back",
                        fontFamily = nunitoLight,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Dennis Odhiambo",
                        fontFamily = nunitoMedium,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )

                }

            }
            BadgedBox(badge = { Badge(backgroundColor = Green) }) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )
            }

        }
    }

    @Composable
    fun SearchInputComponent() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Search", fontFamily = nunitoLight) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Filter Icon",
                 )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.LightGray,
                trailingIconColor = Black
            )
        )
    }
}

