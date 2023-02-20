package com.btrac.basic.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyUserResponse internal constructor(
  @SerialName("avatar") var avatar: String? = null,
  @SerialName("createdAt") var createdAt: String? = null,
  @SerialName("id") var id: String? = null,
  @SerialName("name") var name: String? = null
)