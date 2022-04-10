package com.example.charles.curriculumvitae

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.charles.curriculumvitae.fragments.About
import com.example.charles.curriculumvitae.fragments.Contact
import com.example.charles.curriculumvitae.fragments.Home
import com.example.charles.curriculumvitae.fragments.WorkExperience

class PagerViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Home()
            }
            1 -> {
                About()
            }
            2 -> {
                WorkExperience()
            }
            3 -> {
                Contact()
            }
            else -> Fragment()
        }
    }

    override fun getCount(): Int {

        return 4
    }
}