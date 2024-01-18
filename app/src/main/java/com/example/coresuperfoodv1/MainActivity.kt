package com.example.coresuperfoodv1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coresuperfoodv1.ui.theme.CoreSuperFoodv1Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreSuperFoodv1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting()
                        Spacer(modifier = Modifier.padding(0.5.dp))
                        Top()
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Row(
        Modifier
            .background(Color(0xFF6f1dc9))
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "NO DAIRY, NO PRESERVATIVES, NO ADDED SUGAR",
        color = Color.White, fontWeight = FontWeight.Bold,
        modifier = Modifier.weight(1f))
        Text(text = "FOR SUBSCRIPTION WHATSAPP US ON 8826683886",
        color = Color.White, fontWeight = FontWeight.Bold,
        modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoreSuperFoodv1Theme {
        Greeting()
        Top()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Top()
{
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope =  rememberCoroutineScope()

    Scaffold(
        scaffoldState=scaffoldState,
        topBar = { CenterAlignedTopAppBarExample(
            navController =navController,
            onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        ) }, drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {

            DrawerHeader()
            var  items = listOf(
                MenuItem(
                    id = "Shop",
                title = "Shop",
            contentDescription = "Go to Shop"

            ),
            MenuItem(
                id = "Our Story",
            title = "Our Story",
            contentDescription = ""

            ),
            MenuItem(
                id = "Customer speak",
            title = "Customer speak",
            contentDescription = "Customer speak"

            )
            )
            DrawerBody(items)
        }

    ) {
        it
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarExample(navController: NavController,
                                  onNavigationIconClick: () -> Unit,) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                        Image(painterResource(id = R.drawable.actionbarimage), contentDescription = null,

                            modifier = Modifier.padding(15.dp))
                },
                navigationIcon = {
                    IconButton(onClick = onNavigationIconClick) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Localized description"
                        )
                    }
                },

                scrollBehavior = scrollBehavior,
            )
        },
    ) {
        innerPadding ->
        ScrollContent(innerPadding)
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
   // TODO("Not yet implemented")
}

@Composable
fun DrawerHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp)
        ,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}
@Composable
private fun DrawerMenuItem(
    iconDrawableId: Int,
    text: String,
    onItemClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            painter = painterResource(iconDrawableId),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, )
    }
}
@Composable
fun DrawerBody(items: List<MenuItem>) {

    items.forEach { menuItem ->

            Text(text = menuItem.title, fontSize = 20.sp,modifier=Modifier.padding(15.dp))


    }
}
