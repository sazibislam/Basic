package com.btrac.basic.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel internal constructor(
  @SerialName("title") var title: String = "",
  @SerialName("description") var description: String = "",
  @SerialName("image") var image: String = ""
)