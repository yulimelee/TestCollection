package com.example.testcollection.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.testcollection.R
import com.example.testcollection.databinding.ItemLicenseBinding

@EpoxyModelClass(layout = R.layout.item_license)
abstract class LicenseModel : EpoxyModelWithHolder<LicenseModel.LicenseHolder>(){

    @EpoxyAttribute
    lateinit var licenseClickListener: LicenseClickListener<LicenseInfo>

    @EpoxyAttribute
    lateinit var licenseInfo: LicenseInfo

    override fun bind(holder: LicenseHolder) {
        with(holder.binding){
            tvLibraryName.apply {
                text = licenseInfo.libraryName
                setOnClickListener { licenseClickListener.onLibraryNameClick(licenseInfo) }
            }
            tvLibraryUrl.apply {
                text = licenseInfo.libraryUrl
                setOnClickListener { licenseClickListener.onLibraryUrlClick(licenseInfo) }
            }
            tvLicenseName.apply {
                text = licenseInfo.licenseName
                setOnClickListener { licenseClickListener.onLicenseNameClick(licenseInfo) }
            }
            tvLicenseDesc.apply {
                text = licenseInfo.licenseDesc
                setOnClickListener { licenseClickListener.onLicenseDescClick(licenseInfo) }
            }
        }
    }


    inner class LicenseHolder : EpoxyHolder(){
        lateinit var binding: ItemLicenseBinding

        override fun bindView(itemView: View) {
            binding = ItemLicenseBinding.bind(itemView)
        }
    }
}