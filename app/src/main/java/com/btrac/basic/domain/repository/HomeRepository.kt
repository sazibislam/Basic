package com.btrac.basic.domain.repository

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.response.DummyResponse2
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
  suspend fun getHomeData(): Flow<ResponseResource<DummyResponse2>>
}