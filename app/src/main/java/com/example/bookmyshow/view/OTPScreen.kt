package com.example.bookmyshow.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
import com.example.bookmyshow.view.ui.theme.PoppinsTypography
import com.example.bookmyshow.view.ui.theme.Purple700
import com.example.bookmyshow.viewmodel.OTPViewModel


@Composable
fun OTPScreen(navController: NavController, viewModel: OTPViewModel) {

    Surface(color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val context = LocalContext.current
            StringOTPText()
            SimpleOTPField()
            ContinueMoviesButton(navController)
        }
    }
}
@Composable
fun StringOTPText() {
    Column(
        modifier = Modifier
            .padding(10.dp, 200.dp, 10.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.otp_message),
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SimpleOTPField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "OTP",
            style = PoppinsTypography.body2) },
        placeholder = { Text(text = "OTP",
            style = PoppinsTypography.body2) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 50.dp, 10.dp, 10.dp)
    )
}


@Composable
fun ContinueMoviesButton(navController: NavController) {
    Button(
        onClick = {

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
