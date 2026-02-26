package com.tedmoon.doclensapp.common

import androidx.fragment.app.Fragment
import com.tedmoon.doclensapp.home.HomeFragment

enum class FragmentName(var str: String) {
    FRAGMENT_HOME("HomeFragment");

    fun create(): Fragment {
        return when (this) {
            FRAGMENT_HOME -> HomeFragment()
        }
    }
}