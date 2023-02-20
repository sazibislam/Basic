package com.btrac.basic.data.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestModel internal constructor(
  @SerialName("title") internal var title: String,
  @SerialName("description") internal var description: String,
  @SerialName("image") internal var image: String
)