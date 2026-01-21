package com.example.nurturemom.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.AirlineSeatLegroomExtra
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.CorporateFare
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nurturemom.R
import com.example.nurturemom.room.VitalsEntity
import com.example.nurturemom.ui.theme.DarkPink
import com.example.nurturemom.ui.theme.Pink

@Composable
fun MainCard(vital: VitalsEntity, onDelete:()-> Unit) {

    val Poppins = FontFamily(
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_med, FontWeight.Medium)
    )


    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {

            // 🔹 TOP LIGHT PURPLE AREA
            Box(
                modifier = Modifier
                    .background(Pink)
                    .padding(16.dp)
            ) {
                Column {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        VitalItem(
                            icon = Icons.Default.MonitorHeart,
                            text = "${vital.heartRate} bpm",
                        )

                        VitalItem(
                            icon = Icons.Default.AirlineSeatLegroomExtra,
                            text = "${vital.babyKicks} kicks"
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        VitalItem(
                            icon = Icons.Default.MonitorWeight,
                            text = "${vital.weight} kg"
                        )

                        VitalItem(
                            icon = Icons.Default.ChildCare,
                            text = "${vital.babyKicks} kicks"
                        )
                    }
                }
            }

            // 🔹 BOTTOM DARK PURPLE STRIP
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkPink)
                    .padding(vertical = 8.dp),

            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {

                    Text( text = "Delete?",
                        textDecoration = TextDecoration.Underline,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light ,
                        modifier = Modifier.clickable{onDelete()}
                        )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = formatDate(vital.createdAt),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun VitalItem(icon: ImageVector, text: String) {

    val Poppins = FontFamily(
        Font(R.font.poppins_light, FontWeight.Light),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_med, FontWeight.Medium)
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(text, fontWeight = FontWeight.Medium, fontFamily = Poppins, fontSize = 14.sp)
    }
}
