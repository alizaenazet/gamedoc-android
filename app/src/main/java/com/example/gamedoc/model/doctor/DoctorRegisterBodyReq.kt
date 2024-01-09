package com.example.gamedoc.model.doctor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DoctorRegisterBodyReq(
    val degree: String,
    val dob: String,
    val email: String,
    val password: String,
    val phone_number: String,
    val profession: String,
    val services: List<String>,
    val username: String
)