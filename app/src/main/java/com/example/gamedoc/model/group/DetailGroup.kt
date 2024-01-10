package com.example.gamedoc.model.group

data class DetailGroup(
    val description: String,
    val doctors: List<DoctorDetailGroup>,
    val id: String,
    val image_url: String,
    val isOwned: Boolean,
    val name: String,
    val price: String,
    val social_media: List<SocialMedia>
)