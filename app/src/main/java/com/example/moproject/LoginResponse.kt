package com.example.moproject

data class LoginResponse(
    val result: String,
    val code: Int,
    val userName: String,
    val token: String
)