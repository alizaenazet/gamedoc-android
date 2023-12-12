package com.example.gamedoc.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val id: String,
    val dob: String,
    val email: String,
    @SerialName("image_url")
    val imageUrl: String,
    val name: String,
    @SerialName("phone_number")
    val phone_number: String
)