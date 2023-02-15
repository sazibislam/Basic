package com.btrac.basic.data.source

import android.util.Log
import com.btrac.basic.data.ApiRoutes.ENDPOINT_PRODUCTS
import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.response.DummyResponse2
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HomeRemoteImpl(private val client: HttpClient) : HomeRemote {

  override suspend fun getHomeList(): ResponseResource<DummyResponse2> {

    return try {
      val response = client.get(ENDPOINT_PRODUCTS) {
        // header("Authorization", "Bearer $token")
      }.body<DummyResponse2>()

      ResponseResource.success(response)
      // when (response.size) {
      //   null -> ResponseResource.error(response)
      //   else -> ResponseResource.success(response)
      // }
    } catch (e: Exception) {
      Log.d("HomeRemoteImpl", "${e.message}")
      ResponseResource.error(DummyResponse2())
    }
  }
}