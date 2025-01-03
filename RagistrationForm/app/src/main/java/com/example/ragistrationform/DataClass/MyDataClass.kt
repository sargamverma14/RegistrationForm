package com.example.ragistrationform.DataClass

import java.io.Serializable

data class MyDataClass(
    val name:String,
    val contact:String,
    val dob:String,
    val address:String,
    val email:String,
    val aadhar :String,
    val pan:String,
    val gender:String,
    val courses:String,
    val image :String


):Serializable
