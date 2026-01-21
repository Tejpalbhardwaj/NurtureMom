package com.example.nurturemom.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nurturemom.R
import com.example.nurturemom.ui.theme.LightPink
import com.example.nurturemom.ui.theme.Pink
import com.example.nurturemom.ui.theme.TopPink
import com.example.nurturemom.vm.VitalsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VitalsScreen(viewModel: VitalsViewModel) {


    val Poppins = FontFamily(
        Font(R.font.poppins_regular , FontWeight.Normal)
    )

    val vitals by viewModel.vitals.collectAsState()
    var showDialog by remember { mutableStateOf(false) }


        Scaffold(containerColor = LightPink,
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Track My Pregnancy" , fontFamily = Poppins , fontWeight = FontWeight.Bold)
                    } , colors = TopAppBarDefaults.topAppBarColors(containerColor = TopPink)
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    containerColor = Pink,
                    onClick = { showDialog = true }) {
                    Text("+", fontSize = 32.sp)
                }
            }
        )
        { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(vitals) { item ->
                    MainCard(item , onDelete = {viewModel.deleteVitals(item)})
                }
            }
        }


    if (showDialog) {
        AddVitalsDialog(
            onDismiss = { showDialog = false },
            onSave = { viewModel.addVitals(it) }
        )
    }
}
