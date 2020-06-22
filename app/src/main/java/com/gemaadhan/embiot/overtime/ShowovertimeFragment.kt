package com.gemaadhan.embiot.overtime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.gemaadhan.embiot.R
import com.gemaadhan.embiot.database.LemburDatabase
import com.gemaadhan.embiot.databinding.FragmentShowovertimeBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class ShowovertimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShowovertimeBinding>(
            inflater,
            R.layout.fragment_showovertime,
            container,
            false
        )
        val application = requireNotNull(this.activity).application
        val dataSource = LemburDatabase.getInstance(application).lemburDatabaseDao
        val viewModelFactory = ShowovertimeViewModelFactory(dataSource, application)
        val showovertimeViewModel = ViewModelProviders.of(this, viewModelFactory).get(ShowovertimeViewModel::class.java)
        binding.showovertimeViewModel = showovertimeViewModel

        val adapter = OvertimeEntityAdapter(
            OvertimeEntityListener { overtimeId ->
                Toast.makeText(context, "${overtimeId}", Toast.LENGTH_LONG).show()
            })

        binding.sleepList.adapter = adapter

        showovertimeViewModel.overtimes.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.submitList(it)
            }
        })

        val manager = GridLayoutManager(activity, 1)
        binding.sleepList.layoutManager = manager

        return binding.root
    }

}
