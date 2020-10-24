package com.jamadev.mealfinder.network


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jamadev.mealfinder.base.NetworkEnvironment
import com.jamadev.mealfinder.base.environment
import dagger.Module
import dagger.Provides
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

@Module
class NetworkModule() {

    private val baseUrl = when(environment){
        NetworkEnvironment.Production ->  "https://www.themealdb.com/api/json/v1/1/"
        NetworkEnvironment.QA ->  "https://www.themealdb.com/api/json/v1/1/"
        NetworkEnvironment.Staging ->  "https://www.themealdb.com/api/json/v1/1/"
    }


    @Provides
    fun providesClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .addInterceptor {
                try {
                    it.proceed(
                        it.request().newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build()
                    )
                } catch (e: Exception) {
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
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    @Provides
    fun providesRecipesApi():RecipesApi = provideRetrofit(providesClient()).create(RecipesApi::class.java)

}