package com.example.nurturemom.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "vitals")
data class VitalsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val systolic: String,
    val diastolic: String,
    val heartRate: String,
    val weight: String,
    val babyKicks: String ,

    val createdAt: Long = System.currentTimeMillis()
)
