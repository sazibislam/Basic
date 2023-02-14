package com.btrac.basic.data.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DummyResponse : ArrayList<DummyResponseItem>()

@Serializable
data class DummyResponseItem(
  @SerialName("category") var category: String? = null,
  @SerialName("description") var description: String? = null,
  @SerialName("id") var id: Int? = null,
  @SerialName("image") var image: String? = null,
  @SerialName("price") var price: Double? = null,
  @SerialName("rating") var rating: Rating? = null,
  @SerialName("title") var title: String? = null
)

@Serializable
data class Rating(
  @SerialName("count") var count: Int? = null,
  @SerialName("rate") var rate: Double? = null
)