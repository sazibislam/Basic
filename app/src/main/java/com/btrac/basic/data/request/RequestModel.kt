package com.btrac.basic.data.request

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class RequestModel internal constructor(
  internal var title: String,
  internal var description: String,
  internal var image: String
)
/*
@Serializable
data class RequestModel internal constructor(
  @Expose @SerializedName("title") internal var title: String,
  @Expose @SerializedName("description") internal var description: String,
  @Expose @SerializedName("image") internal var image: String
)*/