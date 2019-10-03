package com.folioreader.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

/**
 * FolioReader-Android
 * Copyright © 2019 PT. MetraPlasa.
 *
 *
 * Created by asadurrahman.qayyim on 10/2/2019
 */

class ContentHighlightPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val mFragments = ArrayList<Fragment>()
    private val mTitleFragments = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mTitleFragments.add(title)
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleFragments[position]
    }
}
