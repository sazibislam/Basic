package com.btrac.basic.data.remote.source

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.remote.response.DummyResponse2
import com.btrac.basic.data.remote.response.DummyUserResponse

interface HomeRemote {
  suspend fun getHomeList(): ResponseResource<DummyResponse2>
  suspend fun getUserList(): ResponseResource<ArrayList<DummyUserResponse>>
}