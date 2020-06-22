package com.gemaadhan.embiot.pagerovertime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.gemaadhan.embiot.R
import com.gemaadhan.embiot.databinding.FragmentMainOvertimeBinding

/**
 * A simple [Fragment] subclass.
 */
class MainOvertimeFragment : Fragment() {

    lateinit var binding: FragmentMainOvertimeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_overtime, container, false)



        return binding.root
    }

}
