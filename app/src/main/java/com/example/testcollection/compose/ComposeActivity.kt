package com.example.testcollection.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testcollection.compose.ui.theme.TestCollectionTheme
import com.example.testcollection.compose.ui.view.LicenseCardView
import com.example.testcollection.epoxy.LicenseData
import com.example.testcollection.epoxy.getLicenseData
import com.example.testcollection.getStringToClass
import com.google.gson.Gson

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestCollectionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    getList()
                }
            }
        }
    }

    @Composable
    private fun getList() {
        val str = Gson().toJson(getLicenseData())
        val license = getStringToClass(str, LicenseData::class.java)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            itemsIndexed(license.data) { _, item ->
                LicenseCardView(data = item)
            }
        }
    }
}

