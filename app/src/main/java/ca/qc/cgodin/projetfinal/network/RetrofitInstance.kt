package ca.qc.cgodin.mini_projet3.network

import ca.qc.cgodin.projetfinal.network.GazouilliApiService
import ca.qc.cgodin.projetfinal.network.Header
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://10.0.2.15:5000/api"

class RetrofitInstance {

    companion object{
        private val client = OkHttpClient.Builder().apply {
            addInterceptor(Header())
        }.build()
        private val retrofitInstance by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val retrofitService: GazouilliApiService by lazy {
            retrofitInstance.create(GazouilliApiService::class.java)
        }
    }

}