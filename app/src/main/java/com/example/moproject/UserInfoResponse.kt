package com.example.moproject

data class UserInfoResponse(
    val result: String,
    val code: Int,
    val user: User
)

data class User(
    val id: Int,
    val loginId: String,
    val name: String,
    val age: Int,
    val phoneNumber: String,
    val type: String,
    val region: String
)