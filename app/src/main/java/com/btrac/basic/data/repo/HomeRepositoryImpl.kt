package com.btrac.basic.data.repo

import com.btrac.basic.data.ResponseResource
import com.btrac.basic.data.pref.Prefs
import com.btrac.basic.data.response.DummyResponse
import com.btrac.basic.data.source.HomeRemote
import com.btrac.basic.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
  private val remote: HomeRemote,
  private val sessionPrefs: Prefs
) : HomeRepository {

  override suspend fun getHomeData(): Flow<ResponseResource<DummyResponse>> =
    flow {
      val responseResource =
        when (val response = remote.getHomeList()) {
          is ResponseResource.Error -> ResponseResource.error(response.errorMessage)
          is ResponseResource.Success -> ResponseResource.success(response.data)
        }
      emit(responseResource)
    }
}