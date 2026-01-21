package com.example.nurturemom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface VitalsDao {

    @Insert
    suspend fun insertVitals(vitals: VitalsEntity)

    @Delete
    suspend fun deleteVitals(vitals: VitalsEntity)

    @Query("SELECT * FROM vitals ORDER BY id DESC")
    fun getAllVitals(): Flow<List<VitalsEntity>>
}
