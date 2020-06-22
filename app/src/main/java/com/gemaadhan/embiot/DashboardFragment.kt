package com.gemaadhan.embiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.gemaadhan.embiot.databinding.FragmentDashboardBinding

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDashboardBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)

        binding.cardView3.setOnClickListener { this.findNavController().navigate(R.id.action_dashboardFragment_to_formovertimeFragment) }
        binding.cardView.setOnClickListener { this.findNavController().navigate(R.id.action_dashboardFragment_to_showovertimeFragment) }
        return binding.root
    }

}
