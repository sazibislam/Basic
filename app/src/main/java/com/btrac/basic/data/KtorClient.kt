package com.btrac.basic.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val TIME_OUT = 60_000L

val ktorHttpClient = HttpClient(CIO) {

  install(WebSockets)

  install(ContentNegotiation) {
    json(Json {
      prettyPrint = true
      isLenient = true
      ignoreUnknownKeys = true
    })
  }

  engine {
    requestTimeout = TIME_OUT
  }

  install(Logging) {
    logger = object : Logger {
      override fun log(message: String) {
        Log.v("Logger Ktor ->", message)
      }
    }
    level = LogLevel.ALL
  }

  install(ResponseObserver) {
    onResponse { response ->
      Log.d("Http status:", "${response.status.value}")
    }
  }

  install(DefaultRequest) {
    header(HttpHeaders.ContentType, ContentType.Application.Json)
  }
}