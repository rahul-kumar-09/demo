package com.example.cloneapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cloneapp.fragments.BusinessesTabFragment
import com.example.cloneapp.fragments.PersonalTabFragment
import com.example.cloneapp.fragments.ServiceTabFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PersonalTabFragment()
            1 -> ServiceTabFragment()
            2 -> BusinessesTabFragment()
            else -> PersonalTabFragment()
        }
    }

}