package com.btrac.basic.domain.repository

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.remote.response.DummyResponse2
import com.btrac.basic.data.remote.response.DummyUserResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
  suspend fun getHomeData(): Flow<ResponseResource<DummyResponse2>>
  suspend fun getUserListData(): Flow<ResponseResource<ArrayList<DummyUserResponse>>>
}