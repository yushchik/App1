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


        //ex.2
        binding.btnChangeFragment.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.containerFL, BlankFragment())
//                .commit()
            val ft2 = supportFragmentManager.beginTransaction()

            ft2.replace(R.id.containerFL, BlankFragment()).commit()
//            supportFragmentManager.commit {
//                replace(R.id.containerFL, BlankFragment())
//            }
        }

//        ex.3
//        supportFragmentManager
//            .setFragmentResultListener("requestKey", this) { requestKey, bundle ->
//                // We use a String here, but any type that can be put in a Bundle is supported
//                val result = bundle.getString("bundleKey")
//                // Do something with the result
//                binding.tvTittle.text = result
//            }
        //
        // ex.4
        supportFragmentManager
            .setFragmentResultListener("requestKey", this) { requestKey, bundle ->
                // We use a String here, but any type that can be put in a Bundle is supported
                val result = bundle.getBoolean("boolKey")
                // Do something with the result
                if(result) changeFragment()
            }

//        ex.5
//        binding.btnChangeFragment2.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.containerFL, FirstFragment())
//                .commit()
//        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        if(supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStackImmediate()
        }
        else{
            super.onBackPressed()
        }
    }

    private fun changeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFL, BlankFragment.newInstance("Second"))
            .commit()
    }

}



