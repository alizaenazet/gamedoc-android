package com.example.gamedoc.model.user

data class LoginBodyRes(
    val id: String,
    val role: String,
    val token: String
)