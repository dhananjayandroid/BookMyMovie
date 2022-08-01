package com.example.bookmyshow.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookmyshow.R
import com.example.bookmyshow.utils.popUpToTop
import com.example.bookmyshow.view.ui.navigation.Screen
import com.example.bookmyshow.view.ui.theme.PoppinsTypography
import com.example.bookmyshow.view.ui.theme.Purple700
import com.example.bookmyshow.viewmodel.ConfirmationViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ConfirmationScreen(navController: NavController, viewModel: ConfirmationViewModel) {
    Surface(color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            ProfileHeader(viewModel)
            SimpleTitleField(viewModel)
            ShowTimings()
            TicketCountDropdown()
            ConfirmationButton(navController)
        }
    }
}

@Composable
private fun ProfileHeader(
    viewModel: ConfirmationViewModel,
) {
    viewModel.imageBanner?.let {
        GlideImage(
            imageModel = it,
            contentScale = ContentScale.Crop,
            placeHolder =  ImageBitmap.imageResource(R.drawable.movieticket),
            error =  ImageBitmap.imageResource(R.drawable.movieticket),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RectangleShape)
        )
    }
}

@Composable
fun SimpleTitleField(viewModel: ConfirmationViewModel) {
    Text(viewModel.movieName, style = PoppinsTypography.body2, modifier = Modifier.padding(start = 20.dp, top = 20.dp))
    Text(viewModel.theaterName, style = PoppinsTypography.body1, modifier = Modifier.padding(start = 20.dp, top = 20.dp))
    Text(viewModel.theaterAddress,
        style = PoppinsTypography.subtitle2,
        modifier = Modifier.padding(start = 20.dp))
    Text("Select show-time",
        style = PoppinsTypography.subtitle2,
        modifier = Modifier.padding(start = 20.dp, top = 30.dp))
}

@Composable
fun ShowTimings() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        val radioGroupOptions = listOf("10:30 am", "2:00 pm", "5:30 pm")
        val selected = remember { mutableStateOf(radioGroupOptions[0]) }
        Row(modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)) {
            radioGroupOptions.forEach{
                RadioButton(selected = selected.value == it, onClick = {
                    selected.value = it
                })
                Spacer(modifier = Modifier.size(1.dp))
                Text(it, modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.size(4.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TicketCountDropdown(){
    val options = listOf("1", "2", "3", "4")

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text("Number of Tickets") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.White)
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Composable
fun ConfirmationButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.ConfirmedScreen.route) {
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
            text = "Confirm",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = PoppinsTypography.body2
        )
    }
}