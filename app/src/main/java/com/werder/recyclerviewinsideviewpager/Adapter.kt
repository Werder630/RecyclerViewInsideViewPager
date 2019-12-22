package com.werder.recyclerviewinsideviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstFragment()
            1 ->  SecondFragment()
            2 -> ThirdFragment()
            else -> throw IllegalArgumentException("")
        }
    }
}

