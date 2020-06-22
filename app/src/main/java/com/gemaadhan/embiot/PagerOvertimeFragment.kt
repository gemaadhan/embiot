package com.gemaadhan.embiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.gemaadhan.embiot.databinding.FragmentPagerOvertimeBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass.
 */
class PagerOvertimeFragment : Fragment() {
    lateinit var pagerOvertimeFragmentAdapter: PagerOvertimeFragmentAdapter
    lateinit var viewPager2: ViewPager2
    lateinit var binding: FragmentPagerOvertimeBinding
    val tabsname: ArrayList<String> = arrayListOf(
        "Detail", "Add"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pager_overtime, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerOvertimeFragmentAdapter = PagerOvertimeFragmentAdapter(this)
        viewPager2 = binding.pager
        viewPager2.adapter = pagerOvertimeFragmentAdapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "${tabsname[position]}"
        }.attach()
    }

}
