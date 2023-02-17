package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.databinding.ActivityCustomBinding


class CustomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ft = supportFragmentManager.beginTransaction()
        val firstFragment = FirstFragment().newInstance(3, "first fragment")
        ft.replace(R.id.containerFL, firstFragment)
        ft.commit()

        val ft2 = supportFragmentManager.beginTransaction()
        val firstFragment2 = FirstFragment().newInstance(5, "first fragment 2")
        ft2.replace(R.id.containerFL2, firstFragment2)
        ft2.commit()
    }

}



