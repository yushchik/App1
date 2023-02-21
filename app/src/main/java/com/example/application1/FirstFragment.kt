package com.example.application1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.application1.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.textviewFirst.text = it.getString("SomeString", "")
        }

//        //ex.1
//        binding.btn.setOnClickListener {
//            val fragmentTrans = childFragmentManager.beginTransaction()
//            val firstFragment = FirstFragment().newInstance(3, "first fragment")
//            fragmentTrans.add(R.id.container, firstFragment).commit()
//        }

        //ex.3
//        binding.btn.setOnClickListener {
//            val result = "result"
//            // Use the Kotlin extension in the fragment-ktx artifact
//            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
//        }

        //ex.4
        binding.btn.setOnClickListener {
            val result = true
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("boolKey" to result))
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun newInstance(someInt: Int, someString: String?): FirstFragment {
        return FirstFragment().apply {
            arguments = Bundle().apply {
                putInt("someInt", someInt)
                putString("SomeString", someString)
            }
        }
    }
}