package com.example.testcollection.epoxy

import com.airbnb.epoxy.EpoxyController

class MainEpoxyController(private val listener: LicenseClickListener<LicenseInfo>) :
    EpoxyController() {
    companion object{
        private val TAG = MainEpoxyController::class.java.simpleName
    }

    private val licenseList = mutableListOf<LicenseInfo>()

    fun setData(list: List<LicenseInfo>){
        licenseList.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {
        licenseList.forEach {
            license {
                id(it.id)
                licenseInfo(it)
                licenseClickListener(this@MainEpoxyController.listener)
            }
        }
    }
}
