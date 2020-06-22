package com.gemaadhan.embiot.pagerovertime.formovertime

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gemaadhan.embiot.database.LemburDatabaseDao
import com.gemaadhan.embiot.database.OvertimeEntity
import kotlinx.coroutines.*


class FormovertimeViewModel(
    dataSource: LemburDatabaseDao, application: Application
) : ViewModel() {

    val database = dataSource
    private var viewModelJob = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var thisovertime = MutableLiveData<OvertimeEntity>()


    private var _showDatePicker = MutableLiveData<Boolean?>()
    val showDatePicker: LiveData<Boolean?>
        get() = _showDatePicker

    fun onDatePickerClicked() {
        _showDatePicker.value = true
    }
    fun onDatePickerStopClicked() {
        _showDatePicker.value = false
    }

    private var _showTimePickerStart = MutableLiveData<Boolean?>()
    val showTimePickerStart: LiveData<Boolean?>
        get() = _showTimePickerStart

    fun onTimePickerStartClicked() {
        _showTimePickerStart.value = true
    }

    fun onTimePickerStopClicked() {
        _showTimePickerStart.value = false
    }

    private var _showTimePickerEnd = MutableLiveData<Boolean?>()
    val showTimePickerEnd: LiveData<Boolean?>
        get() = _showTimePickerEnd

    fun onTimePickerEndClicked() {
        _showTimePickerEnd.value = true
    }

    fun onTimePickerEndStopClicked() {
        _showTimePickerEnd.value = false
    }

    private var _showSnackbarEvent = MutableLiveData<String?>()
    val showSnackBarEvent: LiveData<String?>
        get() = _showSnackbarEvent





    fun onStart(mvEtDate: String, mvetStartTime: String,mvetStopTime: String,mvetJob: String,mvetCustomer: String,mvetPaid: Long) {

        uiScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            val newOvertime = OvertimeEntity()
            newOvertime.date = mvEtDate
            newOvertime.starttime = mvetStartTime
            newOvertime.stoptime = mvetStopTime
            newOvertime.job = mvetJob
            newOvertime.customer = mvetCustomer
            newOvertime.pay = mvetPaid
            insert(newOvertime)
        }
    }

    private suspend fun insert(newOvertime: OvertimeEntity) {
        withContext(Dispatchers.IO) {
            database.insert(newOvertime)
        }
    }


}





