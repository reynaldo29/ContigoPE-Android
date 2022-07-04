package gaur.himanshu.august.contigope

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    fun getRetrofitClient(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl("https://sprintbootapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getRetrofitVentas(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl("https://sprintbootapirest" +
                ".herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }



}