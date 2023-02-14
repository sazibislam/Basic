package com.btrac.basic.data.source

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.response.DummyResponse

interface HomeRemote {
  suspend fun getHomeList(): ResponseResource<DummyResponse>
}