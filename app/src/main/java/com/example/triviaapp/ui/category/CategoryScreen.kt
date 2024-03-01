package com.example.triviaapp.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {

    val categoryList by viewModel.categoryList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getCategoryList()
    }

    val coroutineScope = rememberCoroutineScope()
    SideEffect {
        if (categoryList.isEmpty()) {
            coroutineScope.launch {
                delay(1000)
            }
        }
    }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(
            text = "Categories",
            color = Color.Black,
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(contentPadding = PaddingValues(12.dp)) {
            items(categoryList.size / 2) { index ->
                ColumnItem(
                    name1 = categoryList[index].name!!,
                    name2 = categoryList[index + 1].name!!)
                Spacer(modifier = Modifier.height(18.dp))
            }
        }

    }
}

@Composable
fun ColumnItem(
    name1: String,
    name2: String
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Item(name = name1)
        Spacer(modifier = Modifier.width(12.dp))
        Item(name = name2)
    }
}

@Composable
fun Item(name: String) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .shadow(elevation = 12.dp, shape = RoundedCornerShape(35.dp))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(35.dp)
            )
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name
                ,color = Color.Black,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}