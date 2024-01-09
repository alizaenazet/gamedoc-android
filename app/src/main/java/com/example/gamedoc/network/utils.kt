package com.example.gamedoc.network

import com.example.gamedoc.BuildConfig
import retrofit2.Retrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
class AuthInterceptor(private val bearerToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $bearerToken")
            .build()
        return chain.proceed(request)
    }
}
class RetrofitInstance {
    companion object {
        var _userToken = ""
        val setUserToken: (String) -> Unit = { _userToken = it}
        val userToken
            get() = _userToken

        val instance: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
        fun instanceHeaderable(): Retrofit{
            val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(_userToken))
            .build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .build()
        }

    }

    }