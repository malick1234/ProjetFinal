package ca.qc.cgodin.mini_projet3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://succursales.onrender.com"

class RetrofitInstance {
    companion object{
        private val retrofitInstance by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val retrofitService: GazouilliApiService by lazy {
            retrofitInstance.create(GazouilliApiService::class.java)
        }
    }

}