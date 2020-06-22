package com.gemaadhan.embiot.overtime

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gemaadhan.embiot.database.LemburDatabaseDao

class ShowovertimeViewModelFactory(
    private val dataSource: LemburDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowovertimeViewModel::class.java)) {
            return ShowovertimeViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}