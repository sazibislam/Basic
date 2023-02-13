package com.btrac.basic.data.response

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

/*@Serializable
data class ResponseModel internal constructor(
  @SerializedName("title") var title: String = "",
  @SerializedName("description") var description: String = "",
  @SerializedName("image") var image: String = ""
)*/


@Keep
@Serializable
data class ResponseModel internal constructor(
  var title: String = "",
  var description: String = "",
  var image: String = ""
)