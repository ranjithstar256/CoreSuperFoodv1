package com.fcenesiz.navigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Row (
                Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFA084C0))){
                AsyncImage(
                    model = "https://coresuperfood.in/cdn/shop/files/Hnet.com-image_200x.jpg?v=1644303486",
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Row(Modifier.fillMaxSize().background(Color(0xFFA084C0)), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "", modifier = Modifier.weight(1f))
                }
            }
        },
        backgroundColor = Color(0xFFA084C0),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle Drawer")
            }
        }
    )
}