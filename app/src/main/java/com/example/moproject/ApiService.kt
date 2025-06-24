package com.example.moproject

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("api/user/sign-up")
    fun signUp(
        @Field("loginId") loginId: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("age") age: Int,
        @Field("phoneNumber") phoneNumber: String,
        @Field("type") type: String,
        @Field("region") region: String
    ): Call<SignUpResponse>

    @FormUrlEncoded
    @POST("api/user/sign-in")
    fun login(
        @Field("loginId") loginId: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("api/user/info")
    fun getUserInfo(
        @Header("Authorization") token: String
    ): Call<UserInfoResponse>
}