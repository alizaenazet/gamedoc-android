package com.example.gamedoc.model.doctor

data class DoctorListItem(
    val id: String,
    val image_url: String,
    val name: String,
    val profession: String,
    val services: List<String>
)