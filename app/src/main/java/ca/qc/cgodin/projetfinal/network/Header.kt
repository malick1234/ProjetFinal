package ca.qc.cgodin.projetfinal.network

import okhttp3.Interceptor
import okhttp3.Response

class Header: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("application/json", "application/json")
            .build()
        return chain.proceed(request)
    }
}