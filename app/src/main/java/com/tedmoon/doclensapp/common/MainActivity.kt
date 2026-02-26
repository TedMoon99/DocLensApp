package com.tedmoon.doclensapp.common

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.tedmoon.doclensapp.R
import com.tedmoon.doclensapp.databinding.ActivityMainBinding
import com.tedmoon.doclensapp.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        replaceFragment(name = FragmentName.FRAGMENT_HOME, addToBackStack = false, animate = false)
    }


    // 지정한 Fragment를 보여주는 메서드
    fun replaceFragment(
        name: FragmentName,
        addToBackStack: Boolean,
        animate: Boolean = false
    ) {
        // Fragment 교체 상태로 설정
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        // 새로운 Fragment를 담을 변수
        val newFragment: Fragment = name.create()


        // Fragment 교체
        fragmentTransaction.replace(R.id.mainContainer, newFragment)

        if (animate) {
            // 애니메이션 설정
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }

        if (addToBackStack) {
            // Fragment를 BackStack에 삽입
            fragmentTransaction.addToBackStack(name.str)
        }

        // 실행
        fragmentTransaction.commit()
    }

    private fun removeFragment(name: FragmentName) {
        supportFragmentManager.popBackStack(name.str, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}