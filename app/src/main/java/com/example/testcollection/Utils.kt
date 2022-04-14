package com.example.testcollection

import com.google.gson.Gson

fun<T: Any> getStringToClass(str: String, `class`: Class<T>): T{
    val result = Gson().fromJson<T>(str, `class`)
    return result
}