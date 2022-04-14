package com.example.testcollection.epoxy

interface LicenseClickListener<T: Any> {
    fun onLibraryNameClick(data: T)
    fun onLibraryUrlClick(data: T)
    fun onLicenseNameClick(data: T)
    fun onLicenseDescClick(data: T)
}