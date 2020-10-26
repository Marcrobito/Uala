package com.jamadev.mealfinder.network

import android.util.Log
import com.jamadev.mealfinder.base.NetworkEnvironment
import com.jamadev.mealfinder.base.environment
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "NetworkModule"
@Module
class NetworkModule {

    private val baseUrl = when(environment){
        NetworkEnvironment.Production -> "https://www.themealdb.com/api/json/v1/1/"
        NetworkEnvironment.QA -> "https://www.themealdb.com/api/json/v1/1/"
        NetworkEnvironment.Staging -> "https://www.themealdb.com/api/json/v1/1/"
    }

    @Provides
    fun providesClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).addInterceptor{
            try{
                it.proceed(
                    it.request().newBuilder().build()
                )
            }catch (e: Exception) {
                Log.e(TAG, e.toString())
                val offlineRequest = it.request().newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
                it.proceed(offlineRequest)
            }
        }.build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun providesRecipesApi():RecipesApi = provideRetrofit(providesClient()).create(RecipesApi::class.java)

}