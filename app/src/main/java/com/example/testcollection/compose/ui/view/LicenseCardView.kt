package com.example.testcollection.compose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcollection.R
import com.example.testcollection.compose.ui.theme.TestCollectionTheme
import com.example.testcollection.epoxy.LicenseData
import com.example.testcollection.epoxy.LicenseInfo
import com.example.testcollection.epoxy.getLicenseData
import com.example.testcollection.getStringToClass
import com.google.gson.Gson


@Composable
fun LicenseCardView(data: LicenseInfo) {
    Surface(Modifier.background(Color.White)) {
        Column {
            titleText(data.libraryName)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                licenceText(data.licenseName)
            }
            libraryUrlText(data.libraryUrl)
            Box(modifier = Modifier.padding(0.dp, 15.dp, 15.dp, 0.dp)) {
                licenseDesc(data.licenseDesc)
            }
        }
    }
}

@Composable
private fun titleText(text: String) {
    Text(
        text = text,
        fontSize = 30.sp,
        color = Color.Black,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
private fun licenceText(text: String) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End,
        modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
    )
}

@Composable
private fun libraryUrlText(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
        color = Color(R.color.purple_200)
    )
}

@Composable
private fun licenseDesc(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val str = Gson().toJson(getLicenseData())
    val license = getStringToClass(str, LicenseData::class.java)

    TestCollectionTheme {
        LicenseCardView(license.data[0])
    }
}