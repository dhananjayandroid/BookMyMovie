package com.example.bookmyshow.view

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookmyshow.R
import com.example.bookmyshow.model.TheatersList
import com.example.bookmyshow.viewmodel.TheaterViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun TheaterScreen(navController: NavController, viewModel: TheaterViewModel) {
        Surface(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.fillMaxSize()
        ) {
            val list: List<TheatersList>? = viewModel.theaters.observeAsState().value
           // val showProgress = viewModel.progressLiveData.observeAsState().value

            customListView()
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            )
//            {
//                showProgress?.let {
//                    if (it) {
//                        CircularProgressIndicator(
//                            Modifier.align(Alignment.Center)
//                        )
//                    }
//                }
//
//            }
        }
    }

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun customListView() {
    // on below line we are creating and
    // initializing our array list
    lateinit var courseList: List<TheatersList>
    courseList = ArrayList<TheatersList>()

    // on below line we are adding data to our list.
    courseList = courseList + TheatersList(1,"Android", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1015.jpg")
    courseList = courseList + TheatersList(2,"JavaScript", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1095.jpg")
    courseList = courseList + TheatersList(3,"Python", "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1015.jpg")
    courseList = courseList + TheatersList(4, "C++","https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1095.jpg")


    // on below line we are creating a
    // lazy column for displaying a list view.
    LazyColumn {
        // on below line we are setting data for each item of our listview.
        itemsIndexed(courseList) { index, item ->
            // on below line we are creating a card for our list view item.
            Card(
                // inside our grid view on below line
                // we are adding on click for each item of our grid view.
                onClick = {
                    // inside on click we are displaying the toast message.
                   Log.d("test click", "")
                },
                // on below line we are adding
                // padding from our all sides.
                modifier = Modifier.padding(8.dp),

                // on below line we are adding
                // elevation for the card.
                elevation = 6.dp
            )
            {
                // on below line we are creating
                // a row for our list view item.
                Row(
                    // for our row we are adding modifier
                    // to set padding from all sides.
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    // on below line inside row we are adding spacer
                    Spacer(modifier = Modifier.width(5.dp))

                    courseList[index].image?.let {
                        NetworkImageLoader(
                            imageUrl = it,
                            modifier = Modifier
                                .height(60.dp)
                                .width(60.dp)
                                .padding(5.dp)
                        )
                    }

                    // on below line we are adding spacer between image and a text
                    Spacer(modifier = Modifier.width(5.dp))

                    // on the below line we are creating a text.
                    courseList[index].name?.let {
                        Text(
                            // inside the text on below line we are
                            // setting text as the langaueg name
                            // from our modal class.
                            text = it,

                            // on below line we are adding padding
                            // for our text from all sides.
                            modifier = Modifier.padding(4.dp),

                            // on below line we are adding color for our text
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NetworkImageLoader(imageUrl: String, modifier: Modifier = Modifier) {
    GlideImage(
        imageModel = imageUrl,
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}


