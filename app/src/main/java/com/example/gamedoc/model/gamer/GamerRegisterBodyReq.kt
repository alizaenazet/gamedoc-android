package com.example.gamedoc.model.gamer

data class GamerRegisterBodyReq(
    val dob: String,
    val email: String,
    val password: String,
    val phone_number: String,
    val username: String
)