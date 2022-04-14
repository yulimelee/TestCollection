package com.example.testcollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testcollection.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    companion object{
        private val TAG = MainFragment::class.java.simpleName
    }

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView(){
        with(binding){
            if (this == null){
                return@with
            }
            this.btnEpoxy.setOnClickListener {
                findNavController().navigate(R.id.mainFragment_to_epoxyFragment)
            }
        }
    }
}