package com.gemaadhan.embiot

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gemaadhan.embiot.formovertime.FormovertimeFragment
import com.gemaadhan.embiot.overtime.ShowovertimeFragment

@Suppress("DEPRECATION")
class PagerOvertimeFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val fragments: ArrayList<Fragment> = arrayListOf(
        FormovertimeFragment(),
        ShowovertimeFragment()
    )



    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}