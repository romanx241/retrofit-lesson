package ru.netology.retrofitlesson.retrofit

import retrofit2.Response
import retrofit2.http.*

interface MainApi {
    @GET("auth/products/{id}")
    suspend fun getProductsById(@Path("id") id: Int): Product

    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): Response<User>

    @Headers("Content-Type: application/json")
    @GET("auth/products")
    suspend fun getAllProducts(@Header("Authorization") token : String): Products

    @Headers("Content-Type: application/json")
    @GET("auth/products/search")
    suspend fun getProductsByNameAuth(@Header("Authorization") token : String,
                                  @Query("q") name : String): Products

    @GET("auth/products/search")
    suspend fun getProductsByName(@Query("q") name : String): Products
}
