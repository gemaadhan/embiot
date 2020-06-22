package com.gemaadhan.embiot.formovertime


import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gemaadhan.embiot.R
import com.gemaadhan.embiot.database.LemburDatabase
import com.gemaadhan.embiot.databinding.FragmentFormovertimeBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.util.*


/**
 * A simple [Fragment] subclass.
 */


@Suppress("DEPRECATION")
class FormovertimeFragment : Fragment() {
    private val PAID = arrayOf(
        "100000", "200000"
    )

    lateinit var binding: FragmentFormovertimeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_formovertime, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = LemburDatabase.getInstance(application).lemburDatabaseDao
        val viewModelFactory = FormovertimeViewModelFactory(dataSource, application)
        val formovertimeViewModel =
            ViewModelProvider(this, viewModelFactory).get(FormovertimeViewModel::class.java)
        binding.formovertimeViewModel = formovertimeViewModel
        binding.setLifecycleOwner(this)


        //autocomplete paid
        val editTextPaid: AutoCompleteTextView = binding.etPaid
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_list_item_1, PAID
        )
        editTextPaid.setAdapter(adapter)


        formovertimeViewModel.showDatePicker.observe(this, Observer {
            if (it == true) {
                val mcurrentTime = Calendar.getInstance()
                val year = mcurrentTime[Calendar.YEAR]
                val month = mcurrentTime[Calendar.MONTH]
                val day = mcurrentTime[Calendar.DAY_OF_MONTH]

                val dpd = DatePickerDialog(
                    activity!!,
                    OnDateSetListener { view, myear, mmonth, mdayOfMonth ->
                        binding.etDate.setText(
                            String.format(
                                "%02d/%01d/%04d",
                                mdayOfMonth,
                                mmonth,
                                myear
                            )
                        )
                    },
                    year,
                    month,
                    day
                )
                dpd.show()
                formovertimeViewModel.onDatePickerStopClicked()
            }
        })


        formovertimeViewModel.showTimePickerStart.observe(this, Observer
        {

            if (it == true) {
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog

                mTimePicker = TimePickerDialog(
                    activity,
                    OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                        binding.etStartTime.setText(
                            String.format(
                                "%02d:%02d WIB",
                                selectedHour,
                                selectedMinute
                            )
                        )
                    }, hour, minute, true
                ) //Yes 24 hour time

                mTimePicker.show()
                formovertimeViewModel.onTimePickerStopClicked()
            }


        })

        formovertimeViewModel.showTimePickerEnd.observe(this, Observer
        {
            if (it == true) {
                val mcurrentTime = Calendar.getInstance()
                val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
                val minute = mcurrentTime[Calendar.MINUTE]
                val mTimePicker: TimePickerDialog

                mTimePicker = TimePickerDialog(
                    activity,
                    OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                        binding.etStopTime.setText(
                            String.format(
                                "%02d:%02d WIB",
                                selectedHour,
                                selectedMinute
                            )
                        )
                    }, hour, minute, true
                ) //Yes 24 hour time


                mTimePicker.show()
                formovertimeViewModel.onTimePickerEndStopClicked()
            }
        })

        formovertimeViewModel.showSnackBarEvent.observe(this, Observer {

            Snackbar.make(
                activity!!.findViewById(android.R.id.content),
                "$it",
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
            // Reset state to make sure the toast is only shown once, even if the device
            // has a configuration change.


        })

        binding.btnOk.setOnClickListener {

            var mvEtDate = binding.etDate.text.toString()
            var mvetStartTime = binding.etStartTime.text.toString()
            var mvetStopTime = binding.etStopTime.text.toString()
            var mvetJob = binding.etJob.text.toString()
            var mvetCustomer = binding.etCustomer.text.toString()
            var mvetPaid = 0L
            try {
                mvetPaid = binding.etPaid.text.toString().toLong()
            } catch (e: Exception) {
                Log.i("main", "masih error")
            }


            if (mvEtDate.isEmpty() || mvetStartTime.isEmpty() || mvetStopTime.isEmpty() || mvetJob.isEmpty() || mvetCustomer.isEmpty() || mvetPaid.toString().isEmpty()
                || mvetPaid == 0L
            ) {
                Toast.makeText(getActivity(), "DIISI SEMUA DULU DONG", Toast.LENGTH_SHORT).show();
            } else {
                formovertimeViewModel.onStart(
                    mvEtDate,
                    mvetStartTime,
                    mvetStopTime,
                    mvetJob,
                    mvetCustomer,
                    mvetPaid
                )
                binding.etDate.text.clear()
                binding.etStartTime.text.clear()
                binding.etStopTime.text.clear()
                binding.etJob.text.clear()
                binding.etCustomer.text.clear()
                binding.etPaid.text.clear()
            }
        }

        return binding.root


    }


}
