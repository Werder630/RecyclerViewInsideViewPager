package com.werder.recyclerviewinsideviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity(), SecondFragment.Disabler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hello)

        val adapter = Adapter(this)
        viewpager.adapter = adapter
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(tabs, viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = "Text $position"
            }).attach()
    }

    override fun enable() {
        viewpager.isUserInputEnabled = true
    }

    override fun disable() {
        viewpager.isUserInputEnabled = false
    }
}