package com.example.bookmyshow.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookmyshow.R
import com.example.bookmyshow.utils.popUpToTop
import com.example.bookmyshow.view.ui.navigation.Screen
import com.example.bookmyshow.view.ui.theme.PoppinsTypography
import com.example.bookmyshow.view.ui.theme.Purple700
import com.example.bookmyshow.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel:LoginViewModel){
    Surface(color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val context = LocalContext.current

            StringRenameText()
            SimpleTextField()
            ContinueButton(navController)
        }
    }
}


@Composable
fun StringRenameText() {
    Column(
        modifier = Modifier
            .padding(10.dp, 200.dp, 10.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.login_message),
            style = PoppinsTypography.body1,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "phone") },
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "Phone number",
            style = PoppinsTypography.body2,
        ) },
        placeholder = { Text(text = "Phone number",
                style = PoppinsTypography.body2,
        ) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 50.dp, 10.dp, 10.dp)
    )
}


@Composable
fun ContinueButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.OTPScreen.route) {
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
            text = "Continue",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = PoppinsTypography.body2
            )
    }
}