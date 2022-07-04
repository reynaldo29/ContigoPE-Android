package gaur.himanshu.august.contigope

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/products")
    fun getQuotes(): Call<List<DataModel>>

    @GET("api/ventas")
    fun getVentas(): Call<List<DataVenta>>

    @GET("api/ventas/cliente2")
    fun getTotal(): Call<List<DataTotal>>


}