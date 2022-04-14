package com.example.testcollection.epoxy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcollection.databinding.FragmentEpoxyBinding
import com.example.testcollection.getStringToClass
import com.google.gson.Gson

class EpoxyFragment: Fragment() {
    companion object{
        private val TAG = EpoxyFragment::class.java.simpleName
    }

    private var binding : FragmentEpoxyBinding? = null
    private val controller: MainEpoxyController by lazy { MainEpoxyController(
        object : LicenseClickListener<LicenseInfo>{
            override fun onLibraryNameClick(data: LicenseInfo) {
                TODO("Not yet implemented")
            }

            override fun onLibraryUrlClick(data: LicenseInfo) {
                TODO("Not yet implemented")
            }

            override fun onLicenseNameClick(data: LicenseInfo) {
                TODO("Not yet implemented")
            }

            override fun onLicenseDescClick(data: LicenseInfo) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEpoxyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val str = Gson().toJson(getLicenseData())
        val license = getStringToClass(str, LicenseData::class.java)

        with(binding){
            if (binding == null) {
                return@with
            }
            this?.rvList?.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = controller.adapter
                addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
            }
            controller.setData(license.data)
        }
    }

}