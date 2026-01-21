package com.example.nurturemom.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.util.Locale
import com.example.nurturemom.room.VitalsEntity
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSave: (VitalsEntity) -> Unit
) {
    var sys by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var hr by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                onSave(
                    VitalsEntity(
                        systolic = sys,
                        diastolic = dia,
                        heartRate = hr,
                        weight = weight,
                        babyKicks = kicks
                    )
                )
                onDismiss()
            }) {
                Text("Submit")
            }
        },
        title = { Text("Add Vitals") },
        text = {
            Column {
                TextField(value = sys, onValueChange = { sys = it }, label = { Text("Sys BP") })
                TextField(value = dia, onValueChange = { dia = it }, label = { Text("Dias BP") })
                TextField(value = hr, onValueChange = { hr = it }, label = { Text("Heart Rate") })
                TextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight") })
                TextField(
                    value = kicks,
                    onValueChange = { kicks = it },
                    label = { Text("Baby Kicks") })
            }
        }
    )
}

