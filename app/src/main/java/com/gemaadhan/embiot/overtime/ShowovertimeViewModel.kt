package com.gemaadhan.embiot.overtime

import android.app.Application
import androidx.lifecycle.ViewModel
import com.gemaadhan.embiot.database.LemburDatabaseDao

class ShowovertimeViewModel (dataSource: LemburDatabaseDao, application: Application) : ViewModel() {
    val database = dataSource
    val overtimes = database.getAllOvertime()
}