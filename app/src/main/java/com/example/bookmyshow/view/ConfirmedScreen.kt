package com.example.bookmyshow.view

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookmyshow.R
import com.example.bookmyshow.utils.popUpToTop
import com.example.bookmyshow.view.ui.navigation.Screen
import com.example.bookmyshow.view.ui.theme.PoppinsTypography
import com.example.bookmyshow.view.ui.theme.Purple700

@Composable
fun ConfirmedScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ConfirmedImage()
            Text("Thank you for your booking. Your ticket is confirmed.",
                style = PoppinsTypography.body1,
                modifier = Modifier.padding(40.dp),
                textAlign = TextAlign.Center,)
            DoneButton(navController = navController)
        }
    }
}

@Composable
@Preview
private fun ConfirmedImage() {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)) {
        Image(painter = painterResource(id = R.drawable.accept),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}


@Composable
fun DoneButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.TheaterScreen.route) {
                popUpToTop(navController)
            }
        },
        modifier = Modifier
            .height(110.dp)
            .padding(10.dp, 50.dp, 10.dp, 10.dp)
            .fillMaxWidth(),
        enabled = true,
        colors = ButtonDefaults.buttonColors(backgroundColor = Purple700),
        shape = MaterialTheme.shapes.medium,
    )
    {
        Text(
            text = "Done",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = PoppinsTypography.body2
        )
    }
}