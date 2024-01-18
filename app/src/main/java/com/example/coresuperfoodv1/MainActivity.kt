package com.example.coresuperfoodv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coresuperfoodv1.ui.theme.CoreSuperFoodv1Theme
import com.fcenesiz.navigationdrawer.AppBar
import com.fcenesiz.navigationdrawer.DrawerBody
import com.fcenesiz.navigationdrawer.MenuItemm
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreSuperFoodv1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                  tpb()
                }
            }
        }
    }
}

@Composable
fun tpb(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Column {
        Greeting()
        Scaffold(
            scaffoldState= scaffoldState,
            backgroundColor = Color(0xFFA084C0),
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            // to disable drawer gesture when drawer is disappeared
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerContent = {

                //DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItemm(
                            id = "home",
                            title = "Shop",
                            contentDescription = "Go to Home Screen"
                        ),
                        MenuItemm(
                            id = "settings",
                            title = "Our Story",
                            contentDescription = "Go to Settings Screen"
                        ),
                        MenuItemm(
                            id = "help",
                            title = "Customer Speak",
                            contentDescription = "Get Help"
                        )
                    )
                ) {
                    //when(it.id) ...
                    println("Clicked on ${it.title}")
                }
            }
        ) {
      //      it
            ScrollContent(innerPadding = it)
        }
        Column {
            Text(text = "sometign", fontSize = 45.sp)
        }
    }
}


@Composable
fun Greeting() {

    Row(
        Modifier
            .background(Color(0xFF6f1dc9))
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "NO DAIRY, NO PRESERVATIVES, NO ADDED SUGAR",
            color = Color.White, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "FOR SUBSCRIPTION WHATSAPP US ON 8826683886",
            color = Color.White, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            modifier = Modifier.weight(1f)
        )
    }

}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    LazyColumn(
        contentPadding = innerPadding,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFA084C0))
            .padding(start = 30.dp, end = 30.dp)
    ) {
        item {
            Image(
                painterResource(id = R.drawable.coresuperfoodhomeimege),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Adjust the height as needed
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Preorder Now")
            }
        }
        item {
            Column(
                Modifier.padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Know Us",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.White
                )
                Text(
                    text = "NO DAIRY. NO ADDED SUGAR. NO PRESERVATIVES",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 3.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Promise of CORE is to offer freshly prepared Plant Based Beverages, BREAKFAST JARS, JUICES, SMOOTHIES, NUT BUTTER SPREADS & ENERGY BITES making it easier for your body to nourish, taste and that also without too much effort. We make our products from scratch daily to keep it fresh and pure. So, we request you to preorder your favourite products 24 hours in advance.",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
                Text(
                    text = "All our products have been developed in consultation with Shalini Arora, Dubai based Natural Hygiene Health Coach certified by “Institute of Integrative Nutrition” & “Fit for Life Science Institute”",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 2.dp),
                    color = Color.White
                )

                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painterResource(id = R.drawable.one),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(5.dp)
                            .height(100.dp) // Adjust the height as needed
                    )
                    Image(
                        painterResource(id = R.drawable.two),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(5.dp)

                            .height(100.dp) // Adjust the height as needed
                    )
                    Image(
                        painterResource(id = R.drawable.three),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)

                            .weight(1f)
                            .height(100.dp) // Adjust the height as needed
                    )
                    Image(
                        painterResource(id = R.drawable.four),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(5.dp)

                            .height(100.dp) // Adjust the height as needed
                    )
                    Image(
                        painterResource(id = R.drawable.five),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)

                            .weight(1f)
                            .height(100.dp) // Adjust the height as needed
                    )

                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(top = 5.dp, bottom = 20.dp)
                ) {
                    Text(text = "Know More")
                }
            }
        }
        item {
            Column(
                Modifier.padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "goCore Superfood",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(30.dp),
                    color = Color.White
                )
                Text(
                    text = "We deliver freshly prepared health & nutritious food every morning at your doorstep!”",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Image(
                    painterResource(id = R.drawable.beverage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Plant Based Beverage Alternatives",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "goCore Superfoods is proud to bring the purest, freshest, plant based beverages to your doorstep. They are rich in vitamins and minerals, low in fat and do not contain cholesterol. They have a healthy combination of mono- and polyunsaturated fats that is perfect for people with a slow digestive system. Give it a go!",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
                Image(
                    painterResource(id = R.drawable.fakefastjar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Breakfast Jars",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Have you ever dreamt of something that is nutrient-dense, healthy yet amazingly tasty. Your search ends here. goCore Superfoods has created a breakfast jar with fruits, nuts, seeds and a lot more healthy ingredients bound to get you hooked - delivered daily in a eco-friendly packaging to your home. It keeps you full till the next meal so you don't snack on foods that are not good for you. Choose from our tempting range today!",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
            }
        }

        item {
            Column(
                Modifier.padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "JUICES & SMOOTHIES",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Image(
                    painterResource(id = R.drawable.freshjuice),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Fresh Juice",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Beat the summer and give your body the nutrition boost it needs with goCore Superfoods' pure, 100% freshly squeezed juices, packed hygienically and delivered to your doorstep. With powerhouse ingredients like oranges, carrots, beet, pomegranate, greens and more, our juices pack a punch.",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
                Image(
                    painterResource(id = R.drawable.smoothies),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Smoothies",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Having hunger pangs but don't want to reach for that unhealthy snack? We have just the right fix for you. Range of smoothies with no diary, no added sugar and no preservatives. Grab your protein packed, delicious smoothie from goCore Superfoods now!",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
            }
        }
        item {
            Column(
                Modifier.padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "goCore Superfood",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(30.dp),
                    color = Color.White
                )
                Text(
                    text = "SNACKS & SPREADS",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Image(
                    painterResource(id = R.drawable.healthyspreads),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Healthy Spreads",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "goCore Superfoods offers protein rich, peanut butter made from scratch with love and an extra dose of superfoods (like dates). Go on - get one for your toast and taste for yourself how refreshingly different it tastes from a preservative laden store alternative.",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
                Image(
                    painterResource(id = R.drawable.energypackedsnaks),
                    contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                )
                Text(
                    text = "Energy Packed Snacks",
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "It's a long day at work and you are looking for that pick-me-up snack that won't fill you with guilt later. Look no further. goCore Superfoods has cooked up an assorted range of healthy snacks like peanut butter bites and cocoa dates energy bites with more delicious concoctions on the way. We bet you can't stop at one!",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 5.dp, bottom = 15.dp),
                    color = Color.White,
                )
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 5.dp)) {
                    Text(text = "Preorder Now")
                }
            }
        }
    }
}