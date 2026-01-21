package com.example.nurturemom.data

import android.content.Context
import com.example.nurturemom.room.VitalsDao
import com.example.nurturemom.room.VitalsEntity

class VitalsRepository(private val dao: VitalsDao) {

    val vitalsList = dao.getAllVitals()

    suspend fun insert(vitals: VitalsEntity) {
        dao.insertVitals(vitals)
    }

    suspend fun delete(vitals: VitalsEntity) {
        dao.deleteVitals(vitals)
    }
}


