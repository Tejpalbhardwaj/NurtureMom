package com.example.nurturemom.vm

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nurturemom.data.VitalsRepository
import com.example.nurturemom.room.VitalsDatabase
import com.example.nurturemom.room.VitalsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalsViewModel(application: Application) : AndroidViewModel(application) {

    private val dao =
        VitalsDatabase.getDatabase(application).vitalsDao()

    private val repository = VitalsRepository(dao)

    val vitals = repository.vitalsList
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addVitals(v: VitalsEntity) {
        viewModelScope.launch {
            repository.insert(v)
        }
    }

    fun deleteVitals(v: VitalsEntity) {
        viewModelScope.launch {
            repository.delete(v)
        }
    }

}

